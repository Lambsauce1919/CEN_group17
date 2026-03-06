package profile_management;

import java.io.IOException;
import java.util.Scanner;

import API_CONTROLLERS.ApiServices;
import API_CONTROLLERS.Api_Client;
import profile_management.pObject_JSON.RGData;
import retrofit2.Response;

public class retrieve_ud {
// Brenden.
	
	public static void qUser(Scanner sc) {
		
		System.out.println("\n\n\n\n\nWelcome to the Member Query tool, enter a persons username to retrieve their information.");
		String username = sc.nextLine().trim(); // Capture the users response and then 
		
		System.out.println("You have entered: " + username + "\nIs this correct and do you want to continue? (Y/N)");
		
		String inp = sc.nextLine().trim().toLowerCase();
		boolean pass = false;
		
		while (!pass) {
		switch (inp) {
		
		case "y":
			System.out.println("Starting query...");
			pass = true;
			break;
		
		case "n": // If the user entered the incorrect or doesn't want to continue this will be displayed. 
			System.out.println("Redirecting you to the main menu.");
			return;
		
		default:
			System.out.println("Incorrect option, please enter Y or N");
		break;
			
			} // End of switch case
		} // End of while-loop
	
		
		
	Response<RGData> response;
	ApiServices api = Api_Client.getApi(); 

	try {
		response = api.requestUD(username).execute();
		
		if(response.isSuccessful()) {
			System.out.println("\n==============================================================");
			System.out.println("Successfully retrieved the requested users data:");
			System.out.println("Name: " + response.body().getName());
			System.out.println("Email: " + response.body().getemail());
			System.out.println("Home Address: " + response.body().gethaddress());
			System.out.println("==============================================================\n");

		} else {
			if(response.code() == 404) {
				System.out.println("\nThe user you request could not be found in the Database, please ensure correct spelling and try again.\n");
				return;
			}
		}
	
	} catch (IOException e) {
		e.printStackTrace();
	} 
	
		
		
		
		
	}
	
	
	
	
}
