package com.interview.hotelmanagementboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.hotelmanagementboot.dao.RoomsDAO;
import com.interview.hotelmanagementboot.dto.RoomsBean;

@Service
public class RoomServicesIMPL implements RoomsServices {

	@Autowired
	RoomsDAO roomsDao;

	@Override
	public boolean addRoom(RoomsBean room) {
		if (roomsDao.addRoom(room))
			return true;
		else
			return false;
	}

	@Override
	public List<RoomsBean> getAllRooms() {
		List<RoomsBean> rooms = roomsDao.getAllRooms();
		if (rooms != null) {
			return rooms;
		} else
			return null;
	}

	@Override
	public boolean deleteRoom(int roomID) {
		if (roomsDao.deleteRoom(roomID))
			return true;
		else
			return false;
	}

	@Override
	public boolean updateRooms(RoomsBean roomToUpdate) {
		if (roomsDao.updateRooms(roomToUpdate))
			return true;
		else
			return false;
	}

}
