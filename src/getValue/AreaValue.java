package getValue;

import maltaProject.FileOperations;

public class AreaValue {
	/**Stores database location - initialized by constructor*/
	String database;
	/**Stores area name - initialized by constructor*/
	String areaName;

	/**
	 * Constructs a new object with a string containing the database location and a string containing the race name.
	 * */
	public AreaValue(String data, String area){
		areaName = area;
		database = data;
	}

	public String getCurrentWeather(){
		FileOperations FO = new FileOperations(database+"/rooms/" + areaName + "/currentWeather");
		return FO.getLine();
	}

	public void setCurrentWeather(String weather){
		FileOperations FO = new FileOperations(database+"/rooms/" + areaName + "/currentWeather");
		FO.setLine(weather);
	}

	public String getWeatherPattern(){
		FileOperations FO = new FileOperations(database+"/rooms/" + areaName + "/weatherPattern");
		return FO.getLine();
	}

	public void setWeatherPattern(String weatherPattern){
		FileOperations FO = new FileOperations(database+"/rooms/" + areaName + "/weatherPattern");
		FO.setLine(weatherPattern);
	}
}
