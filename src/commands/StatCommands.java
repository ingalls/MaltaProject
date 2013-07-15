package commands;

import getValue.UserValue;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import userInterface.setColor;

public class StatCommands {
	String database;

	Socket socket;

	String user;


	public StatCommands(Socket s, String data, String userName){
		database = data;
		user = userName;
		socket = s;
	}

	public void gold(){
		UserValue UV = new UserValue(database, user);
		setColor color = new setColor();

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream in gold class");
		}

		out.println(color.color("You currently have: [yellow]" + UV.getGold() + "[white] gold"));
	}
}
