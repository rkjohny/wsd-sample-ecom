package com.wsd.ecom.entity.mapper;


import com.wsd.ecom.entity.dto.ItemDto;
import com.wsd.ecom.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper extends DtoMapper<Item, ItemDto> {
}
