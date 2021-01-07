/*****************************************************************************/
//  PalindromeCheckerTest.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 2 Question 4
//  This class tests the method isPalindrome() from the PalindromeChecker 
//  class. 
/*****************************************************************************/

package question4;

public class PalindromeCheckerTest
{
    public static void main(String[] args) 
    {
        //Test variety of string inputs
        System.out.println("\nEmpty String (\"\"): " + PalindromeChecker.isPalindrome(""));
        
        System.out.println("Red rum, sir, is murder (redrumsirismurder): " + 
        PalindromeChecker.isPalindrome("Red rum, sir, is murder"));
        
        System.out.println("Racecar? (racecar): " + 
        PalindromeChecker.isPalindrome("Racecar?"));
        
        System.out.println("test!$@!#tset (testtset): " +
        PalindromeChecker.isPalindrome("test!$@!#tset"));

        System.out.println("123321: " +
        PalindromeChecker.isPalindrome("123321"));

        System.out.println("notAPalindrome: " +
        PalindromeChecker.isPalindrome("notAPalindrome"));

        System.out.println("X AE A-12: " +
        PalindromeChecker.isPalindrome("X AE A-12"));
    } 
}