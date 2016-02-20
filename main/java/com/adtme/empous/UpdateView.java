package main.java.com.adtme.empous;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UpdateView extends SubMenu{
	private static final long serialVersionUID = 1L;
	
	private Map mapimage;
	private JButton newspaper;
	private JButton map;
	private JButton close;
	private JTextArea jenn;
	private JPanel lines;
	
	private int mousein = 0;

	public UpdateView(int input) {
		super();
		setTitle("Update");
		icon = new ImageIcon("src/main/resources/images/JennIcon.png");
		sectorstr = "Update";
		
		DescColor = Color.BLACK;
		
		newspaper = new JButton("Newspaper");
		newspaper.addMouseListener(buttonWatch);
		map = new JButton("Map");
		map.addMouseListener(buttonWatch);
		close = new JButton("Close");
		close.addMouseListener(buttonWatch);
		
		buttons.add(newspaper);
		buttons.add(map);
		buttons.add(close);
	}
	
	public void display(int firstupdate){
		String line1 = "", line2 = "", line3 = "";
		jenn = new JTextArea();
		jenn.setLineWrap(true);
		jenn.setWrapStyleWord(true);
		jenn.setEditable(false);
		jenn.setSize(420, 200);
		jenn.setFont(description.getFont());
		if (firstupdate==1){
			System.out.println("Welcome to the game...");
			description.setText("Hi! My name is Jennifer.");
			jenn.setText("I'm your administrative assistant and I'm " +
					"glad to welcome you to the mayor's office! I will be here to keep you up " +
					"to date on the events in your empire and give you suggestions on how you " +
					"can make improvements.\n\n" +
					""+
					"Remember as you go that the number one priority is the happiness of your " +
					"citizens. If you treat them well, your empire will no doubt grow to " +
					"proportions you never imagined!\n\n" +
					"" +
					"I look forward to working with you!");
		}
		else{
			line1=suggest(1);
			line2=suggest(2);
			line3=suggest(3);
			
			jenn.setText(line1+"\n\n"+line2+"\n\n"+line3);
			
			if(Empous.Gov.publicopinion<=10){
				description.setText("Your empire's status is ABYSMAL");
			}
			else if(Empous.Gov.publicopinion<=25){
				description.setText("Your empire's status is TERRIBLE");
			}
			else if(Empous.Gov.publicopinion<=50){
				description.setText("Your empire's status is BAD");
			}
			else if(Empous.Gov.publicopinion<=75){
				description.setText("Your empire's status is GOOD");
			}
			else if(Empous.Gov.publicopinion<=90){
				description.setText("Your empire's status is GREAT");
			}
			else if(Empous.Gov.publicopinion<=100){
				description.setText("Your empire's status is UTOPIAN");
			}
			
			if (Empous.Gov.riotstate!=0){
				jenn.setText("YOUR CITIZENS ARE RIOTING! IMPROVE THE SITUATION QUICK!\n\n" +
						"If you don't make some good changes, there is no saying what will become " +
						"of your empire's stability! You can always increase the military for now, " +
						"but there is no substitute for fixing the underlying causes!");
			}
		}
		content.add(jenn);
		
		setVisible(true);
		panel.revalidate();
		panel.repaint();
	}
	
	public String suggest(int line){
		int temp;
		switch(line){
		case(1):temp=Empous.game.bad1; break;
		case(2):temp=Empous.game.bad2; break;
		case(3):temp=Empous.game.bad3; break;
		default:temp=0; break;
		}
		
		switch(temp){
		case(1): return "Continue to grow your empire! Bigger is always better!";
		case(2): return "Your people need jobs to be happy. Try concentrating on getting them employed before you make any " +
				"other changes to your empire.";
		case(3): return "Your people are feeling oppressed. Maybe you could look into giving them more personal freedoms?";
		case(4): return "The citizenry is worried about your military. Too much is just as bad as too little.";
		case(5): return "Although necessary, nobody likes taxes!";
		case(6): return "Educated citizens lead happier lives, and are more productive too! Try giving them a boost in that area.";
		case(7): return "Nobody wants to live in a polluted empire. Maybe you could try looking into your environmental policies?";
		case(8): return "No single factor is as important to your Empire's successful advance than science and technology. " +
				"Well, except maybe the other factors...";
		case(9): return "Healthy people will live longer, be happier, and produce more. If only it wasn't so darn expensive!";
		case(10): return "I was kind of hoping for a raise this quarter; maybe you could increase administrative expenses?";
		case(11): return "I don't have a political opinion on Marijuana legalization...";
		case(12): return "The commercial sector is looking a little run-down. You should make sure that you maintain your " +
				"funding levels for infrastructure!";
		case(13): return "The residential sector is looking a little run-down. You should make sure that you maintain your " +
		"funding levels for infrastructure!";
		case(14): return "The industrial sector is looking a little run-down. You should make sure that you maintain your " +
		"funding levels for infrastructure!";
		case(15): return "The lumber mill sector is looking a little run-down. You should make sure that you maintain your " +
		"funding levels for infrastructure!";
		case(16):  return "People are complaining about potholes and utilities can barely keep power flowing through " +
				"the current transmission lines. Increase your infrastructure spending, quick!";
		case(17): return "Running a deficit is bad news--you can't buy new things, and your citizens will not appreciate " +
				"carrying the debt you created!";
		default: return "";
		}
	}
	
	public void showMap(){
		mapimage = new Map();
		mapimage.addMouseListener(buttonWatch);
		
		setContentPane(mapimage);
		mapimage.revalidate();
		repaint();
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
