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
	}
	
	public void display(JPanel content){
		mainPanel.removeAll();
		mainPanel.add(content);
		mainPanel.revalidate();
		mainPanel.repaint();
	}
}