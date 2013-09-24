package edu.grinnell.csc207.huann.hw4;

import static org.junit.Assert.assertEquals;

import java.math.*;

import org.junit.Test;

public class FractionTest {
    @Test
    public void test() throws Exception {
	assertEquals("1/2", new Fraction(1,2).toString());
	assertEquals("2/3", new Fraction(2,3), new Fraction(1,3).multiply(new Fraction(2,1)));
	assertEquals("1/2", new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(2)).toString());
	assertEquals("2/1", new Fraction(2,3).divide(new Fraction(1,3)).toString());
	assertEquals("2/1", new Fraction(2,4).divide(new Fraction(1,4)).toString());
	assertEquals("2/3", new Fraction(2,3), new Fraction(1,3).add(new Fraction(1,3)));
	assertEquals("1", new Fraction(1,1), new Fraction(1,3).add(new Fraction(2,3)));
	assertEquals("7/3", new Fraction(7,3), new Fraction(1,3).add(new Fraction(2,1)));
	assertEquals("2/3", new Fraction(2,3), new Fraction(3,3).subtract(new Fraction(1,3)));
	
    } // test

    
}