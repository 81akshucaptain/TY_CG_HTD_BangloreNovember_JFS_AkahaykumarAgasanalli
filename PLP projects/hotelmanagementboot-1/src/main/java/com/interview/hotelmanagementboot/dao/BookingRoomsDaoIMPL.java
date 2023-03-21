package com.interview.hotelmanagementboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.interview.hotelmanagementboot.dto.BookRoom;

@Repository
public class BookingRoomsDaoIMPL implements BookingRoomsDAO {

	@PersistenceUnit
	EntityManagerFactory emFactory;

	EntityTransaction eTransaction;

	@Override
	
	public boolean bookTheRoom(BookRoom bookRoom) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			eTransaction = emManager.getTransaction();
			eTransaction.begin();
			emManager.persist(bookRoom);
			eTransaction.commit();
			emManager.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean removeTheBooking(int bookingID) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			eTransaction = emManager.getTransaction();
			eTransaction.begin();
			String deleteQuery = "Delete from BookRoom where bookingID=:bookingId";
			Query jpql = emManager.createQuery(deleteQuery);
			jpql.setParameter("bookingId", bookingID);
			int deleteResult = jpql.executeUpdate();
			eTransaction.commit();
			emManager.close();
			if (deleteResult > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public List<BookRoom> getTheBookingsForCustomer(int customerId) {
		try {
			EntityManager eManager = emFactory.createEntityManager();
			eTransaction=eManager.getTransaction();
			eTransaction.begin();
			Integer customerID1=customerId;
			String customerID2=customerID1.toString();
			String jpql = "from BookRoom where customerID=:cID";
			Query query = eManager.createQuery(jpql);
			query.setParameter("cID", customerID2);
			List<BookRoom> result = query.getResultList();
			if (result != null) {
				return result;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<BookRoom> getTheBookingsAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

}
