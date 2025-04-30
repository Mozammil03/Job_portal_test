package com.example.demo.service;

import com.example.demo.dto.LogInDto;
import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.JobPortalException;
import com.example.demo.model.OTP;
import com.example.demo.model.User;
import com.example.demo.repository.OTPrepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.utility.Data;
import com.example.demo.utility.RandomOTPgen;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service( value = "userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private OTPrepo otpRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto registerUser(UserDto userDto){
        if (userRepo.existsByEmail(userDto.getEmail())) {
            throw new IllegalArgumentException("User already exists with this email");
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = userDto.toEntity();
        user = userRepo.save(user);

        return user.toDTO();
    }

    @Override
    public List getAllUser(){
        List<User> lis = userRepo.findAll();
        return lis;
    }

    @Override
    public UserDto logInUser(LogInDto logInDto) {
        User user = userRepo.findByEmail(logInDto.getEmail()).orElseThrow(() -> new JobPortalException("USER_NOT_FOUND"));

        if (!passwordEncoder.matches(logInDto.getPassword(), user.getPassword())) {
            throw new JobPortalException("INVALID_CREDENTIALS");
        }

        return user.toDTO();
    }

    @Override
    public Boolean sendOTP(String email) throws Exception {
        if(!userRepo.existsByEmail(email)){
            throw new JobPortalException("User_not_found_with_this_email");
        }
        MimeMessage mm = mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mm,true);
        message.setTo(email);
        message.setSubject("Your OTP code for jobPortal verfication");
        String genOTP = RandomOTPgen.genOTP();
        OTP otp = new OTP(email,genOTP, LocalDateTime.now());
        otpRepo.save(otp);
        message.setText(Data.getMessageBody(genOTP), true);
        mailSender.send(mm);
        return true;
    }

    @Override
    public Boolean verifyOTP(String email, String otp) throws Exception {
        OTP savedOTP = otpRepo.findById(email).orElseThrow(()->new JobPortalException("OTP not found"));
        if(!savedOTP.getOTPcode().equals(otp)) throw new JobPortalException("OTP incorrect");
        return true;
    }

    @Override
    public ResponseDto changePass(UserDto userDto) throws Exception {
        User user =  userRepo.findByEmail(userDto.getEmail()).orElseThrow(() -> new JobPortalException("USER_NOT_FOUND"));

        if (passwordEncoder.matches(userDto.getPassword(), user.getPassword())) {
            throw new JobPortalException("Password cannot be the same as the old one");
        }
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepo.save(user);
        return new ResponseDto("Password Changed Successfully");
    }

    @Scheduled(fixedRate = 300000)
    public void removeExpiredOTPs(){
        LocalDateTime expiry = LocalDateTime.now().minusMinutes(5);
        List<OTP> expiredOTPs = otpRepo.findAll();
        if(!expiredOTPs.isEmpty()){
            int count = 0;
            for(OTP otp:expiredOTPs){
                System.out.print(otp.getEmail() + " " + otp.getCreationTime() + " " + otp.getOTPcode());
                if(otp.getCreationTime().isBefore(expiry)) {
                    count++;
                    otpRepo.deleteById(otp.getEmail());
                }
            }
            System.out.println("Deleted expired "+ count + " OTP.🔴");
        }
    }


}
