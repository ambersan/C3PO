import java.sql.*;
import java.util.*;

public class PersonDAO
{
	private ArrayList personsList;
	private Connection con;

	// constructor 
	public PersonDAO()
	{
		personsList = new ArrayList();
		getConnection();		//Create Connection to the Oracle Database
	}

	public Connection getConnection()
	{

		try 
		{
			Class.forName("org.sqlite.JDBC");	

		} 
		catch(java.lang.ClassNotFoundException e) 
		{
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		try 
		{
			//Laptop: C:\\Users\\Adam Bersano\\Downloads\\C3PO.sqlite
			//Main PC: C:\\Users\\Adam\\Downloads\\C3PO.sqlite
			con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Adam Bersano\\Downloads\\C3PO2.sqlite");
		} 
		catch(SQLException ex) 
		{
			System.err.println("SQLException: " + ex.getMessage());
		}
		return con;
	}

	public ArrayList searchPerson(String name)
	{
		try	
		{
			String sql = "SELECT * FROM Contacts WHERE Name like '%"+name+"%'";

			// Create a prepared statement
			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery(sql);

			String pname = "";
			String address = "";
			String email = "";
			int cell, phone;

			while(rs.next())
			{
				pname = rs.getString("name");
				address = rs.getString("address");
				phone = rs.getInt("phone");
				cell = rs.getInt("cell");
				email = rs.getString("email");

				//Create a PersonInfo object
				PersonInfo person = new PersonInfo(pname, address, phone, cell, email);

				//Add the person object to array list
				personsList.add(person);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return personsList;
	} 

	public void savePerson(PersonInfo person)
	{
		try
		{
			String sql = "INSERT INTO Contacts(Name, Address, " +
					"Phone, Cell, Email) VALUES (?,?,?,?,?) ";

			// Create a Preparedstatement
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, person.getName());
			ps.setString(2, person.getAddress());
			ps.setInt(3, person.getPhone());
			ps.setInt(4, person.getCell());
			ps.setString(5, person.getEmail());

			ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void updatePerson(PersonInfo person)
	{
		try
		{
			String sql = "UPDATE Contacts SET Name = ?, Address=? , " +
					"Phone=? , Cell=? where Email=?";

			// Create a Prepared statement
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1 , person.getName());		
			ps.setString(2 , person.getAddress());
			ps.setInt(3 , person.getPhone());
			ps.setInt(4 , person.getCell());
			ps.setString(5 , person.getEmail());

			ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public int removePerson(String name)
	{
		int no = 0;
		try
		{
			String sql = "DELETE FROM Contacts WHERE Name = ?";
			// Create a Prepared statement
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			no = ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return no;
	}
}// end class PersonDAO