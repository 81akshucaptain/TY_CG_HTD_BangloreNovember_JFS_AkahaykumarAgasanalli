package com.capgemini.forestmanagementjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.forestmanagementjpa.dto.LandsBean;
import com.capgemini.forestmanagementjpa.dto.ProductBean;

public class LandsDAOImpl implements LandsDAO{
	EntityManagerFactory eFactory=null;
	EntityTransaction etTransaction=null;
	@Override
	public void getAllLands() {
		try{
			String jpql="from LandsBean";
			eFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=eFactory.createEntityManager();
			Query query=emManager.createQuery(jpql);
			List<LandsBean> records=query.getResultList();
			for (LandsBean landBean : records) {
				System.out.println(landBean);
			}
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("No data for Products,try again..!");
		}
	}



	@Override
	public boolean updateLands(int lid, LandsBean landToUpdate) {
		try{
			eFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=eFactory.createEntityManager();
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="update LandsBean set landSize=:lsize,landResources=:lresources,"
					+ "landLocation=:llocation where landId=:landid";
			Query query=emManager.createQuery(jpql);
			query.setParameter("lsize",landToUpdate.getLandSize());
			query.setParameter("lresources",landToUpdate.getLandResources());
			query.setParameter("llocation", landToUpdate.getLandLocation());
			query.setParameter("landid", landToUpdate.getLandId());
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
	public boolean deleteLands(int lid) {
		try{
			eFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=eFactory.createEntityManager();
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			LandsBean lbBean=emManager.find(LandsBean.class, lid);
			emManager.remove(lbBean);
			etTransaction.commit();
			return true;
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("Failed to Find Land, try again: "+message);
			return false;
		}
	}

	@Override
	public boolean addLands(LandsBean Land) {
		try{
			eFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=eFactory.createEntityManager();
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			emManager.persist(Land);
			etTransaction.commit();
			return true;
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("Failed to add land details, try again: "+message);
			return false;
		}
	}

	@Override
	public LandsBean searchLands(int lid) {
		try{
			eFactory=Persistence.createEntityManagerFactory("TestPersistence");
			EntityManager emManager=eFactory.createEntityManager();
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			LandsBean landsBean=emManager.find(LandsBean.class, lid);
			etTransaction.commit();
			return landsBean;
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("Problem in finding the productId, Not found, Try again");
			return null;
		}
	}
}
