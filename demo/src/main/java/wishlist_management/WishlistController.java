package wishlist_management;

import API_CONTROLLERS.ApiServices;
import API_CONTROLLERS.Api_Client;
import wishlist_json.User;
import wishlist_json.Wishlist;

import org.springframework.web.bind.annotation.*;

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