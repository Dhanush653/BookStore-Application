package com.bridgelabz.bookstoreapplication.entity;

import jakarta.persistence.*;
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
    private String user_firstname;
    @Column(name = "last_name")
    private String user_lastname;
    @Column(name = "dob")
    private LocalDate user_dob;
    @Column(name = "registered_date")
    private LocalDate user_registered_date;
    @Column(name = "updated_date")
    private LocalDate user_updated_date;
    @Column(name = "password")
    private String user_password;
    @Column(name = "email")
    private String user_email;
    private boolean user_verify;
}
