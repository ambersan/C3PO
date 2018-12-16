import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Contacts implements ActionListener
{
	ArrayList personsList;
	PersonDAO pDAO;
	JLabel Name, Address, Phone, Email, Cell;
	JTextField fName, fAddress, fPhone, fEmail, fCell;
	JButton saveBTN, deleteBTN, clearBTN, updateBTN, searchBTN, forwardBTN, backBTN, exitBTN;
	String name, address, email, tempname;
	int phone, cell;
	int recordNumber;
	Container cPane;
	JFrame frame;

	public Contacts()
	{	
		name = "";
		address = "";
		email = "";
		phone = -1;
		cell = -1;
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
		Cell = new JLabel("Cell Phone: ");

		fName = new JTextField(50);
		fAddress = new JTextField(50);
		fPhone = new JTextField(50);
		fEmail = new JTextField(50);
		fCell = new JTextField(50);

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

		GridBagConstraints settings2 = new GridBagConstraints();
		settings2.insets = new Insets(5, 5, 5, 5);
		settings2.gridx = 1;
		settings2.gridy = 0;
		settings2.gridwidth = 7;
		settings2.fill = GridBagConstraints.BOTH;
		cPane.add(fName, settings2);

		GridBagConstraints settings3 = new GridBagConstraints();
		settings3.insets = new Insets(5, 5, 5, 5);
		settings3.gridx = 0;
		settings3.gridy = 1;
		cPane.add(Address, settings3);

		GridBagConstraints settings4 = new GridBagConstraints();
		settings4.insets = new Insets(5, 5, 5, 5);
		settings4.gridx = 1;
		settings4.gridy = 1;
		settings4.gridwidth = 7;
		settings4.fill = GridBagConstraints.BOTH;
		cPane.add(fAddress, settings4);

		GridBagConstraints settings5 = new GridBagConstraints();
		settings5.insets = new Insets(5, 5, 5, 5);
		settings5.gridx = 0;
		settings5.gridy = 2;
		cPane.add(Phone, settings5);

		GridBagConstraints settings6 = new GridBagConstraints();
		settings6.insets = new Insets(5, 5, 5, 5);
		settings6.gridx = 1;
		settings6.gridy = 2;
		settings6.gridwidth = 7;
		settings6.fill = GridBagConstraints.BOTH;
		cPane.add(fPhone, settings6);

		GridBagConstraints settings7 = new GridBagConstraints();
		settings7.insets = new Insets(5, 5, 5, 5);
		settings7.gridx = 0;
		settings7.gridy = 3;
		cPane.add(Cell, settings7);

		GridBagConstraints settings8 = new GridBagConstraints();
		settings8.insets = new Insets(5, 5, 5, 5);
		settings8.gridx = 1;
		settings8.gridy = 3;
		settings8.gridwidth = 7;
		settings8.fill = GridBagConstraints.BOTH;
		cPane.add(fCell, settings8);

		GridBagConstraints settings9 = new GridBagConstraints();
		settings9.insets = new Insets(5, 5, 5, 5);
		settings9.gridx = 0;
		settings9.gridy = 4;
		cPane.add(Email, settings9);

		GridBagConstraints settings10 = new GridBagConstraints();
		settings10.insets = new Insets(5, 5, 5, 5);
		settings10.gridx = 1;
		settings10.gridy = 4;
		settings10.gridwidth = 7;
		settings10.fill = GridBagConstraints.BOTH;
		cPane.add(fEmail, settings10);

		GridBagConstraints settings11 = new GridBagConstraints();
		settings11.insets = new Insets(5, 5, 5, 5);
		settings11.gridx = 0;
		settings11.gridy = 5;
		cPane.add(saveBTN, settings11);

		GridBagConstraints settings12 = new GridBagConstraints();
		settings12.insets = new Insets(5, 5, 5, 5);
		settings12.gridx = 1;
		settings12.gridy = 5;
		cPane.add(deleteBTN, settings12);

		GridBagConstraints settings13 = new GridBagConstraints();
		settings13.insets = new Insets(5, 5, 5, 5);
		settings13.gridx = 2;
		settings13.gridy = 5;
		cPane.add(updateBTN, settings13);

		GridBagConstraints settings14 = new GridBagConstraints();
		settings14.insets = new Insets(5, 5, 5, 5);
		settings14.gridx = 0;
		settings14.gridy = 6;
		cPane.add(backBTN, settings14);

		GridBagConstraints settings15 = new GridBagConstraints();
		settings15.insets = new Insets(5, 5, 5, 5);
		settings15.gridx = 1;
		settings15.gridy = 6;
		cPane.add(searchBTN, settings15);

		GridBagConstraints settings16 = new GridBagConstraints();
		settings16.insets = new Insets(5, 5, 5, 5);
		settings16.gridx = 2;
		settings16.gridy = 6;
		cPane.add(forwardBTN, settings16);

		GridBagConstraints settings17 = new GridBagConstraints();
		settings17.insets = new Insets(5, 5, 5, 5);
		settings17.gridx = 1;		//remove?
		settings17.gridy = 7;
		cPane.add(clearBTN, settings17);

		GridBagConstraints settings18 = new GridBagConstraints();
		settings18.insets = new Insets(5, 5, 5, 5);
		settings18.gridx = 2;
		settings18.gridy = 7;
		cPane.add(exitBTN, settings18);


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
		frame.setSize(600, 300);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	//when button is clicked
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == deleteBTN)
		{
			savePerson();
			clear();
		}
		else if(e.getSource() == deleteBTN)
		{
			deletePerson();
			clear();
		}
		else if(e.getSource() == updateBTN)
		{
			updatePerson();
			clear();
		}
		else if(e.getSource() == searchBTN)
		{
			searchPerson();
		}
		else if (e.getSource() == forwardBTN) 
		{
			displayNextRecord();
		}
		else if (e.getSource() == backBTN) 
		{
			displayPreviousRecord();
		}
		else if (e.getSource() == clearBTN)
		{
			clear();
		}
		else if (e.getSource() == exitBTN)
		{
			frame.dispose();
		}
	}

	//methods to handle data entered into the fields
	public void savePerson()
	{
		tempname = fName.getText();
		name = tempname.toUpperCase();		//if all names are upper-case they are easier to handle
		address = fAddress.getText();
		email = fEmail.getText();
		try
		{
			//try to read the Phone input string as an integer
			phone = Integer.parseInt("" + fPhone.getText());
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null,"Please enter a phone number (-1 if N/A)");
		}

		try
		{
			//try to read the Cell input string as an integer
			cell = Integer.parseInt("" + fCell.getText());
		}
		catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null,"Please enter a cell phone number (-1 if N/A)");
		}

		//if name not entered
		if(name.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please enter person's name");
		}
		else
		{
			//create a PersonInfor with the provided information and pass to DAO to save
			PersonInfo person = new PersonInfo(name, address, phone, cell, email);
			pDAO.savePerson(person);
			JOptionPane.showMessageDialog(null, "Contact saved!");
		}
	}//end savePerson

	public void deletePerson()
	{
		tempname = fName.getText();
		name = tempname.toUpperCase();

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
		if(recordNumber >= 0 && recordNumber < personsList.size())
		{
			//if the record is within the list of persons, get it for the UI
			PersonInfo person = (PersonInfo) personsList.get(recordNumber);

			//set variables to newly entered values
			name = fName.getText();
			address = fAddress.getText();
			phone = Integer.parseInt(fPhone.getText());
			cell = Integer.parseInt(fCell.getText());
			email = fEmail.getText();

			person = new PersonInfo(name, address, phone, cell, email);
			pDAO.updatePerson(person);

			JOptionPane.showMessageDialog(null, "Contact updated");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No record to update");
		}
	}//end updatePerson


	public void searchPerson()
	{
		name = fName.getText();
		name = name.toUpperCase();
		personsList.clear();
		recordNumber = 0;

		//if no name was entered
		if(name.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please enter person's name");
		}
		else
		{
			personsList = pDAO.searchPerson(name);

			//if there are no items in the list, no matches were found
			if(personsList.size() == 0) 
			{
				JOptionPane.showMessageDialog(null, "No such person found");
			}
			else
			{
				PersonInfo person = (PersonInfo) personsList.get(recordNumber);

				//display the contacts info in the fields
				fName.setText(person.getName());
				fAddress.setText(person.getAddress());
				fPhone.setText("" + person.getPhone());
				fCell.setText("" + person.getCell());
				fEmail.setText(person.getEmail());

			}
		}
	}//end searchPerson


	//Methods to make the paging buttons work
	public void displayNextRecord()
	{
		recordNumber++;

		//if the record is at the end of the list
		if( recordNumber >= personsList.size()) 
		{

			//because we are at the end of the results the button is disabled
			JOptionPane.showMessageDialog(null, "End of search results");
			forwardBTN.setEnabled(false);
			backBTN.setEnabled(true);
			recordNumber--;

		}
		else
		{
			//enable the back button 
			backBTN.setEnabled(true);

			//grab the next record
			PersonInfo person = (PersonInfo) personsList.get(recordNumber);

			//fill the fields
			fName.setText(person.getName());
			fAddress.setText(person.getAddress());
			fPhone.setText("" + person.getPhone());
			fCell.setText("" + person.getCell());
			fEmail.setText(person.getEmail());

		}
	}//end of displayNext

	public void displayPreviousRecord()
	{
		recordNumber--;

		//if the record is at the beginning of the results
		if( recordNumber < 0)
		{
			//because we are at the beginning of the results the button is disabled
			JOptionPane.showMessageDialog(null, "Beginning of search results");
			forwardBTN.setEnabled(true);
			backBTN.setEnabled(false);
			recordNumber++;
		}
		else
		{
			//enable the forward button 
			forwardBTN.setEnabled(true);

			//grab the next record
			PersonInfo person = (PersonInfo) personsList.get(recordNumber);

			//fill the fields
			fName.setText(person.getName());
			fAddress.setText(person.getAddress());
			fPhone.setText("" + person.getPhone());
			fCell.setText("" + person.getCell());
			fEmail.setText(person.getEmail());
		}
	}//end of displayPrevious

	//method to clear the fields
	public void clear()
	{
		fName.setText("");
		fAddress.setText("");
		fPhone.setText("");
		fEmail.setText("");
		fCell.setText("");

		//reset the search variables
		recordNumber = -1;
		personsList.clear();
		forwardBTN.setEnabled(true);
		backBTN.setEnabled(true);
	}
}