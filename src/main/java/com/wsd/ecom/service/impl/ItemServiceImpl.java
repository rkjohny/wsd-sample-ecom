package com.wsd.ecom.service.impl;

import com.wsd.ecom.dto.ItemDto;
import com.wsd.ecom.entity.Item;
import com.wsd.ecom.mapper.ItemMapper;
import com.wsd.ecom.repository.ItemRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@Transactional
public class ItemServiceImpl extends AbstractServiceImpl<Item, ItemDto, ItemRepository, ItemMapper> {
    private final ItemRepository repository;
    private final ItemMapper mapper;

    @Autowired
    public ItemServiceImpl(ItemRepository repository, ItemMapper mapper) {
        super(repository, mapper);
        this.repository = repository;
        this.mapper = mapper;
    }
}
