package com.wsd.ecom.controller.rest;

import com.wsd.ecom.core.CartApi;
import com.wsd.ecom.dto.types.AddToCartInput;
import com.wsd.ecom.dto.types.AddToCartOutput;
import com.wsd.ecom.dto.types.ViewCartOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Add items to a user's cart")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All items are added to the specified user's cart",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AddToCartOutput.class)) }),
            @ApiResponse(responseCode = "404", description = "Invalid input supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content) })
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
    @Operation(summary = "Get the user's cart items")
    @GetMapping("/view-cart/{id}")
    @ResponseBody
    public ResponseEntity<ViewCartOutput> viewCart(@Parameter(description = "id of the user whose cart will be returned") @NotNull @PathVariable("id") Long id) {
        ViewCartOutput output = cartApi.viewCart(id);
        return ResponseEntity.ok(output);
    }
}
