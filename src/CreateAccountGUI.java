//GUI that allows users to create an account. Users must input a username, password
//and confirm their password
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class CreateAccountGUI implements ActionListener{
	
	//The variables we need for the GUI
	String username;
	String password;
	String confPass;
	
	JFrame caFrame;
	
	JPanel caPanel;
	
	JLabel caNameLabel;
	JLabel caPassLabel;
	JLabel caConfpassLabel;
	JLabel msg;
	
	JTextField caNameText;
	JTextField caPassText;
	JTextField caConfpassText;
	
	JButton caButton;
	
	//Constructor for the GUI
	CreateAccountGUI(){
		//Create the basic frame for our login window
		caFrame = new JFrame("Create Account");
		caFrame.setSize(500, 750);
		
		//Add a panel for us to put elements on, we will not use a specific layout for it so we can have
		//greater control over object placement
		caPanel = new JPanel();
		caPanel.setLayout(null);
		caFrame.add(caPanel);
		
		//This will allow us to close the frame
		caFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set up the text saying "Username", "Password", and "Confirm Password"
		caNameLabel = new JLabel("Username");
		caNameLabel.setBounds(50, 50, 100, 50);
		
		caPassLabel = new JLabel("Password");
		caPassLabel.setBounds(50, 100, 100, 50);
		
		caConfpassLabel = new JLabel ("Confirm Password");
		caConfpassLabel.setBounds(50, 150, 200, 50);
		
		msg = new JLabel("");
		msg.setBounds(50,150,50,50);
		
		caPanel.add(caNameLabel);
		caPanel.add(caPassLabel);
		caPanel.add(caConfpassLabel);
		
		//Now set up the textboxes for the username and password, each one will have 15 characters
		caNameText = new JTextField();
		caPassText = new JTextField();
		caConfpassText = new JTextField();
		
		caNameText.setBounds(175, 65, 100, 25);
		caPassText.setBounds(175, 115, 100, 25);
		caConfpassText.setBounds(175, 165, 100, 25);
		
		caPanel.add(caNameText);
		caPanel.add(caPassText);
		caPanel.add(caConfpassText);
		
		//Add the button that will attempt a login when pressed and it's action listener
		caButton = new JButton("Create Account");
		caButton.setBounds(150, 215, 125, 50);
		caPanel.add(caButton);
		caButton.addActionListener(this);
		
		caFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//When the create account button is pressed, simply make the string variables the current input
		//in the associated text boxes
		//If the login button has been pressed, set the username and password values to the input in their associated
		//text boxes. Set the GUI to invisible
		username = caNameText.getText();
		password = caPassText.getText();
		confPass = caConfpassText.getText();

		if(e.getSource() == caButton)
		{
			String result = InputValidator.validCreateUser(username, password, confPass);
			msg.setText(result);
			if(result.compareTo("") == 0)
			{
				result = NetRequestManager.addUserAttempt(username, password);
				msg.setText(result);
				if(result.compareTo("") == 0)
				{
					caFrame.dispose();
					LoginGui l = new LoginGui();
				}

			}
		}
		
	}

}