package userOperations;


public class Inventory {

	String loc;
	String userName;

	public Inventory (String database, String user){
		loc = database;
		userName = user;
	}

	/**
	 * Drops items from the user's inventory
	 * @param item A string containing a part or the entire name of the item to drop
	 * @param dropNum Number of the specified item to drop
	 * @param room Name of the room to drop the items into
	 */
	public void drop (String item, int dropNum, String room){

	}

	public void take (String item, int num, String room){

	}

	public void give (String item, int num, String user){

	}
}
