package com.emsib.emsib_backend_business.logic.service;

import com.emsib.emsib_backend_business.logic.dto.UserDto;
import com.emsib.emsib_backend_business.logic.entity.User;

import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDto userDto);
    Optional<User> findById(Long id);
}
