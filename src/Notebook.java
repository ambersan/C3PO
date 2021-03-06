import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Notebook 
{
	JTextArea note;
	JScrollPane scroll;
	JPanel pane;
	JFrame frame;
	ArrayList<String> titles = new ArrayList<String>();
	String[] cbTitles = new String[1000];
	JComboBox<String> dropDown;
	String chosen = "";
	String content_on_screen = "";
	JButton addBTN;
	JButton deleteBTN;
	JButton saveBTN;
	String title;
	String content;

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
		titles.add("Enter new title or select from list");
		titles.addAll(getTitles());

		note = new JTextArea(100, 100);	
		note.setText("Enter your note here");
		note.setEditable(true);
		note.setLineWrap(true);
		//note.setWrapStyleWord(true);

		scroll = new JScrollPane(note);
		System.out.println("Scroll pane added text area successfully");
		pane = new JPanel();

		addBTN = new JButton("Add Note");
		deleteBTN = new JButton("Delete Note");
		saveBTN = new JButton("Save Note");

		addBTN.setFont(new Font("Arial", Font.PLAIN, 15));
		deleteBTN.setFont(new Font("Arial", Font.PLAIN, 15));
		saveBTN.setFont(new Font("Arial", Font.PLAIN, 15));

		pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
		pane.add(addBTN);
		pane.add(deleteBTN);
		pane.add(saveBTN);

		//fill title combo box with arraylist of titles
		for (int i = 0; i < cbTitles.length; i++)
		{
			if(cbTitles[i] != null)
			{
				cbTitles[i] = titles.get(i);
			}
		}
		dropDown = new JComboBox<>();
		dropDown.setEditable(true);

		frame.add(dropDown, BorderLayout.NORTH);
		frame.add(note, BorderLayout.CENTER);
		frame.add(pane,  BorderLayout.SOUTH);

		//*SIZE THE FRAME
		frame.setSize(550, 300);

		//*SHOW THE FRAME
		frame.setVisible(true);

		//*SIZE THE FRAME
		frame.setSize(550, 300);

		//*SHOW THE FRAME
		frame.setVisible(true);
	}

	//when button is clicked
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == addBTN)
		{
			System.out.println("Made it into button click : ADD");

			//get title value
			title = (String) dropDown.getSelectedItem();

			//get content value
			content = note.getText();

			//call db add with title and content
			addNote(title, content);

			//leave the title and content on the screen
		}
		else if(e.getSource() == deleteBTN)
		{
			System.out.println("Made it into button click : DELETE");

			//get title value
			title = (String) dropDown.getSelectedItem();

			//call db remove with the title
			remove(title);

			//wipe the title and content from the screen
			dropDown.removeItem(title);
			note.setText("");

		}
		else if(e.getSource() == saveBTN)
		{
			System.out.println("Made it into button click : SAVE");

			//get title value
			title = (String) dropDown.getSelectedItem();

			//get content value
			content = note.getText();

			//call db update with title and content
			updateContent(content, title);

			//leave the title and content on the screen
		}
		else if(e.getSource() == dropDown)
		{
			System.out.println("DROPDOWN registered");

			//clear the old dropDown from screen
			frame.remove(dropDown);

			//get new title from dropDown
			titles.add((String) dropDown.getSelectedItem());

			//update the dropDown on the screen
			for (int i = 0; i < cbTitles.length; i++)
			{
				if(cbTitles[i] != "")
				{
					cbTitles[i] = titles.get(i);
				}
			}
			dropDown = new JComboBox<>(cbTitles);
			dropDown.setEditable(true);
			frame.add(dropDown, BorderLayout.NORTH);
			frame.repaint();
			frame.validate();
		}
	}

	public void remove(String t) 
	{
		NotebookDAO n = new NotebookDAO();
		String x = "delete from NoteBook where Name = '" + t + "'";
		n.runQuery(x);
	}
	public void addNote (String t, String c)
	{
		NotebookDAO n = new NotebookDAO();
		String x = "insert into NoteBook values ('"+ t + "', '" + LocalDateTime.now() + "', '" + c + "')";
		n.runQuery(x);
	}

	public ArrayList<String> getTitles()
	{
		ArrayList<String> s = new ArrayList<String>();
		NotebookDAO n = new NotebookDAO();
		s.add("Enter new title or select from list");
		ResultSet rs = n.getNoteTitles();
		try 
		{
			while (rs.next()) 
			{
				s.add(rs.getString(1));
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return s;
	}

	public ResultSet getContent(String name)
	{
		NotebookDAO n = new NotebookDAO();
		return n.getNoteContent(name);
	}

	public void updateContent (String content, String title)
	{
		NotebookDAO n = new NotebookDAO();
		String x =  "update NoteBook set Content = '" + content + "' where Name = '" + title + "'";
		n.runQuery(x);
	}
}