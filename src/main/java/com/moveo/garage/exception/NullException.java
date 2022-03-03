package com.moveo.garage.exception;

public class NullException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NullException(String varName) {
		super("You must add the "+varName);
	}
	
	public NullException(String varName, String methodName) {
		super("You must add the "+varName+" in order to "+methodName);
	}

}
