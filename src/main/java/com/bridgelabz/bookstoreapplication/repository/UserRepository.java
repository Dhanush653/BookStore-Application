package com.bridgelabz.bookstoreapplication.repository;

import com.bridgelabz.bookstoreapplication.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
