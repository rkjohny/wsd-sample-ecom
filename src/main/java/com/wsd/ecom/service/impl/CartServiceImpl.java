package com.wsd.ecom.service.impl;

import com.wsd.ecom.dto.CartDto;
import com.wsd.ecom.entity.Cart;
import com.wsd.ecom.mapper.CartMapper;
import com.wsd.ecom.repository.CartRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class CartServiceImpl extends AbstractServiceImpl<Cart, CartDto, CartRepository, CartMapper> {
    private final CartRepository repository;
    private final CartMapper mapper;

    @Autowired
    public CartServiceImpl(CartRepository repository, CartMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
