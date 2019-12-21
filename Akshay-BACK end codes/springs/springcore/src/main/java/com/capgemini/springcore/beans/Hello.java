package com.capgemini.springcore.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Hello{ //implements InitializingBean,DisposableBean {

	private String msg;
	private int count;
	
	public Hello() {
		System.out.println("Object is created");
	}
	
	public int getCount() {
		return count;
	}

	public Hello(String msg, int count) {
		super();
		this.msg = msg;
		this.count = count;
		System.out.println("Object creatd..!");
	}
	@PostConstruct
	public void init() {
		System.out.println("init method");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroy method");
	}
	public void setCount(int count) {
		this.count = count;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
//	@Override
//	public void afterPropertiesSet() throws Exception {
//System.out.println("In afterPropertiesSet ");		
//		
	}


