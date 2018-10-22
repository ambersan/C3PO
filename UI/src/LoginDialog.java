import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginDialog extends JDialog {
   
	JLabel userName = new JLabel("Name: ");
	JLabel password = new JLabel("Password: ");
	
	JTextField name = new JTextField();
	JPasswordField pass = new JPasswordField();
	
	JButton okBTN = new JButton("Ok");
	JButton cancelBTN = new JButton("Cancel");
	JButton newAccount = new JButton("New Account");
    
    public LoginDialog()
    {
    	setUp();
    	setUpListeners();
    }
    
    public void setUp()
    {
    	this.setTitle("Login");
    	JPanel fields = new JPanel( new GridBagLayout() );
    	JPanel buttons = new JPanel ( new FlowLayout (FlowLayout.RIGHT) );
    	
    	buttons.add(okBTN);
    	buttons.add(cancelBTN);
    	buttons.add(newAccount);
    	
    	//layout the labels and fields for the username and password
    	
    }
    
    private void setUpListeners()
    {
    	
    }
    
    public static boolean authenticate(String username, String password) {
        // hard-coded username and password
        //if (username.equals("bob") && password.equals("secret")) {
            return true;
        //}
        //return false;
    }
	
}
