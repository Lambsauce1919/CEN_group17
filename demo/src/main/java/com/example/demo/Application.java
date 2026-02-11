package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		boolean lI = false; // lI = logged in.
		Scanner sc = new Scanner(System.in);
		String inp = sc.nextLine();
		
		
		
		System.out.println("Welcome to the library, please login or "
				+ "register if you do not have an account.");
		
		String username = null;
		String password = null; 
		
		while (!lI) { // Keep the user in the login portal until they've passed conditions
			
		System.out.println("l: Login\nr: Register");
		inp = sc.nextLine();
		
		switch (inp) {
		
		case "l":
			
			System.out.println("You have chosen to login, please enter your USERNAME press ENTER, then password press ENTER");
			
			
			
			
			break;
		
		
		
		}
			
			
		}
		
		
		
		do {
			
			
			
			switch (inp) {
			
			
			
			
			
			default: // If a user inputs something that doesn't line up with what we're offering, display this message.
				inp = null;
				System.out.println("You've entered an incorrect option, "
						+ "options are not case-sensitive, however, grammar sensitive.");			
				break;
			
			}
			
			
			
		} while (!inp.equalsIgnoreCase("quit"));
		
		
		
		
		
		
	}

}
