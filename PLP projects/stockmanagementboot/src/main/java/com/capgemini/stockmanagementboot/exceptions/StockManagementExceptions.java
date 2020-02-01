package com.capgemini.stockmanagementboot.exceptions;

public class StockManagementExceptions extends RuntimeException {
	String message;

	public StockManagementExceptions() {
	}

	public StockManagementExceptions(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
