package com.bridgelabz.bookstoreapplication.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartDTO {
    private int book_quantity;
    private int book_price;
    private int book_id;
    private long user_id;
    private long cart_id;
}
