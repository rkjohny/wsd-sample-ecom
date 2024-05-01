package com.wsd.ecom.core;

import com.wsd.ecom.entity.*;
import com.wsd.ecom.exception.ObjectNotFoundException;
import com.wsd.ecom.repository.CartRepository;
import com.wsd.ecom.repository.OrderRepository;
import com.wsd.ecom.repository.UserRepository;
import com.wsd.ecom.dto.types.PurchaseInput;
import com.wsd.ecom.dto.types.PurchaseOutput;
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
public class PurchaseHelper extends AbstractHelper <PurchaseInput, PurchaseOutput> {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Override
    protected void validateInput(PurchaseInput input, Object... args) {
        InputValidationUtils.validateId(input.getUserId());
    }

    @Override
    protected void checkPermission(PurchaseInput input, Object... args) {

    }

    @Override
    protected PurchaseOutput executeHelper(PurchaseInput input, Object... args) {
        PurchaseOutput output = new PurchaseOutput();
        Optional<Cart> cartOptional = cartRepository.findOneByUserAndStatus(input.getUserId(), Status.P);
        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            Optional<User> userOptional = userRepository.findById(input.getUserId());
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                Order order = new Order();
                order.setCustomer(user);
                for (CartItem cartItem : cart.getCartItems()) {
                    Sale sale = new Sale();
                    sale.setCustomer(user);
                    sale.setItem(cartItem.getItem());
                    sale.setOrder(order);
                    sale.setAmount(cartItem.getAmount());
                    sale.setQuantity(cartItem.getQuantity());
                    order.getSales().add(sale);
                }
                if (!order.getSales().isEmpty()) {
                    orderRepository.saveAndFlush(order);
                }
                cart.setStatus(Status.D);
                cartRepository.saveAndFlush(cart);
            } //else throw new ObjectNotFoundException(input.getUserId());
        } //else throw new ObjectNotFoundException(input.getUserId());
        return output;
    }
}
