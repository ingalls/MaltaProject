package getValue;

import maltaProject.FileOperations;

/**
 * This class is used to obtain the stats of a specific instance of an npc.
 * An instance NPC is a child of an NPC.
 * When the instanceNPC is created, it is created with stats
 * 
 * @author Nicholas Ingalls
 */

public class InstanceNPCValue {

	/** Stores database location - initialized by constructor */
	String database = "";
	/** Stores the name of the object - initialized by constructor */
	String npc = "";

	/**
	 * Constructs a new object with a string containing the database location
	 * and a string containing the username.
	 */
	public InstanceNPCValue(String data, String instanceNPC) {
		database = data;
		npc = instanceNPC;
	}

	/**
	 * Returns the dexterity of an instance NPC
	 * 
	 * @return A String containing the dexterity
	 */
	public String getDex() {
		String fileLoc = database + "/instanceNPC/" + npc + "/dexterity";
		FileOperations open = new FileOperations(fileLoc);
		String dex = open.getLine();
		return dex;
	}

	/**
	 * Sets the dexterity of an instance NPC
	 * 
	 * @param dex A String containing the dexterity
	 */
	public void setDex(String dex) {
		String fileLoc = database + "/instanceNPC/" + npc + "/dexterity";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(dex);
	}

	/**
	 * Returns the age of an instance NPC
	 * 
	 * @return A String containing the age
	 */
	public String getAge() {
		String fileLoc = database + "/instanceNPC/" + npc + "/age";
		FileOperations open = new FileOperations(fileLoc);
		String age = open.getLine();
		return age;
	}

	/**
	 * Sets the age of an instance NPC
	 * 
	 * @param age A String containing the age
	 */
	public void setAge(String age) {
		String fileLoc = database + "/instanceNPC/" + npc + "/age";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(age);
	}

	/**
	 * Returns the experience of an instance NPC
	 * 
	 * @return A String containing the experience
	 */
	public String getXP() {
		String fileLoc = database + "/instanceNPC/" + npc + "/experience";
		FileOperations open = new FileOperations(fileLoc);
		String experience = open.getLine();
		return experience;
	}

	/**
	 * Sets the experience of an instance NPC
	 * 
	 * @param experience A String containing the experience
	 */
	public void setXP(String experience) {
		String fileLoc = database + "/instanceNPC/" + npc + "/experience";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(experience);
	}

	/**
	 * Returns the gold of an instance NPC
	 * 
	 * @return A String containing the gold
	 */
	public String getGold() {
		String fileLoc = database + "/instanceNPC/" + npc + "/gold";
		FileOperations open = new FileOperations(fileLoc);
		String gold = open.getLine();
		return gold;
	}

	/**
	 * Sets the amount of gold that an instance NPC has
	 * 
	 * @param gold
	 */
	public void setGold(String gold) {
		String fileLoc = database + "/instanceNPC/" + npc + "/gold";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(gold);
	}

	/**
	 * Returns the health of an instance NPC
	 * 
	 * @return A String containing the health
	 */
	public String getHP() {
		String fileLoc = database + "/instanceNPC/" + npc + "/health";
		FileOperations open = new FileOperations(fileLoc);
		String hp = open.getLine();
		return hp;
	}

	/**
	 * Sets the health of an instance NPC
	 * 
	 * @param hp A String containing the health
	 */
	public void setHP(String hp) {
		String fileLoc = database + "/instanceNPC/" + npc + "/health";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(hp);
	}

	/**
	 * Returns the intelligence of an instance NPC
	 * 
	 * @return A String containing the intelligence
	 */
	public String getIntelligence() {
		String fileLoc = database + "/instanceNPC/" + npc + "/intelligence";
		FileOperations open = new FileOperations(fileLoc);
		String intel = open.getLine();
		return intel;
	}

