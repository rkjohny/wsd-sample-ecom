package com.wsd.ecom.controller;

import com.wsd.ecom.dto.types.*;
import com.wsd.ecom.entity.Item;
import com.wsd.ecom.entity.User;
import com.wsd.ecom.repository.CartRepository;
import com.wsd.ecom.repository.ItemRepository;
import com.wsd.ecom.repository.UserRepository;
import com.wsd.ecom.service.CartService;
import com.wsd.ecom.service.ItemService;
import com.wsd.ecom.service.UserService;
import com.wsd.ecom.utils.RandomUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class APITest {

    private static RestTemplate restTemplate;

    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemRepository itemRepository;


    private String BASE_URL = "http://localhost";
    private String apiVersion = "/api/v1";
    @LocalServerPort
    private int PORT;
    private String cartEndPoint;
    private String orderEndPoint;
    private String saleEndPoint;

    private List<User> users;
    private List<Item> items;

    static long ID = 1000;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }
    @BeforeEach
    public void initTest() {
        cartEndPoint = BASE_URL + ":" + PORT + apiVersion + "/carts";
        orderEndPoint = BASE_URL + ":" + PORT + apiVersion + "/orders";
        saleEndPoint = BASE_URL + ":" + PORT + apiVersion + "/sales";

        insertUser(10);
        insertItems(10);
    }

    public void insertUser(int numberOfUser) {
        users = IntStream.rangeClosed(1, numberOfUser).mapToObj(i -> {
            User user = new User();
            user.login(RandomUtils.generateUserLogin())
                    .email(RandomUtils.generateUserEmail())
                    .firstName("User_" + i + "_first name")
                    .lastName("User_" + i + "_last name")
                    .password(RandomUtils.generateUserPassword())
                    .activated(true);
            user.setId(ID++);
            return user;
        }).collect(Collectors.toList());
        //Mockito.when(userRepository.saveAllAndFlush(users)).thenReturn(users);
        users = userRepository.saveAllAndFlush(users);
    }

    public void insertItems(int numberOfItem) {
        items = IntStream.rangeClosed(1, numberOfItem).mapToObj(i -> {
            Item item = new Item();
            item.name("Item_" + i + "_" + RandomUtils.generateRandom(5))
                    .unitPrice((double) RandomUtils.random(10, 1000))
                    .unit("kg")
                    .currency("USD")
                    .description(RandomUtils.generateRandom(10));
            item.setId(ID++);
            return item;
        }).collect(Collectors.toList());
        //Mockito.when(itemRepository.saveAllAndFlush(items)).thenReturn(items);
        items = itemRepository.saveAllAndFlush(items);
    }

    AddToCartOutput addItemToCart() {
        User user = users.get(0);
        AddToCartInput input = new AddToCartInput();

        Item item1 = items.get(0);
        ItemInCart itemInCart1 = new ItemInCart();
        itemInCart1.setItemId(item1.getId());
        itemInCart1.setQuantity(2);

        Item item2 = items.get(1);
        ItemInCart itemInCart2 = new ItemInCart();
        itemInCart2.setItemId(item2.getId());
        itemInCart2.setQuantity(2);

        input.setUserId(user.getId());
        input.getItems().add(itemInCart1);
        input.getItems().add(itemInCart2);

        AddToCartOutput output = restTemplate.postForObject(cartEndPoint + "/add-to-cart", input, AddToCartOutput.class);
        return output;
    }

    @Test
    void addToCart() {

        AddToCartOutput output = addItemToCart();
        assertEquals("OK", output.getResult());
    }

    @Test
    void viewCart() {
        insertUser(10);
        insertItems(10);
        addItemToCart();
        User user = users.get(0);
        Item item1 = items.get(0);
        Item item2 = items.get(1);
        ViewCartOutput output = restTemplate.getForObject(cartEndPoint + "/view-cart/" + user.getId(), ViewCartOutput.class);
        assertEquals("OK", output.getResult());
        assertEquals(2, output.getItems().size());
        assertEquals(output.getTotalAmount(), (item1.getUnitPrice()*2) + (item2.getUnitPrice() * 2));

        ItemInViewCart viewCart1 = output.getItems().get(0);
        ItemInViewCart viewCart2 = output.getItems().get(1);

        assertEquals(viewCart1.getItemId(), item1.getId());
        assertEquals(viewCart1.getName(), item1.getName());

        assertEquals(viewCart2.getItemId(), item2.getId());
        assertEquals(viewCart2.getName(), item2.getName());
    }
}
