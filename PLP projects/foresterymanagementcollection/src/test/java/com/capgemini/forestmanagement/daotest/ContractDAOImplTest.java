package com.capgemini.forestmanagement.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.capgemini.foresterymanagement.bean.ContractorBean;
import com.capgemini.foresterymanagement.dao.ContractorDAO;
import com.capgemini.foresterymanagement.factory.ForestFactory;

public class ContractDAOImplTest {

	ContractorDAO contractDao = ForestFactory.instanceOfContractorDAOImpl();
	ContractorBean contract = null;

	@Test
	void testAddContract() {
		contract = new ContractorBean();
		contract.setCustomerId(200);
		contract.setProductId(30);
		contract.setHaulierId("WW-77-EE-8956");
		contract.setDeliveryDate("2020-01-29");
		contract.setQunatity(6);
		try {
			boolean flag = contractDao.addContarctor(contract);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				contractDao.addContarctor(contract);
			});
		}
	}

	@Test
	void testUpdateContract() {
		ContractorBean contract = new ContractorBean();
		contract.setContractId(contract.getContractId());
		contract.setCustomerId(200);
		contract.setDeliveryDate("2020-01-24");
		contract.setProductId(898);
		contract.setQunatity(129);
		contract.setHaulierId("GO-98-SS-8956");
		try {
			boolean flag = contractDao.updateContarctor(contract.getContractId(), contract);
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				contractDao.updateContarctor(contract.getContractId(), contract);
			});
		}
	}

	@Test
	void testContractDetailForNull() {

		try {
			ContractorBean contractDaoect = contractDao.searchContarctor(5);
			assertEquals(null, contractDaoect);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				contractDao.deletecontarctor(4);
			});
		}
	}

	/*
	 * @Test void testSearchForTrue() { int ContractNo = 4; try { ContractorBean
	 * bean = contractDao.searchContarctor(ContractNo); assertEquals(bean != null,
	 * true); } catch (Exception e) { assertThrows(Exception.class, () -> {
	 * contractDao.searchContarctor(ContractNo); }); }
	 * 
	 * }
	 */

	@Test
	void testSearchForFalse() {
		int ContractNo = 8;
		try {
			ContractorBean bean = contractDao.searchContarctor(ContractNo);
			assertEquals(bean != null, false);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				contractDao.searchContarctor(ContractNo);
			});
		}

	}

	@Test
	void testDeleteContact() {
		try {
			boolean flag = contractDao.deletecontarctor(this.contract.getContractId());
			assertEquals(flag, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				contractDao.addContarctor(contract);
			});
		}
	}
}
