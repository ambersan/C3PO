import java.awt.BorderLayout;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.sql.SQLException;
import java.util.ArrayList;

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

public void remove(String s) {
	NotebookDAO n = new NotebookDAO();
	String x = "delete * from NoteBook where Content = '" + s + "'";
	n.runQuery(x);
}
public void addNote (String s){
	NotebookDAO n = new NotebookDAO();
	String x = "insert into table NoteBook values ('" + s + "')";
	n.runQuery(x);
	}

	public ArrayList<String> getTitles(){
		ArrayList<String> s = new ArrayList<String>();
		NotebookDAO n = new NotebookDAO();
		s.add("Enter new title or select from list");
		ResultSet rs = n.getNoteTitles();
		try {
			while (rs.next()) {
				s.add(rs.getString(1));
			}
		}catch(SQLException e){
			System.out.println(e);
		}
				return s;
	}

	public ResultSet getContent(String name){
		NotebookDAO n = new NotebookDAO();
		return n.getNoteContent(name);
	}

	public void updateContent (String content, String title){
		NotebookDAO n = new NotebookDAO();
		String x =  "update NoteBook set Content = '" + content + "' where Name = '" + title + "'";
		n.runQuery(x);
	}



}