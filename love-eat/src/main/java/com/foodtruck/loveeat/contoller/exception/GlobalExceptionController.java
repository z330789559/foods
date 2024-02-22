package com.foodtruck.loveeat.contoller.exception;

import java.util.Objects;

import com.foodtruck.loveeat.contoller.response.ResponseUtils;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobaExceptionController
 *
 * @author libaozhong
 * @version 2024-02-21
 **/

@RestControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	 public ResponseUtils.R handleException(MethodArgumentNotValidException e) {
	        return ResponseUtils.fail(500, Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
	    }
}
