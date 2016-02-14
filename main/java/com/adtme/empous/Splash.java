package main.java.com.adtme.empous;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Splash extends JPanel implements Runnable{
	
	private BufferedImage title;
	
	private Color background = Color.white;
	private Font font1 = new Font("Serif", Font.PLAIN, 24);
	private Font font3 = new Font("Serif", Font.ITALIC, 18);
	
	private int counter;
	private JLabel title1;
	private JLabel title2;
	
	public Splash(){ //Constructor
		title=Empous.LoadImage("src/main/resources/images/title.png");
		setBackground(background);
		
		title1 = new JLabel("Hades Games Presents", JLabel.CENTER); //Create the title objects
		title2 = new JLabel("", JLabel.CENTER);
		title1.setOpaque(false);
		title2.setOpaque(false);
		title1.setFont(font1);
		title2.setFont(font3);
		
		setLayout(new BorderLayout()); //Set up the layout and add the titles
		title2.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		title1.setBorder(BorderFactory.createEmptyBorder(0, 0, 275, 0));
		add(title2, BorderLayout.NORTH);
		add(title1, BorderLayout.SOUTH);
	}
	
	@Override
	public void run() {
		while(counter != 4){
			counter++;
			//System.out.println( "Frame "+counter);
			if(counter == 2){
            	title2.setText("In Association With");
				title1.setText("El Pollo Diablo Productions");
            }
            if(counter == 3){
            	remove(title2);
				remove(title1);
				repaint();
            }     
            if(counter == 4){
            	System.out.println("Animation done...");
            }
            try { Thread.sleep(2000); }
            catch(InterruptedException ie) { }
		}
		System.out.println("Returning from animation...");
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(counter == 3)
		g.drawImage(title, 0, 0, 640, 480, null);
	}
}
