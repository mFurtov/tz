package com.example.tz.transaction.dto;

import com.example.tz.transaction.model.OperationType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class TransactionDtoResponse {
    private Long id;
    private OperationType operationType;
    private String operationDate;
    private Long readerId;
    private Long bookId;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");


    public TransactionDtoResponse(Long id, OperationType operationType, LocalDateTime operationDate, Long readerId, Long bookId) {
        this.id = id;
        this.operationType = operationType;
        this.operationDate = dataFormat(operationDate);
        this.readerId = readerId;
        this.bookId = bookId;
    }

    private String dataFormat(LocalDateTime operationDate) {
        return operationDate.format(FORMATTER);
    }
}
