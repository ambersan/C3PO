public class PersonInfo
{
	//class to handle information between the database and the UI
	private String name,address,email;
	private int id, phone, cell;

      	// default constructor
      	public PersonInfo()
      	{       
	         name = "";
	         address = "";
	         email = "";
	
	         id = 0;  
	         phone = 0;
	         cell = 0;
      	}

      	//constructor w/ id
		public PersonInfo(int id, String name, String address, int phone, int cell, String email)
		{
	        this.id = id;
			this.name = name;
			this.address = address;
			this.phone = phone;
			this.email = email;
			this.cell = cell;
		}
	 
	    // constructor w/o id
		public PersonInfo(String name, String address, int phone, int cell, String email)
		{
			this.name = name;
			this.address = address;
			this.phone = phone;
			this.email = email;
			this.cell = cell;
		}
	
	    // setters
		public void setId(int i)
		{
			id = i;
		}
	
		public void setName(String n)
		{
			name=n;		
		}
		
		public void setAddress(String a)
		{
			address=a;
		}
		
		public void setPhone(int ph)
		{
			phone=ph;
		}
		public void setCell(int c)
		{
			cell=c;
		}
		
		public void setEmail(String e)
		{
			email=e;
		}
	
	    // getters
		public int getId( )
		{
			return id;
	    }
	
		public String getName()
		{
			return name;
		}
	
		public String getAddress()
		{
			return address;
		}
	
		public int getPhone()
		{
			return phone;
		}
		
		public int getCell()
		{
			return cell;
		}
	
		public String getEmail()
		{
			return email;
		}

}