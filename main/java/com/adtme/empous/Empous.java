package main.java.com.adtme.empous;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Empous
 * 
 * @category This game is HUGE.
 * 
 * @author Andy Tracy and Ryan Hurley
 *
 */

public class Empous {
	
	public static String empireName = "Andy's Magnificence";
	public static Residential Res;
	public static Commercial Com;
	public static Industrial Ind;
	public static LumberMill LM;
	public static Infrastructure Inf;
	public static Government Gov;
	
	public static GUI window;
	public static Splash splash;
	public static MainMenu menu;
	public static InGame game;
	
	private static int mainloop = 0;
	private static int playloop = 0;
	private static int newgame = 1;
	public static int happy = 50;
	
	public static void main(String[]args){
		/*Start up the Game, display splash page*/
		Empous.splash = new Splash(); //Create the basic game screens
		Empous.menu = new MainMenu();
		Empous.game = new InGame();
		
		window = new GUI(); //Create the GUI
		
		/*Begin main loop*/
		while (true){
			while (mainloop == 0){
				/*Main menu*/
				window.setTitle("Empous");
				int localchoice = window.MainMenu();
			
				if (localchoice == 1){
					newGame();
					newgame = 1;
				}
				else if (localchoice == 2){
					if (LoadSaveManager.loadGame("src/saves/savedata2.dat")!=null){
						mainloop = 2;
						newgame = 0;
					}
				}
				else if (localchoice == 3){
					System.exit(0);
				}
			} //End main menu loop
			mainloop = 0;
			
			window.setTitle("Empous - "+empireName);
			
			while (playloop == 0){
				/*Give an update*/
				SubMenu Sub = new SubMenu(6);
				Sub.showUpdate(newgame);
				if (newgame==1) newgame=0;
								
				/*The Chair*/
				window.InGame();
			
				/*Process Turn*/
				LoadSaveManager.saveGame("src/saves/savedata2.dat");
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
			mainloop = 1;
			LoadSaveManager.saveGame("C:\\Users\\Andy2\\javawork\\workspace\\Learning Java\\src\\empous\\saves\\savedata2.dat");
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
			System.out.println("Empous error... Couldn't find image!");
			System.out.println(filepath);
			System.exit(1);
	    }
		return image;
	}
	
	private static void winLose(){
		if (happy>=100){
//			System.out.println("YOU ARE WINNER!");
		}
		else if (happy==0){
//			System.out.println("YOU LOSE!");
		}
	}
}
