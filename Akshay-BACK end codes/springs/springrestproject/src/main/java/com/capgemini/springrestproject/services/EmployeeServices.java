package com.capgemini.springrestproject.services;

import java.util.List;

import com.capgemini.springrestproject.dto.EmployeeBean;

public interface EmployeeServices {
	public EmployeeBean auth(String email,String password);
	public boolean addEmployee(EmployeeBean bean);
	public List<EmployeeBean> getEmployees(String key);
	public boolean changePassword(int id,String password);
	public boolean deleteEmployee(int id);
}
