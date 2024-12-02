package com.example.tz.book.service;

import com.example.tz.author.dao.AuthorRepository;
import com.example.tz.author.model.Author;
import com.example.tz.book.dao.BookRepository;
import com.example.tz.book.dto.BookDtoRequest;
import com.example.tz.book.dto.BookDtoResponse;
import com.example.tz.book.mapper.BookMapper;
import com.example.tz.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public BookDtoResponse addBook(BookDtoRequest bookDtoRequest) {
        Book book = BookMapper.bookDtoResponseMappingToBook(bookDtoRequest);
        if (bookDtoRequest.getAuthors() != null && !bookDtoRequest.getAuthors().isEmpty()) {
            for (String a : bookDtoRequest.getAuthors()) {
                String[] parts = a.split(" ", 2);
                if (parts.length < 2) {
                    throw new IllegalArgumentException("Некорректный формат строки. Ожидается: 'Фамилия Имя'.");
                }
                String lastName = parts[0];
                String firstName = parts[1];
                Author author = authorRepository.findAuthorByFullName(firstName, lastName);
                book.getAuthors().add(author);
                author.getBooks().add(book);
            }
        }
        return BookMapper.bookMappingToBookDto(bookRepository.save(book));
    }

    @Override
    public List<BookDtoResponse> getAllBook() {
        return BookMapper.bookMappingToBookDtoList(bookRepository.findAll());
    }

    @Override
    public BookDtoResponse getBookById(Long id) {
        return BookMapper.bookMappingToBookDto(bookRepository.getById(id));
    }

    @Override
    public BookDtoResponse getBookByName(String name) {
        return BookMapper.bookMappingToBookDto(bookRepository.findByBookName(name));
    }

    @Override
    public BookDtoResponse updateBookById(Long id, BookDtoRequest bookDto) {
        Book book = bookRepository.getById(id);
        if (bookDto.getBookName() != null && !bookDto.getBookName().isBlank()) {
            book.setBookName(bookDto.getBookName());
        }
        if (bookDto.getYearPublication() != null) {
            book.setYearPublication(bookDto.getYearPublication());
        }
        bookRepository.save(book);
        return BookMapper.bookMappingToBookDto(book);
    }

    @Override
    public void dellBook(Long id) {
        bookRepository.deleteById(id);
    }
}
