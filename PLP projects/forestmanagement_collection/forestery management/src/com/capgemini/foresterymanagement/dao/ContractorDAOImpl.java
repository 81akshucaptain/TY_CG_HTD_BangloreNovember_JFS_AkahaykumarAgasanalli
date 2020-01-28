package com.capgemini.foresterymanagement.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.capgemini.foresterymanagement.bean.*;
import com.capgemini.foresterymanagement.exception.ContractorAppException;
import com.capgemini.foresterymanagement.exception.CustomerAppException;

public class ContractorDAOImpl implements ContractorDAO {
	private static HashMap<Integer, ContractorBean> h1 = new HashMap<Integer, ContractorBean>();
	static int contractId = 0;

	@Override
	public HashMap<Integer, ContractorBean> getAllContarctor() {
		if (h1.isEmpty() == false) {
			return h1;
		} else {
			return null;
		}
	}

	@Override
	public boolean updateContarctor(int contractIdToUpdate, ContractorBean contarctorToUpdate) {
		if (h1.replace(contractIdToUpdate, contarctorToUpdate) != null) {
			return true;
		} else {
			throw new ContractorAppException("Contract Not Found, Problem in updating try again..!");
		}
	}

	@Override
	public boolean deletecontarctor(int contractIdToDelete) {
		if (h1.remove(contractIdToDelete) != null) {
			return true;
		} else {
			throw new ContractorAppException("Contract Not Found..!");
		}
	}

	@Override
	public boolean addContarctor(ContractorBean contractor) {
		while (true) {
			++contractId;
			// In-order to Add the generated ContractID to each objects
			contractor.setContractId(contractId);
			try {
				h1.put(contractId, contractor);
				return true;
			} catch (Exception e) {
				throw new ContractorAppException("Dumplicate Customer ID, please try again..!");
			}
		}
	}

	@Override
	public ContractorBean searchContarctor(int contractId) {
		if (h1.containsKey(contractId) == true) {
			return h1.get(contractId);
		} else {
			System.err.println("No such Contract Exist..!");
			return null;
		}

	}

}
