package com.wsd.ecom.core;

import com.wsd.ecom.types.AddToCartInput;
import com.wsd.ecom.types.AddToCartOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartApi {
    private final ObjectProvider<AddToCartHelper> addToCartHelperProvider;

    public AddToCartOutput addToCart(AddToCartInput input) {
        AddToCartHelper helper = addToCartHelperProvider.getObject();
        return (AddToCartOutput) helper.executeHelper(input);
    }
}
