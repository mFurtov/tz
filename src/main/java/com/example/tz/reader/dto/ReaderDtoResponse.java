package com.example.tz.reader.dto;

import com.example.tz.reader.model.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class ReaderDtoResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String birthDate;
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


    public ReaderDtoResponse(Long id, String firstName, String lastName, Gender gender, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = dataFormat(birthDate);
    }

    private String dataFormat(LocalDate dateTime) {
        return dateTime.format(formatter);
    }
}