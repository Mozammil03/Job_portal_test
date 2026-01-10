package com.example.demo.service;

import com.example.demo.dto.PfpDto;
import org.springframework.stereotype.Service;

@Service
public interface PfpService {
    public PfpDto updateDetails(PfpDto pfpDto);
    public PfpDto getDetails(String email);
    public Boolean pfpExists(String email);
}
