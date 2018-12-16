import java.util.ArrayList;

//Is this even used

public class ContactList {
//Arraylist with elements that can be ordered in any manner.
//element has: name, number, cell, address, email
//Only thing required to make a new contact entry is a name.
	
	public static class Contact{
		String name = "";
		String num = "";
		String cellNum = "";
		String address = "";
		String email = "";
		public Contact(String n, String nu, String cellNu, String add, String e){
			if(!n.equals(null)) {
				name = n;
				num = nu;
				cellNum = cellNu;
				address = add;
				email = e;
			}
		}
		
		public void setEmail(String e) {
			email = e;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setName(String n) {
			name = n;
		}
		public void setNum(String n) {
			num = n;
		}
		public void setCellNum(String n) {
			cellNum = n;
		}
		public void setAdd(String a) {
			address = a;
		}
		public String getName() {
			return name;
		}
		public String getNum() {
			return num;
		}
		public String getCellNum() {
			return cellNum;
		}
		public String getAdd() {
			return address;
		}
	}
	
	public ArrayList<Contact> c = new ArrayList<>();

	public Contact getContact(int i){
		return c.get(i);
	}
	
	public void add(String name, String num, String cellNum, String add,  String email) {
			Contact con = new Contact(name, num, cellNum, add, email);
			int place = 0;
			for (int i = 0; i < c.size(); i++) {
				if(c.get(i).name.compareTo(name) < 0) {
					place = i;
				}
			}
			if(!c.isEmpty()){
				if(c.get(c.size()-1).name.compareTo(name)<0){
					place = c.size();
				}
			}
			c.add(place, con);
	}
	
	public void delete(int i) {
		c.remove(i);
	}
	
	public void edit(String name, String num, String cellNum, String add, String email, int i) {

		if(name.equals(c.get(i).name)){
			Contact con = c.get(i);
			con.setNum(num);
			con.setCellNum(cellNum);
			con.setAdd(add);
			con.setEmail(email);
		}else{
			delete(i);
			add(name, num, cellNum, add, email);
		}


	}
}
