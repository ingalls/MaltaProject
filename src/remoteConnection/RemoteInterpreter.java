package remoteConnection;

import getValue.LoginValue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class RemoteInterpreter {

	PrintWriter out = null;

	BufferedReader in;

	String database;

	boolean AUTH = false;

	String username = "";

	String password = "";

	public RemoteInterpreter(Socket socket, String data){
		System.out.println("Remote connection");

		database = data;

		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: cannot open printstream for RemoteConnection");
		}
		interpreter();
	}

	public void interpreter(){
		while (true){
			System.out.println((!password.equals("")) && (!username.equals("")) && AUTH == false);
			if ((!password.equals("")) && (!username.equals("")) && AUTH == false){
				System.out.println("Checking Credentials:" + username + "|" + password);
				checkLogin(username, password);
			}

			String input = input();

			if (AUTH == false){
				if (input.contains("&username&:")){
					username = input.replace("&username&:", "");
				} else if (input.contains("&password&:")){
					password = input.replace("&password&:", "");
				}

			} else {

			}
		}
	}

	public void checkLogin(String username, String password){
		LoginValue LV = new LoginValue(database, username);
		if (!LV.checkUser()){
			output("&incorrect-user&");
		} else if (!LV.checkPassword(password)){
			output("&incorrect-password&");
		} else {
			AUTH = true;
			System.out.println(username + " Authenticated");
			output("&authenticated&");
		}
	}

	public String input(){
		try {
			String input = "";
			System.out.println("Waiting for input");
			while (input.equals("")){
				input = in.readLine();
			}
			return input;
		} catch (IOException e) {
			System.out.println("Could not recieve input from connection");
			return "";
		}
	}

	public void output(String outputText){
		out.println(outputText);
	}
}
