import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonInfoTest {
    PersonInfo p;
    @Before
    public void initialize(){
        p = new PersonInfo("Jeff", "1234 Peach St.", 7777777, 9999999, "babe@gmail.com");
    }

    @Test
    public void setCell() {
        p.setCell(1234);
        assertEquals(1234, p.getCell());
    }

    @Test
    public void setName() {
        p.setName("Nick");
        assertEquals("Nick", p.getName());
    }

    @Test
    public void setAddress() {
        p.setAddress("6969 Rainbow Rd.");
        assertEquals("6969 Rainbow Rd.", p.getAddress());
    }

    @Test
    public void setPhone() {
        p.setPhone(1111111);
        assertEquals(1111111, p.getPhone());
    }

    @Test
    public void setEmail() {
        p.setEmail("fff@gmail.com");
        assertEquals("fff@gmail.com", p.getEmail());
    }

    @Test
    public void getCell() {
        assertEquals(5555, p.getCell());
    }

    @Test
    public void getName() {
        assertEquals("Jeff", p.getName());
    }

    @Test
    public void getAddress() {
        assertEquals("1234 Peach St.", p.getAddress());
    }

    @Test
    public void getPhone() {
        assertEquals(7777777, p.getPhone());
    }

    @Test
    public void getEmail() {
        assertEquals("babe@gmail.com", p.getEmail());
    }
}