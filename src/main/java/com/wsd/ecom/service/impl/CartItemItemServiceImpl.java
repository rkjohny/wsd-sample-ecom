package com.wsd.ecom.service.impl;

import com.wsd.ecom.dto.CartItemDto;
import com.wsd.ecom.entity.CartItem;
import com.wsd.ecom.mapper.CartItemMapper;
import com.wsd.ecom.repository.CartItemRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class CartItemItemServiceImpl extends AbstractServiceImpl<CartItem, CartItemDto, CartItemRepository, CartItemMapper> {
    private final CartItemRepository repository;
    private final CartItemMapper mapper;

    @Autowired
    public CartItemItemServiceImpl(CartItemRepository repository, CartItemMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
