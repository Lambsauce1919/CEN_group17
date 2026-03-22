package API_CONTROLLERS;

import retrofit2.Retrofit;
import wishlist_json.GoogleBooksApi;
import retrofit2.converter.gson.GsonConverterFactory;


public class GoogleApi_Client {
    private static Retrofit retrofit = null;
    public static GoogleBooksApi getApi(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl("https://www.googleapis.com/books/v1/")
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(GoogleBooksApi.class);
    }
}
