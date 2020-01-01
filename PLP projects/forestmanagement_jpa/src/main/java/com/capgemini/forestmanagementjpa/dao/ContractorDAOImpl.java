package com.capgemini.forestmanagementjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestmanagementjpa.dto.ContractorBean;
import com.capgemini.forestmanagementjpa.dto.CustomerBean;

public class ContractorDAOImpl implements ContractorDAO{
	EntityManagerFactory eFactory=null;
	EntityTransaction etTransaction=null;
	@Override
	public void getAllContarctor() {
		try{
			String jpql="from CustomerBean";
			EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=emFactory.createEntityManager();
			Query query=emManager.createQuery(jpql);
			List<ContractorBean> record=query.getResultList();
			System.out.println("        ::::CUSTOMER DETAILS ARE::::");
			for (ContractorBean contractor : record) {
				System.out.println("CONTRACT-ID= "+contractor.getContractId());
				System.out.println("CUSTOMER-ID="+contractor.getCustomerId());
				System.out.println("PRODUCT-ID="+contractor.getProductId());
				System.out.println("DELIVEY-DATE="+contractor.getDeliveryDate());
				System.out.println("DEMANDED-QUANTITY= "+contractor.getQunatity());
				System.out.println("HUALIER-ID= "+contractor.getHaulierId());
			}
		}catch (Exception e) {
			System.err.println("No data found for all Customers..!try again");
		}

	}


	@Override
	public boolean updateContarctor(int cid, ContractorBean contarctorToUpdate) {
		try{
			eFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=eFactory.createEntityManager();
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="update ContractBean set customerId=:cid,productId=:pid,"
					+ "haulierId=:hid,deliveryDate=:ddate,qunatity=qty where contractId=:ctid";
			Query query=emManager.createQuery(jpql);
			query.setParameter("cid",contarctorToUpdate.getCustomerId());
			query.setParameter("pid",contarctorToUpdate.getProductId());
			query.setParameter("hid", contarctorToUpdate.getHaulierId());
			query.setParameter("ddate", contarctorToUpdate.getDeliveryDate());
			query.setParameter("qty", contarctorToUpdate.getQunatity());
			query.setParameter("ctid", contarctorToUpdate.getContractId());
			int result=query.executeUpdate();
			etTransaction.commit();

			if(result>0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("There is problem in updating the record, try again"+message);
			etTransaction.rollback();
			return false;
		}
	}

	@Override
	public boolean deletecontarctor(int cid) {
		try{
			EntityManagerFactory emFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=emFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="Delete from ContractBean where cid=cid";
			Query q=emManager.createQuery(jpql);
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
			System.out.println("Contract Added successfully");
			transactiont.commit();
			entityManager.close();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			System.out.println("Failed to Add new Contract Details...! :"+message);
			//TO ROLL BACK THE DATA ENTERD TO THE DB IF SOMETHIG BAD HAPPENCE
			transactiont.rollback();
			return false;
		}
	}
	@Override
	public ContractorBean searchContarctor(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

}
