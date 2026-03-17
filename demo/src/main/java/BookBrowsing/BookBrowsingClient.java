package BookBrowsing;

import API_CONTROLLERS.ApiServices;
import API_CONTROLLERS.Api_Client;
import Book_Browsing_Json.BookData;
import retrofit2.Response;
import java.util.List;

public class BookBrowsingClient {
    public static void getBooksByGenre(String genre) {
        try {
            ApiServices api = Api_Client.getApi();
            Response<List<BookData>> response = api.getBooksByGenre(genre).execute();

            if (response.isSuccessful() && response.body() != null) {
                System.out.println("Books in genre: " + genre);
                for (BookData book : response.body()) {
                    System.out.println(book);
                }
            } else {
                System.out.println("Request failed: " + response.code());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getTopSellers() {
        try {
            ApiServices api = Api_Client.getApi();
            Response<List<BookData>> response = api.getTopSellers().execute();

            if (response.isSuccessful() && response.body() != null) {
                System.out.println("Top Sellers:");
                for (BookData book : response.body()) {
                    System.out.println(book);
                }
            } else {
                System.out.println("Request failed: " + response.code());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getBooksByRating(double rating) {
        try {
            ApiServices api = Api_Client.getApi();
            Response<List<BookData>> response = api.getBooksByRating(rating).execute();

            if (response.isSuccessful() && response.body() != null) {
                System.out.println("Books with rating >= " + rating);
                for (BookData book : response.body()) {
                    System.out.println(book);
                }
            } else {
                System.out.println("Request failed: " + response.code());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void discountBooksByPublisher(String publisher, double percent) {
        try {
            ApiServices api = Api_Client.getApi();
            Response<String> response = api.discountBooksByPublisher(publisher, percent).execute();

            if (response.isSuccessful() && response.body() != null) {
                System.out.println(response.body());
            } else {
                System.out.println("Request failed: " + response.code());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
