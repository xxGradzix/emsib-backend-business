package com.emsib.emsib_backend_business.logic.mapper;

import com.emsib.emsib_backend_business.logic.dto.UserDto;
import com.emsib.emsib_backend_business.logic.entity.UserEnt;

public class UserMapper {

    public static UserDto mapToUserDto(UserEnt user){
        return new UserDto(
            user.getUserId(),
            user.getName(),
            user.getSurname(),
            user.getEmail(),
            user.getPhone(),
            user.getNip()
        );
    }

    public static UserEnt mapToUser(UserDto userDto){
        return new UserEnt(
            userDto.getId(),
            userDto.getName(),
            userDto.getSurname(),
            userDto.getEmail(),
            userDto.getPhone(),
            userDto.getNip(),
            new byte[2],
            new byte[2]
        );
    }
}
