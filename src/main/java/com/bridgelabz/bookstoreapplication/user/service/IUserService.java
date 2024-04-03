package com.bridgelabz.bookstoreapplication.user.service;

import com.bridgelabz.bookstoreapplication.user.dto.LoginDTO;
import com.bridgelabz.bookstoreapplication.user.entity.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserEntity> getAlluserdetails();
    UserEntity getAlluserbyId(long id);
    UserEntity createUser(UserEntity user);
    UserEntity updatedUser(long id);
    void deleteuser(long id);
    String userRegistration(UserEntity user);
    String logintoken(LoginDTO login);
    List<UserEntity> generateUserByToken(String token);

    String forgetPassword(String email);
    String changePassword(String email, String otp, String newPassword);

    String resetPassword(String email, String oldPassword, String newPassword);
}
