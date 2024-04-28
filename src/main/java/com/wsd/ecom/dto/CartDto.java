package com.wsd.ecom.dto;

import com.wsd.ecom.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private Long id;
    private Double amount;
    private UserDto customer;
    private List<CartItemDto> cartItems;

    public CartDto(Cart cart) {
        this.id = cart.getId();
        this.amount = cart.getAmount();
        this.customer = new UserDto(cart.getCustomer());
        this.cartItems = cart.getCartItems().stream().map(CartItemDto::new).collect(Collectors.toList());
    }
}
