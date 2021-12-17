package com.aaryadevg;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OperationsTest {
	public OperationsTest() {
	}

	@Test
	public void addition() {
		Variable a = new Variable(1.0, true);
		Variable b = new Variable(1.0, true);
		
		Variable c = Operations.add(a, b);
		
		assertEquals("Value of c should be 2", 2.0, c.getValue(), 0);
		
		c.backward(1.0);
		
		assertEquals("dc/da Should be 1", 1.0, a.getGrad(), 0);
		assertEquals("dc/db Should be 1", 1.0, b.getGrad(), 0);
	}
	
	@Test
	public void subtraction() {
		Variable a = new Variable(5.0, true);
		Variable b = new Variable(3.0, true);
		
		Variable c = Operations.subtract(a, b);
		
		assertEquals("5 - 3 should be 2", 2.0, c.getValue(), 0);
		
		c.backward(1.0);
		
		assertEquals("dc/da Should be 1",   1.0, a.getGrad(), 0);
		assertEquals("dc/db Should be -1", -1.0, b.getGrad(), 0);
	}
	
	@Test
	public void multiplication() {
		Variable a = new Variable(5.0, true);
		Variable b = new Variable(3.0, true);
		
		Variable c = Operations.multiply(a, b);
		
		assertEquals("5 * 3 = 15", 5.0 * 3.0, c.getValue(), 0);
		
		c.backward(1.0);
		
		assertEquals("dc/da should be 3", 3.0, a.getGrad(), 0);
		assertEquals("dc/db should be 5", 5.0, b.getGrad(), 0);
	}
	
	@Test
	public void division() {
		Variable a = new Variable(3.0, true);
		Variable b = new Variable(2.0, true);
		
		Variable c = Operations.divide(a, b);
		
		assertEquals("3/2 = 1.5", 1.5, c.getValue(), 0);
		
		c.backward(1.0);
		
		assertEquals("dc/da = 1/b", 0.5, a.getGrad(), 0);
		assertEquals("dc/db should be -0.75", -0.75, b.getGrad(), 0);
	}

	@Test
	public void exponentiation() {
		Variable a = new Variable(2.0, true);
		Variable b = Operations.exp(a);
		
		assertEquals("e^2 = 7.3890560989306495", 7.3890560989306495, b.getValue(), 0.0001); // floating point errors can happen here

		b.backward(1.0);

		assertEquals("derivate of e^x is itself", 7.3890560989306495, a.getGrad(), 0.0001); // floating point errors can happen here
	}

	@Test
	public void naturalLogTest() {
		Variable a = new Variable(1.0, true);
		Variable b = Operations.ln(a);

		assertEquals("ln(1) = 0", 0.0, b.getValue(), 0);

		b.backward(1.0);

		assertEquals("db/da = 1", 1.0, a.getGrad(), 0);
	}

	@Test
	public void log10Test() {
		Variable a = new Variable(1.0,true);
		Variable b = Operations.log10(a);

		assertEquals("log10(1) = 0", 0.0, b.getValue(), 0);

		b.backward(1.0);

		assertEquals("db/da = 1", 0.43429, a.getGrad(), 0.0001);
	}
	@Test
	public void powTest() {
		Variable a = new Variable(1.0, true);
		Variable b = new Variable(1.0, true);

		Variable c = Operations.pow(a,b);

		assertEquals("1^1 = 1", 1.0, c.getValue(), 0);
		
		c.backward(1.0);

		assertEquals("dc/da = 1", 1.0, a.getGrad(), 0);
		assertEquals("dc/db = 0", 0.0, b.getGrad(), 0);
	}

	@Test
	public void multiOP() {
		Variable a = new Variable(3.0, true);
		Variable b = new Variable(2.0, true);
		
		// d = (a * b) + a
		Variable d = Operations.add(Operations.multiply(a, b), a);
		
		assertEquals("(3 * 2) + 3 = 9",9.0, d.getValue(), 0);
		
		d.backward(1.0);
		
		assertEquals("dd/da = 3", 3.0, a.getGrad(), 0);
		assertEquals("dd/db = 3", 3.0, b.getGrad(), 0);
	}
}
