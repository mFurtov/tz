package com.example.tz.book.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Set;


@Data
@NoArgsConstructor
public class BookDtoRequest {
    private String bookName;
    private LocalDate yearPublication;
    private Set<String> authors;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public BookDtoRequest(String bookName, String yearPublication) {
        this.bookName = bookName;
        this.yearPublication = dataFormat(yearPublication);
    }

    public LocalDate dataFormat(String yearPublication) {
        try {
            return LocalDate.parse(yearPublication, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Корректный формат dd.MM.yyyy");
        }
    }

}
