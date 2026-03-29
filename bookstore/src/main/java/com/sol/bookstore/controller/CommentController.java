package com.sol.bookstore.controller;

import com.sol.bookstore.Commenting;
import com.sol.bookstore.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

    @RestController
    @RequestMapping("/comments")
    public class CommentController {

        private List<Commenting> comments = new ArrayList<>();
        @Autowired
        private CommentRepository commentRepository;

        @PostMapping
        public void createComment(
                @RequestParam String comment,
                @RequestParam int userID,
                @RequestParam int bookID) {

            Commenting newComment = new Commenting(comment, userID, bookID);

            System.out.println("Comment created for book " + bookID);
        }
        @GetMapping
        public List<Commenting> getCommentsByBook(@RequestParam int bookID) {

            List<Commenting> result = new ArrayList<>();

            for (Commenting c : comments) {
                if (c.bookID == bookID) {
                    result.add(c);
                }
            }

            return result;
        }
    }


