package com.example.restdemo.service;

import com.example.restdemo.dto.UserDto;
import com.example.restdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserDto userDto) {
        userRepository.create(userDto);
    }

}
