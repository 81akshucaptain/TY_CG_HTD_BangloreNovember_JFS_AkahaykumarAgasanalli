package com.capgemini.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.capgemini.springboot.dto.EmployeeBean;
import com.capgemini.springboot.exception.EmployeeException;
@Repository
public class EmployeeDAOimpl implements EmployeeDAO{
	@PersistenceUnit
	private EntityManagerFactory emFactory;
	@Override
	public EmployeeBean auth(String email, String password) {
		try {
			EntityManager eManager =emFactory.createEntityManager();
			String jpql="from EmployeeBean where email=:email";
			TypedQuery<EmployeeBean> query=eManager.createQuery(jpql,EmployeeBean.class);
			query.setParameter("email", email);
			//query.setParameter("password", password);
			EmployeeBean empbean=query.getSingleResult();
			BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
			if(encoder.matches(password, empbean.getPassword())){
				return empbean;	
			}else {
				throw new EmployeeException("invalid password");
			}
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public boolean addEmployee(EmployeeBean bean) {
		EntityManager eManager=emFactory.createEntityManager();
		EntityTransaction et=eManager.getTransaction();
		et.begin();
		try {
			eManager.persist(bean);
			et.commit();
			return true;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			throw new EmployeeException("email allready exist");
		}
	}

	//STUDY THISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
	@Override
	public List<EmployeeBean> getEmployees(String key) {
		try {
			String jpql="from EmployeeBean where name=:name or email=:email ";
			EntityManager eManager=emFactory.createEntityManager();
			TypedQuery<EmployeeBean> query=eManager.createQuery(jpql,EmployeeBean.class);
			query.setParameter("name", key);
			query.setParameter("email", key);

			List<EmployeeBean> emp=query.getResultList();
			return emp;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean changePassword(int id, String password) {
		try {
			EntityManager emManager=emFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			EmployeeBean bean=emManager.find(EmployeeBean.class, id);
			bean.setPassword(password);
			etTransaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteEmployee(int id) {
		EntityManager emManager=emFactory.createEntityManager();
		EntityTransaction etTransaction=emManager.getTransaction();
		etTransaction.begin();
		EmployeeBean ebBean=emManager.find(EmployeeBean.class, id);
		if(ebBean!=null) {
			emManager.remove(ebBean);
			etTransaction.commit();
			return true;
		}else {
			throw new EmployeeException("emplyee not found");
		}
	}

}
