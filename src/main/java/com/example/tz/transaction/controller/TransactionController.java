package com.example.tz.transaction.controller;

import com.example.tz.transaction.dto.TransactionDtoRequest;
import com.example.tz.transaction.dto.TransactionDtoResponse;
import com.example.tz.transaction.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library/transactions")
@Tag(name = "Transaction Controller", description = "Управление транзакциями в библиотеке")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    @Operation(
            summary = "Создать новую транзакцию",
            description = "Создаёт новую транзакцию для книги и читателя."
    )
    public TransactionDtoResponse addTransaction(@RequestBody TransactionDtoRequest transactionDtoRequest) {
        return transactionService.addTransaction(transactionDtoRequest);
    }

    @GetMapping
    @Operation(
            summary = "Получить все транзакции",
            description = "Возвращает список всех транзакций в библиотеке."
    )
    public List<TransactionDtoResponse> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получить транзакцию по ID",
            description = "Возвращает информацию о транзакции по указанному идентификатору."
    )
    public TransactionDtoResponse getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удалить транзакцию",
            description = "Удаляет транзакцию по указанному идентификатору."
    )
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}