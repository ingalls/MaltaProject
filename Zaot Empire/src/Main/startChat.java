package Main;

import java.net.Socket;

public class startChat extends Thread {
	public Socket socket;
	public String database;
	public String user;
	
	public startChat(Socket s, String data, String name) {
		socket = s;
		database = data;
		user = name;
		begin();
	}
	private void begin() {
		printChat PC = new printChat(socket, database, user);
		PC.begin();
	}

}
