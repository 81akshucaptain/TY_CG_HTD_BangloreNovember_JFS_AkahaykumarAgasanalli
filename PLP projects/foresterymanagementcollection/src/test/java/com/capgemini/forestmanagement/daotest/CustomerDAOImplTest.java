package com.capgemini.forestmanagement.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.capgemini.foresterymanagement.bean.CustomerBean;
import com.capgemini.foresterymanagement.dao.CustomerDAO;
import com.capgemini.foresterymanagement.factory.ForestFactory;

public class CustomerDAOImplTest {

	CustomerDAO customerDao = ForestFactory.instanceOfCustomerDAOImpl();
	CustomerBean customer = null;

	@Test
	void addCustomer() {
		customer = new CustomerBean();
		customer.setEmail("aks11@gmil.com");
		customer.setName("JACK");
		customer.setPassword("Aksha1y@AK123");
		customer.setPhone(874512457);
		customer.setTown("DWD");
		customer.setPostal(895689);
		try {
			boolean flag = customerDao.addCustomer(customer);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				customerDao.addCustomer(customer);
			});
		}
	}

	@Test
	void testDeleteCustomer() {
		try {
			boolean flag = customerDao.deleteCustomer(CustomerBean.getCustomerId());
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				customerDao.addCustomer(customer);
			});
		}
	}

	@Test
	void testUpdateCustomer() {
		CustomerBean customer = new CustomerBean();
		CustomerBean.setCustomerId(CustomerBean.getCustomerId());
		customer.setEmail("aks@gmil.com");
		customer.setName("AKSHUUU");
		customer.setPassword("Akshay@AK123");
		customer.setPhone(898989989);
		customer.setTown("DWD");
		customer.setPostal(895689);

		try {
			boolean flag = customerDao.updateCustomer(1, customer);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				customerDao.updateCustomer(1, customer);
			});
		}
	}

	/*@Test
	void testSearchForTrue() {
		int customerNo = CustomerBean.getCustomerId();
		try {
			CustomerBean bean = customerDao.searchCustomer(customerNo);
			assertEquals(bean != null, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				customerDao.searchCustomer(customerNo);
			});
		}

	}*/

	@Test
	void testSearchForFalse() {
		int customerNo = 108;
		try {
			CustomerBean bean = customerDao.searchCustomer(customerNo);
			assertEquals(bean != null, false);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				customerDao.searchCustomer(customerNo);
			});
		}

	}

	@Test
	void testCustomerDetailForNull() {

		try {
			CustomerBean contractDaoect = customerDao.searchCustomer(5);
			assertEquals(null, contractDaoect);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				customerDao.searchCustomer(4);
			});
		}
	}

}
