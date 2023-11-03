package com.njoyfashion.repository;

import com.njoyfashion.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long>,JpaRepository<User,Long> {

     Optional<User> findByUserName(String userName);
     Optional<User> findByEmail(String email);
     Optional<User> findByMobileNumber(Long mobileNumber);

     @Query("SELECT e FROM User e ORDER BY e.registeredDate")
     Page<User> findAllUsers(Pageable paging);
}
