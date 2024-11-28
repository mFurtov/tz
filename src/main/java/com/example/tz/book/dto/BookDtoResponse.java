package com.example.tz.book.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Data
@NoArgsConstructor
public class BookDtoResponse {
    private Long id;
    private String bookName;
    private String yearPublication;
    private Set<String> authors;
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public BookDtoResponse(Long id, String bookName, LocalDate yearPublication, Set<String> authors) {
        this.id = id;
        this.bookName = bookName;
        this.yearPublication = dataFormat(yearPublication);
        this.authors = authors;
    }

    private String dataFormat(LocalDate dateTime) {
        return dateTime.format(formatter);
    }
}
