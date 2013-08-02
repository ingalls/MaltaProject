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
	 * * and a string containing the user name.
	 * @param data A String containing the database location
	 * @param objectName A String containing the name of the object being accessed
	 */
	public ObjectValue(String data, String objectName) {
		database = data;
		obj = objectName;
	}

	/**
	 * Returns the dexterity modifier This value will be an integer percent. ie:
	 * 50 will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @return An int containing the modifier
	 */
	public int getDexterityBonus() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/modifiers/dexterityModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * sets the dexterity modifier This value will be an integer percent. ie: 50
	 * will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @param dex A String containing the dexterity
	 */
	public void setDexBonus(String dex) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/modifiers/dexterityModifier");
		FO.setLine(dex);
	}

	/**
	 * Returns the experience modifier This value will be an integer percent.
	 * ie: 50 will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @return An int containing the modifier
	 */
	public int getXPModifier() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/modifiers/expereienceModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * sets the experience modifier This value will be an integer percent. ie:
	 * 50 will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @param XP A String containing the modifier
	 */
	public void setXPModifier(String XP) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/modifiers/experienceModifier");
		FO.setLine(XP);
	}

	/**
	 * Returns the intelligence modifier This value will be an integer percent.
	 * ie: 50 will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @return An int containing the modifier
	 */
	public int getIntelligenceBonus() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/modifiers/intelligenceModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * sets the intelligence modifier This value will be an integer percent. ie:
	 * 50 will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @param intel A String containing the modifier
	 */
	public void setIntelligenceBonus(String intel) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/modifiers/intelligenceModifier");
		FO.setLine(intel);
	}

	/**
	 * Returns the strength modifier This value will be an integer percent. ie:
	 * 50 will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @return An int containing the modifier
	 */
	public int getStrengthBonus() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/modifiers/strengthModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * sets the strength modifier This value will be an integer percent. ie: 50
	 * will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @param str A String containing the modifier
	 */
	public void setStrengthBonus(String str) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/modifiers/strengthModifier");
		FO.setLine(str);
	}

	/**
	 * Returns the wisdom modifier This value will be an integer percent. ie: 50
	 * will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @return An int containing the modifier
	 */
	public int getWisdomBonus() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/modifiers/wisdomModifier");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * sets the wisdom modifier This value will be an integer percent. ie: 50
	 * will reduce the wielder's stat by half 200 will double the stat.
	 * 
	 * @param wis A String containing the modifier
	 */
	public void setWisdomBonus(String wis) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/modifiers/wisdomModifier");
		FO.setLine(wis);
	}

	/**
	 * Tells whether the object can be worn This does not include left-hand and
	 * right-hand
	 * 
	 * @return A string containing the body part that it can be worn on or
	 *         "false"
	 */
	public boolean isWearable() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/settings/wearable");
		return FO.checkFile();
	}

	/**
	 * Sets whether an object can be worn
	 * 
	 * @param wearable A boolean of whether the object can be worn
	 */
	public void setWearable(boolean wearable) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/settings/wearable");
		if (wearable == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	/**
	 * Returns a string containing one of several options "none" - means the
	 * object cannot be held in left-hand or right-hand "weapon" - means the
	 * object can be held and has weapon properties attached to it
	 * 
	 * @return A boolean containing the setting
	 */
	public boolean isWieldable() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/settings/wieldable");
		return FO.checkFile();
	}

	/**
	 * Sets whether the object can be held
	 * 
	 * @param wield A boolean containing the setting
	 */
	public void setWieldable(boolean wield) {
		FileOperations FO = new FileOperations("/objects/" + obj + "/settings/wieldable");
		if (wield == true){
			FO.setLine("");
		} else {
			FO.deleteFile();
		}
	}

	/**
	 * Returns a description for an examined object
	 * 
	 * @return A String containing the description
	 */
	public String getExamine() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/examine");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "The item refuses further examination";
		}
	}

	/**
	 * Sets the description for an examined object
	 * 
	 * @param desc A String containing the description
	 */
	public void setExamine(String desc) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/examine");
		FO.setLine(desc);
	}

	/**
	 * Returns a description for the object
	 * 
	 * @return A String containing the description
	 */
	public String getDesc() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/desc");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "No Description";
		}
	}

	/**
	 * Sets the description for an object
	 * 
	 * @param desc A String containing the description
	 */
	public void setDesc(String desc) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/desc");
		FO.setLine(desc);
	}

	/**
	 * Returns the worth of an object
	 * 
	 * @return A String containing the worth
	 */
	public int getWorth() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/worth");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the worth of an object
	 * 
	 * @param price A String containing the worth
	 */
	public void setWorth(String price) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/worth");
		FO.setLine(price);
	}

	/**
	 * Returns the title for the object
	 * 
	 * @return A String containing the title
	 */
	public String getTitle() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/title");
		return FO.getLine();
	}

	/**
	 * Sets the title for an object
	 * 
	 * @param title A String containing the title
	 */
	public void setTitle(String title) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/title");
		FO.setLine(title);
	}

	/**
	 * Returns whether the item provides acid protection to the user
	 * This value is modified by an integer percent.
	 * Ie. A returned value of 50% would halve the users protection
	 * A returned value of 200% would double it
	 * 
	 * @return An int containing an integer percent
	 */
	public int getAcidProtectionModifier() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/protection/acidProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the acid protection percent for the item
	 * 
	 * @param acid A String containing an integer percent
	 */
	public void setAcidProtectionModifier(String acid) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/protection/acidProtection");
		FO.setLine(acid);
	}

	/**
	 * Returns whether the item provides fire protection to the user
	 * This value is modified by an integer percent.
	 * Ie. A returned value of 50% would halve the users protection
	 * A returned value of 200% would double it
	 * 
	 * @return An int containing an integer percent
	 */
	public int getFireProtectionModifier() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/protection/fireProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the fire protection percent of the item
	 * 
	 * @param fire A String containing an integer percent
	 */
	public void setFireProtectionModifier(String fire) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/protection/fireProtection");
		FO.setLine(fire);
	}

	/**
	 * Returns whether the item provides hit protection to the user
	 * This value is modified by an integer percent.
	 * Ie. A returned value of 50% would halve the users protection
	 * A returned value of 200% would double it
	 * 
	 * @return An int containing an integer percent
	 */
	public int getHitProtectionModifier() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/protection/hitProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the hit protection percent of an item
	 * 
	 * @param hit A String containing an integer percent
	 */
	public void setHitProtectionModifier(String hit) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/protection/hitProtection");
		FO.setLine(hit);
	}

	/**
	 * Returns whether the item provides magic protection to the user
	 * This value is modified by an integer percent.
	 * Ie. A returned value of 50% would halve the users protection
	 * A returned value of 200% would double it
	 * 
	 * @return An int containing an integer percent
	 */
	public int getMagicProtectionModifier() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/protection/acidProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the magic protection percent of an item
	 * 
	 * @param magic A String containing an integer percent
	 */
	public void setMagicProtectionModifier(String magic) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/protection/magicProtection");
		FO.setLine(magic);
	}

	/**
	 * Returns whether the item provides pierce protection to the user
	 * This value is modified by an integer percent.
	 * Ie. A returned value of 50% would halve the users protection
	 * A returned value of 200% would double it
	 * 
	 * @return An int containing an integer percent
	 */
	public int getPierceProtectionModifier() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/protection/pierceProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the piece protection of an item
	 * 
	 * @param pierce A String containing an integer percent
	 */
	public void setPiercedProtectionModifier(String pierce) {
		FileOperations FO = new FileOperations("/objects/" + obj + "/protection/pierceProtection");
		FO.setLine(pierce);
	}

	/**
	 * Returns whether the item provides ranged protection to the user
	 * This value is modified by an integer percent.
	 * Ie. A returned value of 50% would halve the users protection
	 * A returned value of 200% would double it
	 * 
	 * @return An int containing an integer percent
	 */
	public int getRangedProtectionModifier() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/protection/rangedProtection");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the ranged protection of an item
	 * 
	 * @param ranged A String containing an integer percent
	 */
	public void setRangedProtectionModifier(String ranged) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/protection/rangedProtection");
		FO.setLine(ranged);
	}

	/**
	 * Returns the age required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public int getAgeRequirement() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredAge");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the age required to use the item
	 * 
	 * @param age A String containing the requirement
	 */
	public void setAgeRequirement(String age) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredAge");
		FO.setLine(age);
	}

	/**
	 * Returns the class required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public String getClassRequirement() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredClass");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Sets the class required to use the item
	 * 
	 * @param classRequire A String containing the requirement
	 */
	public void setClassRequirement(String classRequire) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredClass");
		FO.setLine(classRequire);
	}

	/**
	 * Returns the dexterity required to use the item
	 * 
	 * @return An int containing the requirement
	 */
	public int getDexterityRequirement() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredDexterity");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the dexterity required to use the item
	 * 
	 * @param dex A String containing the requirement
	 */
	public void setDexterityRequirement(String dex) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredDexterity");
		FO.setLine(dex);
	}

	/**
	 * Returns the health required to use the item
	 * 
	 * @return An int containing the requirement
	 */
	public int getHealthRequirement() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredHealth");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the health required to use the item
	 * 
	 * @param hp A String containing the requirement
	 */
	public void setHealthRequirement(String hp) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredHealth");
		FO.setLine(hp);
	}

	/**
	 * Returns the intelligence required to use the item
	 * 
	 * @return An int containing the requirement
	 */
	public int getIntelligenceRequirement() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredIntelligence");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the intelligence required to use the item
	 * 
	 * @param intel A String containing the requirement
	 */
	public void setIntelligenceRequirement(String intel) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredIntelligence");
		FO.setLine(intel);
	}

	/**
	 * Returns the level required to use the item
	 * 
	 * @return An int containing the requirement
	 */
	public int getLevelRequirement() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredLevel");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the level required to use the item
	 * 
	 * @param lvl A String containing the requirement
	 */
	public void setLevelRequirement(String lvl) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredLevel");
		FO.setLine(lvl);
	}

	/**
	 * Returns the race required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public String getRaceRequirement() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredRace");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Sets the race required to use the item
	 * 
	 * @param race A String containing the requirement
	 */
	public void setRaceRequirement(String race) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredRace");
		FO.setLine(race);
	}

	/**
	 * Returns the religion required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public String getReligionRequirement() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredReligion");
		if (FO.checkFile()){
			return FO.getLine();
		} else {
			return "none";
		}
	}

	/**
	 * Sets the religion required to use the item
	 * 
	 * @param religion A String containing the requirement
	 */
	public void setReligionRequirement(String religion) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredReligion");
		FO.setLine(religion);
	}

	/**
	 * Returns the skill required to use the item
	 * 
	 * @return A String containing the requirement
	 */
	public String[] getSkillRequirement() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredSkill");
		if (FO.checkFile()){
			return FO.getFile();
		} else {
			return null;
		}
	}

	/**
	 * Sets the skill required to use the item
	 * 
	 * @param skills A String[] containing the requirement
	 */
	public void setSkillRequirement(String[] skills) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requiredSkill");
		FO.deleteFile();
		FO.setFile(skills);
	}

	/**
	 * Returns the strength required to use the item
	 * 
	 * @return An int containing the requirement
	 */
	public int getStrengthRequirement() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredStrenth");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the strength required to use the item
	 * 
	 * @param strength A String containing the requirement
	 */
	public void setStrengthRequirement(String strength) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredStrength");
		FO.setLine(strength);
	}

	/**
	 * Returns the weight of the item
	 * 
	 * @return An int containing the weight
	 */
	public int getWeight() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/weight");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the weight required of the item
	 * 
	 * @param weight A String containing the weight
	 */
	public void setWeight(String weight) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/weight");
		FO.setLine(weight);
	}

	/**
	 * Returns the weight required to use the item
	 * 
	 * @return An int containing the requirement
	 */
	public int getWeightRequirement() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredWeight");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the weight required to use the item
	 * 
	 * @param weight A String containing the requirement
	 */
	public void setWeightRequirement(String weight) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredWeight");
		FO.setLine(weight);
	}

	/**
	 * Returns the wisdom required to use the item
	 * 
	 * @return An int containing the requirement
	 */
	public int getWisdomRequirement() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredSkill");
		if (FO.checkFile()){
			return Integer.parseInt(FO.getLine());
		} else {
			return 0;
		}
	}

	/**
	 * Sets the wisdom required to use the item
	 * 
	 * @param wis A String containing the requirement
	 */
	public void setWisdomRequirement(String wis) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/requirements/requiredWisdom");
		FO.setLine(wis);
	}

	/**
	 * Returns a String containing the type of damage the weapon incurs.
	 * This will be a String containing either:
	 * "acid", "fire", "hit", "magic", "pierce", "ranged", or "none" if the object is not a weapon.
	 * 
	 * @return A String containing the type of damage
	 */
	public String getWeaponType() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/fighting/weaponType");
		return FO.getLine();
	}

	/**
	 * Sets the type of damage a weapon object causes
	 * 
	 * @param type A String containing either "acid", "fire", "hit", "magic", "pierce", "ranged", or "none"
	 */
	public void setWeaponType(String type) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/fighting/weaponType");
		FO.setLine(type);
	}

	/**
	 * Returns the String that will be used to describe the damage
	 * if it is a third or less of the max damage
	 * 
	 * @return A String containing the description
	 */
	public String getMinDamageDesc() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/fighting/minDamageDesc");
		return FO.getLine();
	}

	/**
	 * Sets the description that will be used to describe the damage
	 * if it is a third or less of a the max damage
	 * 
	 * @param desc A String containing the description
	 */
	public void setMinDamageDesc(String desc) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/fighting/minDamageDesc");
		FO.setLine(desc);
	}

	/**
	 * Returns the String that will be used to describe the damage
	 * if it is between 1 third and 2 thirds of the max damage
	 * 
	 * @return A String containing the description
	 */
	public String getMedDamageDesc() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/fighting/medDamageDesc");
		return FO.getLine();
	}

	/**
	 * Sets the description that will be used to describe the damage if it is
	 * between 1 third and 2 thirds of the max value
	 * 
	 * @param desc A String containing the description
	 */
	public void setMedDamageDesc(String desc) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/fighting/medDamageDesc");
		FO.setLine(desc);
	}

	/**
	 * Returns the String that will be used to describe the damage
	 * if it is between 2 thirds and 3 thirds of the max damage.
	 * 
	 * @return A String containing the description
	 */
	public String getMaxDamageDesc() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/fighting/maxDamageDesc");
		return FO.getLine();
	}

	/**
	 * Sets the description that will be used to describe the damage if it is
	 * between 1 third and 2 thirds of the max value
	 * 
	 * @param desc A String containing the description
	 */
	public void setMaxDamageDesc(String desc) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/fighting/maxDamageDesc");
		FO.setLine(desc);
	}

	/**
	 * Returns an int containing the min damage that a weapon can cause
	 * 
	 * @return An int containing the damage
	 */
	public int getMinDamage() {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/fighting/minDamage");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the min damage that a weapon can cause
	 * 
	 * @param damage An int containing the min damage
	 */
	public void setMinDamage(int damage) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/fighting/minDamage");
		FO.setLine(damage + "");
	}

	/**
	 * Returns an int containing the max damage that a weapon can cause
	 * 
	 * @return An int containing the max damage
	 */
	public int getMaxDamage() {
		FileOperations FO = new FileOperations( database + "/objects/" + obj + "/fighting/maxDamage");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the max damage that a weapon can cause
	 * 
	 * @param damage An int containing the max damage that a weapon can cause
	 */
	public void setMaxDamage(int damage) {
		FileOperations FO = new FileOperations(database + "/objects/" + obj + "/fighting/maxDamage");
		FO.setLine(damage + "");
	}
}
