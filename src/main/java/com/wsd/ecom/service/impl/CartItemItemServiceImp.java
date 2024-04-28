package com.wsd.ecom.service.impl;


import com.wsd.ecom.service.CartItemService;
import com.wsd.ecom.service.mapper.CartItemMapper;
import com.wsd.ecom.repository.CartItemRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class CartItemItemServiceImp implements CartItemService {
    private final CartItemRepository repository;
    private final CartItemMapper mapper;

    @Autowired
    public CartItemItemServiceImp(CartItemRepository repository, CartItemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
