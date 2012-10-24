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
	String npc = "";
	
	/**
	* Constructs a new object with a string containing the database location and a string containing the username.
	*/ 
	public NPCValue(String data, String name){
		database = data;
		npc = name;
	}
	
	/**
	 * Used to obtain the minimum age that an NPC can be
	 * @return A String containing the minimum age
	 */
	public String getMinAge(){
		String fileLoc = database + "/npc/"+npc+"/minAge";
		FileOperations open = new FileOperations(fileLoc);
		String minAge = open.getLine();
		return minAge;
	}
	
	/**
	 * Sets the minimum age that an NPC can be
	 * @param age A String containing the minimum age
	 */
	public void setMinAge(String minAge){
		String fileLoc = database + "/charProfile/"+npc+"/minAge";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(minAge);
	}
	
	/**
	 * Used to obtain the max age that an NPC can be
	 * @return A String containing max age
	 */
	public String getMaxAge(){
		String fileLoc = database + "/npc/"+npc+"/maxAge";
		FileOperations open = new FileOperations(fileLoc);
		String maxAge = open.getLine();
		return maxAge;
	}
	
	/**
	 * Sets the max age that an NPC can be
	 * @param age A String containing the max age
	 */
	public void setMaxAge(String maxAge){
		String fileLoc = database + "/charProfile/"+npc+"/maxAge";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(maxAge);
	}
	
	/**
	 * Used to obtain the class of an NPC
	 * @return A String containing the class
	 */
	public String getNPCClass(){
		String fileLoc = database + "/npc/"+npc+"/class";
		FileOperations open = new FileOperations(fileLoc);
		String NPCclass = open.getLine();
		return NPCclass;
	}
	
	/**
	 * Sets the class of an NPC
	 * @param age A String containing the class
	 */
	public void setNPCClass(String NPCclass){
		String fileLoc = database + "/charProfile/"+npc+"/class";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(NPCclass);
	}
	
	/**
	 * Used to obtain the NPCs current level
	 * @return A String containing the level
	 */
	public String getLevel(){
		String fileLoc = database + "/npc/"+npc+"/level";
		FileOperations open = new FileOperations(fileLoc);
		String level = open.getLine();
		return level;
	}
	
	/**
	 * Sets the level of an NPC
	 * @param age A String containing the level
	 */
	public void setLevel(String level){
		String fileLoc = database + "/charProfile/"+npc+"/level";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(level);
	}
	
	/**
	 * Used to obtain the NPC's race
	 * @return A String containing the race
	 */
	public String getRace(){
		String fileLoc = database + "/npc/"+npc+"/race";
		FileOperations open = new FileOperations(fileLoc);
		String race = open.getLine();
		return race;
	}
	
	/**
	 * Sets the race of an NPC
	 * @param age A String containing the race
	 */
	public void setRace(String race){
		String fileLoc = database + "/charProfile/"+npc+"/race";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(race);
	}
	
	/**
	 * Used to obtain the NPC's religion
	 * @return A String containing the religion
	 */
	public String getReligion(){
		String fileLoc = database + "/npc/"+npc+"/religion";
		FileOperations open = new FileOperations(fileLoc);
		String religion = open.getLine();
		return religion;
	}
	
	/**
	 * Sets the religion of an NPC
	 * @param age A String containing the religion
	 */
	public void setReligion(String religion){
		String fileLoc = database + "/charProfile/"+npc+"/religion";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(religion);
	}
}
