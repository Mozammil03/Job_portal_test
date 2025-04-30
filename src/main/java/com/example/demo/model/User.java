package com.example.demo.model;

import com.example.demo.dto.AccountType;
import com.example.demo.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or GenerationType.AUTO
    private Long id;

    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private AccountType accountType;


    public UserDto toDTO() {
        return new UserDto(this.id,this.name, this.email, this.password, this.accountType);
    }
    // Getters and Setters

}