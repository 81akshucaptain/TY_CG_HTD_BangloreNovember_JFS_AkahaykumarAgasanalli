package com.capgemini.forestmnagement.factory;

import com.capgemini.forestmnagement.dao.ContractorDAO;
import com.capgemini.forestmnagement.dao.ContractorDAOImpl;
import com.capgemini.forestmnagement.dao.CustomerDAO;
import com.capgemini.forestmnagement.dao.CustomerDAOImpl;
import com.capgemini.forestmnagement.dao.LandsDAO;
import com.capgemini.forestmnagement.dao.LandsDAOImpl;
import com.capgemini.forestmnagement.dao.ProductDAO;
import com.capgemini.forestmnagement.dao.ProductDAOImpl;

public class ForestFactoryFmDb {
public static CustomerDAO createInstanceOfCustomerDAOImpl() {
	return new CustomerDAOImpl();
}
public static ProductDAO createInstanceOfProductDAOImpl() {
	return new ProductDAOImpl();
}
public static ContractorDAO createInstanceOfContractorDAOImpl() {
	return new ContractorDAOImpl();
}
public static LandsDAO createInstanceOfLandsDAOImpl() {
	return new LandsDAOImpl();
}

}
