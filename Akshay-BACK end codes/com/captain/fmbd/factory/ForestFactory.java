package com.captain.fmbd.factory;

import com.captain.fmdb.DAO.CustomerDAO;
import com.captain.fmdb.DAO.CustomerDAOImpl;

	public class ForestFactory {
		public static CustomerDAO instanceOfCustomerDAOImpl() {
			return new CustomerDAOImpl();
		}
		/*public static ContractorDAO instanceOfContractorDAOImpl() {
			return new ContractorDAOImpl();
		}
		public static ProductDAO insatnceOfProductDAOImpl() {
			return new ProductDAOImpl();
			
		}*/
		}

