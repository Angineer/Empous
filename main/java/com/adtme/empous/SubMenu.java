package main.java.com.adtme.empous;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SubMenu extends JFrame{
	private JPanel panel;
	private JPanel content;
	private JLabel description;
	private JPanel overpanel;
	private JPanel buttons;
	
	int[][] stats = new int[5][3];
	int[][] sum = new int[1][4];

	public SubMenu(){
		super(); //Create the frame
		
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
		
		overpanel = new JPanel();
		overpanel.setLayout(new OverlayLayout(overpanel));
		
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setOpaque(false);
		
		description = new JLabel();
		description.setIconTextGap(10);
		description.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		description.setHorizontalAlignment(JLabel.LEFT);
		
		panel.add(description, BorderLayout.NORTH);
		panel.add(content, BorderLayout.CENTER);
		panel.add(buttons, BorderLayout.SOUTH);
		
		setContentPane(panel);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void display(){
		System.out.println("Generating sub-menu");		
	}
	
	public void setDescription(ImageIcon icon, String text, Color color){
		description.setIcon(icon);
		description.setText(text);
		description.setForeground(color);
	}
	public void addContent(JPanel content){
		content.add(content);
	}
	public void addButton(JButton button){
		buttons.add(button);
	}
}

