package com.aaryadevg;


public class AutogradException extends RuntimeException {

	private static final long serialVersionUID = 2400118858874218856L;

	public AutogradException() {
		super("Invalid Operation");
	}
	
	public AutogradException(String errorMessage) {
		super(errorMessage);
	}
}
