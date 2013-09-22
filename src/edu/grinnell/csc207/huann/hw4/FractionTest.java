package edu.grinnell.csc207.huann.hw4;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {
    @Test
    public void test() {
	//assertEquals("1/2", new Fraction(1,2).toString());
	assertEquals("2/3", new Fraction(1,3).multiply(new Fraction(2,1)));
	
    } // test

    
}