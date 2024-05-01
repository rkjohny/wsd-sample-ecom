package com.wsd.ecom.core;

import com.wsd.ecom.dto.types.ItemInViewCart;
import com.wsd.ecom.dto.types.ViewCartInput;
import com.wsd.ecom.dto.types.ViewCartOutput;
import com.wsd.ecom.entity.Cart;
import com.wsd.ecom.entity.CartItem;
import com.wsd.ecom.entity.Status;
import com.wsd.ecom.repository.CartRepository;
import com.wsd.ecom.utils.InputValidationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@Scope("prototype")
@RequiredArgsConstructor
public class ViewCartHelper extends AbstractHelper <ViewCartInput, ViewCartOutput>{
    private final CartRepository cartRepository;

    @Override
    protected void validateInput(ViewCartInput input, Object... args) {
        InputValidationUtils.validateId(input.getUserId());
    }

    @Override
    protected void checkPermission(ViewCartInput input, Object... args) {

    }

    @Override
    protected ViewCartOutput executeHelper(ViewCartInput input, Object... args) {
        ViewCartOutput output = new ViewCartOutput();

        Optional<Cart> cartOptional = cartRepository.findOneByUserAndStatus(input.getUserId(), Status.P);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            Double totalAmount = 0D;
            for (CartItem cartItem : cart.getCartItems()) {
                ItemInViewCart item = new ItemInViewCart();
                item.setItemId(cartItem.getItem().getId());
                item.setName(cartItem.getItem().getName());
                item.setUnitPrice(cartItem.getItem().getUnitPrice());
                item.setQuantity(cartItem.getQuantity());
                item.setAmount(cartItem.getAmount());

                totalAmount += item.getAmount();
                output.getItems().add(item);
            }
            output.setTotalAmount(totalAmount);
        }
        return output;
    }
}
