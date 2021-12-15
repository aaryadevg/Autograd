package com.aaryadevg.Ops;

import com.aaryadevg.*;

public interface Operatable {
	public Variable forward();
	public void backward(double grad);
}
