package com.example.restdemo.controllers;

import com.example.restdemo.dto.UserDto;
import com.example.restdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/v1/")
public class UserControllerV1 {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "create/user")
    public ResponseEntity createUser(@RequestBody UserDto dto) {
        userRepository.create(dto);
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", "User successfully registered");
        ResponseEntity responseEntity = new ResponseEntity(responseBody, HttpStatus.OK);
        responseEntity.getHeaders().add("myHeader", "myValue");
        return responseEntity;
    }

}