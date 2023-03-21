package com.interview.hotelmanagementboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interview.hotelmanagementboot.dto.HotelManagementResponseBodyBean;
import com.interview.hotelmanagementboot.dto.RoomsBean;
import com.interview.hotelmanagementboot.service.RoomsServices;

@RestController
@RequestMapping("/admin")
//@CrossOrigin(allowCredentials = "true", origins = "", allowedHeaders = "")
public class RoomsController {
	@Autowired
	RoomsServices roomsServices;
	
	@PostMapping(path = "/add.room", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponseBodyBean addRoom(@RequestBody RoomsBean room) {
		HotelManagementResponseBodyBean roomsResponse = new HotelManagementResponseBodyBean();
		if (roomsServices.addRoom(room)) {
			roomsResponse.setStatusCode(400);
			roomsResponse.setMessage("Success");
			roomsResponse.setDescription("Room Added Successfuly");
		} else {
			roomsResponse.setStatusCode(401);
			roomsResponse.setMessage("Failure");
			roomsResponse.setDescription("Failed to Add Room,Room May Exist..!");

		}

		return roomsResponse;
	}

	@DeleteMapping(path = "/delete.room/{id}")
	public HotelManagementResponseBodyBean deleteRoom(@PathVariable("id") int id) {
		HotelManagementResponseBodyBean roomsResponse = new HotelManagementResponseBodyBean();
		if (roomsServices.deleteRoom(id)) {
			roomsResponse.setStatusCode(400);
			roomsResponse.setMessage("Success");
			roomsResponse.setDescription("Room Deleted Successfuly");
		} else {
			roomsResponse.setStatusCode(401);
			roomsResponse.setMessage("Failure");
			roomsResponse.setDescription("Failed to delete Room,Room May not  Exist..!");

		}
		return roomsResponse;
	}

	@GetMapping(path = "/get.all.rooms")
	public HotelManagementResponseBodyBean searchRoom() {
		HotelManagementResponseBodyBean roomsResponse = new HotelManagementResponseBodyBean();
		List<RoomsBean> rooms = roomsServices.getAllRooms();
		if (rooms != null) {
			roomsResponse.setStatusCode(400);
			roomsResponse.setMessage("Success");
			roomsResponse.setDescription("Room Found Successfuly");
			roomsResponse.setRooms(rooms);
		} else {
			roomsResponse.setStatusCode(401);
			roomsResponse.setMessage("Failure");
			roomsResponse.setDescription("Failed to find Rooms,Rooms May not  Exist..!");

		}
		return roomsResponse;
	}

	@PutMapping(path = "/update.room", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public HotelManagementResponseBodyBean updateRoom(@RequestBody RoomsBean roomToUpdate) {
		HotelManagementResponseBodyBean roomsResponse = new HotelManagementResponseBodyBean();
		if(roomsServices.updateRooms(roomToUpdate)) {
			roomsResponse.setStatusCode(400);
			roomsResponse.setMessage("Success");
			roomsResponse.setDescription("Room Updated Successfuly");
		}else {
			roomsResponse.setStatusCode(401);
			roomsResponse.setMessage("Failure");
			roomsResponse.setDescription("Failed to Update Room,Room May not  Exist..!");

		}
		return roomsResponse;
	}
	
	
}



