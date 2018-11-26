import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class ToDo implements ActionListener{
	
	//arraylist of query results and check box objects
	ArrayList list = new ArrayList ();
	ArrayList<JCheckBox> checkboxes = new ArrayList<> ();
	
	
	public ToDo()
	{
		createAndShowGUI();	
	}
	
	
	private static void createAndShowGUI() 
	{
		//*CREATE AND SET UP THE WINDOW
		//Ask for window decorations provided by the look and feel
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		//Create the frame, close on exit
		JFrame frame = new JFrame("C3PO : To-Do List");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Set the frame icon to an image loaded from a file
		frame.setIconImage(new ImageIcon("/home/campus20/aslabbek/Desktop/TeamSoftware/robot.png").getImage());
		
		
		//*CREATE THE COMPONENTS
		JButton newListBTN = new JButton("Refresh List");
		newListBTN.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel title = new JLabel("To Do List");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setForeground(Color.YELLOW);
		
		JPanel buttonPane = new JPanel();
		buttonPane.add(newListBTN);
		
		JPanel titlePane = new JPanel();
		titlePane.setBackground(Color.DARK_GRAY);
		titlePane.add(title);
		
		JTextField field;
		JPanel pane;
		
		//Add listeners to buttons
		newListBTN.addActionListener( new ActionListener()
			{
				@Override 
				public void actionPerformed( ActionEvent e)
				{
					
					//retrieve the newest list from database
					//repaint the list (get the result set from the query and the panel
					
				}
			}//end ActionListener
		);//end add
		
		
		
		//*ADD COMPONENTS TO THE FRAME		
		frame.getContentPane().add(buttonPane, BorderLayout.WEST);
		frame.getContentPane().add(titlePane, BorderLayout.NORTH);
		
		
		//*SIZE THE FRAME
		//frame.pack();		//shrink/grows to fit
		frame.setSize(550, 300);
		
		
		//*SHOW THE FRAME
		frame.setVisible(true);
	}
	
	//method to update the list
	public void updateList (ResultSet rs, Panel p, Frame f) throws SQLException
	{
		int i = 0;
		while(rs.next())
		{
			Task task = new Task();
			task.setDescription(rs.getString("description"));
			task.setSelected(false);
			
			list.add(task);
		}
		
		//add each task to a check box item
		for(Object t : list)
		{
			JCheckBox item = new JCheckBox(list.get(i).toString());
			checkboxes.add(item);
			p.add(item);
		}
		
		//add the panel to the frame to overwrite previous frame
		f.add(p);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
