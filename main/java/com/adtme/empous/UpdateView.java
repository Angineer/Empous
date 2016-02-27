package main.java.com.adtme.empous;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class UpdateView extends SubMenu{
	private static final long serialVersionUID = 1L;
	
	private Map mapimage;
	private Newspaper newsimage;
	private JButton newspaper;
	private JButton map;
	private JButton close;
	private JTextArea jenn;
	
	private ButtonClick buttonWatch;
	private int mousein = 0;

	public UpdateView(int newGame) {
		super();
		setTitle("Update");
		buttonWatch = new ButtonClick();
		
		newspaper = new JButton("Newspaper");
		newspaper.addMouseListener(buttonWatch);
		map = new JButton("Map");
		map.addMouseListener(buttonWatch);
		close = new JButton("Close");
		close.addMouseListener(buttonWatch);
		
		jenn = new JTextArea();
		jenn.setLineWrap(true);
		jenn.setWrapStyleWord(true);
		jenn.setEditable(false);
		jenn.setSize(420, 200);
		addContent(jenn);
		
		addButton(newspaper);
		addButton(map);
		addButton(close);
		
		refresh(newGame);
	}
	
	public void refresh(int newGame){
		String line1 = "", line2 = "", line3 = "";
		//jenn.setFont(description.getFont());
		if (newGame==1){
			setDescription("/main/resources/images/JennIcon.png", "Hi! My name is Jennifer.");
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
			
			if(Empous.Gov.getStat("publicopinion")==0){
				setDescription("/main/resources/images/JennIcon.png", "Your empire's status is DESTROYED");
				jenn.setText("Despite your best efforts, your dream of an empire that ruled the world has " +
				"come to a bitter, fruitless end. \n\n It has been an honor serving you, mayor.");
			}
			else if(Empous.Gov.getStat("publicopinion")<=10){
				setDescription("/main/resources/images/JennIcon.png", "Your empire's status is ABYSMAL");
			}
			else if(Empous.Gov.getStat("publicopinion")<=25){
				setDescription("/main/resources/images/JennIcon.png", "Your empire's status is TERRIBLE");
			}
			else if(Empous.Gov.getStat("publicopinion")<=50){
				setDescription("/main/resources/images/JennIcon.png", "Your empire's status is BAD");
			}
			else if(Empous.Gov.getStat("publicopinion")<=75){
				setDescription("/main/resources/images/JennIcon.png", "Your empire's status is GOOD");
			}
			else if(Empous.Gov.getStat("publicopinion")<=90){
				setDescription("/main/resources/images/JennIcon.png", "Your empire's status is GREAT");
			}
			else if(Empous.Gov.getStat("publicopinion")<=100){
				setDescription("/main/resources/images/JennIcon.png", "Your empire's status is UTOPIAN");
			}
			else if(Empous.Gov.getStat("publicopinion")>100){
				setDescription("/main/resources/images/JennIcon.png", "Your empire's status is COMPLETE");
				jenn.setText("You did it! Your hard work and perseverence have paid off and your empire " +
				"now governs all of human existence. Who knew this would be so rewarding?");
			}
			// TODO fix hierarchy of text and use local variable to store public opinion, 
			// rather than calling method in each if statement
			/*if (Empous.Gov.riotstate!=0){
				jenn.setText("YOUR CITIZENS ARE RIOTING! IMPROVE THE SITUATION QUICK!\n\n" +
						"If you don't make some good changes, there is no saying what will become " +
						"of your empire's stability! You can always increase the military for now, " +
						"but there is no substitute for fixing the underlying causes!");
			}*/
		}
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
	public void showNewspaper(){
		newsimage = new Newspaper();
		newsimage.addMouseListener(buttonWatch);
		
		setContentPane(newsimage);
		newsimage.revalidate();
		repaint();
	}
	
	public class ButtonClick implements MouseListener {
		public void mouseClicked(MouseEvent evt) {
			if (evt.getSource()==mapimage || evt.getSource()==newsimage){
				display();
			}
		}
		public void mouseEntered(MouseEvent evt) {
			if (evt.getSource()==newspaper){
				mousein = 1;
			}
			if (evt.getSource()==map){
				mousein = 2;
			}
			if (evt.getSource()==close){
				mousein = 3;
			}
		}
		public void mouseExited(MouseEvent evt) {
			mousein=0;
		}
		public void mousePressed(MouseEvent evt) {}
		public void mouseReleased(MouseEvent evt) {
			if (mousein == 1 && evt.getSource()==newspaper){
				showNewspaper();
			}
			if (mousein == 2 && evt.getSource()==map){
				showMap();
			}
			if (mousein == 3 && evt.getSource()==close){
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		}
	}
}
