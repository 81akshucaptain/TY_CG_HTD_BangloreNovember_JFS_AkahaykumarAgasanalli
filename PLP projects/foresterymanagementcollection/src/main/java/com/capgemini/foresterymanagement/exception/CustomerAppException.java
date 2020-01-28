package com.capgemini.foresterymanagement.exception;

public class CustomerAppException extends RuntimeException{
	String message;
	public CustomerAppException() {

	}
	public CustomerAppException(String message){
		super();
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}	
}