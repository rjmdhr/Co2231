/*****************************************************************************/
//  ArrayDequeTest.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 2 Question 3
//  This class tests the ArrayDeque class and its methods
/*****************************************************************************/

package question3;

import jsjf.exceptions.EmptyCollectionException;

public class ArrayDequeTest 
{
    public static void main(String[] args)
    {
        //create new ArrayDeque of size 5
        ArrayDeque<Integer> testDeque = new ArrayDeque<Integer>(5);

        //test methods on an empty stack
        System.out.println("\n*EMPTY DEQUE TEST (deque of capacity 5)*");
        System.out.println("isEmpty(): " + testDeque.isEmpty());
        System.out.println("size(): " + testDeque.size());
        System.out.print("first(): ");
        try
        {testDeque.first();}
        catch(EmptyCollectionException ex)
        {System.out.println("Exception - " + ex.getMessage());}
        System.out.print("deleteFront(): ");
        try
        {testDeque.deleteFront();}
        catch(EmptyCollectionException ex)
        {System.out.println("Exception - " + ex.getMessage());}
        System.out.print("deleteRear(): ");
        try
        {testDeque.deleteRear();}
        catch(EmptyCollectionException ex)
        {System.out.println("Exception - " + ex.getMessage());}
        System.out.println("The Deque: " + testDeque.toString() + "\n");

        //test methods by adding elements
        testDeque.insertFront(1);
        testDeque.insertRear(2);
        testDeque.insertFront(0);
        System.out.println("*MULTIPLE ELEMENT DEQUE TEST* (less than 5 elements)");
        System.out.println("(Adding 1,0 to front and 2 to rear)");
        System.out.println("The Deque: " + testDeque.toString());
        System.out.println("isEmpty(): " + testDeque.isEmpty());
        System.out.println("size(): " + testDeque.size());
        System.out.println("first(): " + testDeque.first());
        System.out.println("deleteFront(): " + testDeque.deleteFront());
        System.out.println("deleteRear(): " + testDeque.deleteRear());
        System.out.println("The Deque: " + testDeque.toString() + "\n");

        System.out.println("*OVERLOAD DEQUE TEST (exceed 5 element capacity)");
        System.out.println("(Adding 0,-1,-2,-3,-4 to front and 2,3,4 to rear)");
        testDeque.insertFront(0);
        testDeque.insertFront(-1);
        testDeque.insertFront(-2);
        testDeque.insertFront(-3);
        testDeque.insertFront(-4);
        testDeque.insertRear(2);
        testDeque.insertRear(3);
        testDeque.insertRear(4);
        System.out.println("The Deque:" + testDeque.toString());
        System.out.println("isEmpty(): " + testDeque.isEmpty());
        System.out.println("size(): " + testDeque.size());
        System.out.println("first(): " + testDeque.first());
        System.out.println("deleteFront(): " + testDeque.deleteFront());
        System.out.println("deleteRear(): " + testDeque.deleteRear());
        System.out.println("The Deque: " + testDeque.toString());
        System.out.println("deleteFront(): " + testDeque.deleteFront());
        System.out.println("deleteRear(): " + testDeque.deleteRear());
        System.out.println("The Deque: " + testDeque.toString());
        System.out.println("size(): " + testDeque.size());
        System.out.println("first(): " + testDeque.first());
    }
}