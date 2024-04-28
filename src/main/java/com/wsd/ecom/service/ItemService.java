package com.wsd.ecom.service;

import com.wsd.ecom.dto.ItemDto;
import com.wsd.ecom.entity.Item;
import org.springframework.stereotype.Service;


@Service
public interface ItemService extends IService<Item, ItemDto> {

}
