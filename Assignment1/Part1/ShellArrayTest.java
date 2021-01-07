/*****************************************************************************/
//  ShellArrayTest.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 1
//  This application tests the ShellArray Class with different array types
//  to validate the functionality and demonstration of the shell sort algorithm
/*****************************************************************************/

public class ShellArrayTest
{
    public static void main(String[] args)
    {
        //All zero array test
        ShellArray test = new ShellArray();
        test.shell = new int [] {0,0,0,0,0};
        System.out.println("\n*Testing an all zero array*");
        test.shellSort();
        System.out.println();

        //Predictable array test
        test.shell = new int [] {7,6,5,4,3,2,1,0};
        System.out.println("*Testing a decreasing order array (7-0)");
        test.shellSort();
        System.out.println();
        
        //Negative array test
        test.shell = new int [] {0,-1,-2,-3,-4,-5};
        System.out.println("*Testing a negative array*");
        test.shellSort();
        System.out.println();

        //Random array test (7 elements max value 100)
        test = new ShellArray(7,100);
        System.out.println("*Testing a random array with max element value of 100*");
        test.shellSort();
        System.out.println();
    }
}