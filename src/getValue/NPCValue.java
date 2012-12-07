package getValue;

import maltaProject.FileOperations;

/**
 * This class is used to obtain stats about an NPC. Given the NPC's
 * name and the location of the server database, a string with the specific
 * stat will be returned.
 *
 * @author  Nicholas Ingalls
 */

public class NPCValue {
	/**Stores database location - initialized by constructor*/
	String database = "";
	/**Stores the name of the NPC - initialized by constructor*/
	String npc = "";

	/**
	 * Constructs a new object with a string containing the database location and a string containing the username.
	 */
	public NPCValue(String data, String npcName){
		database = data;
		npc = npcName;
	}

	/**
	 * Used to obtain the desc used to describe an NPC in a room
	 * eg A GateKeeper Stands here
	 * 
	 * @return A String containing the desc
	 */
	public String getDesc(){
		String fileLoc = database + "/npc/"+npc+"/desc";
		FileOperations open = new FileOperations(fileLoc);
		String desc = open.getLine();
		return desc;
	}

	/**
	 * Sets desc of an NPC
	 * 
	 * @param age A String containing the desc
	 */
	public void setDesc(String desc){
		String fileLoc = database + "/npc/"+npc+"/desc";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(desc);
	}

	/**
	 * Used to obtain the minimum age that an NPC can be
	 * 
	 * @return A String containing the minimum age
	 */
	public String getMinAge(){
		String fileLoc = database + "/npc/"+npc+"/minAge";
		FileOperations open = new FileOperations(fileLoc);
		String minAge = open.getLine();
		return minAge;
	}

	/**
	 * Sets the minimum age that an NPC can be
	 * 
	 * @param age A String containing the minimum age
	 */
	public void setMinAge(String minAge){
		String fileLoc = database + "/npc/"+npc+"/minAge";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(minAge);
	}

	/**
	 * Used to obtain the max age that an NPC can be
	 * 
	 * @return A String containing max age
	 */
	public String getMaxAge(){
		String fileLoc = database + "/npc/"+npc+"/maxAge";
		FileOperations open = new FileOperations(fileLoc);
		String maxAge = open.getLine();
		return maxAge;
	}

	/**
	 * Sets the max age that an NPC can be
	 * 
	 * @param age A String containing the max age
	 */
	public void setMaxAge(String maxAge){
		String fileLoc = database + "/npc/"+npc+"/maxAge";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(maxAge);
	}

	/**
	 * Used to obtain the class of an NPC
	 * 
	 * @return A String containing the class
	 */
	public String getNPCClass(){
		String fileLoc = database + "/npc/"+npc+"/class";
		FileOperations open = new FileOperations(fileLoc);
		String NPCclass = open.getLine();
		return NPCclass;
	}

	/**
	 * Sets the class of an NPC
	 * 
	 * @param age A String containing the class
	 */
	public void setNPCClass(String NPCclass){
		String fileLoc = database + "/npc/"+npc+"/class";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(NPCclass);
	}

	/**
	 * Used to obtain the NPCs current level
	 * 
	 * @return A String containing the level
	 */
	public String getLevel(){
		String fileLoc = database + "/npc/"+npc+"/level";
		FileOperations open = new FileOperations(fileLoc);
		String level = open.getLine();
		return level;
	}

	/**
	 * Sets the level of an NPC
	 * 
	 * @param age A String containing the level
	 */
	public void setLevel(String level){
		String fileLoc = database + "/npc/"+npc+"/level";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(level);
	}

	/**
	 * Used to obtain the NPC's race
	 * 
	 * @return A String containing the race
	 */
	public String getRace(){
		String fileLoc = database + "/npc/"+npc+"/race";
		FileOperations open = new FileOperations(fileLoc);
		String race = open.getLine();
		return race;
	}

	/**
	 * Sets the race of an NPC
	 * 
	 * @param age A String containing the race
	 */
	public void setRace(String race){
		String fileLoc = database + "/npc/"+npc+"/race";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(race);
	}

	/**
	 * Used to obtain the NPC's max Dexterity
	 * 
	 * @return A String containing the max dexterity
	 */
	public String getMaxDexterity(){
		String fileLoc = database + "/npc/"+npc+"/maxDexterity";
		FileOperations open = new FileOperations(fileLoc);
		String dex = open.getLine();
		return dex;
	}

	/**
	 * Sets the dexterity of an NPC
	 * 
	 * @param age A String containing the max dexterity
	 */
	public void setMaxDexterity(String dex){
		String fileLoc = database + "/npc/"+npc+"/maxDexterity";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(dex);
	}

