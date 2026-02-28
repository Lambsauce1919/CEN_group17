package Wishlist.controller;

import API_CONTROLLERS.ApiServices;
import API_CONTROLLERS.Api_Client;
import Wishlist.model.Wishlist;
import Wishlist.model.User;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/wishlists")

public class WishlistController{

    public static void createWishlist(String name, String token){

        try{
            Wishlist wl = new Wishlist(name, token);
            Api_Client.getApi().createWishlist(wl).execute();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}