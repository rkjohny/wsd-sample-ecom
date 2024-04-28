package com.wsd.ecom.service;

import com.wsd.ecom.dto.UserDto;
import com.wsd.ecom.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<User, UserDto> {

}
