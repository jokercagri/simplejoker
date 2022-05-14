package com.cagri.joker.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiErrorOutput {

	@ApiModelProperty
	private String message;

	public ApiErrorOutput() {
		super();
	}

	public ApiErrorOutput(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
