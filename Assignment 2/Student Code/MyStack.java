package assignment2;
import java.util.*;

/*
 * Author @Caitlyn Clifton
 * Dr David Kuijt
 * CMSC 204
 */
public class MyStack <T> implements StackInterface <T>
{
	private int max = 0; //max size; only changed in the constructor, checks to see if stack is full
	private int size = 0; //size of the stack
	Stack <T> stack = new Stack <T>();
	
	public MyStack(int size) //takes in an int as the size of the stack
	{
		this.max = size;
		stack.setSize(this.max);
		this.size = 0;
	}
	public MyStack() //default constructor - uses default as the size of the stack
	{
		max = 10;
		stack.setSize(max);
		this.size = 0;
	}
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty()
	{
		if (size == 0)
			return true;
		else
			return false;
	}
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull()
	{
		if (isEmpty())
			return false;
		else
		{
			if(max == size)
				return true;
			else
				return false;
		}
	}
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T pop() throws StackUnderflowException //removes top item of the stack
	{
		if(isEmpty())
		{
			throw new StackUnderflowException();
		}
		else
		{
			this.size--;
			return stack.pop();
		}
	}
	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T top() throws StackUnderflowException //returns top value of the stack
	{
		if(isEmpty())
			throw new StackUnderflowException();
		else
			return stack.peek();
	}
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size()
	{
		return size;
	}
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	public boolean push(T e) throws StackOverflowException
	{
		// add a new item to the top
		if (isFull())
		{
			throw new StackOverflowException();
		}
		else
		{
			stack.push(e);
			this.size++;
			return true;
		}
	}
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString()
	{
		String str = "";
		for (int i = 0; i < stack.size(); i++)
		{
			if(stack.get(i) != null)
				str += stack.get(i);
		}
		return str;
	}
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter)
	{
		String str = "";
		for (int i = 0; i < stack.size(); i++)
		{
			if(stack.get(i) != null)
				str += stack.get(i) + delimiter;
		}
		return str.substring(0,str.length()-1);
	}
	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	public void fill(ArrayList<T> list) throws StackOverflowException
	{
		ArrayList<T> listCopy = new ArrayList<T>();
		listCopy.addAll(list);
		for (int i = 0; i < listCopy.size(); i++)
		{
			if (isFull())
				throw new StackOverflowException(); //throw if it is full
			else
			{
				stack.push(listCopy.get(i));
				size++;
			}
				
		}
	}
}