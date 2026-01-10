package com.example.demo.model.ProfileDetails;

import java.util.List;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobExp {
    private String company;
    private String role;
    private String duration;
    private String location;
    private List<String> responsibilities;
    private List<String> techStack;
}
