package com.interview.hotelmanagementboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.hotelmanagementboot.dto.BookRoom;
import com.interview.hotelmanagementboot.dto.HotelManagementResponseBodyBean;
import com.interview.hotelmanagementboot.service.BookRoomsService;

@RestController
//@CrossOrigin(origins = "",allowCredentials = "true",allowedHeaders = "")
public class BookRoomsController {
	@Autowired
	BookRoomsService bRoomsService;
	/*
	 * @PostMapping annotation maps HTTP POST requests onto specific handler
	 * methods. It is a composed annotation that acts as a shortcut
	 * for @RequestMapping(method = RequestMethod.POST).
	 */
	@PostMapping(path = "/add.bookingRoom", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponseBodyBean addBookingRoom(@RequestBody BookRoom bookingRoom) {
		HotelManagementResponseBodyBean bookingRoomsResponse = new HotelManagementResponseBodyBean();
		if (bRoomsService.bookTheRoom(bookingRoom)) {
			bookingRoomsResponse.setStatusCode(400);
			bookingRoomsResponse.setMessage("Success");
			bookingRoomsResponse.setDescription("BookingRoom Added Successfuly");
		} else {
			bookingRoomsResponse.setStatusCode(401);
			bookingRoomsResponse.setMessage("Failure");
			bookingRoomsResponse.setDescription("Failed to Add BookingRoom,BookingRoom May Exist..!");

		}

		return bookingRoomsResponse;
	}

	@DeleteMapping(path = "/delete.bookingRoom/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponseBodyBean deleteBookingRoom(@PathVariable("id") int id) {
		HotelManagementResponseBodyBean bookingRoomsResponse = new HotelManagementResponseBodyBean();
		if (bRoomsService.removeTheBooking(id)) {
			bookingRoomsResponse.setStatusCode(400);
			bookingRoomsResponse.setMessage("Success");
			bookingRoomsResponse.setDescription("BookingRoom Deleted Successfuly");
		} else {
			bookingRoomsResponse.setStatusCode(401);
			bookingRoomsResponse.setMessage("Failure");
			bookingRoomsResponse.setDescription("Failed to delete BookingRoom,BookingRoom May not  Exist..!");

		}
		return bookingRoomsResponse;
	}

	@GetMapping(path = "/get.customer.bookingRooms/{customerID}")
	public HotelManagementResponseBodyBean getBookingRoomsForCustomer(@PathVariable("customerID") int customerID) {
		HotelManagementResponseBodyBean bookingRoomsResponse = new HotelManagementResponseBodyBean();
		List<BookRoom> bookingRooms = bRoomsService.getTheBookingsForCustomer(customerID);
		if (bookingRooms != null) {
			bookingRoomsResponse.setStatusCode(400);
			bookingRoomsResponse.setMessage("Success");
			bookingRoomsResponse.setDescription("CustomerBookingRoom Found Successfuly");
			bookingRoomsResponse.setBookRooms(bookingRooms);
		} else {
			bookingRoomsResponse.setStatusCode(401);
			bookingRoomsResponse.setMessage("Failure");
			bookingRoomsResponse.setDescription("Failed to find CustomerBookingRoom,CustomerBookingRoom May not  Exist..!");
		}
		return bookingRoomsResponse;
	}
	@GetMapping(path = "/get.all.bookingRooms")
	public HotelManagementResponseBodyBean getBookingRoomsForAdmin() {
		HotelManagementResponseBodyBean bookingRoomsResponse = new HotelManagementResponseBodyBean();
		List<BookRoom> bookingRooms = bRoomsService.getTheBookingsAdmin();
		if (bookingRooms != null) {
			bookingRoomsResponse.setStatusCode(400);
			bookingRoomsResponse.setMessage("Success");
			bookingRoomsResponse.setDescription("BookingRoomsForAdmin() Found Successfuly");
			bookingRoomsResponse.setBookRooms(bookingRooms);
		} else {
			bookingRoomsResponse.setStatusCode(401);
			bookingRoomsResponse.setMessage("Failure");
			bookingRoomsResponse.setDescription("Failed to find BookingRoomsForAdmin(),BookingRoomsForAdmin() May not  Exist..!");

		}
		return bookingRoomsResponse;
	}

	
	
	

}
