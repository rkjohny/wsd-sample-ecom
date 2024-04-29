package com.wsd.ecom.core;

import com.wsd.ecom.service.LoadDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppEventListener implements ApplicationListener<ContextRefreshedEvent> {

    private final LoadDataService loadDataService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Application loaded. Inserting dummy data ...");
        loadDataService.insertUser(100);
        loadDataService.insertItem(100);
        log.info("Dummy data inserted");
    }
}
