package assignment2;

import java.util.*;

/*
 * Author @Caitlyn Clifton
 * Dr David Kuijt
 * CMSC 204
 */

public class MyQueue <T> implements QueueInterface <T>
{
	private int max; //max size of the queue
	private int size; //size of the queue
	Queue <T> queue = new LinkedList <T>();; //queue
	
	MyQueue() //default constructor - uses a default as the size of the queue
	{
		this.max = 20;
		this.size = 0;
	}
	MyQueue(int size) //takes an int as the size of the queue
	{
		this.max = size;
		this.size = 0;
	}
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}

	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	public boolean isFull()
	{
		if(size == max)
			return true;
		else
			return false;
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	public T dequeue() throws QueueUnderflowException
	{
		if (isEmpty())
		{
			throw new QueueUnderflowException();
		}
		else
		{
			size --;
			return queue.poll();
		}
	}

	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size()
	{
		return size;
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	public boolean enqueue(T e) throws QueueOverflowException
	{
		if(isFull())
		{
			throw new QueueOverflowException();
		}
		else
		{
			queue.add(e);
			size++;
			return true;
		}
	}
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString()
	{
		String str = "";
		for (int i = 0; i < queue.size(); i++)
		{
			if(((LinkedList<T>) queue).get(i) != null)
			{
				str += ((LinkedList<T>) queue).get(i);
			}
		}
		return str;
	}
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter)
	{
		String str = "";
		for (int i = 0; i < queue.size(); i++)
		{
			if(((LinkedList<T>) queue).get(i) != null)
				str += ((LinkedList<T>) queue).get(i) + delimiter;
		}
		return str.substring(0,str.length()-1);
	}
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
	public void fill(ArrayList<T> list) throws QueueOverflowException
	{
		ArrayList <T> listCopy = new ArrayList <T>();
		listCopy.addAll(list);
		for(int i = 0; i < listCopy.size(); i++)
		{
			if (isFull())
				throw new QueueOverflowException();
			else
			{
				queue.add(listCopy.get(i));
				size++;
			}
		}
	}
}
