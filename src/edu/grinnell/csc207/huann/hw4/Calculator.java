package edu.grinnell.csc207.huann.hw4;

import java.io.PrintWriter;
import java.math.BigInteger;

/**
 * A fraction calculator.
 * 
 * @author Samuel A. Rebelsky
 * @author Ann Hu
 * @author Kyle Moorehead
 * @author Tim Youtz
 * @author CSC207 2013F
 * @version 0.1 of September 2013
 */
public class Calculator {
	
	    // +------------------+---------------------------------------------
		// | Design Decisions |
		// +------------------+

		/*
		 * User input must be separated by spaces.
		 * 
		 * The calculator returns only fractions, in their simplest form.
		 * 
		 */

	// static String[] r = new String[8];
	static Fraction[] r = new Fraction[8];

	public static Fraction evaluate(String expression) throws Exception {
		// use the spaces in the expression as a separator
		String[] arrExpr = expression.split(" ");
		// create a new fraction to store the answer
		Fraction ans = new Fraction(BigInteger.valueOf(1),
				BigInteger.valueOf(1));
		
		if (arrExpr.length == 1) {
			ans = new Fraction(rCheck(arrExpr[0]));
			return ans; //if there is only one input, return that input (assuming it can be evaluated)
		} else {
			if (arrExpr[1].equals("=")) {
				r[(int) arrExpr[0].charAt(1)] = evaluate(rCheck(arrExpr[2]));
				return r[(int) arrExpr[0].charAt(1)];
				//if the operator is "=" then set the first expression (r[something]) equal to the second expression
			}
			ans = new Fraction(rCheck(arrExpr[0]));
			// set the current answer to the first number input
			for (int i = 1; i < arrExpr.length; i++) {

				if (arrExpr[i].equals("+")) {
					ans = ans.add(new Fraction(rCheck(arrExpr[i + 1])));
				} // if addition
				if (arrExpr[i].equals("-")) {
					ans = ans.subtract(new Fraction(rCheck(arrExpr[i + 1])));
				} // if subtraction
				if (arrExpr[i].equals("*")) {
					ans = ans.multiply(new Fraction(rCheck(arrExpr[i + 1])));
				} // if multiplication
				if (arrExpr[i].equals("/")) {
					ans = ans.divide(new Fraction(rCheck(arrExpr[i + 1])));
				} // if division

			} // for
			return ans;
		} // eva1uate(string)
	}

	public static Fraction[] evaluate(String[] expression) throws Exception {
		Fraction[] ans = new Fraction[expression.length];
		for (int i = 0; i < expression.length; i++) {
			ans[i] = evaluate(expression[i]);
		} //for
		return ans;
	} // eva1uate(string [])

	public static String rCheck(String arrExpr) throws Exception {

		if (arrExpr.charAt(0) == 'r') {
			return (r[arrExpr.charAt(1)]).toString();
		} else
			return arrExpr;
	}

	/**
	 * Main method acts as user interface.
	 */
	public static void main(String[] args) throws Exception {
		PrintWriter pen = new PrintWriter(System.out, true);
		java.io.BufferedReader eyes;
		java.io.InputStreamReader istream;
		istream = new java.io.InputStreamReader(System.in);
		String response;
		eyes = new java.io.BufferedReader(istream);
		pen.println("What would you like calculated?\nType 'quit' to exit calculator.");
		while (true) {
			while ((response = eyes.readLine()).equals("quit")) {
				System.exit(0);
			} //while quit
			try {
				pen.println(Calculator.evaluate(rCheck(response)));
				pen.println("Calculation complete.");
			} catch (Exception e) {
				pen.println("Sorry, that is not valid input. Please try again.");
			}
		} //while the calculator is running
	} //main
} //class Calculator