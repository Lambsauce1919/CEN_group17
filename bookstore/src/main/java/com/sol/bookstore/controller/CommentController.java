package com.sol.bookstore.controller;

import com.sol.bookstore.Commenting;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/comments")
    public class CommentController {

        @PostMapping
        public void createComment(
                @RequestParam String comment,
                @RequestParam int userID,
                @RequestParam int bookID) {

            Commenting newComment = new Commenting(comment, userID, bookID);

            System.out.println("Comment created for book " + bookID);
        }
    }


