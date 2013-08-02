package maltaProject;

import getValue.InstanceNPCValue;
import getValue.NPCValue;
import getValue.ObjectValue;
import getValue.ReligionLevelValue;
import getValue.SubClassValue;

/**
 * This class is responsible for calculating total values
 * for NPC's. Since objects can modify the npc's stats,
 * these must be applied to the npc's stats for the total
 * to be known.
 * 
 * @author Nicholas Ingalls
 */
public class NpcStatCalculator {

	String database = "";
	String instanceNPC = "";

	public NpcStatCalculator(String data, String instanceName){
		database = data;
		instanceNPC = instanceName;
	}

	public int getDexterityTotal(){
		int dexTotal;

		InstanceNPCValue instanceStat = new InstanceNPCValue(database, instanceNPC);
		NPCValue npcStat = new NPCValue(database, instanceStat.getReference());

		dexTotal = instanceStat.getDexterity();

		if (!npcStat.getNpcClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, npcStat.getNpcClass() , npcStat.getNpcSubClass());
			dexTotal = dexTotal + subClassStat.getDexterityBonus();
		}
		if (!npcStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, npcStat.getReligion(), npcStat.getReligionLvl());
			dexTotal = dexTotal + religion.getDexterityBonus();
		}


		if (!npcStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, npcStat.getWearingChest());
			dexTotal = dexTotal + chest.getDexterityBonus();
		}

		if (!npcStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, npcStat.getWearingFeet());
			dexTotal = dexTotal + feet.getDexterityBonus();
		}

		if (!npcStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, npcStat.getWearingHands());
			dexTotal = dexTotal + hands.getDexterityBonus();
		}

		if (!npcStat.getWearingHands().equals("none")){
			ObjectValue head = new ObjectValue(database, npcStat.getWearingHead());
			dexTotal = dexTotal + head.getDexterityBonus();
		}

		if (!npcStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, npcStat.getWearingLeftArm());
			dexTotal = dexTotal + leftArm.getDexterityBonus();
		}

		if (!npcStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, npcStat.getWearingLegs());
			dexTotal = dexTotal + legs.getDexterityBonus();
		}

		if (!npcStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, npcStat.getWearingNeck());
			dexTotal = dexTotal + neck.getDexterityBonus();
		}

		if (!npcStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, npcStat.getWearingRightArm());
			dexTotal = dexTotal + rightArm.getDexterityBonus();
		}

		if (!npcStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, npcStat.getWearingWaist());
			dexTotal = dexTotal + waist.getDexterityBonus();
		}

		if (!npcStat.getWearingWaist().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, npcStat.getLeftHand());
			dexTotal = dexTotal + leftHand.getDexterityBonus();
		}

		if (!npcStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, npcStat.getRightHand());
			dexTotal = dexTotal + rightHand.getDexterityBonus();
		}

		return dexTotal;
	}

	public int getIntelligenceTotal(){
		int intTotal;

		InstanceNPCValue instanceStat = new InstanceNPCValue(database, instanceNPC);
		NPCValue npcStat = new NPCValue(database, instanceStat.getReference());

		intTotal = instanceStat.getIntelligence();

		if (!npcStat.getNpcClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, npcStat.getNpcClass() , npcStat.getNpcSubClass());
			intTotal = intTotal + subClassStat.getIntelligenceBonus();
		}
		if (!npcStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, npcStat.getReligion(), npcStat.getReligionLvl());
			intTotal = intTotal + religion.getIntelligenceBonus();
		}


		if (!npcStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, npcStat.getWearingChest());
			intTotal = intTotal + chest.getIntelligenceBonus();
		}

		if (!npcStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, npcStat.getWearingFeet());
			intTotal = intTotal + feet.getIntelligenceBonus();
		}

		if (!npcStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, npcStat.getWearingHands());
			intTotal = intTotal + hands.getIntelligenceBonus();
		}

		if (!npcStat.getWearingHands().equals("none")){
			ObjectValue head = new ObjectValue(database, npcStat.getWearingHead());
			intTotal = intTotal + head.getIntelligenceBonus();
		}

		if (!npcStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, npcStat.getWearingLeftArm());
			intTotal = intTotal + leftArm.getIntelligenceBonus();
		}

		if (!npcStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, npcStat.getWearingLegs());
			intTotal = intTotal + legs.getIntelligenceBonus();
		}

		if (!npcStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, npcStat.getWearingNeck());
			intTotal = intTotal + neck.getIntelligenceBonus();
		}

		if (!npcStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, npcStat.getWearingRightArm());
			intTotal = intTotal + rightArm.getIntelligenceBonus();
		}

		if (!npcStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, npcStat.getWearingWaist());
			intTotal = intTotal + waist.getIntelligenceBonus();
		}

		if (!npcStat.getWearingWaist().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, npcStat.getLeftHand());
			intTotal = intTotal + leftHand.getIntelligenceBonus();
		}

		if (!npcStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, npcStat.getRightHand());
			intTotal = intTotal + rightHand.getIntelligenceBonus();
		}

		return intTotal;
	}

	public int getStrengthTotal(){
		int strTotal;

		InstanceNPCValue instanceStat = new InstanceNPCValue(database, instanceNPC);
		NPCValue npcStat = new NPCValue(database, instanceStat.getReference());

		strTotal = instanceStat.getStrength();

		if (!npcStat.getNpcClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, npcStat.getNpcClass() , npcStat.getNpcSubClass());
			strTotal = strTotal + subClassStat.getStrengthBonus();
		}
		if (!npcStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, npcStat.getReligion(), npcStat.getReligionLvl());
			strTotal = strTotal + religion.getStrengthBonus();
		}

		if (!npcStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, npcStat.getWearingChest());
			strTotal = strTotal + chest.getStrengthBonus();
		}

		if (!npcStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, npcStat.getWearingFeet());
			strTotal = strTotal + feet.getStrengthBonus();
		}

		if (!npcStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, npcStat.getWearingHands());
			strTotal = strTotal + hands.getStrengthBonus();
		}

		if (!npcStat.getWearingHands().equals("none")){
			ObjectValue head = new ObjectValue(database, npcStat.getWearingHead());
			strTotal = strTotal + head.getStrengthBonus();
		}

		if (!npcStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, npcStat.getWearingLeftArm());
			strTotal = strTotal + leftArm.getStrengthBonus();
		}

		if (!npcStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, npcStat.getWearingLegs());
			strTotal = strTotal + legs.getStrengthBonus();
		}

		if (!npcStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, npcStat.getWearingNeck());
			strTotal = strTotal + neck.getStrengthBonus();
		}

		if (!npcStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, npcStat.getWearingRightArm());
			strTotal = strTotal + rightArm.getStrengthBonus();
		}

		if (!npcStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, npcStat.getWearingWaist());
			strTotal = strTotal + waist.getStrengthBonus();
		}

		if (!npcStat.getWearingWaist().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, npcStat.getLeftHand());
			strTotal = strTotal + leftHand.getStrengthBonus();
		}

		if (!npcStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, npcStat.getRightHand());
			strTotal = strTotal + rightHand.getStrengthBonus();
		}

		return strTotal;
	}

	public int getWisdomTotal(){
		int wisTotal;

		InstanceNPCValue instanceStat = new InstanceNPCValue(database, instanceNPC);
		NPCValue npcStat = new NPCValue(database, instanceStat.getReference());

		wisTotal = instanceStat.getWisdom();

		if (!npcStat.getNpcClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, npcStat.getNpcClass() , npcStat.getNpcSubClass());
			wisTotal = wisTotal + subClassStat.getWisdomBonus();
		}
		if (!npcStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, npcStat.getReligion(), npcStat.getReligionLvl());
			wisTotal = wisTotal + religion.getWisdomBonus();
		}

		if (!npcStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, npcStat.getWearingChest());
			wisTotal = wisTotal + chest.getWisdomBonus();
		}

		if (!npcStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, npcStat.getWearingFeet());
			wisTotal = wisTotal + feet.getWisdomBonus();
		}

		if (!npcStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, npcStat.getWearingHands());
			wisTotal = wisTotal + hands.getWisdomBonus();
		}

		if (!npcStat.getWearingHands().equals("none")){
			ObjectValue head = new ObjectValue(database, npcStat.getWearingHead());
			wisTotal = wisTotal + head.getWisdomBonus();
		}

		if (!npcStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, npcStat.getWearingLeftArm());
			wisTotal = wisTotal + leftArm.getWisdomBonus();
		}

		if (!npcStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, npcStat.getWearingLegs());
			wisTotal = wisTotal + legs.getWisdomBonus();
		}

		if (!npcStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, npcStat.getWearingNeck());
			wisTotal = wisTotal + neck.getWisdomBonus();
		}

		if (!npcStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, npcStat.getWearingRightArm());
			wisTotal = wisTotal + rightArm.getWisdomBonus();
		}

		if (!npcStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, npcStat.getWearingWaist());
			wisTotal = wisTotal + waist.getWisdomBonus();
		}

		if (!npcStat.getWearingWaist().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, npcStat.getLeftHand());
			wisTotal = wisTotal + leftHand.getWisdomBonus();
		}

		if (!npcStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, npcStat.getRightHand());
			wisTotal = wisTotal + rightHand.getWisdomBonus();
		}
		return wisTotal;
	}

	public void getExperienceModifier(){
		//TODO
	}

	public int getAcidProtectionTotal(){
		float acidProtectionTotal;

		InstanceNPCValue instanceStat = new InstanceNPCValue(database, instanceNPC);
		NPCValue npcStat = new NPCValue(database, instanceStat.getReference());

		acidProtectionTotal = npcStat.getAcidProtection();

		if (!npcStat.getNpcClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, npcStat.getNpcClass() , npcStat.getNpcSubClass());
			acidProtectionTotal = acidProtectionTotal * (0.01f * subClassStat.getAcidProtectionModifier());
		}
		if (!npcStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, npcStat.getReligion(), npcStat.getReligionLvl());
			acidProtectionTotal = acidProtectionTotal * (0.01f * religion.getAcidProtectionModifier());
		}

		if (!npcStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, npcStat.getWearingChest());
			acidProtectionTotal = acidProtectionTotal * (0.01f * chest.getAcidProtectionModifier());
		}

		if (!npcStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, npcStat.getWearingFeet());
			acidProtectionTotal = acidProtectionTotal * (0.01f * feet.getAcidProtectionModifier());
		}

		if (!npcStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, npcStat.getWearingHands());
			acidProtectionTotal = acidProtectionTotal * (0.01f * hands.getAcidProtectionModifier());
		}

		if (!npcStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, npcStat.getWearingHead());
			acidProtectionTotal = acidProtectionTotal * (0.01f * head.getAcidProtectionModifier());
		}

		if (!npcStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, npcStat.getWearingLeftArm());
			acidProtectionTotal = acidProtectionTotal * (0.01f * leftArm.getAcidProtectionModifier());
		}

		if (!npcStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, npcStat.getWearingLegs());
			acidProtectionTotal = acidProtectionTotal * (0.01f * legs.getAcidProtectionModifier());
		}

		if (!npcStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, npcStat.getWearingNeck());
			acidProtectionTotal = acidProtectionTotal * (0.01f * neck.getAcidProtectionModifier());
		}

		if (!npcStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, npcStat.getWearingRightArm());
			acidProtectionTotal = acidProtectionTotal * (0.01f * rightArm.getAcidProtectionModifier());
		}

		if (!npcStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, npcStat.getWearingWaist());
			acidProtectionTotal = acidProtectionTotal * (0.01f * waist.getAcidProtectionModifier());
		}

		if (!npcStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, npcStat.getLeftHand());
			acidProtectionTotal = acidProtectionTotal * (0.01f * leftHand.getAcidProtectionModifier());
		}

		if (!npcStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, npcStat.getRightHand());
			acidProtectionTotal = acidProtectionTotal * (0.01f * rightHand.getAcidProtectionModifier());
		}

		return Math.round(acidProtectionTotal);
	}

	public int getFireProtectionTotal(){
		float fireProtectionTotal;

		InstanceNPCValue instanceStat = new InstanceNPCValue(database, instanceNPC);
		NPCValue npcStat = new NPCValue(database, instanceStat.getReference());

		fireProtectionTotal = npcStat.getFireProtection();

		if (!npcStat.getNpcClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, npcStat.getNpcClass() , npcStat.getNpcSubClass());
			fireProtectionTotal = fireProtectionTotal * (0.01f * subClassStat.getFireProtectionModifier());
		}
		if (!npcStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, npcStat.getReligion(), npcStat.getReligionLvl());
			fireProtectionTotal = fireProtectionTotal * (0.01f * religion.getFireProtectionModifier());
		}

		if (!npcStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, npcStat.getWearingChest());
			fireProtectionTotal = fireProtectionTotal * (0.01f * chest.getFireProtectionModifier());
		}

		if (!npcStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, npcStat.getWearingFeet());
			fireProtectionTotal = fireProtectionTotal * (0.01f * feet.getFireProtectionModifier());
		}

		if (!npcStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, npcStat.getWearingHands());
			fireProtectionTotal = fireProtectionTotal * (0.01f * hands.getFireProtectionModifier());
		}

		if (!npcStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, npcStat.getWearingHead());
			fireProtectionTotal = fireProtectionTotal * (0.01f * head.getFireProtectionModifier());
		}

		if (!npcStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, npcStat.getWearingLeftArm());
			fireProtectionTotal = fireProtectionTotal * (0.01f * leftArm.getFireProtectionModifier());
		}

		if (!npcStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, npcStat.getWearingLegs());
			fireProtectionTotal = fireProtectionTotal * (0.01f * legs.getFireProtectionModifier());
		}

		if (!npcStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, npcStat.getWearingNeck());
			fireProtectionTotal = fireProtectionTotal * (0.01f * neck.getFireProtectionModifier());
		}

		if (!npcStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, npcStat.getWearingRightArm());
			fireProtectionTotal = fireProtectionTotal * (0.01f * rightArm.getFireProtectionModifier());
		}

		if (!npcStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, npcStat.getWearingWaist());
			fireProtectionTotal = fireProtectionTotal * (0.01f * waist.getFireProtectionModifier());
		}

		if (!npcStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, npcStat.getLeftHand());
			fireProtectionTotal = fireProtectionTotal * (0.01f * leftHand.getFireProtectionModifier());
		}

		if (!npcStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, npcStat.getRightHand());
			fireProtectionTotal = fireProtectionTotal * (0.01f * rightHand.getFireProtectionModifier());
		}

		return Math.round(fireProtectionTotal);
	}

	public int getHitProtectionTotal(){
		float hitProtectionTotal;

		InstanceNPCValue instanceStat = new InstanceNPCValue(database, instanceNPC);
		NPCValue npcStat = new NPCValue(database, instanceStat.getReference());

		hitProtectionTotal = npcStat.getHitProtection();

		if (!npcStat.getNpcClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, npcStat.getNpcClass() , npcStat.getNpcSubClass());
			hitProtectionTotal = hitProtectionTotal * (0.01f * subClassStat.getHitProtectionModifier());
		}
		if (!npcStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, npcStat.getReligion(), npcStat.getReligionLvl());
			hitProtectionTotal = hitProtectionTotal * (0.01f * religion.getHitProtectionModifier());
		}

		if (!npcStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, npcStat.getWearingChest());
			hitProtectionTotal = hitProtectionTotal * (0.01f * chest.getHitProtectionModifier());
		}

		if (!npcStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, npcStat.getWearingFeet());
			hitProtectionTotal = hitProtectionTotal * (0.01f * feet.getHitProtectionModifier());
		}

		if (!npcStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, npcStat.getWearingHands());
			hitProtectionTotal = hitProtectionTotal * (0.01f * hands.getHitProtectionModifier());
		}

		if (!npcStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, npcStat.getWearingHead());
			hitProtectionTotal = hitProtectionTotal * (0.01f * head.getHitProtectionModifier());
		}

		if (!npcStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, npcStat.getWearingLeftArm());
			hitProtectionTotal = hitProtectionTotal * (0.01f * leftArm.getHitProtectionModifier());
		}

		if (!npcStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, npcStat.getWearingLegs());
			hitProtectionTotal = hitProtectionTotal * (0.01f * legs.getHitProtectionModifier());
		}

		if (!npcStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, npcStat.getWearingNeck());
			hitProtectionTotal = hitProtectionTotal * (0.01f * neck.getHitProtectionModifier());
		}

		if (!npcStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, npcStat.getWearingRightArm());
			hitProtectionTotal = hitProtectionTotal * (0.01f * rightArm.getHitProtectionModifier());
		}

		if (!npcStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, npcStat.getWearingWaist());
			hitProtectionTotal = hitProtectionTotal * (0.01f * waist.getHitProtectionModifier());
		}

		if (!npcStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, npcStat.getLeftHand());
			hitProtectionTotal = hitProtectionTotal * (0.01f * leftHand.getHitProtectionModifier());
		}

		if (!npcStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, npcStat.getRightHand());
			hitProtectionTotal = hitProtectionTotal * (0.01f * rightHand.getHitProtectionModifier());
		}

		return Math.round(hitProtectionTotal);
	}

	public int getMagicProtectionTotal(){
		float magicProtectionTotal;

		InstanceNPCValue instanceStat = new InstanceNPCValue(database, instanceNPC);
		NPCValue npcStat = new NPCValue(database, instanceStat.getReference());

		magicProtectionTotal = npcStat.getMagicProtection();

		if (!npcStat.getNpcClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, npcStat.getNpcClass() , npcStat.getNpcSubClass());
			magicProtectionTotal = magicProtectionTotal * (0.01f * subClassStat.getMagicProtectionModifier());
		}
		if (!npcStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, npcStat.getReligion(), npcStat.getReligionLvl());
			magicProtectionTotal = magicProtectionTotal * (0.01f * religion.getMagicProtectionModifier());
		}

		if (!npcStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, npcStat.getWearingChest());
			magicProtectionTotal = magicProtectionTotal * (0.01f * chest.getMagicProtectionModifier());
		}

		if (!npcStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, npcStat.getWearingFeet());
			magicProtectionTotal = magicProtectionTotal * (0.01f * feet.getMagicProtectionModifier());
		}

		if (!npcStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, npcStat.getWearingHands());
			magicProtectionTotal = magicProtectionTotal * (0.01f * hands.getMagicProtectionModifier());
		}

		if (!npcStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, npcStat.getWearingHead());
			magicProtectionTotal = magicProtectionTotal * (0.01f * head.getMagicProtectionModifier());
		}

		if (!npcStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, npcStat.getWearingLeftArm());
			magicProtectionTotal = magicProtectionTotal * (0.01f * leftArm.getMagicProtectionModifier());
		}

		if (!npcStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, npcStat.getWearingLegs());
			magicProtectionTotal = magicProtectionTotal * (0.01f * legs.getMagicProtectionModifier());
		}

		if (!npcStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, npcStat.getWearingNeck());
			magicProtectionTotal = magicProtectionTotal * (0.01f * neck.getMagicProtectionModifier());
		}

		if (!npcStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, npcStat.getWearingRightArm());
			magicProtectionTotal = magicProtectionTotal * (0.01f * rightArm.getMagicProtectionModifier());
		}

		if (!npcStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, npcStat.getWearingWaist());
			magicProtectionTotal = magicProtectionTotal * (0.01f * waist.getMagicProtectionModifier());
		}

		if (!npcStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, npcStat.getLeftHand());
			magicProtectionTotal = magicProtectionTotal * (0.01f * leftHand.getMagicProtectionModifier());
		}

		if (!npcStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, npcStat.getRightHand());
			magicProtectionTotal = magicProtectionTotal * (0.01f * rightHand.getMagicProtectionModifier());
		}

		return Math.round(magicProtectionTotal);
	}

	public int getPierceProtectionTotal(){
		float pierceProtectionTotal;

		InstanceNPCValue instanceStat = new InstanceNPCValue(database, instanceNPC);
		NPCValue npcStat = new NPCValue(database, instanceStat.getReference());

		pierceProtectionTotal = npcStat.getPierceProtection();

		if (!npcStat.getNpcClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, npcStat.getNpcClass() , npcStat.getNpcSubClass());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * subClassStat.getPierceProtectionModifier());
		}
		if (!npcStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, npcStat.getReligion(), npcStat.getReligionLvl());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * religion.getPierceProtectionModifier());
		}

		if (!npcStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, npcStat.getWearingChest());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * chest.getPierceProtectionModifier());
		}

		if (!npcStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, npcStat.getWearingFeet());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * feet.getPierceProtectionModifier());
		}

		if (!npcStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, npcStat.getWearingHands());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * hands.getPierceProtectionModifier());
		}

		if (!npcStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, npcStat.getWearingHead());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * head.getPierceProtectionModifier());
		}

		if (!npcStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, npcStat.getWearingLeftArm());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * leftArm.getPierceProtectionModifier());
		}

		if (!npcStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, npcStat.getWearingLegs());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * legs.getPierceProtectionModifier());
		}

		if (!npcStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, npcStat.getWearingNeck());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * neck.getPierceProtectionModifier());
		}

		if (!npcStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, npcStat.getWearingRightArm());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * rightArm.getPierceProtectionModifier());
		}

		if (!npcStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, npcStat.getWearingWaist());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * waist.getPierceProtectionModifier());
		}

		if (!npcStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, npcStat.getLeftHand());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * leftHand.getPierceProtectionModifier());
		}

		if (!npcStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, npcStat.getRightHand());
			pierceProtectionTotal = pierceProtectionTotal * (0.01f * rightHand.getPierceProtectionModifier());
		}

		return Math.round(pierceProtectionTotal);
	}

	public int getRangedProtectionTotal(){
		float rangedProtectionTotal;

		InstanceNPCValue instanceStat = new InstanceNPCValue(database, instanceNPC);
		NPCValue npcStat = new NPCValue(database, instanceStat.getReference());

		rangedProtectionTotal = npcStat.getRangedProtection();

		if (!npcStat.getNpcClass().equals("none")){
			SubClassValue subClassStat = new SubClassValue(database, npcStat.getNpcClass() , npcStat.getNpcSubClass());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * subClassStat.getRangedProtectionModifier());
		}
		if (!npcStat.getReligion().equals("none")){
			ReligionLevelValue religion = new ReligionLevelValue(database, npcStat.getReligion(), npcStat.getReligionLvl());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * religion.getRangedProtectionModifier());
		}

		if (!npcStat.getWearingChest().equals("none")){
			ObjectValue chest = new ObjectValue(database, npcStat.getWearingChest());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * chest.getRangedProtectionModifier());
		}

		if (!npcStat.getWearingFeet().equals("none")){
			ObjectValue feet = new ObjectValue(database, npcStat.getWearingFeet());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * feet.getRangedProtectionModifier());
		}

		if (!npcStat.getWearingHands().equals("none")){
			ObjectValue hands = new ObjectValue(database, npcStat.getWearingHands());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * hands.getRangedProtectionModifier());
		}

		if (!npcStat.getWearingHead().equals("none")){
			ObjectValue head = new ObjectValue(database, npcStat.getWearingHead());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * head.getRangedProtectionModifier());
		}

		if (!npcStat.getWearingLeftArm().equals("none")){
			ObjectValue leftArm = new ObjectValue(database, npcStat.getWearingLeftArm());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * leftArm.getRangedProtectionModifier());
		}

		if (!npcStat.getWearingLegs().equals("none")){
			ObjectValue legs = new ObjectValue(database, npcStat.getWearingLegs());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * legs.getRangedProtectionModifier());
		}

		if (!npcStat.getWearingNeck().equals("none")){
			ObjectValue neck = new ObjectValue(database, npcStat.getWearingNeck());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * neck.getRangedProtectionModifier());
		}

		if (!npcStat.getWearingRightArm().equals("none")){
			ObjectValue rightArm = new ObjectValue(database, npcStat.getWearingRightArm());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * rightArm.getRangedProtectionModifier());
		}

		if (!npcStat.getWearingWaist().equals("none")){
			ObjectValue waist = new ObjectValue(database, npcStat.getWearingWaist());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * waist.getRangedProtectionModifier());
		}

		if (!npcStat.getLeftHand().equals("none")){
			ObjectValue leftHand = new ObjectValue(database, npcStat.getLeftHand());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * leftHand.getRangedProtectionModifier());
		}

		if (!npcStat.getRightHand().equals("none")){
			ObjectValue rightHand = new ObjectValue(database, npcStat.getRightHand());
			rangedProtectionTotal = rangedProtectionTotal * (0.01f * rightHand.getRangedProtectionModifier());
		}
		return Math.round(rangedProtectionTotal);
	}
}
