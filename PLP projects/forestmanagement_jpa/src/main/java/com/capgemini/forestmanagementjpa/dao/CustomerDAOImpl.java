package com.capgemini.forestmanagementjpa.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestmanagementjpa.dto.CustomerBean;

public class CustomerDAOImpl implements CustomerDAO {
	EntityTransaction etTransaction=null;
	public void getAllCustomer() {
		try{
			String jpql="from CustomerBean";
			EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=emFactory.createEntityManager();
			Query query=emManager.createQuery(jpql);
			List<CustomerBean> record=query.getResultList();
			System.out.println("        ::::CUSTOMER DETAILS ARE::::");
			for (CustomerBean customer : record) {
				System.out.println("CID= "+customer.getCid());
				System.out.println("NAME= "+customer.getName());
				System.out.println("TOWN= "+customer.getTown());
				System.out.println("POSTAL= "+customer.getPostal());
				System.out.println("EMIAL= "+customer.getEmail());
				System.out.println("PHONE= "+customer.getPhone());
			}
			emManager.close();
		}catch (Exception e) {
			String message=e.getMessage();
			System.err.println("No data found for all Customers..!try again"+message);
		}

	}

	public boolean updateCustomer(CustomerBean CustomerToUpdate) {
		try{
			EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=emFactory.createEntityManager();
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			//HARD CODING
			/*String jpql="update CustomerBean set name='paramatma' where MID=5";
		Query q=emManager.createQuery(jpql);
		int re=q.executeUpdate();
		etTransaction.commit();*/
			//DYNAMIC values
			String jpql="update CustomerBean set name=:name,town=:town,postal=:postal,email=:email,phone=:phone where cid=:cid";
			Query q=emManager.createQuery(jpql);
			q.setParameter("name",CustomerToUpdate.getName());
			q.setParameter("town", CustomerToUpdate.getTown());
			q.setParameter("postal", CustomerToUpdate.getPostal());
			q.setParameter("email", CustomerToUpdate.getEmail());
			q.setParameter("phone", CustomerToUpdate.getPhone());
			q.setParameter("cid", CustomerToUpdate.getCid());
			int result=q.executeUpdate();
			etTransaction.commit();
			emManager.close();

			if(result>0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			String message=e.getMessage();
			System.err.println("Problem in Updating Customer Details, try again:"+message);
			etTransaction.rollback();
			return false;
		}
	}



	public boolean deleteCustomer(int cidTodelete) {
		try{
			EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=emFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="Delete from CustomerBean where cid=cid";
			Query query=emManager.createQuery(jpql);
			query.setParameter("cid", cidTodelete);
			int result=query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if(result>0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("There is problem in deleting Customer: "+message);
			return false;
		}
	}
	public void addCustomer(CustomerBean customer) {
		EntityTransaction transactiont=null;
		try {
			//persistence class is bootstrap class helps us create obj
			//createEntityManagerFactory created only once in life
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
			//EM is interface which is used to communicate with db
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			//to deal with overall transaction we need   this line and respective methods
			transactiont=entityManager.getTransaction();
			transactiont.begin();
			//TO INSERT RECORD WE HAVE TO PASS THE obj reff.
			entityManager.persist(customer);
			System.out.println("Customer Added successfully");
			transactiont.commit();
			entityManager.close();
		}catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			System.out.println("Failed to Add new Customer...! :"+message);
			//TO ROLL BACK THE DATA ENTERD TO THE DB IF SOMETHIG BAD HAPPENCE
			transactiont.rollback();
		}
	}

	public void searchCustomer(int cid) {
		try{
			EntityManagerFactory eMFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager eManager=eMFactory.createEntityManager();
			CustomerBean cbBean=eManager.find(CustomerBean.class, cid);
			if(cbBean!=null) {
			System.out.println("        ::::CUSTOMER DETAILS ARE::::");
			System.out.println("CUSTOMER-ID= "+cbBean.getCid());
			System.out.println("NAME= "+cbBean.getName());
			System.out.println("TOWN= "+cbBean.getTown());
			System.out.println("POSTAL= "+cbBean.getPostal());
			System.out.println("EMIAL= "+cbBean.getEmail());
			System.out.println("PHONE= "+cbBean.getPhone());
			}else {
				System.out.println("Customer Not Found..! try again");
			}
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("There is problem in Searching Contracts"+message);
		}
	}

	public boolean customerlogin(int cid, String email) {
		try{
			EntityManagerFactory eMFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager eManager=eMFactory.createEntityManager();
			CustomerBean cbBean=eManager.find(CustomerBean.class, cid);
			if((cbBean.getCid()==cid)&&(cbBean.getEmail().equals(email))){
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("There is problem in Searching Customer: "+message);
			return false;
		}
	}


}
