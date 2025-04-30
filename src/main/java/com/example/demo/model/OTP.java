package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "OTP")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OTP {
    @Id
    private String email;
    private String OTPcode;
    private LocalDateTime creationTime;


}
