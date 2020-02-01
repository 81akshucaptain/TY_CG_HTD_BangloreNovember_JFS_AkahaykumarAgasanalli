package com.capgemini.stockmanagementboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagementboot.dto.CompanyBean;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
	
	@PersistenceUnit
	EntityManagerFactory emFactory;

	EntityTransaction etTransaction = null;

	@Override
	public List<CompanyBean> getAllCompany() {
		try {
			String jpql = "from CompanyBean";
			EntityManager emManager = emFactory.createEntityManager();
			Query query = emManager.createQuery(jpql);
			List<CompanyBean> record = query.getResultList();
			emManager.close();
			if (record != null) {
				return record;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.err.println("No data found for all company..!try again: ");
			return null;
		}

	}

	@Override
	public boolean updateCompany(int companyId, CompanyBean companyToUpdate) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			etTransaction = emManager.getTransaction();
			etTransaction.begin();

			String jpql = "update CompanyBean set companyName=:cName,companyDirector=:cDirector,"
					+ "companyChairman=:cChairman,companyEmail=:cEmail,companyPhone=:cPhone,"
					+ "companyCity=:cCity,maxInvest=:mInvest,maxStocksPurchase=:mPurchase where companyID=:cID";
			Query query = emManager.createQuery(jpql);
			query.setParameter("cName", companyToUpdate.getCompanyName());
			query.setParameter("cDirector", companyToUpdate.getCompanyDirector());
			query.setParameter("cChairman", companyToUpdate.getCompanyChairman());
			query.setParameter("cEmail", companyToUpdate.getCompanyEmail());
			query.setParameter("cPhone", companyToUpdate.getCompanyPhone());
			query.setParameter("cCity", companyToUpdate.getCompanyCity());
			query.setParameter("mInvest", companyToUpdate.getMaxInvest());
			query.setParameter("mPurchase", companyToUpdate.getMaxStocksPurchase());
			query.setParameter("cID", companyToUpdate.getCompanyID());
			int result = query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("Problem in Updating company Details, try again:");
			etTransaction.rollback();
			return false;
		}
	}

	@Override
	public boolean deleteCompany(int companyId) {
		// TODO Auto-generated method stub
		try {
			EntityManager emManager = emFactory.createEntityManager();
			EntityTransaction etTransaction = emManager.getTransaction();
			etTransaction.begin();
			String jpql = "Delete from CompanyBean where companyId=:companyId";
			Query query = emManager.createQuery(jpql);
			query.setParameter("companyId", companyId);
			int result = query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("There is problem in deleting company: ");
			return false;
		}
	}

	@Override
	public boolean addCompany(CompanyBean company) {
		// TODO Auto-generated method stub
		EntityTransaction transactiont = null;
		try {
			// persistence class is bootstrap class helps us create obj
			// createEntityManagerFactory created only once in life
			// EM is interface which is used to communicate with db
			EntityManager entityManager = emFactory.createEntityManager();
			// to deal with overall transaction we need this line and respective methods
			transactiont = entityManager.getTransaction();
			transactiont.begin();
			// to insert record we have to pass the object reference.
			entityManager.persist(company);

			transactiont.commit();
			// ToGenerate customer Credentials in Login table
			entityManager.close();

			return true;
		} catch (Exception e) {
			System.out.println("Failed to Add new company, company May Already Exist..! ");
			// to roll back the data entered to the database if something bad happen
			transactiont.rollback();
			return false;
		}
	}
	@Override
	public CompanyBean searchCompany(int companyId) {
		try {
			EntityManager eManager = emFactory.createEntityManager();
			CompanyBean cbBean = eManager.find(CompanyBean.class, companyId);
			if (cbBean != null) {
				return cbBean;
			} else {
				return null;
			}
		} catch (Exception e) {
			String message = e.getMessage();
			System.out.println("There Is Problem In Searching The company:" + message);
		}
		return null;
	}


	@Override
	public CompanyBean searchCompanyByMail(String email) {
		try {
			EntityManager eManager = emFactory.createEntityManager();
			String jpql = "from CompanyBean where email=:email";
			TypedQuery<CompanyBean> query = eManager.createQuery(jpql, CompanyBean.class);
			query.setParameter("email", email);
			CompanyBean auth = query.getSingleResult();
			if (auth != null) {
				return auth;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
