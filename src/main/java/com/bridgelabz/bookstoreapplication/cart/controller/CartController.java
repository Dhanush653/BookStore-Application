package com.bridgelabz.bookstoreapplication.cart.controller;

import com.bridgelabz.bookstoreapplication.cart.dto.CartDTO;
import com.bridgelabz.bookstoreapplication.cart.service.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartServiceImp cartService;

    @Autowired
    public CartController(CartServiceImp cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public void addToCart(@RequestBody CartDTO cartDTO) {
        cartService.addToCart(cartDTO);
    }

    @DeleteMapping("/remove/{cartId}")
    public void removeFromCart(@PathVariable Long cartId) {
        cartService.removeFromCart(cartId);
    }

    @DeleteMapping("/removeByUser/{userId}")
    public void removeByUserId(@PathVariable long userId) {
        cartService.removeByUserId(userId);
    }

    @PutMapping("/updateQuantity/{cartId}/{quantity}")
    public void updateQuantity(@PathVariable Long cartId, @PathVariable int quantity) {
        cartService.updateQuantity(cartId, quantity);
    }

    @GetMapping("/allForUser/{userId}")
    public List<CartDTO> getAllCartItemsForUser(@PathVariable long userId) {
        return cartService.getAllCartItemsForUser(userId);
    }
    @GetMapping("/all")
    public List<CartDTO> getAllCartItems() {
        return cartService.getAllCartItems();
    }
}
