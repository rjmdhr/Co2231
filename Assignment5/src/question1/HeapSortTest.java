/*****************************************************************************/
//  HeapSortTest.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 5 Question 1
//  This class tests the heapSort class that attemps to build a heap in place.
//  It will sort arrays in ascending order using the maxHeapify and heapSort
//  method.
/*****************************************************************************/

package question1;

public class HeapSortTest 
{
    public static void main(String[] args) 
    {
        // construct various test heaps and a HeapSort object
        HeapSort<Integer> sorter = new HeapSort<Integer>();
        Integer[] testHeapA = {10,9,8,7,6,5,4,3,2,1};
        Integer[] testHeapB = {-2,-6,0,1,-9,5,-7,4,-3,8};
        Integer[] testHeapC = {0,1,2,3,4,5};
        Integer[] testHeapD = {0,0,0,0,0,0};
        Integer[] testHeapE = {-1,-5,-12,-25,-6,-9,-3};
        
        // heap sort arrays and print results
        System.out.println("\nHEAPSORT TEST");
        System.out.println("*Array in decreasing order (10 to 1)*");
        sorter.heapSort(testHeapA);
        printArray(testHeapA);

        System.out.println("\n\n*Randomized array of 10 integers*");
        sorter.heapSort(testHeapB);
        printArray(testHeapB);

        System.out.println("\n\n*Already sorted array in ascending order* (0-5)");
        sorter.heapSort(testHeapC);
        printArray(testHeapC);

        System.out.println("\n\n*All zeros array (size 6)*");
        sorter.heapSort(testHeapD);
        printArray(testHeapD);

        System.out.println("\n\n*All negative integers array (size 7)*");
        sorter.heapSort(testHeapE);
        printArray(testHeapE);
    }

    /**
     * Prints <Integer> array
     * @param array the array to be printed
     */
    public static void printArray(Integer [] array)
    {
        System.out.print("[");
        for (int i = 0; i < array.length; i++)
            System.out.print(" " + array[i]);
        System.out.print(" ]");
    }
}
