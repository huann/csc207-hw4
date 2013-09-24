package edu.grinnell.csc207.huann.hw4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	String[] hat = new String[] {"10 / 2 + 6 - 6 * 2", "10 / 2", "10 - 5"};
	Fraction[] answer = new Fraction[] {new Fraction (10, 1), new Fraction (5, 1), new Fraction (5, 1)};
	
	@Test
	public void testEvaluate() throws Exception {
		assertEquals("12/1", Calculator.evaluate("5 + 7").toString());
		assertEquals("5/1", Calculator.evaluate("10 - 5").toString());
		assertEquals("20/1", Calculator.evaluate("10 * 2").toString());
		assertEquals("5/1", Calculator.evaluate("10 / 2").toString());
		assertEquals("10/1", Calculator.evaluate("10 / 2 + 6 - 6 * 2").toString());
		assertEquals(answer, Calculator.evaluate(hat));
		assertEquals("1/1", Calculator.evaluate("r1 = 10").toString());
	}

}
