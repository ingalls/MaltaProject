package userOperations;

import getValue.UserValue;

import java.net.Socket;

public class Wizard {
	//TODO wizard is currently the only mod level created (create builder/immortal)

	/*
	 * Notes:
	 * A wizard has full access to every command
	 * A builder has full access to any creation commands but cannot affect user's directly
	 * An immortal can perform basic user modification
	 */

	boolean wizard = false;
	boolean builder = false;
	boolean immortal = false;
	Socket socket;
	String database;

	public Wizard(Socket s, String data, String user){
		database = data;
		UserValue UV = new UserValue(database, user);
		socket = s;

		wizard = UV.isWizard();
	}

	/**
	 * Allows an immortal to advance a user a certain number of levels
	 * @param user The name of the user
	 * @param level the number of levels to advance the user
	 */
	public void advance(String user, int level){

		UserValue UV = new UserValue(database, user);
		UV.setLvl(UV.getLvl() + level);
	}

	/**
	 * Allows an immortal to perform actions in a different location than where the immortal is.
	 * @param location The room name where the action will be performed
	 * @param command The command that will be performed
	 */
	public void wizat(String location, String command){
		//TODO
	}

	/**
	 * Prints the real time & game time date
	 */
	public void date(){
		//TODO
	}

	/**
	 * Forcibly disconnects a user
	 * @param user Name of user
	 */
	public void disconnect(String user){
		//TODO
	}

	/**
	 * Allows the imm to send a global message. Highlighted in yellow
	 * This gives more prominence to a message than OOC or IC.
	 * @param Line The string that will be sent to players
	 */
	public void imm(String Line){
		//TODO
	}

	/**
	 * Forces a user or an NPC to perform a certain action
	 * @param user The name of the user or NPC
	 * @param command The action to be performed
	 */
	public void force(String user, String command){
		//TODO
	}

	/**
	 * Freezes a user so that they are unable to perform any actions until they are thawed.
	 * @param user The name of the user to freeze
	 */
	public void freeze(String user){
		//TODO
	}

	/**
	 * Thaws a user so that they can continue playing.
	 * @param user The name of the user to thaw
	 */
	public void thaw(String user){
		//TODO
	}

	/**
	 * Transports you to a given location
	 * @param location The location to be transported to
	 */
	public void goTo(String location){
		//TODO
	}

	/**
	 * Transports you to a specific user
	 * @param user
	 */
	public void goToUser(String user){
		//TODO
	}

	/**
	 * Transports a user to your location
	 * @param user The user to bring to you
	 */
	public void trans(String user){
		//TODO
	}

	/**
	 * Allows you to move a user to a given room
	 * @param user The user to teleport
	 * @param location The location to send a user
	 */
	public void teleport(String user, String location){
		//TODO
	}

	/**
	 * Toggles goldeneyes. This is the ability to see invisible objects, no matter their level of
	 * expertise, see invisible people, and be able to see in the dark
	 * @param on
	 */
	public void goldeneyes(boolean on){
		//TODO
	}

	/**
	 * Check the last time that a user has logged in
	 * @param user The name of the user
	 */
	public void last(String user){
		//TODO
	}

	/**
	 * Allows an immortal to create NPCs and objects in the room that they are in.
	 * @param type Whether it is an NPC or an object. (npc/obj)
	 * @param name The name of the object or NPC to create
	 */
	public void create(String type, String name){
		//TODO
	}

	/**
	 * Shuts a player up. The player will still be able to OPRAY to immortals
	 * @param username The name of the user
	 */
	public void mute(String user){
		//TODO
	}

	/**
	 * Allows a player to chat again.
	 * @param user The name of the user
	 */
	public void unmute(String user){
		//TODO
	}

	/**
	 * Setting to change the text displayed when an immortal gotos to a room
	 * @param text New text to display
	 */
	public void gotoIn(String text){
		//TODO
	}

	/**
	 * Setting to change the text displayed when an immortal gotos out of a room
	 * @param text New text to display
	 */
	public void gotoOut(String text){
		//TODO
	}

	/**
	 * 'purge <user>' will make the player
	 * drop everything in their inventory and then be reset back to the start
	 * location of the game
	 * @param name Either 'room' or the name of a user
	 */
	public void purgeUser(String name){
		//TODO
	}

	/**
	 * Purge will delete NPCs and Objects from a room. Command 'purge room'
	 * Purge can also remove players.
	 * @param name Either 'room' or the name of a user
	 */
	public void purgeRoom(String location){

	}

	/**
	 * Randomizes the Str, Int, Dex, etc. of a player.
	 * These stats are randomly generated when a player is created.
	 * This command will regenerate the base stats
	 * @param username Name of the user
	 */
	public void reCast(String username){
		//TODO
	}

	/**
	 * Returns a user to full health, mana, and move points.
	 * @param username The name of the user
	 */
	public void healingLight(String username){
		UserValue UV = new UserValue(database, username);
		UV.setHP(UV.getMaxHealth());
		UV.setMana(UV.getMaxMana());
		//TODO movepoints

	}

	/**
	 * Shows any number of stats. NPCs in rooms, room names, user stats, etc.
	 * @param command The object to get stats on
	 */
	public void show(String command){

	}

	/**
	 * Shuts the server down
	 */
	public void shutdown(){

	}

	/**
	 * Allows an immortal to see everything that a user types.
	 * @param user The name of the user
	 */
	public void snoop(String user){

	}

	/**
	 * Stops all snooping
	 */
	public void stopSnoop(){

	}

	/**
	 * Allows an immortal to control a mob
	 * @param npc The name of the NPC to control
	 */
	public void mindMeld(String npc){

	}
}
