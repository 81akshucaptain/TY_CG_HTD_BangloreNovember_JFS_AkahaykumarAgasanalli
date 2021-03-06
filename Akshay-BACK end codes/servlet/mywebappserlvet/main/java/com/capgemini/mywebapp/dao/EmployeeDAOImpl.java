package com.capgemini.mywebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.mywebapp.bean.EmployeeBean;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManagerFactory eMFactory=Persistence.createEntityManagerFactory("TestPersistence");
	@Override
	public EmployeeBean searchEmployee(int empId) {

		EntityManager emManager=eMFactory.createEntityManager();
		EmployeeBean emb=emManager.find(EmployeeBean.class, empId);
		emManager.close();
		return emb;
	}

	@Override
	public EmployeeBean authenticate(int empId, String password) {
		EntityManager emManager=eMFactory.createEntityManager();
		String sql="from EmployeeBean"
				+ " where empid=:emp and password=:pwd ";
		Query query=emManager.createQuery(sql);
		query.setParameter("emp", empId);
		query.setParameter("pwd", password);
		EmployeeBean empbean=null;;
		try {
			empbean=(EmployeeBean) query.getSingleResult();


		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in authentication");
		}
		emManager.close();
		return empbean;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean isDeleted=false;
		EntityManager emManager=eMFactory.createEntityManager();
		EntityTransaction etTransaction=null;
		EmployeeBean emb=emManager.find(EmployeeBean.class, empId);

		if(emb!=null) {
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			emManager.remove(emb);
			etTransaction.commit();
			isDeleted=true;
		}
		emManager.close();
		return isDeleted;
	}

	@Override
	public boolean addEmployee(EmployeeBean empbeanAdd) {
		boolean isAdded=false;

		EntityManager emManager=eMFactory.createEntityManager();
		EntityTransaction etTransaction=null;
		try {
			etTransaction=emManager.getTransaction();
			etTransaction.begin();
			emManager.persist(empbeanAdd);
			etTransaction.commit();
			isAdded=true;
		}catch (Exception e) {
			e.printStackTrace();	
		}
		emManager.close();
		return isAdded;
	}

	@Override
	public boolean updateEmployee(EmployeeBean empbeanUpdate) {
		boolean isUpdated=false;
		EntityManager emManager=eMFactory.createEntityManager();
		EmployeeBean existEmpBean=emManager.find(EmployeeBean.class, empbeanUpdate.getEmpid());
		EntityTransaction etTransaction=emManager.getTransaction();
		{
			if(existEmpBean!=null) {
				try {
					etTransaction.begin();
					String newName=empbeanUpdate.getName().trim();
					if(newName!=null && !newName.isEmpty()) {
						existEmpBean.setName(newName);
					}

					int newAge = empbeanUpdate.getAge();
					if(newAge>18){
						existEmpBean.setAge(newAge);
					}
					String newSalary=empbeanUpdate.getSalary().trim();
					if(newSalary!=null && !newSalary.isEmpty()) {
						existEmpBean.setSalary(newSalary);
					}

					String newDesignation=empbeanUpdate.getSalary().trim();
					if(newDesignation!=null && !newDesignation.isEmpty()) {
						existEmpBean.setDesignation(newDesignation);
					}

					String newPassword=empbeanUpdate.getSalary().trim();
					if(newPassword!=null && !newPassword.isEmpty()) {
						existEmpBean.setPassword(newPassword);
					}
					etTransaction.begin();
					emManager.persist(existEmpBean);
					etTransaction.commit();
					isUpdated=true;
				}catch (Exception e) {
					e.printStackTrace();
					return false;
				}
				emManager.close();

			}
		}
		return isUpdated;
	}
	@Override
	public List<EmployeeBean> getAllEmployees() {
		EntityManager emManager=eMFactory.createEntityManager();
		String jpql="from EmployeeBean";
		Query query=emManager.createQuery(jpql);
		List<EmployeeBean> empbean=query.getResultList();
		emManager.close();
		return empbean;
	}

}
