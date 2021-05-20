package DisplayGUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	
	private JTextArea displayScreen;
	private JScrollPane scroll;
	private JPanel pnlDisplay, pnlError;
	private JTextArea lblError;
	
	public Display() {
		guiDesign();
		addToPanel();
		adjustScreenSize(false);
	}
	
	private void addToPanel() {
		pnlDisplay = new JPanel();
		pnlDisplay.setLayout(new GridLayout(1,1));
		add(pnlDisplay, BorderLayout.SOUTH);
		
		displayScreen = new JTextArea();
		displayScreen.setEditable(false);
		DefaultDesign(displayScreen);
		
		scroll = new JScrollPane(displayScreen);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		pnlDisplay.add(scroll);
		
		
		pnlError = new JPanel();
		pnlError.setLayout(new GridLayout(1,1));
		add(pnlError, BorderLayout.CENTER);

		
		lblError = new JTextArea();
		lblError.setEditable(false);
		pnlError.add(lblError);
		
		
	}
	
	public void adjustScreenSize(boolean flag) {
		if (flag) {
			pnlDisplay.setPreferredSize(new Dimension(0,360));
			setSize(600,400);
		}
		else {
			pnlDisplay.setPreferredSize(new Dimension(0,0));
			setSize(600,40);
		}
	}
	
	private void guiDesign() {
		setLocation(550,500);
		setLayout(new BorderLayout());
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
		
	private void treeDisplay() throws IOException {
		FileSystem x = new FileSystem();
		ancestryTree y = x.DeserializeTree();
		displayScreen.setText(y.outputAsString());
		
	}
	
	public void updateTree() {
		try {
			treeDisplay();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void personDisplay(String e) {
		displayScreen.setText(e);
	}
	
	public void errorDisplay(String e) {
		lblError.setForeground(Color.red);
		lblError.setText(e);
	}
	
	public void messageDisplay(String e) {
		lblError.setForeground(Color.black);
		lblError.setText(e);
	}
	
	public static void main(String[] args) {
		Display d = new Display();
		d.setVisible(true);
		d.adjustScreenSize(false);
	}
	
}
