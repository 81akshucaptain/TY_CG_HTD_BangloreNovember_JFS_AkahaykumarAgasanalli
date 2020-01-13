package com.capgemini.forestmanagementrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementrest.dto.CustomerBean;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@PersistenceUnit
	EntityManagerFactory emFactory;
	
	EntityTransaction etTransaction = null;

	public List<CustomerBean> getAllCustomer() {
		try {
			String jpql = "from CustomerBean";
			EntityManager emManager = emFactory.createEntityManager();
			Query query = emManager.createQuery(jpql);
			List<CustomerBean> record = query.getResultList();
			emManager.close();
			if (record != null) {
				return record;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println("No data found for all Customers..!try again: ");
			return null;
		}

	}

	public boolean updateCustomer(CustomerBean CustomerToUpdate) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			etTransaction = emManager.getTransaction();
			etTransaction.begin();

			String jpql = "update CustomerBean set name=:name,town=:town,postal=:postal,email=:email,phone=:phone where cid=:cid";
			Query q = emManager.createQuery(jpql);
			q.setParameter("name", CustomerToUpdate.getName());
			q.setParameter("town", CustomerToUpdate.getTown());
			q.setParameter("postal", CustomerToUpdate.getPostal());
			q.setParameter("email", CustomerToUpdate.getEmail());
			q.setParameter("phone", CustomerToUpdate.getPhone());
			q.setParameter("cid", CustomerToUpdate.getCid());
			int result = q.executeUpdate();
			etTransaction.commit();
			emManager.close();

			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("Problem in Updating Customer Details, try again:");
			etTransaction.rollback();
			return false;
		}
	}

	public boolean deleteCustomer(int cidTodelete) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			EntityTransaction etTransaction = emManager.getTransaction();
			etTransaction.begin();
			String jpql = "Delete from CustomerBean where cid=:cid";
			Query query = emManager.createQuery(jpql);
			query.setParameter("cid", cidTodelete);
			int result = query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("There is problem in deleting Customer: " );
			return false;
		}
	}

	public boolean addCustomer(CustomerBean customer) {
		EntityTransaction transactiont = null;
		try {
			// persistence class is bootstrap class helps us create obj
			// createEntityManagerFactory created only once in life
			// EM is interface which is used to communicate with db
			String password=customer.getEmail()+customer.getPostal();
			customer.setPassword(password);
			EntityManager entityManager = emFactory.createEntityManager();
			// to deal with overall transaction we need this line and respective methods
			transactiont = entityManager.getTransaction();
			transactiont.begin();
			// to insert record we have to pass the object reference.
			entityManager.persist(customer);
			transactiont.commit();
			entityManager.close();
			return true;
		} catch (Exception e) {
			System.out.println("Failed to Add new Customer. Custtomer May Already Exist..! ");
			// to roll back the data enterd to the db if somethig bad happence
			transactiont.rollback();
			return false;

		}
	}

	public CustomerBean searchCustomer(int cid) {
		try {
			EntityManager eManager = emFactory.createEntityManager();
			CustomerBean cbBean = eManager.find(CustomerBean.class, cid);
			if (cbBean != null) {
				return cbBean;
			} else {
				return null;
			}
		} catch (Exception e) {
			String message = e.getMessage();
			System.out.println("There Is Problem In Searching The Contract:" + message);
		}
		return null;
	}

	public boolean customerlogin(int cid, String password) {
		try {
			EntityManager eManager = emFactory.createEntityManager();
			CustomerBean cbBean = eManager.find(CustomerBean.class, cid);
			if ((cbBean.getCid() == cid) && (cbBean.getPassword().equals(password))) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Invalid UserID or Password, Please try again!");
			return false;
		}
	}

}
