package Main;
//This class is responsible for creating a new NPC object
//It is used primarily when a user chooses to fight an NPC

/**
* This class is used to construct a new NPC object. It is used when
* setting up a fight between a user and an NPC. It depends on the getNpcValue
* class to initialise instance variables.
*
* @author  Nicholas Ingalls
*/

public class NPC {
	/**stores the name of the NPC*/
	String name;
	
	
	NPC(String NPCname){ //Constructor
		name = NPCname;
	}
}
