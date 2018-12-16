
//Tested and works

public class PersonInfo
{
	private String name,address,email;
	private int cell, phone;

      // default constructor
      public PersonInfo()
      {       
         name = "";
         address = "";
         email = "";

         cell = 0;  
         phone = 0;
      }

	public PersonInfo(String name, String address, int phone, int cell, String email)
	{
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.cell = cell;
		this.email = email;
	}
/* 
      // param construcrtor with 4 values 
	public PersonInfo(String name, String address, int phone, String email)
	{
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
*/
      // setters
	public void setCell(int i)
	{
		cell = i;
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
	public void setEmail(String e)
	{
		email=e;
	}

      // getters
	public int getCell( )
	{
		return cell;
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

	public String getEmail()
	{
		return email;
	}

}