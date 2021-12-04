//Gui for the main menu and acts as a sort of main method/hub
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenuGUI implements ActionListener{
	
	//RunTestGUI class that may be opened if a certain button is pressed
	RunTestGUI runTest;
	
	//JFrame and JPanel
	JFrame menuFrame;
	JPanel menuPanel;
	
	//4 Buttons
	JButton runTestButton;
	JButton wipButton;
	JButton wipButton2;
	JButton wipButton3;
	String user;
	
	//Constructor
	MainMenuGUI(String username){
		

		user = username;

		//Create the frame and panel that we will be using
		menuFrame = new JFrame("Main Menu");
		menuFrame.setSize(500, 500);
		menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuFrame.add(menuPanel);
		
		//This will allow us to close the frame
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set up the 4 buttons on the panel and their action listeners
		runTestButton = new JButton("Run Test");
		runTestButton.setBounds(200, 50, 100, 50);
		menuPanel.add(runTestButton);
		runTestButton.addActionListener(this);
		
		wipButton = new JButton("WIP");
		wipButton.setBounds(200, 125, 100, 50);
		menuPanel.add(wipButton);
		wipButton.addActionListener(this);
		
		wipButton2 = new JButton("WIP");
		wipButton2.setBounds(200, 200, 100, 50);
		menuPanel.add(wipButton2);
		wipButton2.addActionListener(this);
		
		wipButton3 = new JButton("WIP");
		wipButton3.setBounds(200, 275, 100, 50);
		menuPanel.add(wipButton3);
		wipButton3.addActionListener(this);
		
		menuFrame.setVisible(true);
	}

	//Action listener that determines what button was pressed and acts accordingly
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//If the runTestButton is pressed, create a new instance of the RunTestGUI class, and set the 
		//MainMenuGUI to invisible
		if(e.getSource() == runTestButton) {
			
			//Create an instance of RunTestGUI
			runTest = new RunTestGUI(user);
			runTest = null;
			//Set the menu to invisible
			//menuFrame.setVisible(false);
		}
		
		//If any other button is pressed, print "Feature not implemented" in the console
		else {
			System.out.println("Feature not implemented");
		}
		
	}

}
