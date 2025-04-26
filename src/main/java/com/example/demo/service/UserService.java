package com.example.demo.service;

import com.example.demo.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserDto registerUser(UserDto userDto);
}
