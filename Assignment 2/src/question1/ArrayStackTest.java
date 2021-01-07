/*****************************************************************************/
//  ArrayStackTest.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 2 Question 1
//  This application tests the validity of modifying the ArrayStack class such
//  that the stack[top] is the actual top of the stack
/*****************************************************************************/

package question1;

import jsjf.exceptions.EmptyCollectionException;

public class ArrayStackTest 
{
    public static void main(String[] args) 
    {
        //create a new stack with size of 5
        ArrayStack<Integer> testStack = new ArrayStack<Integer>(5);

        //test methods on empty stack
        System.out.println("\n*EMPTY STACK TEST*");
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
        System.out.println("*MULTIPLE ELEMENT STACK TEST*");
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
        testStack.push(99);
        System.out.println("*OVERLOAD STACK TEST*");
        System.out.println("The Stack: " + testStack.toString());
        System.out.println("isEmpty(): " + testStack.isEmpty());
        System.out.println("peek(): " + testStack.peek());
        System.out.println("size(): " + testStack.size());
        System.out.println("pop(): " + testStack.pop());
        System.out.println("The Stack: " + testStack.toString());
    }
}