package com.capgemini.forestmanagementjpa.exceptions;

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
