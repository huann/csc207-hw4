package edu.grinnell.csc207.huann.hw4;

import static org.junit.Assert.assertEquals;

import java.math.*;

import org.junit.Test;

public class FractionTest {
	@Test
	public void test() throws Exception {
		//test constructors (and toString)
		assertEquals("fraction(int,int) to string", "1/2", new Fraction(1,2).toString());
		assertEquals("fraction(BigInteger, BigInteger) to string", "1/2", new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(2)).toString());
		assertEquals("fraction(int) to string", "5/1", new Fraction(5).toString());
		assertEquals("fraction(BigInteger) to string", "5/1", new Fraction(BigInteger.valueOf(5)).toString());
		assertEquals("fraction(String) to string", "5/1", new Fraction("5/1").toString());
		assertEquals("fraction(String) to string", "5/1", new Fraction("5").toString());

		//test Standard Object methods
		assertEquals("toString", "5/4", new Fraction(5,4).toString());
		assertEquals("equals", true, new Fraction(5,1).equals(new Fraction("5")));
		assertEquals("equals", false, new Fraction(5,7).equals(new Fraction("5")));
		assertEquals("clone and equals", true, new Fraction(5,1).clone().equals(new Fraction("5")));
		assertEquals("hashCode", 5, new Fraction(5,1).hashCode());
		assertEquals("hashCode", 14, new Fraction(7,2).hashCode());
		
		// test public methods - simplify tested indirectly
		assertEquals("add", new Fraction(2,3), new Fraction(1,3).add(new Fraction(1,3)));
		assertEquals("add", new Fraction(8,1), new Fraction(6).add(new Fraction(2)));
		assertEquals("add", new Fraction(7,3), new Fraction(1,3).add(new Fraction(2)));
		assertEquals("subtract", new Fraction(2,3), new Fraction(3,3).subtract(new Fraction(1,3)));
		assertEquals("subtract", new Fraction(-1,1), new Fraction(3).subtract(new Fraction(4)));
		assertEquals("multiply", new Fraction(2,3), new Fraction(1,3).multiply(new Fraction(2,1)));
		assertEquals("multiply", new Fraction(10,3), new Fraction(5,3).multiply(new Fraction(2,1)));
		assertEquals("multiply", new Fraction(5,3), new Fraction(5,3).multiply(new Fraction(2,2)));
		assertEquals("divide", "2/1", new Fraction(2,3).divide(new Fraction(1,3)).toString());
		assertEquals("divide", "2/1", new Fraction(2,4).divide(new Fraction(1,4)).toString());
		assertEquals("reciprocal", new Fraction(5,3), new Fraction(3,5).reciprocal());
		assertEquals("negate", new Fraction(-3,5), new Fraction(3,5).negate());
		assertEquals("numerator", BigInteger.valueOf(3), new Fraction(3,5).numerator());
		assertEquals("denominator", BigInteger.valueOf(5), new Fraction(3,5).denominator());
	} // test
}