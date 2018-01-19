package edu.hawaii.ics211;

/** CalculatorTest.java
 * 
 * @author Jarrin Kasuya
 *
 */

public class CalculatorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Calculator.calculate("1 2 + 3 * 6 + 2 3 + /"));
		
		System.out.println(Calculator.calculate("2.2 7.0 + 3.0 *"));
		
		System.out.println(Calculator.calculate("1 3 5 + -"));
		
		System.out.println(Calculator.calculate("1 2 3.0 / +"));
		

//		System.out.println(Calculator.calculate("1 3 5  -"));

//		System.out.println(Calculator.calculate("1f 3 5 + -"));
//		System.out.println(Calculator.calculate("1 3 5 * / + -"));
//		System.out.println(Calculator.calculate("1 3 5 + -5 + -"));

//		System.out.println(Calculator.calculate(""));

//		System.out.println(Calculator.calculate(" +-"));
		

	}

}
