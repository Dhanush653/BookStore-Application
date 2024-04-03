package com.bridgelabz.bookstoreapplication.book.service;

import com.bridgelabz.bookstoreapplication.book.entity.BookEntity;

import java.util.List;

public interface IBookService {
    List<BookEntity> findallbooks();
    BookEntity findBookByID(int id);
    BookEntity addbook(BookEntity book);
    BookEntity updatebook(int id);
    void deletebook(int id);
}
