package ControlGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Additional_methods.FileSystem;
import BackEnd.ancestryTree;
import DisplayGUI.Display;

public class UI extends JFrame {

	private static final long serialVersionUID = 123L;

	private JPanel pnlinput, pnlLeft,pnlRight,pnlBtn,pnlRightUp,pnlRightDown,pnlPassword; 
	
	private JLabel lblfName,lblmName,lbllName,lblfatherFName,lblfatherLName,
					lblmotherFName,lblGfatherFName,lblGfatherLName,
					lblmotherLName,lblD_O_B,lblD_O_D,
					lblMoreInformation,lblParentPassword,lblChildPassword;
	
	private JTextField txtfName,txtmName,txtlName,txtfatherFName,txtfatherLName,
						txtGfatherFName,txtGfatherLName,txtmotherFName,
						txtmotherLName,txtD_O_B,txtD_O_D,txtParentPassword,txtChildPassword;
	
	private JButton btnClose,btnDelete,btnInsert,btnShow_RefreshDisplay,btnHideDisplay;
	
	private JTextArea tAreaMoreInformation;
	
	private ancestryTree tree ;
	
	private Display display = new Display();
	
	FileSystem fileSys = new FileSystem();
	
	public UI() {
		guiDesign();
		addToPanel();
		addListener();
	}
	
