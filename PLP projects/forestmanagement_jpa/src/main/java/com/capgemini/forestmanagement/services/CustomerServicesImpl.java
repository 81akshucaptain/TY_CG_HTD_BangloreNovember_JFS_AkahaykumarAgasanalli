package com.capgemini.forestmanagement.services;

import com.capgemini.forestmanagementjpa.dao.CustomerDAO;
import com.capgemini.forestmanagementjpa.dto.CustomerBean;
import com.capgemini.forestmanagementjpa.factory.ForestFactoryFmJpa;

public class CustomerServicesImpl implements CustomerServices{

	CustomerDAO customerDao=ForestFactoryFmJpa.createInstanceOfCustomerDAOImpl();

	@Override
	public void getAllCustomer() {
		customerDao.getAllCustomer();
	}

	@Override
	public boolean customerLogin(int id, String email) {
		return customerDao.customerlogin(id, email);
	}

	@Override
	public boolean updateCustomer(int cid, CustomerBean CustomerToUpdate) {
		return customerDao.updateCustomer(CustomerToUpdate);
	}

	@Override
	public boolean deleteCustomer(int cid) {
		return customerDao.deleteCustomer(cid);
	}

	@Override
	public boolean addCustomer(CustomerBean customer) {
		return customerDao.addCustomer(customer);
	}

	@Override
	public CustomerBean searchCustomer(int cid) {
		return customerDao.searchCustomer(cid);
	}

}
