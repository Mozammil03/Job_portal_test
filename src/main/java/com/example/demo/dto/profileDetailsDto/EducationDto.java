package com.example.demo.dto.profileDetailsDto;


import com.example.demo.model.ProfileDetails.Education;
import lombok.Data;

@Data
public class EducationDto {
    private String institution;
    private String degree;
    private String duration;
    private String cgpa;
    private String coursework;

    public Education toEntity() {
        return new Education(institution, degree, duration, cgpa, coursework);
    }
}
