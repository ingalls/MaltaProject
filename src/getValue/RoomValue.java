package getValue;

import maltaProject.FileOperations;

/**
 * This class is used to return information on a given room. Given the room
 * name and the location of the database, a string with the requested stat
 * will be returned.
 *
 * @author  Nicholas Ingalls
 */
public class RoomValue {
	/**Stores database location - initialized by constructor*/
	String database;
	/**Stores room name - initialized by constructor*/
	String roomName;


	/**
	 * Constructs a new object with a string containing the database location and a string containing the room name.
	 * */
	public RoomValue(String data, String room){
		roomName = room;
		database = data;
	}

	/**
	 * Returns the title of the room. Each room has a distinct room name.
	 * The room name is the name of the folder that the room is in.
	 * Each room also has a Title. The room name is used by the server to distinguish between different
	 * rooms while the Title is shown to the user. Multiple rooms can have the same title but not the same
	 * Room name.
	 * 
	 * @return A String containing the title of the room
	 */
	public String getTitle(){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/title");
		return FO.getLine();
	}

	/**
	 * Sets a new title of a room
	 * 
	 * @param strLine A string that will overwrite room title
	 */
	public void setTitle(String strLine){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/title");
		FO.setLine(strLine);
	}

	public String[] getDefaultNPCs(){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/defaultNPC");
		return FO.getDirectory();
	}

	public int getDefaultNPC(String NPC){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/defaultNPC/" + NPC);
		return Integer.parseInt(FO.getLine());
	}

	public void addDefaultNPC(String NPC, int num){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/defaultNPC/" + NPC);
		FO.setLine(num + "");
	}
	public void removeDefaultNPC(String NPC){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/defaultNPC/" + NPC);
		FO.deleteFile();
	}

