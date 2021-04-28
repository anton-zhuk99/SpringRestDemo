package com.example.restdemo.repository;

import com.example.restdemo.dto.UserDto;
import com.example.restdemo.model.User;

public interface UserRepository extends CrudRepository<User, UserDto> {

    User getUserByUsername(String username);


}
