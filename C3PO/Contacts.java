import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;


public class Contacts implements ActionListener{
	
	ArrayList personsList;
	PersonDAO pDAO;
	JLabel Name, Address, Phone, Email;
	JTextField fName, fAddress, fPhone, fEmail;
	JButton saveBTN, deleteBTN, clearBTN, updateBTN, searchBTN, forwardBTN, backBTN, exitBTN;
	String name, address, email;
	int phone;
	int recordNumber;
	Container cPane;
	JFrame frame;
	
	public Contacts()
	{
		//javax.swing.SwingUtilities.invokeLater(new Runnable() {
			//public void run() {
				//createAndShowGUI();
			//}
		//});
		
		name = "";
		address = "";
		email = "";
		phone = -1;
		recordNumber = -1;
		
		personsList = new ArrayList();
		pDAO = new PersonDAO();
		
		createAndShowGUI();
		
	}
	
	
	private void createAndShowGUI() 
	{
		//*CREATE AND SET UP THE WINDOW
		//Ask for window decorations provided by the look and feel
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		//Create the frame, close on exit and its content pane
		frame = new JFrame("C3PO : Contacts");
		cPane = frame.getContentPane();
		cPane.setLayout(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Set the frame icon to an image loaded from a file
		frame.setIconImage(new ImageIcon("/home/campus20/aslabbek/Desktop/TeamSoftware/robot.png").getImage());
		
		//format the components
		Name = new JLabel("Name:");
		Address = new JLabel("Address:");
		Phone = new JLabel("Phone Number:");
		Email = new JLabel("Email:");
		
		fName = new JTextField(20);
		fAddress = new JTextField(20);
		fPhone = new JTextField(20);
		fEmail = new JTextField(20);
		
		saveBTN = new JButton("save");
		deleteBTN = new JButton("delete");
		clearBTN = new JButton("clear");
		updateBTN = new JButton("update");
		searchBTN = new JButton("search");
		forwardBTN = new JButton(">>");
		backBTN = new JButton("<<");
		exitBTN = new JButton("exit");
		
		
		//format the grid-bag layout
		GridBagConstraints settings = new GridBagConstraints();
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 0;
    	settings.gridy = 0;
    	cPane.add(Name, settings);
    	
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 1;
    	settings.gridy = 0;
    	settings.gridwidth = 2;
    	settings.fill = GridBagConstraints.BOTH;
    	cPane.add(fName, settings);
    	
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 0;
    	settings.gridy = 1;
    	cPane.add(Address, settings);
    	
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 1;
    	settings.gridy = 1;
    	settings.gridwidth = 2;
    	settings.fill = GridBagConstraints.BOTH;
    	cPane.add(fAddress, settings);
		
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 0;
    	settings.gridy = 2;
    	cPane.add(Phone, settings);
    	
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 1;
    	settings.gridy = 2;
    	settings.gridwidth = 2;
    	settings.fill = GridBagConstraints.BOTH;
    	cPane.add(fPhone, settings);
		
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 0;
    	settings.gridy = 3;
    	cPane.add(Email, settings);
    	
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 1;
    	settings.gridy = 3;
    	settings.gridwidth = 2;
    	settings.fill = GridBagConstraints.BOTH;
    	cPane.add(fEmail, settings);
    	
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 0;
    	settings.gridy = 4;
    	cPane.add(saveBTN, settings);
    	
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 1;
    	settings.gridy = 4;
    	cPane.add(deleteBTN, settings);
    	
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 2;
    	settings.gridy = 4;
    	cPane.add(updateBTN, settings);
    	
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 0;
    	settings.gridy = 5;
    	cPane.add(backBTN, settings);
    	
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 1;
    	settings.gridy = 5;
    	cPane.add(searchBTN, settings);
    	
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 2;
    	settings.gridy = 5;
    	cPane.add(forwardBTN, settings);
    	
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 1;		//remove?
    	settings.gridy = 6;
    	cPane.add(clearBTN, settings);
    	
    	settings.insets = new Insets(5, 5, 5, 5);
    	settings.gridx = 2;
    	settings.gridy = 6;
    	cPane.add(exitBTN, settings);
    	
    	//add button listeners
    	saveBTN.addActionListener(this);
    	deleteBTN.addActionListener(this);
    	clearBTN.addActionListener(this);
    	updateBTN.addActionListener(this);
    	searchBTN.addActionListener(this);
    	forwardBTN.addActionListener(this);
    	backBTN.addActionListener(this);
    	exitBTN.addActionListener(this);
    	
		//*SHOW THE FRAME
		frame.setSize(550, 300);
		frame.setResizable(false);
		frame.setVisible(true);
	}


	//when button is clicked
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == deleteBTN)
		{
			savePerson();
			clear();
		}else if(e.getSource() == deleteBTN)
		{
			deletePerson();
			clear();
		}else if(e.getSource() == updateBTN)
		{
			updatePerson();
			clear();
		}else if(e.getSource() == searchBTN)
		{
			searchPerson();
		}else if (e.getSource() == forwardBTN) 
		{
			displayNextRecord();
		}else if (e.getSource() == backBTN) 
		{
			display PreviousRecord();
		}else if (e.getSource() == clearBTN)
		{
			clear();
		}else if (e.getSource() == exitBTN)
		{
			frame.dispose();
		}
	}
	
	
	//methods to handle data entered into the fields
	public void savePerson()
	{
		name = Name.getText();
		name = name.toUpperCase();		//if all names are uppercase they are easier to handle
		
		address = Address.getText();
		email = Email.getText();
		try
		{
			//try to read the Phone input string as an integer
			phone = Integer.parseInt("" + Phone.getText());
		}catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null,"Please enter a phone number");
		}
		
		//if name not entered
		if(name.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please enter person's name");
		}
		else
		{
			//create a PersonInfor with the provided information and pass to DAO to save
			PersonInfo person = new PersonInfo(name, address, phone, email);
			pDAO.savePerson(person);
			JOptionPane.showMessageDialog(null, "Contact saved!");
		}
	}//end savePerson
	
	public void deletePerson()
	{
		name = Name.getText();
		name = name.toUpperCase();
		
		if(name.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please enter person's name");
		}
		else
		{
			int idNumber = pDAO.removePerson(name);
			JOptionPane.showMessageDialog(null, idNumber + " record(s) deleted!");
		}
	}//end deltetePerson
	
	public void updatePerson()
	{
		
	}

}
