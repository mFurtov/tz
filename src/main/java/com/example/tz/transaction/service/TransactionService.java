package com.example.tz.transaction.service;

import com.example.tz.transaction.dto.TransactionDtoRequest;
import com.example.tz.transaction.dto.TransactionDtoResponse;

import java.util.List;

public interface TransactionService {
    TransactionDtoResponse addTransaction(TransactionDtoRequest dto);

    List<TransactionDtoResponse> getAllTransactions();

    TransactionDtoResponse getTransactionById(Long id);

    void deleteTransaction(Long id);

    TransactionDtoResponse closeTransaction(Long id);
}
