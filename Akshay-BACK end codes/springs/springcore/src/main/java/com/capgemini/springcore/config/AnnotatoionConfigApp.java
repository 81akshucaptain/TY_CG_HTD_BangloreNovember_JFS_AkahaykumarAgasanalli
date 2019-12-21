package com.capgemini.springcore.config;
import com.capgemini.springcore.beans.*;

import java.applet.AppletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.beans.Animal;
import com.capgemini.springcore.beans.Author;
import com.capgemini.springcore.beans.Book;
import com.capgemini.springcore.beans.Hello;

public class AnnotatoionConfigApp {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context=
				new AnnotationConfigApplicationContext(BeansConfig.class);

		Hello hello=context.getBean(Hello.class);
		System.out.println(hello.getMsg());
		System.out.println(hello.getCount());

		System.out.println("++++++++++++++++++++++++++++++++++");

		Hello hello2=context.getBean(Hello.class);
		System.out.println(hello);
		System.out.println(hello2);
		System.out.println(hello==hello2);

		System.out.println("=================================");

		Animal animal=context.getBean(Animal.class);
		animal.makeSound();

		System.out.println("**********************************");
		Pet pet=context.getBean(Pet.class);
		System.out.println(pet.getName());
		pet.getAnimal().makeSound();
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		Author author=context.getBean(Author.class);
		author.displyaAuthor();
		
		System.out.println("======================================");
		
		Book book=context.getBean(Book.class);
		System.out.println(book.getName());
		System.out.println(book.getAuthor().getName());
		context.close();

		
			
		
	}
}
