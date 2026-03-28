package wishlist_json;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GoogleBooksApi {
    @GET("volumes/{volumeId}")
    Call<BookData> getBookTitle(@Path("volumeId") String volumeId);
}
