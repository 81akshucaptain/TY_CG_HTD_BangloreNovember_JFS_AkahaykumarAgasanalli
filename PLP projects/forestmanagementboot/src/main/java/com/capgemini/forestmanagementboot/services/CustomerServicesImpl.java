package com.capgemini.forestmanagementboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementboot.dao.CustomerDAO;
import com.capgemini.forestmanagementboot.dto.CustomerBean;
import com.capgemini.forestmanagementboot.exceptionss.VallidationExceptionFMS;
import com.capgemini.forestmanagementboot.util.Validations;

@Service
public class CustomerServicesImpl implements CustomerServices {
	@Autowired
	CustomerDAO customerDao;

	@Override
	public List<CustomerBean> getAllCustomer() {
		return customerDao.getAllCustomer();
	}

	@Override
	public boolean customerLogin(int id, String password) {
		try {
			if (Validations.numberValidation(id)) {
				return customerDao.customerlogin(id, password);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;

	}

	@Override
	public boolean updateCustomer(int cid, CustomerBean CustomerToUpdate) {
		try {
			if (Validations.numberValidation(cid) && Validations.fullNameValidation(CustomerToUpdate.getName())
					&& Validations.emailValidation(CustomerToUpdate.getEmail())
					&& Validations.phoneNumberValidation(CustomerToUpdate.getPhone())
					&& Validations.postalValidation(CustomerToUpdate.getPostal())
					&& Validations.alphabetsValidation(CustomerToUpdate.getTown())) {
				return customerDao.updateCustomer(CustomerToUpdate);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(int cid) {
		try {
			if (Validations.numberValidation(cid)) {
				return customerDao.deleteCustomer(cid);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public boolean addCustomer(CustomerBean customer) {
		try {
			if (Validations.numberValidation(customer.getCid()) &&
					Validations.fullNameValidation(customer.getName())
					&& Validations.emailValidation(customer.getEmail())
					&& Validations.phoneNumberValidation(customer.getPhone())
					&& Validations.postalValidation(customer.getPostal())
					&& Validations.alphabetsValidation(customer.getTown())) {
				return customerDao.addCustomer(customer);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public CustomerBean searchCustomer(int cid) {
		try {
			if (Validations.numberValidation(cid)) {
				return customerDao.searchCustomer(cid);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}

}
