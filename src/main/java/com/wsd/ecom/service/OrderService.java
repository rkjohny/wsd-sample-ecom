package com.wsd.ecom.service;

import com.wsd.ecom.dto.OrderDto;
import com.wsd.ecom.entity.Order;
import org.springframework.stereotype.Service;

@Service
public interface OrderService extends IService<Order, OrderDto> {

}
