package Main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class interpretationServer extends Thread{
		
		//This will change the location of the MUD Data-set
		String database = "/Volumes/AMICITIA/Zaos";
		
		private Socket socket;
		private BufferedReader in;
		private PrintWriter out;
		String[] result;

		ArrayList<String> itemList = new ArrayList<String>();
		ArrayList<String> shopList = new ArrayList<String>();
		String[] itemListTemp;
		static String user = "";
		static String age = "<none>";
		static String race = "<none>";
		static String location = "<none>";
		static String name = "<none>";
		static String list = "";
		static int numberofNPC = 0;
		String strLine;
		String direction = "";
		String northRoom, eastRoom, southRoom, westRoom, upRoom, downRoom;
		static int numofItems;
		public void ZaosClient(Socket s) throws IOException {
			socket = s;
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// Enable auto-flush:
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			// If any of the above calls throw an 
			// exception, the caller is responsible for
			// closing the socket. Otherwise the thread
			// will close it.
			start(); // Calls run()
		}
		public void run() {
			out.println ((char)27 + "[2J");
			out.println ((char)27 + "[0m");
			out.println("#################################################");
			out.println("#       "+(char)27 + "[1mWelcome to  The Zaotian Empire"+(char)27 + "[22m          #");
			out.println("#                                               #");
			out.println("# New Characters should ("+(char)27 + "[34mR"+(char)27 + "[0m)egister              #");
			out.println("# Current characters should ("+(char)27 + "[34mL"+(char)27 + "[0m)ogin             #");
			out.println("# To leave the game one should ("+(char)27 + "[34mQ"+(char)27 + "[0m)uit           #");
			out.println("# ("+(char)27 + "[34mP"+(char)27 + "[0m)rint this dialogue                       #");
			out.println("#                                               #");
			out.println("# The Zaot Empire has grown so large that it    #");
			out.println("# now spans the entire width of the galaxy.     #");
			out.println("# Within in the Zaot Empire, various faction    #");
			out.println("# scheme for dominance and control of the       #");
			out.println("# empire. While the Solar Guards strive to keep #");
			out.println("# peace and prevent the fall of the empire.     #");
			out.println("#                                               #");
			out.println("# Who will win? The noble cause of the Solar    #");
			out.println("# Guards or the warring factions within the     #");
			out.println("# empire? Only YOU can decide!                  #");
			out.println("#################################################");
		
			login();
			characterLogin();
		}
		public void login(){
			String str;
			Scanner usrTxt = new Scanner(in);
			String strLine = "";
			boolean failLogin = false;
			boolean login = false;
			while (login==false) {  
				out.println();
				out.println("Select an Option:");
				str = usrTxt.nextLine();
				str = str.trim();
				str = str.toLowerCase();
				if (str.equals("q")){ 
					break;
				} else if (str.equals("r")){
					out.println("Welcome to the Zaotian User Creator");
					out.println("First you must pick a username. This username will be the name of your character so it must be appropriate to a role playing game.");
					boolean createUser = true;
					boolean matchPass = true;
					boolean error = false;
					String strPass="";
					while (createUser==true){
						error = false;
						out.println("");
						out.println("Username:");
						str = usrTxt.nextLine();
						str = str.trim();
						str = str.toLowerCase();
						str=str.replace("\n", "");
						user = str;
						try{
							FileInputStream fstream = new FileInputStream(database + "/Zaot/login/"+user);
							DataInputStream in = new DataInputStream(fstream);
							BufferedReader br = new BufferedReader(new InputStreamReader(in));
							strLine = br.readLine();
							in.close();
						} catch (Exception e){
							createUser = false;
						}
						if (createUser == true){
							out.println("");
							out.println("I'm afraid that username has already been taken.");
						}
					}

					while (matchPass == true){
						out.println("");
						out.println("Password:");

						strPass = usrTxt.nextLine();
						str = str.trim();
						str = str.toLowerCase();
						str=str.replace("\n", "");
						user = str;

						out.println("");
						out.println("");
						out.println("Re-Type Password:");
						String strPassChk = usrTxt.nextLine();
						str = str.trim();
						str = str.toLowerCase();
						str=str.replace("\n", "");

						if (strPass.equals(strPassChk)){
							matchPass = false;
						} else {
							out.println("I'm afraid those passwords don't match! Please try it again.");
						}
					}
					out.println("");
					out.println("");
					out.println("Adding an email acount will allow the administrators to contact you in the event of a problem or future updates. Although this is optional it is recommended.");
					out.println("If you do not want to provide an email address please just press enter.");
					out.println("");
					out.println("Email:");
					str = usrTxt.nextLine();
					str = str.trim();
					str = str.toLowerCase();
					str=str.replace("\n", "");

					try {
						FileWriter fstream = new FileWriter(database + "/Zaot/login/"+user);
						BufferedWriter out = new BufferedWriter(fstream);
						out.write(strPass+"\n");
						out.write(str);
						out.close();
					}catch (Exception e){
					}

					out.println("");
					out.println("Your Profile has been sucessfully created. Please login to continue.");
					out.println("");
				} else if (str.equals("p")){
					out.println ((char)27 + "[2J");
					out.println ((char)27 + "[0m");
					out.println("#################################################");
					out.println("#       "+(char)27 + "[1mWelcome to  The Zaotian Empire"+(char)27 + "[22m          #");
					out.println("#                                               #");
					out.println("# New Characters should ("+(char)27 + "[34mR"+(char)27 + "[0m)egister              #");
					out.println("# Current characters should ("+(char)27 + "[34mL"+(char)27 + "[0m)ogin             #");
					out.println("# To leave the game one should ("+(char)27 + "[34mQ"+(char)27 + "[0m)uit           #");
					out.println("# ("+(char)27 + "[34mP"+(char)27 + "[0m)rint this dialogue                       #");
					out.println("#                                               #");
					out.println("# The Zaot Empire has grown so large that it    #");
					out.println("# now spans the entire width of the galaxy.     #");
					out.println("# Within in the Zaot Empire, various faction    #");
					out.println("# scheme for dominance and control of the       #");
					out.println("# empire. While the Solar Guards strive to keep #");
					out.println("# peace and prevent the fall of the empire.     #");
					out.println("#                                               #");
					out.println("# Who will win? The noble cause of the Solar    #");
					out.println("# Guards or the warring factions within the     #");
					out.println("# empire? Only YOU can decide!                  #");
					out.println("#################################################");
					login();
				} else if (str.equals("l")){
					out.println("");
					out.println("");
					out.println("Username:");
					str = usrTxt.nextLine();
					str = str.trim();
					str = str.toLowerCase();
					str=str.replace("\n", "");
					user = str;
					System.out.println("<Control> - " + user + " is attempting to login");
					logging("<Control> - " + user + " is attempting to login");
					try{
						FileInputStream fstream = new FileInputStream(database + "/Zaot/login/"+user);
						DataInputStream in = new DataInputStream(fstream);
						BufferedReader br = new BufferedReader(new InputStreamReader(in));
						strLine = br.readLine();
						in.close();
					}catch (Exception e){
						out.println("<Control> I'm afraid I can't find that user. Have you created an account yet?");
						out.println("<Control> If you need assistance you can speak to an admin @ nicholas.ingalls@gmail.com");
						failLogin = true;
					}
					if (failLogin==false){
						out.println("");
						out.println("");
						out.println("Password:" + (char)27 + "[8m");				//This ansi code will make the password the user types invisible
						str = usrTxt.nextLine();
						str = str.trim();
						str = str.toLowerCase();
						if (str.equals(strLine)){
							out.println((char)27 + "[0mLogin Sucessful!");			//Ansi reset
							login = true;
							System.out.println("<Control> - " + user + " has sucessfully logged in.");
							logging("<Control> - " + user + " has sucessfully logged in.");
						} else {
							out.println("Incorrect!");
							System.out.println("<Control> - " + user + " has FAILED login.");
							logging("<Control> - " + user + " has FAILED login.");
						}
						failLogin = false;
					}
				}
			}

		}
		public void characterLogin(){
			String strLine;
			boolean loadChar = false;
			int charLen = 0;
			boolean error = true;
			String space = " ";
			out.println("''''''''''''''''''''''''''''''''''''''''''''''''");
			out.println("'              Character Selection             '");
			out.println("'                                              '");
			out.println("' Character:                                   '");

			try{
				FileInputStream fstream = new FileInputStream(database + "/Zaot/characters/"+user);
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				while(loadChar==false){
					strLine = br.readLine();
					charLen = strLine.length();
					charLen = 46 - charLen;
					while (charLen>3){
						space = space.concat(" ");
						charLen--;
					}

					out.println("' ~" + strLine + space +"'");
					space = " ";
					error = false;
				}
				in.close();
			} catch (Exception e){
				if (error==true){
					out.println("");
					out.println("You account looks like it is suffering against data lose! An admin has been notified and we will endeavor to fix it as quickly as possible. Please also drop me a line at nicholas.ingalls@gmail.com");
					out.println("");
					System.out.println("<ERROR> - "+user+" was unable to load any of his character profiles.");
					logging("<ERROR> - "+user+" was unable to load any of his character profiles.");
				}
			}

			out.println("'                                              '");
			out.println("' (P)lay a current Character.                  '");
			out.println("' (C)reate a new Character                     '");
			out.println("' (R)eprint this dialogue                      '");
			out.println("' (L)ogout                                     '");
			out.println("''''''''''''''''''''''''''''''''''''''''''''''''");
			out.println("");
			out.println("");
			out.println("Select an Option:");
			Scanner usrTxt = new Scanner(in);
			String str;
			str = usrTxt.nextLine();
			str = str.trim();
			str = str.toLowerCase();

			if (str.equals("c")){
				out.println("Character Creation:");
				out.println("Name: " + name);
				out.println("Race: " + race);
				out.println("Age: " + age);
				out.println("");
				out.println("Pick a (n)ame");
				out.println("Pick a (r)ace");
				out.println("Choose an (a)ge");
				out.println("(D)one - create my character");
				out.println("(A)bort character creation");
				out.println("");
			} else if (str.equals("p")){
				out.println("");
				out.println("Name of the Character that you would like to play:");
				str = usrTxt.nextLine();
				str = str.trim();
				str = str.toLowerCase();
				try{
					FileInputStream fstream = new FileInputStream(database + "/Zaot/characters/"+user);
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					while(loadChar==false){
						while (name.equals("<none>")){
							strLine = br.readLine();
							if (strLine.equals(str)){
								name = strLine;
							}
						}
					}
					in.close();
				} catch (Exception e){
					out.println("That isn't the name of one of your characters!");
				}
			} else if (str.equals("r")){
				room();
			}
		}
		public void room(){
			numberofNPC = 0;
			list = "";
			try{
				FileInputStream fstream = new FileInputStream(database + "/Zaot/charProfile/"+user+"/"+user+".loc");
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				strLine = br.readLine();
				in.close();
			} catch (Exception e){
				System.out.println("<ERROR> " + user + " was unable to access their user.loc file");
				logging("<ERROR> " + user + " was unable to access their user.loc file");
			}
			strLine = strLine.replace("\n", "");
			location = strLine;
			System.out.println("<Control> - " + user + " has entered " + location);
			logging("<Control> - " + user + " has entered " + location);

			try{
				FileInputStream fstream = new FileInputStream(database + "/Zaot/rooms/"+location+"/"+location);
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				strLine = br.readLine();
				out.println((char)27 + "[34m" + "---"+strLine+"---" + (char)27 + "[0m");
				boolean exitDesc = false;
				while (exitDesc==false){
					strLine = br.readLine();
					if (strLine.equals("<endofdesc>")){
						exitDesc = true;
					} else if (strLine.contains("<Dynamic:")){
						String Dynamic = strLine;
						try{	
							Dynamic = Dynamic.replace("<Dynamic:", "");
							Dynamic = Dynamic.replace(">", "");
							FileInputStream fstream2 = new FileInputStream(database + "/Zaot/DynamicRooms/" + Dynamic + "/" + Dynamic + ".desc");
							DataInputStream in2 = new DataInputStream(fstream2);
							BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
							while (exitDesc==false){
								strLine = br2.readLine();
								if (strLine.equals("<endofdesc>")){
									strLine = br2.readLine();
									exitDesc = true;
								} else
									out.println(strLine);
							}
							in2.close();
						} catch (Exception e){
							System.out.println("<ERROR> " + user + " cannot access a Dynamic room: " + Dynamic);
							logging("<ERROR> " + user + " cannot access a Dynamic room: " + Dynamic);
						}
					} else {
						out.println(strLine); 
					}

				}
				direction = "";
				out.println("");
				strLine = br.readLine();
				if (strLine.contains("[North:none]")){
				} else {
					direction = direction + "[North] ";
				}
				northRoom=strLine;
				northRoom = northRoom.replace("[North:", "");
				northRoom = northRoom.replace("]", "");


				strLine = br.readLine();
				if (strLine.contains("[East:none]")){
				} else {
					direction = direction + "[East] ";
				}		
				eastRoom=strLine;
				eastRoom = eastRoom.replace("[East:", "");
				eastRoom = eastRoom.replace("]", "");


				strLine = br.readLine();
				if (strLine.contains("[South:none]")){
				} else {
					direction = direction + "[South] ";
				}
				southRoom=strLine;
				southRoom = southRoom.replace("[South:", "");
				southRoom = southRoom.replace("]", "");


				strLine = br.readLine();
				if (strLine.contains("[West:none]")){
				} else {
					direction = direction + "[West] ";
				}
				westRoom=strLine;
				westRoom = westRoom.replace("[West:", "");
				westRoom = westRoom.replace("]", "");


				strLine = br.readLine();
				if (strLine.contains("[Up:none]")){
				} else {
					direction = direction + "[Up] ";
				}
				upRoom=strLine;
				upRoom = upRoom.replace("[Up:", "");
				upRoom = upRoom.replace("]", "");


				strLine = br.readLine();
				if (strLine.contains("[Down:none]")){
				} else {
					direction = direction + "[Down] ";
				}
				downRoom=strLine;
				downRoom = downRoom.replace("[Down:", "");
				downRoom = downRoom.replace("]", "");

				out.println((char)27 + "[34m" + direction + (char)27 + "[0m");
				in.close();
			} catch (Exception e){
				System.out.println("<ERROR> " + user + " is located in a room which doesn't exist!");
				logging("<ERROR> " + user + " is located in a room which doesn't exist!");
			}

			NPC();
			objects();
			interpretUsr();
		}
		public void NPC(){
			boolean error = false;
			boolean checkList = true;
			String checkNPC = "";
			try{
				FileInputStream fstream = new FileInputStream(database + "/Zaot/rooms/"+location+"/"+location+".npc");
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));	
				while (error == false){
					strLine = br.readLine();
					result = strLine.split(":");
					try{
						checkNPC = result[numberofNPC];
						checkNPC = checkNPC.replace("[", "");
						checkNPC = checkNPC.replace("]", "");
						checkNPC = checkNPC.replace("\n", "");
						FileInputStream fstream2 = new FileInputStream(database + "/Zaot/npc/"+checkNPC+"/"+checkNPC+".lst");
						DataInputStream in2 = new DataInputStream(fstream2);
						BufferedReader br2 = new BufferedReader(new InputStreamReader(in));	
						in2.close();
					} catch (Exception e){
						System.out.println("ERROR:"+result[numberofNPC]);
						logging("ERROR:"+result[numberofNPC]);
						checkList = false;
					}
					if (checkList==true){
						list = checkNPC;		
					} else {
						checkList = true;
					}
					numberofNPC=numberofNPC+2;
				}
				in.close();
			} catch (Exception e){
				error = true;
			}
			int currentNPC = 0;
			if (numberofNPC != 0){
				while (numberofNPC > currentNPC){
					out.println("["+result[currentNPC]+"] " + result[currentNPC+1]);
					currentNPC = currentNPC+2;
				}
			}
		}
		public void objects(){
			boolean error = false;
			int numofItems = 0;
			int getItemsList = 0;
			error = false;

			try{
				FileInputStream fstream = new FileInputStream(database + "/Zaot/rooms/" + location + "/" + location + ".obj");
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				while (true){
					strLine = br.readLine();
					itemListTemp = strLine.split(":");
					itemList.add(itemListTemp[1]);
					itemList.add(itemListTemp[0]);
					numofItems=numofItems+2;
				}
			} catch (Exception e){
				error = true;
			}
			error = false;

			try {
				while (true){
					if (numofItems==getItemsList){
						break;
					}
					out.println("[" + itemList.get(getItemsList+1)+ "] - " + itemList.get(getItemsList));
					getItemsList = getItemsList + 2;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		public void interpretUsr(){
			String hp = "", xp = "";
			try{
				FileInputStream fstream = new FileInputStream(database + "/Zaot/charProfile/"+user+"/"+user+".hp");
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				strLine = br.readLine();
				hp = strLine;
				in.close();
			} catch (Exception e){
				System.out.println("<ERROR> " + user + " was unable to access their user.hp file");
				logging("<ERROR> " + user + " was unable to access their user.hp file");
			}
			try{
				FileInputStream fstream = new FileInputStream(database + "/Zaot/charProfile/"+user+"/"+user+".xp");
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				strLine = br.readLine();
				xp = strLine;
				in.close();
			} catch (Exception e){
				System.out.println("<ERROR> " + user + " was unable to access their user.xp file");
				logging("<ERROR> " + user + " was unable to access their user.xp file");
			}

			out.println("");
			out.println("(" + hp + " HP/" + xp + " XP):");
			Scanner usrTxt = new Scanner(in);
			String str;
			str = usrTxt.nextLine();
			str = str.trim();
			str = str.toLowerCase();
			if (str.equals("n") | str.equals("north")){
				File bkup = new File(database + "/Zaot/charProfile/"+user+"/"+user+".loc");
				bkup.delete();
				try{
					FileWriter fstream = new FileWriter(database + "/Zaot/charProfile/"+user+"/"+user+".loc");
					BufferedWriter writeout = new BufferedWriter(fstream);
					writeout.write(northRoom);

					try {
						FileInputStream fstream2 = new FileInputStream(database + "/Zaot/rooms/"+location+"/"+location+".n");
						DataInputStream in = new DataInputStream(fstream2);
						BufferedReader br = new BufferedReader(new InputStreamReader(in));
						out.println();
						out.println(br.readLine());
						out.println();
						br.close();
					} catch (Exception e) {
						out.println();
						out.println("You walk to the north.");
						out.println();
					}


					writeout.close();
				} catch (Exception e){

				}
				room();
			} else if (str.equals("e") | str.equals("e")){
				File bkup = new File(database + "/Zaot/charProfile/"+user+"/"+user+".loc");
				bkup.delete();
				try{
					FileWriter fstream = new FileWriter(database + "/Zaot/charProfile/"+user+"/"+user+".loc");
					BufferedWriter writeout = new BufferedWriter(fstream);
					writeout.write(eastRoom);
					try {
						FileInputStream fstream2 = new FileInputStream(database + "/Zaot/rooms/"+location+"/"+location+".e");
						DataInputStream in = new DataInputStream(fstream2);
						BufferedReader br = new BufferedReader(new InputStreamReader(in));
						out.println();
						out.println(br.readLine());
						out.println();
						br.close();
					} catch (Exception e) {
						out.println();
						out.println("You walk to the east.");
						out.println();
					}

					writeout.close();
				} catch (Exception e){

				}
				room();
			} else if (str.equals("s") | str.equals("south")){
				File bkup = new File(database + "/Zaot/charProfile/"+user+"/"+user+".loc");
				bkup.delete();
				try{
					FileWriter fstream = new FileWriter(database + "/Zaot/charProfile/"+user+"/"+user+".loc");
					BufferedWriter writeout = new BufferedWriter(fstream);
					writeout.write(southRoom);
					try {
						FileInputStream fstream2 = new FileInputStream(database + "/Zaot/rooms/"+location+"/"+location+".s");
						DataInputStream in = new DataInputStream(fstream2);
						BufferedReader br = new BufferedReader(new InputStreamReader(in));
						out.println();
						out.println(br.readLine());
						out.println();
						br.close();
					} catch (Exception e) {
						out.println();
						out.println("You walk to the south.");
						out.println();
					}
					writeout.close();
				} catch (Exception e){

				}
				room();
			} else if (str.equals("w") | str.equals("west")){
				File bkup = new File(database + "/Zaot/charProfile/"+user+"/"+user+".loc");
				bkup.delete();
				try{
					FileWriter fstream = new FileWriter(database + "/Zaot/charProfile/"+user+"/"+user+".loc");
					BufferedWriter writeout = new BufferedWriter(fstream);
					writeout.write(westRoom);
					try {
						FileInputStream fstream2 = new FileInputStream(database + "/Zaot/rooms/"+location+"/"+location+".w");
						DataInputStream in = new DataInputStream(fstream2);
						BufferedReader br = new BufferedReader(new InputStreamReader(in));
						out.println();
						out.println(br.readLine());
						out.println();
						br.close();
					} catch (Exception e) {
						out.println();
						out.println("You walk to the west.");
						out.println();
					}
					writeout.close();
				} catch (Exception e){

				}
				room();
			} else if (str.equals("d") | str.equals("down")){
				File bkup = new File(database + "/Zaot/charProfile/"+user+"/"+user+".loc");
				bkup.delete();
				try{
					FileWriter fstream = new FileWriter(database + "/Zaot/charProfile/"+user+"/"+user+".loc");
					BufferedWriter writeout = new BufferedWriter(fstream);
					writeout.write(downRoom);

					try {
						FileInputStream fstream2 = new FileInputStream(database + "/Zaot/rooms/"+location+"/"+location+".d");
						DataInputStream in = new DataInputStream(fstream2);
						BufferedReader br = new BufferedReader(new InputStreamReader(in));
						out.println();
						out.println(br.readLine());
						out.println();
						br.close();
					} catch (Exception e) {
						out.println();
						out.println("You climb down.");
						out.println();
					}

					writeout.close();
				} catch (Exception e){

				}
				room();
			} else if (str.equals("u") | str.equals("up")){
				File bkup = new File(database + "/Zaot/charProfile/"+user+"/"+user+".loc");
				bkup.delete();
				try{
					FileWriter fstream = new FileWriter(database + "/Zaot/charProfile/"+user+"/"+user+".loc");
					BufferedWriter writeout = new BufferedWriter(fstream);
					writeout.write(upRoom);

					try {
						FileInputStream fstream2 = new FileInputStream(database + "/Zaot/rooms/"+location+"/"+location+".u");
						DataInputStream in = new DataInputStream(fstream2);
						BufferedReader br = new BufferedReader(new InputStreamReader(in));
						out.println();
						out.println(br.readLine());
						out.println();
						br.close();
					} catch (Exception e) {
						out.println();
						out.println("You climb up.");
						out.println();
					}

					writeout.close();
				} catch (Exception e){

				}
				room();
			}  else if (str.contains("help")){
				str.replace("help ", "");
				help(str);
				interpretUsr();
			} else if (str.contains("jump")){
				out.println("You jump up and down on the spot.");
				interpretUsr();
			}	else if (str.contains("kiss")){
				out.println("Your advances would not be appreciated!");
				interpretUsr();
			} else if (str.equals("l")| str.contains("look") | str.equals("")){
				room();
			} else if (str.equals("list") | str.contains("buy ")){
				try {
					list(str);
				} catch (IOException e) {
					System.out.println("<ERROR> " + user + " can not access the shop list found in " + list);
					logging("<ERROR> " + user + " can not access the shop list found in " + list);
				}
				interpretUsr();
			} else if (str.contains("fight ")){
				String character = str;
				character = character.replace("fight ", "");
				fight(character);
			} else if (str.contains("examine ")){
				String examine = str;
				examine = examine.replace("examine ", "");
				examine(examine);
			} else if (str.contains("quit")){
				quit();
			} else if (str.equals("inventory")|str.equals("i")|str.equals("inv")){
				inv();
				interpretUsr();
			} else if (str.contains("take ")){
				take();
				interpretUsr();
			} else if (str.contains("drop ")){
				drop(str);
				interpretUsr();
			} else if (str.equals("stop")){
				stopServer();
			} else {
				out.println("Sorry, I can't do that!");
				interpretUsr();
			}

		}
		public void list(String str) throws IOException{
			boolean buyList = false;					//If true user is buying, if false user is listing
			if (str.contains("buy ")){
				buyList = true;
			}
			String shop = "";
			ArrayList<String> shopList = new ArrayList<String>();
			String[] shopListTemp;
			boolean error = false;
			int numofItems = 0;
			int getItemsList = 0;
			error = false;

			try{
				FileInputStream fstream = new FileInputStream(database + "/Zaot/npc/"+list+"/"+list+".lst");
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				while (true){
					strLine = br.readLine();
					shopListTemp = strLine.split(":");
					shopList.add(shopListTemp[1]);
					strLine = br.readLine();
					shopListTemp = strLine.split(":");
					shopList.add(shopListTemp[1]);
					numofItems=numofItems+2;
				}
			} catch (Exception e){
				error = true;
			}
			error = false;

			if (buyList==false){
				out.println("Cost   Item");
				try {
					while (true){
						out.println(shopList.get(getItemsList+1)+ " " + shopList.get(getItemsList));
						getItemsList = getItemsList + 2;
						if (numofItems==getItemsList){
							break;
						}

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				str = str.replace("buy ", "");
				str = str.toLowerCase();
				try {
					int loc = 0;
					int gld = 0, price = 0;
					while (true){
						shop = shopList.get(loc);
						shop = shop.toLowerCase();
						if (shop.equals(str)){
							try{
								FileInputStream fstream = new FileInputStream(database + "/Zaot/charProfile/"+user+"/"+user+".gld");
								DataInputStream in = new DataInputStream(fstream);
								BufferedReader br = new BufferedReader(new InputStreamReader(in));
								strLine = br.readLine();
								in.close();
								gld = Integer.parseInt(strLine);
								price = Integer.parseInt(shopList.get(loc + 1));
							} catch (Exception e){
								System.out.println("<ERROR> " + user + " was unable to access their user.gld file");
								logging("<ERROR> " + user + " was unable to access their user.gld file");
							}
							if (gld>price){
								File file = new File(database + "/Zaot/charProfile/"+user+"/"+user+".gld");
								file.delete();
								try {
									FileWriter fstream = new FileWriter(database + "/Zaot/charProfile/"+user+"/"+user+".gld");
									BufferedWriter out = new BufferedWriter(fstream);
									gld = gld - price;
									out.write("" + gld);
									out.close();
								}catch (Exception e){
								}
								try{
									// Create file 
									FileWriter fstream = new FileWriter(database + "/Zaot/charProfile/"+user+"/"+user+".inv",true);
									BufferedWriter out = new BufferedWriter(fstream);
									out.write("1:"+str + "\n");
									//Close the output stream
									out.close();
								}catch (Exception e){//Catch exception if any
									System.err.println("Error: " + e.getMessage());
									logging("Error: " + e.getMessage());
								}
								out.println(str+" has been added to your inventory.");
								break;
							} else {
								out.println("You don't have that much money!");
								break;
							}
						}
						loc = loc + 2;
					}
				} catch (Exception e) {
					out.println("That item isn't offered in this store!");
				}

			}
		}
		public void examine(String examine){
			String[] examineTemp;
			String testExamine = "";
			try{
				FileInputStream fstream = new FileInputStream(database + "/Zaot/rooms/"+location+"/"+location+".ex");
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				while (true){
					strLine = br.readLine();
					examineTemp = strLine.split(":");
					testExamine = examineTemp[0];

					if (testExamine.equals(examine)){
						break;
					}
				}
				out.println(examineTemp[1]);
				in.close();
			} catch (Exception e){
				out.println("I'm afraid there isn't anything by that name to examine!");
			}

			interpretUsr();
		}
		public void sleep(){
			//TODO Sleep increases the rate at which health is regenerated.
		}
		public void score(){
			//TODO Have a nicely formated table that prints out lvl, hp, etc.
		}
		public void fight(String character){
			boolean continueOn = false;
			String characterActual = "", hurtDesc = "", killDesc = "", userWeapon = "", NPCweapon = "", userHurtdesc = "", userKilldesc = "";
			int NPCaccuracy = 0, userAccuracy = 0, userMindamage = 0, userMaxdamage = 0, maxDamage = 0, minDamage = 0;
			String[] characterSplit;

			try{
				FileInputStream fstream = new FileInputStream(database + "/Zaot/rooms/"+location+"/"+location+".npc");
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				while (true){
					strLine = br.readLine();
					characterSplit = strLine.split(":");
					characterActual = characterSplit[0];
					strLine = characterSplit[0];
					strLine = strLine.toLowerCase();
					strLine = strLine.replace("-", " ");
					character = character.toLowerCase();
					character = character.replace("-", " ");

					if (strLine.contains(character)){
						continueOn = true;
						break;
					}
				}
				in.close();
			} catch (Exception e){
				out.println("You can't fight someone if they aren't in the room with you!");
			}
			if (continueOn==true){
				try{
					FileInputStream fstream = new FileInputStream(database + "/Zaot/charProfile/" + user + "/" + user + ".wld");
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					while(true){
						strLine = br.readLine();
						if (strLine.contains("[right-hand:")){
							strLine = strLine.replace("[right-hand:", "");
							strLine = strLine.replace("]", "");
							userWeapon = strLine;
							break;
						}
					}
					in.close();
				} catch (Exception e){
					System.out.println("<ERROR> " + user + " was unable to access  their .wld file");
					logging("<ERROR> " + user + " was unable to access  their .wld file");
				}
				try{
					FileInputStream fstream = new FileInputStream(database + "/Zaot/npc/" + characterActual + "/" + characterActual + ".inv");
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					while(true){
						strLine = br.readLine();
						if (strLine.contains("[right-hand:")){
							strLine = strLine.replace("[right-hand:", "");
							strLine = strLine.replace("]", "");
							NPCweapon = strLine;
							break;
						}
					}
					in.close();
				} catch (Exception e){
					System.out.println("<ERROR> " + user + " was unable to access NPC " + characterActual + " inv file");
					logging("<ERROR> " + user + " was unable to access NPC " + characterActual + " inv file");
				}
				try{
					FileInputStream fstream = new FileInputStream(database + "/Zaot/objects/weapons/"+NPCweapon);
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					while(true){
						strLine = br.readLine();
						if (strLine.contains("minDamage:")){
							strLine = strLine.replace("minDamage:", "");
							minDamage = Integer.parseInt(strLine);
						} else if (strLine.contains("maxDamage:")){
							strLine = strLine.replace("maxDamage:", "");
							maxDamage = Integer.parseInt(strLine);
						} else if (strLine.contains("hurtDesc:")){
							strLine = strLine.replace("hurtDesc:", "");
							hurtDesc = strLine;
						} else if (strLine.contains("killDesc:")){
							strLine = strLine.replace("killDesc:", "");
							killDesc = strLine;
							break;
						} else if (strLine.contains("accuracy:")){
							strLine = strLine.replace("accuracy:", "");
							NPCaccuracy = Integer.parseInt(strLine);	
						}
					}
					in.close();
				} catch (Exception e){
					System.out.println("<ERROR> " + user + " was unable to access obj " + characterActual + " file");
					logging("<ERROR> " + user + " was unable to access obj " + characterActual + " file");
				}
				
				try{
					FileInputStream fstream = new FileInputStream(database + "/Zaot/objects/weapons/"+userWeapon);
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					while(true){
						strLine = br.readLine();
						if (strLine.contains("minDamage:")){
							strLine = strLine.replace("minDamage:", "");
							userMindamage = Integer.parseInt(strLine);
						} else if (strLine.contains("maxDamage:")){
							strLine = strLine.replace("maxDamage:", "");
							userMaxdamage = Integer.parseInt(strLine);
						} else if (strLine.contains("hurtDesc:")){
							strLine = strLine.replace("hurtDesc:", "");
							userHurtdesc = strLine;
						} else if (strLine.contains("killDesc:")){
							strLine = strLine.replace("killDesc:", "");
							userKilldesc = strLine;	
							break;
						} else if (strLine.contains("accuracy:")){
							strLine = strLine.replace("accuracy:", "");
							userAccuracy = Integer.parseInt(strLine);
						}
					}
					in.close();
				} catch (Exception e){
					System.out.println("<ERROR> " + user + " was unable to access obj " + characterActual + " file");
					logging("<ERROR> " + user + " was unable to access obj " + characterActual + " file");
				}

				Random r = new Random();
				int gunDamage = r.nextInt(maxDamage-minDamage) + minDamage;
				int userGundamage = r.nextInt(userMaxdamage-userMindamage) + userMindamage;
				//TODO Generate number between 1 and 100 and see if it is within accuracy check...
				int accuracyCheck = r.nextInt(100);
				int userAccuracyCheck = r.nextInt(100);
				
				System.out.println(accuracyCheck + " accuracy:" + NPCaccuracy);
				logging(accuracyCheck + " accuracy:" + NPCaccuracy);
				
				if(accuracyCheck>NPCaccuracy){
					out.println(characterActual + " attempts to kill you but misses!");
				} else {
					out.println(characterActual + " attacks! " + hurtDesc + " [Damage:" +gunDamage+"]");
				}
				if(accuracyCheck>userAccuracy){
					out.println(user + " attempts to kill " + characterActual + " but misses!");
				} else {
					out.println(user + " attacks! " + userHurtdesc + " [Damage:" +userGundamage+"]");
				}
				


			}
			interpretUsr();
		}
		public void help(String input){ //TODO This code should not be hard-coded. This needs to be removed and re-encoded into a text file that is read
			if (input.equals("terrarians")){
				out.println("The Terrarians originated on planet Earth in the system Sol.");
				out.println("");
				out.println("It has often been said that in older times, the Earth was a marvel"); 
				out.println("of planetary beauty. However, during the third and final tropospheric");
				out.println("revolution, much of Earth's natural beauty was transformed into ");
				out.println("industrial waste-land. The pollution amount eventually became so ");
				out.println("high, it led the commander Julius the 3rd to remark idly, 'The whole");
				out.println("quadrant at my hand, and a trash can at my disposal.' ");
				out.println("");
				out.println("The Terranians have always been at the fore-front of the innovative"); 
				out.println("worlds. Producing many galaxy renown scientists. Much of Earth's");
				out.println("technology is shared within the Zaotian Empire though their large ");
				out.println("pirate fleet is always equipped with the very latest. The Terrarians");
				out.println("are eager explorers and have many colonies spread throughout the ");
				out.println("galaxy.");
				out.println("");
				out.println("Earth has a Military ruled government built on a system of Sars.");
				out.println("Currently reigning is Sar Grule the 1st, whose diplomatic ties were"); 
				out.println("severely crippled after the Croctail Nebula Ambush. Therefore the ");
				out.println("Terrarians have very weak ties with the Solar Guards as well.");
			} else if (input.equals("")){

			} else if (input.equals("")){

			} else if (input.equals("")){

			} else if (input.equals("")){

			}else if (input.equals("")){

			} else {
				out.println("I'm afraid there isn't any help avaliable for that topic");
			}

		}
		public void quit(){
			out.println("We only part to meet again.");
			System.out.println("<Control> - " + user + " has left the game.");
			logging("<Control> - " + user + " has left the game.");
			try {
				socket.close();
			} catch(IOException e) {
				System.out.println("<ERROR> - Could not close connection with user");
				logging("<ERROR> - Could not close connection with user");
			}
		}
		public void inv(){
			String[] inventory;
			out.println("");
			out.println("--Inventory--");
			out.println("#   Name");
			try{
				FileInputStream fstream = new FileInputStream(database + "/Zaot/charProfile/"+user+"/"+user+".inv");
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));	

				while ((strLine = br.readLine()) != null){
					inventory = strLine.split(":");
					out.println(inventory[0] + " " + inventory[1]);
				}
				br.close();
			} catch (Exception e){
				System.out.println("<ERROR> " + user + " cannot access their inventory file");
				logging("<ERROR> " + user + " cannot access their inventory file");
			}
		}
		public void take(){
			//Allows a user to pick up an object from the ground
			//SYNTAX take $obj$ or take $obj$ ##
			

		
			
		}
		public void drop(String userInpt){
			//Allows a user to drop and object from their inventory
			//SYNTAX drop $obj$ or drop $obj$ ## or drop $obj$ all
			
			//Delete inv file and then re-write without the dropped item
			
			//Read room inv file into array
			//Add num if inv item is already in room or create a new entry at end of array
			//Delete room inv file and re-write
			
			ArrayList<String> stringInv = new ArrayList<String>();
			ArrayList<Integer> numInv = new ArrayList<Integer>();
			ArrayList<String> stringRoom = new ArrayList<String>();
			ArrayList<String> numRoom = new ArrayList<String>();
			String[] inventory, userInputSplitter;
			int invNum = 0;
			int dropNum = 0; //The number of items to drop (-1 represents all items by that name in inv)
			String dropName = ""; //The name of the item to drop
			try{
				FileInputStream fstream = new FileInputStream(database + "/Zaot/charProfile/"+user+"/"+user+".inv");
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));	

				while ((strLine = br.readLine()) != null){
					inventory = strLine.split(":");
					numInv.add(Integer.parseInt(inventory[0]));
					stringInv.add(inventory[1]);
				}
				br.close();
			} catch (Exception e){
				System.out.println("<ERROR> " + user + " cannot access their inventory file");
				logging("<ERROR> " + user + " cannot access their inventory file");
			}
			
			userInpt = userInpt.replace("take ", "");
			userInputSplitter = userInpt.split(" ");
			if (userInputSplitter[1] == null){
				dropNum = 1;
			} else if (userInputSplitter[1] == "all"){
				dropNum = -1;
			} else {
				try {
					dropNum = Integer.parseInt(userInputSplitter[1]);
				} catch (NumberFormatException e) {
					out.println("The item you want to drop must be one word");
					System.out.println("dropNum: " + dropNum);
					System.out.println("userInputSplitter: " + userInputSplitter[1]);
					System.out.println();
					System.out.println();
					interpretUsr();
				}
			}
			
			
			int i=0;
			try {
				while (true){
					if (dropName.equals(stringInv.get(i))){
						break;
					}
					
					i++;
				}
			} catch (Exception e) {
					out.println("You can't drop an item that you don't have!");
					interpretUsr();
			}
			
			if (dropNum > 0){
				int tempInv = numInv.get(i);
				tempInv=tempInv-dropNum;
				numInv.set(i, tempInv);
			} else if (dropNum == -1){
				dropNum = numInv.get(i);
			} else {
				out.println("Sorry, I can't drop that many items!");
				interpretUsr();
			}
			
			File file = new File(database + "/Zaot/charProfile/"+user+"/"+user+".inv");
			file.delete();
			try{
				// Create file 
				FileWriter fstream = new FileWriter(database + "/Zaot/charProfile/"+user+"/"+user+".inv",true);
				BufferedWriter fileOut = new BufferedWriter(fstream);
				int invCounter = 0;
				while(true){
					if (numInv.get(invCounter) > 0){
						fileOut.write(numInv.get(invCounter) +":" + stringInv.get(invCounter));
						fileOut.newLine();
					}
					invCounter++;
					
					if (numInv.size() == invCounter){
						break;
					}
				}
				
				//Close the output stream
				fileOut.close();
			}catch (Exception e){//Catch exception if any
				System.err.println("Error: " + e.getMessage());
				logging("Error: " + e.getMessage());
			}
			
			
		}
		public void stopServer(){

			System.out.println("<CONTROL> " + user + " is attempting to stop the server");
			logging("<CONTROL> " + user + " is attempting to stop the server");
			out.println("Preparing to stop the server...");
			try {
				FileInputStream fstream2 = new FileInputStream(database + "/Zaot/charProfile/"+user+"/GOD");
				DataInputStream in = new DataInputStream(fstream2);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				br.close();
				System.out.println("<CONTROL>" + user + "has stopped the server");
				logging("<CONTROL>" + user + "has stopped the server");
				System.exit(0);
			} catch (Exception e) {
				out.println("You are not a GOD, I can't let you do that!");
				System.out.println("<CONTROL> " + user + " failed to stop the server.");
				logging("<CONTROL> " + user + " failed to stop the server.");
				interpretUsr();
			}
		}
		public void logging(String logPhrase){
			try{
	    		File file = new File(database + "/Zaot/logs/"+user+".log");
	    		//if file doesn't exists, then create it
	    		if(!file.exists()){
	    			file.createNewFile();
	    		}
	    		//true = append file
	    		BufferedWriter bW = new BufferedWriter(new FileWriter(database + "/Zaot/logs/"+user+".log", true));
	    	    bW.write(logPhrase);
	    	    bW.newLine();
	    	    bW.close();
	    	}catch(IOException e){
	    		e.printStackTrace();
	    	}
	    	
	    	/** Removed as high server loads could cause multiple threads to access this file at the same time, creating syncronization problems
	    	try{
	    		File file = new File(database + "/Zaot/logs/server.log");
	    		//if file doesn't exists, then create it
	    		if(!file.exists()){
	    			file.createNewFile();
	    		}
	    		//true = append file
	    		BufferedWriter bW = new BufferedWriter(new FileWriter(database + "/Zaot/logs/server.log", true));
	    	    bW.write(logPhrase);
	    	    bW.newLine();
	    	    bW.close();
	    	}catch(IOException e){
	    		e.printStackTrace();
	    	}
	    	**/
		}
}
