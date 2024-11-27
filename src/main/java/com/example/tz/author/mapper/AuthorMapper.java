package com.example.tz.author.mapper;

import com.example.tz.author.dto.AuthorDtoRequest;
import com.example.tz.author.dto.AuthorDtoResponse;
import com.example.tz.author.model.Author;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class AuthorMapper {
    public Author authorDtoRequestMappingToAuthor(AuthorDtoRequest authorDtoRequest) {
        return new Author(authorDtoRequest.getFirstName(), authorDtoRequest.getLastName(), authorDtoRequest.getBirthDate());
    }

    public AuthorDtoResponse authorMappingToAuthorDtoResponse(Author author) {
        return new AuthorDtoResponse(author.getId(), author.getFirstName(), author.getLastName(), author.getBirthDate());
    }

    public List<AuthorDtoResponse> authorMappingToAuthorDtoResponseList(List<Author> author) {
        List<AuthorDtoResponse> authorDtoResponsesList = new ArrayList<>();
        for (Author a : author){
            authorDtoResponsesList.add(authorMappingToAuthorDtoResponse(a));
        }
        return authorDtoResponsesList;
    }

}

