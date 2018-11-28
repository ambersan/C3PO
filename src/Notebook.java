import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Notebook 
{
	public Notebook()
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	
	private void createAndShowGUI() 
	{
		JTextField fNote = new JTextField(500);	
		fNote.setText("");
		
		//*CREATE AND SET UP THE WINDOW
		//Ask for window decorations provided by the look and feel
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		//Create the frame, close on exit
		JFrame frame = new JFrame("C3PO : Notebook");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Set the frame icon to an image loaded from a file
		frame.setIconImage(new ImageIcon("/home/campus20/aslabbek/Desktop/TeamSoftware/robot.png").getImage());
		
		//make a list of the note titles from the database (function used here to make list)
		String[] titles = new String[] { "Sample 1", "Sample 2", "So on", "and so forth"};
		JComboBox<String> dropDown = new JComboBox<>(titles);
		frame.add(dropDown, BorderLayout.NORTH);
		frame.add(fNote, BorderLayout.CENTER);
		
		//get the selected item for retrieving the note
		String chosen = (String) dropDown.getSelectedItem();
		
		//to DELETE a note user can activate a method that calls the dropDown.removeItem and a database deletion 
		
		//hand the 'chosen' title to a database method that returns the note as a string
		
		//note text field is updated 
		fNote.setText("Returned string from database match");
		
		
		
		
		
		
		
		
		//*SIZE THE FRAME
		//frame.pack();		//shrink/grows to fit
		frame.setSize(550, 300);
		
		
		//*SHOW THE FRAME
		frame.setVisible(true);
	}
}
