package com.moveo.garage.exception;

public class AlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AlreadyExistsException(String name) {
		super(name + " already exists");
	}
	
	

}
