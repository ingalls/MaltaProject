package getValue;

import maltaProject.FileOperations;

/**
 * This class contains getters and setters that the calling method
 * will use to set up a store in a room
 * 
 * @author Nicholas Ingalls
 *
 */
public class StoreValue {
	/** Stores database location - initialized by constructor */
	String database = "";
	/** Stores the name of the object - initialized by constructor */
	String store = "";

	/**
	 * Constructs a new object with a string containing the database location
	 * * and a string containing the name of the store.
	 * @param data A String containing the database location
	 * @param storeName A String containing the name of the store being accessed
	 */
	public StoreValue(String data, String storeName) {
		database = data;
		store = storeName;
	}

	/**
	 * Returns an integer containing the percentage of money that is returned
	 * if an item at the store is sold back to the store
	 * @return A value containing the buy back percentage
	 */
	public int getBuyBack(){
		FileOperations FO = new FileOperations(database + "/store/" + store + "/buyPercentage");
		return Integer.parseInt(FO.getLine());
	}

	/**
	 * Sets the percentage of money that is returned
	 * if an item at the store is sold back to the store.
	 * @param buyBack A String containing the buy back percentage
	 */
	public void setBuyBack(String buyBack){
		FileOperations FO = new FileOperations(database + "/store/" + store + "/buyPercentage");
		FO.setLine(buyBack);
	}

	/**
	 * Returns the items that the store sells. Each element in the array
	 * contains one item
	 * @return A String[] containing the items
	 */
	public String[] getStoreList(){
		FileOperations FO = new FileOperations(database + "/store/" + store + "/sell");
		return FO.getFile();
	}

	/**
	 * Sets the items that the store sells. Each element in the array should
	 * contain one item
	 * @param storeList A String[] containing the items
	 */
	public void setStoreList(String[] storeList){
		FileOperations FO = new FileOperations(database + "/store/" + store + "/sell");
		FO.setFile(storeList);
	}

}
