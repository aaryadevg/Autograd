package com.aaryadevg.Ops;

import java.util.ArrayList;

import com.aaryadevg.*;


public class ExponentialOperation extends Operation {
	
	public ExponentialOperation(ArrayList<Variable> inputs) {
		super(inputs, 1);
	}

	@Override
	public Variable forward() {
		return new Variable(Math.exp(getArg(0)), this, this.getReqGrad());
	}

	@Override
	public void backward(double grad) {
		double g = grad * Math.exp(getArg(0));
		if (inputs.get(0).getRequiresGrad()) { inputs.get(0).backward(g); }
	}

}
