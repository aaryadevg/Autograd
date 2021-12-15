package com.aaryadevg.Ops;

import java.util.ArrayList;

import com.aaryadevg.*;


public class Log10Operation extends Operation {

	public Log10Operation(ArrayList<Variable> inputs) {	
		super(inputs, 1);
	}

	@Override
	public Variable forward() {
			double val = Math.log10(getArg(0)) ;
			return new Variable(val, this, this.getReqGrad());			
	}

	@Override
	public void backward(double grad) {		
		if (inputs.get(0).getRequiresGrad()) { inputs.get(0).backward(grad * (1 / (Math.log(10) * getArg(0)))); }
	}
}
