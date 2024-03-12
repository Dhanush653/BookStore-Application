package com.bridgelabz.bookstoreapplication.repository;

import com.bridgelabz.bookstoreapplication.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

    @Query("SELECT u FROM UserEntity u WHERE u.email = :userEmailId AND u.user_password = :userPassword")
    UserEntity findByUsernameAndPassword(@Param("userEmailId") String userEmailId, @Param("userPassword") String userPassword);

    @Query("SELECT u from UserEntity u where u.user_firstname = :userFirstName")
    UserEntity findByFirstName(@Param("userFirstName") String userFirstName);
}
