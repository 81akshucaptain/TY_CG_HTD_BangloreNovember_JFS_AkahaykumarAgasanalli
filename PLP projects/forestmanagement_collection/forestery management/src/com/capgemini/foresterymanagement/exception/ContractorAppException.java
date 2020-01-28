package com.capgemini.foresterymanagement.exception;

public class ContractorAppException extends RuntimeException {
	String message;
	public ContractorAppException() {
		
	}
	public ContractorAppException(String message){
		super();
		this.message=message;
	}
	 @Override
	public String getMessage() {
		return message;
	}
}