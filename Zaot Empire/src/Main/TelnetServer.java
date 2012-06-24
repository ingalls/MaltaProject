package Main;

import java.io.*;
import java.net.*;

public class TelnetServer {
	
	//-------------Change-With-Caution-----------------
	//This will change the location of the MUD Data-set
	static String database = "/Users/sherryingalls/git";
	//This will change the port for the MUD
	static final int PORT = 1337;
	//-------------------------------------------------
	
	
	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(PORT);
		System.out.println("Server Started");
		check();
		try {
			while(true) {
				// Blocks until a connection occurs:
				Socket socket = s.accept();
					interpretationServer IS = new interpretationServer();
					IS.ZaosClient(socket, database);
			}
		} finally {
			s.close();
		}
	} 
	public static void check(){
		boolean error = false;
		System.out.println("<Control> Checking for Database");
		try{
			FileInputStream fstream = new FileInputStream(database + "/Zaot/check");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			in.read();
			in.close();
		} catch (Exception e){
			System.out.println("<ERROR> The Server cannot connect to the database!");
			System.out.println("<ERROR> Make sure that the database address is correct");
			error = true;
		}
		if (error==false){
			System.out.print("<Control> Database OKAY");
		}
	}
}