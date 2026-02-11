package API_CONTROLLERS;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Api_Client {

    private static ApiServices api;

    private static final String BASE_URL = "https://your-backend-url.com";

    public static ApiServices getApi() {

        if (api == null) {

            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());

            OkHttpClient client = new OkHttpClient.Builder().build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(JacksonConverterFactory.create(mapper))
                    .build();

            api = retrofit.create(ApiServices.class);
        }

        return api;
    }
}
