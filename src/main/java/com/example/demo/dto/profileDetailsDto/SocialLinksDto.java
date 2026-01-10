package com.example.demo.dto.profileDetailsDto;
import com.example.demo.model.ProfileDetails.SocialLinks;
import lombok.Data;

@Data
public class SocialLinksDto {
    private String linkedin;
    private String github;
    private String portfolio;

    public SocialLinks toEntity() {
        return new SocialLinks(linkedin, github, portfolio);
    }
}
