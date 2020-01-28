package com.capgemini.forestmanagement.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileReader;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmanagementjpa.dao.CustomerDAO;
import com.capgemini.forestmanagementjpa.dao.CustomerDAOImpl;
import com.capgemini.forestmanagementjpa.dto.ContractorBean;
import com.capgemini.forestmanagementjpa.dto.CustomerBean;
import com.capgemini.forestmanagementjpa.factory.ForestFactoryFmJpa;

public class CustomerDAOImplTest {

	CustomerDAO customerDao = ForestFactoryFmJpa.createInstanceOfCustomerDAOImpl();
	CustomerBean customer = null;

	@Test
	void addCustomer() {
		customer = new CustomerBean();
		customer.setEmail("aks11@gmil.com");
		customer.setName("JACK");
		customer.setPassword("Aksha1y@AK123");
		customer.setPhone("8898989989");
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
			boolean flag = customerDao.deleteCustomer(77);
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
		customer.setCustomerId(1);
		customer.setEmail("aks@gmil.com");
		customer.setName("AKSHUUU");
		customer.setPassword("Akshay@AK123");
		customer.setPhone("8898989989");
		customer.setTown("DWD");
		customer.setPostal(895689);

		try {
			boolean flag = customerDao.updateCustomer(customer);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				customerDao.updateCustomer(customer);
			});
		}
	}

	@Test
	void testSearchForTrue() {
		int customerNo = 77;
		try {
			CustomerBean bean = customerDao.searchCustomer(customerNo);
			assertEquals(bean != null, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				customerDao.searchCustomer(customerNo);
			});
		}

	}

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
