package com.capgemini.forestmnagementdb.exception;

public class VallidationExceptionFMS extends RuntimeException{
	String message;
	public VallidationExceptionFMS() {

	}
	public VallidationExceptionFMS(String message){
		super();
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}	
}