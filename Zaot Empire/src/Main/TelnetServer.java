package Main;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TelnetServer {
	static String database = "/Volumes/AMICITIA/Zaos";
	static final int PORT = 1337;
	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(PORT);
		System.out.println("Server Started");
		check();
		try {
			while(true) {
				// Blocks until a connection occurs:
				Socket socket = s.accept();
					interpretationServer IS = new interpretationServer();
					IS.ZaosClient(socket);
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