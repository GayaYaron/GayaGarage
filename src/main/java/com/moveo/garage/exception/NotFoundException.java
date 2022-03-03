package com.moveo.garage.exception;

public class NotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String name) {
		super("The " + name + "was not found");
	}

}
