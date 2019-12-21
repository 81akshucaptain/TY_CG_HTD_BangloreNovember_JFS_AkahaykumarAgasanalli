package com.capgemini.springcore.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.capgemini.springcore.beans.Pet;
import com.capgemini.springcore.beans.Author;
import com.capgemini.springcore.beans.Book;
import com.capgemini.springcore.beans.Cat;
import com.capgemini.springcore.beans.Dog;
import com.capgemini.springcore.beans.Hello;

@Configuration
public class BeansConfig {
	//TO CONFIGURE THIS PALIN METHOD TO BEAN MEATHOD
	//USE ANNOTATION
	//THIS @Bean annotation is exactly same as a bean
	//tag and respective description in beans.xml
	@Bean("hello")
	//DEFAULT scope is singleTone
	@Scope("prototype")
	public Hello getHello() {
		Hello hello=new Hello();
		hello.setMsg("I love dumma");
		hello.setCount(100);
		return hello;
	}
	
	@Bean("author")
	@Scope("prototype")
	public Author getAurhor() {
		Author author=new Author();
		author.setName("akshu");
		return author;
	}

	//if we fail to give the id/name then automatic
	// method name will be taken as default ID
	@Bean("book")
	public Book getBook() {
		Book book=new Book();
		book.setName("mowna");
		book.setAuthor(getAurhor());
		return book;
	}
	@Bean("dog")
	//@Bean(name="dog")
	public Dog getDog() {
		return new Dog();
	}
	
	@Bean("cat")
	@Primary
	public Cat getCat() {
		return new Cat();
	}
	
	@Bean("pet")
	public com.capgemini.springcore.beans.Pet getPet() {
		com.capgemini.springcore.beans.Pet pet=new com.capgemini.springcore.beans.Pet();
		pet.setName("jacky");
		//pet.setAnimal(getDog());
		return pet;
		}
}
