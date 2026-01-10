package com.example.demo.dto;

import com.example.demo.model.Profile;
import com.example.demo.model.ProfileDetails.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {
    private Long id;

    private String profileImg;
    private String email;
    private String phone;
    private String profession;
    private String bio;
    private List<JobExp> jobsExp;
    private List<Education> education;
    private SocialLinks socialLinks;


    public Profile toEntity(){
        return new Profile(this.id,this.profileImg, this.email, this.phone, this.profession, this.bio, this.jobsExp, this.education,  this.socialLinks);
    }
}
