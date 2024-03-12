package com.bridgelabz.bookstoreapplication.service.user;

import com.bridgelabz.bookstoreapplication.dto.LoginDTO;
import com.bridgelabz.bookstoreapplication.dto.UserDTO;
import com.bridgelabz.bookstoreapplication.entity.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAlluserdetails();
    UserDTO getAlluserbyId(long id);
    UserEntity createUser(UserEntity user);
    UserEntity updatedUser(long id);
    void deleteuser(long id);

    String userRegistration(UserEntity user);
    String logintoken(LoginDTO login);
    List<UserEntity> generateUserByToken(String token);
}
