package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcore.beans.Animal;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;

public class App 
{
	@SuppressWarnings("resource")
	public static void main( String[] args )
	{
		ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");
		Hello hello1=context.getBean(Hello.class);
		Hello hello2=context.getBean(Hello.class);
		System.out.println("============Singlotone Classs(default)(due to container)===============");
		System.out.println("hello1: "+hello1);
		System.out.println("hello2: "+hello2);
		System.out.println(hello1==hello2);
		//IF WE MADE SCOPE OF CLASS scope="prototype"; THEN DIFFERENT OBJECTS WILL BE CREATED
		System.out.println("==================================");


		hello1.setCount(20000);

		System.out.println(hello1.getMsg());
		System.out.println(hello1.getCount());
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		//GETbean IS FACTORY METHOD
		Animal animal= context.getBean(Animal.class);
		animal.makeSound();
		System.out.println("===============================");
		Pet pet=context.getBean(Pet.class);
		System.out.println(pet.getName());
		//this can be done using WIRING by using "ref" keyword in 
		//bean.xml whic is paasing dog object to animal reference
		pet.getAnimal().makeSound();
		

	}
}
