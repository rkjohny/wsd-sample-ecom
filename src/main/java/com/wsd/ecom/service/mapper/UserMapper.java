package com.wsd.ecom.service.mapper;

import com.wsd.ecom.dto.UserDto;
import com.wsd.ecom.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends DtoMapper<User, UserDto> {
}
