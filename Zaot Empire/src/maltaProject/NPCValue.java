package maltaProject;

/**
* This class is used to obtain stats about an NPC. Given the NPC's
* name and the location of the server database, a string with the specific
* stat will be returned.
*
* @author  Nicholas Ingalls
*/

public class NPCValue {
	/**Stores database location - initialized by constructor*/
	String database = "";
	/**Stores the name of the NPC - initialized by constructor*/
	String user = "";
	
	/**
	* Constructs a new object with a string containing the database location and a string containing the username.
	*/ 
	public NPCValue(String data, String username){
		database = data;
		user = username;
	}
}
