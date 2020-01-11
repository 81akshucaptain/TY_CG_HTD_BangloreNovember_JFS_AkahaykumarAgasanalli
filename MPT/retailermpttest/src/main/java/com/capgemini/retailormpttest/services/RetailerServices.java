package com.capgemini.retailormpttest.services;

import java.util.List;

import com.capgemini.retailormpttest.dto.OrderInfoBean;
import com.capgemini.retailormpttest.dto.ProductInfoBean;
import com.capgemini.retailormpttest.dto.UserInfoBean;

public interface RetailerServices {
	public UserInfoBean login(String email, String password);

	public boolean registerUser(UserInfoBean userBean);

	public boolean addProductInfo(ProductInfoBean productInfo);

	public List<ProductInfoBean> searchProduct(int productId);

	public boolean updateUserPassword(int id, String password);

	public List<OrderInfoBean> getOrders(int userId);
}
