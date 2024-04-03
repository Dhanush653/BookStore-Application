package com.bridgelabz.bookstoreapplication.book.controller;

import com.bridgelabz.bookstoreapplication.book.entity.BookEntity;
import com.bridgelabz.bookstoreapplication.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    IBookService bookservice;

    @GetMapping("/books")
    List<BookEntity> findallbooks(){
        return bookservice.findallbooks();
    }
    @GetMapping("/book/{id}")
    BookEntity findBookByID(@PathVariable int id){
        return bookservice.findBookByID(id);
    }
    @PostMapping("/book/add")
    BookEntity addbook(@RequestBody BookEntity book) {
        return bookservice.addbook(book);
    }
    @PutMapping("/book/update/{id}")
    BookEntity updatebook(@PathVariable int id){
        return bookservice.updatebook(id);
    }
    @DeleteMapping("/book/delete/{id}")
    void deletebook(@PathVariable int id){
        bookservice.deletebook(id);
    }
}
