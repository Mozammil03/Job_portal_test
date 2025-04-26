package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service( value = "userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto registerUser(UserDto userDto){
        if (userRepo.existsByEmail(userDto.getEmail())) {
            throw new IllegalArgumentException("User already exists with this email");
        }
        User user = userDto.toEntity();
        user = userRepo.save(user);

        return user.toDTO();
    }
}
