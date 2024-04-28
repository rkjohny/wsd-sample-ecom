package com.wsd.ecom.service.impl;

import com.wsd.ecom.dto.OrderDto;
import com.wsd.ecom.entity.Order;
import com.wsd.ecom.mapper.OrderMapper;
import com.wsd.ecom.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class OrderServiceImpl extends AbstractServiceImpl<Order, OrderDto, OrderRepository, OrderMapper> {
    private final OrderRepository repository;
    private final OrderMapper mapper;

    @Autowired
    public OrderServiceImpl(OrderRepository repository, OrderMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
