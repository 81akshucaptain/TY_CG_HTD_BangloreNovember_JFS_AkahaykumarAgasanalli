package com.capgemini.foresterymanagement.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.capgemini.foresterymanagement.bean.*;
import com.capgemini.foresterymanagement.exception.ContractorAppException;
import com.capgemini.foresterymanagement.exception.CustomerAppException;

public class ContractorDAOImpl implements ContractorDAO{
	private static HashMap<Integer,ContractorBean> h1=new HashMap<Integer,ContractorBean>();
	static int ctid=0;

	@Override
	public HashMap<Integer, ContractorBean> getAllContarctor() {
		if(h1.isEmpty()==false) {
			return h1;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean updateContarctor(int cidToUpdate, ContractorBean contarctorToUpdate) {
		if(h1.replace(cidToUpdate,contarctorToUpdate )!=null) {
			return true;
		}else{
			throw new ContractorAppException("Contract Not Found, Problem in updating try again..!");
		}
	}


	@Override
	public boolean deletecontarctor(int cidToDelete) {
		if(h1.remove(cidToDelete)!=null) {
			return true;
		}
		else {
			throw new ContractorAppException("Contract Not Found..!");
		}
	}
	@Override
	public boolean addContarctor(ContractorBean contractor) {
		while(true) {
			++ctid;
			//In-order to Add the generated ContractID to each objects
			contractor.setContractId(ctid);
			try
			{
				h1.put(ctid,contractor);
				return true;
			}catch (Exception e) {
				throw new ContractorAppException("Dumplicate Customer ID, please try again..!");
			}
		}
	}
	@Override
	public ContractorBean searchContarctor(int ctid) {
		if(h1.containsKey(ctid)==true) {
			return h1.get(ctid);
		}else {
			System.err.println("No such Contract Exist..!");
			return null;
		}

	}

}
