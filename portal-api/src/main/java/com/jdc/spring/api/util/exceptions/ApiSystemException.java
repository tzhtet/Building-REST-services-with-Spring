package com.jdc.spring.api.util.exceptions;

public class ApiSystemException extends ApiBaseException {

	private static final long serialVersionUID = 1L;

	public ApiSystemException(Throwable cause, String message) {
		super(cause, message);
	}
	
	public ApiSystemException(Throwable cause) {
		super(cause);
	}

}
