package com.example.tz.author.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class AuthorDtoResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public AuthorDtoResponse(Long id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = dataFormat(birthDate);
    }

    private String dataFormat(LocalDate dateTime) {
        return dateTime.format(formatter);
    }
}
