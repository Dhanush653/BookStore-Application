package com.bridgelabz.bookstoreapplication.controller;

import com.bridgelabz.bookstoreapplication.dto.CartDTO;
import com.bridgelabz.bookstoreapplication.entity.CartEntity;
import com.bridgelabz.bookstoreapplication.service.cart.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @PostMapping("/add")
    public CartEntity addToCart(@RequestBody CartDTO cartDTO) {
        return cartService.addToCart(cartDTO);
    }

    @PutMapping("/update/{cartId}")
    public CartEntity updateCart(@PathVariable Integer cartId, @RequestBody CartDTO cartDTO) {
        return cartService.updateCart(cartId, cartDTO);
    }

    @DeleteMapping("/remove/{cartId}")
    public void removeCart(@PathVariable Integer cartId) {
        cartService.removeCart(cartId);
    }
}
