package com.sol.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sol.bookstore.Commenting;
import org.springframework.beans.factory.annotation.Autowired;
import com.sol.bookstore.repository.CommentRepository;

public interface CommentRepository extends JpaRepository<Commenting, Long> {

}
