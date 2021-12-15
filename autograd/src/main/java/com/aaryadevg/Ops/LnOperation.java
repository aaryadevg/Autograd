package com.aaryadevg.Ops;

import java.util.ArrayList;

import com.aaryadevg.*;


public class LnOperation extends Operation {

	public LnOperation(ArrayList<Variable> inputs) {
		super(inputs, 1);
	}

	@Override
	public Variable forward() {
		return new Variable(Math.log(getArg(0)), this, this.getReqGrad());
	}

	@Override
	public void backward(double grad) {
		if (inputs.get(0).getRequiresGrad()) { inputs.get(0).backward( grad * 1/getArg(0) ); }
	}

}
