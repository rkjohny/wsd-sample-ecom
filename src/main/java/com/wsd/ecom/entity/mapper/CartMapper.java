package com.wsd.ecom.entity.mapper;

import com.wsd.ecom.entity.dto.CartDto;
import com.wsd.ecom.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartMapper extends DtoMapper<Cart, CartDto> {
}
