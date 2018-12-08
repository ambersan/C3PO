import java.util.*;
import java.sql.*;

public class TaskDAO {
private Connection conn;

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
