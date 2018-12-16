import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ToDo implements ActionListener
{
	//arraylist of query results and check box objects
		ArrayList list = new ArrayList ();
		ArrayList<JCheckBox> checkboxes = new ArrayList<> ();
		
		//Global variables to keep all the stupid errors from bugging me about statics
		JFrame frame;
		JButton newListBTN;
		JButton addTaskBTN;
		static JPanel taskPane;
		JLabel title;
		JLabel taskName;
		JTextField input;
		JPanel buttonPane;
		JPanel titlePane;
		String taskInput;
		String desc = new String();
		
		
		public ToDo() 
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
			newListBTN.setMaximumSize(new Dimension(200, 30));
			
			JButton addTaskBTN = new JButton("Add Task");
			addTaskBTN.setFont(new Font("Arial", Font.PLAIN, 15));
			addTaskBTN.setMaximumSize(new Dimension(200, 30));
			
			//add button listeners
	    	newListBTN.addActionListener(this);
	    	addTaskBTN.addActionListener(this);
			
			JLabel title = new JLabel("To Do List");
			title.setFont(new Font("Arial", Font.BOLD, 20));
			title.setForeground(Color.YELLOW);
			
			JLabel taskName = new JLabel("New Task");
			JTextField input = new JTextField();
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));
			buttonPane.add(newListBTN);
			buttonPane.add(addTaskBTN);
			buttonPane.add(taskName);
			buttonPane.add(input);
			
			JPanel titlePane = new JPanel();
			titlePane.setBackground(Color.DARK_GRAY);
			titlePane.add(title);
			
			taskPane = new JPanel();
			taskPane.setLayout(new BoxLayout(taskPane, BoxLayout.Y_AXIS));
			taskPane.repaint();
			
			frame.pack();
			frame.setVisible(true);
			
			/*
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
			*/
			
			
			//*ADD COMPONENTS TO THE FRAME		
			frame.getContentPane().add(buttonPane, BorderLayout.WEST);
			frame.getContentPane().add(titlePane, BorderLayout.NORTH);
			frame.getContentPane().add(taskPane);
			
			
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


		public void actionPerformed(ActionEvent e) 
		{
			//WORKS WITH SINGLE REMOVAL ONLY, POSSIBLY FIX?
			
			if(e.getSource() == addTaskBTN)
			{
				//get the text from the input field and reset to empty 
				taskInput = input.getText();
				input.setText("");
				
				//validate that the text doesn't interfere with the base
				if(taskInput.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter a task description");
					input.requestFocusInWindow();
				}
				else
				{
					//create a checkbox with input
					JCheckBox cb = new JCheckBox(taskInput, false);
					
					//add the task to the pane
					checkboxes.add(cb);
					taskPane.add(cb);
					taskPane.validate();
					
					//add the task to the database
					addTask(taskInput);
					
				}
				
				
				
			}
			if(e.getSource() == newListBTN)
			{
				
				//for each checkbox in the list
				for (Iterator<JCheckBox> iterator = checkboxes.iterator(); iterator.hasNext();) 
				{
				    JCheckBox cb = iterator.next();
				    if (cb.isSelected()) 
				    {
				    	desc = cb.getText();
				    	
				        // Remove the current element from the iterator and the list.
				        iterator.remove();
				        taskPane.remove(cb);
				        taskPane.repaint();
				        taskPane.validate();
				    }
				}
				
				//pass desc to database 
				removeTask(desc);
				
				//call db method to get result set rs
				try {
					updateList(grabTasks());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		
		
		//method to update the list
		public void updateList (ResultSet rs) throws SQLException
		{
			int i = 0;
			while(rs.next())
			{
				Task task = new Task();
				task.setDescription(rs.getString("description"));
				task.setSelected(false);
				
				//create a checkbox with input
				JCheckBox cb1 = new JCheckBox(taskInput);
				
				//add the task to the pane
				checkboxes.add(cb1);
				taskPane.add(cb1);
				taskPane.validate();
				
			}
			
		}
		
		//method to remove tasks
		public void removeTask(String desc)
		{
			//makes connection to the database
			TaskDAO t = new TaskDAO();
			
			//makes and runs the statement
			String s = "delete from To_Do where Content = '" + desc + "'";
			t.runQuery(s);
		}
		
		
		//method to refresh the list
		public ResultSet grabTasks()
		{
			TaskDAO t = new TaskDAO();
			
			return t.getTasks();
		}
		
		//method to add task to the database
		public void addTask(String desc)
		{
			TaskDAO t = new TaskDAO();
			String s = "insert into table To_Do values ('" + desc + "')";
			t.runQuery(s);
		}
}
