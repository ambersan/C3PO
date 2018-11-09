import java.sql.*;
import java.util.*;

public class dbConnection {

	/* Person Table needs to be created in the Oracle Database.
	 * create table Person (
	 id Integer,
	 name Varchar(30),
	 address Varchar(30),
	 phone Integer,
	 email Varchar(50)
	 );*/

    private ArrayList personsList;
    private String userid = "scott";
    private String password = "tiger";
    static String url = "jdbc:odbc:bob";
    private Connection con;
    // constructor
    public void PersonDAO() {
        personsList = new ArrayList();
        getConnection(); //Create Connection to the Oracle Database
    }
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.Jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://C3PO/SQL/C3PO", userid, password);
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return con;
    }
    public ArrayList searchPerson(String name) {
        try {
            String sql = "SELECT * FROM Contacts WHERE Name like '%" + name
                    + "%'";
            // Create a prepared statement
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            String pname = "";
            String address = "";
            String email = "";
            int id, phone;
            while (rs.next()) {
                id = rs.getInt("id");
                pname = rs.getString("name");
                address = rs.getString("address");
                phone = rs.getInt("phone");
                email = rs.getString("email");
                //Create a PersonInfo object
                PersonInfo person = new PersonInfo(id, pname, address,
                        phone, email);
                //Add the person object to array list
                personsList.add(person);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return personsList;
    }
    public void savePerson(PersonInfo person) {
        try {
            String sql = "INSERT INTO Contacts(Name, Home_Phone, "
                    + "Email, Cellphone, Address) VALUES (?,?,?,?) ";
            // Create a Preparedstatement
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setString(2, person.getAddress());
            ps.setInt(3, person.getPhone());
            ps.setString(4, person.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updatePerson(PersonInfo person) {
        try {
            String sql = "UPDATE Contacts SET Name = ?, Address=? , "
                    + "Phone=? , Email=? where id=?";
            // Create a Prepared statement
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, person.getName());
            ps.setString(2, person.getAddress());
            ps.setInt(3, person.getPhone());
            ps.setString(4, person.getEmail());
            ps.setInt(5, person.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public int removePerson(String name) {
        int no = 0;
        try {
            String sql = "DELETE FROM Contacts WHERE Name = ?";
            // Create a Prepared statement
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            no = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return no;
    }
}