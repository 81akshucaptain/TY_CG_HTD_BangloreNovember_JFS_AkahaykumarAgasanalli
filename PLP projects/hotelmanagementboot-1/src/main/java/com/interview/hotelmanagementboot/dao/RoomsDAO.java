package com.interview.hotelmanagementboot.dao;

import java.util.List;

import com.interview.hotelmanagementboot.dto.RoomsBean;

public interface RoomsDAO {
	public boolean addRoom(RoomsBean room);

	public boolean deleteRoom(int roomID);

	public List<RoomsBean> getAllRooms();

	public boolean updateRooms(RoomsBean roomToUppdate);
}
