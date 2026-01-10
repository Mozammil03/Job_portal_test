package com.example.demo.model;
import com.example.demo.dto.PfpDto;
import com.example.demo.model.ProfileDetails.Locationss;
import com.example.demo.model.ProfileDetails.SocialLinks;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pfp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Name;
    private String profileImgLink;
    private String email;
    private String phone;

    @Embedded
    private Locationss address;

    @Embedded
    private SocialLinks socialLinks;

    private String bio;

    public PfpDto toDto(){
        return new PfpDto(this.id,this.Name, this.profileImgLink, this.email, this.phone, this.address, this.socialLinks,this.bio);
    }
}
