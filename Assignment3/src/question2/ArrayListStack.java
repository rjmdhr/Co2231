/*****************************************************************************/
//  ArrayListStack.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 3 Question 2
//  This class utilizes java.util.ArrayList to create a stack. It does not
//  directly use the methods that would otherwise be inherited from the
//  super class for the same purpose (e.g. ArrayList.size())
/*****************************************************************************/

package question2;
import java.util.ArrayList;
import exceptions.*;

public class ArrayListStack<T>
{
    private ArrayList<T> stack;
    private int count; //current size

    /**
     * Default constructor
     * Creates an empty stack
     */
    public ArrayListStack()
    {
        stack = new ArrayList<T>();
        count = 0;
    }

    /**
     * Adds the specified element to the top of this stack.
     * Super class will automatically expand array capacity when 
     * the max capacity of the array has been reached.
     * @param element the element to be added
     */
    public void push(T element)
    {
        stack.add(0, element);
        count++;
    }

    /**
     * Removes element from the top of this stack and returns
     * a reference to it.
     * @return the top element on this stack
     * @throws EmptyCollecitonException if the stack is empty
     */
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");
        
        T element = stack.remove(count-1);
        count--;
        return element;
    }

    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from this stack
     * @return
     * @throws EmptyCollectionException
     */
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        return stack.get(count-1);
    }

    /**
     * Returns the total number of elements in this stack.
     * @return number of elements in this stack
     */
    public int size()
    {
        return count;
    }

    /**
     * Checks if this stack is empty.
     * @return true if empty, false otherwise
     */
    public boolean isEmpty()
    {
        return (count == 0);
    }

    /**
     * Returns a string representation of this stack.
     * @return the string representation of this stack
     */
    public String toString()
    {
        String result = "";

        for (T element : stack)
            result += element.toString() + " ";

        return result;
    }
}