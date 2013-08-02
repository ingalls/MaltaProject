package remoteConnection;

import getValue.LoginValue;
import getValue.RoomValue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import maltaProject.FileOperations;

public class RemoteInterpreter {

	PrintWriter out = null;

	BufferedReader in;

	String database;

	boolean AUTH = false;

	String username = "";

	String password = "";

	public RemoteInterpreter(Socket socket, String data){
		System.out.println("Remote connection");

		database = data;

		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			interpreter();
		} catch (IOException e) {
			System.out.println("Error: cannot open printstream for RemoteConnection");
			System.out.println("Destoying Thread");
			Thread.currentThread().destroy();
		}

	}

	public void interpreter(){
		//Settable Variables
		String area = "";
		String room = "";

		while (true){
			System.out.println((!password.equals("")) && (!username.equals("")) && AUTH == false);
			if ((!password.equals("")) && (!username.equals("")) && AUTH == false){
				checkLogin(username, password);
			}

			String input = input();

			if (AUTH == false){
				if (input.contains("&username&:")){
					username = input.replace("&username&:", "");
				} else if (input.contains("&password&:")){
					password = input.replace("&password&:", "");
				}

			} else {
				if (input.contains("&area-list&")){
					FileOperations FO = new FileOperations(database+"/rooms/");
					String[] dirList = FO.getDirectory();
					String areaList = "&area-list&:";
					int parser = 0;

					while (parser <= dirList.length - 1){
						System.out.println(areaList);
						areaList = areaList + dirList[parser] + ",";
						parser++;
					}

					output(areaList);

				} else if (input.contains("&room-title-list&")){
					FileOperations FO = new FileOperations(database+"/rooms/" + area + "/");
					System.out.println(database+"/rooms/" + area + "/");
					String[] dirList = FO.getDirectoryFolders();
					String roomList = "&room-title-list&:";
					int parser = 0;

					while (parser <= dirList.length - 1){
						RoomValue RV = new RoomValue(database, dirList[parser]);
						roomList = roomList +  RV.getTitle() + ",";
						parser++;
					}

					output(roomList);

				} else if (input.contains("&room-list&")){
					FileOperations FO = new FileOperations(database+"/rooms/" + area + "/");
					System.out.println(database+"/rooms/" + area + "/");
					String[] dirList = FO.getDirectoryFolders();
					String roomList = "&room-list&:";
					int parser = 0;

					while (parser <= dirList.length - 1){
						System.out.println(roomList);
						roomList = roomList + dirList[parser] + ",";
						parser++;
					}

					output(roomList);
				} else if (input.contains("&set-working-area&:")){
					area = input.replace("&set-working-area&:", "");
					System.out.println("Setting area:" + area);
				} else if (input.contains("&set-working-room&:")){
					System.out.println("Setting room:" + input);
					room = input.replace("&set-working-room&:", "");
				}
			}
		}
	}

	public void checkLogin(String username, String password){
		LoginValue LV = new LoginValue(database, username);
		if (!LV.checkUser()){
			output("&incorrect-user&");
		} else if (!LV.checkPassword(password)){
			output("&incorrect-password&");
		} else {
			AUTH = true;
			System.out.println(username + " Authenticated");
			output("&authenticated&");
		}
	}

	public String input(){
		try {
			String input = "";
			input = in.readLine();
			return input;
		} catch (IOException e) {
			System.out.println("Could not recieve input from connection");
			return "";
		}
	}

	public void output(String outputText){
		out.println(outputText + "\r\n");
	}
}
