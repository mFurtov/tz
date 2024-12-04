package com.example.tz.book.service;

import com.example.tz.author.dao.AuthorRepository;
import com.example.tz.author.model.Author;
import com.example.tz.book.dao.BookRepository;
import com.example.tz.book.dto.BookDtoRequest;
import com.example.tz.book.dto.BookDtoResponse;
import com.example.tz.book.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;
    @Mock
    private AuthorRepository authorRepository;
    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    void startUp(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void testAddBookSuccess() {
        BookDtoRequest bookDtoRequest = new BookDtoRequest();
        bookDtoRequest.setBookName("bookTest");
        bookDtoRequest.setYearPublication(LocalDate.of(1999,1,1));
        bookDtoRequest.setAuthors(Set.of("FirstNameTest LastNameTest"));

        Author author = new Author();
        author.setBooks(new HashSet<>());
        author.setId(1l);
        author.setBirthDate(LocalDate.of(1990, 1, 1));
        author.setLastName("LastNameTest");
        author.setFirstName("FirstNameTest");

        Book book = new Book();
        book.setBookName("bookTest");
        book.setYearPublication(LocalDate.of(1999, 1, 1));

//        Set<Author> authorSet = new HashSet<>();
//        authorSet.add(author);

        when(authorRepository
                .findAuthorByFullName("LastNameTest","FirstNameTest")).thenReturn(author);
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        BookDtoResponse bookDtoResponse = bookService.addBook(bookDtoRequest);

        assertNotNull(bookDtoResponse);
        verify(authorRepository,times(1)).findAuthorByFullName("LastNameTest","FirstNameTest");
        verify(bookRepository,times(1)).save(any(Book.class));
    }
    @Test
    void testAddBook_invalidAuthorFormat() {
        BookDtoRequest bookDtoRequest = new BookDtoRequest();
        bookDtoRequest.setAuthors(Collections.singleton("Некорректно"));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> bookService.addBook(bookDtoRequest));
        assertEquals("Некорректный формат строки. Ожидается: 'Фамилия Имя'.", exception.getMessage());
        verifyNoInteractions(bookRepository);
    }

    @Test
    void testGetAllBook() {
        // Arrange
        Book book = new Book();
        book.setBookName("bookTest");
        book.setYearPublication(LocalDate.of(1999, 1, 1));

        when(bookRepository.findAll()).thenReturn(Collections.singletonList(book));

        // Act
        List<BookDtoResponse> books = bookService.getAllBook();

        // Assert
        assertNotNull(books);
        assertEquals(1, books.size(),"Книги нет");
        verify(bookRepository, times(1)).findAll();
    }


    @Test
    void getAllBook() {
    }

    @Test
    void getBookById() {
    }

    @Test
    void getBookByName() {
    }

    @Test
    void updateBookById() {
    }

    @Test
    void dellBook() {
    }
}