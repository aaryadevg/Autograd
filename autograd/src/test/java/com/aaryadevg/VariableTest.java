package com.aaryadevg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.aaryadevg.Ops.AddOperation;

import org.junit.Test;

public class VariableTest {
	public VariableTest() {
	}

	@Test
	public void defaultConstructorTest() {
		Variable v = new Variable();
		assertEquals("Default value of a variable should be 0", 0.0, v.getValue(), 0);
		assertEquals(false, v.getRequiresGrad());
	}
	
	@Test
	public void valueConstructorTest() {
		Variable v = new Variable(1.5);
		assertEquals("checks that initial value is set correctly", 1.5, v.getValue(), 0);
		assertEquals(false, v.getRequiresGrad());
	}
	
	@Test
	public void requiresGradTest() {
		Variable v = new Variable(1.5, true);
		assertEquals(true, v.getRequiresGrad());
	}
	
	@Test
	public void toStringTest() {
		Variable v = new Variable(1.5);
		assertEquals("Variable(1.5)", v.toString());
	}
	
	@Test
	public void childVariableConstructorTest() {
		Variable a = new Variable(1.0);
		Variable b = new Variable(3.0);
		
		Variable c = Operations.add(a, b);
		assertEquals("Checking addition", 4.0, c.getValue(), 0);
		assertFalse("requires grad field of child variable depends on parent", c.getRequiresGrad());
		
		assertTrue(c.getBackwardOperation() instanceof AddOperation);
	}
	
	@Test(expected = AutogradException.class)
	public void backwardMethodCanThrowErrors() {
		Variable a = new Variable(1.5);
		a.backward(1.0);
	}
	

}
