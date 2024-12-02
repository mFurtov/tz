package com.example.tz.book.controller;

import com.example.tz.book.dto.BookDtoRequest;
import com.example.tz.book.dto.BookDtoResponse;
import com.example.tz.book.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/books")
@Tag(name = "Book Controller", description = "Управление книгами в библиотеке")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    @Operation(
            summary = "Добавить книгу",
            description = "Добавляет новую книгу в библиотеку."
    )
    public BookDtoResponse addBook(@RequestBody BookDtoRequest bookDtoRequest) {
        return bookService.addBook(bookDtoRequest);
    }

    @GetMapping
    @Operation(
            summary = "Получить список книг",
            description = "Возвращает список всех книг, зарегистрированных в библиотеке."
    )
    public List<BookDtoResponse> getBook() {
        return bookService.getAllBook();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получить книгу по ID",
            description = "Возвращает информацию о книге по указанному идентификатору."
    )
    public BookDtoResponse getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/search")
    @Operation(
            summary = "Найти книгу по названию",
            description = "Возвращает книгу по указанному названию."
    )
    public BookDtoResponse getBookByName(@RequestParam("bookname") String bookName) {
        return bookService.getBookByName(bookName);
    }

    @PatchMapping("/{id}")
    @Operation(
            summary = "Обновить информацию о книге",
            description = "Обновляет данные о книге по указанному идентификатору."
    )
    public BookDtoResponse updateBookById(@PathVariable Long id, @RequestBody BookDtoRequest bookDto) {
        return bookService.updateBookById(id, bookDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Удалить книгу",
            description = "Удаляет книгу из библиотеки по указанному идентификатору."
    )
    public void dellBook(@PathVariable Long id) {
        bookService.dellBook(id);
    }

}
