package com.wsd.ecom.service;


import com.wsd.ecom.mapper.CartItemMapper;
import com.wsd.ecom.repository.CartItemRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class CartItemItemService {
    private final CartItemRepository repository;
    private final CartItemMapper mapper;

    @Autowired
    public CartItemItemService(CartItemRepository repository, CartItemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
