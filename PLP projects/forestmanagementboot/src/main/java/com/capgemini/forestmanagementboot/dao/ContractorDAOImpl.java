package com.capgemini.forestmanagementboot.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementboot.dto.ContractorBean;
@Repository
public class ContractorDAOImpl implements ContractorDAO{
	
	@PersistenceUnit
	EntityManagerFactory eFactory;
	EntityTransaction etTransaction=null;

	public List<ContractorBean> getAllContarctor() {
		try{
			String jpql="from ContractorBean";
			EntityManager emManager=eFactory.createEntityManager();
			Query query=emManager.createQuery(jpql);
			List<ContractorBean> record=query.getResultList();
			if(record!=null) {
				return record;
			}else
				return null;
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("No data found for Contracts..!try again: "+message);
			return null;
		}

	}


	@Override
	//ACCESSED BY ONLY PARTICULAR CUSTOMER
	public List<ContractorBean> getAllContarctor(int customerId) {
		try{
			String jpql="from ContractorBean where customerId=:cid";
			EntityManager emManager=eFactory.createEntityManager();
			Query query=emManager.createQuery(jpql);
			query.setParameter("cid", customerId);
			List<ContractorBean> record=query.getResultList();
			if(record!=null) {
				return record;
			}else {
				return null;
			}
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("No data found for Contracts..!try again: "+message);
			return null;
		}

	}


	@Override
	public boolean updateContarctor(int cid, ContractorBean contarctorToUpdate) {
		try{
			EntityManager emManager=eFactory.createEntityManager();
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="update ContractorBean set customerId=:cid,productId=:pid,"
					+ "haulierId=:hid,deliveryDate=:ddate,qunatity=:qty where contractId=:ctid";
			Query query=emManager.createQuery(jpql);
			query.setParameter("cid",contarctorToUpdate.getCustomerId());
			query.setParameter("pid",contarctorToUpdate.getProductId());
			query.setParameter("hid", contarctorToUpdate.getHaulierId());
			query.setParameter("ddate",contarctorToUpdate.getDeliveryDate());
			query.setParameter("qty", contarctorToUpdate.getQunatity());
			query.setParameter("ctid",cid);
			int result=query.executeUpdate();
			etTransaction.commit();

			if(result>0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("There is problem in updating the contract, try again:"+message);
			etTransaction.rollback();
			return false;
		}
	}

	@Override
	public boolean deletecontarctor(int cidToDelete) {
		try{
			EntityManager emManager=eFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="Delete from ContractorBean where contractId=:cid";
			Query q=emManager.createQuery(jpql);
			q.setParameter("cid", cidToDelete);
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
			System.out.println("There Is No Such Contract-Id: "+message);
			return false;
		}
	}

	@Override
	public boolean addContarctor(ContractorBean contractor) {
		EntityTransaction transactiont=null;
		try {
			//persistence class is bootstrap class helps us create obj
			//createEntityManagerFactory created only once in life
			//EM is interface which is used to communicate with db
			EntityManager entityManager=eFactory.createEntityManager();
			//to deal with overall transaction we need   this line and respective methods
			transactiont=entityManager.getTransaction();
			transactiont.begin();
			//to insert record we have to pass the object reference.
			entityManager.persist(contractor);
			transactiont.commit();
			entityManager.close();
			return true;
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("Failed to Add new Contract Details..! ContractID may exist, try again :"+message);
			//to roll back the data entered to the db if something bad happense
			transactiont.rollback();
			return false;
		}
	}
	@Override
	public ContractorBean searchContarctor(int contractIdToSearch) {
		try{
			EntityManager emManager=eFactory.createEntityManager();
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			ContractorBean contractBean=emManager.find(ContractorBean.class, contractIdToSearch);
			etTransaction.commit();
			if(contractBean!=null) {
				return contractBean;
			}else {
				return null;
			}
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("There Is No Such Contract Id,Try again:"+message);
			return null;
		}
	}


}
