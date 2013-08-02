package getValue;

import maltaProject.FileOperations;

public class GameKeeperValue {

	String database = "";

	public GameKeeperValue(String data){
		database = data;
	}

	public String[] getRoomList(){
		FileOperations FO = new FileOperations(database + "/gamekeeper/regenNPC/");
		String[] directory = FO.getDirectory();
		int parser = 0;
		while (parser <= directory.length - 1){
			directory[parser] = directory[parser].replace("&", "/");
			parser++;
		}
		return directory;
	}

	public String[] getRoomRegenList(String room){
		FileOperations FO = new FileOperations(database + "/gamekeeper/regenNPC/" + room.replace("/", "&"));
		return FO.getFile();
	}

	public void addRegenNPC(String roomName, String npcName){
		FileOperations FO = new FileOperations(database + "/gamekeeper/regenNPC/" + roomName);
		FO.setLine(npcName.replace("/", "&"));
	}

	public void removeRegenNPC(String roomName){
		FileOperations FO = new FileOperations(database + "/gamekeeper/regenNPC/" + roomName.replace("/", "&"));
		FO.deleteFile();
	}
}