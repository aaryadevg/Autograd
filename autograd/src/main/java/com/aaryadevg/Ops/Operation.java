package com.aaryadevg.Ops;
import java.util.ArrayList;

import com.aaryadevg.*;

public abstract class Operation implements Operatable {
	public ArrayList<Variable> inputs;
	private boolean childReqGrad;
	
	public Operation(ArrayList<Variable>inputs, int expectedSz) {
		if (inputs.size() != expectedSz) {
			throw new AutogradException("Invalid input size for operation");
		}
		else {
			this.inputs = inputs;
		}
		
		checkChildRequiresGrad();
	}
	
	public boolean getReqGrad() {
		return this.childReqGrad;
	}
	
	public double getArg(int idx) {
		return inputs.get(idx).getValue();
	}
	
	private void checkChildRequiresGrad() {
		childReqGrad= false;
		
		for (Variable v : inputs) {
			if (v.getRequiresGrad())
				childReqGrad = true;
		}
	}
}

