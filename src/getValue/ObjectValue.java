package getValue;

import maltaProject.FileOperations;

/**
 * This class is used to obtain stats about an object. Given the object's name
 * and the database location, this class will allow the caller to return
 * numerous stats about an object.
 * 
 * WARNING - Unlike NPC and User Values which remain relatively unchanged from
 * release to release, Object values are in a state of constant flux This is due
 * to the nature of introducing new objects. Objects must be introduced at the
 * code level and therefore new getters and setters will be introduced as new
 * types of objects form.
 * 
 * @author Nicholas Ingalls
 */

public class ObjectValue {
	/** Stores database location - initialized by constructor */
	String database = "";
	/** Stores the name of the object - initialized by constructor */
	String obj = "";

	/**
	 * Constructs a new object with a string containing the database location
	 * and a string containing the username.
	 */
	public ObjectValue(String data, String objectName) {
		database = data;
		obj = objectName;
	}

	/**
	 * Returns the dexterity modifier This value will be an integer percent. ie:
	 * 50 will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @return A String containing the modifier
	 */
	public String getDexModifier() {
		String fileLoc = database + "/objects/" + obj + "/modifiers/dexterityModifier";
		FileOperations open = new FileOperations(fileLoc);
		String dex = open.getLine();
		return dex;
	}

	/**
	 * sets the dexterity modifier This value will be an integer percent. ie: 50
	 * will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @return A String containing the modifier
	 */
	public void setDexModifier(String dex) {
		String fileLoc = database + "/objects/" + obj + "/modifiers/dexterityModifier";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(dex);
	}

	/**
	 * Returns the experience modifier This value will be an integer percent.
	 * ie: 50 will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @return A String containing the modifier
	 */
	public String getXPModifier() {
		String fileLoc = database + "/objects/" + obj + "/modifiers/expereienceModifier";
		FileOperations open = new FileOperations(fileLoc);
		String XP = open.getLine();
		return XP;
	}

	/**
	 * sets the experience modifier This value will be an integer percent. ie:
	 * 50 will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @return A String containing the modifier
	 */
	public void setXPModifier(String XP) {
		String fileLoc = database + "/objects/" + obj + "/modifiers/experienceModifier";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(XP);
	}

	/**
	 * Returns the intelligence modifier This value will be an integer percent.
	 * ie: 50 will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @return A String containing the modifier
	 */
	public String getIntelligenceModifier() {
		String fileLoc = database + "/objects/" + obj + "/modifiers/intelligenceModifier";
		FileOperations open = new FileOperations(fileLoc);
		String intel = open.getLine();
		return intel;
	}

	/**
	 * sets the intelligence modifier This value will be an integer percent. ie:
	 * 50 will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @return A String containing the modifier
	 */

	public void setIntelligenceModifier(String intel) {
		String fileLoc = database + "/objects/" + obj + "/modifiers/intelligenceModifier";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(intel);
	}

	/**
	 * Returns the strength modifier This value will be an integer percent. ie:
	 * 50 will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @return A String containing the modifier
	 */
	public String getStrengthModifier() {
		String fileLoc = database + "/objects/" + obj + "/modifiers/strengthModifier";
		FileOperations open = new FileOperations(fileLoc);
		String str = open.getLine();
		return str;
	}

	/**
	 * sets the strength modifier This value will be an integer percent. ie: 50
	 * will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @return A String containing the modifier
	 */
	public void setStrengthModifier(String str) {
		String fileLoc = database + "/objects/" + obj + "/modifiers/strengthModifier";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(str);
	}

	/**
	 * Returns the wisdom modifier This value will be an integer percent. ie: 50
	 * will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @return A String containing the modifier
	 */
	public String getWisdomModifier() {
		String fileLoc = database + "/objects/" + obj + "/modifiers/wisdomModifier";
		FileOperations open = new FileOperations(fileLoc);
		String wis = open.getLine();
		return wis;
	}

	/**
	 * sets the wisdom modifier This value will be an integer percent. ie: 50
	 * will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @return A String containing the modifier
	 */
	public void setWisdomModifier(String wis) {
		String fileLoc = database + "/objects/" + obj + "/modifiers/wisdomModifier";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(wis);
	}

