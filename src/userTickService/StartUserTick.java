package userTickService;

import java.net.Socket;


public class StartUserTick extends Thread {
	public Socket socket;
	public String database;
	public String user;

	public StartUserTick(Socket s, String data, String name) {
		socket = s;
		database = data;
		user = name;
		begin();
	}
	private void begin() {
		UserTicker PC = new UserTicker(socket, database, user);
	}
}
