package commands;

import getValue.BankValue;
import getValue.ObjectValue;
import getValue.UserValue;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import userInterface.setColor;

public class BankCommands {
	String database;

	Socket socket;

	String user;

	String bank;

	public BankCommands(Socket s, String data, String userName, String bankName){
		database = data;
		user = userName;
		socket = s;
		bank = bankName;
	}

	public void bank(){
		BankValue BV = new BankValue(database, bank);

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream in inventory class");
		}

		if (!BV.hasAccount(user)){
			BV.createAccount(user);
		}

		setColor SC = new setColor();
		out.println("--" + BV.getTitle() + "--");
		out.println(user + "'s account:");
		out.println(SC.color("[yellow]" + BV.getGold(user) + "[white]") + " gold");
		out.println(user + "'s vault:");

		int objGet = 0;
		String[] itemList = BV.getVaultContents(user);

		if(itemList.length == 0){
			out.println("Empty...");
		} else {
			out.println(" # | Description");
			while (objGet < itemList.length){
				int number = BV.getItem(user, itemList[objGet]);
				ObjectValue OV = new ObjectValue(database, itemList[objGet]);
				String textOut = SC.color(" " + number + "  " + OV.getTitle() + " - " + OV.getDesc());
				out.println(textOut);

				objGet++;
			}
		}
		out.println("\n" + BV.getWithdrawFee() + "g withdrawl fee");

	}

	public void deposit(int amount){
		BankValue BV = new BankValue(database, bank);
		UserValue UV = new UserValue(database, user);
		setColor SC = new setColor();

		if (amount == -1){
			amount = UV.getGold();
		}

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream in inventory class");
		}

		if (!BV.hasAccount(user)){
			BV.createAccount(user);
		}

		if (UV.getGold() >= amount){
			UV.setGold(UV.getGold() - amount);
			BV.setGold(user, amount + BV.getGold(user));

			out.println(SC.color("[yellow]" + amount + "[white] has been moved to your account"));
		} else {
			out.println("You can't deposit more than you have");
		}
	}

	public void withdraw(int amount){
		BankValue BV = new BankValue(database, bank);
		UserValue UV = new UserValue(database, user);
		setColor SC = new setColor();

		if (amount == -1){
			amount = BV.getGold(user);
		}

		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e) {
			System.out.println("Error: " + user + " cannot open printstream in inventory class");
		}

		if (!BV.hasAccount(user)){
			out.println("You don't have anything stored at this bank!");
		} else {
			if (amount <= BV.getWithdrawFee()){
				out.println("You must withdraw more than the withdrawl fee!");
			} else if (BV.getGold(user) >= amount){
				BV.setGold(user, BV.getGold(user) - amount);
				UV.setGold(UV.getGold() + amount);

				out.println(SC.color("[yellow]" + amount + "[white] has been withdrawn from your account."));
			} else {
				out.println("You can't withdraw more than you have!");
			}
		}
	}
}
