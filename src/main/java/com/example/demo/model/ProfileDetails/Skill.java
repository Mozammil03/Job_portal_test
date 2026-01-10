package com.example.demo.model.ProfileDetails;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
    private List<String> programmingLanguages;
    private List<String> frameworksAndLibraries;
    private List<String> databases;
    private List<String> tools;
    private List<String> cloudAndDevOps;
}
