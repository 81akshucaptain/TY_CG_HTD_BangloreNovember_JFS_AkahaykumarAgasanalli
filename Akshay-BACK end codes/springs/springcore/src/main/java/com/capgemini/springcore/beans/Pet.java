package com.capgemini.springcore.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.capgemini.springcore.beans.Animal;
@Component
public class Pet {
	
private String name;
@Autowired
//inorder to deal with byName, we go for 
@Qualifier("dog")
private Animal animal;

//CONSTTRUCTOR WITH NO ARGS
public Pet() {
	super();
}
//CONSTRUCTOR WITH ARGS
public Pet(String name, Animal animal) {
	super();
	this.name = name;
	this.animal = animal;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Animal getAnimal() {
	return animal;
}
public void setAnimal(Animal animal) {
	this.animal = animal;
}
}
