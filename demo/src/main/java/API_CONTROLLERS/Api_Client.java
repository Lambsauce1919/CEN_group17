package API_CONTROLLERS;

import org.springframework.stereotype.Service;
import retrofit2.Call;
// Initial config from Brenden
@Service
public class Api_Client {

    private final ApiServices exampleApi;

    public Api_Client(ApiServices exampleApi) {
        this.exampleApi = exampleApi;
    }
}

