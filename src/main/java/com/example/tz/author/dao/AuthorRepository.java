package com.example.tz.author.dao;

import com.example.tz.author.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorByFirstName(String firstName);

    @Query("SELECT a FROM Author a WHERE a.lastName = ?1 AND a.firstName = ?2")
    Author findAuthorByFullName(String lastName, String firstName);
}
