package com.capgemini.retailormpttest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.retailormpttest.dto.RetailerResponse;
import com.capgemini.retailormpttest.exceptions.RetailerException;

@RestControllerAdvice
public class RetailerControllerAdvice {
	@ExceptionHandler(RetailerException.class)
	public RetailerResponse HandleEmployeeException(RetailerException e) {
		RetailerResponse rResponse=new RetailerResponse();
		rResponse.setStatusCode(501);
		rResponse.setMessage("Exception");
		rResponse.setDiscription(e.getMessage());
		return rResponse;
	}
}
