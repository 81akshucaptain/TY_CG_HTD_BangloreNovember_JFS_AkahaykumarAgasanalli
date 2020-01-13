package com.capgemini.forestmanagementrest.services;

import java.util.List;

import com.capgemini.forestmanagementrest.dto.ContractorBean;
import com.capgemini.forestmanagementrest.dto.CustomerBean;

public interface ContractorServices {
	public List<ContractorBean> getAllContarctor();
	public boolean updateContarctor(int cid,ContractorBean contarctorToUpdate);
	public boolean deletecontarctor(int cid);
	//create contarctorBean obje and pass to insert all values
	public boolean addContarctor(ContractorBean contractor);
	public ContractorBean searchContarctor(int cid);

}
