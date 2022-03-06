package com.moveo.garage.exception.util;

public enum ExceptionCode {
	MISMATCHING_WHEEL_AMOUNT(1), NOT_FOUND(2), NULL_EXCEPTION(3), ALREADY_EXISTS(4);

	private int code;

	private ExceptionCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
