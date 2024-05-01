package com.wsd.ecom.entity.dto;

import com.wsd.ecom.entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private UserDto customer;
    private List<CartItemDto> cartItems;

    public CartDto(Cart cart) {
        this.id = cart.getId();
        this.customer = new UserDto(cart.getCustomer());
        this.cartItems = cart.getCartItems().stream().map(CartItemDto::new).collect(Collectors.toList());
    }
}
