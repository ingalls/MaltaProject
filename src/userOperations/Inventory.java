package userOperations;

import getValue.RoomValue;
import getValue.UserValue;


public class Inventory {

	String loc;
	String userName;

	public Inventory (String database, String user){
		loc = database;
		userName = user;
	}

	/**
	 * Drops items from the user's inventory
	 * @param item A string containing a part or the entire name of the item to drop
	 * @param dropNum Number of the specified item to drop
	 * @param room Name of the room to drop the items into
	 */
	public boolean drop (String item, int dropNum, String room){
		UserValue UserValue = new UserValue(loc, userName);

		boolean error = false;
		String[] inv = UserValue.getInventory();
		String[] itemSearch = item.split(" ");
		int invLength = inv.length - 1; //Number of items in user inventory
		int itemSearchLength = itemSearch.length - 1; //Number of words in item to drop
		int currentInv = 0; //Current item being searched in inventory
		int currentSearch = 0; //Current word being checked against inventory item
		boolean matchesSearch = true;
		String currentInvItem = "";
		String itemSearchString;

		//Searches for match of inv item to drop
		while(currentInv <= invLength){
			currentInvItem = inv[currentInv];
			while (currentSearch <= itemSearchLength){
				currentInvItem = currentInvItem.toLowerCase();
				itemSearchString = itemSearch[currentSearch].toLowerCase();
				System.out.println(currentInvItem + "|" + itemSearch[currentSearch]);
				if (currentInvItem.contains(itemSearchString)){
					matchesSearch = true;
				} else {
					matchesSearch = false;
				}
				currentSearch++;
			}
			if (matchesSearch == true){
				break;
			}
			currentInvItem = "";
			currentInv++;
		}

		if (currentInvItem.equals("")){
			error = true;
		} else {

			currentInvItem = inv[currentInv]; //Restores uppercase chars.

			//Gets the max number of items in the user's inventory
			int hasNum = UserValue.getInventoryItem(currentInvItem);

			//Stops the user from dropping more than in inventory
			//Also handles drop all
			if (hasNum < dropNum | dropNum == -1){
				dropNum = hasNum;
			}

			if (hasNum - dropNum==0){
				//Deletes the item from inventory if the value is
				UserValue.deleteInv(currentInvItem);
			} else {
				//Sets the new number in the user's inventory
				UserValue.setNewInv(currentInvItem, (hasNum - dropNum));
			}

			RoomValue RoomValue = new RoomValue(loc, room);
			String currentNum = RoomValue.getObjectNumber(currentInvItem);

			if (currentNum.equals("")){
				RoomValue.setNewObject(currentInvItem, dropNum+"");
			} else {
				int currentNumber = Integer.parseInt(currentNum);
				dropNum = dropNum + currentNumber;
				RoomValue.setNewObject(currentInvItem, dropNum+"");
			}
		}
		return error;
	}

	/**
	 * Takes an item from a room and adds to inventory
	 * @param item A string containing a part or the entire name of the item to drop
	 * @param num Number of items to take
	 * @param room The name of the room to take the item from
	 */
	public boolean take (String item, int takeNum, String room){
		RoomValue RoomValue = new RoomValue(loc, room);

		boolean error = false;
		String[] inv = RoomValue.getObjects();
		String[] itemSearch = item.split(" ");
		int objectLength = inv.length - 1; //Number of items in room
		int itemSearchLength = itemSearch.length - 1; //Number of words object to take
		int currentObject = 0; //Current item being searched in room
		int currentSearch = 0; //Current word being checked against room object
		boolean matchesSearch = true;
		String currentObjectItem = "";
		String itemSearchString;

		//Searches for match of inv item to drop
		while(currentObject <= objectLength){
			currentObjectItem = inv[currentObject];
			while (currentSearch <= itemSearchLength){
				currentObjectItem = currentObjectItem.toLowerCase();
				itemSearchString = itemSearch[currentSearch].toLowerCase();
				System.out.println(currentObjectItem + "|" + itemSearch[currentSearch]);
				if (currentObjectItem.contains(itemSearchString)){
					matchesSearch = true;
				} else {
					matchesSearch = false;
				}
				currentSearch++;
			}
			if (matchesSearch == true){
				break;
			}
			currentObjectItem = "";
			currentObject++;
		}

		if (currentObjectItem.equals("")){
			error = true;
		} else {

			currentObjectItem = inv[currentObject]; //Restores uppercase chars.

			//Gets the max number of objects in the room
			String invNum = RoomValue.getObjectNumber(currentObjectItem);
			int roomNum = Integer.parseInt(invNum);

			//Stops the user from taking more than the room has
			//Also handles take all <item>
			if (roomNum < takeNum | takeNum == -1){
				takeNum = roomNum;
			}

			if (roomNum - takeNum==0){
				//Deletes the item from the room's inventory if the value is 0
				RoomValue.deleteObject(currentObjectItem);
			} else {
				//Sets the new number of objects in the room
				RoomValue.setNewObject(currentObjectItem, (roomNum - takeNum) + "");
			}

			UserValue UserValue = new UserValue(loc, userName);
			String currentNum = Integer.toString(UserValue.getInventoryItem(currentObjectItem));

			if (currentNum.equals("") | currentNum.equals(null)){
				UserValue.setNewInv(currentObjectItem, takeNum);
			} else {
				int currentNumber = Integer.parseInt(currentNum);
				takeNum = takeNum + currentNumber;
				UserValue.setNewInv(currentObjectItem, takeNum);
			}
		}
		return error;
	}

	public void give (String item, int num, String user){

	}
}
