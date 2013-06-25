package chatServices;

import getValue.RoomValue;
import getValue.WhoValue;
import maltaProject.FileOperations;

public class sendChat {
	public String database;
	public String user;
	public String strLine;
	//---Chat Variables---//

	/**
	 * Default constructor for sending a chat
	 * @param data A String containing the location of the database
	 * @param name A String containing the user's name
	 */
	public sendChat(String data, String name) {
		database = data;
		user = name;
	}

	/**
	 * Sends an Out Of Character chat to all users
	 * @param chatString A String containing the chat phrase
	 */
	public void ooc(String chatString){
		chatString = chatString.replace("ooc ", "");

		WhoValue WhoValue = new WhoValue(database);
		String[] onlineUsers = WhoValue.listWho();
		int userLength = onlineUsers.length;
		userLength--; //Corrects for 0th item

		while (userLength >= 0){
			FileOperations FO = new FileOperations(database + "/charProfile/" + onlineUsers[userLength] + "/chat");
			FO.appendLine(user + " oocs " +"[green] '" + chatString + "'[white]");
			userLength--;
		}
	}

	/**
	 * Sends an In Character chat to all users
	 * @param chatString A String containing the chat phrase
	 */
	public void ic(String chatString){
		chatString = chatString.replace("ic ", "");

		WhoValue WhoValue = new WhoValue(database);
		String[] onlineUsers = WhoValue.listWho();
		int userLength = onlineUsers.length;
		userLength--; //Corrects for 0th item

		while (userLength >= 0){
			FileOperations FO = new FileOperations(database + "/charProfile/" + onlineUsers[userLength] + "/chat");
			FO.appendLine(user + " ics " +"[purple] '"+ chatString+"'[white]");
			userLength--;
		}
	}

	/**
	 * Sends a private message to a specific user
	 * @param chatString A String containing the chat phrase
	 * @param user A String containing the user to send it to.
	 */
	public void tell(String chatString, String user){
		FileOperations FO = new FileOperations(database + "/charProfile/" + user + "/chat");
		FO.appendLine(chatString);
	}

	/**
	 * Sends a message to all user's in a specific room
	 * @param chatString A String containing the chat phrase
	 * @param room A String containing the user's room
	 */
	public void say(String chatString, String room){
		RoomValue RoomValue = new RoomValue(database, room);
		String users[] = RoomValue.getUsers();
		int userLength = users.length;
		userLength--; //Corrects for 0th item

		while (userLength >= 0){
			FileOperations FO = new FileOperations(database + "/charProfile/" + users[userLength] + "/chat");
			FO.appendLine(user + " ics " +"[purple] '"+ chatString+"'[white]");
			userLength--;
		}
	}

	/**
	 * Sends a message to all user's in a a specific room as well as all adjacent rooms
	 * 
	 * @param chatString A String containing the chat phrase
	 * @param room a String containing the user's room
	 */
	public void yell(String chatString, String room){//TODO finish
		RoomValue currentRoom = new RoomValue(database, room);
		RoomValue upRoom = new RoomValue(database, currentRoom.getUp());
		RoomValue downRoom = new RoomValue(database, currentRoom.getDown());
		RoomValue northRoom = new RoomValue(database, currentRoom.getNorth());
		RoomValue eastRoom = new RoomValue(database, currentRoom.getEast());
		RoomValue southRoom = new RoomValue(database, currentRoom.getSouth());
		RoomValue westRoom = new RoomValue(database, currentRoom.getWest());

		String[] currentUsers = currentRoom.getUsers();
		int userLength = currentUsers.length - 1;
		while (userLength >= 0){
			FileOperations FO = new FileOperations(database + "/charProfile/" + currentUsers[userLength] + "/chat");
			FO.appendLine(user + " ics " +"[purple] '"+ chatString+"'[white]");
			userLength--;
		}

		String[] upUsers = upRoom.getUsers();
		userLength = upUsers.length - 1;
		while (userLength >= 0){
			FileOperations FO = new FileOperations(database + "/charProfile/" + upUsers[userLength] + "/chat");
			FO.appendLine(user + " ics " +"[purple] '"+ chatString+"'[white]");
			userLength--;
		}

		String[] downUsers = downRoom.getUsers();
		userLength = downUsers.length - 1;
		while (userLength >= 0){
			FileOperations FO = new FileOperations(database + "/charProfile/" + downUsers[userLength] + "/chat");
			FO.appendLine(user + " ics " +"[purple] '"+ chatString+"'[white]");
			userLength--;
		}

		String[] northUsers = northRoom.getUsers();
		userLength = northUsers.length - 1;
		while (userLength >= 0){
			FileOperations FO = new FileOperations(database + "/charProfile/" + northUsers[userLength] + "/chat");
			FO.appendLine(user + " ics " +"[purple] '"+ chatString+"'[white]");
			userLength--;
		}

		String[] eastUsers = eastRoom.getUsers();
		userLength = eastUsers.length - 1;
		while (userLength >= 0){
			FileOperations FO = new FileOperations(database + "/charProfile/" + eastUsers[userLength] + "/chat");
			FO.appendLine(user + " ics " +"[purple] '"+ chatString+"'[white]");
			userLength--;
		}

		String[] southUsers = southRoom.getUsers();
		userLength = southUsers.length - 1;
		while (userLength >= 0){
			FileOperations FO = new FileOperations(database + "/charProfile/" + southUsers[userLength] + "/chat");
			FO.appendLine(user + " ics " +"[purple] '"+ chatString+"'[white]");
			userLength--;
		}

		String[] westUsers = westRoom.getUsers();
		userLength = westUsers.length - 1;
		while (userLength >= 0){
			FileOperations FO = new FileOperations(database + "/charProfile/" + westUsers[userLength] + "/chat");
			FO.appendLine(user + " ics " +"[purple] '"+ chatString+"'[white]");
			userLength--;
		}
	}
}
