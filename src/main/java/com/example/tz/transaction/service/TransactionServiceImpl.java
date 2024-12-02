package com.example.tz.transaction.service;


import com.example.tz.book.dao.BookRepository;
import com.example.tz.book.model.Book;
import com.example.tz.reader.dao.ReaderRepository;
import com.example.tz.reader.model.Reader;
import com.example.tz.transaction.dao.TransactionRepository;
import com.example.tz.transaction.dto.TransactionDtoRequest;
import com.example.tz.transaction.dto.TransactionDtoResponse;
import com.example.tz.transaction.mapper.TransactionMapper;
import com.example.tz.transaction.model.OperationType;
import com.example.tz.transaction.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public TransactionDtoResponse addTransaction(TransactionDtoRequest transactionDtoRequest) {
        Reader reader = readerRepository.getById(transactionDtoRequest.getReaderId());
        Book book = bookRepository.getById(transactionDtoRequest.getBookId());
        return TransactionMapper
                .transactionToTransactionDtoRequest(transactionRepository
                        .save(TransactionMapper.transactionDtoRequestToTransaction(transactionDtoRequest, reader, book)));
    }

    @Override
    public List<TransactionDtoResponse> getAllTransactions() {
        return TransactionMapper
                .transactionToTransactionDtoRequestList(transactionRepository.findAll());
    }

    @Override
    public TransactionDtoResponse getTransactionById(Long id) {
        return TransactionMapper.transactionToTransactionDtoRequest(transactionRepository.getById(id));
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public TransactionDtoResponse closeTransaction(Long id){
        Transaction transaction = transactionRepository.getById(id);
        transaction.setOperationType(OperationType.возврат);
        return TransactionMapper.transactionToTransactionDtoRequest(transactionRepository.save(transaction));
    }
}