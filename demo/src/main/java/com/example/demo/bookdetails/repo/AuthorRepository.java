package com.example.demo.bookdetails.repo;

import com.example.demo.bookdetails.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> { }

