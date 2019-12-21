package com.captain.Fm.DAO;

import java.util.HashMap;
import com.captain.Fm.bean.*;

import com.captain.Fm.bean.ContractorBean;
import com.captain.Fm.bean.CustomerBean;

public class ContractorDAOImpl implements ContractorDAO{
	private static HashMap<Integer,ContractorBean> h1=new HashMap<Integer,ContractorBean>();
	int ctid=0;

	@Override
	public void getAllContarctor() {
		System.out.println(h1);
		
	}

	@Override
	public boolean updateContarctor(int cidToUpdate, ContractorBean contarctorToUpdate) {
		h1.replace(cidToUpdate,contarctorToUpdate );
		return true;

	}

	@Override
	public boolean deletecontarctor(int cidToDelete) {
		System.out.println("The specified Contrcator got delated");
		h1.remove(cidToDelete);
		return true;
	}

	@Override
	public boolean addContarctor(ContractorBean contractor) {

		while(true) {
			++ctid;
			h1.put(ctid,contractor);
			System.out.println("hello contractor your ID is : "+ctid+" please remember..! Else GOVINDA..!");
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
