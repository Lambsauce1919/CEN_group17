package wishlist_management;

import API_CONTROLLERS.ApiServices;
import API_CONTROLLERS.Api_Client;
import wishlist_json.Wishlist;
import wishlist_json.User;
import org.springframework.web.bind.annotation.*;

public class WishlistController{

    public static int createWishlist(String name, String token){

        try{
            Wishlist wl = new Wishlist(name, token);
            retrofit2.Response<Integer> response = Api_Client.getApi().createWishlist(wl).execute();
            if(response.isSuccessful()){
                return response.body();
            }
            else{
                System.out.println("Failed! Server code: " + response.code());
                return -1;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public static void addBookToWishlist(int wishlist_id, int book_id){
        try{
            retrofit2.Response<Void> response = Api_Client.getApi().addBookToWishlist(wishlist_id, book_id).execute();
            if(response.isSuccessful()){
                System.out.println("Book " + book_id + " was added to Wishlist " + wishlist_id);
            }
            else {
                System.out.println("Failed! Server code: " + response.code());
            }
        }
        catch(Exception e){
            System.out.println("Error in adding book to Wishlist " + wishlist_id);
            e.printStackTrace();
        }
    }


}