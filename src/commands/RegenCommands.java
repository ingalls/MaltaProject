package commands;

import getValue.UserValue;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class RegenCommands {

	String database;

	Socket socket;

	String user;

	public RegenCommands(Socket s, String data, String userName){
		database = data;
		user = userName;
		socket = s;
	}

	public void sleep(){
		UserValue UV = new UserValue(database, user);

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream in sleep class");
		}

		out.println("You lay down and fall into a deep sleep.");
		UV.setSleep(true);
	}

	public void rest(){
		//TODO
	}
}
