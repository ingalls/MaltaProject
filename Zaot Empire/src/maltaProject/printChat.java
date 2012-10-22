package maltaProject;

import java.io.*;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

public class printChat{
	
	Timer timer;
	public Socket socket;
	public PrintWriter out;
	public String database;
	public String user;
	public String strLine;
	
	public printChat(Socket s, String data, String name){
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
		
		
		
		int milliseconds = 500;
		timer = new Timer();
		timer.schedule(new RemindTask(), milliseconds);
	}
	
	class RemindTask extends TimerTask{
		public void run(){
			timer.cancel();
			begin();
			
		}
	}
}
