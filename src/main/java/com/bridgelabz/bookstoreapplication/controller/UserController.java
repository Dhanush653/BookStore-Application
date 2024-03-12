package com.bridgelabz.bookstoreapplication.controller;

import com.bridgelabz.bookstoreapplication.dto.LoginDTO;
import com.bridgelabz.bookstoreapplication.dto.UserDTO;
import com.bridgelabz.bookstoreapplication.entity.UserEntity;
import com.bridgelabz.bookstoreapplication.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userservice;

    @GetMapping("/all")
    List<UserDTO> getAlluserdetails(){
        return userservice.getAlluserdetails();
    }
    @GetMapping("/{id}")
    UserDTO getAlluserbyId(@PathVariable int id){
        return userservice.getAlluserbyId(id);
    }
    @PostMapping("/create")
    UserEntity createUser(@RequestBody UserEntity user){
        return userservice.createUser(user);
    }
    @PutMapping("/update/{id}")
    UserEntity updatedUser(@PathVariable int id){
        return userservice.updatedUser(id);
    }
    @DeleteMapping("/delete/{id}")
    void deleteuser(@PathVariable int id){
        userservice.deleteuser(id);
    }
    @PostMapping("/registration")
    String userRegistration(@RequestBody UserEntity user){
        return userservice.userRegistration(user);
    }
    @PostMapping("/login")
    String logintoken(@RequestBody LoginDTO login){
        return userservice.logintoken(login);
    }
    @GetMapping("/details")
    List<UserEntity> generateUserByToken(@RequestHeader String token){
        return userservice.generateUserByToken(token);
    }
}
