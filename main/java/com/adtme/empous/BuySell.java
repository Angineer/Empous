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
	
	private Capital sector;
	
	private GridBagConstraints c;
	
	private int mousein = 0;
	
	public BuySell(Capital sector){
		super(); //Create the frame
		setTitle("Buy/Sell");
		
		this.sector=sector;
		
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
	    
	    cl1 = new JLabel("Capital = ");
		cl2 = new JLabel("Wood = ");
		cl3 = new JLabel("Oil = ");
	    
	    current.add(cl1);
		current.add(cl2);
		current.add(cl3);
	    
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
	    buytype.setSelectedIndex(2*3-3);
	    buytype.addActionListener(otherWatch);
	    selltype = new JComboBox(list);
	    selltype.setBackground(Color.WHITE);
	    selltype.setSelectedIndex(2*3-3);
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
		
		jl1 = new JLabel("");
		jl2 = new JLabel("");
		jl3 = new JLabel("");
		jl4 = new JLabel("");
		jl5 = new JLabel("");
		jl6 = new JLabel("");
		jl7 = new JLabel("");
		jl8 = new JLabel("");
		jl9 = new JLabel("");
		
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
	    
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void display(){
	    refresh();
		setVisible(true);
	}
	
	public void refresh(){		
		cl1.setText("Capital = "+stats[0][0]);
		cl2.setText("Wood = "+stats[0][1]);
		cl3.setText("Oil = "+stats[0][2]);
		
		jl1.setText(Integer.toString(stats[1][0]));
		jl2.setText(Integer.toString(stats[1][1]));
		jl3.setText(Integer.toString(stats[1][2]));
		jl4.setText(Integer.toString(stats[2][0]));
		jl5.setText(Integer.toString(stats[2][1]));
		jl6.setText(Integer.toString(stats[2][2]));
		jl7.setText(Integer.toString(sum[0][0]));
		jl8.setText(Integer.toString(sum[0][1]));
		jl9.setText(Integer.toString(sum[0][2]));
		
	    setVisible(true);
		panel.revalidate();
	}
	
	public void BuySellCalc(int buy, int size){
		int avail = 0;

		avail=sector.getQuantity(size);
		stats[buy][0]=sector.getCost("capital", size);
		stats[buy][1]=sector.getCost("wood", size);
		stats[buy][2]=sector.getCost("oil", size);
		
//		System.out.println("Size = "+size);
//		System.out.println("Available = "+avail);
		avail-=(Integer.parseInt(sellnumber.getText())-Integer.parseInt(buynumber.getText()));
//		System.out.println("Available = "+avail);
		if (avail<0){
			avail+=Integer.parseInt(sellnumber.getText());
			sellnumber.setText(Integer.toString(avail));
		}
		stats[0][0]=(int) Empous.Gov.reserve;
		stats[0][1]=(int) Empous.Gov.woodstock;
		stats[0][2]=(int) Empous.Gov.oiltank;
		stats[1][0]=sector.getCost("capital", size);
		stats[1][1]=sector.getCost("wood", size);
		stats[1][2]=sector.getCost("oil", size);
		stats[2][0]=sector.getCost("capital", size);
		stats[2][1]=sector.getCost("wood", size);
		stats[2][2]=sector.getCost("oil", size);
		
		sum[0][0]=(stats[1][0]*Integer.parseInt(buynumber.getText())-stats[2][0]*Integer.parseInt(sellnumber.getText()));
		sum[0][1]=(stats[1][1]*Integer.parseInt(buynumber.getText())-stats[2][1]*Integer.parseInt(sellnumber.getText()));
		sum[0][2]=(stats[1][2]*Integer.parseInt(buynumber.getText())-stats[2][2]*Integer.parseInt(sellnumber.getText()));
	}
	
	public void settle(){
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
				case(0): Empous.Com.setQuantity(Empous.Com.getQuantity(1)+Integer.parseInt(buynumber.getText()), 1); break;
				case(1): Empous.Com.setQuantity(Empous.Com.getQuantity(2)+Integer.parseInt(buynumber.getText()), 2); break;
				case(2): Empous.Com.setQuantity(Empous.Com.getQuantity(3)+Integer.parseInt(buynumber.getText()), 3); break;
				case(3): Empous.Res.setQuantity(Empous.Res.getQuantity(1)+Integer.parseInt(buynumber.getText()), 1); break;
				case(4): Empous.Res.setQuantity(Empous.Res.getQuantity(2)+Integer.parseInt(buynumber.getText()), 2); break;
				case(5): Empous.Res.setQuantity(Empous.Res.getQuantity(3)+Integer.parseInt(buynumber.getText()), 3); break;
				case(6): Empous.Ind.setQuantity(Empous.Ind.getQuantity(1)+Integer.parseInt(buynumber.getText()), 1); break;
				case(7): Empous.Ind.setQuantity(Empous.Ind.getQuantity(2)+Integer.parseInt(buynumber.getText()), 2); break;
				case(8): Empous.Ind.setQuantity(Empous.Ind.getQuantity(3)+Integer.parseInt(buynumber.getText()), 3); break;
				case(9): Empous.LM.setQuantity(Empous.LM.getQuantity(1)+Integer.parseInt(buynumber.getText()), 1); break;
				case(10): Empous.LM.setQuantity(Empous.LM.getQuantity(2)+Integer.parseInt(buynumber.getText()), 2); break;
				case(11): Empous.LM.setQuantity(Empous.LM.getQuantity(3)+Integer.parseInt(buynumber.getText()), 3); break;
			}
			
			switch(stype){
				case(0): Empous.Com.setQuantity(Empous.Com.getQuantity(1)-Integer.parseInt(sellnumber.getText()), 1); break;
				case(1): Empous.Com.setQuantity(Empous.Com.getQuantity(2)-Integer.parseInt(sellnumber.getText()), 2); break;
				case(2): Empous.Com.setQuantity(Empous.Com.getQuantity(3)-Integer.parseInt(sellnumber.getText()), 3); break;
				case(3): Empous.Res.setQuantity(Empous.Res.getQuantity(1)-Integer.parseInt(sellnumber.getText()), 1); break;
				case(4): Empous.Res.setQuantity(Empous.Res.getQuantity(2)-Integer.parseInt(sellnumber.getText()), 2); break;
				case(5): Empous.Res.setQuantity(Empous.Res.getQuantity(3)-Integer.parseInt(sellnumber.getText()), 3); break;
				case(6): Empous.Ind.setQuantity(Empous.Ind.getQuantity(1)-Integer.parseInt(sellnumber.getText()), 1); break;
				case(7): Empous.Ind.setQuantity(Empous.Ind.getQuantity(2)-Integer.parseInt(sellnumber.getText()), 2); break;
				case(8): Empous.Ind.setQuantity(Empous.Ind.getQuantity(3)-Integer.parseInt(sellnumber.getText()), 3); break;
				case(9): Empous.LM.setQuantity(Empous.LM.getQuantity(1)-Integer.parseInt(sellnumber.getText()), 1); break;
				case(10): Empous.LM.setQuantity(Empous.LM.getQuantity(2)-Integer.parseInt(sellnumber.getText()), 2); break;
				case(11): Empous.LM.setQuantity(Empous.LM.getQuantity(3)-Integer.parseInt(sellnumber.getText()), 3); break;
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
				refresh();
			}
			if (evt.getSource()==selltype || evt.getSource()==sellnumber){
				refresh();
			}
			if (evt.getSource()==buynumber || evt.getSource()==sellnumber){
				refresh();
			}
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
				settle();
				refresh();
			}
			if (mousein == 2 && evt.getSource()==ok){
				settle();
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
			if (mousein == 3 && evt.getSource()==close){
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		}
	}
}