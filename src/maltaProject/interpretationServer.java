package maltaProject;

import getValue.InstanceNPCValue;
import getValue.NPCValue;
import getValue.ObjectValue;
import getValue.RoomValue;
import getValue.UserValue;

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
import java.util.Enumeration;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import userOperations.Inventory;
import chatService.sendChat;
import chatService.startChat;


/**
 * This class obtains user input. It then analyzes the input and chooses the appropriate action.
 *
 * @author  Nicholas Ingalls
 */


//--- TODO Section ---
//TODO SkillsValue
//TODO DropValue
//TODO HelpRetrieval

//TODO ClassValue --used for stat gen on usr creation
//TODO religionValue --used for stat gen on usr creation
//TODO raceValue --used for stat gen on usr creation

//TODO Delete instanceObjects, InstanceNPCs, Objects, NPC's, Rooms (Need to import apache FileUtils)
//TODO ***KILL CHAT THREAD WHEN USER LOGS OUT***
//TODO Redo Fight Code
//TODO Add some sort of examine code for inv items
//TODO Finish drop()
//TODO start take()
//TODO Make skills() command. This command would print the skills a character currently has
//TODO make learn() command. This command would print the skills that a character can gain. This information is stored in the profession folder under skills
//TODO make some exits require an object.
//TODO Create chat
//finish Yell (To Room and rooms surrounding), Tell, Say? (To room)
//OOC Green, IC purple, Yell red, tell blue, Add OPRAY. Add mute support except for opray
//TODO Give() command
//TODO Make health/hp bar color depending on percentage. (50+ green)(25+ white)(15+ yellow)(0+ red)
//TODO when user exits it currently wipes who file instead of removing single entry.
//TODO *** Timer needs to work in a new thread or else it screws up the users location within the program. This is evident from the inability to utilize the wizard dialogue and also from the healthbar menu.
//TODO Drop & Take

public class interpretationServer extends Thread{
	//---Called Classes---//
	setColor setColor = new setColor(); //Used to change color tags to ascii colors

	//---Database Location---//
	String database = null; //Database address is passed to interpretationServer() from TelnetServer(). To modify path edit TelnetServer()

	//---Telnet Socket---//
	public Socket socket; //Stores socket
	public BufferedReader in; //Input through soocket from user
	public PrintWriter out; //Output through socket to user

	//---Character Variables---//
	static String user = "";
	String age = "<none>";
	String race = "<none>";
	String location = "<none>";
	String name = "<none>";
	int hp = 0;
	int maxHp = 0;
	int xp = 0;
	int maxXp = 0;

