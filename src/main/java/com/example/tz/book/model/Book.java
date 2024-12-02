package com.example.tz.book.model;

import com.example.tz.author.model.Author;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    private LocalDate yearPublication;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")

    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Author> authors = new HashSet<>();

    public Book(String bookName, LocalDate yearPublication) {
        this.bookName = bookName;
        this.yearPublication = yearPublication;
    }
    public Book(String bookName, LocalDate yearPublication,Set<Author> authors) {
        this.bookName = bookName;
        this.yearPublication = yearPublication;
        this.authors = authors;
    }
}