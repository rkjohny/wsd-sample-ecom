package com.wsd.ecom.controller.rest;

import com.wsd.ecom.core.OrderApi;
import com.wsd.ecom.dto.types.PurchaseInput;
import com.wsd.ecom.dto.types.PurchaseOutput;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderApi orderApi;

    /**
     * {@code POST  /api/v1/orders/place-order} :
     *
     * Place an order for a user. All items of the user's cart will be sold for the user.
     *
     * @param input {
     *              userId: id of the user
     * }
     * @return {@link PurchaseOutput} with status code 200 OK
     */
    @PostMapping(value = "/place-order", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PurchaseOutput> placeOrder(@Valid @RequestBody PurchaseInput input) {
        PurchaseOutput output = orderApi.placeOrder(input);
        return ResponseEntity.ok(output);
    }
}
