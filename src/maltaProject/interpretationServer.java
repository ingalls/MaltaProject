package maltaProject;

import getValue.InstanceNPCValue;
import getValue.NPCValue;
import getValue.ObjectValue;
import getValue.RoomValue;
import getValue.StoreValue;
import getValue.UserValue;
import getValue.WhoValue;

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
import java.util.Enumeration;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

import userInterface.InputBar;
import userInterface.setColor;
import userOperations.CreateAccount;
import userOperations.CreateUser;
import userOperations.InventoryOperations;
import userTickService.StartUserTick;
import chatServices.sendChat;

import commands.BankCommands;
import commands.FightCommands;
import commands.MovementCommands;
import commands.RegenCommands;
import commands.StatCommands;
import commands.UserCommands;

/**
 * This class obtains user input. It then analyzes the input and chooses the appropriate action.
 *
 * @author  Nicholas Ingalls
 */

public class interpretationServer extends Thread {
	//---Database Location---//
	String database = null; //Database address is passed to interpretationServer() from TelnetServer(). To modify path edit TelnetServer()

	//---Called Classes---//
	setColor setColor = new setColor(); //Used to change color tags to ascii colors

	//---Telnet Socket---//
	Socket socket; //Stores socket
	BufferedReader in; //Input through socket from user
	PrintWriter out; //Output through socket to user

	//---Character Variables---//
	static String user = "";
	String location = "<none>";

