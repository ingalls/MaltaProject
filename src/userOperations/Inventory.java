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

		while(currentInv <= invLength){
			currentInvItem = inv[currentInv];
			while (currentSearch <= itemSearchLength){
				if (currentInvItem.contains(itemSearch[currentSearch])){
					matchesSearch = true;
				} else {
					matchesSearch = false;
				}
				currentSearch++;
			}
			if (matchesSearch == true){
				break;
			}
			currentInv++;
		}

		String invNum = UserValue.getInventoryItem(currentInvItem);
		int hasNum = Integer.parseInt(invNum);

		if (hasNum < dropNum | dropNum == -1){
			dropNum = hasNum;
		}

		UserValue.setNewInv(currentInvItem, (hasNum - dropNum) + "");

		RoomValue RoomValue = new RoomValue(loc, room);
		String currentNum = RoomValue.getObjectNumber(currentInvItem);
		if (currentNum.equals("")){
			RoomValue.setNewObject(currentInvItem, dropNum+"");
		} else {
			int currentNumber = Integer.parseInt(currentNum);
			dropNum = dropNum + currentNumber;
			RoomValue.setNewObject(currentInvItem, dropNum+"");
		}
		System.out.println(userName + " dropped " + dropNum + " into " + room );
		return error;
	}

	public void take (String item, int num, String room){

	}

	public void give (String item, int num, String user){

	}
}
