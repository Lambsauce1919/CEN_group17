package API_CONTROLLERS;

import java.util.HashMap;

import profile_management.pObject_JSON.LoginData;
import profile_management.pObject_JSON.RGData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
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
	
	@GET("/user/{id}")
	Call<RGData> requestUD(@Path("id") String username);
	
	@POST("/updateInfo")
	Call<String> updateInfo(@Body HashMap<Integer, String> payload, @Header("Authorization") String sToken);
	
	
	
}
