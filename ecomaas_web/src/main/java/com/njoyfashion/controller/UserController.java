package com.njoyfashion.controller;

import com.njoyfashion.dto.PageableDto;
import com.njoyfashion.dto.UserDto;
import com.njoyfashion.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public Boolean create(@RequestBody @Valid UserDto userDto) {
        return userService.create(userDto);
    }

    @GetMapping("/getAll")
    public PageableDto<UserDto> getAllUsers(@RequestParam int page, @RequestParam int size){
        return userService.getAllUsers(page,size);
    }
}
