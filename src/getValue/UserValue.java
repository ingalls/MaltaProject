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
		String fileLoc = database + "/charProfile/"+user+"/age";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(age));
	}

	/**
	 * Used to obtain the class of a user.
	 * @return A String containing the class of a user
	 */
	public String getUserClass(){
		String fileLoc = database + "/charProfile/"+user+"/class";
		FileOperations open = new FileOperations(fileLoc);
		String userClass = open.getLine();
		return userClass;
	}

	/**
	 * Sets the class of a user
	 * @param userClass A String containing the class of a user
	 */
	public void setUserClass(String userClass){
		String fileLoc = database + "/charProfile/"+user+"/class";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(userClass);
	}
	/**
	 * Used to obtain the dexterity of a user.
	 * @return An integer containing the dexterity of a user
	 */
	public int getDex(){
		String fileLoc = database + "/charProfile/"+user+"/dexterity";
		FileOperations open = new FileOperations(fileLoc);
		String userDex = open.getLine();
		return Integer.parseInt(userDex);
	}

	/**
	 * Sets the Dex of a user
	 * @param dex An integer containing the dex of a user
	 */
	public void setDex(int dex){
		String fileLoc = database + "/charProfile/"+user+"/dexterity";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(dex));
	}

	/**
	 * used to obtain the experience of a user.
	 * @return An integer containing the experience of a user
	 */
	public int getXP(){
		String fileLoc = database + "/charProfile/"+user+"/experience";
		FileOperations open = new FileOperations(fileLoc);
		String userXP = open.getLine();
		return Integer.parseInt(userXP);
	}

	/**
	 * Used to set the experience of a user
	 * @param age An integer containing the experience
	 */
	public void setXP(int XP){
		String fileLoc = database + "/charProfile/"+user+"/experience";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(XP));
	}

	/**
	 * used to return the amount of gold that a user has.
	 * @return An integer containing the amount of gold
	 */
	public int getGold(){
		String fileLoc = database + "/charProfile/"+user+"/gold";
		FileOperations open = new FileOperations(fileLoc);
		String userGold = open.getLine();
		return Integer.parseInt(userGold);
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
	public int getInt(){
		String fileLoc = database + "/charProfile/"+user+"/intelligence";
		FileOperations open = new FileOperations(fileLoc);
		String userInt = open.getLine();
		return Integer.parseInt(userInt);
	}

	/**
	 * Used to set the amount of intelligence a user has
	 * @param Int An integer containing the amount of intelligence
	 */
	public void setInt(int Int){
		String fileLoc = database + "/charProfile/"+user+"/intelligence";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(Int));
	}

	/**
	 * Used to obtain the level of a user.
	 * @return An integer containing the level of a user
	 */
	public int getLvl(){
		String fileLoc = database + "/charProfile/"+user+"/level";
		FileOperations open = new FileOperations(fileLoc);
		String userLvl = open.getLine();
		return Integer.parseInt(userLvl);
	}

	/**
	 * Used to set the user's level
	 * @param level An integer containing the level to set
	 */
	public void setLvl(int level){
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
	 * Used to obtain the religion of a user.
	 * @return A String containing the age of a user
	 */
	public String getReligion(){
		String fileLoc = database + "/charProfile/"+user+"/religion";
		FileOperations open = new FileOperations(fileLoc);
		String userReligion = open.getLine();
		return userReligion;
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
	public int getStr(){
		String fileLoc = database + "/charProfile/"+user+"/strength";
		FileOperations open = new FileOperations(fileLoc);
		String userStr = open.getLine();
		return Integer.parseInt(userStr);
	}

	/**
	 * Used to set the strength of a user
	 * @param str An integer containing the strength to set
	 */
	public void setStr(int str){
		String fileLoc = database + "/charProfile/"+user+"/strength";
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
		String fileLoc = database + "/charProfile/"+user+"/maxhealth";
		FileOperations open = new FileOperations(fileLoc);
		String maxHealth = open.getLine();
		return Integer.parseInt(maxHealth);
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
	public int getWis(){
		String fileLoc = database + "/charProfile/"+user+"/wisdom";
		FileOperations open = new FileOperations(fileLoc);
		String userWis = open.getLine();
		return Integer.parseInt(userWis);
	}

	/**
	 * Used to set the wisdom of a user
	 * @param wis An integer containing the wisdom to set
	 */
	public void setWis(int wis){
		String fileLoc = database + "/charProfile/"+user+"/wisdom";
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
		String fileLoc = database + "/charProfile/"+user+"/guild";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(guild);
	}


	/**
	 * Used to obtain what the user is wearing on their chest
	 * @return A String containing what the user is wearing on their chest
	 */
	public String getWearingChest(){
		String fileLoc = database + "/charProfile/"+user+"/wield/chest";
		FileOperations open = new FileOperations(fileLoc);
		String chest = open.getLine();
		return chest;
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
		String fileLoc = database + "/charProfile/"+user+"/wield/feet";
		FileOperations open = new FileOperations(fileLoc);
		String feet = open.getLine();
		return feet;
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
		String fileLoc = database + "/charProfile/"+user+"/wield/head";
		FileOperations open = new FileOperations(fileLoc);
		String head = open.getLine();
		return head;
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
		String fileLoc = database + "/charProfile/"+user+"/wield/left-arm";
		FileOperations open = new FileOperations(fileLoc);
		String leftArm = open.getLine();
		return leftArm;
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
		String fileLoc = database + "/charProfile/"+user+"/wield/hands";
		FileOperations open = new FileOperations(fileLoc);
		String hands = open.getLine();
		return hands;
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
		String fileLoc = database + "/charProfile/"+user+"/wield/left-hand";
		FileOperations open = new FileOperations(fileLoc);
		String leftHand = open.getLine();
		return leftHand;
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
		String fileLoc = database + "/charProfile/"+user+"/wield/legs";
		FileOperations open = new FileOperations(fileLoc);
		String legs = open.getLine();
		return legs;
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
		String fileLoc = database + "/charProfile/"+user+"/wield/neck";
		FileOperations open = new FileOperations(fileLoc);
		String neck = open.getLine();
		return neck;
	}

	/**
	 * Used to set what the user is wearing on their neck
	 * @param feet A String containing what the user is wearing on their neck
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
		String fileLoc = database + "/charProfile/"+user+"/wield/right-arm";
		FileOperations open = new FileOperations(fileLoc);
		String rightArm = open.getLine();
		return rightArm;
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
		String fileLoc = database + "/charProfile/"+user+"/wield/right-hand";
		FileOperations open = new FileOperations(fileLoc);
		String rightHand = open.getLine();
		return rightHand;
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
		String fileLoc = database + "/charProfile/"+user+"/wield/waist";
		FileOperations open = new FileOperations(fileLoc);
		String waist = open.getLine();
		return waist;
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
	 * @param waist An integer containing the amount of knowledge
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
		FileOperations FO = new FileOperations(database);
		String[] files = FO.getDirectory("/"+user+"/skills/");
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
		FileOperations OP = new FileOperations(database);
		OP.deleteFile("/charProfile/"+user+"/skills/"+skill);
	}

	/**
	 * Returns a String array containing the inventory of a user.
	 * @return A String array containing the inventory of a user.
	 */
	public String[] getInventory(){
		FileOperations FO = new FileOperations(database);
		String[] files = FO.getDirectory("/charProfile/"+user+"/inventory/");
		return files;
	}

	/**
	 * Used to create a new inventory item
	 * This is also used to change the quantity of an item
	 * @param inv The name of the item
	 * @param quantity The quantity of the item
	 */
	public void setNewInv(String inv, int quantity){
		String fileLoc = database + "/charProfile/"+user+"/inventory/" + inv;
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(Integer.toString(quantity));
	}

	/**
	 * Returns the number of a certain item in a user's inventory
	 * @param inv The name of the item
	 * @return The number of instances of that item that the user is carrying.
	 */
	public int getInventoryItem(String inv){
		String fileLoc = database + "/charProfile/" + user + "/inventory/" + inv;
		FileOperations fileOp = new FileOperations(fileLoc);
		return Integer.parseInt(fileOp.getLine());
	}

	/**
	 * Used to delete an inventory item
	 * @param inv A String containing the inventory item to delete
	 */
	public void deleteInv(String inv){
		FileOperations OP = new FileOperations(database);
		OP.deleteFile("/charProfile/"+user+"/inventory/"+inv);
	}

}
