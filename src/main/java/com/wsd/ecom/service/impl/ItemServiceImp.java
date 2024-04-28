package com.wsd.ecom.service.impl;

import com.wsd.ecom.service.ItemService;
import com.wsd.ecom.service.mapper.ItemMapper;
import com.wsd.ecom.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class ItemServiceImp implements ItemService {
    private final ItemRepository repository;
    private final ItemMapper mapper;

    @Autowired
    public ItemServiceImp(ItemRepository repository, ItemMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
}
