package main.java.com.adtme.empous;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

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
	public static String empireName = "Andy's Magnificence";
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
	public static int happy = 50;
	
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
		Thread t = new Thread(Empous.splash); // Create thread to run animation
		t.start(); // Start thread
		try{ t.join(); } // Wait for thread to finish
		catch(InterruptedException ie){	}

		// Display main menu
		System.out.println("Main menu...");
		window.setTitle("Empous");
		window.display(Empous.menu);			
	}
	
	public static void newGame(){
		System.out.println("Starting new game...");
		empireName = JOptionPane.showInputDialog(null, "Enter your empire's name:");
		if (empireName != null){
			Res=new Residential();
			Com=new Commercial();
			Ind=new Industrial();
			LM=new LumberMill();
			Inf=new Infrastructure();
			Gov=new Government();
			
			// Save to disk 
			LoadSaveManager.saveGame();
		}
		window.setTitle("Empous - "+empireName);
		playGame(1);
	}
	
	public static void loadGame(){
		System.out.println("Loading saved game...");
		LoadSaveManager.loadGame();
		playGame(0);
	}
	
	public static void playGame(int newGame){
		// Display game
		window.display(Empous.game);
		
		// Start with an update
		Empous.game.update();
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
		if (happy>=100){
			System.out.println("YOU ARE WINNER!");
		}
		else if (happy==0){
			System.out.println("YOU LOSE!");
		}
	}
}
