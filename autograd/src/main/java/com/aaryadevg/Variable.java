package com.aaryadevg;

import com.aaryadevg.Ops.*;

// TODO: Add support for generic types
public class Variable {
	private double value;
	private double grad;
	private Operation backwardOperation;
	private boolean requiresGrad;
	
	public Variable() {
		this.setValue(0.0);
		this.setRequiresGrad(false);
	}
	
	public Variable(double value) {
		this.setValue(value);
		this.setRequiresGrad(false);
	}
	
	public Variable(double value, boolean requiresGrad) {
		this.setValue(value);
		this.setRequiresGrad(requiresGrad);
	}
	
	
	public Variable(double value, Operation backwardOp, boolean requiresGrad) {
		this.setValue(value);
		this.setBackwardOperation(backwardOp);
		this.setRequiresGrad(requiresGrad);
	}
	
	public double getValue() {
		return this.value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public double getGrad() {
		return this.grad;
	}
	
	public void setGrad(double gradient) {
		this.grad = gradient;
	}
	
	
	public boolean getRequiresGrad() {
		return this.requiresGrad;
	}
	
	
	private void setRequiresGrad(boolean reqGrad) {
		this.requiresGrad = reqGrad;
	}
	
	public Operation getBackwardOperation() {
		return this.backwardOperation;
	}
	
	public void setBackwardOperation(Operation op) {
		this.backwardOperation = op;
	}
	
	public String toString() {
		return "Variable(" + this.getValue() + ")";
	}
	
	public void backward(double grad) {
		if (this.getRequiresGrad()) {
			this.setGrad(this.getGrad() + grad);
			if (this.backwardOperation != null) {
				this.getBackwardOperation().backward(grad);
			} 
			else {
				return;
			}
		}
		else {
			throw new AutogradException("cannot call 'backward' on Non-RequiresGrad Variable");
		}
	}
}
