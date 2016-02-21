package main.java.com.adtme.empous;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
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
	
	private JPanel content1;
	private JPanel content2;
	
	private JButton close;
	
	private ButtonClick buttonWatch;
	private int mousein = 0;

	public GovView() {
		super();
		buttonWatch = new ButtonClick();
		
		setTitle("Sector View - Government");
		
		setDescription("src/main/resources/images/GovIcon.png", "<html>The Government makes the laws and set the policies that tell " +
				"your citizens what they can and can't do.</html>");
		
		setContentLayout(new GridLayout(1,2));
		content1 = new JPanel();
		content2 = new JPanel();
		content1.setLayout(new GridLayout(10,1));
		content2.setLayout(new GridLayout(10,1));
		addContent(content1);
		addContent(content2);
		
		close = new JButton("Close");
		close.addMouseListener(buttonWatch);
		
		addButton(close);
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
		
		content1.add(new JLabel("Freedom"));
		content1.add(new JLabel("Military"));
		content1.add(new JLabel("Taxes"));
		content1.add(new JLabel("Education"));
		content1.add(new JLabel("Infrastructure"));
		content1.add(new JLabel("Environment"));
		content1.add(new JLabel("Science & Tech"));
		content1.add(new JLabel("Healthcare"));
		content1.add(new JLabel("Administration"));
		content1.add(new JLabel("Legalize Marijuana"));
		
		content2.add(freedom);
		content2.add(military);
		content2.add(taxes);
		content2.add(education);
		content2.add(infrastructure);
		content2.add(environment);
		content2.add(sciencetech);
		content2.add(healthcare);
		content2.add(admin);
		content2.add(mjbox);
		
		content1.setBorder(BorderFactory.createEmptyBorder(5,75,5,0));
		content2.setBorder(BorderFactory.createEmptyBorder(5,0,5,35));
		
		super.display();
	}
	
	public class ButtonClick implements MouseListener {
		public void mouseClicked(MouseEvent evt) {}
		public void mouseEntered(MouseEvent evt) {
			if (evt.getSource()==close){
				mousein = 1;
			}
		}
		public void mouseExited(MouseEvent evt) {
			mousein=0;
		}
		public void mousePressed(MouseEvent evt) {}
		public void mouseReleased(MouseEvent evt) {
			if (mousein == 1 && evt.getSource()==close){
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
