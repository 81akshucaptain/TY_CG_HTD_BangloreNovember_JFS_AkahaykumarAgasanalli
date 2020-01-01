package com.capgemini.forestmanagementjpa.exceptions;

public class ProductAppException extends RuntimeException {
	
	String message;
	
	public ProductAppException(){	
	}
	public ProductAppException(String message) {
		super();
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
