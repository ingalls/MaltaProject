package getValue;

import maltaProject.FileOperations;

public class LoginValue {
	/**Stores database location - initialized by constructor*/
	String database;
	/**Stores login name - initialized by constructor*/
	String userName;

	/**
	 * Constructs a new object with a string containing the database location and a string containing the race name.
	 * */
	public LoginValue(String data, String user){
		userName = user;
		database = data;
	}

	public boolean checkUser(){
		FileOperations FO = new FileOperations(database+"/login/" + userName);
		return FO.checkFile();
	}

	public boolean checkPassword(String password){
		FileOperations FO = new FileOperations(database+"/login/" + userName);
		if (FO.getLine().equals(password)){
			return true;
		} else {
			return false;
		}
	}
}
