package com.capgemini.stockmanagementboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagementboot.dto.InvesterBean;
import com.capgemini.stockmanagementboot.dto.ManagerBean;

@Repository
public class InvesterDAOImpl implements InvesterDAO {

	@PersistenceUnit
	EntityManagerFactory emFactory;

	EntityTransaction etTransaction = null;

	@Override
	public List<InvesterBean> getAllInvesters() {
		try {
			String jpql = "from InvesterBean";
			EntityManager emManager = emFactory.createEntityManager();
			Query query = emManager.createQuery(jpql);
			List<InvesterBean> record = query.getResultList();
			emManager.close();
			if (record != null) {
				return record;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println("No data found for all invester..!try again: ");
			return null;
		}

	}

	@Override
	public boolean updateInvesters(int investerId, InvesterBean investerToUpdate) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			etTransaction = emManager.getTransaction();
			etTransaction.begin();

			String jpql = "update InvesterBean set investerName=:iName,investerEmail=:iEmail,"
					+ "investerPhone=:iPhone,investerCity=:iCity,"
					+ "investerPostal=:iPostal where investerID=:iID";
			Query query = emManager.createQuery(jpql);
			query.setParameter("iName", investerToUpdate.getInvesterName());
			query.setParameter("iEmail", investerToUpdate.getInvesterEmail());
			query.setParameter("iPhone", investerToUpdate.getInvesterPhone());
			query.setParameter("iCity", investerToUpdate.getInvesterCity());
			query.setParameter("iPostal", investerToUpdate.getInvesterPostal());
			query.setParameter("iID", investerToUpdate.getInvesterID());
			int result = query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("Problem in Updating Invester Details, try again:"+e.getMessage());
			etTransaction.rollback();
			return false;
		}
	}

	@Override
	public boolean deleteInvester(int investerId) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			EntityTransaction etTransaction = emManager.getTransaction();
			etTransaction.begin();
			String jpql = "Delete from InvesterBean where investerId=:investerId";
			Query query = emManager.createQuery(jpql);
			query.setParameter("investerId", investerId);
			int result = query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("There is problem in deleting invester ");
			return false;
		}
	}

	@Override
	public boolean addInvester(InvesterBean invester) {
		EntityTransaction transactiont = null;
		try {
			EntityManager entityManager = emFactory.createEntityManager();
			transactiont = entityManager.getTransaction();
			transactiont.begin();

			entityManager.persist(invester);
			transactiont.commit();

			entityManager.close();

			return true;
		} catch (Exception e) {
			System.out.println("Failed to Add new invester, invester May Already Exist..! ");
			transactiont.rollback();
			return false;
		}
	}

	@Override
	public InvesterBean searchInvester(int investerId) {
		try {
			EntityManager eManager = emFactory.createEntityManager();
			InvesterBean investerBean = eManager.find(InvesterBean.class, investerId);
			if (investerBean != null) {
				return investerBean;
			} else {
				return null;
			}
		} catch (Exception e) {
			String message = e.getMessage();
			System.out.println("There Is Problem In Searching The invester:" + message);
		}
		return null;
	}

	@Override
	public InvesterBean searchInvesterByEmail(String investerEmail) {
		try {
			EntityManager eManager = emFactory.createEntityManager();
			String jpql = "from InvesterBean where investerEmail=:investerEmail";
			TypedQuery<InvesterBean> query = eManager.createQuery(jpql, InvesterBean.class);
			query.setParameter("investerEmail", investerEmail);
			InvesterBean invester = query.getSingleResult();
			if (invester != null) {
				return invester;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("problem in searching invester name :" + e.getMessage());
			return null;
		}
	}
}