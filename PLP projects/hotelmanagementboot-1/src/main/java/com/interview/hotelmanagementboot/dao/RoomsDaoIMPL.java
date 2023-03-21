package com.interview.hotelmanagementboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.hotelmanagementboot.dto.User;
import com.interview.hotelmanagementboot.dto.RoomsBean;

@Repository
public class RoomsDaoIMPL implements RoomsDAO {
	@PersistenceUnit
	EntityManagerFactory emFactory;

	EntityTransaction eTransaction = null;

	@Override
	public boolean addRoom(RoomsBean room) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			eTransaction = emManager.getTransaction();
			eTransaction.begin();
			emManager.persist(room);
			eTransaction.commit();
			emManager.close();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public List<RoomsBean> getAllRooms() {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			eTransaction = emManager.getTransaction();
			eTransaction.begin();
			String jpql = "from RoomsBean";
			Query query = emManager.createQuery(jpql);
			List<RoomsBean> rooms = query.getResultList();
			eTransaction.commit();
			emManager.close();
			if (rooms != null)
				return rooms;
			else
				return null;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean deleteRoom(int roomIDtoDelete) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			eTransaction = emManager.getTransaction();
			eTransaction.begin();
			String jpql = "delete from RoomsBean where roomId=:roomID";
			Query query = emManager.createQuery(jpql);
			query.setParameter("roomID", roomIDtoDelete);
			int result=query.executeUpdate();
			eTransaction.commit();
			emManager.close();
			if (result>0)
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateRooms(RoomsBean roomToUppdate) {
		try {
			EntityManager emEntityManager = emFactory.createEntityManager();
			eTransaction = emEntityManager.getTransaction();
			eTransaction.begin();
			String jpql = "update RoomsBean set roomType=:newroomType,roomRent=:newroomRent,"
					+ "roomSize=:newroomSize,roomStatus=:newroomStatus,roomImage=:newRoomImage where roomId=:roomID";
			Query query = emEntityManager.createQuery(jpql);
			query.setParameter("newroomType", roomToUppdate.getRoomType());
			query.setParameter("newroomRent", roomToUppdate.getRoomRent());
			query.setParameter("newroomSize", roomToUppdate.getRoomSize());
			query.setParameter("newroomStatus", roomToUppdate.getRoomStatus());
			query.setParameter("newRoomImage", roomToUppdate.getRoomImage());
			query.setParameter("roomID", roomToUppdate.getRoomId());
			int result = query.executeUpdate();
			eTransaction.commit();
			emEntityManager.close();
			if (result > 0)
				return true;
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
