package com.example.tz.reader.dao;

import com.example.tz.reader.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    @Query("""
                SELECT r 
                FROM Reader r
                JOIN Transaction t ON r.id = t.reader.id
                WHERE t.operationType = 'взятие'
                GROUP BY r.id
                ORDER BY COUNT(t.id) DESC
                LIMIT 1
            """)
    Reader findTopReader();

    @Query("""
                SELECT r 
                FROM Reader r
                JOIN Transaction t ON r.id = t.reader.id
                WHERE t.operationType = 'взятие'
                GROUP BY r.id
                ORDER BY COUNT(t.id) DESC
                LIMIT 1
            """)
    List<Reader> findReadersWithUnreturnedBooks();
}