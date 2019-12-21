package com.capgemini.springcore.beans;

import java.io.FileNotFoundException;
import java.util.Stack;

public class SubClass extends SuperClass {
@Override
public Stack<Object> show() throws FileNotFoundException{
	//WE CAN OVERRIDE,INTERMS SUPER TO SUB BUT NOT SUB TO SUPER
	return null;
}
}
