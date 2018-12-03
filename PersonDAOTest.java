import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonDAOTest {
 PersonDAO pd;
    PersonInfo p;
    @Before
    public void instantiate(){
        p = new PersonInfo(1111, "Harry", "675 Bruh", 4444444, "yo@mail");
        pd = new PersonDAO();

    }

    @Test
    public void searchPerson() {
        assertEquals(1, pd.searchPerson("Joel").size());
    }

    @Test
    public void savePerson() {
        pd.savePerson(p);
        assertEquals(1, pd.searchPerson("Harry").size());
    }

    @Test
    public void updatePerson() {
        assertEquals(0, pd.searchPerson("Jacob").size());
        PersonInfo p1 = new PersonInfo(1234, "Jacob", "6999 Yo", 8888888, "gee@mail");
        pd.updatePerson(p1);
        assertEquals(1, pd.searchPerson("Jacob").size());
    }

    @Test
    public void removePerson() {
        pd.removePerson("Joel");
        assertEquals(0, pd.searchPerson("Joel").size());
    }
}