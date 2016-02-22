package main.java.com.adtme.empous;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class BuySell extends JFrame{
	private JPanel panel;
	private JPanel current;
	private JPanel content;
	private JPanel subcontent;
	private JPanel buttons;
	private JTextField buynumber;
	private JTextField sellnumber;
	private JComboBox type;
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
	
	private SectorView parent;
	private Capital sector;
	
	private GridBagConstraints c;
	
	private int mousein = 0;
	
	public BuySell(SectorView parent, Capital sector){
		super(); //Create the frame
		this.sector=sector;
		this.parent=parent;
		
		// Create listeners
		ButtonClick buttonWatch = new ButtonClick();
		Change1 typeWatch = new Change1();
		Change2 numWatch = new Change2();
		FocusChange focusWatch = new FocusChange();
		
		// Basic frame settings
		setTitle("Buy/Sell");
		setBackground(Color.WHITE);
		setSize(575,200); //Default window size
		setResizable(false);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation( (screensize.width - getWidth())/2, (screensize.height - getHeight())/2); // Put it in the middle
	    
	    // Components
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
	    
	    content = new JPanel();
	    content.setBorder(BorderFactory.createEmptyBorder(15,25,15,25));
	    content.setLayout(new GridBagLayout());
	    subcontent = new JPanel();
	    subcontent.setOpaque(false);
	    
	    c = new GridBagConstraints();
	    c.ipadx = 15;
	    c.ipady = 3;
	    c.weightx = 0.5;
	    c.weighty = 0.25;
	    c.gridx = 0;
	    c.gridy = 0;
	    content.add(new JLabel("  "));
	    c.gridy = 1;
	    content.add(subcontent, c);
	    c.gridy = 2;
	    content.add(new JLabel("Total to spend:"), c);
	    
	    buynumber = new JTextField("0",3);
	    buynumber.getDocument().addDocumentListener(numWatch);
	    buynumber.addFocusListener(focusWatch);
	    sellnumber = new JTextField("0",3);
	    sellnumber.getDocument().addDocumentListener(numWatch);
	    sellnumber.addFocusListener(focusWatch);
	    
	    String[] list = {"Small "+sector.getType(), "Medium "+sector.getType(), "Large "+sector.getType(),};
	    
	    type = new JComboBox(list);
	    type.setBackground(Color.WHITE);
	    type.addActionListener(typeWatch);
	    
	    subcontent.add(new JLabel("Buy "));
	    subcontent.add(buynumber);
	    subcontent.add(new JLabel("Sell "));
	    subcontent.add(sellnumber);
	    subcontent.add(type);
	    
	    c.weightx = 1/6;
	    c.gridy = 0;
		c.gridx = 1;
		content.add(new JLabel("Capital"), c);
		c.gridx =2;
		content.add(new JLabel("Wood"), c);
		c.gridx =3;
		content.add(new JLabel("Oil"), c);
		
		jl1 = new JLabel("");
		jl2 = new JLabel("");
		jl3 = new JLabel("");
		jl4 = new JLabel("");
		jl5 = new JLabel("");
		jl6 = new JLabel("");
		
		c.gridy = 1;
		c.gridx = 1;
		content.add(jl1, c);
		c.gridx = 2;
		content.add(jl2, c);
		c.gridx = 3;
		content.add(jl3, c);
	    
		c.gridy = 2;
		c.gridx = 1;
		content.add(jl4, c);
		c.gridx = 2;
		content.add(jl5, c);
		c.gridx = 3;
		content.add(jl6, c);
	    
	    // Buttons
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
	    
	    // Component holder
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
		calcStats();
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
		jl4.setText(Integer.toString(sum[0][0]));
		jl5.setText(Integer.toString(sum[0][1]));
		jl6.setText(Integer.toString(sum[0][2]));
		
		panel.revalidate();
		parent.refresh();
	}
	
	public void calcStats(){
		int buyquant = Integer.parseInt(buynumber.getText());
		int sellquant = Integer.parseInt(sellnumber.getText());
		int type_int = type.getSelectedIndex()+1;
		int avail = sector.getQuantity(type_int);

		if (avail+buyquant-sellquant<0){
			sellquant=avail+buyquant;
			final int temp = sellquant; // Weird java passthrough thing
			SwingUtilities.invokeLater(new Runnable(){
				public void run(){
					sellnumber.setText(Integer.toString(temp));
				}
			});
		}
		stats[0][0] = Empous.Gov.getStat("reserve");
		stats[0][1] = Empous.Gov.getStat("woodstock");
		stats[0][2] = Empous.Gov.getStat("oiltank");
		stats[1][0] = sector.getCost("capital", type_int);
		stats[1][1] = sector.getCost("wood", type_int);
		stats[1][2] = sector.getCost("oil", type_int);
		
		sum[0][0]=(stats[1][0]*(buyquant-sellquant));
		sum[0][1]=(stats[1][1]*(buyquant-sellquant));
		sum[0][2]=(stats[1][2]*(buyquant-sellquant));
	}
	
	public void settle(){
		int buyquant = Integer.parseInt(buynumber.getText());
		int sellquant = Integer.parseInt(sellnumber.getText());
		int type_int = type.getSelectedIndex()+1;
		int current = sector.getQuantity(type_int);
		
		int checkCap = Empous.Gov.getStat("reserve") - sum[0][0];
		int checkWood = Empous.Gov.getStat("woodstock") - sum[0][1];
		int checkOil = Empous.Gov.getStat("oiltank") - sum[0][2];
		
		// If they have enough resources, perform the transaction
		if (checkCap >= 0 && checkWood >= 0 && checkOil >= 0){
			
			Empous.Gov.setStat("reserve", checkCap);
			Empous.Gov.setStat("woodstock", checkWood);
			Empous.Gov.setStat("oiltank", checkOil);
						
			sector.setQuantity(type_int, current+buyquant-sellquant);
		}
		// If they don't, give a warning
		else{
			System.out.println("Not enough resources!");
		}
	}
	
	public class Change1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			if (evt.getSource()==type){
				calcStats();
				refresh();
			}
		}
	}
	
	public class Change2 implements DocumentListener{
		public void changedUpdate(DocumentEvent evt) {
			update();
			}
		public void insertUpdate(DocumentEvent evt) {
			update();
		}
		public void removeUpdate(DocumentEvent evt) {
			update();
		}
		
		public void update(){
			try{
				Integer.parseInt(buynumber.getText());}
			catch(NumberFormatException nf){
				return;
			}
			try{
				Integer.parseInt(sellnumber.getText());}
			catch(NumberFormatException nf){
				return;
			}
			calcStats();
			refresh();
		}
	}
	
	public class FocusChange implements FocusListener{
		@Override
		public void focusGained(FocusEvent evt) {}
		@Override
		public void focusLost(FocusEvent evt) {
			if (evt.getSource()==buynumber){
				if (buynumber.getText().equals("")) buynumber.setText("0");			
			}
			if (evt.getSource()==sellnumber){
				if (sellnumber.getText().equals("")) sellnumber.setText("0");			
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
				calcStats();
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