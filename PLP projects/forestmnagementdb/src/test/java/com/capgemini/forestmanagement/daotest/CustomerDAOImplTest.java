package com.capgemini.forestmanagement.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileReader;
import java.util.Properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmnagementdb.bean.ContractorBean;
import com.capgemini.forestmnagementdb.bean.CustomerBean;
import com.capgemini.forestmnagementdb.dao.ContractorDAOImpl;
import com.capgemini.forestmnagementdb.dao.CustomerDAO;
import com.capgemini.forestmnagementdb.dao.CustomerDAOImpl;
import com.capgemini.forestmnagementdb.exception.CustomerAppException;
import com.capgemini.forestmnagementdb.factory.ForestFactoryJdbc;

public class CustomerDAOImplTest {

	CustomerDAO customerDao = null;
	CustomerBean customer = null;

	@BeforeEach
	void testCustomerDAOImpl() {
		FileReader reader;
		Properties prop;
		try {
			reader = new FileReader("customer.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("DriverClass"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customerDao = new CustomerDAOImpl();
	}

//	@Test
//	void addCustomer() {
//		customer = new CustomerBean();
//		customer.setCustomerId(3331);
//		customer.setEmail("aks11@gmil.com");
//		customer.setName("JACK");
//		customer.setPassword("Aksha1y@AK123");
//		customer.setPhone("8898989989");
//		customer.setTown("DWD");
//		customer.setPostal(895689);
//		try {
//			boolean flag = customerDao.addCustomer(customer);
//			assertEquals(flag, true);
//		} catch (Exception e) {
//			assertThrows(CustomerAppException.class, () -> {
//				customerDao.addCustomer(customer);
//			});
//		}
//	}
//	@Test
//	void testDeleteCustomer() {
//		try {
//			boolean flag = customerDao.deleteCustomer(3331);
//			assertEquals(flag, true);
//		} catch (Exception e) {
//			assertThrows(Exception.class, () -> {
//				customerDao.addCustomer(customer);
//			});
//		}
//	}

//	@Test
//	void testUpdateCustomer() {
//		CustomerBean customer = new CustomerBean();
//		customer.setCustomerId(3331);
//		customer.setEmail("aks@gmil.com");
//		customer.setName("AKSHUUU");
//		customer.setPassword("Akshay@AK123");
//		customer.setPhone("8898989989");
//		customer.setTown("DWD");
//		customer.setPostal(895689);
//
//		try {
//			boolean flag = customerDao.updateCustomer(customer);
//			assertEquals(flag, true);
//		} catch (Exception e) {
//			assertThrows(Exception.class, () -> {
//				customerDao.updateCustomer(customer);
//			});
//		}
//	}

//	@Test
//	void testSearchForTrue() {
//		int customerNo = 3331;
//		try {
//			CustomerBean bean= customerDao.searchCustomer(customerNo);
//			assertEquals(bean!=null, true);
//		}catch(Exception e) {
//			assertThrows(Exception.class,()->{
//				customerDao.searchCustomer(customerNo);
//			});
//		}
//		
//	}
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

}
