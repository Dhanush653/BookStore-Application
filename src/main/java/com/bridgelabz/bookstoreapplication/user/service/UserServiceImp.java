package com.bridgelabz.bookstoreapplication.user.service;

import com.bridgelabz.bookstoreapplication.user.utility.Emailsender;
import com.bridgelabz.bookstoreapplication.user.utility.ForgetPassword;
import com.bridgelabz.bookstoreapplication.user.utility.JWTservice;
import com.bridgelabz.bookstoreapplication.user.dto.LoginDTO;
import com.bridgelabz.bookstoreapplication.user.entity.UserEntity;
import com.bridgelabz.bookstoreapplication.user.exception.UserException;
import com.bridgelabz.bookstoreapplication.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JWTservice jwtservice;

    @Autowired
    private Emailsender mailsender;

    @Autowired
    private BCryptPasswordEncoder passwordconfig;

    @Autowired
    private ForgetPassword forget;

    @Override
    public List<UserEntity> getAlluserdetails() {
        try{
            return repo.findAll();
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            throw new UserException("Error While Retrieving the user Details");
        }
    }

    @Override
    public UserEntity getAlluserbyId(long id) {
        try{
            UserEntity userid = repo.findById(id).get();
            return userid;
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            throw new UserException("Error While Finding User By ID");
        }
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        try{
            return repo.save(user);
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            throw new UserException("Error: " + e.getMessage());
        }
    }

    @Override
    public UserEntity updatedUser(long id) {
        try{
            UserEntity user = repo.findById(id).orElse(null);
            if (user != null) {
                user.setUser_firstname("Dhanush");
                user.setUser_lastname("Kumar");
                return repo.save(user);
            }
            return null;
        }
        catch(Exception e){
            System.out.println("Error while adding a user");
            throw new UserException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteuser(long id) {
        try{
            UserEntity user = repo.findById(id).orElse(null);
            if (user != null) {
                repo.delete(user);
            }
        }
        catch (Exception e){
            System.out.println("Error while deleting user");
            throw new UserException("Error: " + e.getMessage());
        }
    }

    @Override
    public String userRegistration(UserEntity user) {
        String encodedpassword = passwordconfig.encode(user.getUser_password());
        user.setUser_password(encodedpassword);
        user.setUser_verify(true);
        repo.save(user);
        String body ="Hello "+ user.getUser_firstname() + " " + user.getUser_lastname() + " You have Registered Successfully in book store Please Click the below link to login" + "https://localhost:8080/user/login";
        String subject = "You have registered Successfully";
        System.out.println(user.getEmail());
        System.out.println("Mail sent successfully");
        mailsender.sendMail(user.getEmail(),subject,body);
        return "User registered successfully";
    }

    @Override
    public String logintoken(LoginDTO login) {

//        UserEntity userentity = repo.findByEmail(login.getUser_email());
        UserEntity userentity = repo.findByEmail(login.getEmail());

        if(userentity != null && passwordconfig.matches(login.getUser_password(),userentity.getUser_password())){
//            String token = jwtservice.generateToken(login.getUser_email());
            String token = jwtservice.generateToken(login.getEmail());
            String body = "Successfully Registered";
            String subject = "Mail from Spring";
//            mailsender.sendMail(login.getUser_email(),subject,body);
            mailsender.sendMail(login.getEmail(),subject,body);
            return token;
        }
        else{
            return "Invalid Login. Try Again";
        }
    }
    public List<UserEntity> generateUserByToken(String token){
        String email = jwtservice.decodetoken(token);
        UserEntity userEntity = repo.findByEmail(email);
        return Collections.singletonList(userEntity);
    }

    @Override
    public String forgetPassword(String email) {
        String otp = forget.generateOtp();
        forget.sendOtp(email,otp);
        return "OTP send to " + email;
    }

    @Override
    public String changePassword(String email, String otp, String newPassword) {
        forget.changePassword(email,otp,newPassword);

        return "Password changed successfully";
    }

    @Override
    public String resetPassword(String email, String oldPassword, String newPassword) {
        UserEntity userEntity = repo.findByEmail(email);
        if(userEntity != null && passwordconfig.matches(oldPassword, userEntity.getUser_password())){
            userEntity.setUser_password(passwordconfig.encode(newPassword));
            repo.save(userEntity);
            return "Password changed successfully";
        }
        else{
            return "Invalid email or oldPassword";
        }
    }
}
