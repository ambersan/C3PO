import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginDialog extends JDialog
{
	JLabel userName = new JLabel("Name: ");
	JLabel password = new JLabel("Password: ");

	JTextField name = new JTextField();
	JPasswordField pass = new JPasswordField();

	JButton okBTN = new JButton("Ok");
	JButton cancelBTN = new JButton("Cancel");
	//JButton newAccount = new JButton("New Account");

	public LoginDialog()
	{
		setUp();
		setUpListeners();
	}

	public void setUp()
	{

		this.setSize(400, 150);
		this.setAlwaysOnTop(true);
		this.setVisible(true);
		this.setTitle("Login");
		JPanel fields = new JPanel( new GridBagLayout() );
		JPanel buttons = new JPanel ( new FlowLayout (FlowLayout.RIGHT) );

		buttons.add(okBTN);
		buttons.add(cancelBTN);
		//buttons.add(newAccount);

		//layout the labels and fields for the username and password
		GridBagConstraints settings = new GridBagConstraints();
		settings.insets = new Insets(4, 4, 4, 4);

		//format the label for the username
		settings.gridx = 0;
		settings.gridy = 0;
		settings.weightx = 0;
		fields.add(userName, settings);

		//format the field for the username
		settings.gridx = 1;
		settings.gridy = 0;
		settings.weightx = 1;
		settings.fill = GridBagConstraints.HORIZONTAL;
		fields.add(name, settings);

		//format the label for the password
		settings.gridx = 0;
		settings.gridy = 1;
		settings.weightx = 0;
		settings.fill = GridBagConstraints.NONE;
		fields.add(password, settings);

		//format the field for the password
		settings.gridx = 1;
		settings.gridy = 1; 
		settings.weightx = 1;
		settings.fill = GridBagConstraints.HORIZONTAL;
		fields.add(pass, settings);

		//add field panel to frame
		this.add(fields);

		//add the button panel to frame
		this.add(buttons, BorderLayout.SOUTH);
	}//end setUp

	private void setUpListeners()
	{
		pass.addKeyListener(new KeyAdapter()
		{
			@Override 
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					String user = name.getText();
					@SuppressWarnings("deprecation")
					String password = pass.getText();

					//pass on the strings here
					LoginDialog.this.setVisible(false);

				}//end comparison
			}//end keyPressed
		}//end KeyAdapter
				);//end add

		okBTN.addActionListener( new ActionListener()
		{
			@Override 
			public void actionPerformed( ActionEvent e)
			{
				String user = name.getText();
				@SuppressWarnings("deprecation")
				String password = pass.getText();


				//pass on the strings here
				LoginDialog.this.setVisible(false);
			}
		}//end ActionListener
				);//end add

		cancelBTN.addActionListener( new ActionListener()
		{
			@Override 
			public void actionPerformed( ActionEvent e)
			{
				LoginDialog.this.setVisible(false);
			}
		}//end ActionListener
				);//end add

		/*
    	newAccount.addActionListener( new ActionListener()
			{
				@Override 
				public void actionPerformed( ActionEvent e)
				{
					//new dialog with entry fields
				}
			}//end ActionListener
		);//end add
		 */

	}
}