	/**
	 * Used to obtain the NPC's min dexterity
	 * 
	 * @return A String containing the min dexterity
	 */
	public String getMinDexterity(){
		String fileLoc = database + "/npc/"+npc+"/minDexterity";
		FileOperations open = new FileOperations(fileLoc);
		String dex = open.getLine();
		return dex;
	}

	/**
	 * Sets the min dexterity of an NPC
	 * 
	 * @param age A String containing the min dexterity
	 */
	public void setMinDexterity(String dex){
		String fileLoc = database + "/npc/"+npc+"/minDexterity";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(dex);
	}

	/**
	 * Used to obtain the NPC's religion
	 * 
	 * @return A String containing the religion
	 */
	public String getReligion(){
		String fileLoc = database + "/npc/"+npc+"/religion";
		FileOperations open = new FileOperations(fileLoc);
		String religion = open.getLine();
		return religion;
	}

	/**
	 * Sets the religion of an NPC
	 * 
	 * @param age A String containing the religion
	 */
	public void setReligion(String religion){
		String fileLoc = database + "/npc/"+npc+"/religion";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(religion);
	}

	/**
	 * Used to obtain the NPC's experience
	 * 
	 * @return A String containing the experience
	 */
	public String getXP(){
		String fileLoc = database + "/npc/"+npc+"/experience";
		FileOperations open = new FileOperations(fileLoc);
		String xp = open.getLine();
		return xp;
	}

	/**
	 * Sets the experience of an NPC
	 * 
	 * @param age A String containing the experience
	 */
	public void setXP(String xp){
		String fileLoc = database + "/npc/"+npc+"/experience";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(xp);
	}

	/**
	 * Used to obtain the NPC's min health
	 * 
	 * @return A String containing the min health
	 */
	public String getMinHealth(){
		String fileLoc = database + "/npc/"+npc+"/minHealth";
		FileOperations open = new FileOperations(fileLoc);
		String health = open.getLine();
		return health;
	}

	/**
	 * Sets the min health of an NPC
	 * 
	 * @param age A String containing the min health
	 */
	public void setMinHealth(String health){
		String fileLoc = database + "/npc/"+npc+"/minHealth";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(health);
	}

	/**
	 * Used to obtain the NPC's max health
	 * 
	 * @return A String containing the max health
	 */
	public String getMaxHealth(){
		String fileLoc = database + "/npc/"+npc+"/maxHealth";
		FileOperations open = new FileOperations(fileLoc);
		String health = open.getLine();
		return health;
	}

	/**
	 * Sets the max health of an NPC
	 * 
	 * @param age A String containing the max health
	 */
	public void setMaxHealth(String health){
		String fileLoc = database + "/npc/"+npc+"/maxHealth";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(health);
	}

	/**
	 * Used to obtain the NPC's max intelligence
	 * 
	 * @return A String containing the max intelligence
	 */
	public String getMaxIntelligence(){
		String fileLoc = database + "/npc/"+npc+"/maxIntelligence";
		FileOperations open = new FileOperations(fileLoc);
		String intel = open.getLine();
		return intel;
	}

	/**
	 * Sets the max intelligence of an NPC
	 * 
	 * @param age A String containing the max intelligence
	 */
	public void setMaxIntelligence(String intel){
		String fileLoc = database + "/npc/"+npc+"/maxIntelligence";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(intel);
	}

	/**
	 * Used to obtain the NPC's max intelligence
	 * 
	 * @return A String containing the max intelligence
	 */
	public String getMinIntelligence(){
		String fileLoc = database + "/npc/"+npc+"/maxIntelligence";
		FileOperations open = new FileOperations(fileLoc);
		String intel = open.getLine();
		return intel;
	}

	/**
	 * Sets the max intelligence of an NPC
	 * 
	 * @param age A String containing the max intelligence
	 */
	public void setMinIntelligence(String intel){
		String fileLoc = database + "/npc/"+npc+"/maxIntelligence";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(intel);
	}

	/**
	 * Used to obtain the NPC's max strength
	 * 
	 * @return A String containing the max strength
	 */
	public String getMaxStrength(){
		String fileLoc = database + "/npc/"+npc+"/maxStrength";
		FileOperations open = new FileOperations(fileLoc);
		String str = open.getLine();
		return str;
	}

	/**
	 * Sets the max strength of an NPC
	 * 
	 * @param age A String containing the max strength
	 */
	public void setMaxStrength(String str){
		String fileLoc = database + "/npc/"+npc+"/maxStrength";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(str);
	}

