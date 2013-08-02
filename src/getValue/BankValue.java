package getValue;

import java.io.File;

import maltaProject.FileOperations;

public class BankValue {
	/** Stores database location - initialized by constructor */
	String database = "";
	/** Stores the name of the bank - initialized by constructor */
	String bank = "";

	/**
	 * Constructs a new object with a string containing the database location
	 * and a string containing the user name.
	 * @param data A String containing the database location
	 * @param bankName A String containing the name of the bank being accessed
	 */
	public BankValue(String data, String bankName) {
		database = data;
		bank = bankName;
	}

	public boolean hasAccount(String user){
		FileOperations FO = new FileOperations(database + "/bank/" + bank + "/account/" + user);
		return FO.checkFile();
	}

	public void createAccount(String user){
		File account = new File(database + "/bank/" + bank + "/account/" + user);
		account.mkdirs();

		setGold(user, 0);

		File vault = new File(database + "/bank/" + bank + "/account/" + user + "/vault/");
		vault.mkdirs();
	}

	public String getTitle(){
		FileOperations FO = new FileOperations(database + "/bank/" + bank + "/title");
		return FO.getLine();
	}

	public void setTitle(String title){
		FileOperations FO = new FileOperations(database + "/bank/" + bank + "/title");
		FO.setLine(title);
	}

	public String getDesc(){
		FileOperations FO = new FileOperations(database + "/bank/" + bank + "/desc");
		return FO.getLine();
	}

	public void setDesc(String desc){
		FileOperations FO = new FileOperations(database + "/bank/" + bank + "/desc");
		FO.setLine(desc);
	}

	public int getWithdrawFee(){
		FileOperations FO = new FileOperations(database + "/bank/" + bank + "/withdrawFee");
		return Integer.parseInt(FO.getLine());
	}

	public void setWithdrawFee(String fee){
		FileOperations FO = new FileOperations(database + "/bank/" + bank + "/withdrawFee");
		FO.setLine(fee);
	}

	public String[] getVaultContents(String user){
		FileOperations FO = new FileOperations(database + "/bank/" + bank + "/account/" + user + "/vault/");
		return FO.getDirectory();
	}

	/**
	 * Used to create a new inventory item
	 * This is also used to change the quantity of an item
	 * @param user The user's name
	 * @param item The name of the item
	 * @param quantity The quantity of the item
	 */
	public void setNewItem(String user, String item, int quantity){
		FileOperations FO = new FileOperations(database + "/bank/" + bank + "/account/" + user + "/vault/" + item);
		FO.setLine(Integer.toString(quantity));
	}

	/**
	 * Returns the number of a certain item in a user's inventory
	 * @param user The name of the user
	 * @param item The name of the item
	 * @return The number of instances of that item that the user is carrying.
	 */
	public int getItem(String user, String item){
		FileOperations fileOp;
		boolean exceptionCatcher = false;
		int numHolder = 0;

		try {
			fileOp = new FileOperations(database + "/bank/" + bank + "/account/" + user + "/vault/" + item);
			numHolder = Integer.parseInt(fileOp.getLine());
		} catch (Exception e) {
			exceptionCatcher = true;
		}
		if (exceptionCatcher == false){
			return numHolder;
		} else {
			return 0;
		}
	}

	/**
	 * Used to delete an inventory item
	 * @param user A String containing the user's name
	 * @param item A String containing the inventory item to delete
	 */
	public void deleteItem(String user, String item){
		FileOperations FO = new FileOperations(database + "/bank/" + bank + "/account/" + user + "/vault/" + item);
		FO.deleteFile();
	}

	public int getGold(String user){
		FileOperations FO = new FileOperations(database + "/bank/" + bank + "/account/" + user + "/gold");
		return Integer.parseInt(FO.getLine());
	}

	public void setGold(String user, int gold){
		FileOperations FO = new FileOperations(database + "/bank/" + bank + "/account/" + user + "/gold");
		FO.setLine(gold + "");
	}
}
