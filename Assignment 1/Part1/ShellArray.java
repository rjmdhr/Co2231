/*****************************************************************************/
//  ShellArray.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 1
//  This application creates and populates an array of integers based on a
//  size supplied to the constructor. It will also implement the shell sort
//  algorithm as a method of the class
/*****************************************************************************/

import java.util.Random;

public class ShellArray
{
    /**
     * The class attribute (an array that is modified upon calling ShellArray)
     */
    public int [] shell;

    /**
     * Default Constructor
     */
    public ShellArray() {}

    /**
     * Constructor
     * @param size the size of the array to be created
     * @param max the max value of each integer in the array
     */
    public ShellArray(int size, int max)
    {
        shell = ShellArray.makeArray(size, max);
    }
    
    /**
     * Creates a random array of integers between 1-max depending on given
     * paramter size
     * @param size the size of the arrary to be created
     * @param max the max value of each integer in the array
     * @return the randomized array
     */
    private static int [] makeArray(int size, int max)
    {
        //initialize random array and number generator
        int [] randomArray = new int[size];
        Random rand = new Random();
        int randInt;

        //create random array
        for(int x = 0; x < size; x++)
        {
            randInt = rand.nextInt(max);
            randomArray[x] = randInt;
        }

        return randomArray;
    }

    /**
     * sorts the class attribute shell using the shell sort algorithm
     */
    public void shellSort()
    {
        //instantiate variables for gap and swapflag
        boolean swapflag;
        int gap = shell.length/2;

        //shell sort algorithm
        while (gap > 0)
        {
            swapflag = true;
            while (swapflag == true)
            {
                swapflag = false;
                for (int s = 0; s < shell.length-gap; s++)
                {
                    if (shell[s] > shell[s+gap])
                    {
                        //swap elements at s and s+gap
                        int temp = shell[s];
                        shell[s] = shell[s+gap];
                        shell[s+gap] = temp;
                        swapflag = true;
                    }
                    toStr(shell, swapflag);
                }
            }
            gap = gap/2;
        }
    }

    /**
     * Prints one result of a swap for the shell array
     * @param shell
     * @param success
     */
    private static void toStr(int [] shell, boolean success)
    {
        for(int x = 0; x < shell.length; x++)
        {
            System.out.print(shell[x]+", ");
        }
        if (success)
        {
            System.out.println("swap successful");
        }
        else 
            System.out.println("swap unsuccessful");
    }

//end class    
}