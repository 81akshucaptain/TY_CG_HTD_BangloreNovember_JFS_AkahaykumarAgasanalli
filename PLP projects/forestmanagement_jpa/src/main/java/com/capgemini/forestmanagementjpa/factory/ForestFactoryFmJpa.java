package com.capgemini.forestmanagementjpa.factory;

import com.capgemini.forestmanagementjpa.dao.CustomerDAO;
import com.capgemini.forestmanagementjpa.dao.CustomerDAOImpl;
import com.capgemini.forestmanagementjpa.dao.LandsDAO;
import com.capgemini.forestmanagementjpa.dao.LandsDAOImpl;
import com.capgemini.forestmanagementjpa.dao.ProductDAO;
import com.capgemini.forestmanagementjpa.dao.ProductDAOImpl;
import com.capgemini.forestmanagementjpa.dao.*;

public class ForestFactoryFmJpa {
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
