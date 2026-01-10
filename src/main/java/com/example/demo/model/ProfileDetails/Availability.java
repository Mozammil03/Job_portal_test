package com.example.demo.model.ProfileDetails;

import java.util.List;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Availability {
    private boolean openToWork;
    private List<String> preferredRoles;
    private String noticePeriod;
}
