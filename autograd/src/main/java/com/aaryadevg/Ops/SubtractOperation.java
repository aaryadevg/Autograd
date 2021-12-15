package com.aaryadevg.Ops;

import java.util.ArrayList;

import com.aaryadevg.*;


public class SubtractOperation extends Operation {
	
	public SubtractOperation(ArrayList<Variable> inputs) {	
		super(inputs, 2);
	}

	@Override
	public Variable forward() {
			double val = getArg(0) - getArg(1);
			return new Variable(val, this, this.getReqGrad());			
	}

	@Override
	public void backward(double grad) {
		if (inputs.get(0).getRequiresGrad()) { inputs.get(0).backward(grad);  }
		if (inputs.get(1).getRequiresGrad()) { inputs.get(1).backward(-grad); }
	}
}
