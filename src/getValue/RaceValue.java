package getValue;

import maltaProject.FileOperations;

public class RaceValue {
	/**Stores database location - initialized by constructor*/
	String database;
	/**Stores race name - initialized by constructor*/
	String raceName;

	/**
	 * Constructs a new object with a string containing the database location and a string containing the race name.
	 * */
	public RaceValue(String data, String race){
		raceName = race;
		database = data;
	}

	/**
	 * Returns a String[] containing a list of possible classes for the specific race.
	 * @return A String[] containing a list of possible classes
	 */
	public String[] getClassList(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/classList");
		return FO.getFile();
	}

	/**
	 * Sets the list of possible classes for a specific race.
	 * @param classList A String[] containing a list of possible classes
	 */
	public void setClassList(String[] classList){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/classList");
		FO.setFile(classList);
	}

	public String getMinKnowledge(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/minKnowledge");
		return FO.getLine();
	}

	public void setMinKnowledge(String minKnowledge){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/minKnowledge");
		FO.setLine(minKnowledge);
	}

	public String getMaxKnowledge(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/maxKnowledge");
		return FO.getLine();
	}

	public void setMaxKnowledge(String maxKnowledge){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/maxKnowledge");
		FO.setLine(maxKnowledge);
	}
	public String[] getDefaultObjects(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/defaultObjects");
		return FO.getFile();
	}

	public void setDefaultObjects(String[] defaultObjects){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/defaultObjects");
		FO.setFile(defaultObjects);
	}

	public String[] getPossibleSkills(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/possibleSkills");
		return FO.getFile();
	}

	public void setPossibleSkills(String[] possibleSkills){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/possibleSkills");
		FO.setFile(possibleSkills);
	}

	public String getDesc(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/desc");
		return FO.getLine();
	}

	public void setDesc(String desc){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/desc");
		FO.setLine(desc);
	}

	public String getMaxGold(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/maxGold");
		return FO.getLine();
	}

	public void setMaxGold(String maxGold){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/maxGold");
		FO.setLine(maxGold);
	}

	public String getMinGold(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/minGold");
		return FO.getLine();
	}

	public void setMinGold(String minGold){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/minGold");
		FO.setLine(minGold);
	}

	public String getTitle(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/title");
		return FO.getLine();
	}

	public void setTitle(String title){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/title");
		FO.setLine(title);
	}

	public String getAcidProtectionMax(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseProtection/acidProtectionMax");
		return FO.getLine();
	}

	public void setAcidProtectionMax(String acidProtection){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseProtection/acidProtectionMax");
		FO.setLine(acidProtection);
	}

	public String getAcidProtectionMin(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseProtection/acidProtectionMin");
		return FO.getLine();
	}

	public void setAcidProtectionMin(String acidProtection){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseProtection/acidProtectionMin");
		FO.setLine(acidProtection);
	}

	public String getFireProtectionMax(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseProtection/fireProtectionMax");
		return FO.getLine();
	}

	public void setFireProtectionMax(String fireProtection){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseProtection/fireProtectionMax");
		FO.setLine(fireProtection);
	}

	public String getFireProtectionMin(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseProtection/fireProtectionMin");
		return FO.getLine();
	}

	public void setFireProtectionMin(String fireProtection){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseProtection/fireProtectionMin");
		FO.setLine(fireProtection);
	}

	public String getHitProtectionMax(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseProtection/hitProtectionMax");
		return FO.getLine();
	}

	public void setHitProtectionMax(String hitProtection){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseProtection/hitProtectionMax");
		FO.setLine(hitProtection);
	}

	public String getHitProtectionMin(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseProtection/hitProtectionMin");
		return FO.getLine();
	}

	public void setHitProtectionMin(String hitProtection){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseProtection/hitProtectionMin");
		FO.setLine(hitProtection);
	}

	public String getMagicProtectionMax(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseProtection/magicProtectionMax");
		return FO.getLine();
	}

