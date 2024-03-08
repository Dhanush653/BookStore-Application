package com.bridgelabz.bookstoreapplication.service;

import com.bridgelabz.bookstoreapplication.dto.UserDTO;
import com.bridgelabz.bookstoreapplication.entity.UserEntity;
import com.bridgelabz.bookstoreapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository repo;

    @Override
    public List<UserDTO> getAlluserdetails(){
        List<UserDTO> alluser = repo.findAll()
                .stream()
                .map(UserEntity -> new UserDTO(
                        UserEntity.getUser_id(),
                        UserEntity.getUser_firstname(),
                        UserEntity.getUser_lastname(),
                        UserEntity.getUser_dob()
                )).collect(Collectors.toList());
        return alluser;
    }
    @Override
    public UserDTO getAlluserbyId(long id){
        UserEntity userbyid = repo.findById(id).orElse(null);
        if(userbyid != null){
            return new UserDTO(
                    userbyid.getUser_id(),
                    userbyid.getUser_firstname(),
                    userbyid.getUser_lastname(),
                    userbyid.getUser_dob()
            );
        }
        return null;
    }
    @Override
    public UserEntity createUser(UserEntity user){
        return repo.save(user);
    }

    @Override
    public UserEntity updatedUser(long id){
        UserEntity user = repo.findById(id).get();
        user.setUser_firstname("Dhanush");
        user.setUser_lastname("Kumar");
        repo.save(user);
        return user;
    }
    @Override
    public void deleteuser(long id){
        UserEntity user = repo.findById(id).get();
        repo.delete(user);
    }

}
