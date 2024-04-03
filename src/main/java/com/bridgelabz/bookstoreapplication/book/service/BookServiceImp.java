package com.bridgelabz.bookstoreapplication.book.service;

import com.bridgelabz.bookstoreapplication.book.entity.BookEntity;
import com.bridgelabz.bookstoreapplication.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements IBookService {
    @Autowired
    BookRepository bookrepo;

    @Override
    public List<BookEntity> findallbooks(){
        return bookrepo.findAll();
    }
    @Override
    public BookEntity findBookByID(int id){
        return bookrepo.findById(id).get();
    }

    @Override
    public BookEntity addbook(BookEntity book) {
        return bookrepo.save(book);
    }

    @Override
    public BookEntity updatebook(int id) {
        BookEntity book = bookrepo.findById(id).get();
        book.setBook_author("Ram");
        book.setBook_name("Physics");
        book.setBook_description("This is a physics book");
        book.setBook_logo("5.jpa");
        return(book);
    }

    @Override
    public void deletebook(int id) {
        BookEntity delbook = bookrepo.findById(id).get();
        bookrepo.delete(delbook);
    }
}
