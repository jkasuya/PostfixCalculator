package edu.hawaii.ics211;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * CalculatorUserInputTest.java
 * 
 * @author Jarrin Kasuya
 *
 */

public class CalculatorUserInputTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create the input scanner
		Scanner scanner = new Scanner(new InputStreamReader(System.in));

		// create a boolean that allows us to keep track of whether the do loop
		// should run
		boolean exit = false;
		
		System.out.println("Type in 00 to exit the calculator.");

		// My do loop
		do {

			// Give user input
			System.out.print("Enter a postfix expression: ");

			// Retrieve the expression the person types in
			String expression = scanner.nextLine();

			if (expression.equals("00")) {
				exit = true;
				System.out.println("Bye. Thanks for Calculating :)");
			}

			else
				// Print out the answer
				System.out.println("The answer is " + Calculator.calculate(expression));

			// If exit is NOT true then keep prompting and calculating.
		} while (exit != true);

		// Close the Scanner
		scanner.close();

	}

}
