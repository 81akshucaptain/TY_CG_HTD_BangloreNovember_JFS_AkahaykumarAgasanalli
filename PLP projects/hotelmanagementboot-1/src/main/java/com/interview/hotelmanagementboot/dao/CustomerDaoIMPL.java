package com.interview.hotelmanagementboot.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.interview.hotelmanagementboot.dto.CustomerBean;
import com.interview.hotelmanagementboot.dto.User;
import com.interview.hotelmanagementboot.utilities.HotelManagementException;

@Repository
/*
 * Indicates that an annotated class is a "Repository" or DATA ACCESS OBJECT,
 * originally defined byDomain-Driven Design (Evans, 2003) as "a mechanism for
 * encapsulating storage,retrieval, and search behaviour which emulates(follow)
 * a collection of objects"
 */
public class CustomerDaoIMPL implements CustomerDAO {

	@PersistenceUnit
	/*
	 * Expresses a dependency on an EntityManagerFactory and its associated
	 * persistence unit.
	 */
	EntityManagerFactory emFactory;
	// Interface used to interact with the entity manager factory for the
	// persistence
	// unit
	EntityTransaction eTransaction = null;
	// Interface used to control transactions on resource-local entity managers. The
	// EntityManager.getTransaction() method returns the EntityTransaction
	// interface.

	@Override
	public boolean createCustomer(CustomerBean customer) {
		try {

			EntityManager eManager = emFactory.createEntityManager();
			/*
			 * Within the persistence context, the entity instances and their life cycle are
			 * managed.The EntityManager API is used to create and remove persistent entity
			 * instances, to find entities by their primary key, and to query over entities.
			 */
			eTransaction = eManager.getTransaction();
			eTransaction.begin();
			eManager.persist(customer);
			// save kind operation

			eTransaction.commit();
			eManager.close();

			return true;
		} catch (HotelManagementException e) {
			eTransaction.rollback();
			return false;
		}
	}

	@Override
	public boolean deleteCusromer(int customerId) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			eTransaction = emManager.getTransaction();

			// emManager.remove(emManager.find(CustomerBean.class, customerId));

			eTransaction.begin();
			String deleteQuery = "Delete from CustomerBean where customerID=:customerID";
			Query jpql = emManager.createQuery(deleteQuery);
			jpql.setParameter("customerID", customerId);
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
	public boolean updateCustomer(CustomerBean customer) {
		try {
			EntityManager emEntityManager = emFactory.createEntityManager();
			eTransaction = emEntityManager.getTransaction();
			eTransaction.begin();
			String jpql = "update CustomerBean set email=:newEmail,name=:newName,phone=:newPhone,place=:newPlace where customerID=:customerId";
			Query query = emEntityManager.createQuery(jpql);
			query.setParameter("newEmail", customer.getEmail());
			query.setParameter("newName", customer.getName());
			query.setParameter("newPhone", customer.getPhone());
			query.setParameter("newPlace", customer.getPlace());
			query.setParameter("customerId", customer.getCustomerID());
			int result = query.executeUpdate();
			eTransaction.commit();
			emEntityManager.close();
			if (result > 0)
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			eTransaction = emManager.getTransaction();
			eTransaction.begin();
			String customerQuery = "from CustomerBean";
			Query jpql = emManager.createQuery(customerQuery);
			List<CustomerBean> customerResult = jpql.getResultList();
			eTransaction.commit();
			emManager.close();

			if (customerResult != null)
				return customerResult;
			else
				return null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean createAccount(User loginBean) {

		try {

			EntityManager eManager = emFactory.createEntityManager();

			eTransaction = eManager.getTransaction();
			eTransaction.begin();
			eManager.persist(loginBean);

			eTransaction.commit();
			eManager.close();

			return true;
		} catch (HotelManagementException e) {
			eTransaction.rollback();
			return false;
		}
	}

	@Override
	public boolean login(User loginBean) {
		try {
			String uName = loginBean.getUsername();

			String jpql = "from LoginBean where userName=:uName";
			EntityManager emManager = emFactory.createEntityManager();
			Query query = emManager.createQuery(jpql);
			query.setParameter("uName", uName);
			User record = (User) query.getSingleResult();
			if (record != null) {
				if (record.getPassword().equals(loginBean.getPassword()))
					return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return false;

	}

	@Override
	public User findByUsername(String username) {
		try {

			String jpql = "from LoginBean where userName=:uName";
			EntityManager emManager = emFactory.createEntityManager();
			Query query = emManager.createQuery(jpql);
			query.setParameter("uName", username);
			User record = (User) query.getSingleResult();
			return record;
		} catch (Exception e) {
		 throw new HotelManagementException("User NOT FOUND");
		}
	}

	
}
