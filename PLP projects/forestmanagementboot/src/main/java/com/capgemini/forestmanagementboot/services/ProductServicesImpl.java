package com.capgemini.forestmanagementboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestmanagementboot.dao.ProductDAO;
import com.capgemini.forestmanagementboot.dto.ProductBean;
import com.capgemini.forestmanagementboot.exceptionss.VallidationExceptionFMS;
import com.capgemini.forestmanagementboot.util.Validations;

@Service
public class ProductServicesImpl implements ProductServices {
	@Autowired
	ProductDAO productDao;

	@Override
	public List<ProductBean> getAllProduct() {
		return productDao.getAllProduct();
	}

	@Override
	public boolean deleteProduct(int pid) {
		try {
			if (Validations.numberValidation(pid)) {
				return productDao.deleteProduct(pid);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public boolean addProduct(ProductBean product) {
		try {
			if (Validations.numberValidation(product.getCost()) 
					&& Validations.numberValidation(product.getQantity())
					&& Validations.alphabetsValidation(product.getName())
					&& Validations.alphabetsValidation(product.getProductClass())) {
				return productDao.addProduct(product);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public boolean checkIsTherePID(int pid) {
		try {
			if (Validations.numberValidation(pid)) {
				return productDao.checkIsTherePID(pid);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public boolean updateProduct(ProductBean ProductToUpdate) {
		try {
			if (Validations.numberValidation(ProductToUpdate.getPID())&&
					Validations.numberValidation(ProductToUpdate.getCost()) 
					&& Validations.numberValidation(ProductToUpdate.getQantity())
					&& Validations.alphabetsValidation(ProductToUpdate.getName())
					&& Validations.alphabetsValidation(ProductToUpdate.getProductClass())) {
				return productDao.updateProduct(ProductToUpdate);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}

	@Override
	public ProductBean searchProduct(int pid) {
		try {
			if (Validations.numberValidation(pid)) {
				return productDao.searchProduct(pid);
			}
		} catch (VallidationExceptionFMS e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}
}