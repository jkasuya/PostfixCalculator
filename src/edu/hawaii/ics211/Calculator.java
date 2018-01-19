/** Calculator.java
 *  
 * @author  Jarrin Kasuya 
 * Thanks to Logan Uyeda for helping me find all the exceptions that I had to throw
 * 
 * Code Based off Pages 173-175 in the textbook
 * 
 */


package edu.hawaii.ics211;


import java.util.*;


public class Calculator {

	// Declare a variable to figure out what the Operators are
	private static final String OPERATORS = "+-*/";

	// Create an operand stack of type integer and float
	private static Stack<Integer> intStack;
	private static Stack<Float> floatStack;
	
	//Create a method to see whether or not a character is a operator
	private static boolean isOperator(char c) {
		return OPERATORS.lastIndexOf(c) != -1;
	}
	
	//Create the Number calculate method
	public static Number calculate(String expression) {
		try{
		// if expression is going to do int math
		if (expression.indexOf('.') == -1) {
			intStack = new Stack<Integer>();
			//split the expression
			String[] ops = expression.split("\\s+");
			try {
				//Go through each character and see whether they are a digit or an operator
				for (String nextOp : ops) {
					char firstChar = nextOp.charAt(0);
					//if its a character, then push it onto the stack
					if (Character.isDigit(firstChar)) {
						try {
						int value = Integer.parseInt(nextOp);
						intStack.push(value);
						} catch (NumberFormatException e){
							throw new ICS211Exception("Improper input");
						}
					//else if its a operator, do some math
					} else if (isOperator(firstChar)) {
						try {
						int right = intStack.pop();
						int left = intStack.pop();
						int result = 0;
						//see which operator is the one that is there, and do math accordingly
						switch (firstChar) {
						case '+':
							result = left + right;
							break;
						case '-':
							result = left - right;
							break;
						case '/':
							result = left / right;
							break;
						case '*':
							result = left * right;
							break;
						}
						//then push the result back on the stack
						intStack.push(result); 
						} catch (EmptyStackException es) {
							throw new ICS211Exception("You tried to pop an empty stack");
						}
					} else {
						throw new ICS211Exception("Invalid character encountered " + firstChar);
					}
				}
				//pop the answer off the stack
				int answer = intStack.pop();
				//and then if the stack is empty, then return the answer, else throw an exception
				if (intStack.empty()) {
					return answer;
				} else {
					throw new ICS211Exception("Syntax Error: Stack should be empty");
				}
			} catch (EmptyStackException ex) {
				throw new ICS211Exception("Syntax Error: The stack is empty");
			}
		//else we need to do float math (Comments are the exact same, just in terms of floats)
		} else {
			floatStack = new Stack<Float>();
			String[] ops = expression.split("\\s+");
			try {
				for (String nextOp : ops) {
					char firstChar = nextOp.charAt(0);
					if (Character.isDigit(firstChar)) {
						try {
						float value = Float.parseFloat(nextOp);
						floatStack.push(value);
						} catch (NumberFormatException e){
							throw new ICS211Exception("Improper input");
						}
					} else if (isOperator(firstChar)) {
						try {
						float right = floatStack.pop();
						float left = floatStack.pop();
						float result = 0;
						switch (firstChar) {
						case '+':
							result = left + right;
							break;
						case '-':
							result = left - right;
							break;
						case '/':
							result = left / right;
							break;
						case '*':
							result = left * right;
							break;
						}
						floatStack.push(result); 
						} catch (EmptyStackException es) {
							throw new ICS211Exception("You tried to pop an empty stack");
						}
					} else {
						throw new ICS211Exception("Invalid character encountered " + firstChar);
					}
				}
				float answer = floatStack.pop();
				if (floatStack.empty()) {
					return answer;
				} else {
					throw new ICS211Exception("Syntax Error: Stack should be empty");
				}
			} catch (EmptyStackException ex) {
				throw new ICS211Exception("Syntax Error: The stack is empty");
			}
			
		} 
		} catch (StringIndexOutOfBoundsException se) {
			throw new ICS211Exception("No operands");
		}
		
	}
}
