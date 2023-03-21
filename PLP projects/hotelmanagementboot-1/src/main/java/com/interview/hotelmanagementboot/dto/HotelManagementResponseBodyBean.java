package com.interview.hotelmanagementboot.dto;

import java.util.List;


public class HotelManagementResponseBodyBean {
	private int statusCode;
	private String message;
	private String description;
	private List<RoomsBean> rooms;
	private List<BookRoom> bookRooms;
	private List<CustomerBean> customer;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<RoomsBean> getRooms() {
		return rooms;
	}

	public void setRooms(List<RoomsBean> rooms) {
		this.rooms = rooms;
	}

	public List<BookRoom> getBookRooms() {
		return bookRooms;
	}

	public void setBookRooms(List<BookRoom> bookRooms) {
		this.bookRooms = bookRooms;
	}

	public List<CustomerBean> getCustomer() {
		return customer;
	}

	public void setCustomer(List<CustomerBean> customer) {
		this.customer = customer;
	}

}
