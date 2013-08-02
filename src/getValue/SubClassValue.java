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

	public int getAcidProtectionModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/acidModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setAcidProtectionModifier(String acidModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/acidModifier");
		FO.setLine(acidModifier);
	}

	public int getFireProtectionModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/fireModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setFireProtectionModifier(String fireModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/fireModifier");
		FO.setLine(fireModifier);
	}

	public int getHitProtectionModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/hitModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setHitProtectionModifier(String hitModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/hitModifier");
		FO.setLine(hitModifier);
	}

	public int getMagicProtectionModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/magicModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setMagicProtectionModifier(String magicModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/magicModifier");
		FO.setLine(magicModifier);
	}

	public int getPierceProtectionModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/pierceModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setPierceProtectionModifier(String pierceModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/pierceModifier");
		FO.setLine(pierceModifier);
	}

	public int getRangedProtectionModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/rangedModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setRangedProtectionModifier(String rangedModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/protectionModifier/rangedModifier");
		FO.setLine(rangedModifier);
	}

	public int getAgeModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/ageModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setAgeModifier(String ageModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/ageModifier");
		FO.setLine(ageModifier);
	}

	public int getDexterityBonus(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/dexterityModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}

	}

	public void setDexterityBonus(String dexterityModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/dexterityModifier");
		FO.setLine(dexterityModifier);
	}

	public int getExperienceModifier(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/experienceModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setExperienceModifier(String experienceBonus){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/experienceModifier");
		FO.setLine(experienceBonus);
	}

	public int getIntelligenceBonus(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/intelligenceModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setIntelligenceBonus(String intelligenceBonus){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/intelligenceModifier");
		FO.setLine(intelligenceBonus);
	}

	public int getStrengthBonus(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/strengthModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setStrengthBonus(String strengthBonus){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/strengthModifier");
		FO.setLine(strengthBonus);
	}

	public int getWeightBonus(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/weightModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setWeightBonus(String weightBonus){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/weightModifier");
		FO.setLine(weightBonus);
		;	}

	public int getWisdomBonus(){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/wisdomModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setWisdomBonus(String wisdomModifier){
		FileOperations FO = new FileOperations(database + "/class/" + className + "/subClass/" + subName + "/statModifier/wisdomModifier");
		FO.setLine(wisdomModifier);
	}
}
