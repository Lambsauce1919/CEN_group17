package API_CONTROLLERS;

import profile_management.pObject_JSON.LoginData;
import profile_management.pObject_JSON.RGData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
// Initial design - Brenden
import wishlist_json.Wishlist;

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
	Call<Wishlist> createWishlist(@Body Wishlist wishlist);
	
	
	
}
