package com.example.tz.book.dao;

import com.example.tz.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByYearPublication(LocalDate year);
    Book findByBookName(String bookName);
}