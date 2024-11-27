package com.example.tz.author.controller;

import com.example.tz.author.dto.AuthorDtoRequest;
import com.example.tz.author.dto.AuthorDtoResponse;
import com.example.tz.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public AuthorDtoResponse addAuthor(@RequestBody AuthorDtoRequest authorDtoRequest) {
        return authorService.addAuthor(authorDtoRequest);
    }

    @GetMapping
    public List<AuthorDtoResponse> getAllAuthor() {
        return authorService.getAllAuthor();
    }

    @GetMapping("/{id}")
    public AuthorDtoResponse getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/search")
    public AuthorDtoResponse getAuthorByLastName(@RequestParam("firstname") String firstName) {
        return authorService.getAuthorByFirstName(firstName);
    }

    @PatchMapping("/{id}")
    public AuthorDtoResponse updateAuthorById(@PathVariable Long id, @RequestBody AuthorDtoRequest authorDtoRequest) {
        return authorService.updateAuthorById(id, authorDtoRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void dellAuthor(@PathVariable Long id) {
        authorService.dellAuthor(id);
    }
}
