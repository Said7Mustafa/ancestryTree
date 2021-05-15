package DisplayGUI;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


import Additional_methods.FileSystem;
import BackEnd.ancestryTree;

public class Display extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JTextArea print;
	private JScrollPane sp;
	private JPanel panel;
	
	public Display() {
		guiDesign();
		addToPanel();
	}
	
	private void addToPanel() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(1,1));
		add(panel);
		
		print = new JTextArea();
		print.setEditable(false);
		DefaultDesign(print);
		
		sp = new JScrollPane(print);
		sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		panel.add(sp);
	}
	
	private void guiDesign() {
		setSize(600,400);
		setLocation(550,500);
		setLayout(new GridLayout(1, 1));
		setUndecorated(true);
	}

	private void DefaultDesign(JTextArea jta) {
		Color color = new Color(127,5,127);
		
		jta.setOpaque(true);
		jta.setBackground(color);
		jta.setForeground(Color.yellow);
		jta.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		jta.setText("");
	}
	
	public void update() {
		try {
			DisplayOnScreen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void DisplayOnScreen() throws IOException {
		FileSystem x = new FileSystem();
		ancestryTree y = x.DeserializeTree();
		print.setText(y.outputAsString());
		
	}
}
