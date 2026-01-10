package com.example.demo.dto;

import com.example.demo.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    @NotBlank(message = "{user.name.blank}")
    private String name;

    @NotBlank(message = "{user.email.blank}")
    @Email(message = "{user.email.invalid}")
    private String email;

    @NotBlank(message = "{user.password.blank}")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$",
            message = "{user.password.invalid}"
    )
    private String password;

    private AccountType accountType;
    private Long profileId;
    public User toEntity() {
        return new User(this.id,this.name, this.email, this.password, this.accountType, this.profileId);
    }
}
