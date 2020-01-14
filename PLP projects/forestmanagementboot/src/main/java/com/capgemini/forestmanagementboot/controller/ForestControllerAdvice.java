package com.capgemini.forestmanagementboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.forestmanagementboot.dto.ForestManagementResponse;
import com.capgemini.forestmanagementboot.exceptionss.ForestManagementException;

@RestControllerAdvice
public class ForestControllerAdvice {
	@ExceptionHandler
	public ForestManagementResponse HandleForestManagementExceptions(ForestManagementException e) {
		ForestManagementResponse fResponse = new ForestManagementResponse();
		fResponse.setStatusCode(501);
		fResponse.setMessage("Exception");
		fResponse.setDescription(e.getMessage());
		return fResponse;
	}

}
