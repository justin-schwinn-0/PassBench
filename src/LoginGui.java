//Gui for the login
import javax.swing.*;


public class LoginGui {
	
	//Constructor for the loginGUI
	LoginGui(){
		
		String username;
		String password;
		
		//Create the basic frame for our login window
		JFrame GuiFrame = new JFrame("Login");
		GuiFrame.setSize(200, 200);
		
		//Add a panel for us to put elements on, we will not use a specific layout for it so we can have
		//greater control over object placement
		JPanel GuiPanel = new JPanel();
		GuiPanel.setLayout(null);
		GuiFrame.add(GuiPanel);
		
		//This will allow us to close the frame
		GuiFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Set up the text saying "Username" and "Password"
		JLabel NameLabel = new JLabel("Username");
		NameLabel.setBounds(50, 50, 100, 50);
		
		JLabel PassLabel = new JLabel("Password");
		PassLabel.setBounds(50, 100, 100, 50);
		
		GuiPanel.add(NameLabel);
		GuiPanel.add(PassLabel);
		
		//Now set up the textboxes for the username and password, each one will have 15 characters
		JTextField NameText = new JTextField();
		JTextField PassText = new JTextField();
		
		NameText.setBounds(125, 65, 100, 25);
		PassText.setBounds(125, 115, 100, 25);
		
		GuiPanel.add(NameText);
		GuiPanel.add(PassText);
		
		GuiFrame.setVisible(true);
	}
	
}
