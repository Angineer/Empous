package main.java.com.adtme.empous;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainMenu extends JPanel {
	private BufferedImage title;
	private volatile int choice = 0;
	private int mousein;
	
	private JPanel buttons; //Panel to hold the three buttons
	private JButton newgame; //Three main menu items
	private JButton loadgame;
	private JButton quitgame;
	
	private Color background = new Color(100, 100, 100);
	private Font menufont = new Font("SansSerif", Font.PLAIN, 24);
	
	public MainMenu(){
		title=Empous.LoadImage("src/main/resources/images/title.png");
		
		setLayout(new BorderLayout()); //Main layout
		setOpaque(false); //Let the title screen show through
		
		buttons = new JPanel(); //Buttons layout
		buttons.setLayout(new GridLayout(1,3));
		
		ButtonClick buttonWatch = new ButtonClick ();
		
		newgame = new JButton("New Game"); //Create the buttons
		newgame.setBorder(BorderFactory.createMatteBorder(10,10,10,7, background));
		newgame.setFont(menufont);
		newgame.addMouseListener(buttonWatch);
		
		loadgame = new JButton("Load Game");
		loadgame.setBorder(BorderFactory.createMatteBorder(10,7,10,7, background));
		loadgame.setFont(menufont);
		loadgame.addMouseListener(buttonWatch);
		
		quitgame = new JButton("Quit");
		quitgame.setBorder(BorderFactory.createMatteBorder(10,7,10,10, background));
		quitgame.setFont(menufont);
		quitgame.addMouseListener(buttonWatch);
		
		buttons.add(newgame); //Add dem buttons
		buttons.add(loadgame);
		buttons.add(quitgame);
		
		add(buttons, BorderLayout.SOUTH);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(title, 0, 0, 640, 480, null);
	}
	
	public int getChoice(){
			int gchoice = choice;
			choice = 0;
			return gchoice;
	}
	
	public class ButtonClick implements MouseListener {

		public void mouseClicked(MouseEvent evt) {}
		public void mouseEntered(MouseEvent evt) {
			if (evt.getSource()==newgame){
				mousein = 1;
			}
			if (evt.getSource()==loadgame){
				mousein = 2;
			}
			if (evt.getSource()==quitgame){
				mousein = 3;
			}
		}
		public void mouseExited(MouseEvent evt) {
			mousein=0;
		}
		public void mousePressed(MouseEvent evt) {}
		public void mouseReleased(MouseEvent evt) {
			if (mousein == 1 && evt.getSource()==newgame){
				choice = 1;
			}
			if (mousein == 2 && evt.getSource()==loadgame){
				choice = 2;
			}
			if (mousein == 3 && evt.getSource()==quitgame){
				choice = 3;
			}
		}
	}
}
