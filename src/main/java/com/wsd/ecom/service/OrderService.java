package com.wsd.ecom.service;

import com.wsd.ecom.mapper.OrderMapper;
import com.wsd.ecom.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;

    @Autowired
    public OrderService(OrderRepository repository, OrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
