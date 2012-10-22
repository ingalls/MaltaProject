package maltaProject;
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
	RoomValue(String data, String room){
		roomName = room;
		database = data;
	}
	
	/**
	 * Returns the title of the room. Each room has a distinct room name.
	 * The room name is the name of the folder that the room is in.
	 * Each room also has a Title. The room name is used by the server to distinguish between different
	 * rooms while the Title is shown to the user. Multiple rooms can have the same title but not the same
	 * Room name.
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
	 * @return A String containing the description
	 */
	public String getDesc(){
		String fileLoc = database + "/rooms/"+roomName+"/desc";
		FileOperations open = new FileOperations(fileLoc);
		String desc = open.getLine();
		desc = desc.toLowerCase();
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
	 * @param strLine A string that will overwrite the room description.
	 */
	public void setDesc(String strLine){
		String fileLoc = database + "/rooms/"+roomName+"/desc";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strLine);
	}
	
	/**
	 * Returns the name of the room to the north
	 * @return name of the room
	 */
	public String getNorth(){
		String fileLoc = database + "/rooms/"+roomName+"/north";
		FileOperations open = new FileOperations(fileLoc);
		String north = open.getLine();
		return north;
	}
	
	/**
	 * Sets a new room to the north
	 * @param strLine A string that will overwrite the current room
	 */
	public void setNorth(String strLine){
		String fileLoc = database + "/rooms/"+roomName+"/north";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strLine);
	}
	
	/**
	 * Returns the name of the room to the south
	 * @return name of the room
	 */
	public String getSouth(){
		String fileLoc = database + "/rooms/"+roomName+"/south";
		FileOperations open = new FileOperations(fileLoc);
		String south = open.getLine();
		return south;
	}
	
	/**
	 * Sets a new room to the south
	 * @param strLine A string that will overwrite the current room
	 */
	public void setSouth(String strLine){
		String fileLoc = database + "/rooms/"+roomName+"/south";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strLine);
	}
	
	/**
	 * Returns the name of the room to the east
	 * @return name of the room
	 */
	public String getEast(){
		String fileLoc = database + "/rooms/"+roomName+"/east";
		FileOperations open = new FileOperations(fileLoc);
		String east = open.getLine();
		return east;
	}
	
	/**
	 * Sets a new room to the east
	 * @param strLine A string that will overwrite the current room
	 */
	public void setEast(String strLine){
		String fileLoc = database + "/rooms/"+roomName+"/east";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strLine);
	}
	
	/**
	 * Returns the name of the room to the west
	 * @return name of the room
	 */
	public String getWest(){
		String fileLoc = database + "/rooms/"+roomName+"/west";
		FileOperations open = new FileOperations(fileLoc);
		String west = open.getLine();
		return west;
	}
	
	/**
	 * Sets a new room to the west
	 * @param strLine A string that will overwrite the current room
	 */
	public void setWest(String strLine){
		String fileLoc = database + "/rooms/"+roomName+"/west";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strLine);
	}
	
	/**
	 * Returns the name of the room to the up
	 * @return name of the room
	 */
	public String getUp(){
		String fileLoc = database + "/rooms/"+roomName+"/up";
		FileOperations open = new FileOperations(fileLoc);
		String up = open.getLine();
		return up;
	}
	
	/**
	 * Sets a new room to the up
	 * @param strLine A string that will overwrite the current room
	 */
	public void setUp(String strLine){
		String fileLoc = database + "/rooms/"+roomName+"/up";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strLine);
	}
	
	/**
	 * Returns the name of the room to the down
	 * @return name of the room
	 */
	public String getDown(){
		String fileLoc = database + "/rooms/"+roomName+"/down";
		FileOperations open = new FileOperations(fileLoc);
		String down = open.getLine();
		return down;
	}
	
	/**
	 * Sets a new room to the down
	 * @param strLine A string that will overwrite the current room
	 */
	public void setDown(String strLine){
		String fileLoc = database + "/rooms/"+roomName+"/down";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strLine);
	}
}