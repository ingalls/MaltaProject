package getValue;

import maltaProject.FileOperations;

/**
 * This class contains getters and setters allowing the calling method
 * to obtain the values in a religion's level.
 * @author Nicholas Ingalls
 */
public class ReligionLevelValue {

	/** Stores the location of the database */
	String database = "";

	/** Stores the name of the religion */
	String religionName = "";

	/** Stores the name of the religionLevel */
	String religionLevel = "";

	/**
	 * Constructs a new ReligionLevelValue object
	 * @param data A String containing the location of the database
	 * @param religion A String containing the name of the religion being accessed
	 * @param religionLvl A String containing the religion level to access
	 */
	public ReligionLevelValue(String data, String religion, String religionLvl){
		database = data;
		religionName = religion;
		religionLevel = religionLvl;
	}

	/**
	 * Returns the description of the religion level
	 * @return A String containing the description
	 */
	public String getDesc(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/desc");
		return FO.getLine();
	}

	/**
	 * Sets the description of the religion level
	 * @param desc A String containing the description
	 */
	public void setDesc(String desc){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/desc");
		FO.setLine(desc);
	}

	/**
	 * Returns a String containing the full title of the religion
	 * @return A String containing the title
	 */
	public String getTitle(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/title");
		return FO.getLine();
	}

	/**
	 * Sets the full title of a religion
	 * @param title A String containing the full title
	 */
	public void setTitle(String title){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/title");
		FO.setLine(title);
	}

	/**
	 * Returns the dexterity modifier of the religion's level
	 * @return A String containing the dexterity modifier
	 */
	public String getDexterityModifier(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/dexterityModifier");
		return FO.getLine();
	}

	/**
	 * Sets the dexterity modifier of the religion's level
	 * @param dexterityModifier A String containing the dexterity modifier
	 */
	public void setDexterityModifier(String dexterityModifier){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/dexterityModifier");
		FO.setLine(dexterityModifier);
	}

	/**
	 * Returns a String containing the experience modifier of the religion's level
	 * @return A String containing the dexterity modifier
	 */
	public String getExperienceModifier(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/experienceModifier");
		return FO.getLine();
	}

	/**
	 * Sets the experience modifier of the religion's level
	 * @param experienceModifier A String containing the dexterity modifier
	 */
	public void setExperienceModifier(String experienceModifier){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/experienceModifier");
		FO.setLine(experienceModifier);
	}

	/**
	 * Returns a String containing the intelligence modifier of the religion's level
	 * @return A String containing the intelligence modifier
	 */
	public String getIntelligenceModifier(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/intelligenceModifier");
		return FO.getLine();
	}

	/**
	 * Sets the intelligence modifier of the religion's level
	 * @param intelligenceModifier A String containing the intelligence modifier
	 */
	public void setIntelligenceModifier(String intelligenceModifier){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/intelligenceModifier");
		FO.setLine(intelligenceModifier);
	}

	/**
	 * Returns a String containing the strength modifier of the religion's level
	 * @return A String containing the strength modifier
	 */
	public String getStrengthModifier(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/strengthModifier");
		return FO.getLine();
	}

	/**
	 * Sets the strength modifier of the religion's level
	 * @param strengthModifier A String containing the strength modifier
	 */
	public void setStrengthModifier(String strengthModifier){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/strengthModifier");
		FO.setLine(strengthModifier);
	}

	/**
	 * Returns a String containing the wisdom modifier of the religion's level
	 * @return A String containing the wisdom modifier
	 */
	public String getWisdomModifier(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/wisdomModifier");
		return FO.getLine();
	}

	/**
	 * Sets the wisdom modifier of the religion's level
	 * @param wisdomModifier A String containing the wisdom modifier
	 */
	public void setWisdomModifier(String wisdomModifier){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/wisdomModifier");
		FO.setLine(wisdomModifier);
	}

	/**
	 * Returns the acid protection modifier of the religion's level
	 * @return A String containing the acid protection
	 */
	public String getAcidProtection(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/acidProtection");
		return FO.getLine();
	}

	/**
	 * Sets the acid protection modifier of the religion's level
	 * @param acidProtection A String containing the acid protection modifier
	 */
	public void setAcidProtection(String acidProtection){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/acidProtection");
		FO.setLine(acidProtection);
	}

	/**
	 * Returns the fire protection modifier of the religion's level
	 * @return A String containing the fire protection
	 */
	public String getFireProtection(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/fireProtection");
		return FO.getLine();
	}

	/**
	 * Sets the fire protection modifier of the religion's level
	 * @param fireProtection A String containing the fire protection modifier
	 */
	public void setFireProtection(String fireProtection){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/fireProtection");
		FO.setLine(fireProtection);
	}

	/**
	 * Returns the hit protection modifier of the religion's level
	 * @return A String containing the fire protection
	 */
	public String getHitProtection(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/hitProtection");
		return FO.getLine();
	}

	/**
	 * Sets the hit protection modifier of the religion's level
	 * @param hitProtection A String containing the hit protection modifier
	 */
	public void setHitProtection(String hitProtection){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/hitProtection");
		FO.setLine(hitProtection);
	}

	/**
	 * Returns the magic protection modifier of the religion's level
	 * @return A String containing the magic protection
	 */
	public String getMagicProtection(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/magicProtection");
		return FO.getLine();
	}

	/**
	 * Sets the magic protection modifier of the religion's level
	 * @param magicProtection A String containing the magic protection modifier
	 */
	public void setMagicProtection(String magicProtection){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/magicProtection");
		FO.setLine(magicProtection);
	}

	/**
	 * Returns the pierce protection modifier of the religion's level
	 * @return A String containing the pierce protection
	 */
	public String getPierceProtection(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/pierceProtection");
		return FO.getLine();
	}

	/**
	 * Sets the pierce protection modifier of the religion's level
	 * @param pierceProtection A String containing the pierce protection modifier
	 */
	public void setPierceProtection(String pierceProtection){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/pierceProtection");
		FO.setLine(pierceProtection);
	}

	/**
	 * Returns the ranged protection modifier of the religion's level
	 * @return A String containing the ranged protection
	 */
	public String getRangedProtection(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/rangedProtection");
		return FO.getLine();
	}

	/**
	 * Sets the ranged protection modifier of the religion's level
	 * @param rangedProtection A String containing the ranged protection modifier
	 */
	public void setRangedProtection(String rangedProtection){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/rangedProtection");
		FO.setLine(rangedProtection);
	}
}
