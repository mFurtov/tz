package com.example.tz.author.service;

import com.example.tz.author.dao.AuthorRepository;
import com.example.tz.author.dto.AuthorDtoRequest;
import com.example.tz.author.dto.AuthorDtoResponse;
import com.example.tz.author.mapper.AuthorMapper;
import com.example.tz.author.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorDtoResponse addAuthor(AuthorDtoRequest authorDtoRequest) {
        return AuthorMapper.authorMappingToAuthorDtoResponse(authorRepository.save(AuthorMapper.authorDtoRequestMappingToAuthor(authorDtoRequest)));
    }

    @Override
    public List<AuthorDtoResponse> getAllAuthor() {
        return AuthorMapper.authorMappingToAuthorDtoResponseList(authorRepository.findAll());
    }

    @Override
    public AuthorDtoResponse getAuthorById(Long id) {
        return AuthorMapper.authorMappingToAuthorDtoResponse(authorRepository.getById(id));
    }

    @Override
    public AuthorDtoResponse getAuthorByFirstName(String firstName) {
        return AuthorMapper.authorMappingToAuthorDtoResponse(authorRepository.findAuthorByFirstName(firstName));
    }

    @Override
    public AuthorDtoResponse updateAuthorById(Long id, AuthorDtoRequest authorDtoRequest) {
        Author author = authorRepository.getById(id);
        if (authorDtoRequest.getFirstName() != null && !authorDtoRequest.getFirstName().isBlank()){
            author.setFirstName(authorDtoRequest.getFirstName());
        }if (authorDtoRequest.getLastName() != null && !authorDtoRequest.getLastName().isBlank()){
            author.setLastName(authorDtoRequest.getLastName());
        }
        if (authorDtoRequest.getBirthDate() != null){
            author.setBirthDate(authorDtoRequest.getBirthDate());
        }
        authorRepository.save(author);
        return AuthorMapper.authorMappingToAuthorDtoResponse(author);
    }

    @Override
    public void dellAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