	/**
	 * Sets whether the user can sit in the room
	 * @param neutral A boolean of whether the user can sit in the room
	 */
	public void setSit(boolean neutral){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/canSit");
		if (neutral == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	/**
	 *  Rooms with seats of some kind allow a user to sit.
	 * 
	 * @param strSit A String containing the description when the user sits.
	 */
	public void setSitDesc(String strSit){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/canSit");
		FO.setLine(strSit);
	}

	/**
	 * Returns a String containing the description that is output when a user sits.
	 * @return A String containing the sit description
	 */
	public String getSitDesc(){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/canSit");
		return FO.getLine();
	}

	/**
	 * Rooms with seats of some kind allow a user to sit.
	 * 
	 * @return A String containing the description when the user sits.
	 */
	public boolean canSit(){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/canSit");
		return FO.checkFile();
	}

	/**
	 * Returns a String containing the name of the bank. Returns null if none.
	 * 
	 * @return A String containing the name of the bank.
	 */
	public String getBank(){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/bank");
		return FO.getLine();
	}

	/**
	 * Sets the name of the bank. Should be "none" for none.
	 * @param store A String containing the name of the bank.
	 */
	public void setBank(String store){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/bank");
		FO.setLine(store);
	}

	public void removeBank(){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/bank");
		FO.deleteFile();
	}

	public void removeStore(){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/store");
		FO.deleteFile();
	}

	/**
	 * Returns a String containing the name of the store. Returns null if none.
	 * 
	 * @return A String containing the name of the store.
	 */
	public String getStore(){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/store");
		return FO.getLine();
	}

	/**
	 * Sets the name of the store. Should be "none" for none.
	 * @param store A String containing the name of the store.
	 */
	public void setStore(String store){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/store");
		FO.setLine(store);
	}

	/**
	 * Returns the description of a room. The description is not wrapped and the calling class
	 * must wrap it to fit in the terminal window.
	 * 
	 * @return A String containing the description
	 */
	public String getDesc(){
		String fileLoc = database + "/rooms/"+roomName+"/desc";
		FileOperations open = new FileOperations(fileLoc);
		String desc = open.getLine();
		if (desc.contains("<dynamic:")){
			desc.replace("<dynamic:>", "");
			desc.replace(">", "");
			FileOperations openDynamic = new FileOperations(database + "/DynamicRooms/"+desc+"/desc");
			desc = openDynamic.getLine();
		}
		return desc;
	}

	/**
	 * Sets a new description
	 * 
	 * @param desc A string that will overwrite the room description.
	 */
	public void setDesc(String desc){
		FileOperations FO = new FileOperations(database + "/rooms/"+roomName+"/desc");
		FO.setLine(desc);
	}

	/**
	 * Returns the name of the room to the north
	 * 
	 * @return name of the room
	 */
	public String getNorth(){
		FileOperations FO = new FileOperations(database + "/rooms/"+roomName+"/move/north");
		return FO.getLine();
	}

	/**
	 * Sets a new room to the north
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setNorth(String strLine){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/move/north");
		open.setLine(strLine);
	}

	/**
	 * Returns the name of the room to the south
	 * 
	 * @return name of the room
	 */
	public String getSouth(){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/move/south");
		String south = open.getLine();
		return south;
	}

	/**
	 * Sets a new room to the south
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setSouth(String strLine){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/move/south");
		open.setLine(strLine);
	}

	/**
	 * Returns the name of the room to the east
	 * 
	 * @return name of the room
	 */
	public String getEast(){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/move/east");
		String east = open.getLine();
		return east;
	}

	/**
	 * Sets a new room to the east
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setEast(String strLine){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/move/east");
		open.setLine(strLine);
	}

	/**
	 * Returns the name of the room to the west
	 * 
	 * @return name of the room
	 */
	public String getWest(){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/move/west");
		String west = open.getLine();
		return west;
	}

	/**
	 * Sets a new room to the west
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setWest(String strLine){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/move/west");
		open.setLine(strLine);
	}

	/**
	 * Returns the name of the room to the up
	 * 
	 * @return name of the room
	 */
	public String getUp(){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/move/up");
		String up = open.getLine();
		return up;
	}

	/**
	 * Sets a new room to the up
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setUp(String strLine){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/move/up");
		open.setLine(strLine);
	}

	/**
	 * Returns the name of the room to the down
	 * 
	 * @return name of the room
	 */
	public String getDown(){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/move/down");
		String down = open.getLine();
		return down;
	}

	/**
	 * Sets a new room to the down
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setDown(String strLine){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/move/down");
		open.setLine(strLine);
	}

	/**
	 * Returns a the string that is printed when a user walks in a certain direction.
	 * The default value is "none" which means the user simply changes rooms.
	 * 
	 * @return name of the room
	 */
	public String getMoveNorth(){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/moveDesc/moveNorth");
		String moveDesc = open.getLine();
		return moveDesc;
	}

	/**
	 * Sets a new room to the down
	 * 
	 * @param moveDesc A string that will overwrite the current room
	 */
	public void setMoveNorth(String moveDesc){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/moveDesc/moveNorth");
		open.setLine(moveDesc);
	}

	/**
	 * Returns a the string that is printed when a user walks in a certain direction.
	 * The default value is "none" which means the user simply changes rooms.
	 * 
	 * @return name of the room
	 */
	public String getMoveEast(){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/moveDesc/moveEast");
		String moveDesc = open.getLine();
		return moveDesc;
	}

	/**
	 * Sets a new room to the down
	 * 
	 * @param moveDesc A string that will overwrite the current room
	 */
	public void setMoveEast(String moveDesc){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/moveDesc/moveEast");
		open.setLine(moveDesc);
	}

	/**
	 * Returns a the string that is printed when a user walks in a certain direction.
	 * The default value is "none" which means the user simply changes rooms.
	 * 
	 * @return name of the room
	 */
	public String getMoveSouth(){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/moveDesc/moveSouth");
		String moveDesc = open.getLine();
		return moveDesc;
	}

	/**
	 * Sets a new room to the down
	 * 
	 * @param moveDesc A string that will overwrite the current room
	 */
	public void setMoveSouth(String moveDesc){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/moveDesc/moveSouth");
		open.setLine(moveDesc);
	}

	/**
	 * Returns a the string that is printed when a user walks in a certain direction.
	 * The default value is "none" which means the user simply changes rooms.
	 * 
	 * @return name of the room
	 */
	public String getMoveWest(){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/moveDesc/moveWest");
		String moveDesc = open.getLine();
		return moveDesc;
	}

	/**
	 * Sets a new room to the down
	 * 
	 * @param moveDesc A string that will overwrite the current room
	 */
	public void setMoveWest(String moveDesc){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/moveDesc/moveWest");
		open.setLine(moveDesc);
	}

	/**
	 * Returns a the string that is printed when a user walks in a certain direction.
	 * The default value is "none" which means the user simply changes rooms.
	 * 
	 * @return name of the room
	 */
	public String getMoveUp(){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/moveDesc/moveUp");
		String moveDesc = open.getLine();
		return moveDesc;
	}

	/**
	 * Sets a new room to the down
	 * 
	 * @param moveDesc A string that will overwrite the current room
	 */
	public void setMoveUp(String moveDesc){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/moveDesc/moveUp");
		open.setLine(moveDesc);
	}

	/**
	 * Returns a the string that is printed when a user walks in a certain direction.
	 * The default value is "none" which means the user simply changes rooms.
	 * 
	 * @return name of the room
	 */
	public String getMoveDown(){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/moveDesc/moveDown");
		String moveDesc = open.getLine();
		return moveDesc;
	}

	/**
	 * Sets a new room to the down
	 * 
	 * @param moveDesc A string that will overwrite the current room
	 */
	public void setMoveDown(String moveDesc){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/moveDesc/moveDown");
		open.setLine(moveDesc);
	}

	/**
	 * Returns a String array containing the objects in a room
	 * 
	 * @return A String array containing the objects
	 */
	public String[] getObjects(){
		FileOperations FO = new FileOperations(database + "/rooms/"+roomName+"/object");
		String[] files = FO.getDirectory();
		return files;
	}

	/**
	 * Creates A new object in a room
	 * 
	 * @param instanceName A String containing the instance number of the object
	 * @param number An int containing the number of said object
	 */
	public void setNewObject(String instanceName, int number){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/object/"+instanceName);
		open.setLine(number + "");
	}

	/**
	 * Returns the number of objects of a specified type
	 * 
	 * @param name Type of object to look up
	 * @return number of objects of that type
	 */
	public String getObjectNumber(String name){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/object/"+name);
		String returnString = "";
		returnString = open.getLine();
		if (open.hasError()==true){
			returnString = "";
		}
		return returnString;
	}

	/**
	 * Used to delete an object in a room
	 * 
	 * @param name A String containing instance number of the object to delete
	 */
	public void deleteObject(String name){
		FileOperations OP = new FileOperations(database + "/rooms/" + roomName + "/object/"+name);
		OP.deleteFile();
	}

	/**
	 * Returns a String array containing the npcs in a room
	 * 
	 * @return A String array containing the npcs
	 */
	public String[] getNPC(){
		FileOperations FO = new FileOperations(database + "/rooms/"+roomName+"/npc/");
		return FO.getDirectory();
	}

	/**
	 * Creates A new npc in a room
	 * 
	 * @param instanceNum A String containing the instance number of the npc
	 */
	public void setNewNPC(String instanceNum){
		FileOperations open = new FileOperations(database + "/rooms/"+roomName+"/npc/"+instanceNum);
		open.setLine("");
	}

	/**
	 * Used to delete an npc in a room
	 * 
	 * @param instanceName A String containing instance name of the npc to delete
	 */
	public void deleteNPC(String instanceName){
		FileOperations OP = new FileOperations(database + "/rooms/"+roomName+"/npc/"+instanceName);
		OP.deleteFile();
	}

	/**
	 * Returns a list of visible user's in a room
	 * @return A String[] containing a list of visible user's in a room
	 */
	public String[] getUsers(){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/users/");
		String[] users = FO.getDirectory();

		return users;
	}

	/**
	 * Used to add a visible user to a room
	 * @param user A String containing the name of the user
	 */
	public void addUser(String user){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/users/" + user);
		FO.setLine("");
	}

	/**
	 * Used to remove a visible user to a room
	 * @param user A String containing the name of the user
	 */
	public void removeUser(String user){
		FileOperations FO = new FileOperations(database + "/rooms/" + roomName + "/users/" + user);
		FO.deleteFile();
	}
}