	/**
	 * Sets the intelligence of an instance NPC
	 * 
	 * @param intel A String containing the intelligence
	 */
	public void setIntelligence(String intel) {
		String fileLoc = database + "/instanceNPC/" + npc + "/intelligence";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(intel);
	}

	/**
	 * Returns the level of an instance NPC
	 * 
	 * @return A String containing the level
	 */
	public String getLevel() {
		String fileLoc = database + "/instanceNPC/" + npc + "/intelligence";
		FileOperations open = new FileOperations(fileLoc);
		String lvl = open.getLine();
		return lvl;
	}

	/**
	 * Sets the level of an instance NPC
	 * 
	 * @param lvl A String containing the level
	 */
	public void setLevel(String lvl) {
		String fileLoc = database + "/instanceNPC/" + npc + "/intelligence";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(lvl);
	}

	/**
	 * Returns a string containing the name of the parent NPC
	 * 
	 * @return A String containing the name of the parent NPC
	 */
	public String getReference() {
		String fileLoc = database + "/instanceNPC/" + npc + "/reference";
		FileOperations open = new FileOperations(fileLoc);
		String ref = open.getLine();
		return ref;
	}

	/**
	 * Changes parent NPC of which the instance is a child of.
	 * This method is included for completeness. It should not
	 * be used in most cases as it allows a child to have better/worse
	 * stats than if it were generated based on the parents stats.
	 * (This class does NOT regenerate the stats of the instance NPC,
	 * it simply changes who the parent it)
	 * 
	 * @param ref A String contaning the name of the reference.
	 */
	public void setReference(String ref) {
		String fileLoc = database + "/instanceNPC/" + npc + "/reference";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(ref);
	}

	/**
	 * Returns the sex of the instance NPC
	 * 
	 * @return A String containing the sex
	 */
	public String getSex() {
		String fileLoc = database + "/instanceNPC/" + npc + "/sex";
		FileOperations open = new FileOperations(fileLoc);
		String sex = open.getLine();
		return sex;
	}

	/**
	 * Sets the sex of an instance NPC
	 * 
	 * @param sex A String containing the sex
	 */
	public void setSex(String sex) {
		String fileLoc = database + "/instanceNPC/" + npc + "/sex";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(sex);
	}

	/**
	 * Returns the strength of an instance NPC
	 * 
	 * @return A String containing the strength
	 */
	public String getStrength() {
		String fileLoc = database + "/instanceNPC/" + npc + "/strength";
		FileOperations open = new FileOperations(fileLoc);
		String str = open.getLine();
		return str;
	}

	/**
	 * Sets the strength of an instance NPC
	 * 
	 * @param str A String containing the strength
	 */
	public void setStrength(String str) {
		String fileLoc = database + "/instanceNPC/" + npc + "/strength";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(str);
	}

	/**
	 * Returns the weight of an instance NPC
	 * 
	 * @return A String containing the weight
	 */
	public String getWeight() {
		String fileLoc = database + "/instanceNPC/" + npc + "/weight";
		FileOperations open = new FileOperations(fileLoc);
		String lvl = open.getLine();
		return lvl;
	}

	/**
	 * Sets the weight of an instance NPC
	 * 
	 * @param lvl A String containing the weight
	 */
	public void setWeight(String lvl) {
		String fileLoc = database + "/instanceNPC/" + npc + "/weight";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(lvl);
	}

	/**
	 * Returns the wisdom of an instance NPC
	 * 
	 * @return A String containing the wisdom
	 */
	public String getWisdom() {
		String fileLoc = database + "/instanceNPC/" + npc + "/wisdom";
		FileOperations open = new FileOperations(fileLoc);
		String wis = open.getLine();
		return wis;
	}

	/**
	 * Sets the wisdom of an instance NPC
	 * 
	 * @param wis A String containing the wisdom
	 */
	public void setWisdom(String wis) {
		String fileLoc = database + "/instanceNPC/" + npc + "/wisdom";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(wis);
	}
}
