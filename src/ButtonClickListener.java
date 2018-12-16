import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ButtonClickListener implements ActionListener
{
	public void actionPerformed(ActionEvent e) 
	{
		//get button command to distinguish the buttons
		String command = e.getActionCommand();  

		if( command.equals( "todo" ))  
		{
			new ToDo();
		} 
		else if( command.equals( "settings" ) )  
		{
			JOptionPane.showMessageDialog(null, "Settings are a stretch goal!");

			//make new dialog to gather the settings information
			//apply the settings to the pages
		} 
		else if( command.equals( "notebook" ) )  
		{
			new Notebook();
		} 
		else if( command.equals( "contacts" ) )  
		{
			new Contacts();
		} 
		else 
		{
			//button does nothing
		}  	
	}
}