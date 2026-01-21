package com.emsib.emsib_backend_business.logic.service;

import com.emsib.emsib_backend_business.logic.dto.UserDto;
import com.emsib.emsib_backend_business.relational_database.UserEnt;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDto userDto);
    Optional<UserEnt> findById(Long id);
    List<UserEnt> findAll();
}
