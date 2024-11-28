package com.example.tz.transaction.dto;

import com.example.tz.transaction.model.OperationType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


@Data
@NoArgsConstructor
public class TransactionDtoRequest {
    private OperationType operationType;
    private LocalDateTime operationDate;
    private Long readerId;
    private Long bookId;

    public TransactionDtoRequest(Long bookId, Long readerId, OperationType operationType) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.operationDate = LocalDateTime.now();
        this.operationType = operationType;
    }

}

