package main.java.com.adtme.empous;
import java.awt.*;
import javax.swing.*;

/**
 * GUI for Empous
 * 
 * @author Andy Tracy
 *
 */

@SuppressWarnings("serial")
public class GUI extends JFrame{
	private JPanel mainPanel;
	
	public GUI(){ //Default constructor
		super("Empous"); //Call the super class constructor (create the frame)
		
		mainPanel = new JPanel();
		
		setSize(640,480); //Default window size
		setResizable(false);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	      setLocation( (screensize.width - getWidth())/2, (screensize.height - getHeight())/2); // Put it in the middle
		
	    setContentPane(mainPanel);
	    mainPanel.setBackground(Color.lightGray);
	    mainPanel.setLayout(new BorderLayout());
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Other options
		setVisible(true);
		splash(); //Start with the splash screen
	}
	
	public void splash(){
		mainPanel.add(Empous.splash, BorderLayout.CENTER);
		while(Empous.splash.GetCount() < 3){
		}
	}
	
	public int MainMenu(){
		mainPanel.removeAll();
		mainPanel.add(Empous.menu);
		mainPanel.revalidate();
		mainPanel.repaint();
		int loop = 0;
		
		while (loop==0){ //Wait for the player to press a button
			loop = Empous.menu.GetChoice();
		}
		
		return loop; //Return the choice to the main program
	}
	
	public void InGame(){		
		Empous.game.generateView();
		mainPanel.removeAll();
		mainPanel.add(Empous.game);
		mainPanel.revalidate();
		mainPanel.repaint();
		
		Empous.game.Play(); //Play the game
	}

}