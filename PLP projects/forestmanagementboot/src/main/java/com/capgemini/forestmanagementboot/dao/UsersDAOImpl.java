package com.capgemini.forestmanagementboot.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.forestmanagementboot.dto.UsersBean;

@Repository
public class UsersDAOImpl implements UsersDAO {

	@PersistenceUnit
	EntityManagerFactory eFactory;

	EntityTransaction eTransaction;

@Override
	public boolean userLogin(String userName, String password) {
		try {
			EntityManager eManager = eFactory.createEntityManager();
			String jpql = "from UsersBean where password=:pswd";
			TypedQuery<UsersBean> query = eManager.createQuery(jpql, UsersBean.class);
			query.setParameter("pswd", password);
			UsersBean auth = query.getSingleResult();
			if (auth != null) {
				if(password.equals(auth.getPassword())) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
