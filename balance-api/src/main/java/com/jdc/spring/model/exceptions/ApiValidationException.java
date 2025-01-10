package com.jdc.spring.model.exceptions;

import java.util.List;

public class ApiValidationException extends ApiBaseException {

	private static final long serialVersionUID = 1L;

	public ApiValidationException(List<String> messages) {
		super(messages);
	}

}
