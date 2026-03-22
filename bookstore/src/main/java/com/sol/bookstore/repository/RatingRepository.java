package com.sol.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sol.bookstore.rating.Rating;

    public interface RatingRepository extends JpaRepository<Rating, Long> {
    }


