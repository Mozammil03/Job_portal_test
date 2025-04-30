package com.example.demo.service;

import com.example.demo.dto.LogInDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.JobPortalException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public UserDto registerUser(UserDto userDto);
    public List getAllUser() throws JobPortalException;
    public UserDto logInUser(LogInDto logInDto) throws JobPortalException;
    public Boolean sendOTP(String email) throws Exception;
    public Boolean verifyOTP(String email, String otp) throws Exception;
    public ResponseDto changePass(UserDto userDto) throws Exception;

}

