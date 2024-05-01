package com.wsd.ecom.controller;


import com.wsd.ecom.entity.Item;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerTest {
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
        endPoint = BASE_URL + ":" + PORT + "/items";
    }

    @Test
    void createItem() {
        Item item = new Item().name("TestItem1").unitPrice(10D).unit("KG").description("test item1 description").currency("USD");
        Item itemCreated = restTemplate.postForObject(endPoint, item, Item.class);
        assertEquals(item.getName(), itemCreated.getName());
        assertEquals(item.getUnit(), itemCreated.getUnit());
        assertEquals(item.getUnitPrice(), itemCreated.getUnitPrice());
        assertEquals(item.getDescription(), itemCreated.getDescription());
    }

    @Test
    @Sql(statements = "INSERT INTO t_item (id, name, unit_price, unit, currency, description, created_date, last_modified_date, status) VALUES (2,'test_item', 10.5, 'piece', 'USD', 'test item', '2024-05-01 05:13:48.337998+06', '2024-05-01 05:13:48.337998+06', 'V')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void getItem() {
        Item item = restTemplate.getForObject(endPoint + "/2", Item.class);
        assertEquals("test_item", item.getName());
        assertEquals(10.5D, item.getUnitPrice());
    }
}