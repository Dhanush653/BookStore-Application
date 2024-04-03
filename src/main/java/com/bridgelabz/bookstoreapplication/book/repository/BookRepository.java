package com.bridgelabz.bookstoreapplication.book.repository;

import com.bridgelabz.bookstoreapplication.book.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
