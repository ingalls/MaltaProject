package getValue;

import maltaProject.FileOperations;

public class WhoValue {
	/**Stores database location - initialized by constructor*/
	String database;

	/**
	 * Constructs a new object with a string containing the database location.
	 * */
	public WhoValue(String data){
		database = data;
	}

	public String[] listWho(){
		FileOperations FO = new FileOperations(database);
		String[] users = FO.getDirectory("/who/");

		return users;
	}

	/**
	 * Creates a new online user
	 * 
	 * @param user String containing the user's name
	 */
	public void createWho(String user){
		FileOperations FO = new FileOperations(database + "/who/" + user);
		FO.setLine("");
	}

	/**
	 * Removes an online user
	 * 
	 * @param user String containing the user's name
	 */
	public void deleteWho(String user){
		FileOperations FO = new FileOperations(database + "/who/" + user);
		FO.deleteFile("");
	}

	/**
	 * Checks to see if a specific user is online
	 * 
	 * @param user String containing the user's name
	 * @return Returns a boolean value for whether the user exists.
	 */
	public boolean checkWho(String user){
		boolean userExists = true;
		FileOperations FO = new FileOperations(database + "/who/" + user);
		userExists = FO.checkFile();

		return userExists;
	}
}
