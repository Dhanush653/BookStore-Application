package com.bridgelabz.bookstoreapplication.user.controller;

import com.bridgelabz.bookstoreapplication.user.dto.ChangePasswordDTO;
import com.bridgelabz.bookstoreapplication.user.dto.ForgetPasswordDTO;
import com.bridgelabz.bookstoreapplication.user.dto.LoginDTO;
import com.bridgelabz.bookstoreapplication.user.dto.ResetPasswordDTO;
import com.bridgelabz.bookstoreapplication.user.entity.UserEntity;
import com.bridgelabz.bookstoreapplication.user.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = "*")
public class UserController {
    @Autowired
    private IUserService userservice;

    @GetMapping("/all")
    List<UserEntity> getAlluserdetails(){
        return userservice.getAlluserdetails();
    }
    @GetMapping("/{id}")
    UserEntity getAlluserbyId(@PathVariable int id){
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
    String userRegistration(@RequestBody @Valid UserEntity user){
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
    @PostMapping("/forget")
    String forgetPassword(@RequestBody ForgetPasswordDTO request){
        return userservice.forgetPassword(request.getUser_email());
    }
    @PostMapping("/change")
    String changePassword(@RequestBody ChangePasswordDTO change){
        return userservice.changePassword(change.getUser_email(),change.getUser_otp(),change.getUser_newPassword());
    }

    @PostMapping("/reset")
    String resetPassword(@RequestBody ResetPasswordDTO reset){
        return userservice.resetPassword(reset.getEmail(),reset.getUser_oldPassword(),reset.getUser_newPassword());
    }
}