	/**
	 * Tells whether the object can be worn This does not include left-hand and
	 * right-hand
	 * 
	 * @return A string containing the body part that it can be worn on or
	 *         "false"
	 */
	public String isWearable() {
		String fileLoc = database + "/objects/" + obj + "/settings/wearable";
		FileOperations open = new FileOperations(fileLoc);
		String wearable = open.getLine();
		return wearable;
	}

	/**
	 * Sets whether an object can be worn
	 * 
	 * @param wearable A String containing the body part that it can be worn on or
	 * "false"
	 */
	public void setWearable(String wearable) {
		String fileLoc = database + "/objects/" + obj + "/settings/wearable";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(wearable);
	}

	/**
	 * Returns a string containing one of several options "none" - means the
	 * object cannot be held in left-hand or right-hand "weapon" - means the
	 * object can be held and has weapon properties attached to it
	 * 
	 * @return A String containing the setting
	 */
	public String isWieldable() {
		String fileLoc = database + "/objects/" + obj + "/settings/wieldable";
		FileOperations open = new FileOperations(fileLoc);
		String wield = open.getLine();
		return wield;
	}

	/**
	 * Sets whether the object can be held
	 * 
	 * @param wield A String containing the setting
	 */
	public void setWieldable(String wield) {
		String fileLoc = database + "/objects/" + obj + "/settings/wieldable";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(wield);
	}

	/**
	 * Returns a description for an examined object
	 * 
	 * @return A String containing the description
	 */
	public String getExamine() {
		String fileLoc = database + "/objects/" + obj + "/examine";
		FileOperations open = new FileOperations(fileLoc);
		String desc = open.getLine();
		return desc;
	}

	/**
	 * Sets the description for an examined object
	 * 
	 * @param desc A String containing the description
	 */
	public void setExamine(String desc) {
		String fileLoc = database + "/objects/" + obj + "/examine";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(desc);
	}

	/**
	 * Returns a description for the object
	 * 
	 * @return A String containing the description
	 */
	public String getDesc() {
		String fileLoc = database + "/objects/" + obj + "/desc";
		FileOperations open = new FileOperations(fileLoc);
		String desc = open.getLine();
		return desc;
	}

	/**
	 * Sets the description for an object
	 * 
	 * @param desc A String containing the description
	 */
	public void setDesc(String desc) {
		String fileLoc = database + "/objects/" + obj + "/desc";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(desc);
	}

	/**
	 * Returns the title for the object
	 * 
	 * @return A String containing the title
	 */
	public String getTitle() {
		String fileLoc = database + "/objects/" + obj + "/title";
		FileOperations open = new FileOperations(fileLoc);
		String title = open.getLine();
		return title;
	}

	/**
	 * Sets the title for an object
	 * 
	 * @param title A String containing the title
	 */
	public void setTitle(String title) {
		String fileLoc = database + "/objects/" + obj + "/title";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(title);
	}

	/**
	 * Returns whether the item provides acid protection to the user
	 * This value is modified by an integer percent.
	 * Ie. A returned value of 50% would halve the users protection
	 * A returned value of 200% would double it
	 * 
	 * @return A String containing an integer percent
	 */
	public String getAcidProtection() {
		String fileLoc = database + "/objects/" + obj + "/protection/acidProtection";
		FileOperations open = new FileOperations(fileLoc);
		String acid = open.getLine();
		return acid;
	}

	/**
	 * Sets the acid protection percent for the item
	 * 
	 * @param acid A String containing an integer percent
	 */
	public void setAcidProtection(String acid) {
		String fileLoc = database + "/objects/" + obj + "/protection/acidProtection";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(acid);
	}

	/**
	 * Returns whether the item provides fire protection to the user
	 * This value is modified by an integer percent.
	 * Ie. A returned value of 50% would halve the users protection
	 * A returned value of 200% would double it
	 * 
	 * @return A String containing an integer percent
	 */
	public String getFireProtection() {
		String fileLoc = database + "/objects/" + obj + "/protection/fireProtection";
		FileOperations open = new FileOperations(fileLoc);
		String fire = open.getLine();
		return fire;
	}

