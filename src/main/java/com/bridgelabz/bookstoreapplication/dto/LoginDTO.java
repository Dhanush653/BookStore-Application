package com.bridgelabz.bookstoreapplication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDTO {
    @NotBlank(message = "Email can not be blank")
    @Pattern(regexp = "^[a-z0-9.+\\-_]+[@][a-z]{3,}[.][a-z]{2,}$",message = "Invalid email format")
    private String email;
    @NotBlank(message = "Password can not be blank")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])[A-Za-z0-9]*[@$%&\\-][A-Za-z0-9]*$", message = "Enter Valid password")
    private String password;
}
