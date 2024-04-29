package com.wsd.ecom.core;

import com.wsd.ecom.service.CartItemItemService;
import com.wsd.ecom.service.CartService;
import com.wsd.ecom.service.ItemService;
import com.wsd.ecom.service.UserService;
import com.wsd.ecom.types.AbstractInput;
import com.wsd.ecom.types.AbstractOutput;
import com.wsd.ecom.types.AddToCartOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("prototype")
@RequiredArgsConstructor
public class AddToCartHelper extends AbstractHelper {
    private final UserService userService;
    private final ItemService itemService;
    private final CartService cartService;
    private final CartItemItemService cartItemItemService;

    @Override
    protected void validateInput(AbstractInput input, Object... args) {
        //TODO: throw exception for invalid input
    }

    @Override
    protected void checkPermission(AbstractInput input, Object... args) {
        //TODO: throw exception if permission not granted
    }

    @Override
    protected AbstractOutput executeHelper(AbstractInput input, Object... args) {
        AddToCartOutput output = new AddToCartOutput();
        return output;
    }
}
