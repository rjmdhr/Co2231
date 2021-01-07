/*****************************************************************************/
//  PalindromeTester.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 2 Question 4
//  This class uses both a stack and queue to test whether a given string is a
//  palindrome
/*****************************************************************************/

package question4;

public class PalindromeChecker 
{
    /**
     * This method uses a stack and queue to test whether the input string is
     * a palindrome
     * @param input the string to test
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String input)
    {
        boolean isPalindrome = true;

        //avoid any discrepencies in input that may result in error
        input = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

        //create stack and queue and insert elements of input String into them
        LinkedStack<Character> charStack = new LinkedStack<Character>();
        LinkedQueue<Character> charQueue = new LinkedQueue<Character>();

        for (int scan = 0; scan < input.length(); scan++)
        {
            charStack.push(input.charAt(scan)); 
            charQueue.enqueue(input.charAt(scan));
        }

        //check if characters at separate ends of string are equal
        while (isPalindrome && !charStack.isEmpty() && !charQueue.isEmpty())
        {
            if (!(charStack.pop().equals(charQueue.dequeue())))
                isPalindrome = false;
        }

        return isPalindrome;
    }
}