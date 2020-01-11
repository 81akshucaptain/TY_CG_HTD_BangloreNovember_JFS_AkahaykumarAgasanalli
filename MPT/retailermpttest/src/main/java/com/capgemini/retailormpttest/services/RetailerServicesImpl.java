package com.capgemini.retailormpttest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.retailormpttest.dto.OrderInfoBean;
import com.capgemini.retailormpttest.dto.ProductInfoBean;
import com.capgemini.retailormpttest.dto.UserInfoBean;
import com.capgemini.retailormpttest.exceptions.RetailerException;
import com.capgemini.retailormpttest.repository.OrderRepository;
import com.capgemini.retailormpttest.repository.ProductRepository;
import com.capgemini.retailormpttest.repository.UserRepository;

@Service
public class RetailerServicesImpl implements RetailerServices {

	@Autowired
	UserRepository userRepo;
	@Autowired
	ProductRepository proRepo;
	@Autowired
	OrderRepository ordRepo;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public UserInfoBean login(String email, String password) {
		UserInfoBean bean = userRepo.findByEmail(email);
		if (bean != null) {
			if (encoder.matches(password, bean.getPassword())) {
				return bean;
			}
			throw new RetailerException("password doesn't match");
		}
		throw new RetailerException("Email doesn't exist");
	}

	@Override
	public boolean registerUser(UserInfoBean userBean) {
		userBean.setPassword(encoder.encode(userBean.getPassword()));
		userRepo.save(userBean);
		return true;
	}

	@Override
	public boolean addProductInfo(ProductInfoBean productInfo) {
		for (UserInfoBean uBean : productInfo.getUserBean()) {
			uBean.setProductBean((List<ProductInfoBean>) productInfo);
		}
		for (OrderInfoBean orderInfoBean : productInfo.getOrderBean()) {
			orderInfoBean.setProductBean(productInfo);
		}
		proRepo.save(productInfo);
		return true;

	}

	@Override
	public List<ProductInfoBean> searchProduct(int productId) {
		return proRepo.findById(productId);
	}

	@Override
	public boolean updateUserPassword(int uid, String password) {
		return userRepo.changePassword(uid, password);
	}

	@Override
	public List<OrderInfoBean> getOrders(int userId) {
		return ordRepo.findById(userId);
	}

}
