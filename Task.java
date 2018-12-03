import java.sql.*;
public class Task 
{
	//the text shown on screen and checked value
		private String label;
		private boolean isSelected = false;
	 
		//setter for text value
		public Task()
		{
			this.label = null;
		}
		
		public void setDescription(String label) 
		{
			this.label = label;
		}
		
		//getter for text value 
		public String toString() 
		{
			return label;
		}
		
		//setter for selected value
		public void setSelected(boolean isSelected) 
		{
			this.isSelected = isSelected;
		}
		
		//getter for selected value
		public boolean isSelected() 
		{
			return isSelected;
		}

		public void remove(String desc){
			if(isSelected){
			TaskDAO bluh = new TaskDAO();
			String s = "delete * from to_do where content = '" + desc + "'";
			bluh.runQuery(s);
		}}

		public ResultSet grabTasks(){

			TaskDAO eeee = new TaskDAO();

			return eeee.getTasks();
		}

		public void addTask(String desc){
			TaskDAO b = new TaskDAO();
			String s = "insert into table to_do values ('" + desc + "')";
			b.runQuery(s);
		}
}
