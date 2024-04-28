package com.wsd.ecom.service;

import com.wsd.ecom.dto.CartDto;
import com.wsd.ecom.entity.Cart;
import org.springframework.stereotype.Service;


@Service
public interface CartService extends IService<Cart, CartDto> {

}