	private void guiDesign() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,400);
		setLocation(550,100);
		setLayout(new BorderLayout());
		setUndecorated(true);
	}
	
	
	private void addToPanel() {
		instantiate();
		pnlDesign();
		
		add(pnlinput,BorderLayout.CENTER);
		add(pnlBtn,BorderLayout.SOUTH);
		
		pnlinput.add(pnlLeft);
		pnlinput.add(pnlRight);

		
		pnlLeft.add(lblfName);
		pnlLeft.add(txtfName);
		pnlLeft.add(lblmName);
		pnlLeft.add(txtmName);
		pnlLeft.add(lbllName);
		pnlLeft.add(txtlName);
		
		pnlLeft.add(lblfatherFName);
		pnlLeft.add(txtfatherFName);
		pnlLeft.add(lblfatherLName);
		pnlLeft.add(txtfatherLName);
		pnlLeft.add(lblmotherFName);
		pnlLeft.add(txtmotherFName);
		pnlLeft.add(lblmotherLName);
		pnlLeft.add(txtmotherLName);
		
		pnlRight.add(pnlRightUp,BorderLayout.NORTH);
		pnlRight.add(pnlRightDown,BorderLayout.CENTER);
		
		pnlRightUp.add(lblD_O_B);
		pnlRightUp.add(txtD_O_B);
		pnlRightUp.add(lblD_O_D);
		pnlRightUp.add(txtD_O_D);
		pnlRightUp.add(lblGfatherFName);
		pnlRightUp.add(txtGfatherFName);
		pnlRightUp.add(lblGfatherLName);
		pnlRightUp.add(txtGfatherLName);
		
		pnlRightDown.add(lblMoreInformation,BorderLayout.NORTH);
		lblMoreInformation.setPreferredSize(new Dimension(0,40));
		
		pnlRightDown.add(tAreaMoreInformation,BorderLayout.CENTER);
		
		pnlRightDown.add(pnlPassword,BorderLayout.SOUTH);
		pnlPassword.setPreferredSize(new Dimension(0,60));
		
		pnlPassword.add(lblChildPassword);
		pnlPassword.add(txtChildPassword);
		pnlPassword.add(lblParentPassword);
		pnlPassword.add(txtParentPassword);
		
		pnlBtn.add(btnClose);
		pnlBtn.add(btnDelete);
		pnlBtn.add(btnInsert);
		pnlBtn.add(btnShow_RefreshDisplay);
		pnlBtn.add(btnHideDisplay);
		
		
	}
		
	private void pnlDesign() {
		pnlinput.setBackground(Color.gray);
		pnlinput.setLayout(new GridLayout(1, 2));
		
		pnlBtn.setBackground(Color.blue);
		pnlBtn.setLayout(new GridLayout(1, 5));
		pnlBtn.setPreferredSize(new Dimension(0,50));

		pnlLeft.setBackground(Color.red);
		pnlLeft.setLayout(new GridLayout(7, 2));
		
		pnlRight.setBackground(Color.black);
		pnlRight.setLayout(new BorderLayout());
		
		pnlRightUp.setBackground(Color.cyan);
		pnlRightUp.setLayout(new GridLayout(4, 2));
		pnlRightUp.setPreferredSize(new Dimension(0,115));
		
		pnlRightDown.setBackground(Color.gray);
		pnlRightDown.setLayout(new BorderLayout());
		
		pnlPassword.setLayout(new GridLayout(2, 2));
		
	}
	
	private void instantiate() {
		pnlinput = new JPanel();
		pnlBtn =  new JPanel();
		pnlLeft = new JPanel();
		pnlRight = new JPanel();
		pnlRightUp = new JPanel();
		pnlRightDown = new JPanel();
		pnlPassword = new JPanel();
		
		lblfName = new JLabel("First Name");
		lblmName = new JLabel("Middle Name");
		lbllName = new JLabel("Last Name");
		
		lblfatherFName = new JLabel("Father's First Name");
		lblfatherLName = new JLabel("Father's Last Name");
		lblmotherFName = new JLabel("Mother's First Name");
		lblmotherLName = new JLabel("Mother's Last Name");
		
		lblGfatherFName = new JLabel("Grandfather's First Name");
		lblGfatherLName = new JLabel("Grandfather's Last Name");
		
		lblD_O_B = new JLabel("Date Of Birth");
		lblD_O_D = new JLabel("Date Of Death");
		lblParentPassword = new JLabel("Parent's Password");
		lblChildPassword = new JLabel("Child's Password");
		
		txtfName = new JTextField();
		txtmName = new JTextField();
		txtlName = new JTextField();
		
		txtfatherFName = new JTextField();
		txtfatherLName = new JTextField();
		txtmotherFName = new JTextField();
		txtmotherLName = new JTextField();
		
		txtGfatherFName = new JTextField();
		txtGfatherLName = new JTextField();
		
		txtGfatherFName = new JTextField();
		txtGfatherLName = new JTextField();
		
		txtD_O_B = new JTextField();
		txtD_O_D = new JTextField();
		txtParentPassword = new JTextField();
		txtChildPassword = new JTextField();
		
		lblMoreInformation = new JLabel("More Information");
		tAreaMoreInformation = new JTextArea();
		
		btnClose = new JButton("Close");
		btnDelete = new JButton("Delete");
		btnInsert = new JButton("Insert");
		btnShow_RefreshDisplay = new JButton("Show/Refresh Display");
		btnHideDisplay = new JButton("Hide Display");
		
	}
	
	private void resetComponent() {
		txtfName.setText("");
		txtmName.setText("");
		txtlName.setText("");
		
		txtfatherFName.setText("");
		txtfatherLName.setText("");
		
		txtmotherFName.setText("");
		txtmotherLName.setText("");
		
		txtD_O_B.setText("");
		txtD_O_D.setText("");
		txtGfatherFName.setText("");
		txtGfatherLName.setText("");
		
		tAreaMoreInformation.setText("");
		txtParentPassword.setText("");
		txtChildPassword.setText("");
	}
	
	private void addListener() {
		btnClose.addActionListener(new ActionHandler());
		btnDelete.addActionListener(new ActionHandler());
		btnInsert.addActionListener(new ActionHandler());
		btnShow_RefreshDisplay.addActionListener(new ActionHandler());
		btnHideDisplay.addActionListener(new ActionHandler());
	}
	
	private class ActionHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				if (e.getSource() == btnClose) {
					dispose();
					display.dispose();
				}
				else if (e.getSource() == btnDelete) 
					btnDelete();
				else if (e.getSource() == btnInsert)
					btnInsert();
				else if (e.getSource() == btnShow_RefreshDisplay) {
					tree = fileSys.DeserializeTree();
					if (display.isVisible() == false) {
						display.setVisible(true);
						display.update();
					} 
					else
						display.update();
				}
				else if (e.getSource() == btnHideDisplay)
					display.dispose();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		}
		
	}
	
	private void btnInsert() throws IOException {
		tree = fileSys.DeserializeTree();

		tree.insert(txtD_O_B.getText(), txtD_O_D.getText(),
				txtfName.getText(), txtmName.getText(), 
				txtlName.getText(), tAreaMoreInformation.getText(),
				tree.personFinder(txtfatherFName.getText(), txtfatherLName.getText(),
						txtGfatherFName.getText(), txtGfatherLName.getText()),
				txtmotherFName.getText(), txtmotherLName.getText(),
				txtChildPassword.getText(),txtParentPassword.getText());
		fileSys.serializeTree(tree);
		
		resetComponent();
	}
	
	public void btnDelete() throws IOException {
		tree = fileSys.DeserializeTree();
		tree.deleteNode(txtfName.getText(), txtlName.getText(),
				txtfatherFName.getText(), txtfatherLName.getText(), txtParentPassword.getText());
		fileSys.serializeTree(tree);
//			resetComponent();
	}
	
	public void btnUpdate() throws IOException {
		display.update();
		display.setVisible(true);
		resetComponent();
	}
	
	public static void main(String[] args) {
		new UI().setVisible(true);;
	}
	

}
//add reset to insertbtn by adding a error method in ancestor