package com.emsib.emsib_backend_business.logic.mapper;

import com.emsib.emsib_backend_business.logic.dto.UserDto;
import com.emsib.emsib_backend_business.logic.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user){
        return new UserDto(
            user.getId(),
            user.getName(),
            user.getSurname(),
            user.getEmail(),
            user.getPhone(),
            user.getNip()
        );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
            userDto.getId(),
            userDto.getName(),
            userDto.getSurname(),
            userDto.getEmail(),
            userDto.getPhone(),
            userDto.getNip(),
            null,
            null
        );
    }
}
