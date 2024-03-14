package com.bridgelabz.bookstoreapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "userdetails_table")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int user_id;

    @Column(name = "first_name")
    @NotBlank(message = "First name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Invalid first name format")
    private String user_firstname;

    @Column(name = "last_name")
    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Invalid lastname format")
    private String user_lastname;

    @Column(name = "dob")
    @NotBlank(message = "DOB cannot be empty")
    @Past
    private LocalDate user_dob;

    @Column(name = "registered_date")
    @NotBlank
    @PastOrPresent
    private LocalDate user_registered_date;

    @Column(name = "updated_date")
    @NotBlank
    private LocalDate user_updated_date;

    @Column(name = "password")
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!&])[A-Za-z0-9]+$", message = "Invalid password format")
    private String user_password;

    @Column(name = "email")
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;
    private boolean user_verify = false;
}
