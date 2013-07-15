package commands;

import getValue.ObjectValue;
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
}
