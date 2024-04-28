package com.wsd.ecom.service;

import com.wsd.ecom.mapper.CartMapper;
import com.wsd.ecom.repository.CartRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class CartService {
    private final CartRepository repository;
    private final CartMapper mapper;

    @Autowired
    public CartService(CartRepository repository, CartMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