	/**
	 * Sets the fire protection percent of the item
	 * 
	 * @param fire A String containing an integer percent
	 */
	public void setFireProtection(String fire) {
		String fileLoc = database + "/objects/" + obj + "/protection/fireProtection";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(fire);
	}

	/**
	 * Returns whether the item provides hit protection to the user
	 * This value is modified by an integer percent.
	 * Ie. A returned value of 50% would halve the users protection
	 * A returned value of 200% would double it
	 * 
	 * @return A String containing an integer percent
	 */
	public String getHitProtection() {
		String fileLoc = database + "/objects/" + obj + "/protection/hitProtection";
		FileOperations open = new FileOperations(fileLoc);
		String hit = open.getLine();
		return hit;
	}

	/**
	 * Sets the hit protection percent of an item
	 * 
	 * @param hit A String containing an integer percent
	 */
	public void setHitProtection(String hit) {
		String fileLoc = database + "/objects/" + obj + "/protection/hitProtection";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(hit);
	}

	/**
	 * Returns whether the item provides magic protection to the user
	 * This value is modified by an integer percent.
	 * Ie. A returned value of 50% would halve the users protection
	 * A returned value of 200% would double it
	 * 
	 * @return A String containing an integer percent
	 */
	public String getMagicProtection() {
		String fileLoc = database + "/objects/" + obj + "/protection/acidProtection";
		FileOperations open = new FileOperations(fileLoc);
		String acid = open.getLine();
		return acid;
	}

	/**
	 * Sets the magic protection percent of an item
	 * 
	 * @param magic A String containing an integer percent
	 */
	public void setMagicProtection(String magic) {
		String fileLoc = database + "/objects/" + obj + "/protection/magicProtection";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(magic);
	}

	/**
	 * Returns whether the item provides pierce protection to the user
	 * This value is modified by an integer percent.
	 * Ie. A returned value of 50% would halve the users protection
	 * A returned value of 200% would double it
	 * 
	 * @return A String containing an integer percent
	 */
	public String getPierceProtection() {
		String fileLoc = database + "/objects/" + obj + "/protection/pierceProtection";
		FileOperations open = new FileOperations(fileLoc);
		String pierce = open.getLine();
		return pierce;
	}

	/**
	 * Sets the piece protection of an item
	 * 
	 * @param pierce A String containing an integer percent
	 */
	public void setPiercedProtection(String pierce) {
		String fileLoc = database + "/objects/" + obj + "/protection/pierceProtection";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(pierce);
	}

	/**
	 * Returns whether the item provides ranged protection to the user
	 * This value is modified by an integer percent.
	 * Ie. A returned value of 50% would halve the users protection
	 * A returned value of 200% would double it
	 * 
	 * @return A String containing an integer percent
	 */
	public String getRangedProtection() {
		String fileLoc = database + "/objects/" + obj + "/protection/rangedProtection";
		FileOperations open = new FileOperations(fileLoc);
		String ranged = open.getLine();
		return ranged;
	}

	/**
	 * Sets the ranged protection of an item
	 * 
	 * @param ranged A String containing an integer percent
	 */
	public void setRangedProtection(String ranged) {
		String fileLoc = database + "/objects/" + obj + "/protection/rangedProtection";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(ranged);
	}

	/**
	 * Returns the age required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public String getAgeRequirement() {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredAge";
		FileOperations open = new FileOperations(fileLoc);
		String age = open.getLine();
		return age;
	}

	/**
	 * Sets the age required to use the item
	 * 
	 * @param wis A String containing the requirement
	 */
	public void setAgeRequirement(String age) {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredAge";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(age);
	}

	/**
	 * Returns the class required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public String getClassRequirement() {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredClass";
		FileOperations open = new FileOperations(fileLoc);
		String classRequire = open.getLine();
		return classRequire;
	}

	/**
	 * Sets the class required to use the item
	 * 
	 * @param wis A String containing the requirement
	 */
	public void setClassRequirement(String classRequire) {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredClass";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(classRequire);
	}

	/**
	 * Returns the dexterity required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public String getDexterityRequirement() {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredDexterity";
		FileOperations open = new FileOperations(fileLoc);
		String dex = open.getLine();
		return dex;
	}

	/**
	 * Sets the dexterity required to use the item
	 * 
	 * @param wis A String containing the requirement
	 */
	public void setDexterityRequirement(String dex) {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredDexterity";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(dex);
	}

