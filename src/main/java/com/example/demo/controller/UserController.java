package com.example.demo.controller;
import com.example.demo.dto.LogInDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Validated
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto>registerUser(@RequestBody @Valid UserDto userDto){
        userDto = userService.registerUser(userDto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    };

    @PostMapping("/login")
    public ResponseEntity<UserDto>loginUser(@RequestBody @Valid LogInDto logInDto){

        return new ResponseEntity<>(userService.logInUser(logInDto), HttpStatus.OK);
    };

    @GetMapping("/getAllUser")
    public ResponseEntity<List>getUsers(){
        List<UserDto> lis = new ArrayList<>();
        lis = userService.getAllUser();
        return new ResponseEntity<>(lis,HttpStatus.OK);
    }
    @PostMapping("/sendOTP/{email}")
    public ResponseEntity<ResponseDto>sendOTP(@PathVariable @Email(message = "{user.email.invalid}") String email) throws Exception{
        userService.sendOTP(email);
        return new ResponseEntity<>(new ResponseDto("Otp Send , check your mail"), HttpStatus.CREATED);
    };
    @GetMapping("/verifyOTP/{email}/{otp}")
    public ResponseEntity<ResponseDto>verifyOTP(@PathVariable @Email(message = "{user.email.invalid}") String email, @PathVariable @Pattern(regexp = "^[0-9]{6}$", message = "{otp.invalid}") String otp) throws Exception{
        userService.verifyOTP(email,otp);
        return new ResponseEntity<>(new ResponseDto("Otp Verified"), HttpStatus.OK);
    };

    @PostMapping("/changePass")
    public ResponseEntity<ResponseDto>changePass(@RequestBody UserDto userDto) throws Exception{
        ResponseDto res = userService.changePass(userDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    };



}