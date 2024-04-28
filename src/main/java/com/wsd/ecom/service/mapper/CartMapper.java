package com.wsd.ecom.service.mapper;

import com.wsd.ecom.dto.CartDto;
import com.wsd.ecom.entity.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CartMapper extends DtoMapper<Cart, CartDto> {
}
