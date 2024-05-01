package com.wsd.ecom.entity.mapper;

import com.wsd.ecom.entity.dto.SaleDto;
import com.wsd.ecom.entity.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SaleMapper extends DtoMapper<Sale, SaleDto> {
}
