package com.njoyfashion.service;


import com.njoyfashion.dto.PageableDto;
import com.njoyfashion.dto.UserDto;

import com.njoyfashion.converter.UserConverter;
import com.njoyfashion.entity.User;
import com.njoyfashion.enums.UserType;
import com.njoyfashion.exceptionHandler.ServiceException;
import com.njoyfashion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;
    @Autowired
    PasswordEncoder passwordEncoder;

    public Boolean create(UserDto userDto){

        if(userRepository.findByUserName(userDto.getUserName()).isPresent())
        {
            throw new ServiceException("User already exist","Bad request", HttpStatus.BAD_REQUEST);
        }
        if(userRepository.findByMobileNumber(userDto.getMobileNumber()).isPresent())
        {
            throw new ServiceException("Mobile number already exist","Bad request", HttpStatus.BAD_REQUEST);
        }

        User user = userConverter.convert(userDto);

        if (userDto.getPassword().isBlank()){
            user.setPassword(null);
        }
        else {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        user.setRegisteredDate(LocalDateTime.now());
        user.setIsActive(Boolean.TRUE);
        user.setUserType(UserType.CUSTOMER);
        user.setIsVerified(Boolean.TRUE);
        userRepository.save(user);
        return true;
    }

    public PageableDto<UserDto> getAllUsers(int page,int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<User> users = userRepository.findAllUsers(paging);
        List<UserDto> userDtoList = users.getContent().stream().map(userConverter::convert).toList();
        PageableDto<UserDto> pageableDto = new PageableDto<>();
        pageableDto.setTotalItems(users.getTotalElements());
        pageableDto.setCurrentPage(page);
        pageableDto.setTotalPages(users.getTotalPages());
        pageableDto.setData(userDtoList);
        return pageableDto;
    }
}
