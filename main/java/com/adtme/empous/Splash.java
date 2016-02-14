package main.java.com.adtme.empous;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Splash extends JPanel {
	private BufferedImage title;
	
	private Color background = Color.white;
	private Font font1 = new Font("Serif", Font.PLAIN, 24);
	private Font font3 = new Font("Serif", Font.ITALIC, 18);
	
	private int counter;
	private TimerListener watch;
	private Timer timer;
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
		
		watch = new TimerListener(); //Start the animation timer
		timer = new Timer(2000, watch);
		timer.start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(counter==2)
		g.drawImage(title, 0, 0, 640, 480, null);
	}
	
	private class TimerListener implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			counter+=1;
			if (counter==1){
				title2.setText("In Association With");
				title1.setText("El Pollo Diablo Productions");
			}
			if (counter==2){
				remove(title2);
				remove(title1);
				repaint();
			}
			if (counter==3){
				timer.stop();
			}
		}
	}
	
	public int GetCount(){
		return counter;
	}
}
