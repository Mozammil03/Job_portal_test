package com.example.demo.repository;

import com.example.demo.model.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface OTPrepo extends JpaRepository<OTP, String> {
    List<OTP> findByCreationTimeBefore(LocalDateTime expiry);

}

