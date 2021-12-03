//Gui for the login
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;


public class LoginGui implements ActionListener {
	
	//All the variables for our GUI
	String username;
	String password;
	
	JFrame guiFrame;
	
	JPanel guiPanel;
	
	JLabel nameLabel;
	JLabel passLabel;
	
	JTextField nameText;
	JTextField passText;
	
	JButton loginButton;
	
	
	//Constructor for the loginGUI
	LoginGui(){
		
		//Create the basic frame for our login window
		guiFrame = new JFrame("Login");
		guiFrame.setSize(500, 500);
		
		//Add a panel for us to put elements on, we will not use a specific layout for it so we can have
		//greater control over object placement
		guiPanel = new JPanel();
		guiPanel.setLayout(null);
		guiFrame.add(guiPanel);
		
		//This will allow us to close the frame
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set up the text saying "Username" and "Password"
		nameLabel = new JLabel("Username");
		nameLabel.setBounds(50, 50, 100, 50);
		
		passLabel = new JLabel("Password");
		passLabel.setBounds(50, 100, 100, 50);
		
		guiPanel.add(nameLabel);
		guiPanel.add(passLabel);
		
		//Now set up the textboxes for the username and password, each one will have 15 characters
		nameText = new JTextField();
		passText = new JTextField();
		
		nameText.setBounds(125, 65, 100, 25);
		passText.setBounds(125, 115, 100, 25);
		
		guiPanel.add(nameText);
		guiPanel.add(passText);
		
		//Add the button that will attempt a login when pressed and it's action listener
		loginButton = new JButton("Login");
		loginButton.setBounds(125, 165, 50, 50);
		guiPanel.add(loginButton);
		loginButton.addActionListener(this);
		
		guiFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//If the login button has been pressed, set the username and password values to the input in their associated
		//text boxes. Set the GUI to invisible
		username = nameText.getText();
		password = nameText.getText();
		guiFrame.setVisible(false);
		
	}
	
}
