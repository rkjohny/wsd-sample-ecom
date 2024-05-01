package com.wsd.ecom.entity.mapper;

import com.wsd.ecom.entity.dto.UserDto;
import com.wsd.ecom.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends DtoMapper<User, UserDto> {
}
