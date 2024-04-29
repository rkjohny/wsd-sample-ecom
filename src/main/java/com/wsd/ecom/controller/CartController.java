package com.wsd.ecom.controller;

import com.wsd.ecom.core.CartApi;
import com.wsd.ecom.types.AddToCartInput;
import com.wsd.ecom.types.AddToCartOutput;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carts")
public class CartController {

    private final CartApi cartApi;

    @PostMapping(value = "/add-to-cart", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<AddToCartOutput> createOrder(@Valid @RequestBody AddToCartInput input) {
        AddToCartOutput output = cartApi.addToCart(input);
        return ResponseEntity.ok(output);
    }
}
