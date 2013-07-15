package maltaProject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import remoteConnection.RemoteInterpreter;

public class WizardSocketManager implements Runnable{
	String database;

	int port;

	public WizardSocketManager(String data, int userPort){
		database = data;
		port = userPort;
	}

	@Override
	public void run(){
		connectionListener();
	}

	public void connectionListener(){
		System.out.println("Wizard Socket Listener Active");
		ServerSocket wizard = null;
		try {
			wizard = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("<ERROR> Could not start WizardSocketManager");
			System.exit(1);
		}
		try {
			while(true) {
				// Blocks until a connection occurs:
				Socket wizardSocket = wizard.accept();

				RemoteInterpreter RI = new RemoteInterpreter(wizardSocket, database);
			}
		} catch (IOException e) {
			System.out.println("<ERROR> Could not accept a wizard socket");
		} finally {
			//Closes all server connections
			try {
				wizard.close();
			} catch (IOException e) {
				System.out.println("<ERROR> Could not close server's wizard socket");
			}
		}
	}
}
