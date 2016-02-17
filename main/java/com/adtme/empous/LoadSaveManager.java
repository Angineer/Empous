package main.java.com.adtme.empous;

import java.io.*;
import java.util.Date;

import javax.swing.JOptionPane;

public class LoadSaveManager {

	public static void saveGame(){
		// Get user input
		Object[] options = {"1", "2", "3"};
		int slot = JOptionPane.showOptionDialog(null, "Select your save slot", "Save Slot", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		slot++;
		
		// Save game
		System.out.println("Saving save slot " + slot + "...");
		File saveFile = new File("src/main/saves/savedata"+slot+".dat");
		Date now = new Date();
		try{
			FileOutputStream fstream = new FileOutputStream (saveFile);
			ObjectOutputStream out = new ObjectOutputStream(fstream);
			out.writeObject(Empous.empireName);
			out.writeObject(now.toString());
			out.writeObject(Empous.Com);
			out.writeObject(Empous.Res);
			out.writeObject(Empous.Ind);
			out.writeObject(Empous.LM);
			out.writeObject(Empous.Inf);
			out.writeObject(Empous.Gov);
			out.flush();
			out.close();
		}
		catch(IOException e){
			System.out.println("Couldn't save to file...");
			System.exit(2);
		}
		System.out.println("Saved to file");
	}
	
	public static String loadGame(){
		// Get user input
		Object[] options = {"1", "2", "3"};
		int slot = JOptionPane.showOptionDialog(null, "Select your save slot", "Save Slot", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		slot++;
		
		// Load saved game
		System.out.println("Loading save slot " + slot + "...");
		File loadFile = new File("src/main/saves/savedata"+slot+".dat");
		String then = null;
		try{
			FileInputStream fstream = new FileInputStream (loadFile);
			ObjectInputStream in = new ObjectInputStream(fstream);
			
			Empous.empireName = (String) in.readObject();
			then=(String) in.readObject();
			Empous.Com=(Commercial) in.readObject();
			Empous.Res=(Residential) in.readObject();
			Empous.Ind=(Industrial) in.readObject();
			Empous.LM=(LumberMill) in.readObject();
			Empous.Inf=(Infrastructure) in.readObject();
			Empous.Gov=(Government) in.readObject();
			
			in.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Your save files gots screwed up... >:[");
		}
		catch(IOException e){
			System.out.println("Couldn't load from file...");
			System.exit(2);
		}
		catch (ClassNotFoundException e) {
			System.out.println("Couldn't load from file...");
			System.exit(2);
		}
		return then;
	}
}

