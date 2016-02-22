package main.java.com.adtme.empous;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class Splash extends JPanel implements ActionListener{
	private Color background = Color.white;
	private Font font1 = new Font("Serif", Font.PLAIN, 24);
	private Font font3 = new Font("Serif", Font.ITALIC, 18);
	
	private int counter;
	private JLabel title1;
	private JLabel title2;
	
	private Timer timer;
	
	public Splash(){ //Constructor
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
		
		counter=0;
		timer = new Timer(2000, this);
		timer.setInitialDelay(0);
		repaint();
		timer.start();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//System.out.println(SwingUtilities.isEventDispatchThread());
		if(counter==1){
		}
		else if(counter == 2){
        	title2.setText("In Association With");
			title1.setText("El Pollo Diablo Productions");
        }
		else if(counter == 3){
			timer.stop();
			System.out.println("Animation done...");
			System.out.println("Main menu...");
			Empous.window.setTitle("Empous");
			Empous.window.display(Empous.menu);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		counter++;
		repaint();
	}
}
