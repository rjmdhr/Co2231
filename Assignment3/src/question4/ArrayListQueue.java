/*****************************************************************************/
//  ArrayListQueue.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 3 Question 4
//  This class utilizes java.util.ArrayList to create a queue. It does not
//  directly use the methods that would otherwise be inherited from the
//  super class for the same purpose (e.g. ArrayList.size())
/*****************************************************************************/

package question4;
import java.util.ArrayList;
import exceptions.*;

public class ArrayListQueue<T>
{
    private ArrayList<T> queue;
    private int count; //current size of this queue

    /**
     * Default constructor
     * Creates an empty queue with zero elements
     */
    public ArrayListQueue()
    {
        queue = new ArrayList<T>();
        count = 0;
    }

    /**
     * Adds the specified element to the rear of this queue
     * Super class will automatically expand array capacity when 
     * the max capacity of the array has been reached.
     * @param element the element to be added to the rear of this queue.
     */
    public void enqueue(T element)
    {
        queue.add(count, element);
        count++;
    }

    /**
     * Removes and returns the element at the front of this queue.
     * Super class automatically shifts elements to the left  and no
     * further processing is needed
     * @return the first element in this queue
     */
    public T dequeue() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("queue");

        T element = queue.remove(0);
        count--;
        return element;
    }

    /**
     * Returns the first element in this queue without removing it.
     * @return the first element in this queue
     */
    public T first() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("queue");

        return queue.get(0);
    }

    /**
     * Returns true if this queue contains zero elements.
     * @return true if this queue is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return (count == 0);
    }

     /**
     * Returns the total number of elements in this queue.
     * @return the number of elements in this queue
     */
    public int size()
    {
        return count;
    }

    /**
     * Returns a string representation of this queue
     * @return the string representation of this queue
     */
    public String toString()
    {
        String result = "";
        
        for (T element : queue)
            result += element.toString() + " ";
        
        return result;
    }
}