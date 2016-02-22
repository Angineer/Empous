package main.java.com.adtme.empous;

import java.awt.Graphics;
import java.awt.image.*;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Map extends JPanel {
	private BufferedImage mapimg;
	
	public Map(){
		if (Empous.Gov.getStat("census")<=50000)
			mapimg = Empous.LoadImage("src/main/resources/images/map1.png");
		else if (Empous.Gov.getStat("census")<=1000000)
			mapimg = Empous.LoadImage("src/main/resources/images/map2.png");
		else if (Empous.Gov.getStat("census")<=300000000)
			mapimg = Empous.LoadImage("src/main/resources/images/map3.png");
		else if (Empous.Gov.getStat("census")<=6000000000D)
			mapimg = Empous.LoadImage("src/main/resources/images/map4.png");
		else if (Empous.Gov.getStat("census")<=100000000000D)
			mapimg = Empous.LoadImage("src/main/resources/images/map5.png");
		else
			mapimg = Empous.LoadImage("src/main/resources/images/map6.png");
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(mapimg, 0, 0, 450, 350, null);
	}
}
