package com.example.tz.author.dao;

import com.example.tz.author.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorByFirstName(String firstName);

    @Query("SELECT a FROM Author a WHERE a.lastName = ?1 AND a.firstName = ?2")
    Author findAuthorByFullName(String lastName, String firstName);

    @Query("""
                SELECT a 
                FROM Transaction t
                JOIN t.book b
                JOIN b.authors a
                WHERE t.operationType = 'взятие'
                  AND t.operationDate BETWEEN ?1 AND ?2
                GROUP BY a
                ORDER BY COUNT(t.id) DESC
            """)
    List<Author> findPopularAuthorBetweenDates(LocalDateTime startDate, LocalDateTime endDate);

}
