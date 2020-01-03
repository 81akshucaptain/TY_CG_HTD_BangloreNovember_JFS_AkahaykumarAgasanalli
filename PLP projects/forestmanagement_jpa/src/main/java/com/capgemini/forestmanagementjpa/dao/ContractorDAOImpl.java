package com.capgemini.forestmanagementjpa.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestmanagementjpa.dto.ContractorBean;
import com.capgemini.forestmanagementjpa.dto.CustomerBean;
import com.capgemini.forestmanagementjpa.dto.LandsBean;

public class ContractorDAOImpl implements ContractorDAO{
	EntityManagerFactory eFactory=null;
	EntityTransaction etTransaction=null;

	public void getAllContarctor() {
		try{
			String jpql="from ContractorBean";
			EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=emFactory.createEntityManager();
			Query query=emManager.createQuery(jpql);
			List<ContractorBean> record=query.getResultList();
			System.out.println("                               ::::CONTRACTOR DETAILS ARE::::");
			for (ContractorBean contractor : record) {
				System.out.println("CONTRACT-ID     = "+contractor.getContractId());
				System.out.println("CUSTOMER-ID     ="+contractor.getCustomerId());
				System.out.println("PRODUCT-ID      ="+contractor.getProductId());
				System.out.println("DELIVEY-DATE    ="+contractor.getDeliveryDate());
				System.out.println("PRODUCT-QUANTITY= "+contractor.getQunatity());
				System.out.println("HUALIER-ID      = "+contractor.getHaulierId());
				System.out.println("===========================================================");
			}
		}catch (Exception e) {
			System.out.println("No data found for Contracts..!try again");
		}

	}


	@Override
	//ACCESSED BY ONLY PARTICULAR CUSTOMER
	public void getAllContarctor(int customerId) {
		try{
			String jpql="from ContractorBean where customerId=:cid";
			EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=emFactory.createEntityManager();
			Query query=emManager.createQuery(jpql);
			query.setParameter("cid", customerId);
			List<ContractorBean> record=query.getResultList();
			System.out.println("                ::::CONTRACTOR DETAILS FOR CUSTOMER_ID = "+customerId+"::::");
			if(record!=null) {
				for (ContractorBean contractor : record) {
					System.out.println("CONTRACT-ID= "+contractor.getContractId());
					System.out.println("CUSTOMER-ID="+contractor.getCustomerId());
					System.out.println("PRODUCT-ID="+contractor.getProductId());
					System.out.println("DELIVEY-DATE="+contractor.getDeliveryDate());
					System.out.println("DEMANDED-QUANTITY= "+contractor.getQunatity());
					System.out.println("HUALIER-ID= "+contractor.getHaulierId());
					System.out.println("===========================================================");
				}
			}else {
				System.out.println("No Contract Deatils Found For Customer_Id: "+customerId);
			}
		}catch (Exception e) {
			System.out.println("No data found for Contracts..!try again");
		}

	}


	@Override
	public boolean updateContarctor(int cid, ContractorBean contarctorToUpdate) {
		try{
			eFactory=Persistence.createEntityManagerFactory("TestPersistence");
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
			EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=emFactory.createEntityManager();
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
			System.out.println("There is problem in deleting contract: "+message);
			return false;
		}
	}

	@Override
	public boolean addContarctor(ContractorBean contractor) {
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
			entityManager.persist(contractor);
			System.out.println("Done with Adding");
			transactiont.commit();
			entityManager.close();
			return true;
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("Failed to Add new Contract Details..! ContractID may exist, try again :"+message);
			//TO ROLL BACK THE DATA ENTERD TO THE DB IF SOMETHIG BAD HAPPENCE
			transactiont.rollback();
			return false;
		}
	}
	@Override
	public ContractorBean searchContarctor(int contractIdToSearch) {
		try{
			eFactory=Persistence.createEntityManagerFactory("TestPersistence");
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
			System.out.println("Problem in finding the Contract,Try again:"+message);
			return null;
		}
	}


}
