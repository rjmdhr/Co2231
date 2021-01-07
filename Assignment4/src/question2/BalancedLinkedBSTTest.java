/*****************************************************************************/
//  BalancedLinkedBSTTest.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 4 Question 2
//  This class tests the balancing mechanism that is implemented in the
//  BalancedLinkedBST class
/*****************************************************************************/

package question2;

import java.util.Iterator;

public class BalancedLinkedBSTTest
{
    public static void main(String[] args)
    {
        // create new BalancedLinkedBST
        BalancedLinkedBST<Integer> testTree = new BalancedLinkedBST<Integer>();

        // adding 3 elements - level order should be:
        // 20 10 30
        System.out.println
        ("\nBALANCED LINKED BST TEST (Trees printed in level order)");
        System.out.println
        ("*Adding 20,30,10 to BST*");
        testTree.addElement(20);
        testTree.addElement(30);
        testTree.addElement(10);
        System.out.println(levelOrder(testTree)); 

        // adding 6 elements - level order should be:
        // 30 (new root) 10 40 20 35 45
        System.out.println("\n*Adding 35,40,45 to BST, new root should be 30*");
        testTree.addElement(35);
        testTree.addElement(40);
        testTree.addElement(45);
        System.out.println(levelOrder(testTree));

        // adding 9 elements - level order should be:
        //  20 (new root) 6 35 4 8 30 40 10 45
        System.out.println("\n*Adding 8,6,4 to BST, new root should be 20*");
        testTree.addElement(8);
        testTree.addElement(6);
        testTree.addElement(4);
        System.out.println(levelOrder(testTree));

        // create new BalancedLinkedBST
        BalancedLinkedBST<Integer> testTree2 = new BalancedLinkedBST<Integer>();

        // attempt to create a degenerate tree but self balancing should
        // give a level order of: 3 1 5 2 4 6
        System.out.println
        ("\nDEGENERATE TREE ATTEMPT (Trees printed in level order)");
        System.out.println("*Adding 1-6 in sequence, root should be 3*");
        testTree2.addElement(1);
        testTree2.addElement(2);
        testTree2.addElement(3);
        testTree2.addElement(4);
        testTree2.addElement(5);
        testTree2.addElement(6);
        System.out.println(levelOrder(testTree2));
    }

    /**
     * Returns the string representation of the BalancedLinkedBST in level order
     * @param tree the tree to print
     * @return string in level order
     */
    public static String levelOrder(BalancedLinkedBST<Integer> tree)
    {
        String result = "";
        
        for(Iterator<Integer> i = tree.iteratorLevelOrder(); i.hasNext();)
            result += i.next() + " ";

        return result;
    }
}