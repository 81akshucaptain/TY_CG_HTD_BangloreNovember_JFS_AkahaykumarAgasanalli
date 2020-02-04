package com.capgemini.stockmanagementboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagementboot.dto.CompanyBean;
import com.capgemini.stockmanagementboot.dto.UsersAuthenticationBean;

@Repository
public class UsersDAOImpl implements UsersDAO {

	@PersistenceUnit
	EntityManagerFactory emFactory;
	EntityTransaction etTransaction = null;

	@Override
	public UsersAuthenticationBean usersLogin(String userName, String password) {
		try {
			// EntityManager will deal with the dataBase mechanism
			EntityManager eManager = emFactory.createEntityManager();
			// create JavaPersistenceQueryLanguageQuery(jpql)
			String jpql = "From UsersAuthenticationBean where userName=:uname";
			TypedQuery<UsersAuthenticationBean> jpQuery = eManager.createQuery(jpql, UsersAuthenticationBean.class);
			jpQuery.setParameter("uname", userName);
			UsersAuthenticationBean user = jpQuery.getSingleResult();
			if (user != null) {
				if (password.equals(user.getPassword())) {
					return user;
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			System.out.println("User does not exist, try agin Login failed: " + e.getMessage());
		}

		return null;
	}

	@Override
	public boolean updatePassword(UsersAuthenticationBean usersBean) {
		try {
			EntityManager emManager = emFactory.createEntityManager();
			etTransaction = emManager.getTransaction();
			etTransaction.begin();

			String jpql = "update UsersAuthenticationBean set password=:pswd where email=:eMail";
			Query query = emManager.createQuery(jpql);
			query.setParameter("pswd", usersBean.getPassword());
			query.setParameter("eMail", usersBean.getEmail());
			int result = query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("Problem in Updating Password , try again:" + e.getMessage());
			etTransaction.rollback();
			return false;
		}
	}

	@Override
	public UsersAuthenticationBean searchUserByEmail(String email) {
		try {
			EntityManager eManager = emFactory.createEntityManager();
			String jpql = "from UsersAuthenticationBean where email=:email";
			TypedQuery<UsersAuthenticationBean> query = eManager.createQuery(jpql, UsersAuthenticationBean.class);
			query.setParameter("email", email);
			UsersAuthenticationBean user = query.getSingleResult();
			if (user != null) {
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("User EmailID Doesn't present");
			return null;
		}
	}
}
