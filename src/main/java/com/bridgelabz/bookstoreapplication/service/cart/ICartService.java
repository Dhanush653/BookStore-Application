package com.bridgelabz.bookstoreapplication.service.cart;

import com.bridgelabz.bookstoreapplication.dto.CartDTO;
import com.bridgelabz.bookstoreapplication.entity.CartEntity;

public interface ICartService {
    CartEntity addToCart(CartDTO cartDTO);
    CartEntity updateCart(Integer cartId, CartDTO cartDTO);
    void removeCart(Integer cartId);
}
