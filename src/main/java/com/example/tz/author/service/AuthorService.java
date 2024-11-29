package com.example.tz.author.service;

import com.example.tz.author.dto.AuthorDtoRequest;
import com.example.tz.author.dto.AuthorDtoResponse;

import java.time.LocalDate;
import java.util.List;

public interface AuthorService {
    AuthorDtoResponse addAuthor(AuthorDtoRequest authorDtoRequest);

    List<AuthorDtoResponse> getAllAuthor();

    AuthorDtoResponse getAuthorById(Long id);

    AuthorDtoResponse getAuthorByFirstName(String firstName);

    AuthorDtoResponse updateAuthorById(Long id, AuthorDtoRequest authorDtoRequest);

    List<AuthorDtoResponse> getPopularAuthor(LocalDate startDate, LocalDate endDate);

    void dellAuthor(Long id);

}
