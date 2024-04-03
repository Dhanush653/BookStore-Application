package com.bridgelabz.bookstoreapplication.user.repository;

import com.bridgelabz.bookstoreapplication.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

}
