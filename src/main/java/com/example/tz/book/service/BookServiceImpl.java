package com.example.tz.book.service;

import com.example.tz.book.dao.BookRepository;
import com.example.tz.book.dto.BookDto;
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

    @Override
    public BookDtoResponse addBook(BookDtoRequest bookDtoRequest) {
        return BookMapper.bookMappingToBookDto(bookRepository.save(BookMapper.bookDtoResponseMappingToBook(bookDtoRequest)));
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
        if (bookDto.getBookName() != null && !bookDto.getBookName().isBlank()){
            book.setBookName(bookDto.getBookName());
        }
        if (bookDto.getYearPublication() != null){
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
