package com.wsd.ecom.mapper;

import com.wsd.ecom.dto.OrderDto;
import com.wsd.ecom.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper extends DtoMapper<Order, OrderDto> {
}
