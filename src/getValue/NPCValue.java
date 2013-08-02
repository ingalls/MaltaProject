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
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/desc");
		return FO.getLine();
	}

	/**
	 * Sets desc of an NPC
	 * 
	 * @param desc A String containing the desc
	 */
	public void setDesc(String desc){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/desc");
		FO.setLine(desc);
	}

	/**
	 * Returns the sex
	 * 
	 * @return A String containing the sex (male/female)
	 */
	public String getSex(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/sex");
		return FO.getLine();
	}

	/**
	 * Sets the sex of the NPC
	 * 
	 * @param sex A String containing the sex (male/female)
	 */
	public void setSex(String sex){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/sex");
		FO.setLine(sex);
	}

	public boolean isWimpy(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isWimpy");
		return FO.checkFile();
	}

	public void setWimpy(boolean wimpy){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isWimpy");
		if (wimpy == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isAggressive(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isAggressive");
		return FO.checkFile();
	}

	public void setAggressive(boolean aggressive){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isAggressive");
		if (aggressive == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isRaceAligned(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isRaceAligned");
		return FO.checkFile();
	}

	public void setRaceAligned(boolean raceAlignment){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isRaceAligned");
		if (raceAlignment == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isClanAligned(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isClanAligned");
		return FO.checkFile();
	}

	public void setClanAligned(boolean clanAligned){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isClanAligned");
		if (clanAligned == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isReligionAligned(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isReligionAligned");
		return FO.checkFile();
	}

	public void setReligionAligned(boolean religionAligned){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isReligionAligned");
		if (religionAligned == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isGuard(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isGuard");
		return FO.checkFile();
	}

	public void setGuard(boolean guard){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isGuard");
		if (guard == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isHealer(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isHealer");
		return FO.checkFile();
	}

	public void setHealer(boolean aggressive){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isHealer");
		if (aggressive == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isTeacher(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isTeacher");
		return FO.checkFile();
	}

	public void setTeacher(boolean teacher){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isTeacher");
		if (teacher == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isStoreKeeper(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isStoreKeeper");
		return FO.checkFile();
	}

	public void setStoreKeeper(boolean storeKeeper){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isStoreKeeper");
		if (storeKeeper == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isCollector(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isCollector");
		return FO.checkFile();
	}

	public void setCollector(boolean collector){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isCollector");
		if (collector == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isScavenger(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isScavenger");
		return FO.checkFile();
	}

	public void setScavenger(boolean scavenger){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isScavenger");
		if (scavenger == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isMoneyChanger(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isMoneyChanger");
		return FO.checkFile();
	}

	public void setMoneyChanger(boolean moneyChanger){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isMoneyChanger");
		if (moneyChanger == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isRidable(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isRideable");
		return FO.checkFile();
	}

	public void setRideable(boolean rideable){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isRideable");
		if (rideable == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isThief(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isThief");
		return FO.checkFile();
	}

	public void setThief(boolean thief){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isThief");
		if (thief == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isMender(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isMender");
		return FO.checkFile();
	}

	public void setMender(boolean mender){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isMender");
		if (mender == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isTailor(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isTailor");
		return FO.checkFile();
	}

	public void setTailor(boolean tailor){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isTailor");
		if (tailor == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	public boolean isSwimmer(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isSwimmer");
		return FO.checkFile();
	}

	public void setSwimmer(boolean swimmer){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isSwimmer");
		if (swimmer == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	/**
	 * Returns whether the NPC can be milked
	 * 
	 * @return A boolean containing the whether the NPC is milkable
	 */
	public boolean isMilkable(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isMilkable");
		return FO.checkFile();
	}

	/**
	 * Sets whether the NPC can be milked
	 * @param milkable A boolean of the NPC's milkability
	 */
	public void setMilkable(boolean milkable){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isMilkable");
		if (milkable == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	/**
	 * Returns whether the NPC is neutral
	 * 
	 * @return A boolean containing the whether the NPC is neutral
	 */
	public boolean isNeutral(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isNeutral");
		return FO.checkFile();
	}

	/**
	 * Sets whether the NPC is neutral
	 * @param neutral A boolean of the NPC's neutrality
	 */
	public void setNeutral(boolean neutral){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/type/isNeutral");
		if (neutral == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	/**
	 * Used to obtain the minimum age that an NPC can be
	 * 
	 * @return An int containing the minimum age
	 */
	public int getMinAge(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/minAge");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the minimum age that an NPC can be
	 * 
	 * @param minAge An int containing the minimum age
	 */
	public void setMinAge(int minAge){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/minAge");
		FO.setLine(minAge + "");
	}

	/**
	 * Used to obtain the max age that an NPC can be
	 * 
	 * @return An int containing max age
	 */
	public int getMaxAge(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/maxAge");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the max age that an NPC can be
	 * 
	 * @param maxAge An int containing the max age
	 */
	public void setMaxAge(int maxAge){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/maxAge");
		FO.setLine(maxAge + "");
	}

	/**
	 * Used to obtain the subclass of an NPC
	 * 
	 * @return A String containing the subclass
	 */
	public String getNpcSubClass(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/subClass");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}

	}

	/**
	 * Sets the subclass of an NPC
	 * 
	 * @param NPCclass A String containing the subclass
	 */
	public void setNpcSubClass(String NPCclass){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/subClass");
		FO.setLine(NPCclass);
	}

	/**
	 * Used to obtain the class of an NPC
	 * 
	 * @return A String containing the class
	 */
	public String getNpcClass(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/class");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}

	}

	/**
	 * Sets the class of an NPC
	 * 
	 * @param NPCclass A String containing the class
	 */
	public void setNpcClass(String NPCclass){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/class");
		FO.setLine(NPCclass);
	}

	/**
	 * Used to obtain the NPCs current level
	 * 
	 * @return An int containing the level
	 */
	public int getLevel(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/level");
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
	 * Sets the level of an NPC
	 * 
	 * @param level An int containing the level
	 */
	public void setLevel(int level){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/level");
		FO.setLine(level + "");
	}

	/**
	 * Used to obtain the NPC's race
	 * 
	 * @return A String containing the race
	 */
	public String getRace(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/race");
		return FO.getLine();
	}

	/**
	 * Sets the race of an NPC
	 * 
	 * @param race A String containing the race
	 */
	public void setRace(String race){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/race");
		FO.setLine(race);
	}

	/**
	 * Used to obtain the NPC's max Dexterity
	 * 
	 * @return An int containing the max dexterity
	 */
	public int getMaxDexterity(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/maxDexterity");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the dexterity of an NPC
	 * 
	 * @param dex An int containing the max dexterity
	 */
	public void setMaxDexterity(int dex){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/maxDexterity");
		FO.setLine(dex + "");
	}

	/**
	 * Used to obtain the NPC's min dexterity
	 * 
	 * @return An int containing the min dexterity
	 */
	public int getMinDexterity(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/minDexterity");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the min dexterity of an NPC
	 * 
	 * @param dex An int containing the min dexterity
	 */
	public void setMinDexterity(int dex){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/minDexterity");
		FO.setLine(dex + "");
	}

	/**
	 * Used to obtain the NPC's religion level
	 * 
	 * @return A String containing the religion level
	 */
	public String getReligionLvl(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/religionLvl");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}

	}

	/**
	 * Sets the religion level of an NPC
	 * 
	 * @param religion A String containing the religion level
	 */
	public void setReligionLvl(String religion){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/religionLvl");
		FO.setLine(religion);
	}

	/**
	 * Used to obtain the NPC's religion
	 * 
	 * @return A String containing the religion
	 */
	public String getReligion(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/religion");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}

	}

	/**
	 * Sets the religion of an NPC
	 * 
	 * @param religion A String containing the religion
	 */
	public void setReligion(String religion){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/religion");
		FO.setLine(religion);
	}

	/**
	 * Used to obtain the NPC's min health
	 * 
	 * @return An int containing the min health
	 */
	public int getMinHealth(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/minHealth");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the min health of an NPC
	 * 
	 * @param health An int containing the min health
	 */
	public void setMinHealth(int health){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/minHealth");
		FO.setLine(health + "");
	}

	/**
	 * Used to obtain the NPC's max health
	 * 
	 * @return An int containing the max health
	 */
	public int getMaxHealth(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/maxHealth");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the max health of an NPC
	 * 
	 * @param health An int containing the max health
	 */
	public void setMaxHealth(int health){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/maxHealth");
		FO.setLine(health + "");
	}

	/**
	 * Used to obtain the NPC's max intelligence
	 * 
	 * @return An int containing the max intelligence
	 */
	public int getMaxIntelligence(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/maxIntelligence");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the max intelligence of an NPC
	 * 
	 * @param intel An int containing the max intelligence
	 */
	public void setMaxIntelligence(int intel){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/maxIntelligence");
		FO.setLine(intel + "");
	}

	/**
	 * Used to obtain the NPC's max intelligence
	 * 
	 * @return An int containing the max intelligence
	 */
	public int getMinIntelligence(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/minIntelligence");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the max intelligence of an NPC
	 * 
	 * @param intel An int containing the max intelligence
	 */
	public void setMinIntelligence(int intel){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/minIntelligence");
		FO.setLine(intel + "");
	}

	/**
	 * Used to obtain the NPC's max strength
	 * 
	 * @return An int containing the max strength
	 */
	public int getMaxStrength(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/maxStrength");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the max strength of an NPC
	 * 
	 * @param str An int containing the max strength
	 */
	public void setMaxStrength(int str){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/maxStrength");
		FO.setLine(str + "");
	}

	/**
	 * Used to obtain the NPC's min strength
	 * 
	 * @return An int containing the min strenth
	 */
	public int getMinStrength(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/minStrength");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the min strength of an NPC
	 * 
	 * @param str An int containing the min strength
	 */
	public void setMinStrength(int str){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/minStrength");
		FO.setLine(str + "");
	}

	/**
	 * Used to obtain the NPC's min Gold
	 * 
	 * @return An int containing the min Gold
	 */
	public int getMinGold(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/minGold");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the min gold of an NPC
	 * 
	 * @param gold An int containing the min gold
	 */
	public void setMinGold(int gold){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/minGold");
		FO.setLine(gold + "");
	}

	/**
	 * Used to obtain the NPC's max gold
	 * 
	 * @return An int containing the max gold
	 */
	public int getMaxGold(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/maxGold");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the max gold of an NPC
	 * 
	 * @param gold An int containing the max gold
	 */
	public void setMaxGold(int gold){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/maxGold");
		FO.setLine(gold + "");
	}

	/**
	 * Used to obtain the NPC's min weight
	 * 
	 * @return An int containing the min weight
	 */
	public int getMinWeight(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/minWeight");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the min weight of an NPC
	 * 
	 * @param weight An int containing the min weight
	 */
	public void setMinWeight(int weight){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/minWeight");
		FO.setLine(weight + "");
	}

	/**
	 * Used to obtain the NPC's max weight
	 * 
	 * @return An int containing the max weight
	 */
	public int getMaxWeight(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/maxWeight");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the max weight of an NPC
	 * 
	 * @param weight An int containing the max weight
	 */
	public void setMaxWeight(int weight){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/maxWeight");
		FO.setLine(weight + "");
	}

	/**
	 * Used to obtain the NPC's min wisdom
	 * 
	 * @return An int containing the min wisdom
	 */
	public int getMinWisom(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/minWisdom");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the min wisdom of an NPC
	 * 
	 * @param wis An int containing the min wisdom
	 */
	public void setMinWisdom(int wis){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/minWisdom");
		FO.setLine(wis + "");
	}

	/**
	 * Used to obtain the NPC's max wisdom
	 * 
	 * @return An int containing the max wisdom
	 */
	public int getMaxWisdom(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/maxWisdom");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the max wisdom of an NPC
	 * 
	 * @param wis An int containing the max wisdom
	 */
	public void setMaxWisdom(int wis){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/stats/maxWisdom");
		FO.setLine(wis + "");
	}

	/**
	 * Used to obtain whether or not the NPC drops special items
	 * These special items are contained in the ~root~/drop/ folder
	 * 
	 * @return A String containing "true" or "false"
	 */
	public String getDrop(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/drop");
		return FO.getLine();
	}

	/**
	 * Sets whether or not the NPC drops items
	 * 
	 * @param drop A String containing "true" or "false"
	 */
	public void setDrop(String drop){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/drop");
		FO.setLine(drop);
	}

	/**
	 * Returns a String array containing the inventory of the NPC.
	 * 
	 * @return A String array containing the inventory of the NPC.
	 */
	public String[] getInventory(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/inventory");
		return FO.getDirectory();
	}

	/**
	 * Used to create a new inventory item
	 * This is also used to change the quantity of an item
	 * 
	 * @param inv The name of the item
	 * @param quantity The quantity of the item
	 */
	public void setNewInv(String inv, String quantity){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/inventory/" + inv);
		FO.setLine(quantity);
	}

	/**
	 * Used to delete an inventory item
	 * 
	 * @param inv A String containing the inventory item to delete
	 */
	public void deleteInv(String inv){
		FileOperations OP = new FileOperations(database + "/npc/" + npc + "/inventory/" + inv);
		OP.deleteFile();
	}

	/**
	 * Returns a String array containing the skills that an npc possesses.
	 * 
	 * @return A String array containing the skills that an npc possesses.
	 */
	public String[] getSkills(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/skills/");
		return FO.getDirectory();
	}

	/**
	 * Used to give an npc a new skill
	 * 
	 * @param skillName A String containing the name of the skill
	 * @param skillLevel A String containing an integer value between 1 and 10 of the npc's proficiency
	 */
	public void setNewSkill(String skillName, String skillLevel){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/skills/" + skillName);
		FO.setLine(skillLevel);
	}

	/**
	 * Used to delete a skill
	 * 
	 * @param skill A String containing the skill to be deleted
	 */
	public void deleteSkill(String skill){
		FileOperations OP = new FileOperations(database + "/npc/" + npc + "/skills/" + skill);
		OP.deleteFile();
	}

	/**
	 * Used to obtain what the npc is wearing on their chest
	 * 
	 * @return A String containing what the npc is wearing on their chest
	 */
	public String getWearingChest(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/chest");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the npc is wearing on their chest
	 * 
	 * @param chest A string containing what the npc is wearing on their chest
	 */
	public void setWearingChest(String chest){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/chest");
		FO.setLine(chest);
	}


	/**
	 * Used to obtain what the npc is wearing on their feet
	 * 
	 * @return A String containing what the npc is wearing on their feet
	 */
	public String getWearingFeet(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/feet");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the npc is wearing on their feet
	 * 
	 * @param feet A String containing what the npc is wearing on their feet
	 */
	public void setWearingFeet(String feet){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/feet");
		FO.setLine(feet);
	}


	/**
	 * Used to obtain what the npc is wearing on their head
	 * 
	 * @return A String containing what the npc is wearing on their head
	 */
	public String getWearingHead(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/head");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the npc is wearing on their head
	 * 
	 * @param head A String containing what the npc is wearing on their head
	 */
	public void setWearingHead(String head){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/head");
		FO.setLine(head);
	}


	/**
	 * Used to obtain what the npc is wearing on their left-arm
	 * 
	 * @return A String containing what the npc is wearing on their left-arm
	 */
	public String getWearingLeftArm(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/left-arm");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the npc is wearing on their left-arm
	 * 
	 * @param leftArm A String containing what the npc is wearing on their left arm
	 */
	public void setWearingLeftArm(String leftArm){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/left-arm");
		FO.setLine(leftArm);
	}


	/**
	 * Used to obtain what the npc is wearing on their hands
	 * 
	 * @return A String containing what the npc is wearing on their hands
	 */
	public String getWearingHands(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/hands");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the npc is wearing on their hands
	 * 
	 * @param hands A String containing what the npc is wearing on their hands
	 */
	public void setWearingHands(String hands){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/hands");
		FO.setLine(hands);
	}


	/**
	 * Used to obtain what the npc is holding in their left-hand
	 * 
	 * @return A String containing what the npc is holding in their left-hand
	 */
	public String getLeftHand(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/left-hand");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the npc is holding in their left-hand
	 * 
	 * @param leftHand A String containing what the npc is holding in their left-hand
	 */
	public void setLeftHand(String leftHand){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/left-hand");
		FO.setLine(leftHand);
	}


	/**
	 * Used to obtain what the npc is wearing on their legs (hopefully something)
	 * 
	 * @return A String containing what the npc is wearing on their legs.
	 */
	public String getWearingLegs(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/legs");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the npc is wearing on their legs
	 * 
	 * @param legs A String containing what the npc is wearing on their legs
	 */
	public void setWearingLegs(String legs){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/legs");
		FO.setLine(legs);
	}


	/**
	 * Used to obtain what a npc is wearing around their neck
	 * 
	 * @return A String containing what the npc is wearing around their neck. (Hopefully not a noose)
	 */
	public String getWearingNeck(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/neck");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the npc is wearing on their neck
	 * 
	 * @param neck A String containing what the npc is wearing on their neck
	 */
	public void setWearingNeck(String neck){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/neck");
		FO.setLine(neck);
	}


	/**
	 * Used to obtain what a npc is wearing on their right arm
	 * 
	 * @return A String containing what the npc is wearing on their right arm
	 */
	public String getWearingRightArm(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/right-arm");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the npc is wearing on their right-arm
	 * 
	 * @param rightArm A String containing what the npc is wearing on their right arm
	 */
	public void setWearingRightArm(String rightArm){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/right-arm");
		FO.setLine(rightArm);
	}

	/**
	 * Used to obtain what a npc is holding in their right hand
	 * 
	 * @return A String containing what the npc is holding in their right hand
	 */
	public String getRightHand(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/right-hand");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the npc is holding in their right-hand
	 * 
	 * @param rightHand A String containing what the npc is wearing in their right-hand
	 */
	public void setRightHand(String rightHand){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/right-hand");
		FO.setLine(rightHand);
	}

	/**
	 * Used to what a npc is wearing around their waist
	 * 
	 * @return A String containing what the npc is wearing around their waist
	 */
	public String getWearingWaist(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/waist");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Used to set what the npc is wearing around their waist
	 * 
	 * @param waist A String containing what the npc is wearing around their waist.
	 */
	public void setWearingWaist(String waist){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/wield/waist");
		FO.setLine(waist);
	}

	public int getAcidProtection(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/protection/acidProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setAcidProtection(int protection){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/protection/acidProtection");
		FO.setLine(protection + "");
	}

	public int getFireProtection(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/protection/fireProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setFireProtection(int protection){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/protection/fireProtection");
		FO.setLine(protection + "");
	}

	public int getHitProtection(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/protection/hitProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setHitProtection(int protection){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/protection/hitProtection");
		FO.setLine(protection + "");
	}

	public int getMagicProtection(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/protection/magicProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setMagicProtection(int protection){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/protection/magicProtection");
		FO.setLine(protection + "");
	}

	public int getPierceProtection(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/protection/pierceProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setPierceProtection(int protection){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/protection/pierceProtection");
		FO.setLine(protection + "");
	}

	public int getRangedProtection(){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/protection/rangedProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	public void setRangedProtection(int protection){
		FileOperations FO = new FileOperations(database + "/npc/" + npc + "/protection/rangedProtection");
		FO.setLine(protection + "");
	}
}
