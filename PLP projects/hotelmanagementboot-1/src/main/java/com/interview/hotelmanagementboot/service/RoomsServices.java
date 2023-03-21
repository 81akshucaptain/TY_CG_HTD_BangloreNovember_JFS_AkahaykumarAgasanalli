package com.interview.hotelmanagementboot.service;

import java.util.List;

import com.interview.hotelmanagementboot.dto.RoomsBean;

public interface RoomsServices {
	public boolean addRoom(RoomsBean room);

	public boolean deleteRoom(int roomID);

	public List<RoomsBean> getAllRooms();

	public boolean updateRooms(RoomsBean roomToUpdate);
}
