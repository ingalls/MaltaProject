package maltaProject;

public class GameKeeper extends Thread {
	
	String database = "";
	
	public GameKeeper(String data){
		database = data;
		System.out.println("[GameKeeper] I am active, fear me.");
	}
}
