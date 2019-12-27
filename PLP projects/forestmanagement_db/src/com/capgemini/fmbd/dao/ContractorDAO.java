package com.capgemini.fmbd.dao;
import com.capgemini.fmdb.bean.ContractorBean;

public interface ContractorDAO {
	public void getAllContarctor();
	public boolean updateContarctor(int cid,ContractorBean contarctorToUpdate);
	public boolean deletecontarctor(int cid);
	public boolean addContarctor(ContractorBean contractor);
	public ContractorBean searchContarctor(int cid);
}
