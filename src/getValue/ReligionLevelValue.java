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
	 * @return An int containing the dexterity modifier
	 */
	public int getDexterityBonus(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/dexterityModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the dexterity modifier of the religion's level
	 * @param dexterityModifier A String containing the dexterity modifier
	 */
	public void setDexterityBonus(String dexterityModifier){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/dexterityModifier");
		FO.setLine(dexterityModifier);
	}

	/**
	 * Returns an int containing the experience modifier of the religion's level
	 * @return An int containing the dexterity modifier
	 */
	public int getExperienceModifier(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/experienceModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the experience modifier of the religion's level
	 * @param experienceBonus A String containing the dexterity modifier
	 */
	public void setExperienceModifier(String experienceBonus){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/experienceModifier");
		FO.setLine(experienceBonus);
	}

	/**
	 * Returns an int containing the intelligence modifier of the religion's level
	 * @return An int containing the intelligence modifier
	 */
	public int getIntelligenceBonus(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/intelligenceModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the intelligence modifier of the religion's level
	 * @param intelligenceBonus A String containing the intelligence modifier
	 */
	public void setIntelligenceBonus(String intelligenceBonus){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/intelligenceModifier");
		FO.setLine(intelligenceBonus);
	}

	/**
	 * Returns an int containing the strength modifier of the religion's level
	 * @return An int containing the strength modifier
	 */
	public int getStrengthBonus(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/strengthModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the strength modifier of the religion's level
	 * @param strengthBonus A String containing the strength modifier
	 */
	public void setStrengthBonus(String strengthBonus){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/strengthModifier");
		FO.setLine(strengthBonus);
	}

	/**
	 * Returns an int containing the wisdom modifier of the religion's level
	 * @return An int containing the wisdom modifier
	 */
	public int getWisdomBonus(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/wisdomModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the wisdom modifier of the religion's level
	 * @param wisdomBonus A String containing the wisdom modifier
	 */
	public void setWisdomBonus(String wisdomBonus){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/modifiers/wisdomModifier");
		FO.setLine(wisdomBonus);
	}

	/**
	 * Returns the acid protection modifier of the religion's level
	 * @return An int containing the acid protection
	 */
	public int getAcidProtectionModifier(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/acidProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 100;
		}
	}

	/**
	 * Sets the acid protection modifier of the religion's level
	 * @param acidProtection A String containing the acid protection modifier
	 */
	public void setAcidProtectionModifier(String acidProtection){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/acidProtection");
		FO.setLine(acidProtection);
	}

	/**
	 * Returns the fire protection modifier of the religion's level
	 * @return An int containing the fire protection
	 */
	public int getFireProtectionModifier(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/fireProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 100;
		}
	}

	/**
	 * Sets the fire protection modifier of the religion's level
	 * @param fireProtection A String containing the fire protection modifier
	 */
	public void setFireProtectionModifier(String fireProtection){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/fireProtection");
		FO.setLine(fireProtection);
	}

	/**
	 * Returns the hit protection modifier of the religion's level
	 * @return An int containing the fire protection
	 */
	public int getHitProtectionModifier(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/hitProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 100;
		}
	}

	/**
	 * Sets the hit protection modifier of the religion's level
	 * @param hitProtection A String containing the hit protection modifier
	 */
	public void setHitProtectionModifier(String hitProtection){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/hitProtection");
		FO.setLine(hitProtection);
	}

	/**
	 * Returns the magic protection modifier of the religion's level
	 * @return An int containing the magic protection
	 */
	public int getMagicProtectionModifier(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/magicProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 100;
		}
	}

	/**
	 * Sets the magic protection modifier of the religion's level
	 * @param magicProtection A String containing the magic protection modifier
	 */
	public void setMagicProtectionModifier(String magicProtection){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/magicProtection");
		FO.setLine(magicProtection);
	}

	/**
	 * Returns the pierce protection modifier of the religion's level
	 * @return An int containing the pierce protection
	 */
	public int getPierceProtectionModifier(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/pierceProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 100;
		}
	}

	/**
	 * Sets the pierce protection modifier of the religion's level
	 * @param pierceProtection A String containing the pierce protection modifier
	 */
	public void setPierceProtectionModifier(String pierceProtection){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/pierceProtection");
		FO.setLine(pierceProtection);
	}

	/**
	 * Returns the ranged protection modifier of the religion's level
	 * @return An int containing the ranged protection
	 */
	public int getRangedProtectionModifier(){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/rangedProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 100;
		}
	}

	/**
	 * Sets the ranged protection modifier of the religion's level
	 * @param rangedProtection A String containing the ranged protection modifier
	 */
	public void setRangedProtectionModifier(String rangedProtection){
		FileOperations FO = new FileOperations(database + "/religion/" + religionName + "/levels/" + religionLevel + "/protection/rangedProtection");
		FO.setLine(rangedProtection);
	}
}
