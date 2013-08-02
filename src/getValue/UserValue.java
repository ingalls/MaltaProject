package getValue;

import maltaProject.FileOperations;

/**
 * This class is used to obtain statistics about a user. Given the user's
 * name and the location of the server database, a string with the specific
 * statistic will be returned.
 *
 * @author  Nicholas Ingalls
 */

public class UserValue {
	/**Stores database location - initialized by constructor*/
	String database = "";
	/**Stores user name - initialized by constructor*/
	String user = "";

	/**
	 * Constructs a new object with a string containing the database location and a string containing the username.
	 */
	public UserValue(String data, String username){
		database = data;
		user = username;
	}

	/**
	 * Is the user currently sitting down
	 * @return A boolean as to whether the user is sitting down
	 */
	public boolean isSitting(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/isSitting");
		return FO.checkFile();
	}

	/**
	 * Sets whether the user is sitting down or not
	 * @param sitting A boolean to whether the user is sitting down or not
	 */
	public void setSitting(boolean sitting){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/isSitting");
		if (sitting == true){
			FO.setLine("");
		} else {
			if (FO.checkFile()){
				FO.deleteFile();
			}
		}

	}

	/**
	 * Is the user a wizard
	 * @return A boolean as to whether the user is a wizard
	 */
	public boolean isWizard(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/wizard");
		return FO.checkFile();
	}

	/**
	 * Sets whether the user is a wizard or not
	 * @param wizard true for the user being a wizard, false for not.
	 */
	public void setWizard(boolean wizard){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/wizard");
		if (wizard == true){
			FO.setLine("");
		} else {
			if (FO.checkFile()){
				FO.deleteFile();
			}
		}
	}

	/**
	 * Is the user sleeping?
	 * @return A boolean as to whether the user is sleeping
	 */
	public boolean isSleeping(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/sleep");
		return FO.checkFile();
	}

	/**
	 * Sets whether the user is sleeping or not
	 * @param sleep true for the user sleeping, false for not.
	 */
	public void setSleep(boolean sleep){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/sleep");
		if (sleep == true){
			FO.setLine("true");
		} else {
			if (FO.checkFile()){
				FO.deleteFile();
			}
		}

	}

	/**
	 * Used to obtain the max mana of a user
	 * @return An integer containing the max mana of a user
	 */
	public int getMaxMana(){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/maxmana");
		return Integer.parseInt(open.getLine());
	}

	/**
	 * Sets the max mana of a user
	 * @param maxMana An integer containing the max mana of a user
	 */
	public void setMaxMana(int maxMana){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/maxmana");
		open.setLine(Integer.toString(maxMana));
	}

	/**
	 * Used to obtain the mana of a user
	 * @return An integer containing the mana of a user
	 */
	public int getMana(){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/mana");
		return Integer.parseInt(open.getLine());
	}

	/**
	 * Sets the mana of a user
	 * @param mana An integer containing the mana of a user
	 */
	public void setMana(int mana){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/mana");
		open.setLine(Integer.toString(mana));
	}

	/**
	 * Used to obtain the age of a user.
	 * @return An integer containing the age of a user
	 */
	public int getAge(){
		String fileLoc = database + "/charProfile/"+user+"/age";
		FileOperations open = new FileOperations(fileLoc);
		String userAge = open.getLine();
		return Integer.parseInt(userAge);
	}

	/**
	 * Sets the age of a user
	 * @param age An integer containing the age of a user
	 */
	public void setAge(int age){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/age");
		open.setLine(Integer.toString(age));
	}


	/**
	 * Used to obtain the class of a user.
	 * @return A String containing the class of a user
	 */
	public String getUserSubClass(){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/subClass");
		return open.getLine();
	}

	/**
	 * Sets the subclass of a user
	 * @param userClass A String containing the subclass of a user
	 */
	public void setUserSubClass(String userClass){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/subClass");
		open.setLine(userClass);
	}

	/**
	 * Used to obtain the class of a user.
	 * @return A String containing the class of a user
	 */
	public String getUserClass(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/class");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Sets the subclass of a user
	 * @param userClass A String containing the class of a user
	 */
	public void setUserClass(String userClass){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/class");
		open.setLine(userClass);
	}

	/**
	 * Used to obtain the dexterity of a user.
	 * @return An integer containing the dexterity of a user
	 */
	public int getBaseDexterity(){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/stats/dexterity");
		return Integer.parseInt(open.getLine());
	}

	/**
	 * Sets the Dex of a user
	 * @param dex An integer containing the dex of a user
	 */
	public void setBaseDexterity(int dex){
		String fileLoc = database + "/charProfile/"+user+"/stats/dexterity";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(dex));
	}

