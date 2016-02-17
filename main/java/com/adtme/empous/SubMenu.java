package main.java.com.adtme.empous;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class SubMenu extends JFrame{
	private Map mapimage;
	private int sector;
	private String sectorstr;
	private JPanel panel;
	private JPanel content;
	private JPanel subcontent1;
	private JPanel subcontent2;
	private JLabel description;
	private JTextArea jenn;
	private JPanel lines;
	private JPanel overpanel;
	private Color DescColor;
	private JPanel buttons;
	private JButton buysell;
	private JButton newspaper;
	private JButton map;
	private JButton close;
	private ImageIcon icon;
	private GridBagConstraints c;
	private ButtonClick buttonWatch;
	
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
	
	int[][] stats = new int[5][3];
	int[][] sum = new int[1][4];
	
	private int mousein = 0;
	private int choice = 0;

	public SubMenu(int input){
		super(); //Create the frame
		buttonWatch = new ButtonClick();
		
		setBackground(Color.WHITE);
		setSize(450,350); //Default window size
		setResizable(false);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation( (screensize.width - getWidth())/2, (screensize.height - getHeight())/2); // Put it in the middle
		
	    buttons = new JPanel();
	    buttons.setOpaque(false);
	    content = new JPanel();
		content.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		content.setOpaque(false);
		sector=input;
		
		overpanel = new JPanel();
		overpanel.setLayout(new OverlayLayout(overpanel));
		
		if (input <=4){
			if (input==1){
				setTitle("Sector View - Commercial");
				icon = new ImageIcon("src/main/resources/images/ComIcon.png");
				sectorstr = "Commercial";
			}
			else if (input==2){
				setTitle("Sector View - Residential");
				icon = new ImageIcon("src/main/resources/images/ResIcon.png");
				sectorstr = "Residential";
			}
			else if (input==3){
				setTitle("Sector View - Industrial");
				icon = new ImageIcon("src/main/resources/images/IndIcon.png");
				sectorstr = "Industrial";
			}
			else if (input==4){
				setTitle("Sector View - Lumber Mills");
				icon = new ImageIcon("src/main/resources/images/LumberIcon.png");
				sectorstr = "Lumber Mill";
			}
			DescColor = Color.GRAY;
			
			overpanel = new JPanel();
			overpanel.setLayout(new OverlayLayout(overpanel));
			
			lines = new JPanel();
			lines.setOpaque(false);
			lines.setBorder(BorderFactory.createMatteBorder(1,0,1,0, Color.BLACK));
			lines.setMaximumSize(new Dimension(200,128));
			
			overpanel.add(lines);
			
			content.setLayout(new GridLayout(1,2));
			subcontent1 = new JPanel();
			subcontent2 = new JPanel();
			
			overpanel.add(subcontent2);
			content.add(subcontent1);
			content.add(overpanel);
			
			buysell = new JButton("Buy/Sell");
			buysell.addMouseListener(buttonWatch);
			close = new JButton("Close");
			close.addMouseListener(buttonWatch);
			
			buttons.add(buysell);
			buttons.add(close);
		}
		else if (input==5){
			setTitle("Sector View - Government");
			icon = new ImageIcon("src/main/resources/images/GovIcon.png");
			sectorstr = "Government";
			
			DescColor = Color.GRAY;
			
			content.setLayout(new GridLayout(1,2));
			subcontent1 = new JPanel();
			subcontent2 = new JPanel();
			content.add(subcontent1);
			content.add(subcontent2);
			
			close = new JButton("Close");
			close.addMouseListener(buttonWatch);
			
			buttons.add(close);
		}
		else{
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
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setOpaque(false);
		
		description = new JLabel();
		description.setIconTextGap(10);
		description.setIcon(icon);
		description.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		description.setHorizontalAlignment(JLabel.LEFT);
		description.setForeground(DescColor);
		
		panel.add(description, BorderLayout.NORTH);
		panel.add(content, BorderLayout.CENTER);
		panel.add(buttons, BorderLayout.SOUTH);
		
		setContentPane(panel);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void GenerateView(Capital Sector){
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
	
	public void ShowSector(Capital Sector){
		if (sector==1){
			description.setText("<html>The Commercial sector provides jobs for your hardworking citizens, " +
					"and frivolous spending for your rich ones.</html>");
		}
		if (sector==2){
			description.setText("<html>The Residential sector provides a place for your citizens to rest " +
					"their weary heads.</html>");
		}
		if (sector==3){
			description.setText("<html>The Industrial sector provides necessary jobs and produces the widgets " +
					"that power the modern economy.</html>");
		}
		if (sector==4){
			description.setText("<html>What great empire could exist without lumber mills???</html>");
		}
		
		subcontent1.setLayout(new GridBagLayout());
		subcontent2.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		
		GenerateView(Sector);
		
		c.gridx = 0;
		c.weighty = 0.2;
		c.gridy = 0;
		c.anchor = GridBagConstraints.WEST;
		subcontent1.add(new JLabel("Your empire has"), c);
		c.gridy = 1;
		subcontent1.add(jla, c);
		c.gridy = 2;
		subcontent1.add(jlb, c);
		c.gridy = 3;
		subcontent1.add(jlc, c);
		c.gridy = 4;
		subcontent1.add(new JLabel("Total Resources Generated:"), c);
		
		c.weightx = 0.5;
		c.anchor = GridBagConstraints.CENTER;
		c.gridy = 0;
		subcontent2.add(new JPanel(), c);
		c.gridx = 1;
		subcontent2.add(new JLabel("<html>Jobs</html>"), c);
		c.gridx = 2;
		subcontent2.add(new JLabel("<html>Capital</html>"), c);
		c.gridx = 3;
		subcontent2.add(new JLabel("<html>Oil</html>"), c);
		c.gridx = 4;
		subcontent2.add(new JLabel("<html>Wood</html>"), c);
		c.gridy = 1;
		c.gridx = 0;
		subcontent2.add(new JLabel("X"), c);
		c.gridx = 1;
		subcontent2.add(jl1, c);
		c.gridx = 2;
		subcontent2.add(jl2, c);
		c.gridx = 3;
		subcontent2.add(jl3, c);
		c.gridx = 4;
		subcontent2.add(jl4, c);
		c.gridy = 2;
		c.gridx = 0;
		subcontent2.add(new JLabel("X"), c);
		c.gridx = 1;
		subcontent2.add(jl5, c);
		c.gridx = 2;
		subcontent2.add(jl6, c);
		c.gridx = 3;
		subcontent2.add(jl7, c);
		c.gridx = 4;
		subcontent2.add(jl8, c);
		c.gridy = 3;
		c.gridx = 0;
		subcontent2.add(new JLabel("X"), c);
		c.gridx = 1;
		subcontent2.add(jl9, c);
		c.gridx = 2;
		subcontent2.add(jl10, c);
		c.gridx = 3;
		subcontent2.add(jl11, c);
		c.gridx = 4;
		subcontent2.add(jl12, c);
		c.gridy = 4;
		c.gridx = 0;
		subcontent2.add(new JPanel(), c);
		c.gridx = 1;
		subcontent2.add(jl13, c);
		c.gridx = 2;
		subcontent2.add(jl14, c);
		c.gridx = 3;
		subcontent2.add(jl15, c);
		c.gridx = 4;
		subcontent2.add(jl16, c);
		
		
		setVisible(true);
		panel.revalidate();
	}
	
	public void showGov(){
		JSlider freedom = new JSlider(0,10,Empous.Gov.getGov(1));
		JSlider military = new JSlider(0,10,Empous.Gov.getGov(2));
		JSlider taxes = new JSlider(0,10,Empous.Gov.getGov(3));
		JSlider education = new JSlider(0,10,Empous.Gov.getGov(4));
		JSlider infrastructure = new JSlider(0,10,Empous.Gov.getGov(5));
		JSlider environment = new JSlider(0,10,Empous.Gov.getGov(6));
		JSlider sciencetech = new JSlider(0,10,Empous.Gov.getGov(7));
		JSlider healthcare = new JSlider(0,10,Empous.Gov.getGov(8));
		JSlider admin = new JSlider(0,10,Empous.Gov.getGov(9));
		JCheckBox mjbox = new JCheckBox("",Empous.Gov.getMJ());
		
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
		/*Empous.Gov.setGov(1, freedom.getValue());
		Empous.Gov.setGov(2, military.getValue());
		Empous.Gov.setGov(3, taxes.getValue());
		Empous.Gov.setGov(4, education.getValue());
		Empous.Gov.setGov(5, infrastructure.getValue());
		Empous.Gov.setGov(6, environment.getValue());
		Empous.Gov.setGov(7, sciencetech.getValue());
		Empous.Gov.setGov(8, healthcare.getValue());
		Empous.Gov.setGov(9, admin.getValue());
		Empous.Gov.setMJ(mjbox.isSelected());*/
	}
	
	public void showUpdate(int firstupdate){
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
						"but there is substitute for fixing the underlying causes!");
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
		}
		public void mouseExited(MouseEvent evt) {
			mousein=0;
		}
		public void mousePressed(MouseEvent evt) {}
		public void mouseReleased(MouseEvent evt) {
			if (mousein == 1 && evt.getSource()==buysell){
				choice = 1;
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
		}
	}
}

