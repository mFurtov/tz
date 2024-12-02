package com.example.tz.author.service;

import com.example.tz.author.dao.AuthorRepository;
import com.example.tz.author.dto.AuthorDtoRequest;
import com.example.tz.author.dto.AuthorDtoResponse;
import com.example.tz.author.mapper.AuthorMapper;
import com.example.tz.author.model.Author;
import com.example.tz.book.dao.BookRepository;
import com.example.tz.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public AuthorDtoResponse addAuthor(AuthorDtoRequest authorDtoRequest) {

        Author author = AuthorMapper.authorDtoRequestMappingToAuthor(authorDtoRequest);

        if (authorDtoRequest.getBooks() != null && !authorDtoRequest.getBooks().isEmpty()) {
            for (String bookName : authorDtoRequest.getBooks()) {
                Book book = bookRepository.findByBookName(bookName);
                author.getBooks().add(book);
                book.getAuthors().add(author);
            }
        }

        return AuthorMapper.authorMappingToAuthorDtoResponse(authorRepository.save(author));
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
        if (authorDtoRequest.getFirstName() != null && !authorDtoRequest.getFirstName().isBlank()) {
            author.setFirstName(authorDtoRequest.getFirstName());
        }
        if (authorDtoRequest.getLastName() != null && !authorDtoRequest.getLastName().isBlank()) {
            author.setLastName(authorDtoRequest.getLastName());
        }
        if (authorDtoRequest.getBirthDate() != null) {
            author.setBirthDate(authorDtoRequest.getBirthDate());
        }
        authorRepository.save(author);
        return AuthorMapper.authorMappingToAuthorDtoResponse(author);
    }

    @Override
    public void dellAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<AuthorDtoResponse> getPopularAuthor(LocalDate startDate, LocalDate endDate) {
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(LocalTime.MAX);

        List<Author> popularAuthors = authorRepository.findPopularAuthorBetweenDates(startDateTime, endDateTime);

        return AuthorMapper.authorMappingToAuthorDtoResponseList(popularAuthors);
    }
}
