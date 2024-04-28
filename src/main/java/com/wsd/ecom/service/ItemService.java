package com.wsd.ecom.service;

import com.wsd.ecom.mapper.ItemMapper;
import com.wsd.ecom.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class ItemService {
    private final ItemRepository repository;
    private final ItemMapper mapper;

    @Autowired
    public ItemService(ItemRepository repository, ItemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
