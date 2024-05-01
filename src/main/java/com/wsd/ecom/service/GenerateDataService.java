package com.wsd.ecom.service;

import com.wsd.ecom.entity.*;
import com.wsd.ecom.repository.*;
import com.wsd.ecom.utils.RandomUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class GenerateDataService {

    private final UserService userService;
    private final UserRepository userRepository;
    private final ItemService itemService;
    private final ItemRepository itemRepository;
    private final CartService cartService;
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;
    private final SaleRepository saleRepository;

    public void insertUser(int numberOfUser) {
        IntStream.range(0, numberOfUser).forEachOrdered(i -> {
            User user = new User();
            user.login(RandomUtils.generateUserLogin())
                    .email(RandomUtils.generateUserEmail())
                    .firstName("User_" + (i + 1) + "_first name")
                    .lastName("User_" + (i + 1) + "_last name")
                    .password(RandomUtils.generateUserPassword())
                    .activated(true);

            userService.save(user);
        });
    }

    public void insertItem(int numberOfItem) {
        IntStream.range(0, numberOfItem).forEachOrdered(i -> {
            Item item = new Item();
            item.name("Item_" + (i + 1))
                    .unitPrice((double) RandomUtils.random(10, 1000))
                    .unit("kg")
                    .currency("USD")
                    .description(RandomUtils.generateRandom(10));
            itemService.save(item);
        });
    }

    public void addToCart(int numberOfCart, int numberOfItemPerCart) {
        List<User> users = userRepository.findAll();
        List<Item> items = itemRepository.findAll();

        IntStream.range(0, numberOfCart).forEachOrdered(i -> {
            Cart cart = new Cart();
            User user = users.get(i);
            cart.setCustomer(user);
            cart.setStatus(Status.P);
            IntStream.range(0, numberOfItemPerCart).forEachOrdered(j -> {
                Item item = items.get(RandomUtils.random(0, (items.size() -1)));
                CartItem cartItem = new CartItem();
                cartItem.setCart(cart);
                cartItem.setItem(item);
                cartItem.setCustomer(user);
                cartItem.setQuantity((long)RandomUtils.random(1,10));
                cartItem.setAmount(cartItem.getQuantity() * item.getUnitPrice());
                cart.getCartItems().add(cartItem);
            });
            cartService.save(cart);
        });
    }

    public void purchaseAllPendingCarts() {
        List<Cart> carts = cartRepository.getAllByStatus(Status.P);
        int count = 0;
        for (Cart cart : carts) {
            User user = cart.getCustomer();
            Order order = new Order();
            order.setCustomer(user);
            for (CartItem cartItem : cart.getCartItems()) {
                Sale sale = new Sale();
                sale.setCustomer(user);
                sale.setItem(cartItem.getItem());
                sale.setOrder(order);
                sale.setAmount(cartItem.getAmount());
                sale.setQuantity(cartItem.getQuantity());

                // for test purpose set first 40 sale at last month
                if (count++ < 40) {
                    ZonedDateTime date = sale.getCreatedDate().atZone(ZoneId.systemDefault());
                    date = date.minusMonths(1);
                    sale.setCreatedDate(date.toInstant());
                }
                order.getSales().add(sale);
            }
            order = orderRepository.saveAndFlush(order);

            cart.setStatus(Status.D);
            cartService.save(cart);
        }
    }
}

