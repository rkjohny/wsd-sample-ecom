package com.wsd.ecom.service;

import com.wsd.ecom.dto.CartItemDto;
import com.wsd.ecom.entity.CartItem;
import org.springframework.stereotype.Service;


@Service
public interface CartItemService extends IService<CartItem, CartItemDto> {

}
