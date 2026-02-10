package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.Wishlist;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wishlists")
public class WishlistController{

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public void createWishlist(@RequestParam String name, @RequestParam int userID) {
        User owner = userRepository.findById(userID).orElse(null);
        if (owner == null) {
            Wishlist wishlist = new Wishlist(name, owner);
            wishlistRepository.save(wishlist);
        }
    }


    @GetMapping("/all")
    public List<Wishlist> getAllWishlists(){
        return wishlistRepository.findAll();
    }

}