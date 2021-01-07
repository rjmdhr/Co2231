/*****************************************************************************/
//  LinkedDropOutStackTest.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 2 Question 2
//  This class tests the LinkedDropOutStack and its methods
/*****************************************************************************/

package question2;

import jsjf.exceptions.EmptyCollectionException;

public class LinkedDropOutStackTest
{
    public static void main(String[] args) 
    {
        //create a new stack with size of 5
        LinkedDropOutStack<Integer> testStack = new LinkedDropOutStack<Integer>(5);

        //test methods on empty stack
        System.out.println("\n*EMPTY DROPOUTSTACK TEST*");
        System.out.println("isEmpty(): " + testStack.isEmpty());
        System.out.println("size(): " + testStack.size());

        System.out.print("pop(): ");
        try
        {testStack.pop();}
        catch (EmptyCollectionException ex)
        {System.out.println("Exception - " + ex.getMessage());}

        System.out.print("peek(): ");
        try
        {testStack.peek();}
        catch (EmptyCollectionException ex)
        {System.out.println("Exception - " + ex.getMessage() + "\n");}

        //test methods by adding elements
        testStack.push(1);
        testStack.push(2);
        testStack.push(3);
        System.out.println("*MULTIPLE ELEMENT DROPOUTSTACK TEST*");
        System.out.println("The Stack: " + testStack.toString());
        System.out.println("isEmpty(): " + testStack.isEmpty());
        System.out.println("size(): " + testStack.size());
        System.out.println("pop(): " + testStack.pop());
        System.out.println("The Stack: " + testStack.toString());
        System.out.println("peek(): " + testStack.peek());
        System.out.println("size(): " + testStack.size() + "\n");

        //test methods by exceeding capacity
        testStack.push(3);
        testStack.push(4);
        testStack.push(5);
        testStack.push(6);
        System.out.println("*OVERLOAD DROPOUTSTACK TEST*");
        System.out.println("The Stack: " + testStack.toString());
        System.out.println("isEmpty(): " + testStack.isEmpty());
        System.out.println("peek(): " + testStack.peek());
        System.out.println("size(): " + testStack.size());
        System.out.println("pop(): " + testStack.pop());
        System.out.println("The Stack: " + testStack.toString());
        testStack.push(6);
        testStack.push(7);
        System.out.println("The Stack: " + testStack.toString());
    }
}