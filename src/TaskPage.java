import java.util.ArrayList;

public class TaskPage {
   public ArrayList <Tasklist> page = new ArrayList<>();

    public void addToPage(){
       Tasklist t = new Tasklist();
       page.add(t);

    }

    public void deleteList(int i){
        page.remove(i);
    }

}
