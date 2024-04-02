package com.bridgelabz.bookstoreapplication.dto;

import jakarta.validation.constraints.*;
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
    private String user_firstname;
    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Invalid lastname format")
    private String user_lastname;
    @NotEmpty(message = "DOB cannot be empty")
    @Past
    private String user_dob;
    @NotBlank
    @Email
    private String user_email;
}
