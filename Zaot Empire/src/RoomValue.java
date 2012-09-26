import Main.openFile;

/**
* This class is used to return information on a given room. Given the room
* name and the location of the database, a string with the requested stat
* will be returned.
*
* @author  Nicholas Ingalls
*/
public class RoomValue {
	String database, user;
	RoomValue(String data, String username){
		user = username;
		database = data;
	}
}