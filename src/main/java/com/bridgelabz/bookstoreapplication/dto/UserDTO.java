package com.bridgelabz.bookstoreapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
    private int user_id;
    private String user_firstname;
    private String user_lastname;
    private LocalDate user_dob;
}
