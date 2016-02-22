package main.java.com.adtme.empous;

import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.InvocationTargetException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Empous
 * 
 * @category Bureaucratic simulation
 * 
 * @author Andy Tracy and Ryan Hurley
 *
 */

public class Empous {
	// Create game objects
	public static String empireName = "Empous";
	public static Residential Res;
	public static Commercial Com;
	public static Industrial Ind;
	public static LumberMill LM;
	public static Infrastructure Inf;
	public static Government Gov;
	
	// Create GUI objects
	public static GUI window;
	public static Splash splash;
	public static MainMenu menu;
	public static InGame game;
	
	// Create game state objects
	public static int saveSlot = 1;
	
	public static void main(String[]args){
		// Create GUI object instances
		System.out.println("Starting up...");
		Empous.splash = new Splash();
		Empous.menu = new MainMenu();
		Empous.game = new InGame();
		
		// This is the main game window where content will be displayed
		System.out.println("Generating GUI...");
		window = new GUI();
		
		// Splash screen
		System.out.println("Splash screen...");
		window.display(Empous.splash);
		// Run splash animation on EDT
		// TODO Fix this thing so it's thread safe and still runs
		try {
			SwingUtilities.invokeAndWait(Empous.splash);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Display main menu
		System.out.println("Main menu...");
		window.setTitle("Empous");
		window.display(Empous.menu);			
	}
	
	public static void newGame(){
		System.out.println("Starting new game...");
		empireName = JOptionPane.showInputDialog(null, "Enter your empire's name:", "Empire Name", JOptionPane.QUESTION_MESSAGE);
		//JOptionPane.showInputDialog(parentComponent, message, title, messageType, icon, selectionValues, initialSelectionValue)
		if (empireName != null){
			Res=new Residential();
			Com=new Commercial();
			Ind=new Industrial();
			LM=new LumberMill();
			Inf=new Infrastructure();
			Gov=new Government();
			
			// Save to disk 
			saveSlot = LoadSaveManager.saveGame(0);
			playGame(1);
		}
	}
	
	public static void loadGame(){
		System.out.println("Loading saved game...");
		saveSlot = LoadSaveManager.loadGame();
		playGame(0);
	}
	
	public static void playGame(int newGame){
		// Display game
		window.display(Empous.game);
		window.setTitle("Empous - "+empireName);
		
		// Start with an update
		Empous.game.showUpdate(newGame);
	}
	
	public static BufferedImage LoadImage(String filepath){
		BufferedImage image=null;
		try{                
	    	image = ImageIO.read(new File(filepath));
	    }
		catch (IOException ex) {
			System.out.println("Couldn't find image!");
			System.out.println(filepath);
			System.exit(1);
	    }
		return image;
	}
	
	public static void winLose(){
		if (Empous.Gov.getStat("publicopinion")>=100){
			UpdateView finalUpdate = new UpdateView(0);
			finalUpdate.display();
			System.out.println("YOU ARE WINNER!");
		}
		else if (Empous.Gov.getStat("publicopinion")==0){
			UpdateView finalUpdate = new UpdateView(0);
			finalUpdate.display();
			System.out.println("YOU LOSE!");
		}
	}
}
