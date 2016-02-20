package main.java.com.adtme.empous;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class GovView extends SubMenu{
	private static final long serialVersionUID = 1L;
	
	private JSlider freedom;
	private JSlider military;
	private JSlider taxes;
	private JSlider education;
	private JSlider infrastructure;
	private JSlider environment;
	private JSlider sciencetech;
	private JSlider healthcare;
	private JSlider admin;
	private JCheckBox mjbox;
	
	private int mousein = 0;

	public GovView(int input, ImageIcon icon) {
		super();
		setTitle("Sector View - Government");
		icon = new ImageIcon("src/main/resources/images/GovIcon.png");
		sectorstr = "Government";
		
		DescColor = Color.GRAY;
		
		content.setLayout(new GridLayout(1,2));
		subcontent1 = new JPanel();
		subcontent2 = new JPanel();
		content.add(subcontent1);
		content.add(subcontent2);
		
		govClose = new JButton("Close");
		govClose.addMouseListener(buttonWatch);
		
		buttons.add(govClose);
	}
	
	public void display(){
		freedom = new JSlider(0,10,Empous.Gov.getGov(1));
		military = new JSlider(0,10,Empous.Gov.getGov(2));
		taxes = new JSlider(0,10,Empous.Gov.getGov(3));
		education = new JSlider(0,10,Empous.Gov.getGov(4));
		infrastructure = new JSlider(0,10,Empous.Gov.getGov(5));
		environment = new JSlider(0,10,Empous.Gov.getGov(6));
		sciencetech = new JSlider(0,10,Empous.Gov.getGov(7));
		healthcare = new JSlider(0,10,Empous.Gov.getGov(8));
		admin = new JSlider(0,10,Empous.Gov.getGov(9));
		mjbox = new JCheckBox("",Empous.Gov.getMJ());
		
		description.setText("<html>The Government makes the laws and set the policies that tell " +
			"your citizens what they can and can't do.</html>");
		
		subcontent1.setLayout(new GridLayout(10,1));
		subcontent2.setLayout(new GridLayout(10,1));
		
		freedom.setMajorTickSpacing(1);
		freedom.setSnapToTicks(true);
		military.setMajorTickSpacing(1);
		military.setSnapToTicks(true);
		taxes.setMajorTickSpacing(1);
		taxes.setSnapToTicks(true);
		education.setMajorTickSpacing(1);
		education.setSnapToTicks(true);
		infrastructure.setMajorTickSpacing(1);
		infrastructure.setSnapToTicks(true);
		environment.setMajorTickSpacing(1);
		environment.setSnapToTicks(true);
		sciencetech.setMajorTickSpacing(1);
		sciencetech.setSnapToTicks(true);
		healthcare.setMajorTickSpacing(1);
		healthcare.setSnapToTicks(true);
		admin.setMajorTickSpacing(1);
		admin.setSnapToTicks(true);
		
		subcontent1.add(new JLabel("Freedom"), c);
		subcontent1.add(new JLabel("Military"), c);
		subcontent1.add(new JLabel("Taxes"), c);
		subcontent1.add(new JLabel("Education"), c);
		subcontent1.add(new JLabel("Infrastructure"), c);
		subcontent1.add(new JLabel("Environment"), c);
		subcontent1.add(new JLabel("Science & Tech"), c);
		subcontent1.add(new JLabel("Healthcare"), c);
		subcontent1.add(new JLabel("Administration"), c);
		subcontent1.add(new JLabel("Legalize Marijuana"), c);
		
		subcontent2.add(freedom);
		subcontent2.add(military);
		subcontent2.add(taxes);
		subcontent2.add(education);
		subcontent2.add(infrastructure);
		subcontent2.add(environment);
		subcontent2.add(sciencetech);
		subcontent2.add(healthcare);
		subcontent2.add(admin);
		subcontent2.add(mjbox);
		
		subcontent1.setBorder(BorderFactory.createEmptyBorder(5,75,5,0));
		subcontent2.setBorder(BorderFactory.createEmptyBorder(5,0,5,35));
		
		setVisible(true);
		panel.revalidate();
	}
	
	public class ButtonClick implements MouseListener {
		public void mouseClicked(MouseEvent evt) {
			if (evt.getSource()==mapimage){
				setContentPane(panel);
			}
		}
		public void mouseEntered(MouseEvent evt) {
			if (evt.getSource()==buysell){
				mousein = 1;
			}
			if (evt.getSource()==newspaper){
				mousein = 1;
			}
			if (evt.getSource()==map){
				mousein = 2;
			}
			if (evt.getSource()==close){
				mousein = 3;
			}
			if (evt.getSource()==govClose){
				mousein = 4;
			}
		}
		public void mouseExited(MouseEvent evt) {
			mousein=0;
		}
		public void mousePressed(MouseEvent evt) {}
		public void mouseReleased(MouseEvent evt) {
			if (mousein == 1 && evt.getSource()==buysell){
				System.out.println("Opening Buy/Sell window...");
				BuySell bs= new BuySell(sector);
				bs.doBuySell(Empous.Com);
			}
			if (mousein == 1 && evt.getSource()==newspaper){
				System.out.println("Newspaper");
			}
			if (mousein == 2 && evt.getSource()==map){
				showMap();
			}
			if (mousein == 3 && evt.getSource()==close){
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
			if (mousein == 4 && evt.getSource()==govClose){
				Empous.Gov.setGov(1, freedom.getValue());
				Empous.Gov.setGov(2, military.getValue());
				Empous.Gov.setGov(3, taxes.getValue());
				Empous.Gov.setGov(4, education.getValue());
				Empous.Gov.setGov(5, infrastructure.getValue());
				Empous.Gov.setGov(6, environment.getValue());
				Empous.Gov.setGov(7, sciencetech.getValue());
				Empous.Gov.setGov(8, healthcare.getValue());
				Empous.Gov.setGov(9, admin.getValue());
				Empous.Gov.setMJ(mjbox.isSelected());
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		}
	}
}
