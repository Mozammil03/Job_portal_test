package com.example.demo.service;

import com.example.demo.dto.ProfileDto;
import com.example.demo.exception.JobPortalException;

public interface ProfileService {
    public String createProfile(String email, ProfileDto profileDto) throws JobPortalException;
}
