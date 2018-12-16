import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Front extends ButtonClickListener
{
	int BGred = 0;
	int BGblue = 0;
	int BGgreen = 0;
	int FGred = 255;
	int FGblue = 255;
	int FGgreen = 255;

	public void setBGColor(int r, int g, int b, JPanel pane)
	{
		Color c = new Color(r, g, b);
		pane.setBackground(c);
	}

	public void setFGColor(int r, int g, int b, JLabel text)
	{
		Color c = new Color(r, g, b);
		text.setForeground(c);
	}

	private static void createAndShowGUI() 
	{
		//get user login information
		LoginDialog loginScreen = new LoginDialog();

		//*CREATE AND SET UP THE WINDOW
		//Ask for window decorations provided by the look and feel
		JFrame.setDefaultLookAndFeelDecorated(true);

		//Create the frame, close on exit
		JFrame frame = new JFrame("C3PO");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set the frame icon to an image loaded from a file
		frame.setIconImage(new ImageIcon("/home/campus20/aslabbek/Desktop/TeamSoftware/robot.png").getImage());

		//*CREATE THE COMPONENTS
		//JLabel label = new JLabel("GUI here");
		JLabel header = new JLabel("Computer-based Personal Project and Productions Organizer");
		JButton toDoBTN = new JButton("To-Do List");
		JButton settingsBTN = new JButton("Settings");
		JButton notebookBTN = new JButton("Notes");
		JButton contactsBTN = new JButton("Contacts");

		//customize the components
		header.setFont(new Font("Arial", Font.PLAIN, 20));
		header.setForeground(Color.YELLOW);

		toDoBTN.setFont(new Font("Arial", Font.PLAIN, 15));
		settingsBTN.setFont(new Font("Arial", Font.PLAIN, 15));
		notebookBTN.setFont(new Font("Arial", Font.PLAIN, 15));
		contactsBTN.setFont(new Font("Arial", Font.PLAIN, 15));

		//Add listeners to buttons
		toDoBTN.setActionCommand("todo");
		settingsBTN.setActionCommand("settings");
		notebookBTN.setActionCommand("notebook");
		contactsBTN.setActionCommand("contacts");

		toDoBTN.addActionListener(new ButtonClickListener());
		settingsBTN.addActionListener(new ButtonClickListener());
		notebookBTN.addActionListener(new ButtonClickListener());
		contactsBTN.addActionListener(new ButtonClickListener());

		//*ADD COMPONENTS TO THE FRAME		
		//create a sub-container for the buttons, and one for the header
		JPanel buttonPane = new JPanel(); 
		buttonPane.setLayout(new GridLayout(2,2));
		JPanel headerPane = new JPanel();

		//customize the header background
		headerPane.setBackground(Color.DARK_GRAY);

		//add the components to their panels and the panels to the frame
		buttonPane.add(toDoBTN, 0, 0);
		buttonPane.add(settingsBTN, 0, 1);	
		buttonPane.add(notebookBTN, 1, 0);
		buttonPane.add(contactsBTN, 1, 1);
		headerPane.add(header, BorderLayout.CENTER);
		frame.getContentPane().add(buttonPane, BorderLayout.SOUTH);
		frame.getContentPane().add(headerPane,  BorderLayout.NORTH);

		//*SIZE THE FRAME
		//frame.pack();		//shrink/grows to fit
		frame.setSize(550, 300);

		//*SHOW THE FRAME
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		//Schedule a job for the event-dispatching thread
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}//end main
}