	/**
	 * Used to obtain the NPC's min strength
	 * 
	 * @return A String containing the min strenth
	 */
	public String getMinStrength(){
		String fileLoc = database + "/npc/"+npc+"/minStrength";
		FileOperations open = new FileOperations(fileLoc);
		String str = open.getLine();
		return str;
	}

	/**
	 * Sets the min strength of an NPC
	 * 
	 * @param age A String containing the min strength
	 */
	public void setMinStrength(String str){
		String fileLoc = database + "/npc/"+npc+"/minStrength";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(str);
	}

	/**
	 * Used to obtain the NPC's min Gold
	 * 
	 * @return A String containing the min Gold
	 */
	public String getMinGold(){
		String fileLoc = database + "/npc/"+npc+"/minGold";
		FileOperations open = new FileOperations(fileLoc);
		String gold = open.getLine();
		return gold;
	}

	/**
	 * Sets the min gold of an NPC
	 * 
	 * @param age A String containing the min gold
	 */
	public void setMinGold(String gold){
		String fileLoc = database + "/npc/"+npc+"/minGold";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(gold);
	}

	/**
	 * Used to obtain the NPC's max gold
	 * 
	 * @return A String containing the max gold
	 */
	public String getMaxGold(){
		String fileLoc = database + "/npc/"+npc+"/maxGold";
		FileOperations open = new FileOperations(fileLoc);
		String gold = open.getLine();
		return gold;
	}

	/**
	 * Sets the max gold of an NPC
	 * 
	 * @param age A String containing the max gold
	 */
	public void setMaxGold(String gold){
		String fileLoc = database + "/npc/"+npc+"/maxGold";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(gold);
	}

	/**
	 * Used to obtain the NPC's min weight
	 * 
	 * @return A String containing the min weight
	 */
	public String getMinWeight(){
		String fileLoc = database + "/npc/"+npc+"/minWeight";
		FileOperations open = new FileOperations(fileLoc);
		String weight = open.getLine();
		return weight;
	}

	/**
	 * Sets the min weight of an NPC
	 * 
	 * @param age A String containing the min weight
	 */
	public void setMinWeight(String weight){
		String fileLoc = database + "/npc/"+npc+"/minWeight";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(weight);
	}

	/**
	 * Used to obtain the NPC's max weight
	 * 
	 * @return A String containing the max weight
	 */
	public String getMaxWeight(){
		String fileLoc = database + "/npc/"+npc+"/maxWeight";
		FileOperations open = new FileOperations(fileLoc);
		String weight = open.getLine();
		return weight;
	}

	/**
	 * Sets the max weight of an NPC
	 * 
	 * @param age A String containing the max weight
	 */
	public void setMaxWeight(String weight){
		String fileLoc = database + "/npc/"+npc+"/maxWeight";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(weight);
	}

	/**
	 * Used to obtain the NPC's min wisdom
	 * 
	 * @return A String containing the min wisdom
	 */
	public String getMinWisom(){
		String fileLoc = database + "/npc/"+npc+"/minWisdom";
		FileOperations open = new FileOperations(fileLoc);
		String wis = open.getLine();
		return wis;
	}

	/**
	 * Sets the min wisdom of an NPC
	 * 
	 * @param age A String containing the min wisdom
	 */
	public void setMinWisdom(String wis){
		String fileLoc = database + "/npc/"+npc+"/minWisdom";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(wis);
	}

	/**
	 * Used to obtain the NPC's max wisdom
	 * 
	 * @return A String containing the max wisdom
	 */
	public String getMaxWisdom(){
		String fileLoc = database + "/npc/"+npc+"/maxWisdom";
		FileOperations open = new FileOperations(fileLoc);
		String wis = open.getLine();
		return wis;
	}

	/**
	 * Sets the max wisdom of an NPC
	 * 
	 * @param age A String containing the max wisdom
	 */
	public void setMaxWisdom(String wis){
		String fileLoc = database + "/npc/"+npc+"/maxWisdom";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(wis);
	}

	/**
	 * Used to obtain whether or not the NPC drops special items
	 * These special items are contained in the ~root~/drop/ folder
	 * 
	 * @return A String containing "true" or "false"
	 */
	public String getDrop(){
		String fileLoc = database + "/npc/"+npc+"/drop";
		FileOperations open = new FileOperations(fileLoc);
		String drop = open.getLine();
		return drop;
	}

	/**
	 * Sets whether or not the NPC drops items
	 * 
	 * @param age A String containing "true" or "false"
	 */
	public void setDrop(String drop){
		String fileLoc = database + "/npc/"+npc+"/drop";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(drop);
	}

