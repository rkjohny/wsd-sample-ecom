package com.wsd.ecom.core;

import com.wsd.ecom.service.GenerateDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppEventListener implements ApplicationListener<ContextRefreshedEvent> {

    private final GenerateDataService generateDataService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Application loaded. Inserting dummy data ...");
        generateDataService.insertUser(100);
        generateDataService.insertItem(100);

        generateDataService.addToCart(20, 4);
        generateDataService.purchaseAllPendingCarts();
        log.info("Dummy data inserted");
    }
}
