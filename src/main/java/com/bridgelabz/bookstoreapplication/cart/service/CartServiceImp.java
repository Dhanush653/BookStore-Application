package com.bridgelabz.bookstoreapplication.cart.service;

import com.bridgelabz.bookstoreapplication.book.entity.BookEntity;
import com.bridgelabz.bookstoreapplication.book.repository.BookRepository;
import com.bridgelabz.bookstoreapplication.cart.dto.CartDTO;
import com.bridgelabz.bookstoreapplication.cart.entity.CartEntity;
import com.bridgelabz.bookstoreapplication.cart.repository.CartRepository;
import com.bridgelabz.bookstoreapplication.user.entity.UserEntity;
import com.bridgelabz.bookstoreapplication.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImp implements ICartService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImp(UserRepository userRepository, BookRepository bookRepository, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void addToCart(CartDTO cartDTO) {
        UserEntity user = userRepository.findById(cartDTO.getUser_id())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        BookEntity book = bookRepository.findById(cartDTO.getBook_id())
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        CartEntity cartEntity = new CartEntity();
        cartEntity.setUser(user);
        cartEntity.setBook(book);
        cartEntity.setBook_quantity(cartDTO.getBook_quantity());
        cartEntity.setBook_price(book.getBook_price() * cartDTO.getBook_quantity());

        cartRepository.save(cartEntity);
    }

    @Override
    public void removeFromCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    public void removeByUserId(long userId) {
        List<CartEntity> cartEntities = cartRepository.findByUserId(userId);
        cartRepository.deleteAll(cartEntities);
    }

    @Override
    public void updateQuantity(Long cartId, int quantity) {
        CartEntity cartEntity = cartRepository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found"));

        BookEntity book = cartEntity.getBook();
        int bookPrice = book.getBook_price();

        cartEntity.setBook_quantity(quantity);
        cartEntity.setBook_price(bookPrice * quantity);
        cartRepository.save(cartEntity);
    }

    @Override
    public List<CartDTO> getAllCartItemsForUser(long userId) {
        List<CartEntity> cartEntities = cartRepository.findByUserId(userId);
        return cartEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CartDTO> getAllCartItems() {
        List<CartEntity> cartEntities = cartRepository.findAll();
        return cartEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CartDTO convertToDTO(CartEntity cartEntity) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCart_id(cartEntity.getCart_id());
        cartDTO.setUser_id(cartEntity.getUser().getUser_id());
        cartDTO.setBook_id(cartEntity.getBook().getBook_id());
        cartDTO.setBook_quantity(cartEntity.getBook_quantity());
        cartDTO.setBook_price(cartEntity.getBook_price());
        return cartDTO;
    }
}
