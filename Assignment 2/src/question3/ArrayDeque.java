/*****************************************************************************/
//  ArrayDeque.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 2 Question 3
//  The CircularArrayQueue was modified and built upon to implement a deque
//	data structure whereby given a queue, you can insert or remove at either
//	end of the queue
/*****************************************************************************/

package question3;

import jsjf.exceptions.EmptyCollectionException;

@SuppressWarnings("unchecked")

/**
 * CircularArrayQueue represents an array implementation of a queue in 
 * which the indexes for the front and rear of the queue circle back to 0
 * when they reach the end of the array.
 * 
 * @author Java Foundations
 * @version 4.0
 */
public class ArrayDeque<T>
{
	private final static int DEFAULT_CAPACITY = 100;
	private int front, rear, count;
	private T[] queue; 

	/**
	 * Creates an empty queue using the specified capacity.
	 * @param initialCapacity the initial size of the circular array queue
	 */
	public ArrayDeque(int initialCapacity)
	{
		front = rear = count = 0;
		queue = (T[]) (new Object[initialCapacity]);
	}

	/**
	 * Creates an empty queue using the default capacity.
	 */
	public ArrayDeque()
	{
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Adds the specified element to the rear of this queue, expanding
	 * the capacity of the queue array if necessary.
	 * @param element the element to add to the rear of the queue
	 */
	public void insertRear(T element)
	{
		if (size() == queue.length) 
			expandCapacity();

		//accounting for initial insert
		if (rear == 0 && front == 0 && count == 0)
		{
			queue[0] = element;
			rear = 1;
			front = queue.length-1;
			count++;
			return;
		}

		queue[rear] = element;
		rear = (rear + 1) % queue.length;
		count++;
	}

	/**
	 * Adds the specified element to the front of this queue, expanding
	 * the capacity of the queue array if necessary.
	 * @param element the element to add to the front of this queue
	 */
	public void insertFront(T element)
	{
		if (size() == queue.length)
			expandCapacity();

		//accounting for intial insert
		if (front == 0 && rear == 0 && count == 0)
		{
			queue[0] = element;
			front = queue.length-1;
			rear = 1;
			count++;
			return;
		}
		
		//wrap around
		if (front == 0 && count != 0)
		{
			queue[front] = element;
			front = queue.length-1;
			count++;
			return;
		}

		queue[front] = element;
		front--;
		count++;
	}

	/**
	 * Creates a new array to store the contents of this queue with
	 * twice the capacity of the old one.
	 */
	private void expandCapacity()
	{
		T[] larger = (T[]) (new Object[queue.length * 2]);

		for (int scan = 0; scan < count; scan++)
		{
			//if front is at end of queue
			if (front == queue.length-1)
				front = -1;
			larger[scan] = queue[front+1];
			front++;
		}

		//assign front and rear to index 0 and previous size respectively
		front = queue.length*2-1;;
		rear = count;
		queue = larger;
	}

	/**
	 * Removes the element at the front of this queue and returns a
	 * reference to it. 
	 * @return the element removed from the front of the queue
	 * @throws EmptyCollectionException  if the queue is empty
	 */
	public T deleteFront() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("queue");

		//if actual front is at index 0
		if (front == queue.length-1 && count != 0)
		{
			T result = queue[0];
			queue[0] = null;
			front = 0;
			count--;
			return result;
		}
		
		T result = queue[front+1];
		queue[front+1] = null;			
		front = (front + 1) % queue.length;
		
		count--;
		return result;
	}

	/**
	 * Removes the element at the front of this queue and returns a
	 * reference to it.
	 * @return the element from the front of this queue
	 * @throws EmptyCollectionException if the queue is empty
	 */
	public T deleteRear() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("queue");

		//actual rear is at end of queue array
		if (rear == 0 && count != 0)
		{
			T result = queue[queue.length-1];
			queue[queue.length-1] = null;
			rear = queue.length-1;
			count--;
			return result;
		}
		
		T result = queue[rear-1];
		queue[rear-1] = null;
		rear--;
		count--;
		return result;
	}

	/** 
	 * Returns a reference to the element at the front of this queue.
	 * The element is not removed from the queue.  
	 * @return the first element in the queue
	 * @throws EmptyCollectionException if the queue is empty
	 */
	public T first() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("queue");

		if (front == queue.length-1 && count != 0)
			return queue[0];

		return queue[front+1];
	}

	/**
	 * Returns true if this queue is empty and false otherwise.
	 * @return true if this queue is empty 
	 */
	public boolean isEmpty()
	{
		return (count == 0);
	}

	/**
	 * Returns the number of elements currently in this queue.
	 * @return the size of the queue
	 */
	public int size()
	{
		return count;
	}

	/**
	 * Returns a string representation of this queue. 
	 * @return the string representation of the queue
	 */
	public String toString()
	{
		String result = "";
		int temp = front;
		for (int scan = 0; scan < count; scan++)
		{
			if (temp == queue.length-1)
				temp = -1;
			result += queue[temp+1] + " ";
			temp++;
		}

		return result;
	}
}
