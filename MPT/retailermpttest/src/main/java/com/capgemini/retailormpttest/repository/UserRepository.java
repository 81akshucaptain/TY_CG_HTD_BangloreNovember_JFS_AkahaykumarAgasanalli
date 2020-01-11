package com.capgemini.retailormpttest.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.retailormpttest.dto.UserInfoBean;

public interface UserRepository extends JpaRepository<UserInfoBean, Integer>{
	
	public UserInfoBean findByEmail(String email);

	@Transactional
	@Modifying
	@Query("update UserInfoBean set password=:pwd where uid=:id")
	public boolean changePassword(@Param("id")int uid,
			@Param("pwd")String password);

}
