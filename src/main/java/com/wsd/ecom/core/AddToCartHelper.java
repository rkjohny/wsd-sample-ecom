package com.wsd.ecom.core;

import com.wsd.ecom.dto.types.AddToCartInput;
import com.wsd.ecom.dto.types.AddToCartOutput;
import com.wsd.ecom.dto.types.ItemInCart;
import com.wsd.ecom.entity.*;
import com.wsd.ecom.exception.ObjectNotFoundException;
import com.wsd.ecom.repository.CartRepository;
import com.wsd.ecom.repository.ItemRepository;
import com.wsd.ecom.repository.UserRepository;
import com.wsd.ecom.service.CartItemItemService;
import com.wsd.ecom.service.CartService;
import com.wsd.ecom.service.ItemService;
import com.wsd.ecom.service.UserService;
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
public class AddToCartHelper extends AbstractHelper <AddToCartInput, AddToCartOutput> {
    private final UserService userService;
    private final ItemService itemService;
    private final CartService cartService;
    private final CartItemItemService cartItemItemService;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    @Override
    protected void validateInput(AddToCartInput input, Object... args) {
        //TODO: throw exception for invalid input
        InputValidationUtils.validateId(input.getUserId());
        InputValidationUtils.validateList(input.getItems());

        for(ItemInCart item : input.getItems()) {
            InputValidationUtils.validateId(item.getItemId());
            InputValidationUtils.validateQuantity(item.getQuantity());
        }
    }

    @Override
    protected void checkPermission(AddToCartInput input, Object... args) {
        //TODO: throw exception if permission not granted
    }

    @Override
    protected AddToCartOutput executeHelper(AddToCartInput input, Object... args) {
        AddToCartOutput output = new AddToCartOutput();

        Optional<User> userOptional = userRepository.findById(input.getUserId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Optional<Cart> cartOptional = cartRepository.findOneByUserAndStatus(userOptional.get().getId(), Status.P);
            Cart cart;
            if (cartOptional.isPresent()) {
                cart = cartOptional.get();
            } else {
                cart = new Cart();
                cart.setStatus(Status.P);
                cart.setCustomer(user);
            }
            for (ItemInCart itemInCart : input.getItems()) {
                Optional<Item> itemOptional = itemRepository.findById(itemInCart.getItemId());
                if (itemOptional.isPresent()) {
                    Item item = itemOptional.get();

                    Optional<CartItem> existingCartItem = cart
                            .getCartItems()
                            .stream()
                            .filter(cartItem -> cartItem.getItem().getId().equals(item.getId()))
                            .findAny();

                    if (existingCartItem.isPresent()) {
                        existingCartItem.get().setQuantity(existingCartItem.get().getQuantity() + itemInCart.getQuantity());
                        existingCartItem.get().setAmount(existingCartItem.get().getAmount() + (item.getUnitPrice() * itemInCart.getQuantity()));
                    } else {
                        CartItem cartItem = new CartItem();
                        cartItem.setCart(cart);
                        cartItem.setItem(item);
                        cartItem.setCustomer(user);
                        cartItem.setQuantity((long) itemInCart.getQuantity());
                        cartItem.setAmount(item.getUnitPrice() * itemInCart.getQuantity());
                        cart.getCartItems().add(cartItem);
                    }
                }
            }
            if (!cart.getCartItems().isEmpty()) {
                cartService.save(cart);
            }
        } else {
            //throw new ObjectNotFoundException(input.getUserId());
        }
        return output;
    }
}
