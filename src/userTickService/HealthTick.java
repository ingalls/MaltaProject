package userTickService;

import getValue.UserValue;

public class HealthTick {
	public HealthTick(String database, String user){
		UserValue UV = new UserValue(database, user);

		if (UV.isSleeping()){
			//TODO increase HP quickly
		} else {
			//TODO increase HP slowly
		}


	}
}
