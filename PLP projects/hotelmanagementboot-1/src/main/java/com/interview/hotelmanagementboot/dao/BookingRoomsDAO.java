package com.interview.hotelmanagementboot.dao;

import java.util.List;

import com.interview.hotelmanagementboot.dto.BookRoom;

public interface BookingRoomsDAO {
	public boolean bookTheRoom(BookRoom bookRoom);

	public boolean removeTheBooking(int bookingID);

	public List<BookRoom> getTheBookingsForCustomer(int bookingID);

	public List<BookRoom> getTheBookingsAdmin();
}
