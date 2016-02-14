package main.java.com.adtme.empous;

import java.io.*;
import java.util.Date;

public class LoadSaveManager {

	public static void saveGame(String path){
		File saveFile = new File(path);
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
	
	public static String loadGame(String path){
		File loadFile = new File(path);
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

