package main.java.com.adtme.empous;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class SubMenu extends JFrame{
	private JPanel panel;
	private JPanel content;
	private JLabel description;
	private JPanel buttons;
	private ImageIcon icon;
	
	Color DescColor = Color.GRAY;

	public SubMenu(){
		super(); //Create the frame
		
		// Basic frame settings
		setBackground(Color.WHITE);
		setSize(500,350);
		setResizable(false);
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	    setLocation( (screensize.width - getWidth())/2, (screensize.height - getHeight())/2); // Put it in the middle
		
	    // Components
	    description = new JLabel();
		description.setIconTextGap(10);
		description.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		description.setHorizontalAlignment(JLabel.LEFT);
		content = new JPanel();
		content.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		content.setOpaque(false);
		buttons = new JPanel();
	    buttons.setOpaque(false);
		
	    // Component holder
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setOpaque(false);
		panel.add(description, BorderLayout.NORTH);
		panel.add(content, BorderLayout.CENTER);
		panel.add(buttons, BorderLayout.SOUTH);
		
		setContentPane(panel);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void display(){
		setVisible(true);
		panel.revalidate();
	}
	
	public void setDescription(String iconPath, String text){
		icon = new ImageIcon(iconPath);
		description.setIcon(icon);
		description.setText(text);
		description.setForeground(DescColor);
	}
	public void setContentLayout(LayoutManager layout){
		content.setLayout(layout);
	}
	public void addContent(Component comp){
		content.add(comp);
	}
	public void addButton(JButton button){
		buttons.add(button);
	}
}

