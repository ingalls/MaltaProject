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
	 * Returns the starting room of the NPC
	 * 
	 * @return A String containing the room
	 */
	public String getOrigin() {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/origin");
		return open.getLine();
	}

	/**
	 * Sets the starting room of the NPC
	 * 
	 * @param origin A String containing the room
	 */
	public void setOrigin(String origin) {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/origin");
		open.setLine(origin);
	}

	/**
	 * Returns the dexterity of an instance NPC
	 * 
	 * @return An int containing the dexterity
	 */
	public int getDexterity() {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/dexterity");
		return Integer.parseInt(open.getLine());
	}

	/**
	 * Sets the dexterity of an instance NPC
	 * 
	 * @param dex An int containing the dexterity
	 */
	public void setDexterity(int dex) {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/dexterity");
		open.setLine(dex + "");
	}

	/**
	 * Returns the age of an instance NPC
	 * 
	 * @return An int containing the age
	 */
	public int getAge() {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/age");
		return Integer.parseInt(open.getLine());
	}

	/**
	 * Sets the age of an instance NPC
	 * 
	 * @param age An int containing the age
	 */
	public void setAge(int age) {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/age");
		open.setLine(age + "");
	}

	/**
	 * Returns the experience of an instance NPC
	 * 
	 * @return An int containing the experience
	 */
	public int getXP() {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/experience");
		return Integer.parseInt(open.getLine());
	}

	/**
	 * Sets the experience of an instance NPC
	 * 
	 * @param experience An int containing the experience
	 */
	public void setXP(int experience) {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/experience");
		open.setLine(experience + "");
	}

	/**
	 * Returns the gold of an instance NPC
	 * 
	 * @return An int containing the gold
	 */
	public int getGold() {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/gold");
		return Integer.parseInt(open.getLine());
	}

	/**
	 * Sets the amount of gold that an instance NPC has
	 * 
	 * @param gold An int containing the amount of gold
	 */
	public void setGold(int gold) {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/gold");
		open.setLine(gold + "");
	}

	/**
	 * Returns the health of an instance NPC
	 * 
	 * @return An int containing the health
	 */
	public int getHP() {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/health");
		return Integer.parseInt(open.getLine());
	}

	/**
	 * Sets the health of an instance NPC
	 * 
	 * @param hp An int containing the health
	 */
	public void setHP(int hp) {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/health");
		open.setLine(hp + "");
	}

	/**
	 * Returns the intelligence of an instance NPC
	 * 
	 * @return An int containing the intelligence
	 */
	public int getIntelligence() {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/intelligence");
		return Integer.parseInt(open.getLine());
	}

	/**
	 * Sets the intelligence of an instance NPC
	 * 
	 * @param intel An int containing the intelligence
	 */
	public void setIntelligence(int intel) {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/intelligence");
		open.setLine(intel + "");
	}

	/**
	 * Returns the level of an instance NPC
	 * 
	 * @return An int containing the level
	 */
	public int getLevel() {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/intelligence");
		return Integer.parseInt(open.getLine());
	}

	/**
	 * Sets the level of an instance NPC
	 * 
	 * @param lvl An int containing the level
	 */
	public void setLevel(int lvl) {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/intelligence");
		open.setLine(lvl + "");
	}

	/**
	 * Returns a string containing the name of the parent NPC
	 * 
	 * @return A String containing the name of the parent NPC
	 */
	public String getReference() {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/reference");
		return open.getLine();
	}

	/**
	 * Changes parent NPC of which the instance is a child of.
	 * This method is included for completeness. It should not
	 * be used in most cases as it allows a child to have better/worse
	 * stats than if it were generated based on the parents stats.
	 * (This class does NOT regenerate the stats of the instance NPC,
	 * it simply changes who the parent it)
	 * 
	 * @param ref A String containing the name of the reference.
	 */
	public void setReference(String ref) {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/reference");
		open.setLine(ref);
	}

	/**
	 * Returns the sex of the instance NPC
	 * 
	 * @return A String containing the sex (male/female)
	 */
	public String getSex() {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/sex");
		return open.getLine();
	}

	/**
	 * Sets the sex of an instance NPC
	 * 
	 * @param sex A String containing the sex (male/female)
	 */
	public void setSex(String sex) {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/sex");
		open.setLine(sex);
	}

	/**
	 * Returns the strength of an instance NPC
	 * 
	 * @return An int containing the strength
	 */
	public int getStrength() {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/strength");
		return Integer.parseInt(open.getLine());
	}

	/**
	 * Sets the strength of an instance NPC
	 * 
	 * @param str An int containing the strength
	 */
	public void setStrength(int str) {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/strength");
		open.setLine(str + "");
	}

	/**
	 * Returns the weight of an instance NPC
	 * 
	 * @return An int containing the weight
	 */
	public int getWeight() {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/weight");
		return Integer.parseInt(open.getLine());
	}

	/**
	 * Sets the weight of an instance NPC
	 * 
	 * @param weight An int containing the weight
	 */
	public void setWeight(int weight) {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/weight");
		open.setLine(weight + "");
	}

	/**
	 * Returns the wisdom of an instance NPC
	 * 
	 * @return An int containing the wisdom
	 */
	public int getWisdom() {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/wisdom");
		return Integer.parseInt(open.getLine());
	}

	/**
	 * Sets the wisdom of an instance NPC
	 * 
	 * @param wis An int containing the wisdom
	 */
	public void setWisdom(int wis) {
		FileOperations open = new FileOperations(database + "/instanceNPC/" + npc + "/wisdom");
		open.setLine(wis + "");
	}
}
