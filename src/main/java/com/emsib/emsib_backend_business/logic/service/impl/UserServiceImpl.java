package com.emsib.emsib_backend_business.logic.service.impl;

import org.springframework.stereotype.Service;

import com.emsib.emsib_backend_business.logic.dto.UserDto;
import com.emsib.relational_database.UserEnt;
import com.emsib.emsib_backend_business.logic.mapper.UserMapper;
import com.emsib.emsib_backend_business.logic.repository.UserRepository;
import com.emsib.emsib_backend_business.logic.service.UserService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEnt user = UserMapper.mapToUser(userDto);
        UserEnt savedUser =userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public Optional<UserEnt> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEnt> findAll() {
        return userRepository.findAll();
    }
}
