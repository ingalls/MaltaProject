package userOperations;

import getValue.ObjectValue;
import getValue.RoomValue;
import getValue.StoreValue;
import getValue.UserValue;

public class InventoryOperations {

	String loc;
	String userName;

	public InventoryOperations (String database, String user){
		loc = database;
		userName = user;
	}

	public String sell(String item, int sellNum, String user, String store){
		UserValue UV = new UserValue(loc, user);
		StoreValue SV = new StoreValue(loc, store);

		String output = "";
		String[] inv = UV.getInventory();
		String[] itemSearch = item.split(" ");
		int invLength = inv.length - 1; //Number of items in user inventory
		int itemSearchLength = itemSearch.length - 1; //Number of words in item to drop
		int currentInv = 0; //Current item being searched in inventory
		int currentSearch = 0; //Current word being checked against inventory item
		boolean matchesSearch = true;
		String objectName = "";
		String objectTitle = "";
		String itemSearchString;

		//Searches for match of inv item to drop
		while(currentInv <= invLength){
			objectName = inv[currentInv];
			ObjectValue OV = new ObjectValue(loc, objectName);
			objectTitle = OV.getTitle();

			while (currentSearch <= itemSearchLength){
				objectTitle = objectTitle.toLowerCase();
				itemSearchString = itemSearch[currentSearch].toLowerCase();
				if (objectTitle.contains(itemSearchString)){
					matchesSearch = true;
				} else {
					matchesSearch = false;
				}
				currentSearch++;
			}
			if (matchesSearch == true){
				break;
			}
			objectTitle = "";
			currentInv++;
		}

		ObjectValue OV = new ObjectValue(loc, objectName);

		if (matchesSearch==false){
			output = "You don't have that item in your inventory!";
		} else {
			if (sellNum == -1){
				output = UV.getInventoryItem(objectName) + " of " + OV.getTitle() + " sold to store for " + OV.getWorth()*UV.getInventoryItem(objectName) + " gold." ;
				float moneyGain = UV.getGold() + SV.getBuyBack()* 0.01F * UV.getInventoryItem(objectName) * OV.getWorth();
				UV.setGold(Math.round(moneyGain));
				UV.deleteInv(objectName);
			} else if (sellNum > UV.getInventoryItem(objectName)){
				output = "You can't sell more than you have!";
			} else {
				if (UV.getInventoryItem(objectName) == sellNum){
					float moneyGain = UV.getGold() + SV.getBuyBack() * 0.01F * sellNum * OV.getWorth();
					UV.setGold(Math.round(moneyGain));
					output = sellNum + " of " + OV.getTitle() + " sold to store for " + OV.getWorth()*sellNum + " gold." ;
					UV.deleteInv(objectName);
				} else {
					float moneyGain = UV.getGold() + SV.getBuyBack() * 0.01F * sellNum * OV.getWorth();
					UV.setGold(Math.round(moneyGain));
					output = sellNum + " of " + OV.getTitle() + " sold to store for " + OV.getWorth()*sellNum + " gold." ;
					UV.setNewInv(objectName, UV.getInventoryItem(objectName) - sellNum);
				}
			}

		}
		return output;
	}

