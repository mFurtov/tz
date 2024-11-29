package com.example.tz.admin.service;

import com.example.tz.author.dto.AuthorDtoResponse;
import com.example.tz.author.service.AuthorService;
import com.example.tz.reader.dto.ReaderDtoResponse;
import com.example.tz.transaction.dto.TransactionDtoRequest;
import com.example.tz.transaction.dto.TransactionDtoResponse;
import com.example.tz.transaction.model.OperationType;
import com.example.tz.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private AuthorService authorService;


    @Override
    public TransactionDtoResponse addTransaction(Long idReader, Long idBook) {
        TransactionDtoRequest transactionDtoRequest = new TransactionDtoRequest(idBook,idReader, OperationType.взятие);
        return transactionService.addTransaction(transactionDtoRequest);
    }

    @Override
    public List<AuthorDtoResponse> getPopularAuthor(LocalDate startDate, LocalDate endDate) {
        return authorService.getPopularAuthor(startDate, endDate);
    }

    @Override
    public ReaderDtoResponse getTopReader() {
        return null;
    }

    @Override
    public List<ReaderDtoResponse> getTopReaderDidntReturn() {
        return List.of();
    }
}
