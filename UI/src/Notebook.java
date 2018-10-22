import javax.swing.*;


public class Notebook {
	
	public Notebook()
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
		JFrame frame = new JFrame("C3PO : Notebook");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//Set the frame icon to an image loaded from a file
		frame.setIconImage(new ImageIcon("/home/campus20/aslabbek/Desktop/TeamSoftware/robot.png").getImage());
		
		
		//*SIZE THE FRAME
		//frame.pack();		//shrink/grows to fit
		frame.setSize(550, 300);
		
		
		//*SHOW THE FRAME
		frame.setVisible(true);
	}

}
