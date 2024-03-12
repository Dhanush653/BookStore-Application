package com.bridgelabz.bookstoreapplication.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int user_id;
    @NotBlank(message = "First name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Invalid first name format")
    private String user_firstname;
    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "[A-Z][a-z]+$", message = "Invalid lastname format")
    private String user_lastname;
    @NotBlank(message = "DOB cannot be empty")
    @Past(message = "Enter a valid Date Of Birth")
    private LocalDate user_dob;
}
