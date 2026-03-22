package com.sol.bookstore.controller;

import com.sol.bookstore.rating.Rating;
import com.sol.bookstore.repository.RatingRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingRepository ratingRepository;

    public RatingController(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @PostMapping
    public ResponseEntity<Void> createRating(@RequestBody Rating rating) {

        // Validate rating is between 1 and 5
        if (rating.getRating() < 1 || rating.getRating() > 5) {
            return ResponseEntity.badRequest().build();
        }

        ratingRepository.save(rating);

        return ResponseEntity.status(201).build();
    }
}
