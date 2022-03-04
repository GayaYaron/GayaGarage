package com.moveo.garage.exception;

public class MismatchingWheelAmountException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MismatchingWheelAmountException(String vehicleType, Integer neededAmount, Integer givenAmount) {
		super("The "+ vehicleType + " must have " + neededAmount + " wheels. You submitted: " + givenAmount);
	}
	
	

}
