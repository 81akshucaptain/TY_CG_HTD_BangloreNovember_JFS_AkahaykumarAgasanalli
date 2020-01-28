package com.capgemini.foresterymanagement.exception;

public class LandsAppException extends RuntimeException {
	String message;
	public LandsAppException() {		
	}
	public LandsAppException(String message){
		super();
		this.message=message;
	}
	 @Override
	public String getMessage() {
		return super.getMessage();
	}
}
