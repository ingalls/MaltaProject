package remoteConnection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class RemoteInterpreter {

	PrintWriter out = null;

	BufferedReader in;

	String database;

	public RemoteInterpreter(Socket socket, String data){
		System.out.println("Remote connection");

		String database = data;

		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: cannot open printstream for RemoteConnection");
		}
		login();
	}

	public void login(){

	}
}
