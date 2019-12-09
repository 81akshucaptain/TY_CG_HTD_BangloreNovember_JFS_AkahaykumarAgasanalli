package com.mycom.hashMAP.TreeMapPgm;

import java.util.Comparator;

public class BasedOnAge implements Comparator<StudentEx>{

	@Override
	public int compare(StudentEx o1, StudentEx o2) {
		if(o1.age>o2.age) {
			return 1;
		}if(o1.age<o2.age) {
			return -1;
		}else
			return 0;
	}

}