package com.example.demo.utility;


import java.security.SecureRandom;

public class RandomOTPgen {
    public static String genOTP(){
        StringBuilder otp = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for(int i=0;i<6;i++){
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }
}
