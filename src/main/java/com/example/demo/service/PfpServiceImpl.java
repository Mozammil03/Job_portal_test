package com.example.demo.service;

import com.example.demo.dto.PfpDto;
import com.example.demo.exception.JobPortalException;
import com.example.demo.model.Pfp;
import com.example.demo.repository.PfpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service( value = "pfpService")
public class PfpServiceImpl implements PfpService{
    @Autowired
    private PfpRepo pfpRepo;

    public PfpDto updateDetails(PfpDto pfpDto) {

        Pfp pfp = pfpRepo.findByEmail(pfpDto.getEmail())
                .orElse(new Pfp());

        pfp.setName(pfpDto.getName());
        pfp.setEmail(pfpDto.getEmail());
        pfp.setPhone(pfpDto.getPhone());
        pfp.setProfileImgLink(pfpDto.getProfileImgLink());
        pfp.setAddress(pfpDto.getAddress());
        pfp.setSocialLinks(pfpDto.getSocialLinks());
        pfp.setBio(pfpDto.getBio());

        return pfpRepo.save(pfp).toDto();
    }

    public PfpDto getDetails(String email){

        Pfp pfp =  pfpRepo.findByEmail(email).orElseThrow(() -> new JobPortalException("DETAILS_NOT_FOUND"));

        System.out.println(pfp);
        return pfp.toDto();
    }

    public Boolean pfpExists(String email){
        return pfpRepo.existsByEmail(email);
    };
}
