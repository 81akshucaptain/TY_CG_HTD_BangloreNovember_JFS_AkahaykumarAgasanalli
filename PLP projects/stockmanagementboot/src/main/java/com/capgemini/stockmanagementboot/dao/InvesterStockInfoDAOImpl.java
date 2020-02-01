package com.capgemini.stockmanagementboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagementboot.dto.InvesterStocksInfoBean;
import com.capgemini.stockmanagementboot.dto.StocksBean;

@Repository
public class InvesterStockInfoDAOImpl implements InvestersStockInfoDAO {
	@PersistenceUnit
	EntityManagerFactory emFactory;

	EntityTransaction etTransaction = null;

	@Override
	public List<InvesterStocksInfoBean> getAllInvesterStockInfo() {
		try {
			String jpql = "from InvesterStocksInfoBean";
			EntityManager emManager = emFactory.createEntityManager();
			Query query = emManager.createQuery(jpql);
			List<InvesterStocksInfoBean> record = query.getResultList();
			emManager.close();
			if (record != null) {
				return record;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println("No data found for stockInformation..!try again: ");
			return null;
		}

	}

	@Override
	public boolean updateInvesterStocksInfo(int transactionId, InvesterStocksInfoBean investerStockInfoToUpdate) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			etTransaction = emManager.getTransaction();
			etTransaction.begin();

			String jpql = "update InvesterStocksInfoBean set companyName=:cName,companyID=:cID,"
					+ "stocksVolume=:sVolume,purchasedPrice=:pPrice,totalPrice=:tPrice,"
					+ "currentPrice=:cPrice where transactionId=:tID";
			Query query = emManager.createQuery(jpql);
			query.setParameter("cName", investerStockInfoToUpdate.getCompanyName());
			query.setParameter("cID", investerStockInfoToUpdate.getCompanyID());
			query.setParameter("sVolume", investerStockInfoToUpdate.getStocksVolume());
			query.setParameter("pPrice", investerStockInfoToUpdate.getPurchasedPrice());
			query.setParameter("tPrice", investerStockInfoToUpdate.getTotalPrice());
			query.setParameter("cPrice", investerStockInfoToUpdate.getCurrentPrice());
			query.setParameter("tID", investerStockInfoToUpdate.getTransactionID());
			int result = query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("Problem in Updating InvestrStockInfo Details, try again:");
			etTransaction.rollback();
			return false;
		}
	}

	@Override
	public boolean deleteInvesterStockInfo(int transactionId) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			EntityTransaction etTransaction = emManager.getTransaction();
			etTransaction.begin();
			String jpql = "Delete from InvesterStocksInfoBean where transactionId=:transactionId";
			Query query = emManager.createQuery(jpql);
			query.setParameter("transactionId", transactionId);
			int result = query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("There is problem in deleting InvesterStockInfo: ");
			return false;
		}
	}

	@Override
	public boolean addInvesterStockInfo(InvesterStocksInfoBean investerStockInfo) {
		EntityTransaction transactiont = null;
		try {
			EntityManager entityManager = emFactory.createEntityManager();
			transactiont = entityManager.getTransaction();
			transactiont.begin();

			entityManager.persist(investerStockInfo);
			transactiont.commit();

			entityManager.close();

			return true;
		} catch (Exception e) {
			System.out.println("Failed to Add new investerStockInfo, investerStockInfo May Already Exist..! ");
			transactiont.rollback();
			return false;
		}
	}

	@Override
	public InvesterStocksInfoBean searchInvesterStockInfo(int transactionId) {
		try {
			EntityManager eManager = emFactory.createEntityManager();
			InvesterStocksInfoBean stockInfo = eManager.find(InvesterStocksInfoBean.class, transactionId);
			if (stockInfo != null) {
				return stockInfo;
			} else {
				return null;
			}
		} catch (Exception e) {
			String message = e.getMessage();
			System.out.println("There Is Problem In Searching The InvseterStockInfo:" + message);
		}
		return null;
	}

	@Override
	public InvesterStocksInfoBean searchInvesterInfoByCompanyName(String companyName) {
		try {
			EntityManager eManager = emFactory.createEntityManager();
			String jpql = "from InvesterStocksInfoBean where companyName=:cName";
			TypedQuery<InvesterStocksInfoBean> query = eManager.createQuery(jpql, InvesterStocksInfoBean.class);
			query.setParameter("cName", companyName);
			InvesterStocksInfoBean investerStockInfo = query.getSingleResult();
			if (investerStockInfo != null) {
				return investerStockInfo;
			} else {
				return null;	
			}
		} catch (Exception e) {
			System.out.println("problem in searching investerStockInfo by name:" + e.getMessage());
			return null;
		}
	}
}
