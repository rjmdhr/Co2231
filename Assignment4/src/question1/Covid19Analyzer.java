/*****************************************************************************/
//  Covid19Analyzer.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 4 Question 1
//  This class demonstrates the use of a binary decision tree to 
//  diagnose Coronavirus-19.
/*****************************************************************************/

package question1;
import java.io.*;

public class Covid19Analyzer
{
	/**
	 *  Asks questions of the user to determine if the 14 day isolation and
     *  or testing for Covid-19 is necessary
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		System.out.println("So, you may be infected with Covid19.");

		DecisionTree expert = new DecisionTree("Covid19TestInput.txt");
		expert.evaluate();
	}
}