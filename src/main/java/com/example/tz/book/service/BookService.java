package com.example.tz.book.service;

import com.example.tz.book.dto.BookDtoRequest;
import com.example.tz.book.dto.BookDtoResponse;

import java.util.List;

public interface BookService {
    BookDtoResponse addBook(BookDtoRequest bookDtoRequest);

    List<BookDtoResponse> getAllBook();

    BookDtoResponse getBookById(Long id);

    BookDtoResponse getBookByName(String name);

    BookDtoResponse updateBookById(Long id, BookDtoRequest bookDto);

    void dellBook(Long id);
}
