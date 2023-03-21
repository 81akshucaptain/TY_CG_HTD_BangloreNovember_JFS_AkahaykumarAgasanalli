package com.interview.hotelmanagementboot.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Entity annotation defines that a class can be mapped to a table.
@Table(name = "BookRoom")
public class BookRoom implements Serializable {
	@Id
	// Provides for the specification of generation strategies for thevalues of
	// primary keys.
	@GeneratedValue
	@Column(unique = true, nullable = false)
	private int bookingID;
	@Column
	private String roomId;
	@Column
	private String customerID;

	@Column(nullable = false)
	private String totalRoomsRequired;
	@Column
	private String totalAmount;
	@Column
	private String checkInDate;
	@Column
	private String checkOutDate;

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getTotalRoomsRequired() {
		return totalRoomsRequired;
	}

	public void setTotalRoomsRequired(String totalRoomsRequired) {
		this.totalRoomsRequired = totalRoomsRequired;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	@Override
	public String toString() {
		return "BookRoom [bookingID=" + bookingID + ", roomId=" + roomId + ", customerID=" + customerID + ", roomType="
				+ ", totalRoomsRequired=" + totalRoomsRequired + ", totalAmount=" + totalAmount + ", checkInDate="
				+ checkInDate + ", checkOutDate=" + checkOutDate + "]";
	}

}
