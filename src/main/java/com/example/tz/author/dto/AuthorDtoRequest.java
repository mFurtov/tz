package com.example.tz.author.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Data
@NoArgsConstructor
public class AuthorDtoRequest {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public AuthorDtoRequest(String firstName, String lastName, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = dataFormat(birthDate);
    }

    public LocalDate dataFormat(String yearPublication) {
        try {
            return LocalDate.parse(yearPublication, FORMATTER);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Корректный формат dd.MM.yyyy");
        }
    }

}
