package profile_management;

import java.io.IOException;
import java.util.Scanner;

import API_CONTROLLERS.ApiServices;
import API_CONTROLLERS.Api_Client;
import profile_management.pObject_JSON.RGData;
import retrofit2.Response;

public class registration_controller {

	private static String originalPassword;
	private static String confirmPassword;
	
	public static void registerUser(String username, String password, String confPass, String email, String name, String hAddress, Scanner sc) {
		// Class-global variables
		originalPassword = password;
		confirmPassword = confPass;
		
		String finalPassword = passCheck(password, confPass, sc);
		
		// If a user enters any data that doesn't meet the criteria
		if(username.isBlank() || password.isBlank() || confPass.isBlank()) {
			System.out.println("One of the following fields were left blank: Username, Password, or the Confirmation Password.");
			gatherInformation(sc);
		}
		
		
			
		if (hAddress.isBlank()) {
			hAddress = "N/A";
		}
		
		if (email.isBlank()) {
			email = "N/A";
		}
		
		if (name.isBlank()) {
			name = "N/A";
		}
		
		// Inform the user of the information they have entered, if any of it is wrong, give them the opportunity to change it.
		System.out.println("This is the information that you provided: \n"
				+ "Username: " + username
				+ "\nPassword: " + finalPassword
				+ "\nName: " + name
				+ "\nHome Address: " + hAddress
				+ "\nEmail: " + email);	
		

		boolean passed = false;
		
		while (!passed) { // Options found in switch case below for this while loop will repeat.
			System.out.println("Is this information correct?\nY / N");	
			String inp = sc.nextLine();
		
		switch (inp.toLowerCase().trim()) {
			
		case "y":
			// Grab the API 
			ApiServices api = Api_Client.getApi(); 

			// Process the users information. 
			// API call, etc.
			RGData rgd = new RGData(username, finalPassword, hAddress, email, name);
			Response<RGData> response;
			
			System.out.println("Packaging your data and sending it to the server, stand by...");
			
	
		try {		
			response = api.requestRegistration(rgd).execute();	
				
			if(response.isSuccessful()) {
				System.out.println("Your account has been successfully created, please login to continue.");
			    passed = true; // Break the while loop, edge case scenario if the return for some reason doesn't.. return... 
				return;
				
			} else if (response.code() == 400) { // Server rejected malformed data.  
				System.out.println("Server rejected your information, did you enter malformed data? Please try registering again.");
				return;
			} else { // Unspecified, un-handled error code. 
				System.out.println("HTTP ERROR: " + response.code()); // Debugging 
				System.out.println("Server says: " + response.errorBody().string()); // Debugging 
				return;
				}		
			} catch (IOException e) {
				System.out.println("Network error: " + e.getMessage()); 
				return; 
			}

			
		case "n": // If the user doesn't confirm this is the correct information, they will have to restart.
			System.out.println("Redirecting you to the main menu.\nPlease register again with the correct information.");
			sc.close();
			return;
						
		default:
			System.out.println("Incorrect option provided.");
			sc.close();
			break;
		
			}
			
		}
	}
	
	
	
	private static String passCheck(String pone, String ptwo, Scanner sc) {
		// If the confirmation password meets the initial, great, let the program continue.
		if(!pone.matches("^(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>])(?=.{9,}).*$")) {
		    System.out.println("Your password must be more than 8 characters and contain at least one number and one symbol.");
		    gatherNewPassword(sc);
		}
		
		if (pone.equals(ptwo)) {
			System.out.println("Your provided password matches confirmation, continuing registration.\n\n");
			// Return the password to be associated with the account.
			return pone; 
		} else {
			
			gatherNewPassword(sc);
			
		}
		
		System.out.println("Something went wrong while attempting to match your password. Please try again.");

		return null;
	}
	
	public static void gatherNewPassword(Scanner sc) {
		// Open a keyboard scanner.
		
		// Gather the user response.
		System.out.println("Enter your password: ");
		originalPassword = sc.nextLine().trim();
		
		// Confirm the user password.
		System.out.println("Confirm your password: ");
		confirmPassword = sc.nextLine().trim();
		
		// Call the method again.
		passCheck(originalPassword, confirmPassword, sc);
		
		// Close scanner
		sc.close(); 
	}
	
	public static void gatherInformation(Scanner sc) {
		// Hold the users information
		String username, password, confPassword, name, hAddress, email;
		
		// Open a scanner to record responses.
		
		// Give the user advice on how to operate the system.
		System.out.println("Registration Form:\nPlease enter the information in the following order, "
				+ "press ENTER after each option.\nAnything labeled 'Optional' may be left blank, press ENTER.\n"
				+ "Requirements: password must contain one number and one symbol.");
		
		// Collect the user responses. 
		System.out.println("Username: ");
		username = sc.nextLine().trim();
		
		System.out.println("Password: ");
		password = sc.nextLine().trim();
		
		System.out.println("Confirm Password: ");
		confPassword = sc.nextLine().trim();
		
		System.out.println("(Optional) Email Address: ");
		name = sc.nextLine().trim();
		
		System.out.println("(Optional) Name [First & Last]: ");
		hAddress = sc.nextLine().trim();
		
		System.out.println("(Optional) Home Address [City, State, Zip Code]: ");
		email = sc.nextLine().trim();
		
		
		// Pass the data to the main registration method.
		registerUser(username, password, confPassword, email, name, hAddress, sc);
		
	}
	
	
	
}
