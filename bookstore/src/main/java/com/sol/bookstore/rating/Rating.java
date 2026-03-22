package com.sol.bookstore.rating;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Rating {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

            private Long userId;
            private Long bookId;

            private int rating;

            private LocalDateTime createdAt;

            public Rating() {
                this.createdAt = LocalDateTime.now();
            }

            // Getters and Setters

            public Long getId() {
                return id;
            }

            public Long getUserId() {
                return userId;
            }

            public void setUserId(Long userId) {
                this.userId = userId;
            }

            public Long getBookId() {
                return bookId;
            }

            public void setBookId(Long bookId) {
                this.bookId = bookId;
            }

            public int getRating() {
                return rating;
            }

            public void setRating(int rating) {
                this.rating = rating;
            }

            public LocalDateTime getCreatedAt() {
                return createdAt;
            }
        }

