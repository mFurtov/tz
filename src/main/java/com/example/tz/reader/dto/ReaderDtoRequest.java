package com.example.tz.reader.dto;


import com.example.tz.reader.model.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Data
@NoArgsConstructor
public class ReaderDtoRequest {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public ReaderDtoRequest(String firstName, String lastName, Gender gender, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
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