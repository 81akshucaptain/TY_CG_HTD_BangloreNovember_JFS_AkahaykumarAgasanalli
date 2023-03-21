package com.interview.hotelmanagementboot.dao;

import java.util.List;
import java.util.Optional;

import com.interview.hotelmanagementboot.dto.CustomerBean;
import com.interview.hotelmanagementboot.dto.User;

public interface CustomerDAO {
	public boolean createCustomer(CustomerBean customer);

	public boolean deleteCusromer(int customerID);

	public boolean updateCustomer(CustomerBean customer);

	public List<CustomerBean> getAllCustomers();

	public boolean createAccount(User loginBean);

	public boolean login(User loginBean);

	public User findByUsername(String username);
}
