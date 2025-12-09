package com.emsib.emsib_backend_business.logic.controller;

import com.emsib.emsib_backend_business.logic.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.emsib.emsib_backend_business.logic.dto.UserDto;
import com.emsib.emsib_backend_business.logic.service.UserService;

import lombok.AllArgsConstructor;

import java.sql.SQLOutput;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser =  userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/name")
    public ResponseEntity<String> getUserName(@PathVariable Long id) {
        return userService.findById(id)
                .map(user -> user.getName()) // extract only the name
                .map(ResponseEntity::ok)     // wrap in ResponseEntity
                .orElse(ResponseEntity.notFound().build());
    }
}
