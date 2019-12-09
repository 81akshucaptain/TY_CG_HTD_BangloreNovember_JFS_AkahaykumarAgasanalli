package com.capgemini.junit.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capgemini.junit.java.Calculator;

class TestCalculator {
	Calculator c=null;
	@BeforeEach
	void creatObject() {
		c=new Calculator();
	}
	@Test
	void testForAdd() {
		//Calculator c=new Calculator();
		int res=c.add(10,5);
		assertEquals(15,res);
	}
	@Test
	void testAddForNegative() {
		//Calculator c=new Calculator();
		int res=c.add(-3,5);
		assertEquals(2,res);
	}
	@Test
	void testForMul() {
		//Calculator c=new Calculator();
		int res=c.mul(-3,5);
		assertEquals(-15,res);
	}
	@Test
	void testForArithmaticException() {
		//Calculator c=new Calculator();
		assertThrows(ArithmeticException.class,
				()->{
					c.div(10,0);
				}
				);	
	}
	@Test
	void testFindLength() {
		//Calculator c=new Calculator();
		int l=c.findLength("priya");
		assertEquals(5, l);
	}
	@Test
	void testFindLenghtNull() {
		//Calculator c=new Calculator();
		assertThrows(NullPointerException.class,

				()->c.findLength(null)
				);
	}



}
