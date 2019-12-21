package com.capgemini.springcore.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Author {
	
private String name;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Author(String name) {
	super();
	this.name = name;
}
public Author() {
	super();
}
public void displyaAuthor() {
	System.out.println("im authorr..!");
}
@PostConstruct
public void init() {
	System.out.println("init method");
}

@PreDestroy
public void destroy() {
	System.out.println("destroy method");
}
}
