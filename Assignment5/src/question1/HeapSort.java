/*****************************************************************************/
//  HeapSort.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 5 Question 1
//  This class modifies an existing binary array tree and converts it to a max
//  heap. It then sorts the array in ascending order by recursivley modifying
//  the sub-tree node by moving the largest element to the ending index and 
//  reducing the size of the modifiable heap until it reaches zero.
//  Some help from GeeksforGeeks.com was used to understand the algorithm
/*****************************************************************************/

package question1;

public class HeapSort<T extends Comparable<T>>
{
	/**
	 * Uses maxHeap to sort each node in data heap
	 * @param data the heap array to be sorted
	 */
	public void heapSort(T[] data) 
	{
        int s = data.length;

        // max heapify array
        // s/2 - 1 represents the index of the last non-leaf node
        for (int i = s/2 - 1; i >= 0; i--) 
            maxHeapify(data, i, s); 

        // max heapify the array while reducing the size by 1 each time
        // store the largest element (index 0) at the end of the heap
        for (int i = s-1; i > 0; i--)
        {
            T temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            // reorder root node so largest element is on top
            maxHeapify(data, 0, i);
        }
    }
    
    /**
     * 
     * @param data the heap array to be built in place
     * @param i the index of the sub-tree root to be heapified
     * @param s the size of the heap to be modified
     */
    public void maxHeapify(T[] data, int i, int s)
    {
        int largest = i; // assume largest node is at root index
        int leftC = 2*i+1; // index of left child in array
        int rightC = 2*i+2; //index of right child in array

        // if left child is within range and larger than parent, change largest
        if (leftC < s && (data[largest]).compareTo(data[leftC]) < 0)
            largest = leftC;
        
        // if right child is within range and larger than parent, change largest
        if (rightC < s && (data[largest]).compareTo(data[rightC]) < 0)
            largest = rightC;

        // swap the parent with the largest node
        if (largest != i)
        {
            T rootVal = data[i];
            data[i] = data[largest];
            data[largest] = rootVal;

            // recursively heapify this node until parent root is largest
            maxHeapify(data, largest, s);
        }
    }
}