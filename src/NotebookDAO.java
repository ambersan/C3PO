import java.sql.*;
import java.util.ArrayList;


public class NotebookDAO 
{
	private Connection conn;

	// constructor 
	public NotebookDAO()
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
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Adam\\Downloads\\C3PO.sqlite");
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


	public ResultSet getNoteTitles(){
		ResultSet rs = null;
		try{
			Statement st = conn.createStatement();
			rs = st.executeQuery("select Name from NoteBook");
		}catch (SQLException e){
			System.out.println(e);
		}

		return rs;
	}

	public ResultSet getNoteContent(String s){
		ResultSet rs = null;
		try{
			Statement st = conn.createStatement();
			rs = st.executeQuery("select Content from NoteBook where Name = '" + s + "'");
		}catch(SQLException e){
			System.out.println(e);
		}
		return rs;
	}


}
