package com.sol.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sol.bookstore.Commenting;

public interface CommentRepository extends JpaRepository<Commenting, Long> {

}
