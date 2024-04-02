package com.bridgelabz.bookstoreapplication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

@Entity
@Table(name = "Cart_table")
public class CartEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cart_id;
    @Column(name = "userid")
    private int user_id;
    @Column(name = "bookid")
    private int book_id;
    @Column(name = "quantity")
    private int book_quantity;
    @Column(name = "price")
    private int book_price;

}
