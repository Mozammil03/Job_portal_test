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
public class Education {
    private String institution;
    private String degree;
    private String duration;
    private String cgpa;
    private String coursework;
}
