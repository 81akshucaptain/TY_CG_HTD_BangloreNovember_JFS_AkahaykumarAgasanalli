package com.interview.hotelmanagementboot.service;

import java.util.List;

import com.interview.hotelmanagementboot.dto.BookRoom;

public interface BookRoomsService {
	public boolean bookTheRoom(BookRoom bookRoom);

	public boolean removeTheBooking(int bookingID);

	public List<BookRoom> getTheBookingsForCustomer(int customerID);

	public List<BookRoom> getTheBookingsAdmin();
}
