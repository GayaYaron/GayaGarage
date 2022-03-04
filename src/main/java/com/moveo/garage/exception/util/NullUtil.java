package com.moveo.garage.exception.util;

import org.springframework.stereotype.Component;

import com.moveo.garage.exception.NullException;

@Component
public class NullUtil {
	public void check(Object o, String name) throws NullException {
		if(o==null) {
			throw new NullException(name);
		}
	}
	
	public void check(Object o, String name, String methodName) throws NullException {
		if(o==null) {
			throw new NullException(name, methodName);
		}
	}
}
