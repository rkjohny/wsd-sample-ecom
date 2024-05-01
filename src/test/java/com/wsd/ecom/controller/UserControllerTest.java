package com.wsd.ecom.controller;


import com.wsd.ecom.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
    private static RestTemplate restTemplate;

    private String BASE_URL = "http://localhost";

    @LocalServerPort
    private int PORT;
    private String endPoint;


    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }

    @BeforeEach
    public void initTest() {
        endPoint = BASE_URL + ":" + PORT + "/users";
    }

    @Test
    void createUser() {
        User user = new User();
        user.firstName("David1234").lastName("Jonson1234").email("david@test.com").login("david12345").password("1234567890").activated(true);
        User userCreated = restTemplate.postForObject(endPoint, user, User.class);
        assertEquals(user.getEmail(), userCreated.getEmail());
        assertEquals(user.getFirstName(), userCreated.getFirstName());
        assertEquals(user.getLastName(), userCreated.getLastName());
        assertEquals(user.getLogin(), userCreated.getLogin());
    }

    @Test
    @Sql(statements = "INSERT INTO t_user (id, first_name, last_name, email, login, password_hash, created_date, last_modified_date, status, activated) VALUES (300,'test_user_first_name', 'test_user_last_name', 'david1234@test.com', 'david12345678', '1234567890', '2024-05-01 05:13:48.337998+06', '2024-05-01 05:13:48.337998+06', 'V', true)", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void getUser() {
        User user = restTemplate.getForObject(endPoint + "/300", User.class);
        assertEquals("test_user_first_name", user.getFirstName());
        assertEquals("test_user_last_name", user.getLastName());
        assertEquals("david1234@test.com", user.getEmail());
    }
}