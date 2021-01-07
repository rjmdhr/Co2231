/*****************************************************************************/
//  HashTableTest.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 5 Question 3
//  This class tests the HashTable class methods made in question 5
/*****************************************************************************/

package question3;

import jsjf.exceptions.ElementNotFoundException;

public class HashTableTest 
{
    public static void main(String[] args) 
    {
        // create a hashTable of size 10
        HashTable testTable = new HashTable(10);

        // add 3 elements to hash table
        System.out.println("\nHASHTABLE TEST\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("*Adding 3 elements to this hashTable (size 10)*");
        testTable.put("225-87-9704", "Marlene Spencer");
        testTable.put("256-56-3134", "Jaiden Cervantes");
        testTable.put("448-68-6645", "Josue Shaw");
        System.out.print(testTable.toString()); 
        System.out.println("size: " + testTable.size() + "\n");

        // delete element
        System.out.println("*Deleting an element (Josue Shaw)*");
        testTable.remove("448-68-6645");
        System.out.print(testTable.toString()); 
        System.out.println("size: " + testTable.size());
        System.out.println("contains(Jaiden): " + testTable.contains("256-56-3134"));
        System.out.println("contains(Josue): " + testTable.contains("448-68-6645"));
        

        // create a hashTable of size 10 and test rehash/collisions
        System.out.println("\nCOLLISION TESTING\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("*Adding 4 elements to this hashTable (size 5)*");
        System.out.println("*This should cause it to exceed the loading factor and rehash*");
        HashTable testTable2 = new HashTable(5);
        testTable2.put("212-62-2055", "King Robbins");
        testTable2.put("212-42-2055", "Leland Barry"); //sinlge collision
        testTable2.put("212-98-2055", "Bobby Chester"); //double collision
        testTable2.put("212-21-2055", "Justice Burgess"); //triple collision
        
        // by now the hashTable should have been rehashed to size 10
        System.out.print(testTable2.toString());
        System.out.println("size: " + testTable2.size());
        System.out.println("\n*Test methods on automatically rehashed table*");
        System.out.println("contains(Leland)(Single collision): " + testTable2.contains("212-42-2055"));
        System.out.println("contains(Bobby)(Double collision): " + testTable2.contains("212-98-2055"));
        System.out.println("contains(Justice)(Triple collision): " + testTable2.contains("212-21-2055"));
        System.out.println("contains(non-existent): " + testTable2.contains("999-99-9999"));
        System.out.println("\n*Removing Justice at triple collision*");
        testTable2.remove("212-21-2055");
        System.out.println("contains(Justice): " + testTable2.contains("212-21-2055"));

        // clear table and print
        testTable2.clear();
        System.out.println("Table after clearing: " + testTable2.toString());

        // test exceptions
        System.out.println("\nTESTING EXCEPTIONS\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("*Adding 999-99-9, and removing non-existent elements*");

        try
        {
            testTable2.put("999-99-9", "This shouldn't work");
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e);
        }

        try
        {
            testTable2.remove("999-99-9999");
        }
        catch(ElementNotFoundException e)
        {
            System.out.println(e);
        }
    }   
}
