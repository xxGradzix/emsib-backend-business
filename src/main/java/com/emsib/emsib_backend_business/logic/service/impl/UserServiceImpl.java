package com.emsib.emsib_backend_business.logic.service.impl;

import org.springframework.stereotype.Service;

import com.emsib.emsib_backend_business.logic.dto.UserDto;
import com.emsib.emsib_backend_business.logic.entity.User;
import com.emsib.emsib_backend_business.logic.mapper.UserMapper;
import com.emsib.emsib_backend_business.logic.repository.UserRepository;
import com.emsib.emsib_backend_business.logic.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = UserMapper.mapToUser(userDto);
        User savedUser =userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

}
