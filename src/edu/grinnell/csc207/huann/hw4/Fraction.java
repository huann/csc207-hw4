package edu.grinnell.csc207.huann.hw4;

import java.math.*;

/**
 * A simple implementation of fractions.
 * 
 * @author Samuel A. Rebelsky
 * @author Ann Hu
 * @author Kyle Moorehead
 * @author Tim Youtz
 * @author CSC207 2013F
 * @version 0.1 of September 2013
 */
public class Fraction {
	// +------------------+---------------------------------------------
	// | Design Decisions |
	// +------------------+

	/*
	 * Fractions are immutable. Once you've created one, it stays that way.
	 * 
	 * Fractions are arbitrary precision.
	 * 
	 * Denominators are always positive. Therefore, negative fractions are
	 * represented with a negative numerator. Similarly, if a fraction has a
	 * negative numerator, it is negative.
	 * 
	 * Fractions are stored in simplified form.
	 */

	private static BigInteger NEGATIVE_ONE = BigInteger.valueOf(-1);

	// +--------+-------------------------------------------------------
	// | Fields |
	// +--------+

	/** The numerator of the fraction. Can be positive, zero or negative. */
	BigInteger numerator;

	/** The denominator of the fraction. Must be positive. */
	BigInteger denominator;

	// +--------------+-------------------------------------------------
	// | Constructors |
	// +--------------+

	/**
	 * Create a new fraction equivalent to numerator/denominator.
	 */
	public Fraction(BigInteger numerator, BigInteger denominator)
			throws Exception {
		if (denominator.signum() == 0) {
			throw new Exception("Zero is an invalid denominator");
		}
		this.numerator = numerator;
		this.denominator = denominator;
		this.cleanup();
	} // Fraction(BigInteger, BigInteger)

	public Fraction(int numerator, int denominator) {
		// I have two ints.
		// I need two BigIntegers
		// How do I go from the ints to BigIntegers?
		// Hint: Read the documentation for Integer and BigInteger
		// A really inefficient strategy:
		// Convert each int to a string
		// Convert each string to a BigInteger
		// this.numerator = new BigInteger(Integer.toString(_num));
		// this.denominator = new BigInteger(Integer.toString(_denom));
		this.numerator = BigInteger.valueOf(numerator);
		this.denominator = BigInteger.valueOf(denominator);
	} // Fraction(int, int)

	public Fraction(String frac) {
		String[] fracParts = frac.split("/");
		this.numerator = new BigInteger(fracParts[0]);
		if (fracParts.length < 2)
			this.denominator = BigInteger.valueOf(1);
		else
			this.denominator = new BigInteger(fracParts[1]);

		this.simplify();

	}

	// +-------------------------+--------------------------------------
	// | Standard Object Methods |
	// +-------------------------+

	/**
	 * Convert this fraction to a string for ease of printing.
	 */
	public String toString() {
		// Lump together the string represention of the numerator,
		// a slash, and the string representation of the denominator
		// return
		// this.numerator.toString().concat("/").concat(this.denominator.toString());
		return this.numerator + "/" + this.denominator;
	} // toString()

	/**
	 * Determine if one fraction equals another.
	 */
	public boolean equals(Object other) {
		return (other instanceof Fraction) && this.equals((Fraction) other);
	} // equals(Object)

	public boolean equals(Fraction other) {
		return this.numerator.equals(other.numerator)
				&& this.denominator.equals(other.denominator);
	} // equals (Fraction)

	//public int hashCode() {
	//return this.numerator.multiply(this.denominator);
	//} // hashCode()

	// +-----------------+----------------------------------------------
	// | Private Methods |
	// +-----------------+

	/**
	 * Make sure the denominator is positive. If the number is 
	 */
	
	private void cleanup() {
		if (this.denominator.signum() < 0) {
			this.denominator = this.denominator.abs();
			this.numerator = this.numerator.multiply(NEGATIVE_ONE);
		} // if
		this.simplify();
	} // cleanup()
	

	/**
	 * 
	 */
	private void simplify() {
		BigInteger commonDenom = this.numerator.gcd(this.denominator);
		this.numerator = this.numerator.divide(commonDenom);
		this.denominator = this.denominator.divide(commonDenom);
	} // simplify()

	// +---------+------------------------------------------------------
	// | Methods |
	// +---------+

	/**
	 * Add another faction to this fraction.
	 */
	public Fraction add(Fraction addend) {
		BigInteger resultNumerator;
		BigInteger resultDenominator;

		// The denominator of the result is the
		// product of this object's denominator
		// and addMe's denominator
		resultDenominator = this.denominator.multiply(addend.denominator);
		// The numerator is more complicated
		resultNumerator = (this.numerator.multiply(addend.denominator))
				.add(addend.numerator.multiply(this.denominator));

		this.simplify();

		// Return the computed value
		try {
			return new Fraction(resultNumerator, resultDenominator);
		} catch (Exception e) {
			return this;
		}
	} // add(Fraction)

	/**
	 * Subtract a fraction from this fraction.
	 */
	public Fraction subtract(Fraction subtractor) {
		BigInteger resultNumerator;
		BigInteger resultDenominator;

		// The denominator of the result is the
		// product of this object's denominator
		// and addMe's denominator
		resultDenominator = this.denominator.multiply(subtractor.denominator);
		// The numerator is more complicated
		resultNumerator = (this.numerator.multiply(subtractor.denominator))
				.subtract(subtractor.numerator.multiply(this.denominator));

		this.simplify();

		// Return the computed value
		try {
			return new Fraction(resultNumerator, resultDenominator);
		} catch (Exception e) {
			return this;
		}
	} // subtract(Fraction)

	public Fraction multiply(Fraction multiplier) {
		BigInteger resultNumerator;
		BigInteger resultDenominator;

		resultDenominator = this.denominator.multiply(multiplier.denominator);
		resultNumerator = this.numerator.multiply(multiplier.numerator);

		try {
			return new Fraction(resultNumerator, resultDenominator);
		} catch (Exception e) {
			return null;
		}
	}

	public Fraction divide(Fraction divisor) throws Exception {
		// Fraction inverse = new Fraction(divisor.denominator,
		// divisor.numerator);
		// create an inverse fraction
		BigInteger resultNumerator;
		BigInteger resultDenominator;

		resultDenominator = this.denominator.multiply(divisor.numerator);
		resultNumerator = this.numerator.multiply(divisor.denominator);

		Fraction result = new Fraction(resultNumerator, resultDenominator);
		// Fraction result = divisor.multiply(inverse);
		result.simplify();

		try {
			return result;
		} catch (Exception e) {
			return this;
		}
	}

	public Fraction fractint(BigInteger val) {
		val = this.numerator;
		this.denominator = BigInteger.valueOf(1);
		return this;
	}

	/**
	 * Approximate this fraction as a double.
	 */
	public double doubleValue() {
		return this.numerator.doubleValue() / this.denominator.doubleValue();
	} // doubleValue()

	public static void main(String[] args) {
		Fraction a = new Fraction(1, 2);
		Fraction b = a.add(new Fraction(1, 2));
		System.out.print("a is " + a);
		System.out.print("b is" + b);
	}
} // class Fraction