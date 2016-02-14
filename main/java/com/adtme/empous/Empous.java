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
	
	// Create flow handling objects
	private static int gameState = 1; //1=main menu, 2=playing game
	private static int mainMenuChoice = 0;
	private static int playloop = 0;
	private static int newgame = 1;
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
		
		// Main loop
		while (true){
			// Main menu
			if(gameState==1){
				System.out.println("Main menu...");
				window.setTitle("Empous");
				window.display(Empous.menu);
				// Get user input
				mainMenuChoice=0;
				while (gameState == 1){
					mainMenuChoice = Empous.menu.getChoice();
					// Start new game
					if(mainMenuChoice == 1){
						System.out.println("Starting new game...");
						newGame();
						gameState=2;
					}
					// Load saved game
					else if (mainMenuChoice == 2){
						System.out.println("Loading saved game...");
						if (LoadSaveManager.loadGame("src/main/saves/savedata2.dat")!=null){
							gameState=2;
						}
					}
					// Quit
					else if (mainMenuChoice == 3){
						System.out.println("Exiting...");
						System.exit(0);
					}
				}
			}
			// In-game
			while (gameState == 2){
				
			}
			
			window.setTitle("Empous - "+empireName);
			
			while (playloop == 0){
				/*Give an update*/
				SubMenu Sub = new SubMenu(6);
				Sub.showUpdate(newgame);
				if (newgame==1) newgame=0;
								
				/*The Chair*/
				window.InGame();
			
				/*Process Turn*/
				LoadSaveManager.saveGame("src/main/saves/savedata2.dat");
				playloop = game.Process();
			} //End in-game loop
			winLose();
			playloop = 0;
			
		} //End main loop
	}
	
	public static void newGame(){
		empireName = JOptionPane.showInputDialog(null, "Enter your empire's name:");
		if (empireName != null){
			Res=new Residential();
			Com=new Commercial();
			Ind=new Industrial();
			LM=new LumberMill();
			Inf=new Infrastructure();
			Gov=new Government();
			LoadSaveManager.saveGame("src/main/saves/savedata2.dat");
		}
	}

	public static void viewMap(){
		/*Display the map*/
	}
	
	public static void buy(int sector, int size, int cap, int oil, int wood){
		if (sector==1){
			
		}
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
	
	private static void winLose(){
		if (happy>=100){
			System.out.println("YOU ARE WINNER!");
		}
		else if (happy==0){
			System.out.println("YOU LOSE!");
		}
	}
}
