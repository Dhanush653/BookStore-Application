package com.bridgelabz.bookstoreapplication.service;

import com.bridgelabz.bookstoreapplication.dto.UserDTO;
import com.bridgelabz.bookstoreapplication.entity.UserEntity;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAlluserdetails();
    UserDTO getAlluserbyId(long id);
    UserEntity createUser(UserEntity user);
    UserEntity updatedUser(long id);
    void deleteuser(long id);
}
