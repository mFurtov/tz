package com.example.tz.book.mapper;

import com.example.tz.author.model.Author;
import com.example.tz.book.dto.BookDtoRequest;
import com.example.tz.book.dto.BookDtoResponse;
import com.example.tz.book.model.Book;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class BookMapper {
    public Book bookDtoResponseMappingToBook(BookDtoRequest bookDtoRequest) {
        return new Book(bookDtoRequest.getBookName(), bookDtoRequest.getYearPublication());
    }

    public BookDtoResponse bookMappingToBookDto(Book book) {
        Set<String> author = book.getAuthors()
                .stream()
                .map(a -> a.getLastName() + " " + a.getFirstName())
                .collect(Collectors.toSet());

        return new BookDtoResponse(book.getId(), book.getBookName(), book.getYearPublication(), author);
    }

    public List<BookDtoResponse> bookMappingToBookDtoList(List<Book> book) {
        List<BookDtoResponse> bookDtoResponsesList = new ArrayList<>();
        for (Book b : book) {
            bookDtoResponsesList.add(bookMappingToBookDto(b));
        }
        return bookDtoResponsesList;
    }
}
