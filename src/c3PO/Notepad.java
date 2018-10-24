package c3PO;

import java.util.ArrayList;
import java.util.Date;

public class Notepad {

	//Arraylist of notes takes two elements-- 
	//Date: Cannot be changed, developed upon posting.
	//Text: the note itself.
	//Notes can be sorted in order of date, but can maybe be moved around?
	
	public static class Note{
		Date d;
		String text = null;
		public Note(Date da, String t) {
			text = t;
			d = da;
		}
		public void setText(String t) {
			text = t;
		}
		public void setDate(Date da) {
			d = da;
		}
		public String getText() {
			return text;
		}
		public Date getDate() {
			return d;
		}
	}
	
	ArrayList<Note> n = new ArrayList<>();
	public void newNote(Date da, String t) {
		Note note = new Note(da.getDate(), t);
	}
	
	public void editNote() {
		
	}
	
	public void deleteNote() {
		
	}
	
}
