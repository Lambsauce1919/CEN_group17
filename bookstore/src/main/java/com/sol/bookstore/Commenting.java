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

