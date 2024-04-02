package com.bridgelabz.bookstoreapplication.service.cart;

import com.bridgelabz.bookstoreapplication.dto.CartDTO;
import com.bridgelabz.bookstoreapplication.entity.CartEntity;
import com.bridgelabz.bookstoreapplication.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImp implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartEntity addToCart(CartDTO cartDTO) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setUser_id(cartDTO.getUser_id());
        cartEntity.setBook_id(cartDTO.getBook_id());
        cartEntity.setBook_quantity(cartDTO.getBook_quantity());
        cartEntity.setBook_price(cartDTO.getBook_price());
        return cartRepository.save(cartEntity);
    }

    @Override
    public CartEntity updateCart(Integer cartId, CartDTO cartDTO) {
        CartEntity cartEntity = cartRepository.findById(cartId).orElse(null);
        if (cartEntity != null) {
            cartEntity.setBook_quantity(cartDTO.getBook_quantity());
            cartEntity.setBook_price(cartDTO.getBook_price());
            return cartRepository.save(cartEntity);
        }
        return null;
    }

    @Override
    public void removeCart(Integer cartId) {
        cartRepository.deleteById(cartId);
    }
}
