import java.sql.*;
public class NotebookDAO {
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
