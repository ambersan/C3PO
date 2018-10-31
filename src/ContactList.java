import java.util.ArrayList;

public class ContactList {
//Arraylist with elements that can be ordered in any manner.
//element has: name, number, description, address
//Only thing required to make a new contact entry is a name.
	
	public static class Contact{
		String name = "";
		String num = "";
		String address = "";
		String email = "";
		String desc = "";
		public Contact(String n, String nu, String add, String d, String e){
			if(!n.equals(null)) {
				name = n;
				num = nu;
				address = add;
				desc = d;	
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
		public void setAdd(String a) {
			address = a;
		}
		public void setDesc(String d) {
			desc = d;
		}
		public String getName() {
			return name;
		}
		public String getNum() {
			return num;
		}
		public String getAdd() {
			return address;
		}
		public String getDesc() {
			return desc;
		}	
	}
	
	public ArrayList<Contact> c = new ArrayList<>();

	public Contact getContact(int i){
		return c.get(i);
	}
	
	public void add(String name, String num, String add, String desc, String email) {
			Contact con = new Contact(name, num, add, desc, email);
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
	
	public void edit(String name, String num, String add, String desc, String email, int i) {

		if(name.equals(c.get(i).name)){
			Contact con = c.get(i);
			con.setNum(num);
			con.setAdd(add);
			con.setDesc(desc);
			con.setEmail(email);
		}else{
			delete(i);
			add(name, num, add, desc,email);
		}


	}
	
	
}
