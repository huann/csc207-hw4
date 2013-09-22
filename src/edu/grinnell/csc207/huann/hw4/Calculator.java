package edu.grinnell.csc207.huann.hw4;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Calculator {
	
	static String[] r = new String[8];
	
	
	public static Fraction evaluate(String expression) throws Exception {
		//use the spaces in the expression as a separator
		String[] arrExpr = expression.split(" ");
		//take the first number as temporary answer
		Fraction ans = new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(1));
		ans = ans.toFraction(arrExpr[0]);
		for (int i = 1; i < arrExpr.length; i++) {
			if (arrExpr[i].equals("=")) {
				r[arrExpr[i-1].charAt(1)] = arrExpr[i+1];
			} //if storage
			if (arrExpr[i-1].charAt(0)=='r') {
				arrExpr[i-1] = r[arrExpr[i-1].charAt(1)];
			} //if
			if (arrExpr[i].equals("+")) {
				ans = ans.add(ans.toFraction(arrExpr[i+1]));
			} //if addition
			if (arrExpr[i].equals("-")) {
				ans = ans.subtract(ans.toFraction(arrExpr[i+1]));
			} //if subtraction
			if (arrExpr[i].equals("*")) {
				ans = ans.multiply(ans.toFraction(arrExpr[i+1]));
			} //if multiplication
			if (arrExpr[i].equals("/")) {
				ans = ans.divide(ans.toFraction(arrExpr[i+1]));
			} //if division


		} //for
		return ans;
	} //eva1uate(string)
	
	
	public static Fraction evaluate(String[] expression) {
		return null;
	} //eva1uate(string [])
	
	
	public static void main () throws IOException {
		PrintWriter pen = new PrintWriter(System.out, true);
		java.io.BufferedReader eyes;
		java.io.InputStreamReader istream;
		istream = new java.io.InputStreamReader(System.in);
		eyes = new java.io.BufferedReader(istream);
		pen.println("Hello");
		pen.println(eyes.readLine());
		System.out.println("Hello");
	}

}

