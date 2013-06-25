package getValue;

import maltaProject.FileOperations;

//TODO
//If user is in a non-existent room, warn them
//Get rid of move:none. If there is not a room in that direction, do not require a file.
//Get rid of moveDesc:none. If there is no movement description, do not require a file.

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
		String fileLoc = database + "/rooms/"+roomName+"/title";
		FileOperations open = new FileOperations(fileLoc);
		String title = open.getLine();
		return title;
	}

	/**
	 * Sets a new title of a room
	 * 
	 * @param strLine A string that will overwrite room title
	 */
	public void setTitle(String strLine){
		String fileLoc = database + "/rooms/"+roomName+"/title";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strLine);
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
	 * @param strLine A string that will overwrite the room description.
	 */
	public void setDesc(String strLine){
		String fileLoc = database + "/rooms/"+roomName+"/desc";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strLine);
	}

	/**
	 * Returns the name of the room to the north
	 * 
	 * @return name of the room
	 */
	public String getNorth(){
		String fileLoc = database + "/rooms/"+roomName+"/move/north";
		FileOperations open = new FileOperations(fileLoc);
		String north = open.getLine();
		return north;
	}

	/**
	 * Sets a new room to the north
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setNorth(String strLine){
		String fileLoc = database + "/rooms/"+roomName+"/move/north";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strLine);
	}

	/**
	 * Returns the name of the room to the south
	 * 
	 * @return name of the room
	 */
	public String getSouth(){
		String fileLoc = database + "/rooms/"+roomName+"/move/south";
		FileOperations open = new FileOperations(fileLoc);
		String south = open.getLine();
		return south;
	}

	/**
	 * Sets a new room to the south
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setSouth(String strLine){
		String fileLoc = database + "/rooms/"+roomName+"/move/south";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strLine);
	}

	/**
	 * Returns the name of the room to the east
	 * 
	 * @return name of the room
	 */
	public String getEast(){
		String fileLoc = database + "/rooms/"+roomName+"/move/east";
		FileOperations open = new FileOperations(fileLoc);
		String east = open.getLine();
		return east;
	}

	/**
	 * Sets a new room to the east
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setEast(String strLine){
		String fileLoc = database + "/rooms/"+roomName+"/move/east";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strLine);
	}

	/**
	 * Returns the name of the room to the west
	 * 
	 * @return name of the room
	 */
	public String getWest(){
		String fileLoc = database + "/rooms/"+roomName+"/move/west";
		FileOperations open = new FileOperations(fileLoc);
		String west = open.getLine();
		return west;
	}

	/**
	 * Sets a new room to the west
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setWest(String strLine){
		String fileLoc = database + "/rooms/"+roomName+"/move/west";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strLine);
	}

	/**
	 * Returns the name of the room to the up
	 * 
	 * @return name of the room
	 */
	public String getUp(){
		String fileLoc = database + "/rooms/"+roomName+"/move/up";
		FileOperations open = new FileOperations(fileLoc);
		String up = open.getLine();
		return up;
	}

	/**
	 * Sets a new room to the up
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setUp(String strLine){
		String fileLoc = database + "/rooms/"+roomName+"/move/up";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strLine);
	}

	/**
	 * Returns the name of the room to the down
	 * 
	 * @return name of the room
	 */
	public String getDown(){
		String fileLoc = database + "/rooms/"+roomName+"/move/down";
		FileOperations open = new FileOperations(fileLoc);
		String down = open.getLine();
		return down;
	}

	/**
	 * Sets a new room to the down
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setDown(String strLine){
		String fileLoc = database + "/rooms/"+roomName+"/move/down";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strLine);
	}

	/**
	 * Returns a the string that is printed when a user walks in a certain direction.
	 * The default value is "none" which means the user simply changes rooms.
	 * 
	 * @return name of the room
	 */
	public String getMoveNorth(){
		String fileLoc = database + "/rooms/"+roomName+"/moveDesc/moveNorth";
		FileOperations open = new FileOperations(fileLoc);
		String moveDesc = open.getLine();
		return moveDesc;
	}

	/**
	 * Sets a new room to the down
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setMoveNorth(String moveDesc){
		String fileLoc = database + "/rooms/"+roomName+"/moveDesc/moveNorth";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(moveDesc);
	}

	/**
	 * Returns a the string that is printed when a user walks in a certain direction.
	 * The default value is "none" which means the user simply changes rooms.
	 * 
	 * @return name of the room
	 */
	public String getMoveEast(){
		String fileLoc = database + "/rooms/"+roomName+"/moveDesc/moveEast";
		FileOperations open = new FileOperations(fileLoc);
		String moveDesc = open.getLine();
		return moveDesc;
	}

	/**
	 * Sets a new room to the down
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setMoveEast(String moveDesc){
		String fileLoc = database + "/rooms/"+roomName+"/moveDesc/moveEast";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(moveDesc);
	}

	/**
	 * Returns a the string that is printed when a user walks in a certain direction.
	 * The default value is "none" which means the user simply changes rooms.
	 * 
	 * @return name of the room
	 */
	public String getMoveSouth(){
		String fileLoc = database + "/rooms/"+roomName+"/moveDesc/moveSouth";
		FileOperations open = new FileOperations(fileLoc);
		String moveDesc = open.getLine();
		return moveDesc;
	}

	/**
	 * Sets a new room to the down
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setMoveSouth(String moveDesc){
		String fileLoc = database + "/rooms/"+roomName+"/moveDesc/moveSouth";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(moveDesc);
	}

	/**
	 * Returns a the string that is printed when a user walks in a certain direction.
	 * The default value is "none" which means the user simply changes rooms.
	 * 
	 * @return name of the room
	 */
	public String getMoveWest(){
		String fileLoc = database + "/rooms/"+roomName+"/moveDesc/moveWest";
		FileOperations open = new FileOperations(fileLoc);
		String moveDesc = open.getLine();
		return moveDesc;
	}

	/**
	 * Sets a new room to the down
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setMoveWest(String moveDesc){
		String fileLoc = database + "/rooms/"+roomName+"/moveDesc/moveWest";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(moveDesc);
	}

	/**
	 * Returns a the string that is printed when a user walks in a certain direction.
	 * The default value is "none" which means the user simply changes rooms.
	 * 
	 * @return name of the room
	 */
	public String getMoveUp(){
		String fileLoc = database + "/rooms/"+roomName+"/moveDesc/moveUp";
		FileOperations open = new FileOperations(fileLoc);
		String moveDesc = open.getLine();
		return moveDesc;
	}

	/**
	 * Sets a new room to the down
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setMoveUp(String moveDesc){
		String fileLoc = database + "/rooms/"+roomName+"/moveDesc/moveUp";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(moveDesc);
	}

	/**
	 * Returns a the string that is printed when a user walks in a certain direction.
	 * The default value is "none" which means the user simply changes rooms.
	 * 
	 * @return name of the room
	 */
	public String getMoveDown(){
		String fileLoc = database + "/rooms/"+roomName+"/moveDesc/moveDown";
		FileOperations open = new FileOperations(fileLoc);
		String moveDesc = open.getLine();
		return moveDesc;
	}

	/**
	 * Sets a new room to the down
	 * 
	 * @param strLine A string that will overwrite the current room
	 */
	public void setMoveDown(String moveDesc){
		String fileLoc = database + "/rooms/"+roomName+"/moveDesc/moveDown";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(moveDesc);
	}

	/**
	 * Returns a String array containing the objects in a room
	 * 
	 * @return A String array containing the objects
	 */
	public String[] getObjects(){
		FileOperations FO = new FileOperations(database);
		String[] files = FO.getDirectory("/rooms/"+roomName+"/object");
		return files;
	}

	/**
	 * Creates A new object in a room
	 * 
	 * @param instanceNum A String containing the instance number of the object
	 */
	public void setNewObject(String name, String number){
		String fileLoc = database + "/rooms/"+roomName+"/object/"+name;
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(number);
	}

	/**
	 * Returns the number of objects of a specified type
	 * 
	 * @param name Type of object to look up
	 * @return number of objects of that type
	 */
	public String getObjectNumber(String name){
		String fileLoc = database + "/rooms/"+roomName+"/object/"+name;
		FileOperations open = new FileOperations(fileLoc);
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
	 * @param inv A String containing instance number of the object to delete
	 */
	public void deleteObject(String name){
		FileOperations OP = new FileOperations(database);
		OP.deleteFile("/rooms/"+roomName+"/object/"+name);
	}

	/**
	 * Returns a String array containing the npcs in a room
	 * 
	 * @return A String array containing the npcs
	 */
	public String[] getNPC(){
		FileOperations FO = new FileOperations(database);
		String[] files = FO.getDirectory("/rooms/"+roomName+"/npc");
		return files;
	}

	/**
	 * Creates A new npc in a room
	 * 
	 * @param instanceNum A String containing the instance number of the npc
	 */
	public void setNewNPC(String instanceNum){
		String fileLoc = database + "/rooms/"+roomName+"/npc/"+instanceNum;
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(" ");
	}

	/**
	 * Used to delete an npc in a room
	 * 
	 * @param inv A String containing instance number of the npc to delete
	 */
	public void deleteNPC(String instanceNum){
		FileOperations OP = new FileOperations(database);
		OP.deleteFile("/rooms/"+roomName+"/npc/"+instanceNum);
	}

	/**
	 * Returns a list of visible user's in a room
	 * @return A String[] containing a list of visible user's in a room
	 */
	public String[] getUsers(){
		FileOperations FO = new FileOperations(database);
		String[] users = FO.getDirectory("/rooms/" + roomName + "/users/");

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
		FO.deleteFile("");
	}
}