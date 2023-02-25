package assignment2;

import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MyStackTest {
	public MyStack<String> stringS;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleS
	public MyStack<Double> doubleS;
	public Double g = 3.0, h = 12.2, i = 7.4, j = 2.1, k = 9.8, l = 5.3;
	// STUDENT: add variables as needed for your student tests
	
	@BeforeEach
	public void setUp() throws Exception 
	{
		stringS = new MyStack<String>(5);
		stringS.push(a);
		stringS.push(b);
		stringS.push(c);
		
		//STUDENT: add setup for doubleS for student tests
		doubleS = new MyStack<Double>(5);
		doubleS.push(g);
		doubleS.push(h);
		doubleS.push(i);
	}

	@AfterEach
	public void tearDown() throws Exception 
	{
		stringS = null;
		doubleS = null;
	}

	@Test
	public void testIsEmpty() throws StackUnderflowException
	{
		assertEquals(false,stringS.isEmpty());
		stringS.pop();
		stringS.pop();
		stringS.pop();
		assertEquals(true, stringS.isEmpty()); //making it fail
	}

	@Test
	public void testIsFull() throws StackOverflowException
	{
		assertEquals(false, stringS.isFull());
		stringS.push(d);
		stringS.push(e);
		assertEquals(true, stringS.isFull()); //making it fail
	}

	@Test
	public void testPop() {
		try {
			assertEquals(c, stringS.pop());
			assertEquals(b, stringS.pop());
			assertEquals(a, stringS.pop());
			//Stack is empty, next statement should cause StackUnderFlowException
			stringS.pop();
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (StackUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}

	@Test
	public void testPopStudent() 
	{
		//Use the doubleS for student tests
		try {
			assertEquals(i, doubleS.pop());
			assertEquals(h, doubleS.pop());
			assertEquals(g, doubleS.pop());
			//Stack is empty, next statement should cause StackUnderFlowException
			doubleS.pop();
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (StackUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}
	
	@Test
	public void testTop() throws StackUnderflowException, StackOverflowException 
	{
		assertEquals(c, stringS.top());
		stringS.push(d);
		assertEquals(d, stringS.top());
		stringS.pop();
		stringS.pop();
		assertEquals(b, stringS.top());		
	}

	@Test
	public void testSize() throws StackUnderflowException, StackOverflowException	
	{
		assertEquals(3, stringS.size());
		stringS.push(d);
		assertEquals(4, stringS.size());
		stringS.pop();
		stringS.pop();
		assertEquals(2, stringS.size());
	}

	@Test
	public void testPush() {
		try {
			assertEquals(3, stringS.size());
			assertEquals(true, stringS.push(d));
			assertEquals(4, stringS.size());
			assertEquals(true, stringS.push(e));
			assertEquals(5, stringS.size());
			//Stack is full, next statement should cause StackOverFlowException
			stringS.push(f);
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}

	@Test
	public void testPushStudent() 
	{
		//Use the doubleQ for student tests
		try {
			assertEquals(3, doubleS.size());
			assertEquals(true, doubleS.push(j));
			assertEquals(4, doubleS.size());
			assertEquals(true, doubleS.push(k));
			assertEquals(5, doubleS.size());
			//Stack is full, next statement should cause StackOverFlowException
			doubleS.push(l);
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}
	
	@Test
	public void testToString() throws StackOverflowException 
	{
		assertEquals("abc", stringS.toString());
		stringS.push(d);
		assertEquals("abcd", stringS.toString());
		stringS.push(e);
		assertEquals("abcde", stringS.toString());
	}

	@Test
	public void testToStringStudent() throws StackOverflowException 
	{
		//Use the doubleQ for student tests
		assertEquals("3.012.27.4", doubleS.toString());
		doubleS.push(j);
		assertEquals("3.012.27.42.1", doubleS.toString());
	}
	
	@Test
	public void testToStringDelimiter() throws StackOverflowException 
	{
		assertEquals("a%b%c", stringS.toString("%"));
		stringS.push(d);
		assertEquals("a&b&c&d", stringS.toString("&"));
		stringS.push(e);
		assertEquals("a/b/c/d/e", stringS.toString("/"));
	}

	@Test
	public void testFill() throws StackUnderflowException, StackOverflowException 
	{
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty Stack
		stringS = new MyStack<String>(5);
		//fill with an ArrayList
		stringS.fill(fill);
		assertEquals(3,stringS.size());
		assertEquals("carrot", stringS.pop());
		assertEquals("banana", stringS.pop());
		assertEquals("apple", stringS.pop());		
	}

}
