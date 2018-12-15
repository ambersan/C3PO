import java.util.*;
import java.sql.*;

public class TaskDAO 
{
	private Connection conn;

	// constructor 
	public TaskDAO()
	{
		getConnection();		//Create Connection to the Oracle Database
	}

	public Connection getConnection()
	{

		try {
			Class.forName("org.sqlite.JDBC");	

		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			conn = DriverManager.getConnection("jdbc:sqlite:H:\\CS 3141\\git\\C3PO\\C3PO.sqlite");
		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}


		return conn;
	}

	public int runQuery(String s){

		int i = 0;
		try{
			PreparedStatement st = conn.prepareStatement(s);
			i = st.executeUpdate();

		} catch(Exception e) {
			System.out.println(e);
		}
		return i;
	}

	public ResultSet getTasks(){
		ResultSet rs = null;
		try{
			Statement st = conn.createStatement();
			rs = st.executeQuery("select * from to_do limit 100");
		}catch (SQLException e){
			System.out.println(e);
		}

		return rs;
	}
}
