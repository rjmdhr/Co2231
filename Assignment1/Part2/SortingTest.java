/*****************************************************************************/
//  SortingTest.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 1
//  This class tests the Sorting class algorithms for the number of comparisons
//  and total runtime of each algorithm in the class
/*****************************************************************************/

import java.util.Arrays;

public class SortingTest 
{
    public static void main(String[] args)
    {
        Integer [] array0 = {1,2,3,4,5,6,7,8,9,10};
        Integer [] array1 = {10,9,8,7,6,5,4,3,2,1};
        Integer [] array2 = {-1,-1,-2,-2,-3,-3,-4};
        Integer [] array3 = {1,-1,2,-2,3,-3,4,-4,5,-5};

        Sorting sorter = new Sorting();

        //Test algorithms for array 0
        printArray(array0);
        sorter.selectionSort(Arrays.copyOf(array0, 10));
        System.out.print("Selection Sort:\t");
        printData(sorter);
        sorter.insertionSort(Arrays.copyOf(array0, 10));
        System.out.print("Insertion Sort:\t");
        printData(sorter);
        sorter.bubbleSort(Arrays.copyOf(array0, 10));
        System.out.print("Bubble Sort:\t");
        printData(sorter);
        sorter.quickSort(Arrays.copyOf(array0, 10));
        System.out.print("Quick Sort:\t");
        printData(sorter);
        sorter.mergeSort(Arrays.copyOf(array0, 10));
        System.out.print("Merge Sort:\t");
        printData(sorter);

        //Test algorithms for array 1
        printArray(array1);
        sorter.selectionSort(Arrays.copyOf(array1, 10));
        System.out.print("Selection Sort:\t");
        printData(sorter);
        sorter.insertionSort(Arrays.copyOf(array1, 10));
        System.out.print("Insertion Sort:\t");
        printData(sorter);
        sorter.bubbleSort(Arrays.copyOf(array1, 10));
        System.out.print("Bubble Sort:\t");
        printData(sorter);
        sorter.quickSort(Arrays.copyOf(array1, 10));
        System.out.print("Quick Sort:\t");
        printData(sorter);
        sorter.mergeSort(Arrays.copyOf(array1, 10));
        System.out.print("Merge Sort:\t");
        printData(sorter);

        //Test algorithms for array 2
        printArray(array2);
        sorter.selectionSort(Arrays.copyOf(array2, 7));
        System.out.print("Selection Sort:\t");
        printData(sorter);
        sorter.insertionSort(Arrays.copyOf(array2, 7));
        System.out.print("Insertion Sort:\t");
        printData(sorter);
        sorter.bubbleSort(Arrays.copyOf(array2, 7));
        System.out.print("Bubble Sort:\t");
        printData(sorter);
        sorter.quickSort(Arrays.copyOf(array2, 7));
        System.out.print("Quick Sort:\t");
        printData(sorter);
        sorter.mergeSort(Arrays.copyOf(array2, 7));
        System.out.print("Merge Sort:\t");
        printData(sorter);

        //Test algorithms for array 3
        printArray(array3);
        sorter.selectionSort(Arrays.copyOf(array3, 10));
        System.out.print("Selection Sort:\t");
        printData(sorter);
        sorter.insertionSort(Arrays.copyOf(array3, 10));
        System.out.print("Insertion Sort:\t");
        printData(sorter);
        sorter.bubbleSort(Arrays.copyOf(array3, 10));
        System.out.print("Bubble Sort:\t");
        printData(sorter);
        sorter.quickSort(Arrays.copyOf(array3, 10));
        System.out.print("Quick Sort:\t");
        printData(sorter);
        sorter.mergeSort(Arrays.copyOf(array3, 10));
        System.out.print("Merge Sort:\t");
        printData(sorter);

    }

    /**
     * Prints generic type array in given parameter
     * @param array the array to be printed
     */
    private static <T> void printArray(T[] array)
    {   
        System.out.println();
        for (int x = 0; x < array.length; x++)
        {
            System.out.print(array[x]+", ");
            if (x == array.length-2)
            {
                System.out.print(array[x+1]);
                break;
            }
        }
        System.out.println();
    }

    /**
     * Prints the number of comparisons and total execution time in Sorter
     * object
     * @param sorter the sorter object that records attributes numComparisons
     * and totalTime
     */
    private static void printData(Sorting sorter)
    {
        System.out.println
        ("Number Comparisons: " + sorter.numComparisons);
        System.out.println("\t\tExecution Time: " + sorter.totalTime + " ns");
    }
}