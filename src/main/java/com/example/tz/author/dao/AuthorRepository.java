package com.example.tz.author.dao;

import com.example.tz.author.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
   Author findAuthorByFirstName(String firstName);
}
