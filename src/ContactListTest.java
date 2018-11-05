import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactListTest {

    ContactList c;

    @Before
    public void instantiate(){
      c = new ContactList();
      c.add("Joe", "888", "j street", "jj@gmail.com");
        c.add("Ann", "344", "A street",  "am@gmail.com");

    }

    @Test
    public void add() {
        assertEquals("Ann", c.c.get(0).getName());
        c.add("Yohan", null, null,  null);
        assertEquals("Yohan", c.c.get(2).getName());
        c.add("", "8844", "3434", "666.com");
        assertEquals(4, c.c.size());
        assertEquals("", c.c.get(0).getName());
    }

    @Test
    public void delete() {
        c.delete(0);
        assertEquals("Joe", c.c.get(0).getName());
        assertEquals(1, c.c.size());
    }

    @Test
    public void edit() {
    c.edit("Ruth", "989", "jam st.", "baseball.com", 0);
    assertEquals("Ruth", c.c.get(1).getName());
    c.edit("Eric", "hurgles", "turgles",  "internet", 0);
    assertEquals("Eric", c.c.get(0).getName());
    }
}