	/**
	 * Returns a String array containing the inventory of the NPC.
	 * 
	 * @return A String array containing the inventory of the NPC.
	 */
	public String[] getInventory(){
		FileOperations FO = new FileOperations(database);
		String[] files = FO.getDirectory("/npc/"+npc+"/inventory");
		return files;
	}

	/**
	 * Used to create a new inventory item
	 * This is also used to change the quantity of an item
	 * 
	 * @param inv The name of the item
	 * @param quantity The quantity of the item
	 */
	public void setNewInv(String inv, String quantity){
		String fileLoc = database + "/npc/"+npc+"/inventory/" + inv;
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(quantity);
	}

	/**
	 * Used to delete an inventory item
	 * 
	 * @param inv A String containing the inventory item to delete
	 */
	public void deleteInv(String inv){
		FileOperations OP = new FileOperations(database);
		OP.deleteFile("/npc/"+npc+"/inventory/"+inv);
	}

	/**
	 * Returns a String array containing the skills that an npc possesses.
	 * 
	 * @return A String array containing the skills that an npc possesses.
	 */
	public String[] getSkills(){
		FileOperations FO = new FileOperations(database);
		String[] files = FO.getDirectory("/npc/"+npc+"/skills/");
		return files;
	}

	/**
	 * Used to give an npc a new skill
	 * 
	 * @param skillName A String containing the name of the skill
	 * @param skillLevel A String containing an integer value between 1 and 10 of the npc's proficiency
	 */
	public void setNewSkill(String skillName, String skillLevel){
		String fileLoc = database + "/npc/"+npc+"/skills/"+skillName;
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(skillLevel);
	}

	/**
	 * Used to delete a skill
	 * 
	 * @param skill A String containing the skill to be deleted
	 */
	public void deleteSkill(String skill){
		FileOperations OP = new FileOperations(database);
		OP.deleteFile("/npc/"+npc+"/skills/"+skill);
	}

	/**
	 * Used to obtain what the npc is wearing on their chest
	 * 
	 * @return A String containing what the npc is wearing on their chest
	 */
	public String getWearingChest(){
		String fileLoc = database + "/npc/"+npc+"/wield/chest";
		FileOperations open = new FileOperations(fileLoc);
		String chest = open.getLine();
		return chest;
	}

	/**
	 * Used to set what the npc is wearing on their chest
	 * 
	 * @param chest A string containing what the npc is wearing on their chest
	 */
	public void setWearingChest(String chest){
		String fileLoc = database + "/npc/"+npc+"/wield/chest";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(chest);
	}


	/**
	 * Used to obtain what the npc is wearing on their feet
	 * 
	 * @return A String containing what the npc is wearing on their feet
	 */
	public String getWearingFeet(){
		String fileLoc = database + "/npc/"+npc+"/wield/feet";
		FileOperations open = new FileOperations(fileLoc);
		String feet = open.getLine();
		return feet;
	}

	/**
	 * Used to set what the npc is wearing on their feet
	 * 
	 * @param feet A String containing what the npc is wearing on their feet
	 */
	public void setWearingFeet(String feet){
		String fileLoc = database + "/npc/"+npc+"/wield/feet";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(feet);
	}


	/**
	 * Used to obtain what the npc is wearing on their head
	 * 
	 * @return A String containing what the npc is wearing on their head
	 */
	public String getWearingHead(){
		String fileLoc = database + "/npc/"+npc+"/wield/head";
		FileOperations open = new FileOperations(fileLoc);
		String head = open.getLine();
		return head;
	}

	/**
	 * Used to set what the npc is wearing on their head
	 * 
	 * @param head A String containing what the npc is wearing on their head
	 */
	public void setWearingHead(String head){
		String fileLoc = database + "/npc/"+npc+"/wield/head";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(head);
	}


	/**
	 * Used to obtain what the npc is wearing on their left-arm
	 * 
	 * @return A String containing what the npc is wearing on their left-arm
	 */
	public String getWearingLeftArm(){
		String fileLoc = database + "/npc/"+npc+"/wield/left-arm";
		FileOperations open = new FileOperations(fileLoc);
		String leftArm = open.getLine();
		return leftArm;
	}

	/**
	 * Used to set what the npc is wearing on their left-arm
	 * 
	 * @param leftArm A String containing what the npc is wearing on their left arm
	 */
	public void setWearingLeftArm(String leftArm){
		String fileLoc = database + "/npc/"+npc+"/wield/left-arm";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(leftArm);
	}


