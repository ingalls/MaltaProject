package Main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class getValue {
	public String getAge(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/age";
		String userAge = accessFile(fileLoc);
		return userAge;
	}
	public String getClass(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/class";
		String userClass =accessFile(fileLoc);
		return userClass;
	}
	public String getDex(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/dexterity";
		String userDex = accessFile(fileLoc);
		return userDex;
	}
	public String getXP(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/experience";
		String userXP = accessFile(fileLoc);
		return userXP;
	}
	public String getGold(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/gold";
		String userGold = accessFile(fileLoc);
		return userGold;
	}
	public String getHP(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/health";
		String userHP = accessFile(fileLoc);
		return userHP;
	}
	public String getInt(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/intelligence";
		String userInt = accessFile(fileLoc);
		return userInt;
	}
	public String getLvl(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/level";
		String userLvl = accessFile(fileLoc);
		return userLvl;
	}
	public String getLoc(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/location";
		String userLoc = accessFile(fileLoc);
		return userLoc;
	}
	public String getName(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/name";
		String userName = accessFile(fileLoc);
		return userName;
	}
	public String getRace(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/race";
		String userRace = accessFile(fileLoc);
		return userRace;
	}
	public String getReligion(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/religion";
		String userReligion = accessFile(fileLoc);
		return userReligion;
	}
	public String getSex(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/sex";
		String userSex = accessFile(fileLoc);
		return userSex;
	}
	public String getStr(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/strength";
		String userStr = accessFile(fileLoc);
		return userStr;
	}
	public String getWeight(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/weight";
		String userWeight = accessFile(fileLoc);
		return userWeight;
	}
	public String getWis(String database, String user){
		String fileLoc = database + "/charProfile/"+user+"/wisdom";
		String userWis = accessFile(fileLoc);
		return userWis;
	}
	public String accessFile(String location){ //Need to incorportate the logging file
		String line = null;
		try{
			FileInputStream fstream = new FileInputStream(location);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			line = br.readLine();
			in.close();
		} catch (Exception e){
		}
		return line;
	}
}
