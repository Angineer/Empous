package main.java.com.adtme.empous;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class BuySell extends JFrame{
	private JPanel panel;
	private JPanel current;
	private JPanel content;
	private JPanel buttons;
	private JPanel subcontent1;
	private JPanel subcontent11;
	private JPanel subcontent12;
	private JTextField buynumber;
	private JTextField sellnumber;
	private JComboBox buytype;
	private JComboBox selltype;
	private JButton buy;
	private JButton ok;
	private JButton close;
	private int buysector;
	private int bos = 1;
	private int changed = 0;
	private int stats[][] = new int[3][3];
	private int sum[][] = new int[1][3];	
	private JLabel cl1;
	private JLabel cl2;
	private JLabel cl3;
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JLabel jl4;
	private JLabel jl5;
	private JLabel jl6;
	private JLabel jl7;
	private JLabel jl8;
	private JLabel jl9;
	
	private GridBagConstraints c;
	
	private int mousein = 0;
	private int choice = 0;
	
	public BuySell(int sector){
		super(); //Create the frame
		setTitle("Buy/Sell");
		
		ButtonClick buttonWatch = new ButtonClick();
		Change otherWatch = new Change();
		
		setBackground(Color.WHITE);
		setSize(450,250); //Default window size
		setResizable(false);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation( (screensize.width - getWidth())/2, (screensize.height - getHeight())/2); // Put it in the middle
	    
	    current = new JPanel();
	    current.setOpaque(false);
	    current.setLayout(new GridLayout(1,4));
	    
	    current.add(new JLabel("Resources: "));
	    current.setBorder(BorderFactory.createEmptyBorder(15,10,0,10));
	    
	    subcontent1 = new JPanel();
	    subcontent1.setBorder(BorderFactory.createEmptyBorder(15,25,15,25));
	    subcontent1.setLayout(new GridBagLayout());
	    subcontent11 = new JPanel();
	    subcontent11.setOpaque(false);
	    subcontent12 = new JPanel();
	    subcontent12.setOpaque(false);
	    
	    c = new GridBagConstraints();
	    c.ipadx = 15;
	    c.ipady = 3;
	    c.weightx = 0.5;
	    c.weighty = 0.25;
	    c.gridx = 0;
	    c.gridy = 0;
	    subcontent1.add(new JLabel("  "));
	    c.gridy = 1;
	    subcontent1.add(subcontent11, c);
	    c.gridy = 2;
	    subcontent1.add(subcontent12, c);
	    c.gridy = 3;
	    subcontent1.add(new JLabel("Total to spend:"), c);
	    
	    buynumber = new JTextField("0",2);
	    buynumber.addActionListener(otherWatch);
	    sellnumber = new JTextField("0",2);
	    sellnumber.addActionListener(otherWatch);
	    
	    String[] list = {"Small Commercial", "Med Commercial", "Large Commercial",
	    				"Small Residential", "Med Residential", "Large Residential",
	    				"Small Industrial", "Med Industrial", "Large Industrial",
	    				"Small Lumber Mill", "Med Lumber Mill", "Large Lumber Mill"};
	    
	    buytype = new JComboBox(list);
	    buytype.setBackground(Color.WHITE);
	    buytype.setSelectedIndex(sector*3-3);
	    buytype.addActionListener(otherWatch);
	    selltype = new JComboBox(list);
	    selltype.setBackground(Color.WHITE);
	    selltype.setSelectedIndex(sector*3-3);
	    selltype.addActionListener(otherWatch);
	    
	    subcontent11.add(new JLabel("Buy "));
	    subcontent11.add(buynumber);
	    subcontent11.add(buytype);
	    
	    subcontent12.add(new JLabel("Sell "));
	    subcontent12.add(sellnumber);
	    subcontent12.add(selltype);
	    
	    c.weightx = 1/6;
	    c.gridy = 0;
		c.gridx = 1;
		subcontent1.add(new JLabel("Capital"), c);
		c.gridx =2;
		subcontent1.add(new JLabel("Wood"), c);
		c.gridx =3;
		subcontent1.add(new JLabel("Oil"), c);
	    
	    content = new JPanel();
	    content.setOpaque(false);
	    content.add(subcontent1);
	    
	    buttons = new JPanel();
	    buttons.setOpaque(false);
	    
	    buy = new JButton("Buy");
	    buy.addMouseListener(buttonWatch);
	    ok = new JButton("OK");
	    ok.addMouseListener(buttonWatch);
	    close = new JButton("Close");
	    close.addMouseListener(buttonWatch);
	    
	    buttons.add(buy);
	    buttons.add(ok);
	    buttons.add(close);
	    	    
	    panel = new JPanel();
	    panel.setOpaque(false);
	    panel.setLayout(new BorderLayout());
	    panel.add(current, BorderLayout.NORTH);
	    panel.add(content, BorderLayout.CENTER);
	    panel.add(buttons, BorderLayout.SOUTH);
	    
	    setContentPane(panel);
	    
	}
	
	public void doBuySell(Capital Sector){
		stats[0][0]=(int) Empous.Gov.reserve;
		stats[0][1]=(int) Empous.Gov.woodstock;
		stats[0][2]=(int) Empous.Gov.oiltank;
		stats[1][0]=Sector.scapcost;
		stats[1][1]=Sector.swoodcost;
		stats[1][2]=Sector.soilcost;
		stats[2][0]=Sector.scapcost;
		stats[2][1]=Sector.swoodcost;
		stats[2][2]=Sector.soilcost;
		
		sum[0][0]=(stats[1][0]*Integer.parseInt(buynumber.getText())-stats[2][0]*Integer.parseInt(sellnumber.getText()));
		sum[0][1]=(stats[1][1]*Integer.parseInt(buynumber.getText())-stats[2][1]*Integer.parseInt(sellnumber.getText()));
		sum[0][2]=(stats[1][2]*Integer.parseInt(buynumber.getText())-stats[2][2]*Integer.parseInt(sellnumber.getText()));
		
		cl1 = new JLabel("Capital = "+stats[0][0]);
		cl2 = new JLabel("Wood = "+stats[0][1]);
		cl3 = new JLabel("Oil = "+stats[0][2]);
		
		current.add(cl1);
		current.add(cl2);
		current.add(cl3);
		
		jl1 = new JLabel(Integer.toString(stats[1][0]));
		jl2 = new JLabel(Integer.toString(stats[1][1]));
		jl3 = new JLabel(Integer.toString(stats[1][2]));
		jl4 = new JLabel(Integer.toString(stats[2][0]));
		jl5 = new JLabel(Integer.toString(stats[2][1]));
		jl6 = new JLabel(Integer.toString(stats[2][2]));
		jl7 = new JLabel(Integer.toString(sum[0][0]));
		jl8 = new JLabel(Integer.toString(sum[0][1]));
		jl9 = new JLabel(Integer.toString(sum[0][2]));
		
		c.gridy = 1;
		c.gridx = 1;
		subcontent1.add(jl1, c);
		c.gridx = 2;
		subcontent1.add(jl2, c);
		c.gridx = 3;
		subcontent1.add(jl3, c);
		
		c.gridy = 2;
		c.gridx = 1;
		subcontent1.add(jl4, c);
		c.gridx = 2;
		subcontent1.add(jl5, c);
		c.gridx = 3;
		subcontent1.add(jl6, c);
	    
		c.gridy = 3;
		c.gridx = 1;
		subcontent1.add(jl7, c);
		c.gridx = 2;
		subcontent1.add(jl8, c);
		c.gridx = 3;
		subcontent1.add(jl9, c);
		
	    setVisible(true);
		panel.revalidate();
		while(isVisible()!=false){
			if (changed==1){
				BuySellCalc(bos, buysector);
				changed=0;
			}
			if (choice==1){
				BuySellCalc(bos, buysector);
				Settle();
				choice=0;
			}
			if (choice==2){
				BuySellCalc(bos, buysector);
				Settle();
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
				break;
			}
			if (choice==3){
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
				break;
			}
		}
	}
	
	public void BuySellCalc(int buy, int sector){
		int size = 0;
		int avail = 0;
		
		if (sector!=0){
			if(sector%3==0){
				size=3;
			}
			else{
				size=sector%3;
			}
			
			if (sector <=3){
				if (size==1){
					avail=Empous.Com.small;
					stats[buy][0]=Empous.Com.scapcost;
					stats[buy][1]=Empous.Com.swoodcost;
					stats[buy][2]=Empous.Com.soilcost;
				}
				if (size==2){
					avail=Empous.Com.med;
					stats[buy][0]=Empous.Com.mcapcost;
					stats[buy][1]=Empous.Com.mwoodcost;
					stats[buy][2]=Empous.Com.moilcost;
				}
				if (size==3){
					avail=Empous.Com.large;
					stats[buy][0]=Empous.Com.lcapcost;
					stats[buy][1]=Empous.Com.lwoodcost;
					stats[buy][2]=Empous.Com.loilcost;
				}
			}
			else if (sector<=6){
				if (size==1){
					avail=Empous.Res.small;
					stats[buy][0]=Empous.Res.scapcost;
					stats[buy][1]=Empous.Res.swoodcost;
					stats[buy][2]=Empous.Res.soilcost;
				}
				if (size==2){
					avail=Empous.Res.med;
					stats[buy][0]=Empous.Res.mcapcost;
					stats[buy][1]=Empous.Res.mwoodcost;
					stats[buy][2]=Empous.Res.moilcost;
				}
				if (size==3){
					avail=Empous.Res.large;
					stats[buy][0]=Empous.Res.lcapcost;
					stats[buy][1]=Empous.Res.lwoodcost;
					stats[buy][2]=Empous.Res.loilcost;
				}
			}
			else if (sector<=9){
				if (size==1){
					avail=Empous.Ind.small;
					stats[buy][0]=Empous.Ind.scapcost;
					stats[buy][1]=Empous.Ind.swoodcost;
					stats[buy][2]=Empous.Ind.soilcost;
				}
				if (size==2){
					avail=Empous.Ind.med;
					stats[buy][0]=Empous.Ind.mcapcost;
					stats[buy][1]=Empous.Ind.mwoodcost;
					stats[buy][2]=Empous.Ind.moilcost;
				}
				if (size==3){
					avail=Empous.Ind.large;
					stats[buy][0]=Empous.Ind.lcapcost;
					stats[buy][1]=Empous.Ind.lwoodcost;
					stats[buy][2]=Empous.Ind.loilcost;
				}
			}
			else{
				if (size==1){
					avail=Empous.LM.small;
					stats[buy][0]=Empous.LM.scapcost;
					stats[buy][1]=Empous.LM.swoodcost;
					stats[buy][2]=Empous.LM.soilcost;
				}
				if (size==2){
					avail=Empous.LM.med;
					stats[buy][0]=Empous.LM.mcapcost;
					stats[buy][1]=Empous.LM.mwoodcost;
					stats[buy][2]=Empous.LM.moilcost;
				}
				if (size==3){
					avail=Empous.LM.large;
					stats[buy][0]=Empous.LM.lcapcost;
					stats[buy][1]=Empous.LM.lwoodcost;
					stats[buy][2]=Empous.LM.loilcost;
				}
			}
		}
//		System.out.println("Size = "+size);
//		System.out.println("Available = "+avail);
		avail-=(Integer.parseInt(sellnumber.getText())-Integer.parseInt(buynumber.getText()));
//		System.out.println("Available = "+avail);
		if (avail<0){
			avail+=Integer.parseInt(sellnumber.getText());
			sellnumber.setText(Integer.toString(avail));
		}
		
		jl1.setText(Integer.toString(stats[1][0]));
		jl2.setText(Integer.toString(stats[1][1]));
		jl3.setText(Integer.toString(stats[1][2]));
		jl4.setText(Integer.toString(stats[2][0]));
		jl5.setText(Integer.toString(stats[2][1]));
		jl6.setText(Integer.toString(stats[2][2]));

		sum[0][0]=(stats[1][0]*Integer.parseInt(buynumber.getText())-stats[2][0]*Integer.parseInt(sellnumber.getText()));
		sum[0][1]=(stats[1][1]*Integer.parseInt(buynumber.getText())-stats[2][1]*Integer.parseInt(sellnumber.getText()));
		sum[0][2]=(stats[1][2]*Integer.parseInt(buynumber.getText())-stats[2][2]*Integer.parseInt(sellnumber.getText()));
	
		jl7.setText(Integer.toString(sum[0][0]));
		jl8.setText(Integer.toString(sum[0][1]));
		jl9.setText(Integer.toString(sum[0][2]));
	}
	
	public void Settle(){
		int btype;
		int stype;
		
		if (Empous.Gov.reserve > sum[0][0] &&
				Empous.Gov.woodstock > sum[0][1] &&
				Empous.Gov.oiltank > sum[0][2]){
			Empous.Gov.reserve-=sum[0][0];
			Empous.Gov.woodstock-=sum[0][1];
			Empous.Gov.oiltank-=sum[0][2];
			
			btype=buytype.getSelectedIndex();
			stype=selltype.getSelectedIndex();
			
			switch(btype){
				case(0): Empous.Com.small+=Integer.parseInt(buynumber.getText()); break;
				case(1): Empous.Com.med+=Integer.parseInt(buynumber.getText()); break;
				case(2): Empous.Com.large+=Integer.parseInt(buynumber.getText()); break;
				case(3): Empous.Res.small+=Integer.parseInt(buynumber.getText()); break;
				case(4): Empous.Res.med+=Integer.parseInt(buynumber.getText()); break;
				case(5): Empous.Res.large+=Integer.parseInt(buynumber.getText()); break;
				case(6): Empous.Ind.small+=Integer.parseInt(buynumber.getText()); break;
				case(7): Empous.Ind.med+=Integer.parseInt(buynumber.getText()); break;
				case(8): Empous.Ind.large+=Integer.parseInt(buynumber.getText()); break;
				case(9): Empous.LM.large+=Integer.parseInt(buynumber.getText()); break;
				case(10): Empous.LM.large+=Integer.parseInt(buynumber.getText()); break;
				case(11): Empous.LM.large+=Integer.parseInt(buynumber.getText()); break;
			}
			
			switch(stype){
				case(0): Empous.Com.small-=Integer.parseInt(sellnumber.getText()); break;
				case(1): Empous.Com.med-=Integer.parseInt(sellnumber.getText()); break;
				case(2): Empous.Com.large-=Integer.parseInt(sellnumber.getText()); break;
				case(3): Empous.Res.small-=Integer.parseInt(sellnumber.getText()); break;
				case(4): Empous.Res.med-=Integer.parseInt(sellnumber.getText()); break;
				case(5): Empous.Res.large-=Integer.parseInt(sellnumber.getText()); break;
				case(6): Empous.Ind.small-=Integer.parseInt(sellnumber.getText()); break;
				case(7): Empous.Ind.med-=Integer.parseInt(sellnumber.getText()); break;
				case(8): Empous.Ind.large-=Integer.parseInt(sellnumber.getText()); break;
				case(9): Empous.LM.large-=Integer.parseInt(sellnumber.getText()); break;
				case(10): Empous.LM.large-=Integer.parseInt(sellnumber.getText()); break;
				case(11): Empous.LM.large-=Integer.parseInt(sellnumber.getText()); break;
			}
			
		}
		else{
			System.out.println("Not enough resource");
		}
		
		stats[0][0]=(int) Empous.Gov.reserve;
		stats[0][1]=(int) Empous.Gov.woodstock;
		stats[0][2]=(int) Empous.Gov.oiltank;
		
		cl1.setText("Capital = "+stats[0][0]);
		cl2.setText("Wood = "+stats[0][1]);
		cl3.setText("Oil = "+stats[0][2]);
	}
	
	public class Change implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			if (evt.getSource()==buytype || evt.getSource()==buynumber){
				buysector = buytype.getSelectedIndex()+1;
				bos=1;
			}
			if (evt.getSource()==selltype || evt.getSource()==sellnumber){
				buysector = selltype.getSelectedIndex()+1;
				bos=2;
			}
//			if (evt.getSource()==buynumber || evt.getSource()==sellnumber){
//				buysector = 0;
//			}
			changed=1;
		}
	}
	
	public class ButtonClick implements MouseListener {
		public void mouseClicked(MouseEvent evt) {}
		public void mouseEntered(MouseEvent evt) {
			if (evt.getSource()==buy){
				mousein = 1;
			}
			if (evt.getSource()==ok){
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
			if (mousein == 1 && evt.getSource()==buy){
				choice = 1;
			}
			if (mousein == 2 && evt.getSource()==ok){
				choice = 2;
			}
			if (mousein == 3 && evt.getSource()==close){
				choice = 3;
			}
		}
	}
}