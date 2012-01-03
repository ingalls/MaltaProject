package Main;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TelnetServer {
	static final int PORT = 1337;
	public static void main(String[] args)
	throws IOException {
		ServerSocket s = new ServerSocket(PORT);
		System.out.println("Server Started");
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
}