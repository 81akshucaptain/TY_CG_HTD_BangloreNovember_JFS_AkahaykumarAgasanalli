package com.capgemini.forestmnagementdb.factory;

import com.capgemini.forestmnagementdb.dao.ContractorDAO;
import com.capgemini.forestmnagementdb.dao.ContractorDAOImpl;
import com.capgemini.forestmnagementdb.dao.CustomerDAO;
import com.capgemini.forestmnagementdb.dao.CustomerDAOImpl;
import com.capgemini.forestmnagementdb.dao.LandsDAO;
import com.capgemini.forestmnagementdb.dao.LandsDAOImpl;
import com.capgemini.forestmnagementdb.dao.ProductDAO;
import com.capgemini.forestmnagementdb.dao.ProductDAOImpl;

public class ForestFactoryJdbc {
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
