package assignment3;

import java.util.*;

public class BasicDoubleLinkedList <T> extends java.lang.Object implements java.lang.Iterable<T>
{
	protected LinkedList <T> list;
	protected Node head; //first value of the linked list
	protected Node tail; //last value of the linked list
	protected int size; //size of the linked list
	
	BasicDoubleLinkedList()	//Constructor to set to initialize head, tail and size to null, null and 0
	{
		list = new LinkedList<T>();
		head = null;
		tail = null;
		size = 0;
	}
	public int getSize()
	{
		return size;
	}
	public void addToEnd(T data) //Adds an element to the end of the list and updated the size of the list
	{
		Node n = new Node(data);
		if (size < 1)
		{
			head = n;
			tail = n;
		}
		else
		{
			n.prev = tail;
			tail.next = n;
			tail = n;
			list.addLast(data);
		}
		size++;
	}
	public void addToFront(T data) //Adds element to the front of the list and updated the size of the list
	{
		Node n = new Node(data);
		if (size < 1)
		{
			head = n;
			tail = n;
		}
		else
		{
			n.next = head;
			head.prev = n;
			head = n;
			list.addFirst(data);
		}
		size++;
	}
	public T getFirst() //Returns but does not remove the first element from the list.
	{
		System.out.println(list.toString());
		return list.getFirst();
	}
	public T getLast()
	{
		return list.getLast();
	}
	public ListIterator<T> iterator()
	{
		return new DoubleLinkedListIterator();
	}
	public Node remove(T targetData, Comparator<T> comparator)
	{
		Node data = null;
		//Removes the first instance of the targetData from the list. 
		//You must use the provided comparator (do not use equals) to find those elements that match the target. 
		//returns a node containing the targetData or null
		return data;
	}
	public T retrieveFirstElement()
	{
		if(size < 1)
			return null;
		else
		{
			size --;
			return head.data;
		}
	}
	public T retrieveLastElement()
	{
		if(size < 1)
			return null;
		else
		{
			size--;
			//assign tail
			return list.pollLast();
		}
		
	}
	public ArrayList<T> toArrayList()
	{
		//Returns an arraylist of all the items in the Double Linked list
		ArrayList<T> copy = new ArrayList<T>();
		for(int i = 0; i < size; i++)
		{
			if(list.get(i) != null)
				copy.add(list.get(i));
		}
		return copy;
	}
	public class DoubleLinkedListIterator extends java.lang.Object implements ListIterator<T>
	{
		protected Node prev;
		protected Node next;
		public DoubleLinkedListIterator()
		{
			//Constructor to initialize the current pointer to the head of the BasicDoubleLinkedList.
			this.prev = null;
			this.next = head;
		}
		public boolean hasNext()
		{
			return next != null;
		}
		public T next() throws java.util.NoSuchElementException
		{
			throw new java.util.NoSuchElementException();
		}
		public boolean hasPrevious()
		{
			return prev != null;
		}
		public T previous() throws java.util.NoSuchElementException
		{
			throw new java.util.NoSuchElementException();
		}
		public void remove() throws java.lang.UnsupportedOperationException
		{
			throw new java.lang.UnsupportedOperationException();
		}
		public void add(T arg0) throws java.lang.UnsupportedOperationException
		{
			throw new java.lang.UnsupportedOperationException();
		}
		public int nextIndex() throws java.lang.UnsupportedOperationException
		{
			throw new java.lang.UnsupportedOperationException();
		}
		public int previousIndex() throws java.lang.UnsupportedOperationException
		{
			throw new java.lang.UnsupportedOperationException();
		}
		public void set(T arg0) throws java.lang.UnsupportedOperationException
		{
			throw new java.lang.UnsupportedOperationException();
		}
	}
	public class Node extends java.lang.Object
	{
		protected T data;
		protected Node prev;
		protected Node next;
		
//		Node()
//		{
//			data = null;
//			prev = null;
//			next = null;
//		}
		public Node(T dataNode)
		{
			this.data = dataNode;
		}
	}
}
