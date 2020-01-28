package com.capgemini.foresterymanagement.services;

import com.capgemini.foresterymanagement.bean.CustomerBean;
import com.capgemini.foresterymanagement.dao.CustomerDAO;
import com.capgemini.foresterymanagement.factory.ForestFactory;

public class CustomerServicesImpl implements CustomerServices{

	CustomerDAO customerDao=ForestFactory.instanceOfCustomerDAOImpl();

	@Override
	public void getAllCustomer() {
		customerDao.getAllCustomer();
	}

	@Override
	public boolean customerLogin(int id, String email) {
		return customerDao.customerLogin(id, email);
	}

	@Override
	public boolean updateCustomer(int cid, CustomerBean CustomerToUpdate) {
		return customerDao.updateCustomer(cid, CustomerToUpdate);
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
