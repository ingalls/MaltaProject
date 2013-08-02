package getValue;

import maltaProject.FileOperations;

/**
 * This class contains getters and setters allowing the calling method
 * to obtain stats on the particular religion being requested.
 * 
 * @author Nicholas Ingalls
 */
public class ReligionValue {

	/** Stores the location of the database */
	String database = "";

	/** Stores the name of the religion */
	String religionName = "";

	/**
	 * Constructs a new ReligionValue object
	 * @param data A String containing the location of the database
	 * @param religion A String containing the name of the religion being accessed
	 */
	public ReligionValue (String data, String religion){
		database = data;
		religionName = religion;
	}

	/**
	 * Returns the religion's descriptions
	 * @return A String containing the description of the religion
	 */
	public String getDesc(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/desc");
		return FO.getLine();
	}

	/**
	 * Sets the religion's description
	 * @param desc A String containing the description of the religion
	 */
	public void setDesc(String desc){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/desc");
		FO.setLine(desc);
	}

	/**
	 * Returns the levels within a religion
	 * @return A String[] containing the levels within a religion
	 */
	public String[] getLevelList(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levelList");
		return FO.getFile();
	}

	/**
	 * Sets the levels within a religion
	 * @param levelList A String[] containing the levels within a religion
	 */
	public void setLevelList(String[] levelList){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levelList");
		FO.setFile(levelList);
	}

	/**
	 * Returns the religion's full name
	 * @return A String containing the religion's full name
	 */
	public String getTitle(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/title");
		return FO.getLine();
	}

	/**
	 * Sets the religion's full name
	 * @param title A String containing the religion's full name
	 */
	public void setTitle(String title){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/title");
		FO.setLine(title);
	}

	/**
	 * Returns a String[] containing the class requirements for a religion
	 * If there are no class requirements, the first element of the String[] will equal "none"
	 * @return A String[] containing the class requirements
	 */
	public String[] getRequiredClass(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/requirements/requiredClass");
		return FO.getFile();
	}

	/**
	 * Sets the class requirements for a religion
	 * If there are no class requirements, the paramater should be a single element array
	 * with the first element equaling "none"
	 * @param requiredClass A String[] containing the names of the levels
	 */
	public void setRequiredClass(String[] requiredClass){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/requirements/requiredClass");
		FO.setFile(requiredClass);
	}

	/**
	 * Returns a String[] containing the race requirements for a religion
	 * If there are no race requirements, the first element of the String[] will equal "none"
	 * @return A String[] containing the race requirements
	 */
	public String[] getRequiredRace(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/requirements/requiredRace");
		return FO.getFile();
	}

	/**
	 * Sets the race requirements for a religion
	 * If there are no race requirements, the parameter should be a single element array
	 * with the first element equaling "none"
	 * @param requiredRace A String[] containing the race requirements
	 */
	public void setRequiredRace(String[] requiredRace){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/requirements/requiredRace");
		FO.setFile(requiredRace);
	}

}