	/**
	 * Returns the health required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public String getHealthRequirement() {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredHealth";
		FileOperations open = new FileOperations(fileLoc);
		String hp = open.getLine();
		return hp;
	}

	/**
	 * Sets the health required to use the item
	 * 
	 * @param wis A String containing the requirement
	 */
	public void setHealthRequirement(String hp) {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredHealth";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(hp);
	}

	/**
	 * Returns the intelligence required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public String getIntelligenceRequirement() {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredIntelligence";
		FileOperations open = new FileOperations(fileLoc);
		String intel = open.getLine();
		return intel;
	}

	/**
	 * Sets the intelligence required to use the item
	 * 
	 * @param wis A String containing the requirement
	 */
	public void setIntelligenceRequirement(String intel) {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredIntelligence";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(intel);
	}

	/**
	 * Returns the level required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public String getLevelRequirement() {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredLevel";
		FileOperations open = new FileOperations(fileLoc);
		String lvl = open.getLine();
		return lvl;
	}

	/**
	 * Sets the level required to use the item
	 * 
	 * @param wis A String containing the requirement
	 */
	public void setLevelRequirement(String lvl) {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredLevel";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(lvl);
	}

	/**
	 * Returns the race required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public String getRaceRequirement() {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredRace";
		FileOperations open = new FileOperations(fileLoc);
		String race = open.getLine();
		return race;
	}

	/**
	 * Sets the race required to use the item
	 * 
	 * @param wis A String containing the requirement
	 */
	public void setRaceRequirement(String race) {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredRace";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(race);
	}

	/**
	 * Returns the religion required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public String getReligionRequirement() {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredReligion";
		FileOperations open = new FileOperations(fileLoc);
		String religion = open.getLine();
		return religion;
	}

	/**
	 * Sets the religion required to use the item
	 * 
	 * @param wis A String containing the requirement
	 */
	public void setReligionRequirement(String religion) {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredReligion";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(religion);
	}

	/**
	 * Returns the skill required to use the item
	 * 
	 * @return A String containing the requirement
	 */

	//TODO should be a String[] as there can be more than one

	public String getSkillRequirement() {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredSkill";
		FileOperations open = new FileOperations(fileLoc);
		String skill = open.getLine();
		return skill;
	}

