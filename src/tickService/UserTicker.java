package tickService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import userInterface.setColor;

public class UserTicker{

	Timer timer;
	public Socket socket;
	public PrintWriter out;
	public String database;
	public String user;
	public String strLine;

	public UserTicker(Socket s, String data, String name){
		socket = s;
		database = data;
		user = name;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Chat Stream Failed for " + user);
		}
	}

	public void begin(){
		//Chat Functions
		boolean chatPrinted = false;
		try{
			FileInputStream fstream = new FileInputStream(database + "/charProfile/"+user+"/chat");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			while ((strLine = br.readLine()) != null){
				setColor setColor = new setColor();
				strLine = setColor.color(strLine);
				out.println(strLine);
				if (strLine!=null){
					chatPrinted=true;
				}
			}
			br.close();
		} catch (Exception e){
			System.out.println("<ERROR> " + user + " cannot access their chat file");
		}
		if (chatPrinted==true){
			chatPrinted = false;
			File file = new File(database + "/charProfile/"+user+"/chat");
			file.delete();
			File newFile = new File(database + "/charProfile/"+user+"/chat");
			try {
				newFile.createNewFile();
			} catch (IOException e1) {
				System.out.println("<ERROR> " + user + " cannot create new chat file");
			}
		}

		//Health Regen
		HealthTick HT = new HealthTick(database, user);



		//Start Timer Again
		int milliseconds = 500;
		timer = new Timer();
		timer.schedule(new RemindTask(), milliseconds);
	}

	class RemindTask extends TimerTask{
		@Override
		public void run(){
			timer.cancel();
			begin();

		}
	}
}
