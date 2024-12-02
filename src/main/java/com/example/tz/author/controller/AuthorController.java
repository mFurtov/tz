package com.example.tz.author.controller;

import com.example.tz.author.dto.AuthorDtoRequest;
import com.example.tz.author.dto.AuthorDtoResponse;
import com.example.tz.author.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/author")
@Tag(name = "Author Controller", description = "Управление авторами")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    @Operation(
            summary = "Добавить нового автора",
            description = "Добавляет нового автора в библиотеку."
    )
    public AuthorDtoResponse addAuthor(@RequestBody AuthorDtoRequest authorDtoRequest) {
        return authorService.addAuthor(authorDtoRequest);
    }

    @GetMapping
    @Operation(
            summary = "Получить всех авторов",
            description = "Возвращает список всех авторов, зарегистрированных в библиотеке."
    )
    public List<AuthorDtoResponse> getAllAuthor() {
        return authorService.getAllAuthor();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получить автора по ID",
            description = "Возвращает информацию об авторе по указанному идентификатору."
    )
    public AuthorDtoResponse getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/search")
    @Operation(
            summary = "Найти автора по имени",
            description = "Возвращает автора по указанному имени."
    )
    public AuthorDtoResponse getAuthorByLastName(@RequestParam("firstname") String firstName) {
        return authorService.getAuthorByFirstName(firstName);
    }

    @PatchMapping("/{id}")
    @Operation(
            summary = "Обновить информацию об авторе",
            description = "Обновляет информацию об авторе по указанному идентификатору."
    )
    public AuthorDtoResponse updateAuthorById(@PathVariable Long id, @RequestBody AuthorDtoRequest authorDtoRequest) {
        return authorService.updateAuthorById(id, authorDtoRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Удалить автора",
            description = "Удаляет автора из библиотеки по указанному идентификатору."
    )
    public void dellAuthor(@PathVariable Long id) {
        authorService.dellAuthor(id);
    }
}
