package edu.grinnell.csc207.huann.hw4;

import java.io.PrintWriter;
import java.math.BigInteger;

public class Calculator {

	// static String[] r = new String[8];

	public static Fraction evaluate(String expression) throws Exception {
		// use the spaces in the expression as a separator
		String[] arrExpr = expression.split(" ");
		// take the first number as temporary answer
		Fraction ans = new Fraction(BigInteger.valueOf(1),
				BigInteger.valueOf(1));
		Fraction[] r = new Fraction[8];

		if (arrExpr[1].equals("=")) {
			r[(int) arrExpr[0].charAt(1)] = evaluate(arrExpr[2]);
			return r[(int) arrExpr[0].charAt(1)] ;
		}
		ans = new Fraction(arrExpr[0]);

		for (int i = 1; i < arrExpr.length; i++) {
			//if (arrExpr[i - 1].charAt(0) == 'r') {
			//	arrExpr[i - 1] = r[arrExpr[i - 1].charAt(1)];
			//} // if
			if (arrExpr[i].equals("+")) {
				ans = ans.add(new Fraction(arrExpr[i + 1]));
			} // if addition
			if (arrExpr[i].equals("-")) {
				ans = ans.subtract(new Fraction(arrExpr[i + 1]));
			} // if subtraction
			if (arrExpr[i].equals("*")) {
				ans = ans.multiply(new Fraction(arrExpr[i + 1]));
			} // if multiplication
			if (arrExpr[i].equals("/")) {
				ans = ans.divide(new Fraction(arrExpr[i + 1]));
			} // if division
			
		} // for
		return ans;
	} // eva1uate(string)

	public static Fraction[] evaluate(String[] expression) throws Exception {
		Fraction[] ans = new Fraction[expression.length];
		for (int i = 0; i < expression.length; i++) {
			ans[i] = evaluate(expression[i]);
		}
		return ans;
	} // eva1uate(string [])

	public static void main(String[] args) throws Exception {
		PrintWriter pen = new PrintWriter(System.out, true);
		java.io.BufferedReader eyes;
		java.io.InputStreamReader istream;
		istream = new java.io.InputStreamReader(System.in);
		eyes = new java.io.BufferedReader(istream);
		String response;
		pen.println("What would you like calculated?\nType 'quit' to exit calculator.");
		while ((response = eyes.readLine()) != "quit") {
			pen.println(Calculator.evaluate(response));
			pen.println("Calculation complete.");
		}
	}

}
