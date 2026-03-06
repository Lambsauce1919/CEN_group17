package API_CONTROLLERS;

import Wishlist.model.Wishlist;
import profile_management.pObject_JSON.LoginData;
import profile_management.pObject_JSON.RGData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;
// Initial design - Brenden

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
	Call<Void> addBookToWishlist(@Query("wishlistId") int wishlist_id, @Query("bookId") int book_id);
	
}
