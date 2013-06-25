package getValue;

import maltaProject.FileOperations;


//TODO finish writing getters & setters

public class SubClassValue {
	/**Stores database location - initialized by constructor*/
	String database;
	/**Stores class name - initialized by constructor*/
	String className;
	/**Stores sub class name - initialized by constructor*/
	String subName;

	/**
	 * Constructs a new object with a string containing the database location and a string containing the class name.
	 * */
	public SubClassValue(String data, String nameClass, String subClass){
		database = data;
		className = nameClass;
		subName = subClass;
	}

	public String getTitle(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/title");
		return FO.getLine();
	}

	public void setTitle(String title){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/title");
		FO.setLine(title);
	}

	public String getDesc(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/desc");
		return FO.getLine();
	}

	public void setDesc(String desc){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/desc");
		FO.setLine(desc);
	}

	public String[] getDefaultSkills(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/defaultSkills");
		return FO.getFile();
	}

	public void setDefaultSkills(String[] defaultSkills){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/defaultSkills");
		FO.setFile(defaultSkills);
	}

	public String[] getDefaultObjects(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/defaultObjects");
		return FO.getFile();
	}

	public void setDefaultObjects(String[] defaultObjects){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/defaultObjects");
		FO.setFile(defaultObjects);
	}

	public String getAcidModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/acidModifier");
		return FO.getLine();
	}

	public void setAcidModifier(String acidModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/acidModifier");
		FO.setLine(acidModifier);
	}

	public String getFireModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/fireModifier");
		return FO.getLine();
	}

	public void setFireModifier(String fireModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/fireModifier");
		FO.setLine(fireModifier);
	}

	public String getHitModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/hitModifier");
		return FO.getLine();
	}

	public void setHitModifier(String hitModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/hitModifier");
		FO.setLine(hitModifier);
	}

	public String getMagicModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/magicModifier");
		return FO.getLine();
	}

	public void setMagicModifier(String magicModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/magicModifier");
		FO.setLine(magicModifier);
	}

	public String getPierceModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/pierceModifier");
		return FO.getLine();
	}

	public void setPierceModifier(String pierceModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/pierceModifier");
		FO.setLine(pierceModifier);
	}

	public String getRangedModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/rangedModifier");
		return FO.getLine();
	}

	public void setRangedModifier(String rangedModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/rangedModifier");
		FO.setLine(rangedModifier);
	}

	public String getAgeModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/ageModifier");
		return FO.getLine();
	}

	public void setAgeModifier(String ageModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/ageModifier");
		FO.setLine(ageModifier);
	}

	public String getDexterityModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/dexterityModifier");
		return FO.getLine();
	}

	public void setDexterityModifier(String dexterityModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/dexterityModifier");
		FO.setLine(dexterityModifier);
	}

	public String getExperienceModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/experienceModifier");
		return FO.getLine();
	}

	public void setExperienceModifier(String experienceModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/experienceModifier");
		FO.setLine(experienceModifier);
	}

	public String getIntelligenceModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/intelligenceModifier");
		return FO.getLine();
	}

	public void setIntelligenceModifier(String intelligenceModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/intelligenceModifier");
		FO.setLine(intelligenceModifier);
	}

	public String getStrengthModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/strengthModifier");
		return FO.getLine();
	}

	public void setStrengthModifier(String strengthModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/strengthModifier");
		FO.setLine(strengthModifier);
	}

	public String getWeightModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/weightModifier");
		return FO.getLine();
	}

	public void setWeightModifier(String weightModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/weightModifier");
		FO.setLine(weightModifier);
		;	}

	public String getWisdomModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/wisdomModifier");
		return FO.getLine();
	}

	public void setWisdomModifier(String wisdomModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/wisdomModifier");
		FO.setLine(wisdomModifier);
	}
}
