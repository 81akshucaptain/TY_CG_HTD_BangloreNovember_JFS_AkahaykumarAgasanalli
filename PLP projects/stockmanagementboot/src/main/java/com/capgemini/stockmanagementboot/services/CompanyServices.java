package com.capgemini.stockmanagementboot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.stockmanagementboot.dto.CompanyBean;

public interface CompanyServices {
	public List<CompanyBean> getAllCompany();

	public boolean updateCompany(int companyId, CompanyBean companyToUpdate);

	public boolean deleteCompany(int companyId);

	public boolean addCompany(CompanyBean company);

	public CompanyBean searchCompany(int companyId);

	public CompanyBean searchCompanyByMail(String email);

}
