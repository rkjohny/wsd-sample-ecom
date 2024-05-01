package com.wsd.ecom.entity.mapper;

import com.wsd.ecom.entity.dto.CartItemDto;
import com.wsd.ecom.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartItemMapper extends DtoMapper<CartItem, CartItemDto> {
}
