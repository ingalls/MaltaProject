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

	public void drop (String item, int dropNum, String room){
		int haveNum; //Number of specified item in user's inventory

		UserValue value = new UserValue(loc, userName);
		haveNum = Integer.parseInt(value.getInventoryItem(item));

		if (dropNum == -1){
			dropNum = haveNum;
			haveNum = 0;
			value.deleteInv(item);
		}
		else if (haveNum>dropNum){
			haveNum = haveNum - dropNum;
			value.setNewInv(item, haveNum+"");
		} else {
			dropNum = haveNum;
			haveNum = 0;
			value.deleteInv(item);
		}

		RoomValue RV = new RoomValue(loc, room);

		String preDrop = RV.getObjectNumber(item);

		if (!preDrop.equals("")){
			int preDropInt = Integer.parseInt(preDrop);
			dropNum = dropNum + preDropInt;
		}

		RV.setNewObject(item, dropNum+"");

	}

	public void take (String item, int num, String room){

	}

	public void give (String item, int num, String user){

	}
}
