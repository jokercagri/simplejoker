package com.cagri.joker.api.exceptions;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 5288387446871407857L;

	private String errorMessage;

	public BusinessException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
