package com.wsd.ecom.service.impl;

import com.wsd.ecom.dto.UserDto;
import com.wsd.ecom.entity.User;
import com.wsd.ecom.mapper.UserMapper;
import com.wsd.ecom.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class UserServiceImpl extends AbstractServiceImpl<User, UserDto, UserRepository, UserMapper> {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
