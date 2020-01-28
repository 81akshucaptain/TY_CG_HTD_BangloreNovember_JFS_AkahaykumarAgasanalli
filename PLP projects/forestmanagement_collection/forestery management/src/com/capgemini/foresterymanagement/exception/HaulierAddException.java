package com.capgemini.foresterymanagement.exception;

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
