package com.captain.Fm.DAO;

import java.util.HashMap;
import java.util.Set;

import com.captain.Fm.bean.*;

import com.captain.Fm.bean.ContractorBean;
import com.captain.Fm.bean.CustomerBean;

public class ContractorDAOImpl implements ContractorDAO{
	private static HashMap<Integer,ContractorBean> h1=new HashMap<Integer,ContractorBean>();
	int ctid=0;
	@Override
	public void getAllContarctor() {
		if(h1.isEmpty()==false) {
			System.out.println("                            ::::ALL CONTRACT DETAILS::::");
			Set<Integer> s=h1.keySet();
			for (Integer key : s) {
				ContractorBean cb=h1.get(key);
				System.out.println("CONTRACT-ID: "+key);
				System.out.println(cb);
			}
		}else {
			System.err.println("Currently there is no contracts..!(No customer orders)");
		}
	}

	@Override
	public boolean updateContarctor(int cidToUpdate, ContractorBean contarctorToUpdate) {
		h1.replace(cidToUpdate,contarctorToUpdate );
		return true;

	}

	@Override
	public boolean deletecontarctor(int cidToDelete) {
		h1.remove(cidToDelete);
		return true;
	}

	@Override
	public boolean addContarctor(ContractorBean contractor) {

		while(true) {
			++ctid;
			//In-order to Add the generated ContractID to each objects
			contractor.setContractId(ctid);
			h1.put(ctid,contractor);
			System.out.println("Contract with CONTRACT-ID : "+ctid+"  \n for CUSTOMER-ID "
					+contractor.getCustomerId() +"is added succesfully (please remember )");
			return true;
		}	
	}

	@Override
	public ContractorBean searchContarctor(int ctid) {
		if(h1.containsKey(ctid)==true) {
			return h1.get(ctid);
		}else {
			return null;
		}

	}

}
