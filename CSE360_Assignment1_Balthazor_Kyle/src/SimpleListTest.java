/**
 * @author Kyle Balthazor
 * Class Id: 186
 * Assignment 1: Simple List and introduction to Javadoc and Junit Tests
 */
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleListTest extends SimpleList
{
	

	@Test // Test that when the constructor is called the count is 0.
	public void testSimpleList()
	{
		SimpleList newList = new SimpleList();
		
		assertEquals(0, newList.count());
	}
	
	@Test // Test for the construct that it is not Null when called.
	public void testMyTest()
	{
		SimpleList newList = new SimpleList();
		assertNotNull (newList);
	}
	
	@Test // Test for add function that when it is called, then the count increases by 1.
	public void testAdd() 
	{
		SimpleList newList = new SimpleList();
		
		newList.add(2);
		
		assertEquals(1,newList.count());
	}
	
	@Test // Test for remove function that when it is called, then the count is decreased by 1.
	public void testRemove() 
	{
		SimpleList newList = new SimpleList();
		
		newList.add(2);
		newList.remove(2);
		
		assertEquals(0,newList.count());
		
	}
	
	@Test // Test for count function that when it is called, then the correct count is displayed.
	public void testCount() 
	{
		SimpleList newList = new SimpleList();
		
		newList.add(2);
		newList.add(2);
		newList.add(2);
		newList.add(2);
		newList.add(2);
		newList.add(2);
		
		assertEquals(6, newList.count());
	}
	
	@Test // Test for the to String function that when it is called then there the correct string is displayed.
	public void testToString() 
	{
		SimpleList newList = new SimpleList();
		
		newList.add(2);
		newList.add(2);
		newList.add(2);
		newList.add(2);
		newList.add(2);
		newList.add(2);
		
		assertEquals("2 2 2 2 2 2", newList.toString());
	}
	
	@Test // Test for the serach function, that when it is called the correct input is returned. 
	public void testSearch() 
	{
		SimpleList newList = new SimpleList();
		
		newList.add(5677);
		newList.add(2);
		newList.add(2);
		newList.add(5);
		newList.add(-1);
		newList.add(-156);
		
		assertEquals(-1, newList.search(-5));
	}

}
