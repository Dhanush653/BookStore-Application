package com.bridgelabz.bookstoreapplication.cart.entity;

import com.bridgelabz.bookstoreapplication.book.entity.BookEntity;
import com.bridgelabz.bookstoreapplication.user.entity.UserEntity;
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
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cart_id;
//    @Column(name = "userid")
//    private long user_id;
//    @Column(name = "bookid")
//    private int book_id;
    @Column(name = "quantity")
    private int book_quantity;
    @Column(name = "price")
    private int book_price;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
