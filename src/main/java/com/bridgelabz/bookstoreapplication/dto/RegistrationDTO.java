package com.bridgelabz.bookstoreapplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrationDTO {
    @NotBlank(message = "First name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Invalid first name format")
    private String firstname;
    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "[A-Z][a-z]+$", message = "Invalid lastname format")
    private String lastname;
    @NotBlank(message = "DOB cannot be empty")
    @Past(message = "Enter a valid Date Of Birth")
    private String dob;
    @NotBlank(message = "Email cannot be empty")
    @Pattern(regexp = "^[a-z0-9.+\\-_]+[@][a-z]{3,}[.][a-z]{2,}$",message = "Invalid email format")
    private String email;
}
