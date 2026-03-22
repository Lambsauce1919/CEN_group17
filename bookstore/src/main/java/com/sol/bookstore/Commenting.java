package com.sol.bookstore;

import java.time.LocalDateTime;

public class Commenting {

    public String comment;
    public int userID;
    public int bookID;
    public LocalDateTime timestamp;

    public Commenting(String comment, int userID, int bookID) {

            this.comment = comment;
            this.userID = userID;
            this.bookID = bookID;
            this.timestamp = LocalDateTime.now();
        }
    }

    // As a team member, I want to create a feature that allows the user to comment on a book
    // critera: User is able to successfully create a comment
    // critera: When the comment is created it will have a date and timestamp next to it
    // Acceptance test: showcase a comment using dummy data
    // Acceptance test: demo video recorded

