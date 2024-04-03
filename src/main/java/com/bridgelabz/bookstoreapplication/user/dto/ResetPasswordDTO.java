package com.bridgelabz.bookstoreapplication.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordDTO {
    private String email;
//    String user_email;
    String user_oldPassword;
    String user_newPassword;
}
