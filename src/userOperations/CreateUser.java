package userOperations;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This class is used to generate the stats needed
 * to create and setup a new user.
 *
 * @author  Nicholas Ingalls
 */

public class CreateUser {
	/**Stores database location - initialized by constructor*/
	String database;
	/**Stores the name of the NPC - initialized by constructor*/
	String user;
	Socket socket;
	BufferedReader input;
	PrintWriter out;


	public CreateUser(Socket s, BufferedReader in, PrintWriter output, String data, String userName){
		database = data;
		user = userName;
		socket = s;
		input = in;
		out = output;
	}

	public void start(){

	}

}
