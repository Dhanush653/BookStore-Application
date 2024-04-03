package com.bridgelabz.bookstoreapplication.cart.repository;

import com.bridgelabz.bookstoreapplication.cart.entity.CartEntity;
import com.bridgelabz.bookstoreapplication.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {
    @Query("SELECT c FROM CartEntity c WHERE c.user.user_id = :userId")
    List<CartEntity> findByUserId(Long userId);
}

