package com.capgemini.forestmanagementjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestmanagementjpa.dto.CustomerBean;

public class CustomerDAOImpl implements CustomerDAO {
	EntityTransaction etTransaction = null;

	public List<CustomerBean> getAllCustomer() {
		try {
			String jpql = "from CustomerBean";
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("TestPersistence");
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
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager = emFactory.createEntityManager();
			etTransaction = emManager.getTransaction();
			etTransaction.begin();

			String jpql = "update CustomerBean set name=:name,town=:town,postal=:postal,email=:email"
					+ ",phone=:phone,password=:pswd where customerId=:customerId";
			Query query = emManager.createQuery(jpql);
			query.setParameter("name", CustomerToUpdate.getName());
			query.setParameter("town", CustomerToUpdate.getTown());
			query.setParameter("postal", CustomerToUpdate.getPostal());
			query.setParameter("email", CustomerToUpdate.getEmail());
			query.setParameter("phone", CustomerToUpdate.getPhone());
			query.setParameter("pswd", CustomerToUpdate.getPassword());
			query.setParameter("customerId", CustomerToUpdate.getCustomerId());
			int result = query.executeUpdate();
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

	public boolean deleteCustomer(int customerIdTodelete) {
		try {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager = emFactory.createEntityManager();
			EntityTransaction etTransaction = emManager.getTransaction();
			etTransaction.begin();
			String jpql = "Delete from CustomerBean where customerId=:customerId";
			Query query = emManager.createQuery(jpql);
			query.setParameter("customerId", customerIdTodelete);
			int result = query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("There is problem in deleting Customer: ");
			return false;
		}
	}

	public boolean addCustomer(CustomerBean customer) {
		EntityTransaction transactiont = null;
		try {
			// persistence class is bootstrap class helps us create obj
			// createEntityManagerFactory created only once in life
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			// EM is interface which is used to communicate with db
			EntityManager entityManager = entityManagerFactory.createEntityManager();
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

	public CustomerBean searchCustomer(int customerIdToSearch) {
		try {
			EntityManagerFactory eMFactory = Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager eManager = eMFactory.createEntityManager();
			CustomerBean cbBean = eManager.find(CustomerBean.class, customerIdToSearch);
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

	public boolean customerlogin(int customerIdToLogin, String password) {
		try {
			EntityManagerFactory eMFactory = Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager eManager = eMFactory.createEntityManager();
			CustomerBean cbBean = eManager.find(CustomerBean.class, customerIdToLogin);
			if ((cbBean.getCustomerId() == customerIdToLogin) && (cbBean.getPassword().equals(password))) {
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
