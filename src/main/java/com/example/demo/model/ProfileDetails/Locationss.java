package com.example.demo.model.ProfileDetails;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Locationss {
    private String city;
    private String state;
    private String country;
    private String timezone;
}
