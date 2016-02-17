package main.java.com.adtme.empous;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class InGame extends JPanel {
	private BufferedImage chairimg;
	private Font sectionTitleFont = new Font("SansSerif", Font.BOLD, 14);
	private JPanel sectors;
	private JPanel control;
	private JPanel chair;
	private JPanel meter;
	private Happyometer hmeter;
	private JPanel resources;
	private JButton commercial;
	private JButton residential;
	private JButton industrial;
	private JButton lumbermill;
	private JButton government;
	private JButton turn;
	private JButton savereturn;
	private long pop = 0;
	private long jobs = 0;
	private int cap;
	private int wood;
	private int oil;
	private int happy;
	private JLabel poplabel;
	private JLabel joblabel;
	private JLabel caplabel;
	private JLabel woodlabel;
	private JLabel oillabel;
	
	public int bad1=0, bad2=0, bad3=0;
	
	private int mousein = 0;
	private int choice = 0;
	
	public InGame(){
		chairimg = Empous.LoadImage("src/main/resources/images/chair.png");
		setLayout(new BorderLayout());
		ButtonClick buttonWatch = new ButtonClick ();
		
		commercial = new JButton("Commercial");
		commercial.addMouseListener(buttonWatch);
		residential = new JButton("Residential");
		residential.addMouseListener(buttonWatch);
		industrial = new JButton("Industrial");
		industrial.addMouseListener(buttonWatch);
		lumbermill = new JButton("Lumber Mills");
		lumbermill.addMouseListener(buttonWatch);
		government = new JButton("Government");
		government.addMouseListener(buttonWatch);
		turn = new JButton("Finish, Save, & Process Turn");
		turn.addMouseListener(buttonWatch);
		savereturn = new JButton("Save & Return to Menu");
		savereturn.addMouseListener(buttonWatch);
		
		sectors = new JPanel();
		sectors.setLayout(new GridLayout(1,4));
		sectors.add(commercial);
		sectors.add(residential);
		sectors.add(industrial);
		sectors.add(lumbermill);
		sectors.add(government);
		
		control = new JPanel();
		control.setLayout(new GridLayout(1,2));
		control.add(turn);
		control.add(savereturn);
		
		chair = new JPanel();
		chair.setLayout(null);
		chair.setOpaque(false);
		
		hmeter = new Happyometer();
		meter = new JPanel();
		meter.setLayout(new BorderLayout());
		JLabel meterTitle = new JLabel("Happy-o-meter");
		meterTitle.setFont(sectionTitleFont);
		meterTitle.setBorder(BorderFactory.createEmptyBorder(20, 0 , 20, 0));
		meter.setBorder(BorderFactory.createEmptyBorder(50, 10, 50, 10));
		meter.add(meterTitle, BorderLayout.NORTH);
		meter.add(hmeter, BorderLayout.CENTER);
		meter.setOpaque(false);
		
		poplabel = new JLabel();
		poplabel.setBackground(Color.white);
		poplabel.setOpaque(true);
		poplabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
		joblabel = new JLabel();
		joblabel.setBackground(Color.white);
		joblabel.setOpaque(true);
		joblabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
		caplabel = new JLabel();
		caplabel.setBackground(Color.white);
		caplabel.setOpaque(true);
		caplabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
		woodlabel = new JLabel();
		woodlabel.setBackground(Color.white);
		woodlabel.setOpaque(true);
		woodlabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
		oillabel = new JLabel();
		oillabel.setBackground(Color.white);
		oillabel.setOpaque(true);
		oillabel.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
		
		resources = new JPanel();
		resources.setLayout(new GridLayout(6,1));
		resources.setBackground(Color.white);
		JLabel resourceTitle = new JLabel("Resources");
		resourceTitle.setFont(sectionTitleFont);
		resources.setBorder(BorderFactory.createEmptyBorder(70, 10, 150, 10));
		resources.add(resourceTitle);
		resources.add(poplabel);
		resources.add(caplabel);
		resources.add(joblabel);
		resources.add(woodlabel);
		resources.add(oillabel);
		resources.setOpaque(false);
		
		add(sectors, BorderLayout.NORTH); //Put all the pieces on the panel
		add(chair, BorderLayout.CENTER);
		add(meter, BorderLayout.EAST);
		add(resources, BorderLayout.WEST);
		add(control, BorderLayout.SOUTH);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(chairimg, 0, 0, 640, 480, null);
	}
	
	public void update(int newGame){
		System.out.println("Showing new update...");
		SubMenu Sub = new SubMenu(6);
		if(newGame==1) Sub.showUpdate(1);
		else Sub.showUpdate(0);
		
		generateView();
	}
	
	public void generateView(){
		UpdateVars();
		
		if(pop<1000){
			poplabel.setText("Population = "+pop);
		}
		else if (pop<1000000){
			poplabel.setText("Population = "+round2(pop)+"K");
		}
		else if (pop>=1000000){
			poplabel.setText("Population = "+round2(pop)+"M");
		}
		caplabel.setText("Capital = "+cap);
		joblabel.setText("Jobs = "+jobs);
		woodlabel.setText("Wood = "+wood);
		oillabel.setText("Oil = "+oil);
		
		repaint();
	}
	
	public static double round2(double num) {
		if (num>=1000000){
			double result = (double)num / 10000;
			result = Math.round(result);
			result = result / 100;
			return result;
		}
		else if (num>=1000){
			double result = (double)num / 10;
			result = Math.round(result);
			result = result / 100;
			return result;
		}
		else{
			double result = (double)num;
			return result;
		}
	}
	
	public class ButtonClick implements MouseListener {
		
		public void mouseClicked(MouseEvent evt) {}
		public void mouseEntered(MouseEvent evt) {
			if (evt.getSource()==commercial){
				mousein = 1;
			}
			if (evt.getSource()==residential){
				mousein = 2;
			}
			if (evt.getSource()==industrial){
				mousein = 3;
			}
			if (evt.getSource()==lumbermill){
				mousein = 4;
			}
			if (evt.getSource()==government){
				mousein = 5;
			}
			if (evt.getSource()==turn){
				mousein = 6;
			}
			if (evt.getSource()==savereturn){
				mousein = 7;
			}
		}
		public void mouseExited(MouseEvent evt) {
			mousein=0;
		}
		public void mousePressed(MouseEvent evt) {}
		public void mouseReleased(MouseEvent evt) {
			if (mousein == 1 && evt.getSource()==commercial){
				SubMenu Sub = new SubMenu(1);
				Sub.ShowSector(Empous.Com);
			}
			if (mousein == 2 && evt.getSource()==residential){
				SubMenu Sub = new SubMenu(2);
				Sub.ShowSector(Empous.Res);
			}
			if (mousein == 3 && evt.getSource()==industrial){
				SubMenu Sub = new SubMenu(3);
				Sub.ShowSector(Empous.Ind);
			}
			if (mousein == 4 && evt.getSource()==lumbermill){
				SubMenu Sub = new SubMenu(4);
				Sub.ShowSector(Empous.LM);
			}
			if (mousein == 5 && evt.getSource()==government){
				SubMenu Sub = new SubMenu(5);
				Sub.showGov();
			}
			if (mousein == 6 && evt.getSource()==turn){
				choice = 6;
			}
			if (mousein == 7 && evt.getSource()==savereturn){
				System.out.println("Saving and returning to menu!");
				Empous.window.display(Empous.menu);
			}
		}
	}
	
	private class Happyometer extends JPanel{
		int bound = 30;

		Happyometer(){
			setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0,bound,0,bound),
					BorderFactory.createLineBorder(Color.BLACK,2)));
			setOpaque(false);
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			g.setColor(Color.WHITE);
			g.fillRect(bound,0,getWidth()-2*bound,getHeight());
			if (happy<=15){
				g.setColor(Color.red);
			}
			else if (happy<=35){
				g.setColor(Color.orange);
			}
			else{
				g.setColor(Color.green);
			}
			g.fillRect(bound, getHeight()-level(), getWidth()-2*bound, level());
		}
		
		private int level(){
			double level = getHeight()*(double)happy/100;
			return (int) Math.round(level);
		}
	}
	
	private int riotGen(){ //Riots are generated randomly, scaled by the current happiness level and military
		Random riotlevel = new Random();
		int riot = (int) Math.abs(Math.round(riotlevel.nextGaussian()*100/happy/Empous.Gov.getGov(2)));
		if(riot>=1){
//			System.out.println("Your citizens are rioting!!");
			for(int a=1;a<=4;a++){
				switch(a){
				case 1: Empous.Com.build_level-=riot*2*Empous.Com.build_rate;
						break;
				case 2: Empous.Res.build_level-=riot*2*Empous.Res.build_rate;;
						break;
				case 3: Empous.Ind.build_level-=riot*2*Empous.Ind.build_rate;;
						break;
				case 4: Empous.LM.build_level-=riot*2*Empous.LM.build_rate;;
						break;
				}
			}
		}
		return riot;
	}
	
	public void UpdateVars(){
		happy = Empous.Gov.publicopinion;
		cap = Empous.Gov.reserve;
		wood = Empous.Gov.woodstock;
		oil = Empous.Gov.oiltank;
		pop = Empous.Gov.census;
		jobs = Empous.Gov.employment;
	}

	public int Process(){
		double delhappy;
		double f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17;
		double[] temp1={1,0}, temp2={1,0}, temp3={1,0};
		
		if (choice==7){
			return 1; //Skip processing if they want to go to the menu
		}
		
		Empous.Gov.employment = (Empous.Com.generate2()+Empous.Ind.generate2()+Empous.LM.generate2()) *
				(1+Empous.Gov.getGov(4)/50+Empous.Gov.getGov(7)/50);	//Calculate proportional resources, Edu Sci
		Empous.Gov.census = Empous.Res.generate2()*(1+Empous.Gov.getGov(8)/20+Empous.Gov.getGov(9)); //Health Admin
		Empous.Gov.reserve += (Empous.Com.generate1()+Empous.Res.generate1());
		Empous.Gov.woodstock += Empous.LM.generate1(); //Edu Env
		Empous.Gov.oiltank += Empous.Ind.generate1(); //Sci Mil
		
		//TODO Add depreciation of sectors
		Empous.Com.upkeep();
		Empous.Res.upkeep();
		Empous.Ind.upkeep();
		Empous.LM.upkeep();
		Empous.Inf.upkeep();
		
		f1 = (Empous.Gov.census/50000000000D)*0.6; //population factor
		if ((Empous.Gov.census*0.65-Empous.Gov.employment)/(Empous.Gov.census*0.65) < 0) f2 = 0.02; //unemployment factor
		else if((Empous.Gov.census*0.65-Empous.Gov.employment)/(Empous.Gov.census*0.65) > -1) f2 = -0.02;
		else f2 = (-10*((Empous.Gov.census*0.65-Empous.Gov.employment)/(Empous.Gov.census*0.65))+1)*0.02;
		f3 = (-.0058*Math.pow(Empous.Gov.getGov(1),3)+.0692*Math.pow(Empous.Gov.getGov(1),2)
				+.0667*Empous.Gov.getGov(1)-1)*0.02; // freedom factor
		f4 = (-.08*Math.pow(Empous.Gov.getGov(2),2)+0.8*Empous.Gov.getGov(2)-1)*0.03125;	// military factor
		f5 = (-.12*Empous.Gov.getGov(3)+0.2)*0.02;	// taxes factor
		f6 = (.0021*Math.pow(Empous.Gov.getGov(4),3)-.0625*Math.pow(Empous.Gov.getGov(4),2)
				+.6167*Empous.Gov.getGov(4)-1)*0.02; // education factor
		f7 = (.0021*Math.pow(Empous.Gov.getGov(6),3)-.0625*Math.pow(Empous.Gov.getGov(6),2)
				+.6167*Empous.Gov.getGov(6)-1)*0.02;	// environment factor
		f8 = (-.03375*Math.pow(Empous.Gov.getGov(7),2)+.4575*Empous.Gov.getGov(7)-.5)*0.02; // science & technology factor
		f9 = (.0021*Math.pow(Empous.Gov.getGov(8),3)-.0625*Math.pow(Empous.Gov.getGov(8),2)
				+.6167*Empous.Gov.getGov(8)-1)*0.02;	// healthcare factor
		f10 = (-.03*Math.pow(Empous.Gov.getGov(9),2)+0.3*Empous.Gov.getGov(9)-.25)*0.02;	// administration factor
		f11 = (Empous.Gov.getMJ()?1:0)*0.02;	// legalize it man!
		f12 = (Empous.Com.build_level/Empous.Com.max_build-0.8)*0.02;	// maintenance level factors
		f13 = (Empous.Res.build_level/Empous.Res.max_build-0.8)*0.02;
		f14 = (Empous.Ind.build_level/Empous.Ind.max_build-0.8)*0.02;
		f15 = (Empous.LM.build_level/Empous.LM.max_build-0.8)*0.02;
		f16 = (Empous.Inf.getLevel()/Empous.Inf.getMaxLevel()-0.8)*0.02;
		if(Empous.Gov.reserve<0) f17 = 0.05*Empous.Gov.reserve/100;
		else f17 = 0;
		
		double[][] rank = {{f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17},
							{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17}};
		
		for (int a=0; a<=16; a++){	//Find out which factor is the most detrimental
			if (rank[0][a]<temp3[0]){
				if(rank[0][a]<temp2[0]){
					if(rank[0][a]<temp1[0]){
						temp3[0]=temp2[0];
						temp3[1]=temp2[1];
						temp2[0]=temp1[0];
						temp2[1]=temp1[1];
						temp1[0]=rank[0][a];
						temp1[1]=rank[1][a];
					}
					else{
						temp3[0]=temp2[0];
						temp3[1]=temp2[1];
						temp2[0]=rank[0][a];
						temp2[1]=rank[1][a];
					}
				}
				else{
					temp3[0]=rank[0][a];
					temp3[1]=rank[1][a];
				}
			}
		}
		bad1=(int) temp1[1];
		bad2=(int) temp2[1];
		bad3=(int) temp3[1];
		
//		System.out.println("factor ="+f1);
//		System.out.println("factor ="+f2);
//		System.out.println("factor ="+f3);
//		System.out.println("factor ="+f4);
//		System.out.println("factor ="+f5);
//		System.out.println("factor ="+f6);
//		System.out.println("factor ="+f7);
//		System.out.println("factor ="+f8);
//		System.out.println("factor ="+f9);
//		System.out.println("factor ="+f10);
//		System.out.println("factor ="+f11);
//		System.out.println("factor ="+f12);
//		System.out.println("factor ="+f13);
//		System.out.println("factor ="+f14);
//		System.out.println("factor ="+f15);
//		System.out.println("factor ="+f16);
//		System.out.println("factor ="+f17);
		
		delhappy=10*(f1+f2+f3+f4+f5+f6+f7+f8+f9+f10+f11+f12+f13+f14+f15+f16+f17);	//Change in happiness
		
		Empous.Gov.publicopinion+=Math.round(delhappy);
		if (Empous.Gov.publicopinion<0) Empous.Gov.publicopinion=0;
		
		Empous.Gov.riotstate = riotGen();	//See if the people riot
		
		
		if (Empous.Gov.publicopinion>=100 || Empous.Gov.publicopinion==0){ //If they won or lost, stop playing
			return 1;
		}
		return 0; //If no previous conditions met, continue playing
	}	
}
