package com.capgemini.mywebapp.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.mywebapp.bean.EmployeeBean;
import com.capgemini.mywebapp.dao.EmployeeDAO;
import com.capgemini.mywebapp.dao.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService{
private EmployeeDAO dao=new EmployeeDAOImpl();
	@Override
	public EmployeeBean searchEmployee(int empId) {
		return dao.searchEmployee(empId);
	}
	@Override
	public EmployeeBean authenticate(int empId, String password) {
	return	dao.authenticate(empId, password);
	}
	@Override
	public boolean deleteEmployee(int empId) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(empId);
	}
	@Override
	public boolean addEmployee(EmployeeBean empbeanAdd) {
		// TODO Auto-generated method stub
		return dao.addEmployee(empbeanAdd);
	}
	@Override
	public boolean updateEmployee(EmployeeBean empbeanUpdate) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(empbeanUpdate);
	}
	@Override
	public List<EmployeeBean> getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

	
}
