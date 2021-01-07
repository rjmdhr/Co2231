/*****************************************************************************/
//  DropOutStack.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 2 Question 2
//  This linked list class was modified to fit the criteria of a drop-out 
// 	stack such that	if the stack size is n, the bottom element is lost when 
// 	the n+1 element is pushed
/*****************************************************************************/

package question2;

import jsjf.exceptions.EmptyCollectionException;
import jsjf.*;

/**
 * Represents a linked implementation of a stack.
 *
 * @author Java Foundations 
 * @version 4.0
 */
public class LinkedDropOutStack<T> implements StackADT<T>
{
	private int count;  
	private LinearNode<T> top;
	private static int n; //the max size of the stack

	/**
	 * Creates an empty stack with default size 10.
	 */
	public LinkedDropOutStack()
	{
		count = 0;
		top = null;
		n = 10;
	}

	/**
	 * Creates stack of specified size
	 * @param size the specified size of the stack
	 */
	public LinkedDropOutStack(int size)
	{
		//set the default size to 10 if not bigger than 1
		if (size > 1)
			n = size;
		else
			n = 10;

		//initialize class fields
		count = 0;
		top = null;
	}

	/**
	 * Adds the specified element to the top of this stack.
	 * If the stack is full, then the bottom element is lost.
	 * @param element element to be pushed on stack
	 */
	public void push(T element)
	{
		LinearNode<T> newNode = new LinearNode<T>(element);

		//count must equal the max capacity, so delete bottom element
		if (count == n)
		{
			LinearNode<T> temp = new LinearNode<T>(element);
			temp = top;

			while (temp.getNext().getNext() != null)
				temp = temp.getNext();
		
			temp.setNext(null);
			count--; //account for net zero count if max capacity is reached
		}

		//count is less than max capacity
		newNode.setNext(top);
		top = newNode;
		count++;
	}

	/**
	 * Removes the element at the top of this stack and returns a
	 * reference to it.
	 * @return element from top of stack
	 * @throws EmptyCollectionException if the stack is empty
	 */
	public T pop() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException("stack");

		T result = top.getElement();
		top = top.getNext();
		count--;

		return result;
	}

	/**
	 * Returns a reference to the element at the top of this stack.
	 * The element is not removed from the stack.  
	 * @return element on top of stack
	 * @throws EmptyCollectionException if the stack is empty  
	 */
	public T peek() throws EmptyCollectionException
	{
		if (isEmpty())
		{
			throw new EmptyCollectionException("stack");
		}
		
		return top.getElement();
	}

	/**
	 * Returns true if this stack is empty and false otherwise. 
	 * @return true if stack is empty
	 */
	public boolean isEmpty()
	{
		return (size() == 0); 
	}

	/**
	 * Returns the number of elements in this stack.
	 * @return number of elements in the stack
	 */
	public int size()
	{
		return count;
	}

	/**
	 * Returns a string representation of this stack. 
	 * @return string representation of the stack
	 */
	public String toString()
	{
		LinearNode<T> current = top;
		String result = "";

		while (current != null)
		{
			result += current.getElement() + " ";
			current = current.getNext();
		}

		return result;
	}
}