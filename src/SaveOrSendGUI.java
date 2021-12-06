//GUI that will ask the user if it'd like to save or send the records of their test
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class SaveOrSendGUI implements ActionListener{
	
	//Variables and data needed for the GUI
	//String needed to store data
	String userChoice;
	
	//Frame and Panel
	JFrame SoSFrame;
	JPanel SoSPanel;
	
	//Label for text
	JLabel SoSLabel;
	JLabel recordL1;
	JLabel recordL2;
	JLabel recordL3;
	JLabel recordL4;
	JLabel recordL5;
	
	//Buttons
	JButton SaveButton;
	JButton SendButton;
	
	Record r;

	//Constructor
	SaveOrSendGUI(Record r){
		//Create the frame and panel for our GUI
		SoSFrame = new JFrame("Records Sender");
		SoSFrame.setSize(500, 200);
		SoSPanel = new JPanel();
		SoSPanel.setLayout(null);
		SoSFrame.add(SoSPanel);
		this.r = r;
		//This will allow us to close the frame
		SoSFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set up the label that asks the user if they would like to send their records
		JLabel RecordLabel = new JLabel("Would you like to save or send your records?");
		RecordLabel.setBounds(150, 25, 500, 50);
		SoSPanel.add(RecordLabel);
		
		//Set up the buttons
		SaveButton = new JButton("Save");
		SaveButton.setBounds(50, 100, 80, 50);
		SaveButton.addActionListener(this);
		
		SendButton = new JButton("Send");
		SendButton.addActionListener(this);
		SendButton.setBounds(400, 100, 80, 50);

		recordL1 = new JLabel(r.user);
		recordL1.setBounds(235, 40, 100, 50);
		recordL2 = new JLabel(r.cpu);
		recordL2.setBounds(235, 51, 100, 50);
		recordL3 = new JLabel(r.dataType);
		recordL3.setBounds(235, 62, 100, 50);
		recordL4 = new JLabel(r.testType);
		recordL4.setBounds(235, 73, 100, 50);
		recordL5 = new JLabel(r.perf);
		recordL5.setBounds(235, 84, 100, 50);

		SoSPanel.add(recordL1);
		SoSPanel.add(recordL2);
		SoSPanel.add(recordL3);
		SoSPanel.add(recordL4);
		SoSPanel.add(recordL5);
	
		
		SoSPanel.add(SaveButton);
		SoSPanel.add(SendButton);
		
		SoSFrame.setVisible(true);


	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		//If the Save button has been pressed, set the userChoice value to Send and remove the frame
		if(e.getSource() == SaveButton) {
			SoSFrame.setVisible(false);

			SaveRecordsGUI s = new SaveRecordsGUI(r);

			SoSFrame.dispose();
		}
		
		//Do the same if Send is pressed instead
		else if (e.getSource() == SendButton) {
			//SoSFrame.setVisible(false);

			NetRequestManager.sendRecord(r);

			SoSFrame.dispose();
		}
		
	}

}