	/**
	 * Used to obtain what the npc is wearing on their hands
	 * 
	 * @return A String containing what the npc is wearing on their hands
	 */
	public String getWearingHands(){
		String fileLoc = database + "/npc/"+npc+"/wield/hands";
		FileOperations open = new FileOperations(fileLoc);
		String hands = open.getLine();
		return hands;
	}

	/**
	 * Used to set what the npc is wearing on their hands
	 * 
	 * @param hands A String containing what the npc is wearing on their hands
	 */
	public void setWearingHands(String hands){
		String fileLoc = database + "/npc/"+npc+"/wield/hands";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(hands);
	}


	/**
	 * Used to obtain what the npc is holding in their left-hand
	 * 
	 * @return A String containing what the npc is holding in their left-hand
	 */
	public String getLeftHand(){
		String fileLoc = database + "/npc/"+npc+"/wield/left-hand";
		FileOperations open = new FileOperations(fileLoc);
		String leftHand = open.getLine();
		return leftHand;
	}

	/**
	 * Used to set what the npc is holding in their left-hand
	 * 
	 * @param leftHand A String containing what the npc is holding in their left-hand
	 */
	public void setLeftHand(String leftHand){
		String fileLoc = database + "/npc/"+npc+"/wield/left-hand";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(leftHand);
	}


	/**
	 * Used to obtain what the npc is wearing on their legs (hopefully something)
	 * 
	 * @return A String containing what the npc is wearing on their legs.
	 */
	public String getWearingLegs(){
		String fileLoc = database + "/npc/"+npc+"/wield/legs";
		FileOperations open = new FileOperations(fileLoc);
		String legs = open.getLine();
		return legs;
	}

	/**
	 * Used to set what the npc is wearing on their legs
	 * 
	 * @param legs A String containing what the npc is wearing on their legs
	 */
	public void setWearingLegs(String legs){
		String fileLoc = database + "/npc/"+npc+"/wield/legs";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(legs);
	}


	/**
	 * Used to obtain what a npc is wearing around their neck
	 * 
	 * @return A String containing what the npc is wearing around their neck. (Hopefully not a noose)
	 */
	public String getWearingNeck(){
		String fileLoc = database + "/npc/"+npc+"/wield/neck";
		FileOperations open = new FileOperations(fileLoc);
		String neck = open.getLine();
		return neck;
	}

	/**
	 * Used to set what the npc is wearing on their neck
	 * 
	 * @param feet A String containing what the npc is wearing on their neck
	 */
	public void setWearingNeck(String neck){
		String fileLoc = database + "/npc/"+npc+"/wield/neck";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(neck);
	}


	/**
	 * Used to obtain what a npc is wearing on their right arm
	 * 
	 * @return A String containing what the npc is wearing on their right arm
	 */
	public String getWearingRightArm(){
		String fileLoc = database + "/npc/"+npc+"/wield/right-arm";
		FileOperations open = new FileOperations(fileLoc);
		String rightArm = open.getLine();
		return rightArm;
	}

	/**
	 * Used to set what the npc is wearing on their right-arm
	 * 
	 * @param rightArm A String containing what the npc is wearing on their right arm
	 */
	public void setWearingRightArm(String rightArm){
		String fileLoc = database + "/npc/"+npc+"/wield/right-arm";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(rightArm);
	}

	/**
	 * Used to obtain what a npc is holding in their right hand
	 * 
	 * @return A String containing what the npc is holding in their right hand
	 */
	public String getRightHand(){
		String fileLoc = database + "/npc/"+npc+"/wield/right-hand";
		FileOperations open = new FileOperations(fileLoc);
		String rightHand = open.getLine();
		return rightHand;
	}

	/**
	 * Used to set what the npc is holding in their right-hand
	 * 
	 * @param rightHand A String containing what the npc is wearing in their right-hand
	 */
	public void setRightHand(String rightHand){
		String fileLoc = database + "/npc/"+npc+"/wield/right-hand";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(rightHand);
	}



	/**
	 * Used to what a npc is wearing around their waist
	 * 
	 * @return A String containing what the npc is wearing around their waist
	 */
	public String getWearingWaist(){
		String fileLoc = database + "/npc/"+npc+"/wield/waist";
		FileOperations open = new FileOperations(fileLoc);
		String waist = open.getLine();
		return waist;
	}

	/**
	 * Used to set what the npc is wearing around their waist
	 * 
	 * @param waist A String containing what the npc is wearing around their waist.
	 */
	public void setWearingWaist(String waist){
		String fileLoc = database + "/npc/"+npc+"/wield/waist";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(waist);
	}


}
