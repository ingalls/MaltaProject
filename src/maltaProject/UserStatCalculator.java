package maltaProject;

import getValue.ObjectValue;
import getValue.ReligionLevelValue;
import getValue.SubClassValue;
import getValue.UserValue;

/**
 * This class is responsible for calculating total values
 * for user's. Since objects can modify the user's stats,
 * these must be applied to the user's stats for the total
 * to be known.
 * 
 * @author Nicholas Ingalls
 */
public class UserStatCalculator {

	String database = "";
	String user = "";

	public UserStatCalculator(String data, String userName){
		database = data;
		user = userName;
	}

	public int getDexterityTotal(){
		int dexTotal;

		UserValue userStat = new UserValue(database, user);
		SubClassValue subClassStat = new SubClassValue(database, userStat.getUserClass(), userStat.getUserSubClass());
		ReligionLevelValue religion = new ReligionLevelValue(database, userStat.getReligion(), userStat.getReligionLvl());

		dexTotal = userStat.getBaseDexterity();
		dexTotal = dexTotal + subClassStat.getDexterityBonus();
		dexTotal = dexTotal + religion.getDexterityBonus();

		if (!userStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, userStat.getWearingChest());
			dexTotal = dexTotal + chest.getDexterityBonus();
		}

		if (!userStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, userStat.getWearingFeet());
			dexTotal = dexTotal + feet.getDexterityBonus();
		}

		if (!userStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, userStat.getWearingHands());
			dexTotal = dexTotal + hands.getDexterityBonus();
		}

		if (!userStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, userStat.getWearingHead());
			dexTotal = dexTotal + head.getDexterityBonus();
		}

		if (!userStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, userStat.getWearingLeftArm());
			dexTotal = dexTotal + leftArm.getDexterityBonus();
		}

		if (!userStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, userStat.getWearingLegs());
			dexTotal = dexTotal + legs.getDexterityBonus();
		}

		if (!userStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, userStat.getWearingNeck());
			dexTotal = dexTotal + neck.getDexterityBonus();
		}

		if (!userStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, userStat.getWearingRightArm());
			dexTotal = dexTotal + rightArm.getDexterityBonus();
		}

		if (!userStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, userStat.getWearingWaist());
			dexTotal = dexTotal + waist.getDexterityBonus();
		}

		if (!userStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, userStat.getLeftHand());
			dexTotal = dexTotal + leftHand.getDexterityBonus();
		}

		if (!userStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, userStat.getRightHand());
			dexTotal = dexTotal + rightHand.getDexterityBonus();
		}

		return dexTotal;
	}

	public int getIntelligenceTotal(){
		int intTotal;

		UserValue userStat = new UserValue(database, user);
		SubClassValue subClassStat = new SubClassValue(database, userStat.getUserClass(), userStat.getUserSubClass());
		ReligionLevelValue religion = new ReligionLevelValue(database, userStat.getReligion(), userStat.getReligionLvl());

		intTotal = userStat.getBaseIntelligence();
		intTotal = intTotal + subClassStat.getIntelligenceBonus();
		intTotal = intTotal + religion.getIntelligenceBonus();

		if (!userStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, userStat.getWearingChest());
			intTotal = intTotal + chest.getIntelligenceBonus();
		}

		if (!userStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, userStat.getWearingFeet());
			intTotal = intTotal + feet.getIntelligenceBonus();
		}

		if (!userStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, userStat.getWearingHands());
			intTotal = intTotal + hands.getIntelligenceBonus();
		}

		if (!userStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, userStat.getWearingHead());
			intTotal = intTotal + head.getIntelligenceBonus();
		}

		if (!userStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, userStat.getWearingLeftArm());
			intTotal = intTotal + leftArm.getIntelligenceBonus();
		}

		if (!userStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, userStat.getWearingLegs());
			intTotal = intTotal + legs.getIntelligenceBonus();
		}

		if (!userStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, userStat.getWearingNeck());
			intTotal = intTotal + neck.getIntelligenceBonus();
		}

		if (!userStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, userStat.getWearingRightArm());
			intTotal = intTotal + rightArm.getIntelligenceBonus();
		}

		if (!userStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, userStat.getWearingWaist());
			intTotal = intTotal + waist.getIntelligenceBonus();
		}

		if (!userStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, userStat.getLeftHand());
			intTotal = intTotal + leftHand.getIntelligenceBonus();
		}

		if (!userStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, userStat.getRightHand());
			intTotal = intTotal + rightHand.getIntelligenceBonus();
		}

		return intTotal;
	}

	public int getStrengthTotal(){
		int strTotal;

		UserValue userStat = new UserValue(database, user);
		SubClassValue subClassStat = new SubClassValue(database, userStat.getUserClass(), userStat.getUserSubClass());
		ReligionLevelValue religion = new ReligionLevelValue(database, userStat.getReligion(), userStat.getReligionLvl());

		strTotal = userStat.getBaseStrength();
		strTotal = strTotal + subClassStat.getStrengthBonus();
		strTotal = strTotal + religion.getStrengthBonus();

		if (!userStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, userStat.getWearingChest());
			strTotal = strTotal + chest.getStrengthBonus();
		}

		if (!userStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, userStat.getWearingFeet());
			strTotal = strTotal + feet.getStrengthBonus();
		}

		if (!userStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, userStat.getWearingHands());
			strTotal = strTotal + hands.getStrengthBonus();
		}

		if (!userStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, userStat.getWearingHead());
			strTotal = strTotal + head.getStrengthBonus();
		}

		if (!userStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, userStat.getWearingLeftArm());
			strTotal = strTotal + leftArm.getStrengthBonus();
		}

		if (!userStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, userStat.getWearingLegs());
			strTotal = strTotal + legs.getStrengthBonus();
		}

		if (!userStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, userStat.getWearingNeck());
			strTotal = strTotal + neck.getStrengthBonus();
		}

		if (!userStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, userStat.getWearingRightArm());
			strTotal = strTotal + rightArm.getStrengthBonus();
		}

		if (!userStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, userStat.getWearingWaist());
			strTotal = strTotal + waist.getStrengthBonus();
		}

		if (!userStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, userStat.getLeftHand());
			strTotal = strTotal + leftHand.getStrengthBonus();
		}

		if (!userStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, userStat.getRightHand());
			strTotal = strTotal + rightHand.getStrengthBonus();
		}

		return strTotal;
	}

	public int getWisdomTotal(){
		int wisTotal;

		UserValue userStat = new UserValue(database, user);
		SubClassValue subClassStat = new SubClassValue(database, userStat.getUserClass(), userStat.getUserSubClass());
		ReligionLevelValue religion = new ReligionLevelValue(database, userStat.getReligion(), userStat.getReligionLvl());

		wisTotal = userStat.getBaseWisdom();
		wisTotal = wisTotal + subClassStat.getWisdomBonus();
		wisTotal = wisTotal + religion.getWisdomBonus();

		if (!userStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, userStat.getWearingChest());
			wisTotal = wisTotal + chest.getWisdomBonus();
		}

		if (!userStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, userStat.getWearingFeet());
			wisTotal = wisTotal + feet.getWisdomBonus();
		}

		if (!userStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, userStat.getWearingHands());
			wisTotal = wisTotal + hands.getWisdomBonus();
		}

		if (!userStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, userStat.getWearingHead());
			wisTotal = wisTotal + head.getWisdomBonus();
		}

		if (!userStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, userStat.getWearingLeftArm());
			wisTotal = wisTotal + leftArm.getWisdomBonus();
		}

		if (!userStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, userStat.getWearingLegs());
			wisTotal = wisTotal + legs.getWisdomBonus();
		}

		if (!userStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, userStat.getWearingNeck());
			wisTotal = wisTotal + neck.getWisdomBonus();
		}

		if (!userStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, userStat.getWearingRightArm());
			wisTotal = wisTotal + rightArm.getWisdomBonus();
		}

		if (!userStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, userStat.getWearingWaist());
			wisTotal = wisTotal + waist.getWisdomBonus();
		}

		if (!userStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, userStat.getLeftHand());
			wisTotal = wisTotal + leftHand.getWisdomBonus();
		}

		if (!userStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, userStat.getRightHand());
			wisTotal = wisTotal + rightHand.getWisdomBonus();
		}

		return wisTotal;
	}

	public void getExperienceModifier(){
		//TODO
	}

	public int getAcidProtectionTotal(){
		float acidProtectionTotal;

		UserValue userStat = new UserValue(database, user);
		acidProtectionTotal = userStat.getBaseAcidProtection();

		if (!userStat.getUserClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, userStat.getUserClass() , userStat.getUserSubClass());
			acidProtectionTotal = acidProtectionTotal * (0.01f * subClassStat.getAcidProtectionModifier());
		}
		if (!userStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, userStat.getReligion(), userStat.getReligionLvl());
			acidProtectionTotal = acidProtectionTotal * (0.01f * religion.getAcidProtectionModifier());
		}

		if (!userStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, userStat.getWearingChest());
			acidProtectionTotal = acidProtectionTotal * (0.01f * chest.getAcidProtectionModifier());
		}

		if (!userStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, userStat.getWearingFeet());
			acidProtectionTotal = acidProtectionTotal * (0.01f * feet.getAcidProtectionModifier());
		}

		if (!userStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, userStat.getWearingHands());
			acidProtectionTotal = acidProtectionTotal * (0.01f * hands.getAcidProtectionModifier());
		}

		if (!userStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, userStat.getWearingHead());
			acidProtectionTotal = acidProtectionTotal * (0.01f * head.getAcidProtectionModifier());
		}

		if (!userStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, userStat.getWearingLeftArm());
			acidProtectionTotal = acidProtectionTotal * (0.01f * leftArm.getAcidProtectionModifier());
		}

		if (!userStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, userStat.getWearingLegs());
			acidProtectionTotal = acidProtectionTotal * (0.01f * legs.getAcidProtectionModifier());
		}

		if (!userStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, userStat.getWearingNeck());
			acidProtectionTotal = acidProtectionTotal * (0.01f * neck.getAcidProtectionModifier());
		}

		if (!userStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, userStat.getWearingRightArm());
			acidProtectionTotal = acidProtectionTotal * (0.01f * rightArm.getAcidProtectionModifier());
		}

		if (!userStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, userStat.getWearingWaist());
			acidProtectionTotal = acidProtectionTotal * (0.01f * waist.getAcidProtectionModifier());
		}

		if (!userStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, userStat.getLeftHand());
			acidProtectionTotal = acidProtectionTotal * (0.01f * leftHand.getAcidProtectionModifier());
		}

		if (!userStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, userStat.getRightHand());
			acidProtectionTotal = acidProtectionTotal * (0.01f * rightHand.getAcidProtectionModifier());
		}

		return Math.round(acidProtectionTotal);
	}

	public int getFireProtectionTotal(){
		float fireProtectionTotal;

		UserValue userStat = new UserValue(database, user);
		fireProtectionTotal = userStat.getBaseFireProtection();

		if (!userStat.getUserClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, userStat.getUserClass() , userStat.getUserSubClass());
			fireProtectionTotal = fireProtectionTotal * (0.01f * subClassStat.getFireProtectionModifier());
		}
		if (!userStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, userStat.getReligion(), userStat.getReligionLvl());
			fireProtectionTotal = fireProtectionTotal * (0.01f * religion.getFireProtectionModifier());
		}

		if (!userStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, userStat.getWearingChest());
			fireProtectionTotal = fireProtectionTotal * (0.01f * chest.getFireProtectionModifier());
		}

		if (!userStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, userStat.getWearingFeet());
			fireProtectionTotal = fireProtectionTotal * (0.01f * feet.getFireProtectionModifier());
		}

		if (!userStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, userStat.getWearingHands());
			fireProtectionTotal = fireProtectionTotal * (0.01f * hands.getFireProtectionModifier());
		}

		if (!userStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, userStat.getWearingHead());
			fireProtectionTotal = fireProtectionTotal * (0.01f * head.getFireProtectionModifier());
		}

		if (!userStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, userStat.getWearingLeftArm());
			fireProtectionTotal = fireProtectionTotal * (0.01f * leftArm.getFireProtectionModifier());
		}

		if (!userStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, userStat.getWearingLegs());
			fireProtectionTotal = fireProtectionTotal * (0.01f * legs.getFireProtectionModifier());
		}

		if (!userStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, userStat.getWearingNeck());
			fireProtectionTotal = fireProtectionTotal * (0.01f * neck.getFireProtectionModifier());
		}

		if (!userStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, userStat.getWearingRightArm());
			fireProtectionTotal = fireProtectionTotal * (0.01f * rightArm.getFireProtectionModifier());
		}

		if (!userStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, userStat.getWearingWaist());
			fireProtectionTotal = fireProtectionTotal * (0.01f * waist.getFireProtectionModifier());
		}

		if (!userStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, userStat.getLeftHand());
			fireProtectionTotal = fireProtectionTotal * (0.01f * leftHand.getFireProtectionModifier());
		}

		if (!userStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, userStat.getRightHand());
			fireProtectionTotal = fireProtectionTotal * (0.01f * rightHand.getFireProtectionModifier());
		}

		return Math.round(fireProtectionTotal);
	}

	public int getHitProtectionTotal(){
		float hitProtectionTotal;

		UserValue userStat = new UserValue(database, user);
		hitProtectionTotal = userStat.getBaseHitProtection();

		if (!userStat.getUserClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, userStat.getUserClass() , userStat.getUserSubClass());
			hitProtectionTotal = hitProtectionTotal * (0.01f * subClassStat.getHitProtectionModifier());
		}
		if (!userStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, userStat.getReligion(), userStat.getReligionLvl());
			hitProtectionTotal = hitProtectionTotal * (0.01f * religion.getHitProtectionModifier());
		}

		if (!userStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, userStat.getWearingChest());
			hitProtectionTotal = hitProtectionTotal * (0.01f * chest.getHitProtectionModifier());
		}

		if (!userStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, userStat.getWearingFeet());
			hitProtectionTotal = hitProtectionTotal * (0.01f * feet.getHitProtectionModifier());
		}

		if (!userStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, userStat.getWearingHands());
			hitProtectionTotal = hitProtectionTotal * (0.01f * hands.getHitProtectionModifier());
		}

		if (!userStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, userStat.getWearingHead());
			hitProtectionTotal = hitProtectionTotal * (0.01f * head.getHitProtectionModifier());
		}

		if (!userStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, userStat.getWearingLeftArm());
			hitProtectionTotal = hitProtectionTotal * (0.01f * leftArm.getHitProtectionModifier());
		}

		if (!userStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, userStat.getWearingLegs());
			hitProtectionTotal = hitProtectionTotal * (0.01f * legs.getHitProtectionModifier());
		}

		if (!userStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, userStat.getWearingNeck());
			hitProtectionTotal = hitProtectionTotal * (0.01f * neck.getHitProtectionModifier());
		}

		if (!userStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, userStat.getWearingRightArm());
			hitProtectionTotal = hitProtectionTotal * (0.01f * rightArm.getHitProtectionModifier());
		}

		if (!userStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, userStat.getWearingWaist());
			hitProtectionTotal = hitProtectionTotal * (0.01f * waist.getHitProtectionModifier());
		}

		if (!userStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, userStat.getLeftHand());
			hitProtectionTotal = hitProtectionTotal * (0.01f * leftHand.getHitProtectionModifier());
		}

		if (!userStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, userStat.getRightHand());
			hitProtectionTotal = hitProtectionTotal * (0.01f * rightHand.getHitProtectionModifier());
		}

		return Math.round(hitProtectionTotal);
	}

	public int getMagicProtectionTotal(){
		float magicProtectionTotal;

		UserValue userStat = new UserValue(database, user);
		magicProtectionTotal = userStat.getBaseMagicProtection();

		if (!userStat.getUserClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, userStat.getUserClass() , userStat.getUserSubClass());
			magicProtectionTotal = magicProtectionTotal * (0.01f * subClassStat.getMagicProtectionModifier());
		}
		if (!userStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, userStat.getReligion(), userStat.getReligionLvl());
			magicProtectionTotal = magicProtectionTotal * (0.01f * religion.getMagicProtectionModifier());
		}

		if (!userStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, userStat.getWearingChest());
			magicProtectionTotal = magicProtectionTotal * (0.01f * chest.getMagicProtectionModifier());
		}

		if (!userStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, userStat.getWearingFeet());
			magicProtectionTotal = magicProtectionTotal * (0.01f * feet.getMagicProtectionModifier());
		}

		if (!userStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, userStat.getWearingHands());
			magicProtectionTotal = magicProtectionTotal * (0.01f * hands.getMagicProtectionModifier());
		}

		if (!userStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, userStat.getWearingHead());
			magicProtectionTotal = magicProtectionTotal * (0.01f * head.getMagicProtectionModifier());
		}

		if (!userStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, userStat.getWearingLeftArm());
			magicProtectionTotal = magicProtectionTotal * (0.01f * leftArm.getMagicProtectionModifier());
		}

		if (!userStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, userStat.getWearingLegs());
			magicProtectionTotal = magicProtectionTotal * (0.01f * legs.getMagicProtectionModifier());
		}

		if (!userStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, userStat.getWearingNeck());
			magicProtectionTotal = magicProtectionTotal * (0.01f * neck.getMagicProtectionModifier());
		}

		if (!userStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, userStat.getWearingRightArm());
			magicProtectionTotal = magicProtectionTotal * (0.01f * rightArm.getMagicProtectionModifier());
		}

		if (!userStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, userStat.getWearingWaist());
			magicProtectionTotal = magicProtectionTotal * (0.01f * waist.getMagicProtectionModifier());
		}

		if (!userStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, userStat.getLeftHand());
			magicProtectionTotal = magicProtectionTotal * (0.01f * leftHand.getMagicProtectionModifier());
		}

		if (!userStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, userStat.getRightHand());
			magicProtectionTotal = magicProtectionTotal * (0.01f * rightHand.getMagicProtectionModifier());
		}

		return Math.round(magicProtectionTotal);
	}

	public int getPierceProtectionTotal(){
		float pierceProtectionTotal;

		UserValue userStat = new UserValue(database, user);
		pierceProtectionTotal = userStat.getBasePierceProtection();

		if (!userStat.getUserClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, userStat.getUserClass() , userStat.getUserSubClass());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * subClassStat.getPierceProtectionModifier());
		}
		if (!userStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, userStat.getReligion(), userStat.getReligionLvl());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * religion.getPierceProtectionModifier());
		}

		if (!userStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, userStat.getWearingChest());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * chest.getPierceProtectionModifier());
		}

		if (!userStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, userStat.getWearingFeet());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * feet.getPierceProtectionModifier());
		}

		if (!userStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, userStat.getWearingHands());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * hands.getPierceProtectionModifier());
		}

		if (!userStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, userStat.getWearingHead());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * head.getPierceProtectionModifier());
		}

		if (!userStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, userStat.getWearingLeftArm());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * leftArm.getPierceProtectionModifier());
		}

		if (!userStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, userStat.getWearingLegs());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * legs.getPierceProtectionModifier());
		}

		if (!userStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, userStat.getWearingNeck());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * neck.getPierceProtectionModifier());
		}

		if (!userStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, userStat.getWearingRightArm());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * rightArm.getPierceProtectionModifier());
		}

		if (!userStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, userStat.getWearingWaist());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * waist.getPierceProtectionModifier());
		}

		if (!userStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, userStat.getLeftHand());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * leftHand.getPierceProtectionModifier());
		}

		if (!userStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, userStat.getRightHand());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * rightHand.getPierceProtectionModifier());
		}
		return Math.round(pierceProtectionTotal);
	}

	public int getRangedProtectionTotal(){
		float rangedProtectionTotal;

		UserValue userStat = new UserValue(database, user);
		rangedProtectionTotal = userStat.getBaseRangedProtection();

		if (!userStat.getUserClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, userStat.getUserClass() , userStat.getUserSubClass());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * subClassStat.getRangedProtectionModifier());
		}
		if (!userStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, userStat.getReligion(), userStat.getReligionLvl());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * religion.getRangedProtectionModifier());
		}

		if (!userStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, userStat.getWearingChest());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * chest.getRangedProtectionModifier());
		}

		if (!userStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, userStat.getWearingFeet());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * feet.getRangedProtectionModifier());
		}

		if (!userStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, userStat.getWearingHands());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * hands.getRangedProtectionModifier());
		}

		if (!userStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, userStat.getWearingHead());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * head.getRangedProtectionModifier());
		}

		if (!userStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, userStat.getWearingLeftArm());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * leftArm.getRangedProtectionModifier());
		}

		if (!userStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, userStat.getWearingLegs());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * legs.getRangedProtectionModifier());
		}

		if (!userStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, userStat.getWearingNeck());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * neck.getRangedProtectionModifier());
		}

		if (!userStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, userStat.getWearingRightArm());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * rightArm.getRangedProtectionModifier());
		}

		if (!userStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, userStat.getWearingWaist());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * waist.getRangedProtectionModifier());
		}

		if (!userStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, userStat.getLeftHand());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * leftHand.getRangedProtectionModifier());
		}

		if (!userStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, userStat.getRightHand());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * rightHand.getRangedProtectionModifier());
		}
		return Math.round(rangedProtectionTotal);
	}
}
