package com.bridgelabz.bookstoreapplication.cart.service;

import com.bridgelabz.bookstoreapplication.cart.dto.CartDTO;
import com.bridgelabz.bookstoreapplication.cart.entity.CartEntity;
import com.bridgelabz.bookstoreapplication.user.entity.UserEntity;

import java.util.List;

public interface ICartService {
    void addToCart(CartDTO cartDTO);
    void removeFromCart(Long cartId);
    void removeByUserId(long userId);
    void updateQuantity(Long cartId, int quantity);
    List<CartDTO> getAllCartItemsForUser(long userId);
    List<CartDTO> getAllCartItems();

    CartDTO convertToDTO(CartEntity cartEntity);
}
