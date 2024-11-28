package com.example.tz.transaction.controller;

import com.example.tz.transaction.dto.TransactionDtoRequest;
import com.example.tz.transaction.dto.TransactionDtoResponse;
import com.example.tz.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public TransactionDtoResponse addTransaction(@RequestBody TransactionDtoRequest transactionDtoRequest) {
        return transactionService.addTransaction(transactionDtoRequest);
    }

    @GetMapping
    public List<TransactionDtoResponse> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public TransactionDtoResponse getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}