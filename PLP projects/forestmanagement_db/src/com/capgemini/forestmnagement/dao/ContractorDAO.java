package com.capgemini.forestmnagement.dao;
import com.capgemini.forestmnagement.bean.ContractorBean;

public interface ContractorDAO {
	public void getAllContarctor();
	public boolean updateContarctor(int cid,ContractorBean contarctorToUpdate);
	public boolean deletecontarctor(int cid);
	public boolean addContarctor(ContractorBean contractor);
	public ContractorBean searchContarctor(int cid);
}
