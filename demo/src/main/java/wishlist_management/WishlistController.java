package wishlist_management;

import API_CONTROLLERS.ApiServices;
import API_CONTROLLERS.Api_Client;
import retrofit2.Call;
import wishlist_json.BookData;
import wishlist_json.Wishlist;
import wishlist_json.User;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import API_CONTROLLERS.GoogleApi_Client;

public class WishlistController{

    public static int createWishlist(String name, String token){

        try{
            Wishlist wl = new Wishlist(name, token);
            retrofit2.Response<Integer> response = Api_Client.getApi().createWishlist(wl).execute();
            if(response.isSuccessful()){
                return response.body();
            }
            else{
                if(response.code() != 403){
                    System.out.println("You have the maximum number of wishlists!");
                }
                else {
                    System.out.println("Failed! Server code: " + response.code());
                }
                    return -1;
            }
        }
        catch(Exception e){
        System.out.println("Error in creating a Wishlist!");
            return -1;
        }
    }

    public static void addBookToWishlist(int wishlist_id, String book_id){
        try{
            retrofit2.Response<Void> response = Api_Client.getApi().addBookToWishlist(wishlist_id, book_id).execute();
            if(response.isSuccessful()){
                System.out.println("BookID " + book_id + " was added to Wishlist " + wishlist_id);
            }
            else {
                System.out.println("Failed! Server code: " + response.code());
            }
        }
        catch(Exception e){
            System.out.println("Error in adding book to Wishlist " + wishlist_id);
        }
    }

    public static void getBooksFromWishlist(int wishlist_id){
        Call<List<String>> callId = Api_Client.getApi().returnBooksFromWishlist(wishlist_id);
        callId.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                   if(response.isSuccessful() && response.body() != null){
                       List<String> bookIds = response.body();
                       if(bookIds.isEmpty()){
                           System.out.println("No books in Wishlist " + wishlist_id + "!");
                       }
                       else {
                           System.out.println("Books in Wishlist " + wishlist_id + ": ");
                           for (String bookId : bookIds) {
                               fetchTitleFromGoogle(bookId);
                           }
                       }
                   }
            }
            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                System.out.println("Failed! Server code: " + t.getMessage());
            }
        });

    }

    //Helper method to get the titles of the books.
    public static void fetchTitleFromGoogle(String bookId){
        GoogleApi_Client.getApi().getBookTitle(bookId).enqueue(new Callback<BookData>() {
            @Override
            public void onResponse(Call<BookData> call, Response<BookData> response) {
                if(response.isSuccessful() && response.body() != null){
                    String bookTitle = response.body().volumeInfo.title;
                    System.out.println("Title: " + bookTitle);
                }
            }
            @Override
            public void onFailure(Call<BookData> call, Throwable t) {
                System.out.println("Failed! Server code: " + t.getMessage());
            }

        });
    }


}