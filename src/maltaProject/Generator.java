package maltaProject;

import getValue.AreaValue;
import getValue.InstanceNPCValue;
import getValue.NPCValue;
import getValue.RoomValue;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;

public class Generator {

	String database = "";

	public Generator(String data){
		database = data;
	}

	public void generateNPC(String room, String NPC){

		System.out.println("[Generator] Regenerating:" + NPC + " in " + room);

		int num = 0;
		String instanceNPC = "";

		//Find free instanceNPC name
		File f;
		do {
			num++;
			instanceNPC = NPC + "-" + num;
			f = new File(database + "/instanceNPC/" + instanceNPC);
		} while (f.exists());

		f.mkdirs();

		InstanceNPCValue iNPC = new InstanceNPCValue(database, instanceNPC);
		NPCValue NPCV = new NPCValue(database, NPC);

		Random generator = new Random();

		if (NPCV.getMaxAge() != NPCV.getMinAge()){
			iNPC.setAge(generator.nextInt(NPCV.getMaxAge() - NPCV.getMinAge()) + NPCV.getMinAge());
		} else {
			iNPC.setAge(NPCV.getMaxAge());
		}
		if (NPCV.getMaxDexterity() != NPCV.getMinDexterity()){
			iNPC.setDexterity(generator.nextInt(NPCV.getMaxDexterity() - NPCV.getMinDexterity()) + NPCV.getMinDexterity());
		} else {
			iNPC.setDexterity(NPCV.getMaxDexterity());
		}
		if (NPCV.getMaxGold() != NPCV.getMinGold()){
			iNPC.setGold(generator.nextInt(NPCV.getMaxGold() - NPCV.getMinGold()) + NPCV.getMinGold());
		} else {
			iNPC.setGold(NPCV.getMaxGold());
		}
		if (NPCV.getMaxHealth() != NPCV.getMinHealth()){
			iNPC.setHP(generator.nextInt(NPCV.getMaxHealth() - NPCV.getMinHealth()) + NPCV.getMinHealth());
		} else {
			iNPC.setHP(NPCV.getMaxHealth());
		}
		if (NPCV.getMaxIntelligence() != NPCV.getMinIntelligence()){
			iNPC.setIntelligence(generator.nextInt(NPCV.getMaxIntelligence() - NPCV.getMinIntelligence()) + NPCV.getMinIntelligence());
		} else {
			iNPC.setIntelligence(NPCV.getMaxIntelligence());
		}
		if (NPCV.getMaxStrength() != NPCV.getMinStrength()){
			iNPC.setStrength(generator.nextInt(NPCV.getMaxStrength() - NPCV.getMinStrength()) + NPCV.getMinStrength());
		} else {
			iNPC.setStrength(NPCV.getMaxStrength());
		}
		if (NPCV.getMaxWeight() != NPCV.getMinWeight()){
			iNPC.setWeight(generator.nextInt(NPCV.getMaxWeight() - NPCV.getMinWeight()) + NPCV.getMinStrength());
		} else {
			iNPC.setWeight(NPCV.getMaxWeight());
		}
		if (NPCV.getMaxWisdom() != NPCV.getMinWisom()){
			iNPC.setWisdom(generator.nextInt(NPCV.getMaxWisdom() - NPCV.getMinWisom()) + NPCV.getMinWisom());
		} else {
			iNPC.setWisdom(NPCV.getMaxWisdom());
		}
		iNPC.setLevel(NPCV.getLevel());
		iNPC.setOrigin(room);
		iNPC.setReference(NPC);
		iNPC.setSex(NPCV.getSex());
		iNPC.setXP(0);

		RoomValue RV = new RoomValue(database, room);
		RV.setNewNPC(instanceNPC);
	}

	public void generateAllNPC(){
		FileOperations FO = new FileOperations(database + "/rooms/");
		String[] areaList = FO.getDirectoryFolders();

		//Remove old instanceNPCs
		File f = new File(database + "/instanceNPC");
		try {
			System.out.println("[Generator] Wiping old instanceNPCs");
			FileUtils.deleteDirectory(f);
		} catch (IOException e) {
			System.out.println("Could not remove instanceNPCs");
			System.exit(0);
		}
		f.mkdir();

		//Remove old instanceNPC creation Stack
		File f2 = new File(database + "/gamekeeper/regenNPC/");
		try {
			System.out.println("[Generator] Wiping old instanceNPC stack");
			FileUtils.deleteDirectory(f2);
		} catch (IOException e) {
			System.out.println("Could not remove instanceNPC stack");
			System.exit(0);
		}
		f2.mkdir();

		int areaParser = 0;

		if (areaList != null){
			while (areaParser <= areaList.length - 1){
				AreaValue AV = new AreaValue(database, areaList[areaParser]);

				String[] roomList = AV.getRoomList();
				int roomParser = 0;

				if (roomList != null){
					while (roomParser <= roomList.length - 1){
						RoomValue RV = new RoomValue(database, areaList[areaParser] + "/" + roomList[roomParser]);

						String[] npcList = RV.getNPC();
						int npcParser = 0;

						//Remove old instanceNPC's
						if (npcList != null){
							while (npcParser <= npcList.length - 1){
								RV.deleteNPC(npcList[npcParser]);

								npcParser++;
							}
						}

						npcList = RV.getDefaultNPCs();
						npcParser = 0;

						//Regenerate instanceNPC's
						if (npcList != null){
							while(npcParser <= npcList.length - 1){
								int numParser = 1;
								int totalNPC = RV.getDefaultNPC(npcList[npcParser]);

								while (numParser <= totalNPC){
									generateNPC(areaList[areaParser] + "/" + roomList[roomParser], npcList[npcParser]);
									numParser++;
								}

								npcParser++;
							}
						}

						roomParser++;
					}
				}

				areaParser++;
			}
		}
	}
}
