package com.interview.hotelmanagementboot.service;

import java.util.List;

import com.interview.hotelmanagementboot.dto.CustomerBean;
import com.interview.hotelmanagementboot.dto.User;

public interface CustomerServices {
	public boolean createCustomer(CustomerBean customer);

	public boolean deleteCusromer(int customerID);

	public boolean updateCustomer(CustomerBean customer);
	
	public boolean createAccount(User loginBean);
	
	public boolean login(User loginBean);

	
	public List<CustomerBean> getAllCustomers();
}
