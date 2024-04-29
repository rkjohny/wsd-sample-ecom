package com.wsd.ecom.service;

import com.wsd.ecom.entity.User;
import com.wsd.ecom.repository.UserRepository;
import com.wsd.ecom.mapper.UserMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public User save(User user) {
        return repository.saveAndFlush(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
