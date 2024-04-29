package com.wsd.ecom.service;

import com.wsd.ecom.entity.Item;
import com.wsd.ecom.repository.ItemRepository;
import com.wsd.ecom.mapper.ItemMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository repository;
    private final ItemMapper mapper;


    public Item save(Item item) {
        return repository.saveAndFlush(item);
    }

    public List<Item> getAllItems() {
        return repository.findAll();
    }
}
