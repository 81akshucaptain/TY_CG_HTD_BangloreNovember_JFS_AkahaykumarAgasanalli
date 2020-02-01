package com.capgemini.stockmanagementboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagementboot.dto.CompanyBean;
import com.capgemini.stockmanagementboot.dto.ManagerBean;

@Repository
public class ManagerDAOImpl implements ManagerDAO {

	@PersistenceUnit
	EntityManagerFactory emFactory;

	EntityTransaction etTransaction = null;
	@Override
	public List<ManagerBean> getAllManager() {
		try {
			String jpql = "from ManagerBean";
			EntityManager emManager = emFactory.createEntityManager();
			Query query = emManager.createQuery(jpql);
			List<ManagerBean> record = query.getResultList();
			emManager.close();
			if (record != null) {
				return record;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println("No data found for all manager..!try again: ");
			return null;
		}

	}

	@Override
	public boolean updateManager(int managerId, ManagerBean managerToUpdate) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			etTransaction = emManager.getTransaction();
			etTransaction.begin();

			String jpql = "update ManagerBean set managerName=:mName,managerCompany=:mCompany,"
					+ "managerPhone=:mPhone,managerEmail=:mEmail,managerCity=:mCity,"
					+ "managerPostal=:mPostal where managerID=:mID";
			Query query = emManager.createQuery(jpql);
			query.setParameter("mName", managerToUpdate.getManagerName());
			query.setParameter("mCompany", managerToUpdate.getManagerCompany());
			query.setParameter("mPhone", managerToUpdate.getManagerPhone());
			query.setParameter("mEmail", managerToUpdate.getManagerEmail());
			query.setParameter("mCity", managerToUpdate.getManagerCity());
			query.setParameter("mPostal", managerToUpdate.getManagerPostal());
			query.setParameter("mID", managerToUpdate.getManagerID());
			int result = query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("Problem in Updating manager Details, try again:");
			etTransaction.rollback();
			return false;
		}
	}


	@Override
	public boolean deleteManager(int managerId) {
		// TODO Auto-generated method stub
				try {
					EntityManager emManager = emFactory.createEntityManager();
					EntityTransaction etTransaction = emManager.getTransaction();
					etTransaction.begin();
					String jpql = "Delete from ManagerBean where managerId=:managerId";
					Query query = emManager.createQuery(jpql);
					query.setParameter("managerId", managerId);
					int result = query.executeUpdate();
					etTransaction.commit();
					emManager.close();
					if (result > 0) {
						return true;
					} else {
						return false;
					}
				} catch (Exception e) {
					System.out.println("There is problem in deleting manager: ");
					return false;
				}
			}

	@Override
	public boolean addManager(ManagerBean manager) {
		EntityTransaction transactiont = null;
		try {
			EntityManager entityManager = emFactory.createEntityManager();
			transactiont = entityManager.getTransaction();
			transactiont.begin();
			
			entityManager.persist(manager);
			transactiont.commit();
			
			entityManager.close();

			return true;
		} catch (Exception e) {
			System.out.println("Failed to Add new manager, manager May Already Exist..! ");
			transactiont.rollback();
			return false;
		}
	}
	@Override
	public ManagerBean searchManager(int managerId) {
		try {
			EntityManager eManager = emFactory.createEntityManager();
			ManagerBean managerBean = eManager.find(ManagerBean.class, managerId);
			if (managerBean != null) {
				return managerBean;
			} else {
				return null;
			}
		} catch (Exception e) {
			String message = e.getMessage();
			System.out.println("There Is Problem In Searching The manager:" + message);
		}
		return null;
	}

	@Override
	public ManagerBean searchManagerByMail(String email) {
		try {
			EntityManager eManager = emFactory.createEntityManager();
			String jpql = "from ManagerBean where managerEmail=:email";
			TypedQuery<ManagerBean> query = eManager.createQuery(jpql, ManagerBean.class);
			query.setParameter("email", email);
			ManagerBean manager = query.getSingleResult();
			if (manager != null) {
				return manager;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
