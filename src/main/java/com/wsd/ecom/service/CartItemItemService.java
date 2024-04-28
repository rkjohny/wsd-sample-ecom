package com.wsd.ecom.service;


import com.wsd.ecom.repository.CartItemRepository;
import com.wsd.ecom.mapper.CartItemMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CartItemItemService {
    private final CartItemRepository repository;
    private final CartItemMapper mapper;
}
