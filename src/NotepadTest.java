import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotepadTest {
    Notepad n;
    @Before
    public void instantiate(){
         n = new Notepad();
        n.newNote("I like money");
        n.newNote("Cheese");

    }

    @Test
    public void newNote() {
        assertEquals(2, n.n.size());
        n.newNote("Hurgles");
        assertEquals(3, n.n.size());
    }

    @Test
    public void editNote() {
        String d = n.n.get(0).getDate();
        n.editNote(0, "bruh");
        if(!d.equals(n.n.get(0).getDate())){
            System.out.println("Failed");
        }
        n.newNote("Banana");
        n.editNote(1,"bro");
        assertEquals("bro", n.n.get(0).getText());

    }

    @Test
    public void deleteNote() {
        assertEquals(2, n.n.size());
        n.deleteNote(0);
        assertEquals(1, n.n.size());
    }
}