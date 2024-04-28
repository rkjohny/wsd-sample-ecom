package com.wsd.ecom.mapper;

import com.wsd.ecom.dto.CartDto;
import com.wsd.ecom.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartMapper extends DtoMapper<Cart, CartDto> {
}
