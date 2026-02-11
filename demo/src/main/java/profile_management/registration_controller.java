package profile_management;

import java.util.Scanner;

public class registration_controller {

	private static String originalPassword;
	private static String confirmPassword;
	
	public static void registerUser(String username, String password, String confPass, String email, String name, String hAddress) {
		
		originalPassword = password;
		confirmPassword = confPass;
		
		String finalPassword = passCheck(password, confPass);
			
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
		
		System.out.println("Is this information correct?\nY / N");
		
		// Open a keyboard scanner for user response.
		Scanner sc = new Scanner(System.in);
		
		// Continue with the logic tomorrow, what I need to finish is the acceptance case, 
		// and any circumstance in which they need to change their information.
		
		switch (sc.nextLine().toLowerCase()) {
			
		case "y":
			
			// Process the users information. API call, etc.
			
			
			
			System.out.println("Your account has been successfully created, please login to continue.");
			break;
			
		case "n":
			System.out.println("Redirecting you to the main menu.");
			break;
			
		default:
			System.out.println("Incorrect option provided directing you to the main menu.");
			break;
		
		}
		
		sc.close();
	}
	
	private static String passCheck(String pone, String ptwo) {
		 // If the confirmation password meets the initial, great, let the program continue.
		if (pone.equals(ptwo)) {
			System.out.println("Your provided password matches confirmation, continuing registration");
			// Return the password to be associated with the account.
			return pone; 
		} else {
			// Open a keyboard scanner.
			Scanner sc = new Scanner(System.in);
			
			// Gather the user response.
			System.out.println("Enter your password:");
			originalPassword = sc.nextLine();
			System.out.println("Confirm your password:");
			confirmPassword = sc.nextLine();
			
			// Call the method again.
			passCheck(originalPassword, confirmPassword);
			
			// Close scanner
			sc.close(); 
		}
		
		System.out.println("Something went wrong while attempting to match your password. Please try again.");

		return null;
	}
	
	
	
}
