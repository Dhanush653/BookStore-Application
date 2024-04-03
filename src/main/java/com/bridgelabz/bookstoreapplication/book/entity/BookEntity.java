package com.bridgelabz.bookstoreapplication.book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Book_details")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int book_id;

    @Column(name = "name")
    private String book_name;

    @Column(name = "author")
    private String book_author;

    @Column(name="description")
    private String book_description;

    @Column(name = "logo")
    private String book_logo;

    @Column(name = "price")
    private int book_price;

    @Column(name = "quantity")
    private int book_quantity;
}
