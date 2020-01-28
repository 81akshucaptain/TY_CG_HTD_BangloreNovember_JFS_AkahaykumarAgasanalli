package com.capgemini.forestmanagement.daotest;

import java.io.FileReader;

import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.forestmnagementdb.bean.ContractorBean;
import com.capgemini.forestmnagementdb.dao.ContractorDAO;
import com.capgemini.forestmnagementdb.dao.ContractorDAOImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContractDAOImplTest {
	ContractorDAO obj = null;
	ContractorBean contract = null;

	@BeforeEach
	void testContractDAOImpl() {
		FileReader reader;
		Properties prop;
		try {
			reader = new FileReader("contractor.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("DriverClass"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("hi");
		}
		obj = new ContractorDAOImpl();
	}

	@Test
	void testAddContract() {
		contract = new ContractorBean();
		contract.setContractId(4747);
		contract.setCustomerId(100);
		contract.setProductId(68);
		contract.setHaulierId("WW-77-EE-8956");
		contract.setDeliveryDate("2020-01-29");
		contract.setQunatity(52);
		try {
			boolean flag = obj.addContarctor(contract);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				obj.addContarctor(contract);
			});
		}
	}


	@Test
	void testUpdateContract() {
		ContractorBean contract = new ContractorBean();
		contract.setContractId(4747);
		contract.setCustomerId(100);
		contract.setDeliveryDate("2020-01-24");
		contract.setProductId(898);
		contract.setQunatity(129);
		contract.setHaulierId("GO-98-SS-8956");
		try {
			boolean flag = obj.updateContarctor(contract.getContractId(), contract);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				obj.updateContarctor(contract.getContractId(), contract);
			});
		}
	}


	@Test
	void testContractDetail() {

		try {
			ContractorBean object = obj.searchContarctor(4747);
			assertEquals(contract, object);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				obj.deletecontarctor(549);
			});
		}
	}

	@Test
	void testSearchForTrue() {
		int ContractNo = 4747;
		try {
			ContractorBean bean= obj.searchContarctor(ContractNo);
			assertEquals(bean!=null, true);
		}catch(Exception e) {
			assertThrows(Exception.class,()->{
				obj.searchContarctor(ContractNo);
			});
		}
		
	}
	@Test
	void testSearchForFalse() {
		int ContractNo = 36598;
		try {
			ContractorBean bean= obj.searchContarctor(ContractNo);
			assertEquals(bean!=null, false);
		}catch(Exception e) {
			assertThrows(Exception.class,()->{
				obj.searchContarctor(ContractNo);
			});
		}
		
	}
	
//	@Test
//	void testDeleteContact() {
//		try {
//			boolean flag = obj.deletecontarctor(4747);
//			assertEquals(flag, true);
//		} catch (Exception e) {
//			assertThrows(Exception.class, () -> {
//				obj.addContarctor(contract);
//			});
//		}
//	}



}
