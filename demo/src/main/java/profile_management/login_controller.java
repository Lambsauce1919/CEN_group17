package profile_management;

import java.io.IOException;

import API_CONTROLLERS.ApiServices;
import API_CONTROLLERS.Api_Client;
import Session_Management.SessionManager;
import profile_management.pObject_JSON.LoginData;
import retrofit2.Response;

public class login_controller {
	
	// Created by BRENDEN

	// This method accepts 2 parameters (both strings) 
	// Calls a back end login API, and then returns a session_token if the user is allowed to login.
	
	public static boolean loginUser(String user, String pass) { 
		ApiServices api = Api_Client.getApi();

		LoginData ld = new LoginData(user, pass);
		
		System.out.println("Calling the server to log you in.");
		
		Response<LoginData> response;

		try { 
			response = api.requestLogin(ld).execute(); 
		
			if (response.isSuccessful() && response.body() != null) { 
			
			LoginData ldr = response.body();
				
			// Set the singleton instance session boolean auth to true to break loop
			SessionManager.getInstance().setSession_token(ldr.getToken()); // Set the returned session token, this is used for any future API calls.
			SessionManager.getInstance().setAuthenticated(ldr.isAuthenticated()); // Set the returned boolean value. 
			
			System.out.println("Logging you in...");
			System.out.println("DEBUG: Approval status: " + SessionManager.getInstance().isAuthenticated());
			
			} else if (response.code() == 401) {				
				System.out.println("Server Response: Did you enter an incorrect username or password?");
				return false;
			}
			else { 
				System.out.println("HTTP ERROR: " + response.code()); // Debugging 
				if (response.errorBody().string() != null) {
				System.out.println("Server says: " + response.errorBody().string()); // Debugging 
				}
				return false; 
				} 
			} 
			catch (IOException e) { // A network error occurred, peep the message to see what went wrong and where. 
				System.out.println("Network error: " + e.getMessage()); 
				return false; 
			}
		
			return response.body().isAuthenticated();
		}
	
	public static void displayLoginInfo() { // Responsible for printing login information. 
		System.out.println("You have chosen to login, please enter your USERNAME press ENTER, then password press ENTER");
		System.out.println("Entries are case-sensitive.\n");
	}
	
}
