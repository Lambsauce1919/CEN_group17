package API_CONTROLLERS;

import java.util.HashMap;

import profile_management.pObject_JSON.LoginData;
import profile_management.pObject_JSON.RGData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Path;
import retrofit2.http.Query;
// Initial design - Brenden
import wishlist_json.BookData;
import wishlist_json.Wishlist;

import java.util.List;

public interface ApiServices {
	
/*
 *================================
 *====PROFILE MANAGEMENT CALLS====
 *================================
 */
	
	@POST("/LOGIN")
	Call<LoginData> requestLogin(@Body LoginData ld);
	
	@POST("/REGISTER")
	Call<String> requestRegistration(@Body RGData rgd);

	@POST("/wishlists/create")
	Call<Integer> createWishlist(@Body Wishlist wishlist);
	
	@POST("/wishlists/addBook")
	Call<Void> addBookToWishlist(@Query("wishlistId") int wishlist_id, @Query("bookId") String book_id);

	@GET("/wishlists/return")
	Call<List<String>> returnBooksFromWishlist(@Query("wishlistId") int wishlist_id);

	@GET("https://www.googleapis.com{id}")
	Call<BookData> getBookInfo(@Path("id") String book_Id);

	@GET("/user/{id}")
	Call<RGData> requestUD(@Path("id") String username);
	
	@POST("/updateInfo")
	Call<String> updateInfo(@Body HashMap<Integer, String> payload, @Header("Authorization") String sToken);
	
	
	
}
