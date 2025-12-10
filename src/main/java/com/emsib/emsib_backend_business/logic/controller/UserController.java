package com.emsib.emsib_backend_business.logic.controller;

import com.emsib.emsib_backend_business.logic.entity.User;
import com.emsib.emsib_backend_business.logic.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.emsib.emsib_backend_business.logic.dto.UserDto;
import com.emsib.emsib_backend_business.logic.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser =  userService.createUser(userDto);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
       User user = userService.findById(id)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
       return ResponseEntity.ok(UserMapper.mapToUserDto(user));
    }

    @GetMapping("/get/all")
    public List<UserDto> getUserAll() {
        List<User> users = userService.findAll();
        List<UserDto> usersDto = new ArrayList<>();
        for (User u : users) {
            usersDto.add(UserMapper.mapToUserDto(u));
        }
        return usersDto;
    }
}
