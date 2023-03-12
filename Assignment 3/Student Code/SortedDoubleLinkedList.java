package assignment3;

import java.util.*;
//import java.lang.*;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>
{
	Comparator<T> c;
	Node prev, next;
	public SortedDoubleLinkedList(Comparator<T> comparableObject)
	{
		this.c = comparableObject;
	}
	public void add(T data)
	{
		Node n = new Node(data);
		if(size == 0)
		{
			super.addToFront(data);
			head = n;
			tail = n;
			size++;
		}
	}
	@Override
	public void addToEnd(T data) throws java.lang.UnsupportedOperationException
	{
		throw new java.lang.UnsupportedOperationException();
	}
	@Override
	public void addToFront(T data) throws java.lang.UnsupportedOperationException
	{
		throw new java.lang.UnsupportedOperationException();
	}
	@Override
	public ListIterator<T> iterator()
	{
		return super.iterator();
	}
	@Override
	public BasicDoubleLinkedList<T>.Node remove(T data, Comparator<T> comparator)
	{
		return super.remove(data, comparator);
	}
}
 