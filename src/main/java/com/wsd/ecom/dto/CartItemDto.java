package com.wsd.ecom.dto;

import com.wsd.ecom.entity.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
    private Long id;
    private Long quantity;
    private Double amount;
    private UserDto customer;
    private CartDto cart;

    public CartItemDto(CartItem cartItem) {
        this.id = cartItem.getId();
        this.quantity = cartItem.getQuantity();
        this.amount = cartItem.getAmount();
        this.customer = new UserDto(cartItem.getCustomer());
        this.cart = new CartDto(cartItem.getCart());
    }
}
