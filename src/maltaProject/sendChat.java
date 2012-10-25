package maltaProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class sendChat {
	public String database;
	public String user;
	public String strLine;
	//---Chat Variables---//
		
	public sendChat(String data, String name) {
		database = data;
		user = name;
	}
	
	//Chat Input Statements
	public void ooc(String chatString){
		chatString = chatString.replace("ooc ", "");
		try{
			FileInputStream fstream = new FileInputStream(database + "/who");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));	

			while ((strLine = br.readLine()) != null){
				
				try{
					BufferedWriter bW = new BufferedWriter(new FileWriter(database + "/charProfile/"+strLine+"/chat", true));
					bW.write(user + " oocs " +"[green] '" + chatString + "'[white]");					
					bW.newLine();
					bW.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			br.close();
		} catch (Exception e){
			System.out.println("<ERROR> " + user + " cannot access chat file of "+strLine);
		}
	}
	public void ic(String chatString){
		chatString = chatString.replace("ic ", "");
		try{
			FileInputStream fstream = new FileInputStream(database + "/who");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));	

			while ((strLine = br.readLine()) != null){
				try{
					BufferedWriter bW = new BufferedWriter(new FileWriter(database + "/charProfile/"+strLine+"/chat", true));
					bW.write(user + " ics " +"[purple] '"+ chatString+"'[white]");					
					bW.newLine();
					bW.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			br.close();
		} catch (Exception e){
			System.out.println("<ERROR> " + user + " cannot access chat file of "+strLine);
		}
	}
	public void tell(String chatString){//TODO finish
	}
	public void say(){//TODO finish

	}
	public void yell(){//TODO finish
}
}
