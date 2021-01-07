/*****************************************************************************/
//  ArrayListQueueTest.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 2 Question 3
//  This class tests the ArrayListQueue class and its methods
/*****************************************************************************/

package question4;
import exceptions.*;

public class ArrayListQueueTest 
{
    public static void main(String[] args)
    {
        //create new LinkedListQueue of defualt size zero
        ArrayListQueue<Integer> testQueue = new ArrayListQueue<Integer>();

        //test methods on an empty stack
        System.out.println("\n*EMPTY ARRAYLIST QUEUE TEST*");
        System.out.println("isEmpty(): " + testQueue.isEmpty());
        System.out.println("size(): " + testQueue.size());
        System.out.print("first(): ");
        try
        {testQueue.first();}
        catch(EmptyCollectionException ex)
        {System.out.println("Exception - " + ex.getMessage());}
        System.out.print("dequeue: ");
        try
        {testQueue.dequeue();}
        catch(EmptyCollectionException ex)
        {System.out.println("Exception - " + ex.getMessage() + "\n");}

        //test methods by adding elements
        testQueue.enqueue(1); 
        testQueue.enqueue(2);
        testQueue.enqueue(3);
        System.out.println("*MULTIPLE ELEMENT ARRAYLIST QUEUE TEST*");
        System.out.println("(Enqueue 1,2,3 to rear)");
        System.out.println("The Queue: " + testQueue.toString());
        System.out.println("isEmpty(): " + testQueue.isEmpty());
        System.out.println("size(): " + testQueue.size());
        System.out.println("first(): " + testQueue.first());
        System.out.println("dequeue: " + testQueue.dequeue());
        System.out.println("The Queue: " + testQueue.toString() + "\n");
        
        System.out.println("(Enqueue 4,5 to rear)");
        testQueue.enqueue(4);
        testQueue.enqueue(5);
        System.out.println("The Queue: " + testQueue.toString());
        System.out.println("first(): " + testQueue.first());
        System.out.println("dequeue: " + testQueue.dequeue());
        System.out.println("The Queue: " + testQueue.toString());
    }
}