	String strLine; //String from the scanner class - AKA user input
	boolean show = true; //decides whether to show the intro screen. For example if a password is incorrect, the intro screen will not be shown.
	boolean startup = true;

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
				CreateAccount Account = new CreateAccount(socket, in, out, database);
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
			CreateUser CreateUser = new CreateUser(socket,in, out, database, user);
			CreateUser.start();
		} else if (str.equals("p")){
			WhoValue WhoValue = new WhoValue(database);
			WhoValue.createWho(user);

			//---Starts Chat Server--//
			StartUserTick SC = new StartUserTick(socket, database, user);

			//Create user file in room
			UserValue UV = new UserValue(database, user);
			RoomValue RV = new RoomValue(database, UV.getLoc());
			RV.addUser(user);

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

		out.println((char)27 + "[1m" + "---" + RV.getTitle() + "---" + (char)27 + "[39m"); //Prints the title of the room
		out.println("");

		int len = 60;
		if (RV.getDesc().length()<len){
			out.println(RV.getDesc());
		} else {
			char [] chars = RV.getDesc().toCharArray();
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
			while (length>current){
				out.println(ret[current]);
				current++;
			}
		}
		String exits = listExit();

		String store = "";
		if (RV.getStore() != null){
			store = "[store]";
		}

		String bank = "";
		if (RV.getBank() != null){
			bank = "[bank]";
		}

		out.println(setColor.color("[blue]" + exits + "[cyan]" + store + bank + "[white]"));

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
	public void store(){
		RoomValue RV = new RoomValue(database, location);
		if (!RV.getStore().equals("none")){
			StoreValue SV = new StoreValue(database, RV.getStore());
			String[] storeList = SV.getStoreList();

			int storeLoc = 0;

			out.println("\n$$  Item");

			while (storeLoc <= storeList.length -1){
				ObjectValue OV = new ObjectValue(database, storeList[storeLoc]);

				out.println(OV.getWorth() + " " + OV.getTitle());
				storeLoc ++;
			}
			out.println("");
		} else {
			out.println("\nThere is no store here!\n");
		}
	}
	public void interpretUsr(){//User Input
		UserValue UV = new UserValue(database, user); //Calls attributes of user
		InputBar UI = new InputBar(database, user);
		out.println(UI.showHealthbar());
		String rawInput = UI.getInput(in);

		out.println("");

		if (rawInput.equals("") | rawInput == null){
			exit();
			NPC();
			objects();
			interpretUsr();
		}

		String formattedInput = rawInput;
		formattedInput = formattedInput.toLowerCase();
		String token = null;
		StringTokenizer st = new StringTokenizer(formattedInput);
		token = st.nextToken();

		if (UV.isSleeping()) {
			if (formattedInput.equals("wake")){
				out.println("You wake up");
				UV.setSleep(false);
				interpretUsr();
			} else {
				out.println("You can't do that while you are sleeping!");
				interpretUsr();
			}
		} else {
			if (token.equals("n") | token.equals("north")) {
				MovementCommands MC = new MovementCommands(socket, database, user);
				if (MC.moveNorth()) {
					room();
				} else {
					interpretUsr();
				}
			} else if (token.equals("e") | token.equals("east")) {
				MovementCommands MC = new MovementCommands(socket, database, user);
				if (MC.moveEast()) {
					room();
				} else {
					interpretUsr();
				}
			} else if (token.equals("s") | token.equals("south")) {
				MovementCommands MC = new MovementCommands(socket, database, user);
				if (MC.moveSouth()) {
					room();
				} else {
					interpretUsr();
				}
			} else if (token.equals("w") | token.equals("west")){
				MovementCommands MC = new MovementCommands(socket, database, user);
				if (MC.moveWest()) {
					room();
				} else {
					interpretUsr();
				}
			} else if (token.equals("u") | token.equals("up")){
				MovementCommands MC = new MovementCommands(socket, database, user);
				if (MC.moveUp()) {
					room();
				} else {
					interpretUsr();
				}
			} else if (token.equals("d") | token.equals("down")){
				MovementCommands MC = new MovementCommands(socket, database, user);
				if (MC.moveDown()) {
					room();
				} else {
					interpretUsr();
				}
			} else if (token.equals("help")) {
				interpretUsr();
			} else if (token.equals("store")){
				store();
				interpretUsr();
			} else if (token.equals("bank")){
				RoomValue RV = new RoomValue(database, location);
				BankCommands BC = new BankCommands(socket, database, user, RV.getBank());
				BC.bank();
				interpretUsr();
			} else if (token.equals("l") | token.contains("look")) {
				room();
			} else if (token.equals("sit")) {
				UserCommands UC = new UserCommands(socket, database, user);
				UC.sit(location);
				interpretUsr();
			} else if (token.equals("stand")){
				UserCommands UC = new UserCommands(socket, database, user);
				UC.stand();
				interpretUsr();
			} else if (token.equals("withdraw")){
				RoomValue RV = new RoomValue(database, location);
				BankCommands BC = new BankCommands(socket, database, user, RV.getBank());

				token = st.nextToken();

				if (token == null){
					out.print("You need to specify a value to withdraw!");
				} else if (token.equals("all")){
					BC.withdraw(-1);
				} else {
					BC.withdraw(Integer.parseInt(token));
				}

				interpretUsr();
			} else if (token.equals("deposit")){
				RoomValue RV = new RoomValue(database, location);
				BankCommands BC = new BankCommands(socket, database, user, RV.getBank());

				token = st.nextToken();
				if (token == null){
					out.print("You need to specify a value to deposit!");
				} else if (token.equals("all")){
					BC.deposit(-1);
				} else {
					BC.deposit(Integer.parseInt(token));
				}

				interpretUsr();
			} else if (formattedInput.contains("quit")) {
				quit();
			} else if (token.equals("fight")){
				FightCommands FC = new FightCommands(socket, database, user);
				FC.fightNPC(user, "GateKeeper-1");
				interpretUsr();
			} else if (formattedInput.equals("inventory") | formattedInput.equals("i") | formattedInput.equals("inv")) {
				UserCommands UC = new UserCommands(socket, database, user);
				UC.inventory();
				interpretUsr();
			} else if (formattedInput.contains("take ")) {
				//Commands must be formatted in one of the following:
				//take <item> (Format 1)
				//take all <item> (Format 2)
				//take ## <item> (Format 3)

				int takeNum; //-1 for all
				String itemName = "";
				String workingItem;
				int format;

				StringTokenizer takeToken = new StringTokenizer(formattedInput);
				takeToken.nextToken(); //Skips the drop token;

				workingItem = takeToken.nextToken();

				if (workingItem.equals("all")){
					takeNum = -1; //Handles format 1
					format = 2;
				} else {
					try{
						takeNum = Integer.parseInt(workingItem); //Handles format 3
						format = 3;
					} catch (NumberFormatException e) {
						takeNum = 1; //Handles format 2
						format = 1;
					}
				}

				if (takeNum == 0){ //Handles dropping 0
					out.println("Try taking more than 0 items!");
					interpretUsr();
				} else if (format == 1){
					itemName = workingItem;
					while (takeToken.hasMoreTokens()){
						itemName = itemName + " " + takeToken.nextToken();
					}
				} else if (format>1){
					if (takeToken.hasMoreTokens()){
						itemName = takeToken.nextToken();
					} else {
						out.println("You must specify an item to take!");
						interpretUsr();
					}
					while (takeToken.hasMoreTokens()){
						itemName = itemName + " " + takeToken.nextToken();
					}
				}


				InventoryOperations Inventory = new InventoryOperations(database, user);
				UserValue UserValue = new UserValue(database, user);

				if (Inventory.take(itemName, takeNum, UserValue.getLoc())==false){
					out.println("You add " + itemName + " to inventory.");
				} else {
					out.println("You can't take an item not in the room!");
				}

				interpretUsr();
			} else if (formattedInput.contains("drop ")) {
				//Commands must be formatted in one of the following:
				//drop <item> (Format 1)
				//drop all <item> (Format 2)
				//drop ## <item> (Format 3)

				int dropNum; //-1 for all
				String itemName = "";
				String workingItem;
				int format;

				StringTokenizer dropToken = new StringTokenizer(formattedInput);
				dropToken.nextToken(); //Skips the drop token;

				workingItem = dropToken.nextToken();

				if (workingItem.equals("all")){
					dropNum = -1; //Handles format 1
					format = 2;
				} else {
					try{
						dropNum = Integer.parseInt(workingItem); //Handles format 3
						format = 3;
					} catch (NumberFormatException e) {
						dropNum = 1; //Handles format 2
						format = 1;
					}
				}

				if (dropNum == 0){ //Handles dropping 0
					out.println("Try dropping more than 0 items!");
					interpretUsr();
				} else if (format == 1){
					itemName = workingItem;
					while (dropToken.hasMoreTokens()){
						itemName = itemName + " " + dropToken.nextToken();
					}
				} else if (format>1){
					if (dropToken.hasMoreTokens()){
						itemName = dropToken.nextToken();
					} else {
						out.println("You must specify an item to drop!");
						interpretUsr();
					}
					while (dropToken.hasMoreTokens()){
						itemName = itemName + " " + dropToken.nextToken();
					}
				}


				InventoryOperations Inventory = new InventoryOperations(database, user);
				UserValue UserValue = new UserValue(database, user);

				if (Inventory.drop(itemName, dropNum, UserValue.getLoc())==false){
					out.println("You drop the " + itemName + " to the ground");
				} else {
					out.println("You don't have that item to drop!");
				}

				interpretUsr();
			} else if (token.equals("buy")){
				//Commands must be formatted in one of the following:
				//buy <item> (Format 1)
				//buy ## <item> (Format 2)

				int buyNum;
				String itemName = "";
				String workingItem;
				int format;

				StringTokenizer dropToken = new StringTokenizer(formattedInput);
				dropToken.nextToken(); //Skips the buy token;

				workingItem = dropToken.nextToken();

				try{
					buyNum = Integer.parseInt(workingItem); //Handles format 2
					format = 3;
				} catch (NumberFormatException e) {
					buyNum = 1; //Handles format 1
					format = 1;
				}

				if (buyNum == 0){ //Handles dropping 0
					out.println("Try buying more than 0 items!");
					interpretUsr();
				} else if (format == 1){
					itemName = workingItem;
					while (dropToken.hasMoreTokens()){
						itemName = itemName + " " + dropToken.nextToken();
					}
				} else if (format>1){
					if (dropToken.hasMoreTokens()){
						itemName = dropToken.nextToken();
					} else {
						out.println("You must specify an item to buy!");
						interpretUsr();
					}
					while (dropToken.hasMoreTokens()){
						itemName = itemName + " " + dropToken.nextToken();
					}
				}

				InventoryOperations Inventory = new InventoryOperations(database, user);
				RoomValue RV = new RoomValue(database, location);
				String output = Inventory.buy(itemName, buyNum, user, RV.getStore());
				out.println("\n" + output + "\n");
				interpretUsr();
			} else if (token.equals("sell")){
				System.out.println("Selling item");
				//Commands must be formatted in one of the following:
				//sell <item> (Format 1)
				//sell all <item> (Format 2)
				//sell ## <item> (Format 3)

				int sellNum;
				String itemName = "";
				String workingItem;
				int format;

				StringTokenizer sellToken = new StringTokenizer(formattedInput);
				sellToken.nextToken(); //Skips the buy token;

				workingItem = sellToken.nextToken();

				if (workingItem.equals("all")){
					sellNum = -1; //Handles format 1
					format = 2;
				} else {
					try{
						sellNum = Integer.parseInt(workingItem); //Handles format 3
						format = 3;
					} catch (NumberFormatException e) {
						sellNum = 1; //Handles format 2
						format = 1;
					}
				}

				if (sellNum == 0){ //Handles dropping 0
					out.println("Try selling more than 0 items!");
					interpretUsr();
				} else if (format == 1){
					itemName = workingItem;
					while (sellToken.hasMoreTokens()){
						itemName = itemName + " " + sellToken.nextToken();
					}
				} else if (format>1){
					if (sellToken.hasMoreTokens()){
						itemName = sellToken.nextToken();
					} else {
						out.println("You must specify an item to buy!");
						interpretUsr();
					}
					while (sellToken.hasMoreTokens()){
						itemName = itemName + " " + sellToken.nextToken();
					}
				}

				InventoryOperations Inventory = new InventoryOperations(database, user);
				RoomValue RV = new RoomValue(database, location);
				String output = Inventory.sell(itemName, sellNum, user, RV.getStore());
				out.println("\n" + output + "\n");
				interpretUsr();
			} else if (token.equals("ooc")){
				sendChat SC = new sendChat(database, user);
				SC.ooc(formattedInput);
				interpretUsr();
			} else if (token.equals("ic")){
				sendChat SC = new sendChat(database, user);
				SC.ic(formattedInput);
				interpretUsr();
			} else if (formattedInput.equals("gold")) {
				StatCommands SC = new StatCommands(socket, database, user);
				SC.gold();
				interpretUsr();
			} else if (formattedInput.equals("exit")){
				exit();
				interpretUsr();
			} else if (formattedInput.equals("clear")){
				out.println ((char)27 + "[2J");
				out.println ((char)27 + "[0m");
				interpretUsr();
			} else if (formattedInput.equals("sleep")){
				RegenCommands RC = new RegenCommands(socket, database, user);
				RC.sleep();
				interpretUsr();
			} else {
				out.println("Sorry, I can't do that!");
				interpretUsr();
			}
		}

	}
	public void exit(){ //Prints a list of exits for the specific room
		UserValue getValue = new UserValue(database, user);
		location = getValue.getLoc();
		String exits = listExit();
		if (exits.equals("")){
			out.println("There are no exits to this room.");
		} else {
			out.println((char)27 + "[34m" + exits + (char)27 + "[0m");
		}
	}
	public String listExit(){
		String direction = "";

		RoomValue RV = new RoomValue(database, location);

		if (RV.getNorth() != null){
			direction = direction + "[North] ";
		}
		if (RV.getSouth() != null){
			direction = direction + "[South] ";
		}
		if (RV.getEast() != null){
			direction = direction + "[East] ";
		}
		if (RV.getWest() != null){
			direction = direction + "[West] ";
		}
		if (RV.getUp() != null){
			direction = direction + "[Up] ";
		}
		if (RV.getDown() != null){
			direction = direction + "[Down] ";
		}

		return direction;
	}
	public void quit(){ //Exits the game and closes the thread
		out.println("We only part to meet again.");
		System.out.println("<Control> - " + user + " has left the game.");
		logging("<Control> - " + user + " has left the game.");

		//TODO send close to chatServer thread

		//Removes entry from the server who file
		WhoValue WhoValue = new WhoValue(database);
		WhoValue.deleteWho(user);

		//Removes entry from the room's users
		RoomValue RV = new RoomValue(database, location);
		RV.removeUser(user);

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