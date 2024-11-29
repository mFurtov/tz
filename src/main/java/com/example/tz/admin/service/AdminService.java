package com.example.tz.admin.service;

import com.example.tz.author.dto.AuthorDtoResponse;
import com.example.tz.reader.dto.ReaderDtoResponse;
import com.example.tz.transaction.dto.TransactionDtoResponse;

import java.time.LocalDate;
import java.util.List;


public interface AdminService {

    TransactionDtoResponse addTransaction(Long idReader, Long idBook);
    List<AuthorDtoResponse> getPopularAuthor(LocalDate startDate, LocalDate endDate);
    ReaderDtoResponse getTopReader();
    List<ReaderDtoResponse> getTopReaderDidntReturn();
}
