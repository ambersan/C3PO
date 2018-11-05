import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class ToDo {
	
	public ToDo()
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
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
		JButton newListBTN = new JButton("+");
		newListBTN.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JRadioButton unorderList = new JRadioButton("Undordered List");
		JRadioButton orderList = new JRadioButton("Ordered List");
		ButtonGroup radios = new ButtonGroup();
		radios.add(orderList);
		radios.add(unorderList);
		
		JLabel title = new JLabel("To Do List");
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setForeground(Color.YELLOW);
		
		JPanel buttonPane = new JPanel();
		buttonPane.add(newListBTN);
		buttonPane.add(unorderList);
		buttonPane.add(orderList);
		
		JPanel titlePane = new JPanel();
		titlePane.setBackground(Color.DARK_GRAY);
		titlePane.add(title);
		
		//Add listeners to buttons
		newListBTN.addActionListener( new ActionListener()
			{
				@Override 
				public void actionPerformed( ActionEvent e)
				{
					//create new list
				}
			}//end ActionListener
		);//end add
		
		unorderList.addActionListener( new ActionListener()
			{
				@Override 
				public void actionPerformed( ActionEvent e)
				{
					//set list order variable to unordered
				}
			}//end ActionListener
		);//end add
		
		orderList.addActionListener( new ActionListener()
			{
				@Override 
				public void actionPerformed( ActionEvent e)
				{
					//set list order variable to ordered
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

}