	/**
	 * used to obtain the experience of a user.
	 * @return An integer containing the experience of a user
	 */
	public int getXP(){
		String fileLoc = database + "/charProfile/"+user+"/stats/experience";
		FileOperations open = new FileOperations(fileLoc);
		String userXP = open.getLine();
		return Integer.parseInt(userXP);
	}

	/**
	 * Used to set the experience of a user
	 * @param XP An integer containing the experience
	 */
	public void setXP(int XP){
		String fileLoc = database + "/charProfile/"+user+"/stats/experience";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(XP));
	}

	/**
	 * used to return the amount of gold that a user has.
	 * @return An integer containing the amount of gold
	 */
	public int getGold(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/gold");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Used to set the amount of gold a user has
	 * @param Gold An integer containing the amount of gold
	 */
	public void setGold(int Gold){
		String fileLoc = database + "/charProfile/"+user+"/gold";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(Gold));
	}

	/**
	 * Used to obtain the health of a user. This is the current health, as opposed to @see getMaxHealth
	 * @return An integer containing the health of a user
	 */
	public int getHP(){
		String fileLoc = database + "/charProfile/"+user+"/health";
		FileOperations open = new FileOperations(fileLoc);
		String userHP = open.getLine();
		return Integer.parseInt(userHP);
	}

	/**
	 * Used to set the amount of Health Points a user has
	 * @param HP An integer containing the number of health points
	 */
	public void setHP(int HP){
		String fileLoc = database + "/charProfile/"+user+"/health";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(HP));
	}

	/**
	 * Used to obtain the intelligence of a user.
	 * @return An integer containing the intelligence of a user
	 */
	public int getBaseIntelligence(){
		String fileLoc = database + "/charProfile/"+user+"/stats/intelligence";
		FileOperations open = new FileOperations(fileLoc);
		String userInt = open.getLine();
		return Integer.parseInt(userInt);
	}

	/**
	 * Used to set the amount of intelligence a user has
	 * @param Int An integer containing the amount of intelligence
	 */
	public void setBaseIntelligence(int Int){
		String fileLoc = database + "/charProfile/"+user+"/stats/intelligence";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(Int));
	}

	/**
	 * Used to obtain the level of a user.
	 * @return An integer containing the level of a user
	 */
	public int getLevel(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/level");
		if (FO.checkFile()){
			if (Integer.parseInt(FO.getLine()) == 0){
				return 1;
			} else {
				return Integer.parseInt(FO.getLine());
			}
		} else {
			return 1;
		}
	}

	/**
	 * Used to set the user's level
	 * @param level An integer containing the level to set
	 */
	public void setLevel(int level){
		String fileLoc = database + "/charProfile/"+user+"/level";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(level));
	}

	/**
	 * Used to obtain the location of a user.
	 * @return A String containing the location (Name of the room) of a user. Will be formatted as "area/room"
	 */
	public String getLoc(){
		String fileLoc = database + "/charProfile/"+user+"/location";
		FileOperations open = new FileOperations(fileLoc);
		String userLoc = open.getLine();
		return userLoc;
	}

	/**
	 * Used to set the location of a user
	 * @param loc A string containing the location. Should be formatted as 'area/roomame' ie: "underrealm/tunnel"
	 */
	public void setLoc(String loc){
		String fileLoc = database + "/charProfile/"+user+"/location";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(loc);
	}

	/**
	 * Used to obtain the race of a user.
	 * @return A String containing the race of a user
	 */
	public String getRace(){
		String fileLoc = database + "/charProfile/"+user+"/race";
		FileOperations open = new FileOperations(fileLoc);
		String userRace = open.getLine();
		return userRace;
	}

	/**
	 * Used to set the race of a user
	 * @param race A String containing the race to set
	 */
	public void setRace(String race){
		String fileLoc = database + "/charProfile/"+user+"/race";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(race);
	}

	/**
	 * Used to obtain the religion level of a user.
	 * @return A String containing the religion of a user
	 */
	public String getReligionLvl(){
		String fileLoc = database + "/charProfile/"+user+"/religionLvl";
		FileOperations open = new FileOperations(fileLoc);
		String userReligion = open.getLine();
		return userReligion;
	}

	/**
	 * Used to set the Religion level of a user
	 * @param religion A String containing the religion to set
	 */
	public void setReligionLvl(String religion){
		String fileLoc = database + "/charProfile/"+user+"/religionLvl";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(religion);
	}

	/**
	 * Used to obtain the religion of a user.
	 * @return A String containing the age of a user
	 */
	public String getReligion(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/religion");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}

	}

	/**
	 * Used to set the Religion of a user
	 * @param religion A String containing the religion to set
	 */
	public void setReligion(String religion){
		String fileLoc = database + "/charProfile/"+user+"/religion";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(religion);
	}

	/**
	 * Used to obtain the gender of a user.
	 * @return A String containing the gender of a user Either "male" or "female"
	 */
	public String getSex(){
		String fileLoc = database + "/charProfile/"+user+"/sex";
		FileOperations open = new FileOperations(fileLoc);
		String userSex = open.getLine();
		return userSex;
	}

	/**
	 * Used to change the sex of a user
	 * @param sex A String containing the sex to set. Should be either "male" or "female"
	 */
	public void setSex(String sex){
		sex = sex.toLowerCase();
		String fileLoc = database + "/charProfile/"+user+"/sex";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(sex);
	}

	/**
	 * Used to obtain the strength of a user.
	 * @return An integer containing the strength of a user
	 */
	public int getBaseStrength(){
		String fileLoc = database + "/charProfile/"+user+"/stats/strength";
		FileOperations open = new FileOperations(fileLoc);
		String userStr = open.getLine();
		return Integer.parseInt(userStr);
	}

	/**
	 * Used to set the strength of a user
	 * @param str An integer containing the strength to set
	 */
	public void setBaseStrength(int str){
		String fileLoc = database + "/charProfile/"+user+"/stats/strength";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(str));
	}

	/**
	 * Used to obtain the weight of a user.
	 * @return An integer containing the weight of a user
	 */
	public int getWeight(){
		String fileLoc = database + "/charProfile/"+user+"/weight";
		FileOperations open = new FileOperations(fileLoc);
		String userWeight = open.getLine();
		return Integer.parseInt(userWeight);
	}

	/**
	 * Used to set the weight of the user
	 * @param weight An integer containing the weight to set
	 */
	public void setWeight(int weight){
		String fileLoc = database + "/charProfile/"+user+"/weight";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(weight));
	}

	/**
	 * Used to obtain the maximum health of a user.
	 * @return An integer containing the maximum health of a user
	 */
	public int getMaxHealth(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/maxhealth");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Used to set the max health of a user
	 * @param health An integer containing the max health to set
	 */
	public void setMaxHealth(int health){
		String fileLoc = database + "/charProfile/"+user+"/maxhealth";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(health));
	}

	/**
	 * Used to obtain the wisdom of a user.
	 * @return An integer containing the wisdom of a user
	 */
	public int getBaseWisdom(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/stats/wisdom");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Used to set the wisdom of a user
	 * @param wis An integer containing the wisdom to set
	 */
	public void setBaseWisdom(int wis){
		String fileLoc = database + "/charProfile/"+user+"/stats/wisdom";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(wis));
	}

	/**
	 * Used to obtain any guild the user is a member of.
	 * The default text is "none". Otherwise, it will be the name of the guild
	 * @return A String containing the guild of a user
	 */
	public String getGuild(){
		String fileLoc = database + "/charProfile/"+user+"/guild";
		FileOperations open = new FileOperations(fileLoc);
		String guild = open.getLine();
		return guild;
	}

	/**
	 * Used to set the guild of a user
	 * @param guild A String containing the guild to set
	 */
	public void setGuild(String guild){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/guild");
		open.setLine(guild);
	}

	public int getBaseAcidProtection(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/protection/acidProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setBaseAcidProtection(int protection){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/protection/acidProtection");
		FO.setLine(protection + "");
	}

	public int getBaseFireProtection(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/protection/fireProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setBaseFireProtection(int protection){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/protection/fireProtection");
		FO.setLine(protection + "");
	}

	public int getBaseHitProtection(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/protection/hitProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setBaseHitProtection(int protection){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/protection/hitProtection");
		FO.setLine(protection + "");
	}

	public int getBaseMagicProtection(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/protection/magicProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setBaseMagicProtection(int protection){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/protection/magicProtection");
		FO.setLine(protection + "");
	}

	public int getBasePierceProtection(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/protection/pierceProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setBasePierceProtection(int protection){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/protection/pierceProtection");
		FO.setLine(protection + "");
	}

	public int getBaseRangedProtection(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/protection/rangedProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setBaseRangedProtection(int protection){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/protection/rangedProtection");
		FO.setLine(protection + "");
	}

	/**
	 * Used to obtain what the user is wearing on their chest
	 * @return A String containing what the user is wearing on their chest
	 */
	public String getWearingChest(){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/wield/chest");
		if (open.checkFile()){
			return open.getLine();
		} else {
			return "none";
		}

	}

	/**
	 * Used to set what the user is wearing on their chest
	 * @param chest A string containing what the user is wearing on their chest
	 */
	public void setWearingChest(String chest){
		String fileLoc = database + "/charProfile/"+user+"/wield/chest";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(chest);
	}


	/**
	 * Used to obtain what the user is wearing on their feet
	 * @return A String containing what the user is wearing on their feet
	 */
	public String getWearingFeet(){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/wield/feet");
		if (open.checkFile()){
			return open.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the user is wearing on their feet
	 * @param feet A String containing what the user is wearing on their feet
	 */
	public void setWearingFeet(String feet){
		String fileLoc = database + "/charProfile/"+user+"/wield/feet";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(feet);
	}


	/**
	 * Used to obtain what the user is wearing on their head
	 * @return A String containing what the user is wearing on their head
	 */
	public String getWearingHead(){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/wield/head");
		if (open.checkFile()){
			return open.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the user is wearing on their head
	 * @param head A String containing what the user is wearing on their head
	 */
	public void setWearingHead(String head){
		String fileLoc = database + "/charProfile/"+user+"/wield/head";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(head);
	}


	/**
	 * Used to obtain what the user is wearing on their left-arm
	 * @return A String containing what the user is wearing on their left-arm
	 */
	public String getWearingLeftArm(){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/wield/left-arm");
		if (open.checkFile()){
			return open.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the user is wearing on their left-arm
	 * @param leftArm A String containing what the user is wearing on their left arm
	 */
	public void setWearingLeftArm(String leftArm){
		String fileLoc = database + "/charProfile/"+user+"/wield/left-arm";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(leftArm);
	}


	/**
	 * Used to obtain what the user is wearing on their hands
	 * @return A String containing what the user is wearing on their hands
	 */
	public String getWearingHands(){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/wield/hands");
		if (open.checkFile()){
			return open.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the user is wearing on their hands
	 * @param hands A String containing what the user is wearing on their hands
	 */
	public void setWearingHands(String hands){
		String fileLoc = database + "/charProfile/"+user+"/wield/hands";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(hands);
	}


	/**
	 * Used to obtain what the user is holding in their left-hand
	 * @return A String containing what the user is holding in their left-hand
	 */
	public String getLeftHand(){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/wield/left-hand");
		if (open.checkFile()){
			return open.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the user is holding in their left-hand
	 * @param leftHand A String containing what the user is holding in their left-hand
	 */
	public void setLeftHand(String leftHand){
		String fileLoc = database + "/charProfile/"+user+"/wield/left-hand";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(leftHand);
	}


	/**
	 * Used to obtain what the user is wearing on their legs (hopefully something)
	 * @return A String containing what the user is wearing on their legs.
	 */
	public String getWearingLegs(){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/wield/legs");
		if (open.checkFile()){
			return open.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the user is wearing on their legs
	 * @param legs A String containing what the user is wearing on their legs
	 */
	public void setWearingLegs(String legs){
		String fileLoc = database + "/charProfile/"+user+"/wield/legs";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(legs);
	}


	/**
	 * Used to obtain what a user is wearing around their neck
	 * @return A String containing what the user is wearing around their neck. (Hopefully not a noose)
	 */
	public String getWearingNeck(){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/wield/neck");
		if (open.checkFile()){
			return open.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the user is wearing on their neck
	 * @param neck A String containing what the user is wearing on their neck
	 */
	public void setWearingNeck(String neck){
		String fileLoc = database + "/charProfile/"+user+"/wield/neck";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(neck);
	}


	/**
	 * Used to obtain what a user is wearing on their right arm
	 * @return A String containing what the user is wearing on their right arm
	 */
	public String getWearingRightArm(){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/wield/right-arm");
		if (open.checkFile()){
			return open.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the user is wearing on their right-arm
	 * @param rightArm A String containing what the user is wearing on their right arm
	 */
	public void setWearingRightArm(String rightArm){
		String fileLoc = database + "/charProfile/"+user+"/wield/right-arm";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(rightArm);
	}

	/**
	 * Used to obtain what a user is holding in their right hand
	 * @return A String containing what the user is holding in their right hand
	 */
	public String getRightHand(){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/wield/right-hand");
		if (open.checkFile()){
			return open.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the user is holding in their right-hand
	 * @param rightHand A String containing what the user is wearing in their right-hand
	 */
	public void setRightHand(String rightHand){
		String fileLoc = database + "/charProfile/"+user+"/wield/right-hand";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(rightHand);
	}



	/**
	 * Used to what a user is wearing around their waist
	 * @return A String containing what the user is wearing around their waist
	 */
	public String getWearingWaist(){
		FileOperations open = new FileOperations(database + "/charProfile/"+user+"/wield/waist");
		if (open.checkFile()){
			return open.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the user is wearing around their waist
	 * @param waist A String containing what the user is wearing around their waist.
	 */
	public void setWearingWaist(String waist){
		String fileLoc = database + "/charProfile/"+user+"/wield/waist";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(waist);
	}

	/**
	 * Used to return the amount of knowledge that a user has
	 * @return An integer containing the amount of knowledge
	 */
	public int getKnowledge(){
		String fileLoc = database + "/charProfile/"+user+"/knowledge";
		FileOperations open = new FileOperations(fileLoc);
		String knowledge = open.getLine();
		return Integer.parseInt(knowledge);
	}

	/**
	 * Used to set the amount of knowledge that a user has
	 * @param knowledge An integer containing the amount of knowledge
	 */
	public void setKnowledge(int knowledge){
		String fileLoc = database + "/charProfile/"+user+"/knowledge";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(knowledge));
	}

	/**
	 * Returns a String array containing the skills that a user possesses.
	 * @return A String array containing the skills that a user possesses.
	 */
	public String[] getSkills(){
		FileOperations FO = new FileOperations(database + "/"+user+"/skills/");
		String[] files = FO.getDirectory();
		return files;
	}

	/**
	 * Used to give a user a new skill
	 * @param skillName A String containing the name of the skill
	 * @param skillLevel A String containing an integer value between 1 and 10 of the user's proficiency
	 */
	public void setNewSkill(String skillName, String skillLevel){
		String fileLoc = database + "/charProfile/"+user+"/skills/"+skillName;
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(skillLevel);
	}

	/**
	 * Used to delete a skill
	 * @param skill A String containing the skill to be deleted
	 */
	public void deleteSkill(String skill){
		FileOperations OP = new FileOperations(database + "/charProfile/"+user+"/skills/"+skill);
		OP.deleteFile();
	}

	/**
	 * Returns a String array containing the inventory of a user.
	 * @return A String array containing the inventory of a user.
	 */
	public String[] getInventory(){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/inventory/");
		String[] files = FO.getDirectory();
		return files;
	}

	/**
	 * Used to create a new inventory item
	 * This is also used to change the quantity of an item
	 * @param inv The name of the item
	 * @param quantity The quantity of the item
	 */
	public void setNewInv(String inv, int quantity){
		FileOperations FO = new FileOperations(database + "/charProfile/"+user+"/inventory/" + inv);
		FO.setLine(Integer.toString(quantity));
	}

	/**
	 * Returns the number of a certain item in a user's inventory
	 * @param inv The name of the item
	 * @return The number of instances of that item that the user is carrying.
	 */
	public int getInventoryItem(String inv){

		FileOperations fileOp;
		boolean exceptionCatcher = false;
		int numHolder = 0;

		try {
			fileOp = new FileOperations(database + "/charProfile/" + user + "/inventory/" + inv);
			numHolder = Integer.parseInt(fileOp.getLine());
		} catch (Exception e) {
			exceptionCatcher = true;
		}
		if (exceptionCatcher == false){
			return numHolder;
		} else {
			return 0;
		}
	}

	/**
	 * Used to delete an inventory item
	 * @param inv A String containing the inventory item to delete
	 */
	public void deleteInv(String inv){
		FileOperations OP = new FileOperations(database + "/charProfile/"+user+"/inventory/"+inv);
		OP.deleteFile();
	}
}
