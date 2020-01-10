package com.capgemini.forestmanagement.services;

import com.capgemini.forestmanagementjpa.dto.ContractorBean;

public interface ContractorServices {
	public void getAllContarctor();
	public boolean updateContarctor(int cid,ContractorBean contarctorToUpdate);
	public boolean deletecontarctor(int cid);
	//create contarctorBean obje and pass to insert all values
	public boolean addContarctor(ContractorBean contractor);
	public ContractorBean searchContarctor(int cid);

}
