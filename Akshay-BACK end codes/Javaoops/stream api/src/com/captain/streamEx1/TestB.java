package com.captain.streamEx1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestB {
public static void main(String[] args) {
	ArrayList<Integer> a1=new ArrayList<Integer>();
	a1.add(56);
	a1.add(95);
	a1.add(23);
	a1.add(12);
	a1.add(66);
	a1.add(9);
	a1.add(98);
	//stream()-contains all the data
	//filter filters data based on lambda exprsn. it will take PRDEICATE
	//collect will collect the output as per the datastructure ex,list:
	List<Integer> o1=a1.stream().filter(i->i%2==0).collect(Collectors.toList());
	System.out.println("even no...."+o1);
	
	//to apply for every element we gone use map,it will take 

	List<Integer> o2=a1.stream().map(i->i*100).collect(Collectors.toList());
	System.out.println("even no...."+o2);
     
	//TO FIND THE MAXIMUM ELEMENT INTHE ARRAYLIST
	Optional<Integer> o3=a1.stream().max((i,j)->i.compareTo(j));
	System.out.println(o3);
	
	//to find the count of element 
	System.out.println("the  count of elements is:  "+a1.stream().count());
	
	
	
	
}
}
