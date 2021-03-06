package userInterface;
import getValue.UserValue;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class InputBar {
	public Socket socket;
	public PrintWriter out;
	public String database;
	public String user;

	public InputBar(String data, String name){
		database = data;
		user = name;
	}
	public String showHealthbar(){
		String hp = "", xp = "", maxHP = "";
		UserValue getValue = new UserValue(database,user);
		hp = Integer.toString(getValue.getHP());
		xp = Integer.toString(getValue.getXP());
		maxHP = Integer.toString(getValue.getMaxHealth());
		double hpint = Double.parseDouble(hp), hpmax = Double.parseDouble(maxHP);
		String color = null;
		double ratio = hpint/hpmax;
		if (ratio >= 0.50){
			color = "[green]";
		} else if (ratio >= 0.25 & ratio < 0.50){
			color = "[white]";
		} else if (ratio >= 0.15 & ratio < 0.25){
			color = "[yellow]";
		} else if (ratio >= 0 & ratio < 0.15){
			color = "[red]";
		}
		setColor setColor = new setColor();
		String healthBar = setColor.color("[white]("+color + hp + "HP[white]/" + xp + " XP):");
		return healthBar;
	}
	public String getInput(BufferedReader in){
		Scanner usrTxt = new Scanner(in);
		String str = "";
		try {
			str = usrTxt.nextLine();

		} catch (NoSuchElementException e){
			//TODO this error will throw if and when the user disconnects.
			//Close the user tick service
			//Remove who file for user
		}

		str = str.trim();
		return str;
	}
}
