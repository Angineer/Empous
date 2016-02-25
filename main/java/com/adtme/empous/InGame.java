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
	
	public InGame(){
		chairimg = Empous.LoadImage("/main/resources/images/chair.png");
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
	
	public void showUpdate(int newGame){
		System.out.println("Showing new update...");
		generateView();
		UpdateView update = new UpdateView(newGame);
		update.display();
	}
	
	public void updateVars(){
		happy = Empous.Gov.getStat("publicopinion");
		cap = Empous.Gov.getStat("reserve");
		wood = Empous.Gov.getStat("woodstock");
		oil = Empous.Gov.getStat("oiltank");
		pop = Empous.Gov.getStat("census");
		jobs = Empous.Gov.getStat("employment");
	}
	
	public void generateView(){
		updateVars();
		
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
	
	private static double round2(double num) {
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
	
	private boolean riotGen(){ //Riots are generated randomly, scaled by the current happiness level and military
		Random riotlevel = new Random();
		int riot = (int) Math.abs(Math.round(riotlevel.nextGaussian()*100/happy/Empous.Gov.getStat("military")));
		if(riot>=1){
//			System.out.println("Your citizens are rioting!!");
			for(int a=1;a<=4;a++){
				switch(a){
				case 1: Empous.Com.setBuildLevel(Empous.Com.getBuildLevel()-riot*2*Empous.Com.getBuildRate());
						break;
				case 2: Empous.Res.setBuildLevel(Empous.Res.getBuildLevel()-riot*2*Empous.Res.getBuildRate());
						break;
				case 3: Empous.Ind.setBuildLevel(Empous.Ind.getBuildLevel()-riot*2*Empous.Ind.getBuildRate());
						break;
				case 4: Empous.LM.setBuildLevel(Empous.LM.getBuildLevel()-riot*2*Empous.LM.getBuildRate());
						break;
				}
			}
			return true;
		}
		return false;
	}


	public int Process(){
		double delhappy;
		int delhappy_int;
		double f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16, f17;
		double[] temp1={1,0}, temp2={1,0}, temp3={1,0};
		
		Empous.Gov.setStat("employment", (Empous.Com.generate2()+Empous.Ind.generate2()+Empous.LM.generate2()) *
				(1+Empous.Gov.getStat("education")/50+Empous.Gov.getStat("sciencetech")/50));	//Calculate proportional resources, Edu Sci
		Empous.Gov.setStat("census", Empous.Res.generate2()*(1+Empous.Gov.getStat("healthcare")/20+Empous.Gov.getStat("admin"))); //Health Admin
		Empous.Gov.setStat("reserve", Empous.Gov.getStat("reserve")+(Empous.Com.generate1()+Empous.Res.generate1()));
		Empous.Gov.setStat("woodstock", Empous.Gov.getStat("woodstock")+Empous.LM.generate1()); //Edu Env
		Empous.Gov.setStat("oiltank", Empous.Gov.getStat("oiltank")+Empous.Ind.generate1()); //Sci Mil
		
		//TODO Add depreciation of sectors
		Empous.Com.upkeep();
		Empous.Res.upkeep();
		Empous.Ind.upkeep();
		Empous.LM.upkeep();
		Empous.Inf.upkeep();
		
		f1 = (Empous.Gov.getStat("census")/50000000000D)*0.6; //population factor
		if ((Empous.Gov.getStat("census")*0.65-Empous.Gov.getStat("employment"))/(Empous.Gov.getStat("census")*0.65) < 0) f2 = 0.02; //unemployment factor
		else if((Empous.Gov.getStat("census")*0.65-Empous.Gov.getStat("employment"))/(Empous.Gov.getStat("census")*0.65) > -1) f2 = -0.02;
		else f2 = (-10*((Empous.Gov.getStat("census")*0.65-Empous.Gov.getStat("employment"))/(Empous.Gov.getStat("census")*0.65))+1)*0.02;
		f3 = (-.0058*Math.pow(Empous.Gov.getStat("freedom"),3)+.0692*Math.pow(Empous.Gov.getStat("freedom"),2)
				+.0667*Empous.Gov.getStat("freedom")-1)*0.02; // freedom factor
		f4 = (-.08*Math.pow(Empous.Gov.getStat("military"),2)+0.8*Empous.Gov.getStat("military")-1)*0.03125;	// military factor
		f5 = (-.12*Empous.Gov.getStat("taxes")+0.2)*0.02;	// taxes factor
		f6 = (.0021*Math.pow(Empous.Gov.getStat("education"),3)-.0625*Math.pow(Empous.Gov.getStat("education"),2)
				+.6167*Empous.Gov.getStat("education")-1)*0.02; // education factor
		f7 = (.0021*Math.pow(Empous.Gov.getStat("environment"),3)-.0625*Math.pow(Empous.Gov.getStat("environment"),2)
				+.6167*Empous.Gov.getStat("environment")-1)*0.02;	// environment factor
		f8 = (-.03375*Math.pow(Empous.Gov.getStat("sciencetech"),2)+.4575*Empous.Gov.getStat("sciencetech")-.5)*0.02; // science & technology factor
		f9 = (.0021*Math.pow(Empous.Gov.getStat("healthcare"),3)-.0625*Math.pow(Empous.Gov.getStat("healthcare"),2)
				+.6167*Empous.Gov.getStat("healthcare")-1)*0.02;	// healthcare factor
		f10 = (-.03*Math.pow(Empous.Gov.getStat("admin"),2)+0.3*Empous.Gov.getStat("admin")-.25)*0.02;	// administration factor
		f11 = (Empous.Gov.getMJ()?1:0)*0.02;	// legalize it man!
		f12 = (Empous.Com.getBuildLevel()/Empous.Com.getMaxBuild()-0.8)*0.02;	// maintenance level factors
		f13 = (Empous.Res.getBuildLevel()/Empous.Res.getMaxBuild()-0.8)*0.02;
		f14 = (Empous.Ind.getBuildLevel()/Empous.Ind.getMaxBuild()-0.8)*0.02;
		f15 = (Empous.LM.getBuildLevel()/Empous.LM.getMaxBuild()-0.8)*0.02;
		f16 = (Empous.Inf.getLevel()/Empous.Inf.getMaxLevel()-0.8)*0.02;
		if(Empous.Gov.getStat("reserve")<0) f17 = 0.05*Empous.Gov.getStat("reserve")/100;
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
		
		delhappy=10*(f1+f2+f3+f4+f5+f6+f7+f8+f9+f10+f11+f12+f13+f14+f15+f16+f17);	//Change in happiness
		delhappy_int=(int) Math.round(delhappy);
		
		// Testing code
		System.out.println("factor1 ="+f1);
		System.out.println("factor2 ="+f2);
		System.out.println("factor3 ="+f3);
		System.out.println("factor4 ="+f4);
		System.out.println("factor5 ="+f5);
		System.out.println("factor6 ="+f6);
		System.out.println("factor7 ="+f7);
		System.out.println("factor8 ="+f8);
		System.out.println("factor9 ="+f9);
		System.out.println("factor10 ="+f10);
		System.out.println("factor11 ="+f11);
		System.out.println("factor12 ="+f12);
		System.out.println("factor13 ="+f13);
		System.out.println("factor14 ="+f14);
		System.out.println("factor15 ="+f15);
		System.out.println("factor16 ="+f16);
		System.out.println("factor17 ="+f17);
		System.out.println("delhappy = "+delhappy+","+delhappy_int);
		
		Empous.Gov.setStat("publicopinion",Empous.Gov.getStat("publicopinion")+delhappy_int);
		if (Empous.Gov.getStat("publicopinion")<0) Empous.Gov.setStat("publicopinion", 0);
		
		Empous.Gov.setRiot(riotGen());	//See if the people riot
		
		// Check for win or lose
		if (Empous.Gov.getStat("publicopinion")>=100 || Empous.Gov.getStat("publicopinion")==0){
			return 1;
		}
		return 0; //If no previous conditions met, continue playing
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
				SectorView Sub = new SectorView(InGame.this, Empous.Com);
				Sub.display();
			}
			if (mousein == 2 && evt.getSource()==residential){
				SectorView Sub = new SectorView(InGame.this, Empous.Res);
				Sub.display();
			}
			if (mousein == 3 && evt.getSource()==industrial){
				SectorView Sub = new SectorView(InGame.this, Empous.Ind);
				Sub.display();
			}
			if (mousein == 4 && evt.getSource()==lumbermill){
				SectorView Sub = new SectorView(InGame.this, Empous.LM);
				Sub.display();
			}
			if (mousein == 5 && evt.getSource()==government){
				GovView Sub = new GovView();
				Sub.display();
			}
			if (mousein == 6 && evt.getSource()==turn){
				LoadSaveManager.saveGame(Empous.saveSlot);
				int end=Process();
				if(end==1){
					Empous.winLose();
					Empous.window.display(Empous.menu);
				}
				else{
					showUpdate(0);
				}
			}
			if (mousein == 7 && evt.getSource()==savereturn){
				System.out.println("Saving and returning to menu...");
				LoadSaveManager.saveGame(Empous.saveSlot);
				Empous.window.setTitle("Empous");
				Empous.window.display(Empous.menu);
			}
		}
	}
}
