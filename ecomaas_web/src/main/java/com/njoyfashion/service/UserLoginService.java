package com.njoyfashion.service;

import com.njoyfashion.dto.UserLoginDto;
import com.njoyfashion.config.SecurityConfig;
import com.njoyfashion.entity.User;
import com.njoyfashion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserLoginService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SecurityConfig securityConfig;


    public ResponseEntity<String> login(UserLoginDto userLoginDto){

       Optional<User> user = userRepository.findByUserName(userLoginDto.getUserName());

       String storedHashedPassword = retrieveStoredHashedPassword(userLoginDto.getUserName(),user);

       if (user.isPresent() && securityConfig.passwordEncoder().matches(userLoginDto.getPassword(),storedHashedPassword)){
            return ResponseEntity.ok("Login successful");
       }
       else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
       }
    }

    private String retrieveStoredHashedPassword(String username, Optional<User> user) {
        if (user.isPresent() && user.get().getUserName().equals(username)) {
            return user.get().getPassword();
        } else {
            return null;
        }
    }
}
