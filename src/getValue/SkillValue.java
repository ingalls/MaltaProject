package getValue;

import maltaProject.FileOperations;

public class SkillValue {

	/** Stores database location - initialized by constructor */
	String database = "";
	/** Stores the name of the object - initialized by constructor */
	String skill = "";

	/**
	 * Constructs a new object with a string containing the database location
	 * * and a string containing the user name.
	 * @param data A String containing the database location
	 * @param skillName A String containing the name of the object being accessed
	 */
	public SkillValue(String data, String skillName) {
		database = data;
		skill = skillName;
	}

	public String getTitle(){
		FileOperations FO = new FileOperations(database + "/skills/" + skill + "/title");
		return FO.getLine();
	}

	public void setTitle(String title){
		FileOperations FO = new FileOperations(database + "/skills/" + skill + "/title");
		FO.setLine(title);
	}

	public String getDesc(){
		FileOperations FO = new FileOperations(database + "/skills/" + skill + "/desc");
		return FO.getLine();
	}

	public void setDesc(String desc){
		FileOperations FO = new FileOperations(database + "/skills/" + skill + "/desc");
		FO.setLine(desc);
	}
}
