package com.cagri.joker.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cagri.joker.api.dto.ApiErrorOutput;
import com.cagri.joker.api.dto.ApiOutput;
import com.cagri.joker.api.dto.ApiStatusOutput;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ApiOutput<ApiErrorOutput> processBusinessException(BusinessException ex) {
		ApiErrorOutput error = new ApiErrorOutput(ex.getErrorMessage());
		return new ApiOutput<>(ApiStatusOutput.ERROR, null, error);
	}

}
