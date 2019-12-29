package com.capgemini.springrestproject.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//(controllerAdvice+ResponseBody)

import com.capgemini.springrestproject.dto.EmployeeResponse;
import com.capgemini.springrestproject.exception.EmployeeException;
@RestControllerAdvice
public class EmployeeControllerAdvice {
	@ExceptionHandler(EmployeeException.class)
	public EmployeeResponse HandleEmployeeException(EmployeeException e) {
		EmployeeResponse erResponse=new EmployeeResponse();
		erResponse.setStatusCode(501);
		erResponse.setMessage("Exception");
		erResponse.setDiscription(e.getMessage());
		return erResponse;
	}
}
