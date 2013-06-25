package userOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import maltaProject.FileOperations;

public class CreateAccount {
	Socket socket;
	BufferedReader input;
	PrintWriter out;
	String database;

	public CreateAccount(Socket s, BufferedReader in, PrintWriter output, String data){
		socket = s;
		input = in;
		out = output;
		database = data;
	}

	public void create(){//Allows for new users to create an account
		String userName = "";
		String password = "";
		String email = "";

		out.println();
		out.println("===Create a New Account===\n");
		out.println("Well hello there! I'm going to help you create an account.");
		out.println("The first thing I'm going to need is a username");
		out.println("Please choose one now:");
		while (true){
			try {
				userName = input.readLine();
			} catch (IOException e) {
				System.out.print("<Control> A New user creating an account cannot input");
			}

			FileOperations FO = new FileOperations(database + "/login/"+userName);
			FO.getLine();
			if (FO.hasError()==true){
				out.println("You now have the username: " + userName + "\n");
				break;
			} else {
				out.println("\nThis username has already been taken.");
				out.println("Please enter a new one now:");
			}
		}

		out.println("Okay now I'm going to need you to enter a password.");


		String passwordCheck="";
		while (true) {

			while (true) {
				try {
					password = input.readLine();
				} catch (IOException e) {
					System.out
					.print("<Control> A New user creating an account cannot input");
				}
				if (password.equals("")) {
					out.println("You Have to enter a password!");
				} else if (password.length() < 6) {
					out.println("Please enter a password that is greater than 5 characters.");
				} else {
					break;
				}

			}
			out.println("And just to be safe, enter is again please.");
			try {
				passwordCheck = input.readLine();
			} catch (IOException e) {
				System.out.print("<Control> A New user creating an account cannot input");
			}

			if (!password.equals(passwordCheck)){
				out.println("Please make sure your passwords match!");
			} else {
				break;
			}
		}
		out.println("Perfect!\n");

		out.println("Now can you enter an email address?");
		out.println("(We will use this if you ever forget your password)");
		try {
			email = input.readLine();
		} catch (IOException e) {
			System.out.print("<Control> A New user creating an account cannot input");
		}

		FileOperations FO = new FileOperations(database+"/login/"+userName);
		FO.appendLine(password);
		FO.appendLine(email);


		out.println("\nOkay That's it!");
		out.println("Press enter now and you will be taken back to the login screen.");
		out.println("From there you can login with your new account and get playing!");

		try {
			passwordCheck = input.readLine();
		} catch (IOException e) {
			System.out.print("<Control> A New user creating an account cannot input");
		}
	}
}
