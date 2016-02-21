package main.java.com.adtme.empous;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class SectorView extends SubMenu{
	private static final long serialVersionUID = 1L;
	
	private JLabel jla = new JLabel();
	private JLabel jlb = new JLabel();
	private JLabel jlc = new JLabel();
	private JLabel jl1 = new JLabel();
	private JLabel jl2 = new JLabel();
	private JLabel jl3 = new JLabel();
	private JLabel jl4 = new JLabel();
	private JLabel jl5 = new JLabel();
	private JLabel jl6 = new JLabel();
	private JLabel jl7 = new JLabel();
	private JLabel jl8 = new JLabel();
	private JLabel jl9 = new JLabel();
	private JLabel jl10 = new JLabel();
	private JLabel jl11 = new JLabel();
	private JLabel jl12 = new JLabel();
	private JLabel jl13 = new JLabel();
	private JLabel jl14 = new JLabel();
	private JLabel jl15 = new JLabel();
	private JLabel jl16 = new JLabel();
	
	private GridBagConstraints c;
	
	private JPanel overpanel;
	private JPanel lines;
	private JPanel content1;
	private JPanel content2;
	
	private JButton buysell;
	private JButton close;
	
	private ButtonClick buttonWatch;
	private int mousein = 0;
	private String sectorstr;
	
	private int[][] stats = new int[5][3];
	private int[][] sum = new int[1][4];

	public SectorView(Capital sector) {
		super();
		buttonWatch = new ButtonClick();
		
		sectorstr=sector.getType();
		setTitle("Sector View - " + sectorstr);
		
		// Description
		if (sectorstr.equals("Commercial")){
			setDescription("src/main/resources/images/ComIcon.png", "<html>The Commercial sector provides jobs for your hardworking citizens, " +
					"and frivolous spending for your rich ones.</html>");
		}
		else if (sectorstr.equals("Residential")){
			setDescription("src/main/resources/images/ResIcon.png", "<html>The Residential sector provides a place for your citizens to rest " +
					"their weary heads.</html>");
		}
		else if (sectorstr.equals("Industrial")){
			setDescription("src/main/resources/images/IndIcon.png", "<html>The Industrial sector provides necessary jobs and produces the widgets " +
					"that power the modern economy.</html>");
		}
		else if (sectorstr.equals("Lumber")){
			setDescription("src/main/resources/images/LumberIcon.png", "<html>What great empire could exist without lumber mills???</html>");
		}
		
		// Overlaid content
		overpanel = new JPanel();
		overpanel.setLayout(new OverlayLayout(overpanel));
		
		lines = new JPanel();
		lines.setOpaque(false);
		lines.setBorder(BorderFactory.createMatteBorder(1,0,1,0, Color.BLACK));
		lines.setMaximumSize(new Dimension(200,128));
		
		overpanel.add(lines);
		
		// Content
		setContentLayout(new GridLayout(1,2));
		addContent(overpanel);
		content1 = new JPanel();
		content2 = new JPanel();
		
		overpanel.add(content2);
		
		addContent(content1);
		addContent(overpanel);
		
		// Buttons
		buysell = new JButton("Buy/Sell");
		buysell.addMouseListener(buttonWatch);
		close = new JButton("Close");
		close.addMouseListener(buttonWatch);
		
		addButton(buysell);
		addButton(close);
	}
	
	public void display(){
		content1.setLayout(new GridBagLayout());
		content2.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		c.gridx = 0;
		c.weighty = 0.2;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		content1.add(new JLabel("Your empire has"), c);
		c.gridy = 1;
		content1.add(jla, c);
		c.gridy = 2;
		content1.add(jlb, c);
		c.gridy = 3;
		content1.add(jlc, c);
		c.gridy = 4;
		content1.add(new JLabel("Total Resources Generated:"), c);
		
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.CENTER;
		c.gridy = 0;
		content2.add(new JPanel(), c);
		c.gridx = 1;
		content2.add(new JLabel("<html>Jobs</html>"), c);
		c.gridx = 2;
		content2.add(new JLabel("<html>Capital</html>"), c);
		c.gridx = 3;
		content2.add(new JLabel("<html>Oil</html>"), c);
		c.gridx = 4;
		content2.add(new JLabel("<html>Wood</html>"), c);
		c.gridy = 1;
		c.gridx = 0;
		content2.add(new JLabel("X"), c);
		c.gridx = 1;
		content2.add(jl1, c);
		c.gridx = 2;
		content2.add(jl2, c);
		c.gridx = 3;
		content2.add(jl3, c);
		c.gridx = 4;
		content2.add(jl4, c);
		c.gridy = 2;
		c.gridx = 0;
		content2.add(new JLabel("X"), c);
		c.gridx = 1;
		content2.add(jl5, c);
		c.gridx = 2;
		content2.add(jl6, c);
		c.gridx = 3;
		content2.add(jl7, c);
		c.gridx = 4;
		content2.add(jl8, c);
		c.gridy = 3;
		c.gridx = 0;
		content2.add(new JLabel("X"), c);
		c.gridx = 1;
		content2.add(jl9, c);
		c.gridx = 2;
		content2.add(jl10, c);
		c.gridx = 3;
		content2.add(jl11, c);
		c.gridx = 4;
		content2.add(jl12, c);
		c.gridy = 4;
		c.gridx = 0;
		content2.add(new JPanel(), c);
		c.gridx = 1;
		content2.add(jl13, c);
		c.gridx = 2;
		content2.add(jl14, c);
		c.gridx = 3;
		content2.add(jl15, c);
		c.gridx = 4;
		content2.add(jl16, c);
		
		super.display();
	}
	
	public void generateView(Capital Sector){
		stats[0][0]=Sector.getSmall();
		stats[0][1]=Sector.getMedium();
		stats[0][2]=Sector.getLarge();
		stats[1][0]=Sector.getJobs(1);
		stats[1][1]=Sector.getJobs(2);
		stats[1][2]=Sector.getJobs(3);
		stats[2][0]=Sector.getCap(1);
		stats[2][1]=Sector.getCap(2);
		stats[2][2]=Sector.getCap(3);
		stats[3][0]=Sector.getOil(1);
		stats[3][1]=Sector.getOil(2);
		stats[3][2]=Sector.getOil(3);
		stats[4][0]=Sector.getWood(1);
		stats[4][1]=Sector.getWood(2);
		stats[4][2]=Sector.getWood(3);
		
		sum[0][0]=stats[0][0]*stats[1][0]+stats[0][1]*stats[1][1]+stats[0][2]*stats[1][2];
		sum[0][1]=stats[0][0]*stats[2][0]+stats[0][1]*stats[2][1]+stats[0][2]*stats[2][2];
		sum[0][2]=stats[0][0]*stats[3][0]+stats[0][1]*stats[3][1]+stats[0][2]*stats[3][2];
		sum[0][3]=stats[0][0]*stats[4][0]+stats[0][1]*stats[4][1]+stats[0][2]*stats[4][2];
		
		jla.setText("       "+stats[0][0]+" Small "+sectorstr+" Units");
		jlb.setText("       "+stats[0][1]+" Medium "+sectorstr+" Units");
		jlc.setText("       "+stats[0][2]+" Large "+sectorstr+" Units");
		
		jl1.setText(Integer.toString(stats[1][0]));
		jl2.setText(Integer.toString(stats[2][0]));
		jl3.setText(Integer.toString(stats[3][0]));
		jl4.setText(Integer.toString(stats[4][0]));
		jl5.setText(Integer.toString(stats[1][1]));
		jl6.setText(Integer.toString(stats[2][1]));
		jl7.setText(Integer.toString(stats[3][1]));
		jl8.setText(Integer.toString(stats[4][1]));
		jl9.setText(Integer.toString(stats[1][2]));
		jl10.setText(Integer.toString(stats[2][2]));
		jl11.setText(Integer.toString(stats[3][2]));
		jl12.setText(Integer.toString(stats[4][2]));
		jl13.setText(Integer.toString(sum[0][0]));
		jl14.setText(Integer.toString(sum[0][1]));
		jl15.setText(Integer.toString(sum[0][2]));
		jl16.setText(Integer.toString(sum[0][3]));
	}
	
	public class ButtonClick implements MouseListener {
		public void mouseClicked(MouseEvent evt) {
		}
		public void mouseEntered(MouseEvent evt) {
			if (evt.getSource()==buysell){
				mousein = 1;
			}
			if (evt.getSource()==close){
				mousein = 2;
			}
		}
		public void mouseExited(MouseEvent evt) {
			mousein=0;
		}
		public void mousePressed(MouseEvent evt) {}
		public void mouseReleased(MouseEvent evt) {
			if (mousein == 1 && evt.getSource()==buysell){
				System.out.println("Opening Buy/Sell window...");
				BuySell bs= new BuySell(sectorstr);
				bs.doBuySell(Empous.Com);
			}
			if (mousein == 2 && evt.getSource()==close){
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		}
	}
}
