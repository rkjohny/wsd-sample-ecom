package com.wsd.ecom.controller.rest;

import com.wsd.ecom.core.CartApi;
import com.wsd.ecom.dto.types.AddToCartInput;
import com.wsd.ecom.dto.types.AddToCartOutput;
import com.wsd.ecom.dto.types.ViewCartOutput;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carts")
public class CartController {

    private final CartApi cartApi;

    /**
     * {@code POST  /api/v1/carts/add-to-cart}
     * Add items to a user's cart
     * @param input {
     *   "userId": id of the user in which cart items will be added
     *   "items":  list of items to add into cart
     *   [
     *     {
     *       "itemId": item's id to add into cart
     *       "quantity": quantity of the item
     *     }
     *   ]
     * }
     * @return {@link AddToCartOutput} object with status code 200 (OK) or 404 (NOT_FOUND) will be returned
     */
    @PostMapping(value = "/add-to-cart", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<AddToCartOutput> addToCart(@Valid @RequestBody AddToCartInput input) {
        AddToCartOutput output = cartApi.addToCart(input);
        return ResponseEntity.ok(output);
    }

    /**
     * {@code GET  /api/v1/carts/view-cart/:id} : get the user's cart items.
     *
     * @param id the id of the user to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the {@link ViewCartOutput} or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/view-cart/{id}")
    @ResponseBody
    public ResponseEntity<ViewCartOutput> viewCart(@NotNull @PathVariable("id") Long id) {
        ViewCartOutput output = cartApi.viewCart(id);
        return ResponseEntity.ok(output);
    }
}