	/**
	 * Allows the user to buy an item from a store
	 * @param item The user's search string for the item
	 * @param buyNum The number of items to buy
	 * @param user The name of the user
	 * @param store The name of the store
	 * @return A String containing any error in cleanText (Can be output to user) Returns "" if no errors are incurred.
	 */
	public String buy (String item, int buyNum, String user, String store){
		UserValue UV = new UserValue(loc, user);
		StoreValue SV = new StoreValue(loc, store);

		String output = "";
		String[] inv = SV.getStoreList();
		String[] itemSearch = item.split(" ");
		int invLength = inv.length - 1; //Number of items in user inventory
		int itemSearchLength = itemSearch.length - 1; //Number of words in item to drop
		int currentInv = 0; //Current item being searched in inventory
		int currentSearch = 0; //Current word being checked against inventory item
		boolean matchesSearch = true;
		String objectName = "";
		String objectTitle = "";
		String itemSearchString;

		//Searches for match of inv item to drop
		while(currentInv <= invLength){
			objectName = inv[currentInv];
			ObjectValue OV = new ObjectValue(loc, objectName);
			objectTitle = OV.getTitle();

			while (currentSearch <= itemSearchLength){
				objectTitle = objectTitle.toLowerCase();
				itemSearchString = itemSearch[currentSearch].toLowerCase();
				if (objectTitle.contains(itemSearchString)){
					matchesSearch = true;
				} else {
					matchesSearch = false;
				}
				currentSearch++;
			}
			if (matchesSearch == true){
				break;
			}
			objectTitle = "";
			currentInv++;
		}

		ObjectValue OV = new ObjectValue(loc, objectName);

		if (matchesSearch==false){
			output = "This store doesn't sell that item!";
		} else {
			if (UV.getGold() < OV.getWorth() * buyNum){
				output = "You don't have enough money to buy that!";
			} else {
				UV.setGold(UV.getGold() - (OV.getWorth()*buyNum)); //Pays for object
				try {
					UV.getInventoryItem(objectName);
					UV.setNewInv(objectName, UV.getInventoryItem(objectName) + buyNum);
				} catch (Exception e){
					UV.setNewInv(objectName, buyNum);
				}
			}

			output = buyNum + " of " + OV.getTitle() + " added to inventory for " + OV.getWorth()*buyNum + " gold." ;
		}
		return output;
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
		String objectName = "";
		String objectTitle = "";
		String itemSearchString;

		//Searches for match of inv item to drop
		while(currentInv <= invLength){
			objectName = inv[currentInv];
			ObjectValue OV = new ObjectValue(loc, objectName);
			objectTitle = OV.getTitle();

			while (currentSearch <= itemSearchLength){
				objectTitle = objectTitle.toLowerCase();
				itemSearchString = itemSearch[currentSearch].toLowerCase();
				if (objectTitle.contains(itemSearchString)){
					matchesSearch = true;
				} else {
					matchesSearch = false;
				}
				currentSearch++;
			}
			if (matchesSearch == true){
				break;
			}
			objectTitle = "";
			currentInv++;
		}

		if (objectTitle.equals("")){
			error = true;
		} else {

			//Gets the max number of items in the user's inventory
			int hasNum = UserValue.getInventoryItem(objectName);

			//Stops the user from dropping more than in inventory
			//Also handles drop all
			if (hasNum < dropNum | dropNum == -1){
				dropNum = hasNum;
			}

			if (hasNum - dropNum==0){
				//Deletes the item from inventory if the value is
				UserValue.deleteInv(objectName);
			} else {
				//Sets the new number in the user's inventory
				UserValue.setNewInv(objectName, (hasNum - dropNum));
			}

			RoomValue RoomValue = new RoomValue(loc, room);
			String currentNum = RoomValue.getObjectNumber(objectName);

			if (currentNum.equals("")){
				RoomValue.setNewObject(objectName, dropNum);
			} else {
				int currentNumber = Integer.parseInt(currentNum);
				dropNum = dropNum + currentNumber;
				RoomValue.setNewObject(objectName, dropNum);
			}
		}
		return error;
	}

	/**
	 * Takes an item from a room and adds to inventory
	 * @param item A string containing a part or the entire name of the item to drop
	 * @param takeNum Number of items to take
	 * @param room The name of the room to take the item from
	 */
	public boolean take (String item, int takeNum, String room){
		RoomValue RoomValue = new RoomValue(loc, room);

		boolean error = false;
		String[] inv = RoomValue.getObjects();
		String[] itemSearch = item.split(" ");
		int invLength = inv.length - 1; //Number of items in user inventory
		int itemSearchLength = itemSearch.length - 1; //Number of words in item to drop
		int currentInv = 0; //Current item being searched in inventory
		int currentSearch = 0; //Current word being checked against inventory item
		boolean matchesSearch = true;
		String objectName = "";
		String objectTitle = "";
		String itemSearchString;

		//Searches for match of inv item to drop
		while(currentInv <= invLength){
			objectName = inv[currentInv];
			ObjectValue OV = new ObjectValue(loc, objectName);
			objectTitle = OV.getTitle();

			while (currentSearch <= itemSearchLength){
				objectTitle = objectTitle.toLowerCase();
				itemSearchString = itemSearch[currentSearch].toLowerCase();
				if (objectTitle.contains(itemSearchString)){
					matchesSearch = true;
				} else {
					matchesSearch = false;
				}
				currentSearch++;
			}
			if (matchesSearch == true){
				break;
			}
			objectTitle = "";
			currentInv++;
		}

		if (objectTitle.equals("")){
			error = true;
		} else {

			//Gets the max number of objects in the room
			String invNum = RoomValue.getObjectNumber(objectName);
			int roomNum = Integer.parseInt(invNum);

			//Stops the user from taking more than the room has
			//Also handles take all <item>
			if (roomNum < takeNum | takeNum == -1){
				takeNum = roomNum;
			}

			if (roomNum - takeNum==0){
				//Deletes the item from the room's inventory if the value is 0
				RoomValue.deleteObject(objectName);
			} else {
				//Sets the new number of objects in the room
				RoomValue.setNewObject(objectName, (roomNum - takeNum));
			}

			UserValue UserValue = new UserValue(loc, userName);
			String currentNum = Integer.toString(UserValue.getInventoryItem(objectName));

			if (currentNum.equals("") | currentNum.equals(null)){
				UserValue.setNewInv(objectName, takeNum);
			} else {
				int currentNumber = Integer.parseInt(currentNum);
				takeNum = takeNum + currentNumber;
				UserValue.setNewInv(objectName, takeNum);
			}
		}
		return error;
	}

	public void give (String item, int num, String user){

	}
}
