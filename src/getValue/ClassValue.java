package getValue;

import maltaProject.FileOperations;


//TODO finish writing getters & setters

public class ClassValue {
	/**Stores database location - initialized by constructor*/
	String database;
	/**Stores class name - initialized by constructor*/
	String className;

	/**
	 * Constructs a new object with a string containing the database location and a string containing the class name.
	 * */
	public ClassValue(String data, String nameClass){
		database = data;
		className = nameClass;
	}

	public String getDesc(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/desc");
		return FO.getLine();
	}

	public void setDesc(String desc){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/desc");
		FO.setLine(desc);
	}

	public String[] getReligionList(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/religionList");
		return FO.getFile();
	}

	public void setReligionList(String[] religionList){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/religionList");
		FO.setFile(religionList);
	}

	public String[] getSubClassList(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClassList");
		return FO.getFile();
	}

	public void setSubClassList(String[] subClassList){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClassList");
		FO.setFile(subClassList);
	}

	public String getTitle(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/title");
		return FO.getLine();
	}

	public void setTitle(String title){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/title");
		FO.setLine(title);
	}

	public String getSubClassLevel(int level){
		level--; //Corrects for array
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClassList");
		String[] classList = FO.getFile();
		if (classList[level] != null){
			return classList[level];
		} else {
			return "";
		}

	}


}
