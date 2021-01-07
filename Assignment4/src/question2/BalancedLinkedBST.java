/*****************************************************************************/
//  BalancedLinkedBST.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 4 Question 2
//  This class extends the LinkedBinarySearchTree and implements a brute force
//  method that recursively balances a BST using binary partitioning
/*****************************************************************************/

package question2;

import jsjf.*;
import java.util.*;
@SuppressWarnings("unchecked")

public class BalancedLinkedBST<T> extends LinkedBinarySearchTree<T>
{
    /**
     * Replaces super instance with balanced tree using binary partitioning
     * Uses existing tree to replace old root with new balanced tree root
     */
    private void balanceTree()
    {
        // array to copy tree elements to
        T[] temp = (T[]) new Object[size()];
        int count = 0;

        for(Iterator<T> i = iterator(); i.hasNext();)
            temp[count++] = i.next();

        // construct new balanced tree and replace old root
        binaryBalance(temp, 0, size()-1);
    }

    /**
     * Uses recursive binary partitioning to create a new balanced tree from an
     * existing input array that holds all inorder LinkedBinarySearchTree elements
     * elements
     * @param inputArray inorder array of LinkedBinarySearchTree elements
     * @param start starting index for input array
     * @param end ending index for input array
     * @return new root of balanced tree
     */
    private BinaryTreeNode<T> binaryBalance(T[] inputArray, int start, int end)
    {
        // invalid input
        if (start > end)
			return null;
        
        // get middle element of array
		int mid = (start + end) / 2;
		BinaryTreeNode<T> newRoot = new BinaryTreeNode<T>(inputArray[mid]);
        
        // recursively add elements to node by binary partitioning
		newRoot.setLeft(binaryBalance(inputArray, start, mid-1));
        newRoot.setRight(binaryBalance(inputArray, mid+1, end));
        
        // assign super root as new balanced node
        root = newRoot;
        return newRoot;
    }

    /**
     * Overrides existing addElement method and balances tree
     * @param element the element to be added to this tree
     */
    public void addElement(T element)
    {
        super.addElement(element);
        balanceTree();
    }

    /**
     * Overrides existing removeElement method and balances tree
     * @param targetElement the element to be removed from this tree
     * @return a reference to removed element in this tree
     */
    public T removeElement(T targetElement)
    {
        super.removeElement(targetElement);
        balanceTree();
        return super.removeElement(targetElement);
    }

    /**
     * Overrides existing removeAllOccurrences method and balances tree
     * @param targetElement the element to remove all occurrences of
     */
    public void removeAllOccurrences(T targetElement)
    {
        super.removeAllOccurrences(targetElement);
        balanceTree();
    }

    /**
     * Overrides existing removeMin method and balances tree
     * @return a reference to the minimum element in this tree
     */
    public T removeMin()
    {
        T result = super.removeMin();
        balanceTree();
        return result;
    }

    /**
     * Overrides existing removeMax method and balances tree
     * @return a reference to the max element in this tree
     */
    public T removeMax()
    {
        T result = super.removeMax();
        balanceTree();
        return result;
    }
}