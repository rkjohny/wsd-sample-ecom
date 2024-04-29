package com.wsd.ecom.service;

import com.wsd.ecom.entity.Item;
import com.wsd.ecom.entity.User;
import com.wsd.ecom.service.ItemService;
import com.wsd.ecom.service.UserService;
import com.wsd.ecom.utils.RandomUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class LoadDataService {

    private final UserService userService;
    private final ItemService itemService;

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
}
