package com.moveo.garage.controller.util;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetail {
	private int statusCode;
	private int garageErrorcode;
	private String message;
}
