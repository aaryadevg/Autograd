package com.aaryadevg;

import java.util.ArrayList;

import com.aaryadevg.Ops.*;

/**
 * Defies a class for all the basic math operations that can be
 * performed on variables
 *
 * 
 * @author Aaryadev Ghosalkar
 *
 */
public class Operations {

	public static Variable add(Variable a, Variable b) {
		ArrayList<Variable> inputs = new ArrayList<Variable>(2);
		inputs.add(a);
		inputs.add(b);
		
		return new AddOperation(inputs).forward();
	}
	
	public static Variable subtract(Variable a, Variable b) {
		ArrayList<Variable> inputs = new ArrayList<Variable>(2);
		inputs.add(a);
		inputs.add(b);
		
		return new SubtractOperation(inputs).forward();
	}
	
	public static Variable multiply(Variable a, Variable b) {
		ArrayList<Variable> inputs = new ArrayList<Variable>(2);
		inputs.add(a);
		inputs.add(b);
		
		return new MultiplyOperation(inputs).forward();
	}
	
	public static Variable divide(Variable a, Variable b) {
		ArrayList<Variable> inputs = new ArrayList<Variable>(2);
		inputs.add(a);
		inputs.add(b);
		
		return new DivideOperation(inputs).forward();
	}
	
	public static Variable exp(Variable a) {
		ArrayList<Variable> inputs = new ArrayList<Variable>(1);
		inputs.add(a);
		
		return new ExponentialOperation(inputs).forward();
	}
	
}
