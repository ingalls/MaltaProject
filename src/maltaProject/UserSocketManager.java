package maltaProject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UserSocketManager implements Runnable {

	String database;

	int port;

	public UserSocketManager(String data, int userPort){
		database = data;
		port = userPort;
	}

	@Override
	public void run(){
		connectionListener();
	}

	public void connectionListener(){
		System.out.println("User Socket Listener Active");
		ServerSocket user = null;
		try {
			user = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("<ERROR> Could not start UserSocketManager");
			System.exit(1);
		}
		try {
			while(true) {
				// Blocks until a connection occurs
				Socket userSocket = user.accept();
				interpretationServer IS = new interpretationServer();
				IS.ZaosClient(userSocket, database);
			}
		} catch (IOException e) {
			System.out.println("<ERROR> Could not accept a user socket");
		} finally {
			//Closes all server connections
			try {
				user.close();
			} catch (IOException e) {
				System.out.println("<ERROR> Could not close server's user socket");
			}
		}
	}
}
