import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CalendarPage {
	//array of events per day (can be as long as user wants).
	//events have a date and a string.
	//possibly a time??? maybe.

    //Structure:
    //description, date.
    //add, delete, edit
    //event array, holds all events across calendar.

    public static class Events{
        Date date;
        String description;

        public Events(String desc, Date da){
            date = da;
            description = desc;
        }

        public Date getDate(){
            return date;
        }
        public String getDesc(){
            return description;
        }
        public void setDate(Date d){
            date = d;
        }
        public void setDesc(String d){
            description = d;
        }
    }

    ArrayList<Events> eList = new ArrayList<>();

    public void add(String des, Date dt){
        Events e = new Events(des, dt);
        int place = 0;

    if(eList.size() != 0){
        for(int i = 0; i < eList.size(); i++){
            if(eList.get(i).getDate().compareTo(dt) <= 0){
                place = i;
            }
        }
        eList.add(place, e);
    }else {
        eList.add(e);
    }

    }

    public void delete(int i){
        eList.remove(i);
    }

    public void edit(int i, String g){

    }

}
