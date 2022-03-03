package com.moveo.garage.exception;

import org.springframework.stereotype.Component;

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
