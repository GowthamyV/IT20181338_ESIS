package com.njoyfashion.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    public Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private Long mobileNumber;
    private String address;
}
