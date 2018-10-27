import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TasklistTest1 {

    Tasklist tasky;

    @Before
   public void instantiate(){
        tasky = new Tasklist();
        tasky.add("Laundry"); tasky.add("Go running"); tasky.add("Dishes"); tasky.add("Pick up kids");
    }


    @Test
   public void testAdd() {

        assertEquals(4, tasky.a.size());
        assertEquals("Laundry", tasky.a.get(0).getString());
        assertEquals("Pick up kids", tasky.a.get(3).getString());

    }

    @Test
    public void testDelete() {
        tasky.delete(1);
        assertEquals("Dishes", tasky.a.get(1).getString());
    }

    @Test
    public void testToggleQueue() {
        tasky.toggleQueue();
        assertEquals(true, tasky.queue);
        tasky.delete(3);
        assertEquals("Go running", tasky.a.get(0).getString());
        tasky.toggleQueue();
        assertEquals(false, tasky.queue);
        tasky.add("Shopping");
        tasky.delete(0);
        assertEquals("Shopping", tasky.a.get(2).getString());

    }
}
