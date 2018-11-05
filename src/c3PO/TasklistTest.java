package c3PO;

import static org.junit.Assert.*;
import org.junit.Test;

public class TasklistTest 
{
	Tasklist t;

	@Test
	public void testAdd() 
	{
		t = new Tasklist();
		t.add("Pick up milk");
		t.add("Complete tests");
		System.out.println(t.a.get(1).getString());
	}
	
	@Test
	public void testDelete() 
	{
		t = new Tasklist();
		t.add("Hello");;
		t.delete(0);
	}
	
	@Test
	public void testToggleQueue() 
	{
		fail("Not yet implemented");
	}

}
