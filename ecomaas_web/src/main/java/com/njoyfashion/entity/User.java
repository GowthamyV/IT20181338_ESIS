package com.njoyfashion.entity;

import com.njoyfashion.enums.Gender;
import com.njoyfashion.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user")

public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String firstName;
        private String lastName;
        private String userName;
        private String password;
        private String email;
        @Enumerated(EnumType.STRING)
        private Gender gender;
        private Long mobileNumber;
        private String address;
        private LocalDateTime registeredDate;
        private Boolean isActive;
        @Enumerated(EnumType.STRING)
        private UserType userType;
        private Boolean isVerified;
}

