package com.bridgelabz.bookstoreapplication.service.user;

import com.bridgelabz.bookstoreapplication.service.user.IUserService;
import com.bridgelabz.bookstoreapplication.util.Emailsender;
import com.bridgelabz.bookstoreapplication.util.JWTservice;
import com.bridgelabz.bookstoreapplication.dto.LoginDTO;
import com.bridgelabz.bookstoreapplication.dto.UserDTO;
import com.bridgelabz.bookstoreapplication.entity.UserEntity;
import com.bridgelabz.bookstoreapplication.exception.UserException;
import com.bridgelabz.bookstoreapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JWTservice jwtservice;

    @Autowired
    private Emailsender mailsender;

    @Override
    public List<UserDTO> getAlluserdetails() {
        try{
            return repo.findAll().stream()
                    .map(userEntity -> new UserDTO(
                            userEntity.getUser_id(),
                            userEntity.getUser_firstname(),
                            userEntity.getUser_lastname(),
                            userEntity.getUser_dob()))
                    .collect(Collectors.toList());
        }
        catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            throw new UserException("Error While Retrieving the user Details");
        }
    }

    @Override
    public UserDTO getAlluserbyId(long id) {
        try{
            UserEntity userbyid = repo.findById(id).orElse(null);
            if (userbyid != null) {
                return new UserDTO(
                        userbyid.getUser_id(),
                        userbyid.getUser_firstname(),
                        userbyid.getUser_lastname(),
                        userbyid.getUser_dob());
            }
            return null;
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
        repo.save(user);
        String body = "You have Registered Successfully." + "Please Click the below link to login" + "https://localhost:8080/user/login";
        String subject = "You have registered Successfully";
        System.out.println("Registered mail" + user.getEmail());
        mailsender.sendMail(user.getEmail(),subject,body);
        return "User registered successfully";
    }

    @Override
    public String logintoken(LoginDTO login) {
        UserEntity userentity = repo.findByUsernameAndPassword(login.getEmail(),login.getPassword());
        if(userentity != null){
            String token = jwtservice.generateToken(login.getEmail());
            String body = "Successfully Registered";
            String subject = "Mail from Spring";
            mailsender.sendMail(login.getEmail(),subject,body);
            return "Login Successfully || Token: "+ token;
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
}
