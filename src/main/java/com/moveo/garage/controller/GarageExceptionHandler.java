package com.moveo.garage.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.moveo.garage.controller.util.ErrorDetail;
import com.moveo.garage.exception.AlreadyExistsException;
import com.moveo.garage.exception.MismatchingWheelAmountException;
import com.moveo.garage.exception.NotFoundException;
import com.moveo.garage.exception.NullException;
import com.moveo.garage.exception.util.ExceptionCode;

/*
 * catches the exceptions thrown by the garage system and sends error details- 
 * an object containing the http status code, the exception code (as defined in the system) 
 * and the message from the exception
 * making it very easy to handle the exceptions at the client side
 */
@ControllerAdvice
@RestController
public class GarageExceptionHandler {
	@ExceptionHandler(MismatchingWheelAmountException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorDetail mismatchingWheelAmount(MismatchingWheelAmountException e) {
		return new ErrorDetail(HttpStatus.FORBIDDEN.value(), ExceptionCode.MISMATCHING_WHEEL_AMOUNT.getCode(),
				e.getMessage());
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorDetail notFound(NotFoundException e) {
		return new ErrorDetail(HttpStatus.NOT_FOUND.value(), ExceptionCode.NOT_FOUND.getCode(), e.getMessage());
	}

	@ExceptionHandler(NullException.class)
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public ErrorDetail nullException(NullException e) {
		return new ErrorDetail(HttpStatus.UNPROCESSABLE_ENTITY.value(), ExceptionCode.NULL_EXCEPTION.getCode(),
				e.getMessage());
	}

	@ExceptionHandler(AlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorDetail alreadyExists(AlreadyExistsException e) {
		return new ErrorDetail(HttpStatus.CONFLICT.value(), ExceptionCode.ALREADY_EXISTS.getCode(), e.getMessage());
	}

}
