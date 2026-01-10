package com.example.demo.repository;

import com.example.demo.dto.PfpDto;
import com.example.demo.model.Pfp;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PfpRepo extends JpaRepository<Pfp, Long> {
    boolean existsByEmail(String email);
    Optional<Pfp> findByEmail(String email);
}
