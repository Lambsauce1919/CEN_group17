package com.example.demo.bookdetails.repo;

import com.example.demo.bookdetails.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    List<Book> findByAuthor_AuthorId(Integer authorId);
}

