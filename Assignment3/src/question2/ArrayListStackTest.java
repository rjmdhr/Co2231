/*****************************************************************************/
//  ArrayListStackTest.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 3 Question 2
//  This class tests the class that uses java.util.ArrayList by checking
//  various cases which would produce errors
/*****************************************************************************/

package question2;
import exceptions.*;

public class ArrayListStackTest 
{
    public static void main(String[] args) 
    {
        //create a new linked stack
        ArrayListStack<Integer> testStack = new ArrayListStack<Integer>();

        //test methods on empty stack
        System.out.println("\n*EMPTY ARRAYLIST STACK TEST*");
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
        System.out.println("*MULTIPLE ELEMENT ARRAYLIST STACK TEST*");
        System.out.println("-left is bottom, right is top-");
        System.out.println("The Stack: " + testStack.toString());
        System.out.println("isEmpty(): " + testStack.isEmpty());
        System.out.println("size(): " + testStack.size());
        System.out.println("pop(): " + testStack.pop());
        System.out.println("The Stack: " + testStack.toString());
        System.out.println("peek(): " + testStack.peek());
        System.out.println("size(): " + testStack.size() + "\n");
    }    
}