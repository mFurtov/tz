package com.example.tz.book.controller;

import com.example.tz.book.dto.BookDtoRequest;
import com.example.tz.book.dto.BookDtoResponse;
import com.example.tz.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public BookDtoResponse addBook(@RequestBody BookDtoRequest bookDtoRequest) {
        return bookService.addBook(bookDtoRequest);
    }

    @GetMapping
    public List<BookDtoResponse> getBook() {
        return bookService.getAllBook();
    }

    @GetMapping("/{id}")
    public BookDtoResponse getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/search")
    public BookDtoResponse getBookByName(@RequestParam("bookname") String bookName) {
        return bookService.getBookByName(bookName);
    }

    @PatchMapping("/{id}")
    public BookDtoResponse updateBookById(@PathVariable Long id, @RequestBody BookDtoRequest bookDto) {
        return bookService.updateBookById(id, bookDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void dellBook(@PathVariable Long id) {
        bookService.dellBook(id);
    }

}
