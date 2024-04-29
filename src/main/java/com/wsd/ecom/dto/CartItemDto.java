package com.wsd.ecom.dto;

import com.wsd.ecom.entity.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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
