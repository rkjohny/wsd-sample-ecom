package com.wsd.ecom.repository;

import com.wsd.ecom.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;


    @BeforeEach
    public void initTest() {

    }

    @Test
    void saveTest() {
        User user = new User();
        user.firstName("David").lastName("Jonson").email("david@test.com").login("david").password("1234").activated(true);
        user.setId(1L);
        userRepository.save(user);
        boolean saved = userRepository.existsById(user.getId());
        assertEquals(true, saved);
        Optional<User> savedUser = userRepository.findById(user.getId());
        assertEquals(true, savedUser.isPresent());
        assertEquals(savedUser.get().getLogin(), user.getLogin());
    }
}