package com.capgemini.forestmanagementjpa.dao;

import com.capgemini.forestmanagementjpa.dto.ContractorBean;

public interface ContractorDAO {
	public void getAllContarctor();
	public boolean updateContarctor(int cid,ContractorBean contarctorToUpdate);
	public boolean deletecontarctor(int cid);
	public boolean addContarctor(ContractorBean contractor);
	public ContractorBean searchContarctor(int cid);

}
