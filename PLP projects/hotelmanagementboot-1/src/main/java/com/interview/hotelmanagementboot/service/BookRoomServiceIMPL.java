package com.interview.hotelmanagementboot.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.hotelmanagementboot.dao.BookingRoomsDAO;
import com.interview.hotelmanagementboot.dto.BookRoom;

@Service
public class BookRoomServiceIMPL implements BookRoomsService {

	@Autowired
	BookingRoomsDAO bookingRoomDao;

	@Override
	public boolean bookTheRoom(BookRoom bookRoom) {
		if (bookingRoomDao.bookTheRoom(bookRoom))
			return true;
		else
			return false;
	}

	@Override
	public boolean removeTheBooking(int bookingID) {
		if (bookingRoomDao.removeTheBooking(bookingID))
			return true;
		else
			return false;
	}

	@Override
	public List<BookRoom> getTheBookingsForCustomer(int bookingID) {
		List<BookRoom> roomsForCustomers = bookingRoomDao.getTheBookingsForCustomer(bookingID);
		if (roomsForCustomers != null)
			return roomsForCustomers;
		else
			return null;
	}

	@Override
	public List<BookRoom> getTheBookingsAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

}
