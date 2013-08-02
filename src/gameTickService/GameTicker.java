package gameTickService;

import getValue.GameKeeperValue;

import java.util.Timer;
import java.util.TimerTask;

import maltaProject.Generator;

public class GameTicker{

	Timer timer;
	public String database;
	public String strLine;

	public GameTicker(String data){
		database = data;
	}

	public void begin(){

		//Regenerate instanceNPC's
		GameKeeperValue GKV = new GameKeeperValue(database);
		Generator regen = new Generator(database);

		while (GKV.getRoomList().length != 0){
			String room = GKV.getRoomList()[0];
			String[] npcList = GKV.getRoomRegenList(room);

			int parser = 0;
			while (parser <= npcList.length - 1){
				regen.generateNPC(room, npcList[parser]);
				parser++;
			}
			GKV.removeRegenNPC(room);
		}

		//Start Timer Again
		int milliseconds = 500;
		timer = new Timer();
		timer.schedule(new RemindTask(), milliseconds);
	}

	class RemindTask extends TimerTask{
		@Override
		public void run(){
			timer.cancel();
			begin();
		}
	}

}
