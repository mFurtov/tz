package com.example.tz.transaction.mapper;

import com.example.tz.book.model.Book;
import com.example.tz.reader.model.Reader;
import com.example.tz.transaction.dto.TransactionDtoRequest;
import com.example.tz.transaction.dto.TransactionDtoResponse;
import com.example.tz.transaction.model.Transaction;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class TransactionMapper {
    public Transaction transactionDtoRequestToTransaction(TransactionDtoRequest transactionDtoRequest, Reader reader, Book book) {
        return new Transaction(transactionDtoRequest.getOperationType(), transactionDtoRequest.getOperationDate(), reader, book);
    }

    public TransactionDtoResponse transactionToTransactionDtoRequest(Transaction transaction) {
        return new TransactionDtoResponse(transaction.getId(), transaction.getOperationType(), transaction.getOperationDate(), transaction.getReader().getId(), transaction.getBook().getId());
    }
    public List<TransactionDtoResponse> transactionToTransactionDtoRequestList(List<Transaction> transaction) {
        List<TransactionDtoResponse> transactionDtoResponseList = new ArrayList<>();
        for (Transaction t : transaction) {
            transactionDtoResponseList.add(transactionToTransactionDtoRequest(t));
        }
        return transactionDtoResponseList;
    }
}
