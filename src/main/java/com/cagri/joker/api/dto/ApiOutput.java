package com.cagri.joker.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiOutput<T> {

	@ApiModelProperty
	private ApiStatusOutput status;

	@ApiModelProperty
	private T data;

	@ApiModelProperty
	private ApiErrorOutput error;

	public ApiOutput() {
		super();
	}
	
	public ApiOutput(ApiStatusOutput status, T data) {
		this(status, data, null);
	}

	public ApiOutput(ApiStatusOutput status, T data, ApiErrorOutput error) {
		super();
		this.status = status;
		this.data = data;
		this.error = error;
	}

	public ApiStatusOutput getStatus() {
		return status;
	}

	public void setStatus(ApiStatusOutput status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ApiErrorOutput getError() {
		return error;
	}

	public void setError(ApiErrorOutput error) {
		this.error = error;
	}

}
