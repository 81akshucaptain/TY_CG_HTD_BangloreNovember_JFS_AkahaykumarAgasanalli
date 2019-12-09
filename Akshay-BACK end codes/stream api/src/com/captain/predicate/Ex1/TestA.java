package com.captain.predicate.Ex1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestA {
	public static void main(String[] args) {

		System.out.println("=======predicate=======");

		Predicate<Integer> p=i->i%2==0;
		boolean b1=p.test(12);
		System.out.println(b1);
		System.out.println(p.test(45));


		System.out.println("=======Function=======");
		Function<Integer,Integer> f1=i->i*100;
		int a=f1.apply(86);
		System.out.println(a);
		
		System.out.println("========Supplier========");
		Supplier<PersonFunction> s1=()->new PersonFunction(22,"akshay");
		System.out.println("age is: "+s1.get().getAge());
		System.out.println("name is"+s1.get().getName());
		
		System.out.println("========Consumer=========");
		Consumer<PersonFunction> c1=j->{
			System.out.println("the age is: "+j.getAge());
			System.out.println("the name is: "+j.getName());
		};
		PersonFunction p1=new PersonFunction(22,"mowna");
		c1.accept(p1);	
	}
}
