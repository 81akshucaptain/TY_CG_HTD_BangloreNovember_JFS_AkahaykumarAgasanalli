package com.capgemini.mywebapp.services;

import java.util.List;

import com.capgemini.mywebapp.bean.EmployeeBean;

public interface EmployeeService {
	public EmployeeBean searchEmployee(int empId);
	public EmployeeBean authenticate(int empId,String password);
	public boolean deleteEmployee(int empId);
	public boolean addEmployee(EmployeeBean empbeanAdd);
	public boolean updateEmployee(EmployeeBean empbeanUpdate);
	public List<EmployeeBean> getAllEmployees();
}
