package com.emsib.emsib_backend_business.logic.service;

import com.emsib.emsib_backend_business.logic.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
}
