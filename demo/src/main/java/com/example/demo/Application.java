package com.example.demo;

import java.util.Scanner;
import Session_Management.SessionManager;
import profile_management.login_controller;
import profile_management.registration_controller;
public class Application {

	public static void main(String[] args) throws Exception {
        // 1. If you have setup logic that was in your 'run' method, call it here
		Application app = new Application();
        app.run(args);
    }
	
	public void run(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);	
		String inp = null;
		
		System.out.println("Welcome to the library, please login or "
				+ "register if you do not have an account.");
	
		
		while (!SessionManager.getInstance().isAuthenticated()) { // Keep the user in the login portal until they've passed conditions
			
		System.out.println("l: Login\nr: Register");
		inp = sc.nextLine();
		
		switch (inp.toLowerCase()) {
		
		case "l": // Case for the user to login.
			
			login_controller.displayLoginInfo();
			
			System.out.println("Username:");
			String username = sc.nextLine();
			System.out.println("Password:");
			String password = sc.nextLine();
			
			login_controller.loginUser(username, password);
			
			System.out.println("Logged in successfully");
			
			break;
			
		case "r": // Case for a user to register;
			
			registration_controller.gatherInformation(sc);
			
			break;
		
		default:
			System.out.println("You have entered an incorrect option.");
			break;
		
			}
			
		}
		
	System.out.println("Welcome to the Library, please see the menu options listed below.");
	if (SessionManager.getInstance().isAuthenticated())	{
				
		do {
			
			System.out.println("Menu options:\n'mSearch' - search for a users information by inputting their username.");
			
			inp = sc.nextLine();
			
			if (inp == null) {
				System.out.println("You have entered a malformed response.");
				continue;
		
      }
			
			switch (inp) {
          
          
          
			case "w": //Case for making a Wishlist
					System.out.println("Enter a Wishlist name:");
					String wishlistName = sc.nextLine();
					String currentSessionToken = SessionManager.getInstance().getSession_token();

					if(currentSessionToken != null) {
//						wishlistController.createWishlist(wishlistName, currentSessionToken);
					}
				break;
			
			case "mSearch": // Member search functionality
				profile_management.retrieve_ud.qUser(sc);
				break;
			
			default: // If a user inputs something that doesn't line up with what we're offering, display this message.
				System.out.println("You've entered an incorrect option, "
						+ "options are not case-sensitive, however, grammar sensitive.");			
				break;
			
			}
			
		} while (!inp.equalsIgnoreCase("quit")); }
		
		sc.close();
		}
		
		
	}


