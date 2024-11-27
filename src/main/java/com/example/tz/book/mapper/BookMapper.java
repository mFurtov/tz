package com.example.tz.book.mapper;

import com.example.tz.book.dto.BookDtoRequest;
import com.example.tz.book.dto.BookDtoResponse;
import com.example.tz.book.model.Book;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class BookMapper {
    public Book bookDtoResponseMappingToBook(BookDtoRequest bookDtoRequest) {
        return new Book(bookDtoRequest.getBookName(), bookDtoRequest.getYearPublication());
    }

    public BookDtoResponse bookMappingToBookDto(Book book) {
        return new BookDtoResponse(book.getId(), book.getBookName(), book.getYearPublication());
    }

    public List<BookDtoResponse> bookMappingToBookDtoList(List<Book> book) {
        List<BookDtoResponse> bookDtoResponsesList = new ArrayList<>();
        for (Book b : book) {
            bookDtoResponsesList.add(bookMappingToBookDto(b));
        }
        return bookDtoResponsesList;
    }
}
