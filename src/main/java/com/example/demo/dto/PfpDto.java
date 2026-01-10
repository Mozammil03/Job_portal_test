package com.example.demo.dto;

import com.example.demo.model.Pfp;
import com.example.demo.model.ProfileDetails.Locationss;
import com.example.demo.model.ProfileDetails.SocialLinks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PfpDto {
    private Long id;

    private String Name;
    private String profileImgLink;
    private String email;
    private String phone;
    private Locationss address;
    private SocialLinks socialLinks;
    private String bio;

    public Pfp toEntity(){
        return new Pfp(this.id,this.Name, this.profileImgLink, this.email, this.phone, this.address, this.socialLinks,this.bio);
    }
}