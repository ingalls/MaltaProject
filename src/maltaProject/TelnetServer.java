package maltaProject;

import gameTickService.StartGameTick;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * This class accepts telnet connections as well as checking for the database.
 * 
 * @author  Nicholas Ingalls
 */
public class TelnetServer extends Thread{

	//-------------Change-With-Caution-----------------
	//This will change the location of the MUD Data-set
	static String database = "/home/aurora/Programming/MaltaProject/MurusServer";
	//This will change the port for the MUD
	static final int USER_PORT = 1337;
	//This will change the port for the MUD
	static final int WIZARD_PORT = 1338;
	//WARNING - Linux needs root privileges for ports below 1000.
	//-------------------------------------------------



	public static void main(String[] args) {

		Thread.currentThread().setName("Telnet-Server");

		System.out.println("Server Started");
		check();

		//Regenerate Instances
		Generator generator = new Generator(database);
		generator.generateAllNPC();

		//Start the Game Keeper
		StartGameTick GM = new StartGameTick(database);

		//Create Listener Threads
		new Thread(new UserSocketManager(database, USER_PORT)).start();
		new Thread(new WizardSocketManager(database, WIZARD_PORT)).start();
	}

	public static void check(){
		boolean error = false;
		System.out.println("[Control] Checking for Database");
		try{
			FileInputStream fstream = new FileInputStream(database + "/check");
			DataInputStream in = new DataInputStream(fstream);
			in.read();
			in.close();
		} catch (Exception e){
			System.out.println("<ERROR> The Server cannot connect to the database!");
			System.out.println("<ERROR> Make sure that the database address is correct");
			error = true;
		}
		if (error==false){
			System.out.println("[Control] Database OKAY");
		}
	}
}