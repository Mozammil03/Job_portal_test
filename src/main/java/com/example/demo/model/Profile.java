package com.example.demo.model;

import com.example.demo.dto.ProfileDto;
import com.example.demo.model.ProfileDetails.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String profileImg;
    private String email;
    private String phone;
    private String profession;
    private String bio;

    @ElementCollection
    @CollectionTable(name = "profile_employment", joinColumns = @JoinColumn(name = "profile_id"))
    private List<JobExp> jobsExp = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "profile_education", joinColumns = @JoinColumn(name = "profile_id"))
    private List<Education> education = new ArrayList<>();

    @Embedded
    private SocialLinks socialLinks;



    public ProfileDto toDto(){
        return new ProfileDto(this.id,this.profileImg, this.email, this.phone, this.profession, this.bio, this.jobsExp, this.education,  this.socialLinks);
    }

}
