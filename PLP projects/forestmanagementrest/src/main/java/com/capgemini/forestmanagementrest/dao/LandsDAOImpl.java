package com.capgemini.forestmanagementrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementrest.dto.LandsBean;

@Repository
public class LandsDAOImpl implements LandsDAO{
	
	@PersistenceUnit
	EntityManagerFactory emFactory;
	
	EntityTransaction etTransaction=null;
	
	@Override
	public List<LandsBean> getAllLands() {
		try{
			String jpql="from LandsBean";
			EntityManager emManager=emFactory.createEntityManager();
			Query query=emManager.createQuery(jpql);
			List<LandsBean> records=query.getResultList();
		if(records!=null) {
			return records;
		}else {
			return null;
		}
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("No data for Lands,try again..! "+message);
			return null;
		}
	}



	@Override
	public boolean updateLands(int lid, LandsBean landToUpdate) {
		try{
			EntityManager emManager=emFactory.createEntityManager();
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
			System.out.println("There is problem in updating the Land details, try again"+message);
			etTransaction.rollback();
			return false;
		}
	}
	@Override
	public boolean deleteLands(int lid) {
		try{
			EntityManager emManager=emFactory.createEntityManager();
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
			EntityManager emManager=emFactory.createEntityManager();
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			emManager.persist(Land);
			etTransaction.commit();
			emManager.close();
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
			EntityManager emManager=emFactory.createEntityManager();
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			LandsBean landsBean=emManager.find(LandsBean.class, lid);
			etTransaction.commit();
			if(landsBean!=null) {
				return landsBean;
			}else {
				return null;
			}
		}catch (Exception e) {
			String message=e.getMessage();
			System.out.println("Problem in finding the Land details, Not found, Try again:"+message);
			return null;
		}
	}
}
