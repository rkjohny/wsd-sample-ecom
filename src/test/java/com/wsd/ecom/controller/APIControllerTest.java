package com.wsd.ecom.controller;


import com.wsd.ecom.dto.types.AddToCartInput;
import com.wsd.ecom.dto.types.AddToCartOutput;
import com.wsd.ecom.dto.types.ItemInCart;
import com.wsd.ecom.entity.Item;
import com.wsd.ecom.entity.User;
import com.wsd.ecom.repository.ItemRepository;
import com.wsd.ecom.repository.UserRepository;
import com.wsd.ecom.service.ItemService;
import com.wsd.ecom.service.OrderService;
import com.wsd.ecom.service.SaleService;
import com.wsd.ecom.service.UserService;
import com.wsd.ecom.utils.RandomUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class APIControllerTest {
    private static RestTemplate restTemplate;

    private String BASE_URL = "http://localhost";
    private String apiVersion = "/api/v1";
    @LocalServerPort
    private int PORT;
    private String cartEndPoint;
    private String orderEndPoint;
    private String saleEndPoint;


    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private ItemService itemService;
    @Mock
    private ItemRepository itemRepository;

//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private SaleService saleService;


    private List<User> users;
    private List<Item> items;

    static long ID = 1;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
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
        Mockito.when(userRepository.saveAllAndFlush(users)).thenReturn(users);
        users = userRepository.saveAllAndFlush(users);
    }

    public void insertItems(int numberOfItem) {
        items = IntStream.rangeClosed(1, numberOfItem).mapToObj(i -> {
            Item item = new Item();
            item.name("Item_" + i)
                    .unitPrice((double) RandomUtils.random(10, 1000))
                    .unit("kg")
                    .currency("USD")
                    .description(RandomUtils.generateRandom(10));
            item.setId(ID++);
            return item;
        }).collect(Collectors.toList());
        Mockito.when(itemRepository.saveAllAndFlush(items)).thenReturn(items);
        items = itemRepository.saveAllAndFlush(items);
    }

    @BeforeEach
    public void initTest() {
        MockitoAnnotations.openMocks(this);

        cartEndPoint = BASE_URL + ":" + PORT + apiVersion + "/carts";
        orderEndPoint = BASE_URL + ":" + PORT + apiVersion + "/orders";
        saleEndPoint = BASE_URL + ":" + PORT + apiVersion + "/sales";

        insertUser(10);
        insertItems(10);
    }

    @Test
    void addToCart() {
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
        assertEquals("OK", output.getResult());
    }
}