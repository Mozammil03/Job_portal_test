package com.example.demo.model.ProfileDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Certification {
    private String title;
    private String issuer;
    private String date;
}
