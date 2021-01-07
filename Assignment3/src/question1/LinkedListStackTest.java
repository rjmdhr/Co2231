/*****************************************************************************/
//  LinkedListStackTest.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 3 Question 1
//  This class tests the class that uses java.util.LinkedList by checking
//  various cases which would produce errors
/*****************************************************************************/

package question1;
import exceptions.*;

public class LinkedListStackTest 
{
    public static void main(String[] args) 
    {
        //create a new linked stack
        LinkedListStack<Integer> testStack = new LinkedListStack<Integer>();

        //test methods on empty stack
        System.out.println("\n*EMPTY LINKEDLIST STACK TEST*");
        System.out.println("isEmpty(): " + testStack.isEmpty());
        System.out.println("size(): " + testStack.size());

        System.out.print("pop(): ");
        try
        {testStack.pop();} 
        catch (EmptyCollectionException ex)
        {System.out.print("Exception - " + ex.getMessage() + "\n");}

        System.out.print("peek(): ");
        try
        {testStack.peek();} 
        catch (EmptyCollectionException ex)
        {System.out.println("Exception - " + ex.getMessage());}

        System.out.println("The Stack: " + testStack.toString() + "\n");

        //test methods by adding elements
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        testStack.push(9);
        testStack.push(-3);
        testStack.push(5);
        System.out.println("*MULTIPLE ELEMENT LINKEDLIST STACK TEST*");
        System.out.println("-left is top, right is bottom-");
        System.out.println("The Stack: " + testStack.toString());
        System.out.println("isEmpty(): " + testStack.isEmpty());
        System.out.println("size(): " + testStack.size());
        System.out.println("pop(): " + testStack.pop());
        System.out.println("The Stack: " + testStack.toString());
        System.out.println("peek(): " + testStack.peek());
        System.out.println("size(): " + testStack.size() + "\n");
    }    
}