	/**
	 * Sets the skill required to use the item
	 * 
	 * @param wis A String containing the requirement
	 */
	public void setSkillRequirement(String[] skills) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requiredSkill");
		FO.deleteFile("");
		int currentPos = 0;
		while (currentPos <= skills.length-1) {
			FO.appendLine(skills[currentPos]);
			currentPos++;
		}
	}

	/**
	 * Returns the strength required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public String getStrengthRequirement() {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredStrenth";
		FileOperations open = new FileOperations(fileLoc);
		String strength = open.getLine();
		return strength;
	}

	/**
	 * Sets the strength required to use the item
	 * 
	 * @param wis A String containing the requirement
	 */
	public void setStrengthRequirement(String strength) {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredStrength";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(strength);
	}

	/**
	 * Returns the weight required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public String getWeightRequirement() {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredWeight";
		FileOperations open = new FileOperations(fileLoc);
		String weight = open.getLine();
		return weight;
	}

	/**
	 * Sets the weight required to use the item
	 * 
	 * @param wis A String containing the requirement
	 */
	public void setWeightRequirement(String weight) {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredWeight";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(weight);
	}

	/**
	 * Returns the wisdom required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public String getWisdomRequirement() {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredSkill";
		FileOperations open = new FileOperations(fileLoc);
		String wis = open.getLine();
		return wis;
	}

	/**
	 * Sets the wisdom required to use the item
	 * 
	 * @param wis A String containing the requirement
	 */
	public void setWisdomRequirement(String wis) {
		String fileLoc = database + "/objects/" + obj + "/requirements/requiredWisdom";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(wis);
	}

	/**
	 * Returns a String containing the type of damage the weapon incurs.
	 * This will be a String containing either:
	 * "acid", "fire", "hit", "magic", "pierce", "ranged", or "none" if the object is not a weapon.
	 * 
	 * @return A String contaning the type of damage
	 */
	public String getWeaponType() {
		String fileLoc = database + "/objects/" + obj + "/fighting/weaponType";
		FileOperations open = new FileOperations(fileLoc);
		String type = open.getLine();
		return type;
	}

	/**
	 * Sets the type of damage a weapon object causes
	 * 
	 * @param type A String containing either "acid", "fire", "hit", "magic", "pierce", "ranged", or "none"
	 */
	public void setWeaponType(String type) {
		String fileLoc = database + "/objects/" + obj + "/fighting/weaponType";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(type);
	}

	/**
	 * Returns the String that will be used to describe the damage
	 * if it is a third or less of the max damage
	 * 
	 * @return A String containing the description
	 */
	public String getMinDamageDesc() {
		String fileLoc = database + "/objects/" + obj + "/fighting/minDamageDesc";
		FileOperations open = new FileOperations(fileLoc);
		String desc = open.getLine();
		return desc;
	}

	/**
	 * Sets the description that will be used to describe the damage
	 * if it is a third or less of a the max damage
	 * 
	 * @param desc A String containing the description
	 */
	public void setMinDamageDesc(String desc) {
		String fileLoc = database + "/objects/" + obj + "/fighting/minDamageDesc";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(desc);
	}

	/**
	 * Returns the String that will be used to describe the damage
	 * if it is between 1 third and 2 thirds of the max damage
	 * 
	 * @return A String containing the description
	 */
	public String getMedDamageDesc() {
		String fileLoc = database + "/objects/" + obj + "/fighting/medDamageDesc";
		FileOperations open = new FileOperations(fileLoc);
		String desc = open.getLine();
		return desc;
	}

	/**
	 * Sets the description that will be used to describe the damage if it is
	 * between 1 third and 2 thirds of the max value
	 * 
	 * @param desc A String containing the description
	 */
	public void setMedDamageDesc(String desc) {
		String fileLoc = database + "/objects/" + obj + "/fighting/medDamageDesc";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(desc);
	}

	/**
	 * Returns the String that will be used to describe the damage
	 * if it is between 2 thirds and 3 thirds of the max damage.
	 * 
	 * @return A String containing the description
	 */
	public String getMaxDamageDesc() {
		String fileLoc = database + "/objects/" + obj + "/fighting/maxDamageDesc";
		FileOperations open = new FileOperations(fileLoc);
		String desc = open.getLine();
		return desc;
	}

	/**
	 * Sets the description that will be used to describe the damage if it is
	 * between 1 third and 2 thirds of the max value
	 * 
	 * @param desc A String containing the description
	 */
	public void setMaxDamageDesc(String desc) {
		String fileLoc = database + "/objects/" + obj + "/fighting/maxDamageDesc";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(desc);
	}

	/**
	 * Returns a string containing the min damage that a weapon can cause
	 * 
	 * @return A String containing the damage
	 */
	public String getMinDamage() {
		String fileLoc = database + "/objects/" + obj + "/fighting/minDamageDesc";
		FileOperations open = new FileOperations(fileLoc);
		String damage = open.getLine();
		return damage;
	}

	/**
	 * Sets the min damage that a weapon can cause
	 * 
	 * @param damage A String containing the min damage
	 */
	public void setMinDamage(String damage) {
		String fileLoc = database + "/objects/" + obj + "/fighting/minDamageDesc";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(damage);
	}

	/**
	 * Returns a String containing the max damage that a weapon can cause
	 * 
	 * @return A String containing the max damage
	 */
	public String getMaxDamage() {
		String fileLoc = database + "/objects/" + obj + "/fighting/minDamageDesc";
		FileOperations open = new FileOperations(fileLoc);
		String damage = open.getLine();
		return damage;
	}

	/**
	 * Sets the max damage that a weapon can cause
	 * 
	 * @param damage A String containing the max damage that a weapon can cause
	 */
	public void setMaxDamage(String damage) {
		String fileLoc = database + "/objects/" + obj + "/fighting/minDamageDesc";
		FileOperations open = new FileOperations(fileLoc);
		open.setLine(damage);
	}
}
