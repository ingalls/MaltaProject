package getValue;

import maltaProject.FileOperations;

public class WeatherPatternValue {
	/**Stores database location - initialized by constructor*/
	String database;
	/**Stores race name - initialized by constructor*/
	String weatherPattern;

	/**
	 * Constructs a new object with a string containing the database location and a string containing the race name.
	 * */
	public WeatherPatternValue(String data, String weather){
		weatherPattern = weather;
		database = data;
	}

	public String getSpringWeather(){
		FileOperations FO = new FileOperations(database+"/WeatherPatterns/" + weatherPattern + "/springWeather");
		return FO.getLine();
	}

	public void setSpringWeather(String weather){
		FileOperations FO = new FileOperations(database+"/WeatherPatterns/" + weatherPattern + "/springWeather");
		FO.setLine(weather);
	}

	public String getSummerWeather(){
		FileOperations FO = new FileOperations(database+"/WeatherPatterns/" + weatherPattern + "/summerWeather");
		return FO.getLine();
	}

	public void setSummerWeather(String weather){
		FileOperations FO = new FileOperations(database+"/WeatherPatterns/" + weatherPattern + "/summerWeather");
		FO.setLine(weather);
	}

	public String getFallWeather(){
		FileOperations FO = new FileOperations(database+"/WeatherPatterns/" + weatherPattern + "/fallWeather");
		return FO.getLine();
	}

	public void setFallWeather(String weather){
		FileOperations FO = new FileOperations(database+"/WeatherPatterns/" + weatherPattern + "/fallWeather");
		FO.setLine(weather);
	}

	public String getWinterWeather(){
		FileOperations FO = new FileOperations(database+"/WeatherPatterns/" + weatherPattern + "/winterWeather");
		return FO.getLine();
	}

	public void setWinterWeather(String weather){
		FileOperations FO = new FileOperations(database+"/WeatherPatterns/" + weatherPattern + "/winterWeather");
		FO.setLine(weather);
	}
}
