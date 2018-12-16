import java.sql.ResultSet;

public class Task 
{
	//the text shown on screen and checked value
	private String label;
	private boolean isSelected = false;

	//setter for text value
	public Task()
	{
		this.label = null;
		this.isSelected = false;
	}
	
	public Task(String l)
	{
		this.label = l;
		this.isSelected = false;
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
		if(isSelected)
		{
			TaskDAO des = new TaskDAO();
			String s = "delete * from To_Do where Content = '" + desc + "'";
			des.runQuery(s);
		}
	}

	public ResultSet grabTasks(){

		TaskDAO result = new TaskDAO();

		return result.getTasks();
	}

	public void addTask(String desc){
		TaskDAO b = new TaskDAO();
		String s = "insert into table To_Do values ('" + desc + "')";
		b.runQuery(s);
	}
}
