package com.example.tz.transaction.model;

import com.example.tz.book.model.Book;
import com.example.tz.reader.model.Reader;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type")
    private OperationType operationType;

    @Column(name = "operation_date")
    private LocalDateTime operationDate;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Transaction(OperationType operationType, Reader reader, Book book) {
        this.operationType = operationType;
        this.reader = reader;
        this.book = book;
    }
}