package com.bridgelabz.bookstoreapplication.service.book;

import com.bridgelabz.bookstoreapplication.entity.BookEntity;

import java.util.List;

public interface IBookService {
    List<BookEntity> findallbooks();
    BookEntity findBookByID(int id);
    BookEntity addbook(BookEntity book);
    BookEntity updatebook(int id);
    void deletebook(int id);
}
