package com.wsd.ecom.service.mapper;

import com.wsd.ecom.dto.SaleDto;
import com.wsd.ecom.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SaleMapper extends DtoMapper<Sale, SaleDto> {
}
