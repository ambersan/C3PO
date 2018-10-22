package c3PO;
import java.util.ArrayList;
public class Tasklist {

//ArrayList holds strings.
//Method of deleting elements depends on whether or not queue is marked true or false.
	
	public static class Task{
		String s;
		int i;
		public void setString(String x) {
			s = x;
		}
		public String getString() {
			return s;
		}
		public void setInt(int n) {
			i = n;
		}
		public int getInt() {
			return i;
		}
		public Task(String x, int n) {
			s = x;
			i = n;
		}
		
	}
	
	
	
	public boolean queue = false;
	public ArrayList<Task> a = new ArrayList<>();
	
	
	
	public void add(String s) {
		if (!s.isEmpty()) {
				Task t = new Task(s,a.size()+1 );
				a.add(t);
		}
	}
	
	public void delete(int i) {
		if (i >= 0) {
			if(queue) {
				a.remove(0);
			}else {
				a.remove(i);
			}
		}
	}
	
	public void toggleQueue() {
		if (queue = true) {
			queue = false;
		}else {
			queue = true;
		}
	}
	
	
}
