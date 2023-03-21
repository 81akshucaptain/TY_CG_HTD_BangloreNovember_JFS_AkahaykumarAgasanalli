package com.interview.hotelmanagementboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.interview.hotelmanagementboot.config.MySecurityConfig;
import com.interview.hotelmanagementboot.dao.CustomerDAO;
import com.interview.hotelmanagementboot.dto.CustomerBean;
import com.interview.hotelmanagementboot.dto.User;

@Service
/*
 * Indicates that an annotated class is a "Service", originally defined by
 * Domain-DrivenDesign (Evans, 2003) May also indicate that a class is a
 * "Business Service Facade" (in the Core J2EEpatterns sense), or something
 * similar
 */
public class CustomerServiceIMPL implements CustomerServices {
	@Autowired
	CustomerDAO customerDao;

	
	BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();

	@Override
	public boolean createCustomer(CustomerBean customer) {
		if (customerDao.createCustomer(customer)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteCusromer(int customerID) {
		if (customerDao.deleteCusromer(customerID))
			return true;
		else
			return false;
	}

	@Override
	public boolean updateCustomer(CustomerBean customerToUpdate) {
		if (customerDao.updateCustomer(customerToUpdate))
			return true;
		else
			return false;
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		List<CustomerBean> customers = customerDao.getAllCustomers();
		return customers;
	}

	@Override
	public boolean createAccount(User loginBean) {
		loginBean.setPassword(this.bcr.encode(loginBean.getPassword()));
		if (customerDao.createAccount(loginBean))
			return true;
		else
			return false;
	}

	@Override
	public boolean login(User loginBean) {
		if (customerDao.login(loginBean))
			
			return true;
		else
			return false;
	}

}
