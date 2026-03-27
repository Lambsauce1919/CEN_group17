package API_CONTROLLERS;

import java.util.List;

import profile_management.pObject_JSON.LoginData;
import profile_management.pObject_JSON.RGData;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
// Initial design - Brenden
import wishlist_json.Wishlist;
import Book_Browsing_Json.BookData;

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

	/*
	 *================================
	 *====Book Browsing Calls====
	 *================================
	 */

	@GET("/api/books/genre/{genre}")
	Call<List<BookData>> getBooksByGenre(@Path("genre") String genre);

	@GET("/api/books/top-sellers")
	Call<List<BookData>> getTopSellers();

	@GET("/api/books/rating/{rating}")
	Call<List<BookData>> getBooksByRating(@Path("rating") double rating);

	@PUT("/api/books/discount/{publisher}/{percent}")
	Call<String> discountBooksByPublisher(@Path("publisher") String publisher,
										  @Path("percent") double percent);
}
