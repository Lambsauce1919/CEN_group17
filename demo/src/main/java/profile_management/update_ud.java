package profile_management;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import API_CONTROLLERS.ApiServices;
import API_CONTROLLERS.Api_Client;
import Session_Management.SessionManager;
import retrofit2.Response;

public class update_ud {

	
	public static void update_information(Scanner sc) {
		
		System.out.println("\nInformation Update Manager:\ne - email\np - password\nn - name\nh - home address"
				+ "\n");
		
		String inp = sc.nextLine();
			switch (inp) {
			
			case"u":
				System.out.println("Enter your newly desired email: ");
				inp = sc.nextLine();
				sendPayload(1, inp);
				break;
				
			case"p":
				System.out.println("Your password must be more than 8 characters and contain at least one number and one symbol.");
				System.out.println("Enter your new password: ");
				inp = sc.nextLine();
				sendPayload(2, inp);
				break;
				
			case"n":
				System.out.println("Enter your new name: ");
				inp = sc.nextLine();
				sendPayload(3, inp);
				break;
				
			case"h":
				System.out.println("Enter your new home address: ");
				inp = sc.nextLine();
				sendPayload(4, inp);
				break;
			
			default:
				System.out.println("This is not a defined option, please try again.");
				break;
				
			}

		}
	
	
	private static void sendPayload(int type, String info) {
		HashMap<Integer, String> payload = new HashMap<>();
		payload.put(type, info);
		
		Response<String> response;
		ApiServices api = Api_Client.getApi(); 
		
		try {
			response = api.updateInfo(payload, SessionManager.getInstance().getSession_token()).execute();
			
			if (response.isSuccessful()) {
				System.out.println("\n=============================");
				System.out.println("|| Successfully updated data. ||");
				System.out.println("==============================\n");
				} else if (response.code() == 400) {
					System.out.println("\n=========================================");
					System.out.println("|| Password does not meet requirements. ||");
					System.out.println("==========================================\n");
				} else if(response.code() == 204) {
					System.out.println("\n=================================================================");
					System.out.println("|| Your provided session token doesn't match or is expired. ||");
					System.out.println("==================================================================\n");
				} else if (response.code() == 409) {
					System.out.println("\n=========================================================");
					System.out.println("|| This email is already registered to another account. ||");
					System.out.println("==========================================================\n");
				} else {
					System.out.println("\n===============================================================================");
					System.out.println("|| There was an unspecified, unhandled error that occurred please try again. ||");
					System.out.println("=================================================================================\n");
				}
			
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		
		payload.clear();
		System.gc();

	}

}
