package commands;

import getValue.InstanceNPCValue;
import getValue.NPCValue;
import getValue.ObjectValue;
import getValue.UserValue;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

import maltaProject.NpcStatCalculator;
import maltaProject.UserStatCalculator;
import userInterface.setColor;

public class FightCommands {

	String database;

	Socket socket;

	String user;


	public FightCommands(Socket s, String data, String userName){
		database = data;
		user = userName;
		socket = s;
	}

	public void fightNPC(String user, String victim){
		InstanceNPCValue inpcStat = new InstanceNPCValue(database, victim);
		NPCValue npcStat = new NPCValue(database, inpcStat.getReference());

		UserValue userStat = new UserValue(database, user);

		UserStatCalculator USC = new UserStatCalculator(database, user);
		NpcStatCalculator NSC = new NpcStatCalculator(database, victim);

		Random generator = new Random();

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream for MovementCommands");
		}

		String npcWeaponDamageDesc;
		int npcWeaponDamage;
		if (!npcStat.getRightHand().equals("none")){
			ObjectValue npcWeapon = new ObjectValue(database, npcStat.getRightHand());

			if (npcWeapon.getMaxDamage() != npcWeapon.getMinDamage()){
				npcWeaponDamage = generator.nextInt(npcWeapon.getMaxDamage() - npcWeapon.getMinDamage()) + npcWeapon.getMinDamage();
			} else {
				npcWeaponDamage = npcWeapon.getMaxDamage();
			}

			String npcWeaponType = npcWeapon.getWeaponType();
			if (npcWeaponType.equals("acid")){
				npcWeaponDamage = npcWeaponDamage - USC.getAcidProtectionTotal();
			} else if (npcWeaponType.equals("fire")){
				npcWeaponDamage = npcWeaponDamage - USC.getFireProtectionTotal();
			} else if (npcWeaponType.equals("hit")){
				npcWeaponDamage = npcWeaponDamage - USC.getHitProtectionTotal();
			} else if (npcWeaponType.equals("magic")){
				npcWeaponDamage = npcWeaponDamage - USC.getMagicProtectionTotal();
			} else if (npcWeaponType.equals("pierce")){
				npcWeaponDamage = npcWeaponDamage - USC.getPierceProtectionTotal();
			} else if (npcWeaponType.equals("ranged")){
				npcWeaponDamage = npcWeaponDamage - USC.getRangedProtectionTotal();
			}

			//Calculates what damage description should be output
			if (npcWeaponDamage <= npcWeapon.getMinDamage() + ((npcWeapon.getMaxDamage() - npcWeapon.getMinDamage()) * 1/3)){
				//Minimum Damage
				npcWeaponDamageDesc = npcWeapon.getMinDamageDesc();
			} else if (npcWeaponDamage <= npcWeapon.getMinDamage() + ((npcWeapon.getMaxDamage() - npcWeapon.getMinDamage()) * 1/3) * 2){
				//Medium Damage
				npcWeaponDamageDesc = npcWeapon.getMedDamageDesc();
			} else {
				//Maximum Damage
				npcWeaponDamageDesc = npcWeapon.getMaxDamageDesc();
			}
		} else {
			//Fight with fists
			npcWeaponDamage = generator.nextInt(50);
			npcWeaponDamage = npcWeaponDamage - USC.getHitProtectionTotal();
			npcWeaponDamageDesc = "A fist lashes out and hits you";
		}

		if (npcWeaponDamage < 0){
			npcWeaponDamage = 0;
		}

		String userWeaponDamageDesc;
		int userWeaponDamage;
		if (!userStat.getRightHand().equals("none")){
			ObjectValue userWeapon = new ObjectValue(database, userStat.getRightHand());

			if (userWeapon.getMaxDamage() != userWeapon.getMinDamage()){
				userWeaponDamage = generator.nextInt(userWeapon.getMaxDamage() - userWeapon.getMinDamage()) + userWeapon.getMinDamage();
			} else {
				userWeaponDamage = userWeapon.getMaxDamage();
			}

			String userWeaponType = userWeapon.getWeaponType();
			if (userWeaponType.equals("acid")){
				userWeaponDamage = userWeaponDamage - NSC.getAcidProtectionTotal() * (generator.nextInt(3) + 1);
			} else if (userWeaponType.equals("fire")){
				userWeaponDamage = userWeaponDamage - NSC.getFireProtectionTotal() * (generator.nextInt(3) + 1);
			} else if (userWeaponType.equals("hit")){
				userWeaponDamage = userWeaponDamage - NSC.getHitProtectionTotal() * (generator.nextInt(3) + 1);
			} else if (userWeaponType.equals("magic")){
				userWeaponDamage = userWeaponDamage - NSC.getMagicProtectionTotal() * (generator.nextInt(3) + 1);
			} else if (userWeaponType.equals("pierce")){
				userWeaponDamage = userWeaponDamage - NSC.getPierceProtectionTotal() * (generator.nextInt(3) + 1);
			} else if (userWeaponType.equals("ranged")){
				userWeaponDamage = userWeaponDamage - NSC.getRangedProtectionTotal() * (generator.nextInt(3) + 1);
			}

			//Calculates what damage description should be output
			if (userWeaponDamage <= userWeapon.getMinDamage() + ((userWeapon.getMaxDamage() - userWeapon.getMinDamage()) * 1/3)){
				//Minimum Damage
				userWeaponDamageDesc = userWeapon.getMinDamageDesc();
			} else if (userWeaponDamage <= userWeapon.getMinDamage() + ((userWeapon.getMaxDamage() - userWeapon.getMinDamage()) * 1/3) * 2){
				//Medium Damage
				userWeaponDamageDesc = userWeapon.getMedDamageDesc();
			} else {
				//Maximum Damage
				userWeaponDamageDesc = userWeapon.getMaxDamageDesc();
			}
		} else {
			//Fight with fists
			userWeaponDamage = generator.nextInt(50);
			userWeaponDamage = userWeaponDamage - NSC.getHitProtectionTotal();
			userWeaponDamageDesc = "A fist lashes out and hits you";
		}

		if (userWeaponDamage < 0){
			userWeaponDamage = 0;
		}

		boolean userFirst = false;
		if (generator.nextInt(USC.getDexterityTotal() * userStat.getLevel()) >= generator.nextInt(NSC.getDexterityTotal() * npcStat.getLevel())){
			userFirst = true;
		}

		setColor SC = new setColor();
		out.println(SC.color("USER lost:" + userWeaponDamage + " : " + npcWeaponDamageDesc));
		out.println(SC.color("NPC lost:" + npcWeaponDamage + " : " + userWeaponDamageDesc));

	}
	public void cast(){

	}
}
