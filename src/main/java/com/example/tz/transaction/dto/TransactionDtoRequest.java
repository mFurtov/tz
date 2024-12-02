package com.example.tz.transaction.dto;

import com.example.tz.transaction.model.OperationType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransactionDtoRequest {
    private OperationType operationType;
    private Long readerId;
    private Long bookId;

    public TransactionDtoRequest(Long bookId, Long readerId, OperationType operationType) {
        this.bookId = bookId;
        this.readerId = readerId;
        this.operationType = operationType;
    }

}

