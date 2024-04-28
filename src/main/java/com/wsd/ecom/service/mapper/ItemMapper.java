package com.wsd.ecom.service.mapper;


import com.wsd.ecom.dto.ItemDto;
import com.wsd.ecom.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper extends DtoMapper<Item, ItemDto> {
}
