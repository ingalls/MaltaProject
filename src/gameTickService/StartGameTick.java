package gameTickService;

public class StartGameTick extends Thread {

	String database = "";

	public StartGameTick(String data){
		database = data;
		System.out.println("[GameKeeper] I am active, fear me.");
		GameTicker GT = new GameTicker(database);
		GT.begin();
	}
}
