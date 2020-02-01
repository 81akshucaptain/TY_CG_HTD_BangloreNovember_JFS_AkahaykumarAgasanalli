package com.capgemini.stockmanagementboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagementboot.dto.ManagerBean;
import com.capgemini.stockmanagementboot.dto.StocksBean;

@Repository
public class StocksDAOImpl implements StocksDAO {

	@PersistenceUnit
	EntityManagerFactory emFactory;

	EntityTransaction etTransaction = null;

	@Override
	public List<StocksBean> getAllStocks() {
		try {
			String jpql = "from StocksBean";
			EntityManager emManager = emFactory.createEntityManager();
			Query query = emManager.createQuery(jpql);
			List<StocksBean> record = query.getResultList();
			emManager.close();
			if (record != null) {
				return record;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println("No data found for all stocks..!try again: ");
			return null;
		}

	}

	@Override
	public boolean updateStocks(int stockId, StocksBean stocksToUpdate) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			etTransaction = emManager.getTransaction();
			etTransaction.begin();

			String jpql = "update StocksBean set companyID=:cID,currentPrice=:cPrice,"
					+ "lastPrice=:lPrice,changePercentage=:cPercentage,availableStocks=:aStocks,"
					+ "companyName=:cName,totalStocks=:tStocks where stockId=:sID";
			Query query = emManager.createQuery(jpql);
			query.setParameter("cID", stocksToUpdate.getCompanyID());
			query.setParameter("cName", stocksToUpdate.getCompanyName());
			query.setParameter("cPrice", stocksToUpdate.getCurrentPrice());
			query.setParameter("lPrice", stocksToUpdate.getLastPrice());
			query.setParameter("cPercentage", stocksToUpdate.getChangePercentage());
			query.setParameter("aStocks", stocksToUpdate.getAvailableStocks());
			query.setParameter("tStocks", stocksToUpdate.getTotalStocks());
			query.setParameter("sID", stocksToUpdate.getStockID());
			int result = query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("Problem in Updating stock Details, try again:");
			etTransaction.rollback();
			return false;
		}
	}

	@Override
	public boolean deleteStocks(int stockId) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			EntityTransaction etTransaction = emManager.getTransaction();
			etTransaction.begin();
			String jpql = "Delete from StocksBean where stockId=:stockId";
			Query query = emManager.createQuery(jpql);
			query.setParameter("stockId", stockId);
			int result = query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("There is problem in deleting stock: ");
			return false;
		}
	}

	@Override
	public boolean addStocks(StocksBean stocks) {
		EntityTransaction transactiont = null;
		try {
			EntityManager entityManager = emFactory.createEntityManager();
			transactiont = entityManager.getTransaction();
			transactiont.begin();

			entityManager.persist(stocks);
			transactiont.commit();

			entityManager.close();

			return true;
		} catch (Exception e) {
			System.out.println("Failed to Add new stocks, stocks May Already Exist..! ");
			transactiont.rollback();
			return false;
		}
	}

	@Override
	public StocksBean searchStocks(int stockId) {
		try {
			EntityManager eManager = emFactory.createEntityManager();
			StocksBean stock = eManager.find(StocksBean.class, stockId);
			if (stock != null) {
				return stock;
			} else {
				return null;
			}
		} catch (Exception e) {
			String message = e.getMessage();
			System.out.println("There Is Problem In Searching The stock:" + message);
		}
		return null;
	}

	@Override
	public StocksBean searchStocksByCompanyID(int companyID) {
		try {
			EntityManager eManager = emFactory.createEntityManager();
			String jpql = "from StocksBean where companyID=:cID";
			TypedQuery<StocksBean> query = eManager.createQuery(jpql, StocksBean.class);
			query.setParameter("cID", companyID);
			StocksBean stock = query.getSingleResult();
			if (stock != null) {
				return stock;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("problem in searching investerStockInfo by name:"+e.getMessage());
			return null;
		}
	}
}