	String list = "";
	String[] result;
	ArrayList<String> itemList = new ArrayList<String>(), shopList = new ArrayList<String>();
	String[] itemListTemp;
	static int numberofNPC = 0;
	boolean sleep = false; //True if the user is sleeping
	String strLine; //String from the scanner class - AKA user input
	String direction = "";
	String northRoom, eastRoom, southRoom, westRoom, upRoom, downRoom; //The program loads all rooms adjacent to the users current position.
	static int numofItems;
	boolean show = true; //decides whether to show the intro screen. For example if a password is incorrect, the intro screen will not be shown.
	boolean startup = true;
	boolean north = false, south = false, east = false, west = false, up = false, down = false;
	public void ZaosClient(Socket s, String databaseLoc) throws IOException {
		database = databaseLoc;
		socket = s;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// Enable auto-flush:
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		// If any of the above calls throw an exception, the caller is responsible for closing the socket. Otherwise the thread will close it.
		start(); // Calls run
	}
	@Override
	public void run() {
		login();
	}
	public void login(){//Account Login Page

		if (startup == true){
			out.println ((char)27 + "[2J");
			out.println ((char)27 + "[0m");
			startup = false;
		}
		if (show==true){
			show = false;
			out.println("");
			try{
				FileInputStream fstream = new FileInputStream(database + "/interface/welcome");
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));

				while ((strLine = br.readLine()) != null){
					setColor setColor = new setColor();
					strLine = setColor.color(strLine);
					out.println(strLine);
				}
				br.close();
			} catch (Exception e){
				System.out.println("An incoming user can't access welcome interface");
				logging("An incoming user can't access welcome interface");
			}
		}

		String str;
		Scanner usrTxt = new Scanner(in);
		String strLine = "";
		boolean failLogin = false;
		boolean login = false;
		while (login==false) {
			out.println();
			out.println("p to reprint options");
			out.println("Select an Option:");
			str = usrTxt.nextLine();
			str = str.trim();
			str = str.toLowerCase();
			if (str.equals("q")){
				out.println("We only part to meet again.");
				System.out.println("<Control> - " + user + " has left the game.");
				logging("<Control> - " + user + " has left the game.");
				try {
					socket.close();
				} catch(IOException e) {
					System.out.println("<ERROR> - Could not close connection with user");
					logging("<ERROR> - Could not close connection with user");
				}
			} else if (str.equals("r")){
				Account Account = new Account(socket, in, out, database);
				Account.create();

			} else if (str.equals("p")){
				show = true;
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
					FileInputStream fstream = new FileInputStream(database + "/login/"+user);
					DataInputStream in = new DataInputStream(fstream);
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					strLine = br.readLine();
					in.close();
				}catch (Exception e){
					out.println("<Control> I'm afraid I can't find that user. Have you created an account yet?");
					out.println("<Control> If you need assistance you can speak to an admin @ nicholas.ingalls@gmail.com");
					failLogin = true;
					show = false;
					login();
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
						characterLogin();
					} else {
						out.println((char)27 + "[0mIncorrect!");
						System.out.println("<Control> - " + user + " has FAILED login.");
						logging("<Control> - " + user + " has FAILED login.");
						failLogin = true;
						show = false;
						login();
					}
				}
			}
		}

	}
	public void characterLogin(){//Character Login Page
		String strLine;
		boolean loadChar = false;
		int charLen = 0;
		boolean error = true;
		String space = " ";
		setColor setColor = new setColor();
		out.println("''''''''''''''''''''''''''''''''''''''''''''''''");
		out.println("'              Character Selection             '");
		out.println("'                                              '");
		out.println("' Character:                                   '");

		try{
			FileInputStream fstream = new FileInputStream(database + "/characters/"+user);
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
				out.println("' You Haven't Created a Character Yet!        '");

			}
		}

		out.println("'                                              '");
		out.println(setColor.color("' ([blue]P[white])lay a current Character.                  '"));
		out.println(setColor.color("' ([blue]C[white])reate a new Character                     '"));
		out.println(setColor.color("' ([blue]R[white])eprint this dialogue                      '"));
		out.println(setColor.color("' ([blue]L[white])ogout                                     '"));
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
			out.println("NOT CURRENTLY OPERATIONAL");
			characterLogin();
		} else if (str.equals("p")){
			try{
				BufferedWriter bW = new BufferedWriter(new FileWriter(database + "/who", true));
				bW.write(user);
				bW.newLine();
				bW.close();
			}catch(IOException e){
				e.printStackTrace();
			}

			//---Starts Chat Server--//
			startChat SC = new startChat(socket, database, user);

			room();
			/**
			out.println("");
			out.println("Name of the Character that you would like to play:");
			str = usrTxt.nextLine();
			str = str.trim();
			str = str.toLowerCase();
			try{
				FileInputStream fstream = new FileInputStream(database + "/characters/"+user);
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
			 **/
		} else if (str.equals("r")){
			characterLogin();
		} else if (str.equals("l")){
			show = true;
			login();
		} else {
			out.println("That is not an option\n");
			characterLogin();
		}
	}
	public void room(){//Prints Description and exits of a room - called by interpretUsr()
		UserValue getValue = new UserValue(database,user);
		location = getValue.getLoc();
		System.out.println("<Control> - " + user + " has entered " + location);
		logging("<Control> - " + user + " has entered " + location);

		RoomValue RV = new RoomValue(database, location);
		String Title = RV.getTitle();
		String desc = RV.getDesc();
		northRoom = RV.getNorth();
		southRoom = RV.getSouth();
		eastRoom = RV.getEast();
		westRoom = RV.getWest();
		upRoom = RV.getUp();
		downRoom = RV.getDown();

		out.println((char)27 + "[1m" + "---" + Title + "---" + (char)27 + "[39m"); //Prints the title of the room
		out.println("");

		int len = 60;
		if (desc.length()<len){
			out.println(desc);
		} else {
			char [] chars = desc.toCharArray();
			Vector lines = new Vector();
			StringBuffer line = new StringBuffer();
			StringBuffer word = new StringBuffer();

			for (int i = 0; i < chars.length; i++) {
				word.append(chars[i]);

				if (chars[i] == ' ') {
					if ((line.length() + word.length()) > len) {
						lines.add(line.toString());
						line.delete(0, line.length());
					}

					line.append(word);
					word.delete(0, word.length());
				}
			}

			// handle any extra chars in current word
			if (word.length() > 0) {
				if ((line.length() + word.length()) > len) {
					lines.add(line.toString());
					line.delete(0, line.length());
				}
				line.append(word);
			}

			// handle extra line
			if (line.length() > 0) {
				lines.add(line.toString());
			}

			String [] ret = new String[lines.size()];
			int c = 0; // counter
			for (Enumeration e = lines.elements(); e.hasMoreElements(); c++) {
				ret[c] = (String) e.nextElement();
			}

			int length = ret.length;
			int current = 0;
			while (length>current+1){
				out.println(ret[current]);
				current++;
			}
		}
		String exits = listExit(location);
		out.println((char)27 + "[34m" + exits + (char)27 + "[0m");

		NPC();
		objects();
		interpretUsr();
	}
	public void NPC(){//Prints NPCs in a room - called by room();
		RoomValue Room = new RoomValue(database, location);
		String[] NPClist = Room.getNPC();
		setColor color = new setColor();

		int npcGet = 0;
		while (npcGet < NPClist.length){
			InstanceNPCValue iNPC = new InstanceNPCValue(database, NPClist[npcGet]);
			String npcName = iNPC.getReference();

			NPCValue NPC = new NPCValue(database, npcName);
			String npcDesc = NPC.getDesc();

			String textOut = color.color("[cyan]["+npcName+"][white] "+ npcDesc);
			out.println(textOut);

			npcGet++;
		}
	}
	public void objects(){//Prints objects in a room - called by room();
		RoomValue Room = new RoomValue(database, location);
		String[] OBJlist = Room.getObjects();
		setColor color = new setColor();

		int objGet = 0;

		while (objGet < OBJlist.length){
			int number = Integer.parseInt(Room.getObjectNumber(OBJlist[objGet]));
			ObjectValue OV = new ObjectValue(database, OBJlist[objGet]);
			String objDesc = OV.getDesc();

			String textOut = color.color("[blue]["+OBJlist[objGet]+"][white]*"+number+" - "+ objDesc);
			out.println(textOut);

			objGet++;
		}
	}
	public void interpretUsr(){//User Input
		UserInterface UI = new UserInterface(database, user);
		out.println(UI.showHealthbar());
		String str = UI.getInput(in);
		String orig = str;
		str = str.toLowerCase();
		String token = null;
		try {
			StringTokenizer st = new StringTokenizer(str);
			token = st.nextToken();
		} catch (Exception e1) {
			//Usually means the user just hit enter if there is an error here.
		}

		if (sleep==true) {
			if (str.equals("wake")){
				out.println("You wake up");
				sleep = false;
				interpretUsr();
			} else {
				out.println("You can't do that while you are sleeping!");
				interpretUsr();
			}
		} else {
			if (str.equals("n") | str.equals("north")) {
				if (northRoom.equals("none")){
					out.println("You can't go that way!");
					interpretUsr();
				} else {
					File bkup = new File(database + "/charProfile/" + user + "/location");
					bkup.delete();
					try {
						FileWriter fstream = new FileWriter(database
								+ "/charProfile/" + user + "/location");
						BufferedWriter writeout = new BufferedWriter(fstream);
						writeout.write(northRoom);

						try {
							FileInputStream fstream2 = new FileInputStream(
									database + "/rooms/" + location + "/"
											+ location + ".n");
							DataInputStream in = new DataInputStream(fstream2);
							BufferedReader br = new BufferedReader(
									new InputStreamReader(in));
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
					} catch (Exception e) {

					}
					room();
				}
			} else if (str.equals("e") | str.equals("e")) {
				if (eastRoom.equals("none")){
					out.println("You can't go that way!");
					interpretUsr();
				} else {


					File bkup = new File(database + "/charProfile/" + user + "/location");
					bkup.delete();
					try {
						FileWriter fstream = new FileWriter(database + "/charProfile/" + user + "/location");
						BufferedWriter writeout = new BufferedWriter(fstream);
						writeout.write(eastRoom);
						try {
							FileInputStream fstream2 = new FileInputStream(database + "/rooms/" + location + "/" + location + ".e");
							DataInputStream in = new DataInputStream(fstream2);
							BufferedReader br = new BufferedReader(
									new InputStreamReader(in));
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
					} catch (Exception e) {

					}
					room();
				}
			} else if (str.equals("s") | str.equals("south")) {
				if (southRoom.equals("none")){
					out.println("You can't go that way!");
					interpretUsr();
				} else {
					File bkup = new File(database + "/charProfile/" + user
							+ "/location");
					bkup.delete();
					try {
						FileWriter fstream = new FileWriter(database
								+ "/charProfile/" + user + "/location");
						BufferedWriter writeout = new BufferedWriter(fstream);
						writeout.write(southRoom);
						try {
							FileInputStream fstream2 = new FileInputStream(database
									+ "/rooms/" + location + "/" + location
									+ ".s");
							DataInputStream in = new DataInputStream(fstream2);
							BufferedReader br = new BufferedReader(
									new InputStreamReader(in));
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
					} catch (Exception e) {

					}
					room();
				}
			} else if (str.equals("w") | str.equals("west")) {
				if (westRoom.equals("none")){
					out.println("You can't go that way!");
					interpretUsr();
				} else {
					File bkup = new File(database + "/charProfile/" + user
							+ "/location");
					bkup.delete();
					try {
						FileWriter fstream = new FileWriter(database
								+ "/charProfile/" + user + "/location");
						BufferedWriter writeout = new BufferedWriter(fstream);
						writeout.write(westRoom);
						try {
							FileInputStream fstream2 = new FileInputStream(database + "/rooms/" + location + "/" + location + ".w");
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
					} catch (Exception e) {

					}
					room();
				}
			} else if (str.equals("d") | str.equals("down")) {
				if (downRoom.equals("none")){
					out.println("You can't go that way!");
					interpretUsr();
				} else {
					File bkup = new File(database + "/charProfile/" + user
							+ "/location");
					bkup.delete();
					try {
						FileWriter fstream = new FileWriter(database
								+ "/charProfile/" + user + "/location");
						BufferedWriter writeout = new BufferedWriter(fstream);
						writeout.write(downRoom);

						try {
							FileInputStream fstream2 = new FileInputStream(database
									+ "/rooms/" + location + "/" + location
									+ ".d");
							DataInputStream in = new DataInputStream(fstream2);
							BufferedReader br = new BufferedReader(
									new InputStreamReader(in));
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
					} catch (Exception e) {

					}
					room();
				}
			} else if (str.equals("u") | str.equals("up")) {
				if (upRoom.equals("none")){
					out.println("You can't go that way!");
					interpretUsr();
				} else {
					File bkup = new File(database + "/charProfile/" + user
							+ "/location");
					bkup.delete();
					try {
						FileWriter fstream = new FileWriter(database
								+ "/charProfile/" + user + "/location");
						BufferedWriter writeout = new BufferedWriter(fstream);
						writeout.write(upRoom);

						try {
							FileInputStream fstream2 = new FileInputStream(database
									+ "/rooms/" + location + "/" + location
									+ ".u");
							DataInputStream in = new DataInputStream(fstream2);
							BufferedReader br = new BufferedReader(
									new InputStreamReader(in));
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
					} catch (Exception e) {

					}
					room();
				}
			} else if (str.contains("help")) {
				str.replace("help ", "");
				interpretUsr();
			} else if (str.contains("jump")) {
				out.println("You jump up and down on the spot.");
				interpretUsr();
			} else if (str.contains("kiss")) {
				out.println("Your advances would not be appreciated!");
				interpretUsr();
			} else if (str.equals("l") | str.contains("look") | str.equals("")) {
				room();
			} else if (str.contains("fight ")) {
				String character = str;
				character = character.replace("fight ", "");
			} else if (str.contains("quit")) {
				quit();
			} else if (str.equals("inventory") | str.equals("i") | str.equals("inv")) {
				UserValue UV = new UserValue(database, user);
				String[] OBJlist = UV.getInventory();
				setColor color = new setColor();

				int objGet = 0;

				if(OBJlist.length == 0){
					out.println("You are not carrying anything!");
				} else {
					out.println("\n # | Description");
					while (objGet < OBJlist.length){
						int number = Integer.parseInt(UV.getInventoryItem((OBJlist[objGet])));
						ObjectValue OV = new ObjectValue(database, OBJlist[objGet]);
						String title = OV.getTitle();
						String objDesc = OV.getDesc();

						String textOut = color.color(" " + number + "  "+title+" - "+ objDesc);
						out.println(textOut);

						objGet++;
					}
				}

				interpretUsr();
			} else if (str.contains("take ")) {
				interpretUsr();
			} else if (str.contains("drop ")) {
				//Commands should be formatted as follows
				//drop all <item>
				//drop <item>
				//drop ## <item>

				int drop = 0; //Number to drop. If the user doesn't specify this should be 1. -1 means drop all of specified type.
				int testDrop = 0;
				String command = "", second = "", third = "";
				boolean inValue = false; //Tells whether the user entered an amount

				StringTokenizer st = new StringTokenizer(orig); //Breaks input into tokens
				command = st.nextToken();
				second = st.nextToken();
				third = st.nextToken();
				try {
					if (second.equals("all")){
						drop = -1;
						inValue = true;
					} else {
						try {
							drop = Integer.parseInt(second);
						} catch (Exception e) {
							out.println("Invalid number to drop!");
							interpretUsr();
						}
						inValue = true;
					}
				} catch (Exception e1) { //Means the user didn't enter a value to drop (Program will assume 1)
					drop = 1;
				}

				String finalItem;

				if (st.hasMoreTokens()){
					if (inValue == false){
						third = second+"-"+third;
					}
					finalItem = third;
				} else {
					if(inValue == false){
						finalItem = second;
					} else {
						finalItem = third;
					}
				}

				while (st.hasMoreTokens()){
					finalItem = finalItem + "-" + st.nextToken();
				}

				UserValue UV = new UserValue(database, user);
				String inv[] = UV.getInventory();
				int invLen = inv.length;
				int test = 0;
				String item = "";
				while (invLen > test){
					String invContainer;
					String userContainer;
					invContainer = inv[test];
					userContainer = finalItem;

					invContainer = invContainer.toLowerCase();
					userContainer = userContainer.toLowerCase();
					invContainer = invContainer.replace(" ", "");
					userContainer = userContainer.replace(" ", "");

					if (userContainer.equals(invContainer)){
						item = inv[test];
					}
					test++;

					//TODO
					System.out.println("Match:"+invContainer + "|User:" + userContainer);

					//TODO get multiple lines working
				}

				if (item.equals("")){
					//TODO
					System.out.println("Items do not match");
					out.println("You can't drop an item you don't have!");
					interpretUsr();
				}


				//TODO
				System.out.println("Attempting to drop");
				Inventory Inv = new Inventory(database, user);
				Inv.drop(item, drop, location);

				if (drop != -1 && drop != 1){
					out.println("You drop " + drop + "x" + item + " from your inventory");
				} else if (drop == -1) {
					out.println("You drop all the " + item + " from your inventory");
				} else {
					if (item.startsWith("a")|item.startsWith("e")|item.startsWith("i")|item.startsWith("o")|item.startsWith("u")){
						out.println("You drop an " + item + " from your inventory");
					} else {
						out.println("You drop a " + item + " from your inventory");
					}
				}

				interpretUsr();
			} else if (token.equals("ooc")){
				sendChat SC = new sendChat(database, user);
				SC.ooc(str);
				interpretUsr();
			} else if (token.equals("ic")){
				sendChat SC = new sendChat(database, user);
				SC.ic(str);
				interpretUsr();
			} else if (str.equals("gold")) {
				gold();
				interpretUsr();
			} else if (str.equals("exit")){
				exit();
				interpretUsr();
			} else if (str.equals("clear")){
				out.println ((char)27 + "[2J");
				out.println ((char)27 + "[0m");
				interpretUsr();
			} else if (str.equals("wizard")|str.equals("wiz")) {
			} else if (str.equals("sleep")){
				sleep();
			} else if (str.equals("database")) {
				//databaseManager DM = new databaseManager();
				//DM.start();
			} else {
				out.println("Sorry, I can't do that!");
				interpretUsr();
			}
		}

	}
	public void exit(){ //Prints a list of exits for the specific room
		UserValue getValue = new UserValue(database, user);
		location = getValue.getLoc();
		String direction = listExit(location);
		if (direction.equals("")){
			out.println("There are no exits to this room.");
		} else {
			out.println("There are exits to the:");
			out.println((char)27 + "[34m" + direction + (char)27 + "[0m");
		}
	}
	public String listExit(String location){
		String direction = "";
		if (northRoom.equals("none")){
		} else {
			north = true;
			direction = direction + "[North] ";
		}
		if (southRoom.equals("none")){
		} else {
			south = true;
			direction = direction + "[South] ";
		}
		if (eastRoom.equals("none")){
		} else {
			east = true;
			direction = direction + "[East] ";
		}
		if (westRoom.equals("none")){
		} else {
			west = true;
			direction = direction + "[West] ";
		}
		if (upRoom.equals("none")){
		} else {
			up = true;
			direction = direction + "[Up] ";
		}
		if (downRoom.equals("none")){
		} else {
			down = true;
			direction = direction + "[Down] ";
		}

		return direction;
	}
	public void gold(){//Prints the amount of gold that a user has in their possession
		UserValue getValue = new UserValue(database, user);
		String gold = getValue.getGold();
		out.println("You currently have: " + gold);
		interpretUsr();
	}
	public void sleep(){ //TODO increases the rate at which health is regenerated by *3
		//TODO Sleep increases the rate at which health is regenerated.
		sleep = true;
		out.println("You lay down and fall into a deep sleep.");
		interpretUsr();
	}
	public void rest(){ //TODO increases the rate at which health is regenerated by *1.5

	}
	public void score(){ //prints out a formatted table of stats
		//TODO Have a nicely formated table that prints out lvl, hp, etc.
		UserValue getValue = new UserValue(database, user);
		String level = getValue.getLvl();

		System.out.println("|-----------------------User-----------------------|");
		System.out.println("| Name: " + user);
		System.out.println("| Level: " + level);
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|");

		interpretUsr();
	}
	public void quit(){ //Exits the game and closes the thread
		out.println("We only part to meet again.");
		System.out.println("<Control> - " + user + " has left the game.");
		logging("<Control> - " + user + " has left the game.");
		//TODO send close to chatServer thread

		//Removes entry from the who file
		ArrayList<String> whoList = new ArrayList<String>();
		try{
			FileInputStream fstream = new FileInputStream(database + "/whp");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			while ((strLine = br.readLine()) != null){
				whoList.add(strLine);
			}
			br.close();
		} catch (Exception e){
			System.out.println("<ERROR> " + user + " cannot access who file");
			logging("<ERROR> " + user + " cannot access access who file");
		}



		File file = new File(database + "/who");
		file.delete();
		try{
			FileWriter fstream = new FileWriter(database + "/who",true);
			BufferedWriter fileOut = new BufferedWriter(fstream);
			int i = whoList.size();

			while(i>-1){
				if (whoList.get(i)!=user){
					fileOut.write(whoList.get(i));
				}
				i--;
				break;
			}

			//Close the output stream
			fileOut.close();
		} catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
			logging("Error: " + e.getMessage());
		}

		try {
			socket.close();
		} catch(IOException e) {
			System.out.println("<ERROR> - Could not close connection with user");
			logging("<ERROR> - Could not close connection with user");
		}
	}
	public void logging(String logPhrase){//Logs errors to the users log file
		try{
			String fileloc = database + "/logs/"+user+".log";
			File file = new File(fileloc);
			//if file doesn't exists, then create it
			if(!file.exists()){
				file.createNewFile();
			}
			//true = append file
			BufferedWriter bW = new BufferedWriter(new FileWriter(database + "/logs/"+user+".log", true));
			bW.write(logPhrase);
			bW.newLine();
			bW.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
