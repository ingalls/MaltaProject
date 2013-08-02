package commands;

import getValue.ObjectValue;
import getValue.RoomValue;
import getValue.UserValue;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import userInterface.setColor;

public class UserCommands {

	String database;

	Socket socket;

	String user;


	public UserCommands(Socket s, String data, String userName){
		database = data;
		user = userName;
		socket = s;
	}

	public void inventory(){
		UserValue UV = new UserValue(database, user);
		String[] inventoryList = UV.getInventory(); //Stores the user's inventory
		setColor color = new setColor();

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream in inventory class");
		}

		int objGet = 0;

		if(inventoryList.length == 0){
			out.println("You have nothing in inventory.");
		} else {
			out.println("# | Description");
			while (objGet < inventoryList.length){
				int number = UV.getInventoryItem((inventoryList[objGet]));
				ObjectValue OV = new ObjectValue(database, inventoryList[objGet]);
				String textOut = color.color(" " + number + "  " + OV.getTitle() + " - " + OV.getDesc());
				out.println(textOut);

				objGet++;
			}
		}
	}

	public void sit(String room){

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream in inventory class");
		}

		RoomValue RV = new RoomValue(database, room);

		if (RV.canSit()){
			out.println(RV.getSitDesc());
			UserValue UV = new UserValue(database, user);
			UV.setSitting(true);
		} else {
			out.println("There isn't anything you could possibly sit on here!");
		}
	}

	public void stand(){
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream in inventory class");
		}

		UserValue UV = new UserValue(database, user);
		if (UV.isSitting()){
			UV.setSitting(false);
			out.println("You stand up!");
		} else {
			out.println("You are already standing!");
		}
	}

	public void stat(){
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream in inventory class");
		}

		int charCount = 0;
		String line;
		out.print("**************************************************");
		charCount = user.length() + 21;
		line = "* " + user + "'s User Statistics";
		for (int i=0; i<= charCount; i++){
			line = line + " ";
		}
		line = line + "*";
		out.print(line);


		out.print("*                                                *");
	}
}
