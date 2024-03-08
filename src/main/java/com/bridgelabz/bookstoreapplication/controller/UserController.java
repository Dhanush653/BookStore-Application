package com.bridgelabz.bookstoreapplication.controller;

import com.bridgelabz.bookstoreapplication.dto.UserDTO;
import com.bridgelabz.bookstoreapplication.entity.UserEntity;
import com.bridgelabz.bookstoreapplication.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userservice;

    @GetMapping("/users")
    List<UserDTO> getAlluserdetails(){
        return userservice.getAlluserdetails();
    }
    @GetMapping("/user/{id}")
    UserDTO getAlluserbyId(@PathVariable int id){
        return userservice.getAlluserbyId(id);
    }
    @PostMapping("/user/create")
    UserEntity createUser(@RequestBody UserEntity user){
        return userservice.createUser(user);
    }
    @PutMapping("/user/update/{id}")
    UserEntity updatedUser(@PathVariable int id){
        return userservice.updatedUser(id);
    }
    @DeleteMapping("/user/delete/{id}")
    void deleteuser(@PathVariable int id){
        userservice.deleteuser(id);
    }
}
