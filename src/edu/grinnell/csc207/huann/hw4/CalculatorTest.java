package edu.grinnell.csc207.huann.hw4;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEvaluate() throws Exception {
		assertEquals("12", Calculator.evaluate("5 + 7"));
	}

}
