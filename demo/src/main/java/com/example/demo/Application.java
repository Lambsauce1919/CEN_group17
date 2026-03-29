package com.example.demo;

import java.util.Scanner;
import Session_Management.SessionManager;
import profile_management.login_controller;
import profile_management.registration_controller;
import wishlist_management.WishlistController;
import BookBrowsing.BookBrowsingClient;
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
			System.out.println("Enter 'w' to create a wishlist.");
			System.out.println("Enter 'a' to add a book to your wishlist.");
			System.out.println("Enter 'r' to see the books within a wishlist.");
			System.out.println("Enter 'genre' to browse books by genre.");
			System.out.println("Enter 'top' to view top sellers.");
			System.out.println("Enter 'rating' to search books by rating.");
			System.out.println("Enter 'discount' to apply publisher discount.");
      System.out.println("Enter 'mSearch' to search for a users information by inputting their username.");
      System.out.println("Enter 'updateInformation' to update your accounts associated information.");

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
					int newId = WishlistController.createWishlist(wishlistName, currentSessionToken);
					if(newId != -1) {
						System.out.println("Wishlist, " + wishlistName + ", with ID: " + newId + " created successfully!");
					}
					else{
						System.out.println("Wishlist" + wishlistName + "not created successfully.");
					}
					break;

				case "a": //Case for adding books to wishlist
					System.out.println("Enter the Wishlist ID of the wishlist you would like to add books to: ");
					int wishlistId = Integer.parseInt(sc.nextLine());
					System.out.println("Enter the Book ID of the book you would like to add: ");
					String bookId = sc.nextLine();
					WishlistController.addBookToWishlist(wishlistId, bookId);
					break;

					case "cart":
                    System.out.println("Shopping Cart feature selected.");
                    break;
				case "r": //Case to return books in a wishlist
					System.out.println("Enter the Wishlist ID of the wishlist you would like to see the books in:  ");
					int wishlist_Id = Integer.parseInt(sc.nextLine());
					WishlistController.getBooksFromWishlist(wishlist_Id);
					break;



			case "mSearch": // Member search functionality
				profile_management.retrieve_ud.qUser(sc);
				break;

				case "genre":
					System.out.println("Enter genre:");
					String genre = sc.nextLine();
					BookBrowsingClient.getBooksByGenre(genre);
					break;

				case "top":
					BookBrowsingClient.getTopSellers();
					break;

				case "rating":
					System.out.println("Enter minimum rating:");
					double rating = Double.parseDouble(sc.nextLine());
					BookBrowsingClient.getBooksByRating(rating);
					break;

				case "discount":
					System.out.println("Enter publisher:");
					String publisher = sc.nextLine();
					System.out.println("Enter discount percentage:");
					double percent = Double.parseDouble(sc.nextLine());
					BookBrowsingClient.discountBooksByPublisher(publisher, percent);
					break;




			case "updateInformation":
				profile_management.update_ud.update_information(sc);

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


