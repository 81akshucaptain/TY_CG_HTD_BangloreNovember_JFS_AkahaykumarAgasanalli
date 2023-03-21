package com.interview.hotelmanagementboot.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Room")
public class RoomsBean implements Serializable {
	@Id
	@GeneratedValue
	@Column(nullable = false, unique = true)
	private int roomId;
	@Column(nullable = false)
	private String roomType;
	@Column
	private String roomSize;
	@Column
	private String roomRent;
	@Column
	private String roomStatus;
	@Column
	private String roomImage;

	public String getRoomImage() {
		return roomImage;
	}

	public void setRoomImage(String roomImage) {
		this.roomImage = roomImage;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomRent() {
		return roomRent;
	}

	public void setRoomRent(String roomRent) {
		this.roomRent = roomRent;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(String roomSize) {
		this.roomSize = roomSize;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "RoomsBean [roomId=" + roomId + "" + ", roomType=" + roomType + ", " + "roomSize=" + roomSize + ","
				+ " roomRent=" + roomRent + "]";
	}

}
