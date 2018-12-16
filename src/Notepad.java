import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//Tested and works

public class Notepad {

	//ArrayList of notes takes two elements--
	//Date: Cannot be changed by the user, developed upon posting.
	//Text: the note itself.
	//Notes sorted from most recent to least recent
	
	public static class Note{
		String d;
		String text = null;
		public Note(String t) {
			text = t;

		}
		public void setText(String t) {
			text = t;
		}
		public void setDate(String da) {
			d = da;
		}
		public String getText() {
			return text;
		}
		public String getDate() {
			return d;
		}
	}
	
	ArrayList<Note> n = new ArrayList<>();


	public String dateString(){
		Date date = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("mm-dd-yyyy");
		return df.format(date);
	}


	public void newNote( String t) {
	Note no = new Note(t);
	no.setDate(dateString());
	n.add(0,no);
	}
	
	public void editNote(int i, String s) {
		Note toEdit = n.get(i);
		toEdit.setText(s);
		toEdit.setDate(dateString());
		n.remove(i);
		n.add(0,toEdit);
	}
	
	public void deleteNote(int i) {
		n.remove(i);
	}
	
}
