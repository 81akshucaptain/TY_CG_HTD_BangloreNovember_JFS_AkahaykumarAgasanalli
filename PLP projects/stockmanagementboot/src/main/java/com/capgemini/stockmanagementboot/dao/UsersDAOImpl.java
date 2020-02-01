package com.capgemini.stockmanagementboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagementboot.dto.UsersAuthenticationBean;

@Repository

public class UsersDAOImpl implements UsersDAO {

	@PersistenceUnit
	EntityManagerFactory emFactory;

	@Override
	public UsersAuthenticationBean usersLogin(String email, String password) {
		try {
			//EntityManager will deal with the dataBase mechanism
			EntityManager eManager = emFactory.createEntityManager();
			//create JavaPersistenceQueryLanguageQuery(jpql) 
			String jpql = "From UsersAuthenticationBean where userName=:uname";
			TypedQuery<UsersAuthenticationBean> jpQuery = eManager.createQuery(jpql, UsersAuthenticationBean.class);
			jpQuery.setParameter("uname", email);
			UsersAuthenticationBean user = jpQuery.getSingleResult();
			if (user != null) {
				if (password.equals(user.getPassword())) {
					return user;
				} else {
					return null;
				}
			}
		} catch (Exception e) {

		}

		return null;
	}

}