	public void setMagicProtectionMax(String magicProtection){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseProtection/magicProtectionMax");
		FO.setLine(magicProtection);
	}

	public String getMagicProtectionMin(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseProtection/magicProtectionMin");
		return FO.getLine();
	}

	public void setMagicProtectionMin(String magicProtection){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseProtection/magicProtectionMin");
		FO.setLine(magicProtection);
	}

	public String getPierceProtectionMax(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseProtection/pierceProtectionMax");
		return FO.getLine();
	}

	public void setPierceProtectionMax(String pierceProtection){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseProtection/pierceProtectionMax");
		FO.setLine(pierceProtection);
	}

	public String getPierceProtectionMin(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseProtection/pierceProtectionMin");
		return FO.getLine();
	}

	public void setPierceProtectionMin(String pierceProtection){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseProtection/pierceProtectionMin");
		FO.setLine(pierceProtection);
	}

	public String getRangedProtectionMax(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseProtection/rangedProtectionMax");
		return FO.getLine();
	}

	public void setRangedProtectionMax(String rangedProtection){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseProtection/rangedProtectionMax");
		FO.setLine(rangedProtection);
	}

	public String getRangedProtectionMin(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseProtection/rangedProtectionMin");
		return FO.getLine();
	}

	public void setRangedProtectionMin(String rangedProtection){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseProtection/rangedProtectionMin");
		FO.setLine(rangedProtection);
	}

	public String getDexterityMax(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/dexterityMax");
		return FO.getLine();
	}

	public void setDexterityMax(String dexterityMax){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseStats/dexterityMax");
		FO.setLine(dexterityMax);
	}

	public String getDexterityMin(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/dexterityMin");
		return FO.getLine();
	}

	public void setDexterityMin(String dexterityMin){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseStats/dexterityMin");
		FO.setLine(dexterityMin);
	}

	public String getExperienceMax(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/expereienceMax");
		return FO.getLine();
	}

	public void setExperienceMax(String experienceMax){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseStats/expereienceMax");
		FO.setLine(experienceMax);
	}

	public String getExperienceMin(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/experienceMin");
		return FO.getLine();
	}

	public void setExperienceMin(String experienceMin){
		FileOperations FO = new FileOperations(database + "/race/" + raceName + "/baseStats/experienceMin");
		FO.setLine(experienceMin);
	}

	public String getIntelligenceMax(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/intelligenceMax");
		return FO.getLine();
	}

	public void setIntelligenceMax(String intelligenceMax){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/intelligenceMax");
		FO.setLine(intelligenceMax);
	}

	public String getIntelligenceMin(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/intelligenceMin");
		return FO.getLine();
	}

	public void setIntelligenceMin(String intelligenceMin){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/intelligenceMin");
		FO.setLine(intelligenceMin);
	}

	public String getStrengthMax(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/strengthMax");
		return FO.getLine();
	}

	public void setStrengthMax(String strengthMax){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/strengthMax");
		FO.setLine(strengthMax);
	}

	public String getStrengthMin(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/strengthMin");
		return FO.getLine();
	}

	public void setStrengthMin(String strengthMin){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/strengthMin");
		FO.setLine(strengthMin);
	}

	public String getWeightMax(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/weightMax");
		return FO.getLine();
	}

	public void setWeightMax(String weightMax){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/weightMax");
		FO.setLine(weightMax);
	}

	public String getWeightMin(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/weightMin");
		return FO.getLine();
	}

	public void setWeightMin(String weightMin){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/weightMin");
		FO.setLine(weightMin);
	}

	public String getWisdomMax(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/wisdomMax");
		return FO.getLine();
	}

	public void setWisdomMax(String wisdomMax){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/wisdomMax");
		FO.setLine(wisdomMax);
	}

	public String getWisdomMin(){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/wisdomMin");
		return FO.getLine();
	}

	public void setWisdomMin(String wisdomMin){
		FileOperations FO = new FileOperations(database+"/race/" + raceName + "/baseStats/wisdomMin");
		FO.setLine(wisdomMin);
	}
}
