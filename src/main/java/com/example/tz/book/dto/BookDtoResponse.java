package com.example.tz.book.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class BookDtoResponse {
    private Long id;
    private String bookName;
    private String yearPublication;
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public BookDtoResponse(Long id, String bookName, LocalDate yearPublication) {
        this.id = id;
        this.bookName = bookName;
        this.yearPublication = dataFormat(yearPublication);
    }

    private String dataFormat(LocalDate dateTime) {
        return dateTime.format(formatter);
    }
}
