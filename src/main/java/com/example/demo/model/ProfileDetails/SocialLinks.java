package com.example.demo.model.ProfileDetails;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialLinks {
    private String linkedin;
    private String github;
    private String portfolio;
}
