package com.wsd.ecom.service;

import com.wsd.ecom.entity.Cart;
import com.wsd.ecom.repository.CartRepository;
import com.wsd.ecom.entity.mapper.CartMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CartService {
    private final CartRepository repository;
    private final CartMapper mapper;

    public Cart save(Cart cart) {
        return repository.saveAndFlush(cart);
    }
}
