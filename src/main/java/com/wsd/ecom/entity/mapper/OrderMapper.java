package com.wsd.ecom.entity.mapper;

import com.wsd.ecom.entity.dto.OrderDto;
import com.wsd.ecom.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper extends DtoMapper<Order, OrderDto> {
}
