package com.example.demo.service;

import com.example.demo.dto.ProfileDto;
import com.example.demo.exception.JobPortalException;
import com.example.demo.model.Profile;
import com.example.demo.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepo profileRepo;

    @Override
    public String createProfile(String email, ProfileDto profileDto) throws JobPortalException {
        Profile prof = profileRepo.save(profileDto.toEntity());

        return prof.getEmail()+"data saved";
    }
}
