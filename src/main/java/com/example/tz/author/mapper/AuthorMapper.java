package com.example.tz.author.mapper;

import com.example.tz.author.dto.AuthorDtoRequest;
import com.example.tz.author.dto.AuthorDtoResponse;
import com.example.tz.author.model.Author;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class AuthorMapper {
    public Author authorDtoRequestMappingToAuthor(AuthorDtoRequest authorDtoRequest) {
        return new Author(authorDtoRequest.getFirstName(), authorDtoRequest.getLastName(), authorDtoRequest.getBirthDate());
    }

    public AuthorDtoResponse authorMappingToAuthorDtoResponse(Author author) {
        List<String> bookNames = author.getBooks()
                .stream()
                .map(book -> book.getBookName())
                .collect(Collectors.toList());

        return new AuthorDtoResponse(author.getId(), author.getFirstName(), author.getLastName(), author.getBirthDate(), bookNames);
    }

    public List<AuthorDtoResponse> authorMappingToAuthorDtoResponseList(List<Author> author) {
        List<AuthorDtoResponse> authorDtoResponsesList = new ArrayList<>();
        for (Author a : author) {
            authorDtoResponsesList.add(authorMappingToAuthorDtoResponse(a));
        }
        return authorDtoResponsesList;
    }

}

