package commands;

import getValue.RoomValue;
import getValue.UserValue;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MovementCommands {

	String database;

	Socket socket;

	String user;


	public MovementCommands(Socket s, String data, String userName){
		database = data;
		user = userName;
		socket = s;
	}

	public boolean moveNorth(){
		final UserValue UV = new UserValue(database, user);
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream for MovementCommands");
		}

		RoomValue CurrentRoom = new RoomValue(database, UV.getLoc());

		if (UV.isSitting()){
			out.println("You need to be standing first!");
			return false;
		} else if (CurrentRoom.getNorth() == null){
			out.println("You can't go that way!");
			return false;
		} else {

			//Removes user from user
			CurrentRoom.removeUser(user);

			//Adds user to room
			RoomValue FutureRoom = new RoomValue(database, CurrentRoom.getNorth());
			FutureRoom.addUser(user);

			if (CurrentRoom.getMoveNorth() == null){
				out.println("You move to the north");
			} else {
				out.println(CurrentRoom.getMoveNorth());
			}
			UV.setLoc(CurrentRoom.getNorth());
			return true;
		}
	}

	public boolean moveEast(){
		final UserValue UV = new UserValue(database, user);
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream for MovementCommands");
		}

		RoomValue CurrentRoom = new RoomValue(database, UV.getLoc());

		if (UV.isSitting()){
			out.println("You need to be standing first!");
			return false;
		} else if (CurrentRoom.getEast() == null){
			out.println("You can't go that way!");
			return false;
		} else {

			//Removes user from user
			CurrentRoom.removeUser(user);

			//Adds user to room
			RoomValue FutureRoom = new RoomValue(database, CurrentRoom.getEast());
			FutureRoom.addUser(user);

			if (CurrentRoom.getMoveEast() == null){
				out.println("You move to the east");
			} else {
				out.println(CurrentRoom.getMoveEast());
			}
			UV.setLoc(CurrentRoom.getEast());
			return true;
		}
	}

	public boolean moveSouth(){
		final UserValue UV = new UserValue(database, user);
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream for MovementCommands");
		}

		RoomValue CurrentRoom = new RoomValue(database, UV.getLoc());

		if (UV.isSitting()){
			out.println("You need to be standing first!");
			return false;
		} else if (CurrentRoom.getSouth() == null){
			out.println("You can't go that way!");
			return false;
		} else {

			//Removes user from user
			CurrentRoom.removeUser(user);

			//Adds user to room
			RoomValue FutureRoom = new RoomValue(database, CurrentRoom.getSouth());
			FutureRoom.addUser(user);

			if (CurrentRoom.getMoveSouth() == null){
				out.println("You move to the south");
			} else {
				out.println(CurrentRoom.getMoveSouth());
			}
			UV.setLoc(CurrentRoom.getSouth());
			return true;
		}
	}

	public boolean moveWest(){
		final UserValue UV = new UserValue(database, user);
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream for MovementCommands");
		}

		RoomValue CurrentRoom = new RoomValue(database, UV.getLoc());

		if (UV.isSitting()){
			out.println("You need to be standing first!");
			return false;
		} else if (CurrentRoom.getWest() == null){
			out.println("You can't go that way!");
			return false;
		} else {

			//Removes user from user
			CurrentRoom.removeUser(user);

			//Adds user to room
			RoomValue FutureRoom = new RoomValue(database, CurrentRoom.getWest());
			FutureRoom.addUser(user);

			if (CurrentRoom.getMoveWest() == null){
				out.println("You move to the west");
			} else {
				out.println(CurrentRoom.getMoveWest());
			}
			UV.setLoc(CurrentRoom.getWest());
			return true;
		}
	}

	public boolean moveUp(){
		final UserValue UV = new UserValue(database, user);
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream for MovementCommands");
		}

		RoomValue CurrentRoom = new RoomValue(database, UV.getLoc());

		if (UV.isSitting()){
			out.println("You need to be standing first!");
			return false;
		} else if (CurrentRoom.getUp() == null){
			out.println("You can't go that way!");
			return false;
		} else {

			//Removes user from user
			CurrentRoom.removeUser(user);

			//Adds user to room
			RoomValue FutureRoom = new RoomValue(database, CurrentRoom.getUp());
			FutureRoom.addUser(user);

			if (CurrentRoom.getMoveUp() == null){
				out.println("You move up");
			} else {
				out.println(CurrentRoom.getMoveUp());
			}
			UV.setLoc(CurrentRoom.getUp());
			return true;
		}
	}

	public boolean moveDown(){
		final UserValue UV = new UserValue(database, user);
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream for MovementCommands");
		}

		RoomValue CurrentRoom = new RoomValue(database, UV.getLoc());

		if (UV.isSitting()){
			out.println("You need to be standing first!");
			return false;
		} else if (CurrentRoom.getDown() == null){
			out.println("You can't go that way!");
			return false;
		} else {

			//Removes user from user
			CurrentRoom.removeUser(user);

			//Adds user to room
			RoomValue FutureRoom = new RoomValue(database, CurrentRoom.getDown());
			FutureRoom.addUser(user);

			if (CurrentRoom.getMoveDown() == null){
				out.println("You move down");
			} else {
				out.println(CurrentRoom.getMoveDown());
			}
			UV.setLoc(CurrentRoom.getDown());
			return true;
		}
	}
}
