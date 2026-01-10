package com.example.demo.dto.profileDetailsDto;


import com.example.demo.model.ProfileDetails.JobExp;
import lombok.Data;

import java.util.List;

@Data
public class JobExpDto {
    private String company;
    private String role;
    private String duration;
    private String location;
    private List<String> responsibilities;
    private List<String> techStack;

    public JobExp toEntity() {
        return new JobExp(company, role, duration, location, responsibilities, techStack);
    }
}
