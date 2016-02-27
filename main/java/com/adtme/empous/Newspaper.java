package main.java.com.adtme.empous;

import java.awt.Graphics;
import java.awt.image.*;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Newspaper extends JPanel {
	private BufferedImage newsimg;
	
	public Newspaper(){
			newsimg = Empous.LoadImage("/main/resources/images/news.png");
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(newsimg, 0, 0, 450, 350, null);
	}
}
