package com.capgemini.forestmnagement.exception;

public class HaulierAddException extends RuntimeException {
	String message;

	HaulierAddException(){

	}
	public HaulierAddException(String message){
		super();
		this.message=message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
