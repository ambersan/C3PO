
public class Task {

	//class to handle information between the database and the UI
		private String description;

	      	// default constructor
	      	public Task()
	      	{       
		         description = "";
	      	}

	      	//constructor
			public Task(String description)
			{
		        this.description = description;
			}
		 
		    // setters
			public void setDescription(String desc)
			{
				description = desc;
			}
		
		
		    // getters
			public String getDescription()
			{
				return description;
			}
	
}
