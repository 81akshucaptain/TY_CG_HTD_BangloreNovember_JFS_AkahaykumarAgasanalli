package com.interview.hotelmanagementboot.utilities;


public class HotelManagementException extends RuntimeException {
	String message;

	public HotelManagementException() {

	}

	public HotelManagementException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
