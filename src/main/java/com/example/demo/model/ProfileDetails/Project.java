package com.example.demo.model.ProfileDetails;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private String name;
    private String description;
    private List<String> technologies;
    private List<String> features;
    private String githubUrl;
}
