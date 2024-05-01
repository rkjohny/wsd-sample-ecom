package com.wsd.ecom.core;

import com.wsd.ecom.dto.types.AddToCartInput;
import com.wsd.ecom.dto.types.AddToCartOutput;
import com.wsd.ecom.dto.types.ViewCartInput;
import com.wsd.ecom.dto.types.ViewCartOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartApi {
    private final ObjectProvider<AddToCartHelper> addToCartHelperProvider;
    private final ObjectProvider<ViewCartHelper> viewCartHelperProvider;

    public AddToCartOutput addToCart(AddToCartInput input) {
        AddToCartHelper helper = addToCartHelperProvider.getObject();
        return helper.executeHelper(input);
    }

    public ViewCartOutput viewCart(Long userId) {
        ViewCartInput input = new ViewCartInput();
        input.setUserId(userId);
        ViewCartHelper helper = viewCartHelperProvider.getObject();
        return helper.executeHelper(input);
    }
}
