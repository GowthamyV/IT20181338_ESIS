package com.njoyfashion.converter;

import com.njoyfashion.dto.UserDto;
import com.njoyfashion.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User convert(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setMobileNumber(userDto.getMobileNumber());
        user.setAddress(userDto.getAddress());
        return user;
    }

    public UserDto convert(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setMobileNumber(user.getMobileNumber());
        userDto.setAddress(user.getAddress());
        return userDto;
    }
}
