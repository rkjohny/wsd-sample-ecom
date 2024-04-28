package com.wsd.ecom.service.impl;

import com.wsd.ecom.repository.CartRepository;
import com.wsd.ecom.service.CartService;
import com.wsd.ecom.service.mapper.CartMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class CartServiceImp implements CartService {
    private final CartRepository repository;
    private final CartMapper mapper;

    @Autowired
    public CartServiceImp(CartRepository repository, CartMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
